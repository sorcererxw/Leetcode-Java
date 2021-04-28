package solution._232_Implement_Queue_using_Stacks;

import java.util.Stack;

/**
 * Created by Sorcerer on 2016/1/5 0005.
 * <p>
 * https://leetcode.com/problems/implement-queue-using-stacks/
 */
class MyQueue {
    Stack<Integer> stack = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        Stack<Integer> tmp = new Stack<>();
        while (!stack.isEmpty()) {
            tmp.push(stack.pop());
        }
        tmp.pop();
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
    }

    // Get the front element.
    public int peek() {
        Stack<Integer> tmp = new Stack<>();
        while (!stack.isEmpty()) {
            tmp.push(stack.pop());
        }
        int result = tmp.peek();
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
        return result;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args){
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue.peek());

        queue.pop();

        System.out.println(queue.peek());

        System.out.println(queue.empty());

        queue.pop();
        queue.pop();

        System.out.println(queue.empty());
    }
}