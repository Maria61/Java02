package solution;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/9 23:38
 */
public class SolutionDaily1109 {
    /**
     * 通过栈实现队列
     */
    class MyQueue {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (!stack2.empty()) {
                return stack2.pop();
            }
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    public static int change(int[] array, int n) {
        Arrays.sort(array);
        int re = 0;
        re = changeIntenal(array, 0, array.length - 1, n);
        return re;
    }

    private static int changeIntenal(int[] array, int min, int max, int n) {
        if (max < min) {
            return 0;
        }
        int re = 0;
        int n1 = n - array[max];
        while (n1 < 0) {
            max = max - 1;
            n1 = n - array[max];
        }
        if (n1 == 0) {
            return 1;
        }
        for (int i = 0; i < max; i++) {
            if (array[i] == n1) {
                re++;
            }
        }
        re += changeIntenal(array, min, max - 1, n);
        return re;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 0;
        int[] array = new int[n];
        while (i < n) {
            array[i] = sc.nextInt();
            i++;
        }
        System.out.println(change(array, 40));
    }
}
