package com.learzhu.browser.test.optimal_solution_of_algorithm.unit1;

import java.util.Stack;

/**
 * StackSort.java是液总汇的类。
 *
 * @author Learzhu
 * @version 2.0.0 2018-11-05 16:27
 * @update Learzhu 2018-11-05 16:27
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class StackSort {
    private static Stack<Integer> rawStack, helpStack;

    public static void main(String args[]) {
        rawStack = new Stack<>();
        rawStack.push(5);
        rawStack.push(1);
        rawStack.push(3);
        rawStack.push(4);
        rawStack.push(2);
        sortStackByStack(rawStack);
        printAll(rawStack);
    }

    /**
     * 从栈顶到栈底由大到小排序
     *
     * @param stack
     */
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            //查看帮助栈的栈顶元素 如果小于当前弹出的数据就直接 因为栈的顺序是先进后出 所以要倒过来
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public static void printAll(Stack stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
