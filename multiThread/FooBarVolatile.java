import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class FooBarVolatile {

    private volatile int state = 0;
    private int n;

    public FooBarVolatile(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (state != 0) {
                Thread.yield();
            }
                // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            state = 1;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (state != 1) {
                Thread.yield();
            }
                // printFoo.run() outputs "foo". Do not change or remove this line.
            printBar.run();
            state = 0;
        }
    }
}

class FooBarSemaphore {
    private int n;

    public FooBarSemaphore(int n) {
        this.n = n;
    }


    private Semaphore foo = new Semaphore(1);
    private Semaphore bar = new Semaphore(0);

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.acquire();  // 获取成功释放许可数
            printFoo.run();
            bar.release();  // release增加许可数
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire();
            printBar.run();
            foo.release();
        }
    }
}


class FooBarCyclicBarrier {

    private int n;

    public FooBarCyclicBarrier(int n) {
        this.n = n;
    }


    private CyclicBarrier cyclicBarrier = new CyclicBarrier(2); //
    private volatile boolean flag = true;

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!flag) { }
            printFoo.run();
            flag = false;
            try {
//                cyclicBarrier.wait();
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            printBar.run();
            flag = true;

        }
    }
}

class FooBarSynchronized {
    private int n;
    // 标志位，控制执行顺序，true执行printFoo，false执行printBar
    private volatile boolean type;
    // 锁标志
    private final Object object;

    public FooBarSynchronized(int n) {
        this.n = n;
        object = new Object();
        type = true;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            synchronized (object) {
                // 初始化type为true,所以肯定会先执行printFoo
                while (!type) {
                    object.wait();
                }
                printFoo.run();
                // 设置false
                type = false;
                // 唤醒printBar执行
                object.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            synchronized (object) {
                // 初始化为true，这里会阻塞
                while (type) {
                    object.wait();
                }
                printBar.run();
                type = true;
                object.notifyAll();
            }
        }
    }
}
