import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: MyStack
 * Package: PACKAGE_NAME
 * Description:
 *
 * @date: 2020/4/13 10:22
 * @author: tooyoung
 */
class MyStack {

    private Queue<Integer> q1 ;
    private Queue<Integer> q2 ;
    private int top;

    /** Initialize your data structure here. */
    public MyStack() {
        q1  = new LinkedList<>();
        q2 = new LinkedList<>();    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        top = x;    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while (q1.size() > 1) {
            top = q1.poll();
            q2.add(top);
        }
        int res = q1.poll();
        // 互换
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
        return res;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();

    }
}
//
//    ArrayDeque<Integer> q1 ;
//
//
//    /** Initialize your data structure here. */
//    public MyStack() {
//        q1  = new ArrayDeque<>();
//    }
//
//    /** Push element x onto stack. */
//    public void push(int x) {
//        q1.add(x);
//    }
//
//    /**
//     * Removes the element on top of the stack and returns that element.
//     */
//    public int pop() {
//        return q1.removeLast();
//    }
//
//    /** Get the top element. */
//    public int top() {
//        return q1.peekLast();
//    }
//
//    /** Returns whether the stack is empty. */
//    public boolean empty() {
//        return q1.isEmpty();
//
//    }


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
