package stackandqueue;

import java.util.Arrays;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @date 2019-08-21 9:47
 */
public class Stack {
    private int[] array = new int[10];
    private int top = 0;

    private void ensureCapacity(){
        if(top < array.length){
            return ;
        }

        array = Arrays.copyOf(array,2*array.length);
    }

    public int push(int element){
        ensureCapacity();
        array[top++] = element;
        return element;

    }
    public int pop(){
       return array[top--];
    }

    public int top(){
        return array[top];
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public int size(){
        return top;
    }

    public int search(int element){
        for(int i = 0;i < top;i++){
            if(array[i] == element){
                return 1;
            }
        }
        return -1;
    }
}
