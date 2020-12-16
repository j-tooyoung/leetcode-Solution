import java.util.concurrent.Semaphore;

/**
 * @Classname FooSemaphore
 * @Description
 * @Date 2020/12/16 21:28
 * @Created by j-tooyoung
 */
public class FooSemaphore {

    Semaphore semaphore1;
    Semaphore semaphore2;

    public FooSemaphore() {
        semaphore1 = new Semaphore(0);
        semaphore2 = new Semaphore(0);
    }

    public void first(Runnable printFirst) {
        printFirst.run();
        semaphore1.release();
    }


    public void second(Runnable printSecond) throws InterruptedException {
        semaphore1.acquire();
        printSecond.run();
        semaphore2.release();
    }


    public void third(Runnable printThird) throws InterruptedException {
        semaphore2.acquire();
        printThird.run();
        semaphore1.release();
    }
}
