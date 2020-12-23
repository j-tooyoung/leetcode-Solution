import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * 1116. 打印零与奇偶数
 * https://leetcode-cn.com/problems/print-zero-even-odd/
 *
 */
public class ZeroEvenOdd {
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private volatile int num = 0;
    private AtomicInteger index = new AtomicInteger(1);

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (num != 0) {
                    condition1.await();
                }
                num = 1;
                printNumber.accept(0);

                if (index.get() % 2 == 0) {
                    num = 2;
                    condition2.signal();
                } else {
                    num = 1;
                    condition3.signal();
                }
            } finally {
                lock.unlock();
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();

            try {
                while (num != 2) {
                    condition2.await();
                }
                num = 0;
                // System.out.println(index.get());

                printNumber.accept(index.get());
                index.getAndAdd(1);
                condition1.signal();
            } finally {
                lock.unlock();
            }
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (num != 1) {
                    condition3.await();
                }
                num = 0;
                printNumber.accept(index.get());
                index.getAndAdd(1);
                condition1.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    // 线程无法结束 fixme
    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(100000);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    zeroEvenOdd.zero(new PrintNumber());
                    zeroEvenOdd.zero(System.out::print);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    zeroEvenOdd.odd(new PrintNumber());
                    zeroEvenOdd.odd(System.out::print);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    zeroEvenOdd.even(new PrintNumber());
                    zeroEvenOdd.even(System.out::print);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
//        Thread[] threads = new Thread[3];
//        List<Thread> list = new ArrayList<>();
//        list.add(t1);
//        list.add(t2);
//        list.add(t3);
//        CountDownLatch countDownLatch = new CountDownLatch(3);
//        for (Thread thread : list) {
//            thread.start();
//            countDownLatch.countDown();
//        }
//        countDownLatch.await();
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(5000);

    }
}

class PrintNumber implements IntConsumer{

    @Override
    public void accept(int value) {
        System.out.println(value);
    }
}
