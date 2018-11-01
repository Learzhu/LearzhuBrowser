package com.learzhu.browser.test.optimal_solution_of_algorithm.unit1;

import java.util.Stack;

/**
 * ReverseStack.java是液总汇的类。
 *
 * @author Learzhu
 * @version 2.0.0 2018-11-01 16:06
 * @update Learzhu 2018-11-01 16:06
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class ReverseStack {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
//        int result = getAndRemoveLastElement(stack);
//        System.out.println("result = " + result);
        reverse(stack);
        System.out.println(stack.size());
    }

    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            System.out.println("result= " + result + " last = " + last + " stack size()=" + stack.size());
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }
}
