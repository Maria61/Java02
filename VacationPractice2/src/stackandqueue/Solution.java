package stackandqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @date 2019-08-21 10:53
 */
class MyStack{
    /**
     * 通过队列实现栈
     */
    private Queue<Integer> queue = new LinkedList<>();

    public void push(int x){
        queue.add(x);
    }

    public int pop(){
        int size = queue.size();
        for(int i = 0;i < size-1;i++){
            queue.add(queue.poll());
        }
        return queue.poll();

    }

    public int top(){
        int size = queue.size();
        for(int i = 0;i < size-1;i++){
            queue.add(queue.poll());
        }
        int v = queue.peek();
        queue.add(v);
        return v;
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

}

/**
 * 通过栈实现队列
 */
class MyQueue{
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int x){
        stack1.push(x);
    }

    public int pop(){
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek(){
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();

    }

    public boolean empty(){
        return stack1.empty() && stack2.empty();
    }
}

/**
 * 最小栈问题
 */
class MinStack{
    Stack<Integer> normal = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public MinStack(){

    }

    public void push(int x){
        normal.push(x);
        if(min.empty()){
            min.push(x);
        }else{
            int m = min.peek();
            if(m<=x){
                min.push(m);
            }else{
                min.push(x);
            }
        }

    }
    public void pop(){
        normal.pop();
        min.pop();

    }
    public int top(){
        return normal.peek();
    }
    public int getMin(){
        return min.peek();
    }
}

public class Solution {
    //LeetCode 20 括号匹配
    public boolean isValid(){
        return false;
    }
}
