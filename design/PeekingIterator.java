import java.util.Iterator;

/**
 * ClassName: PeekingIterator
 * Package: PACKAGE_NAME
 * Description:
 * https://leetcode-cn.com/problems/peeking-iterator/
 * @date: 2020/4/13 10:16
 * @author: tooyoung
 */

class PeekingIterator implements Iterator<Integer> {
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return 0;

    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return 0;

    }

    @Override
    public boolean hasNext() {
        return false;

    }
}
