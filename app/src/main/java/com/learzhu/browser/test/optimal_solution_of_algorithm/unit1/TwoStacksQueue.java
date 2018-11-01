package com.learzhu.browser.test.optimal_solution_of_algorithm.unit1;

import java.util.Stack;

/**
 * TwoStacksQueue.java是液总汇的类。
 *
 * @author Learzhu
 * @version 2.0.0 2018-10-31 17:08
 * @update Learzhu 2018-10-31 17:08
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class TwoStacksQueue {
    public Stack<Integer> mStackPush;
    public Stack<Integer> mStackPop;

    public TwoStacksQueue() {
        mStackPush = new Stack<>();
        mStackPop = new Stack<Integer>();
    }

    public TwoStacksQueue(Stack<Integer> stackPush, Stack<Integer> stackPop) {
        mStackPush = stackPush;
        mStackPop = stackPop;
    }

    public void add(int pushInt) {
        mStackPush.push(pushInt);
    }

    /**
     * 将第一个堆栈的数据都弹出到第二个栈
     *
     * @return
     */
    public int poll() {
        if (mStackPop.empty() && mStackPush.empty()) {
            throw new RuntimeException("Queue is empty!");
        } else if (mStackPop.empty()) {
            //只有第二个栈是空的时候才允许倒入第一个栈的数据
            while (!mStackPush.empty()) {
                //当第1个堆栈不为空就一直将第一个堆栈的数据弹出到第二个栈
                mStackPop.push(mStackPush.pop());
            }
        }
        return mStackPop.pop();
    }

    /**
     * 查看堆栈顶部的对象，但不从堆栈中移除它。
     *
     * @return
     */
    public int peek() {
        if (mStackPop.empty() && mStackPush.empty()) {
            throw new RuntimeException("Queue is empty!");
        } else if (mStackPop.empty()) {
            //只有第二个栈是空的时候才允许倒入第一个栈的数据
            while (!mStackPush.empty()) {
                //当第1个堆栈不为空就一直将第一个堆栈的数据弹出到第二个栈
                mStackPop.push(mStackPush.pop());
            }
        }
        return mStackPop.peek();
    }
}
