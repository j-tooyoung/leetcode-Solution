import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname FooLockCondition
 * @Description
 * @Date 2020/12/16 21:21
 * @Created by j-tooyoung
 */
public class FooLockCondition {

    int num;
    Lock lock;
    Condition condition1, condition2, condition3;

    public FooLockCondition() {
        num = 1;
        this.lock = new ReentrantLock();
        this.condition1 = lock.newCondition();
        this.condition2 = lock.newCondition();
        this.condition3 = lock.newCondition();
    }

    public void first(Runnable printFirst) {
        lock.lock();
        try {
            while (num != 1) {
                condition1.await();
            }
            num = 2;
            printFirst.run();
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void second(Runnable printSecond) {
        lock.lock();
        try {
            while (num != 2) {
                condition2.await();
            }
            num = 3;
            printSecond.run();
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void three(Runnable printThree) {
        lock.lock();
        try {
            while (num != 3) {
                condition3.await();
            }
            num = 1;
            printThree.run();
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
