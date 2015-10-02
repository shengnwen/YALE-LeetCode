import java.util.LinkedList;
import java.util.Queue;


public class MyStackUsingQueue {
	Queue<Integer> q = new LinkedList<Integer>();
    public void push(int x) {
        q.offer(x);
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            q.offer(q.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.size() == 0;
    }
}
