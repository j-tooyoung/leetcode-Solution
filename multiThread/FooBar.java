import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1115. 交替打印FooBar
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 */
public class FooBar {
    AtomicInteger cnt = new AtomicInteger(0);
    private ReentrantLock lock = new ReentrantLock();
    private Condition foo = lock.newCondition();
    private Condition bar = lock.newCondition();

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (cnt.get() != 0) {
                    foo.await();
                }
                cnt.set(1);
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                bar.signal();
            } finally {
                lock.unlock();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (cnt.get() != 1) {
                    bar.await();
                }
                cnt.set(0);
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printBar.run();
                foo.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
