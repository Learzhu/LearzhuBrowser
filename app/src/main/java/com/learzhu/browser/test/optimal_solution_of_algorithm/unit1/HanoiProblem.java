package com.learzhu.browser.test.optimal_solution_of_algorithm.unit1;

import java.util.Stack;

/**
 * HanoiProblem.java是练习项目的汉诺塔问题类。
 *
 * @author Learzhu
 * @version 2.0.0 2018-11-06 15:25
 * @update Learzhu 2018-11-06 15:25
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class HanoiProblem {

    public static void main(String args[]) {
        HanoiProblem hanoiProblem = new HanoiProblem();
//        hanoiProblem.recursion(3, "left", "mid", "right");
        hanoiProblem.stackHanoi(3, "left", "mid", "right");
    }

    /**
     * 通过递归的方式
     *
     * @param num   总共需要移动的数量
     * @param left  左侧
     * @param mind  中间
     * @param right 右侧
     * @return 最佳移动次数总量
     */
    public int recursion(int num, String left, String mind, String right) {
        if (num < 1) {
            return 0;
        }
        return process(num, left, mind, right, left, right);
    }

    /**
     * 递归的方式
     *
     * @param num   需要移动的数量
     * @param left  左侧
     * @param mid   中
     * @param right 右
     * @param from  起点
     * @param to    终点
     * @return 移动的次数
     */
    private int process(int num, String left, String mid, String right, String from, String to) {
        if (num == 1) {
            //只有一块需要移动
            // 从中间出发或者从两侧到中间
            if (from.equals(mid) || to.equals(mid)) {
                System.out.println("Move 1 from " + from + " to " + mid);
                return 1;
            } else {
                //从左到右侧或者从右到左
                System.out.println("Move 1 from " + from + " to " + mid);
                System.out.println("Move 1 from " + mid + " to " + to);
                return 2;
            }
        }

        // 从中间出发或者从两侧到中间
        if (from.equals(mid) || to.equals(mid)) {
            //从左侧出发或者要到左 就设置先移动N-1到右侧
            String another = (from.equals(left) || to.equals(left)) ? right : left;
            int part1 = process(num - 1, left, mid, right, from, another);
            int part2 = 1;
            //然后移动N-1到另一边
            System.out.println("Move " + num + " from " + from + " to " + to);
            int part3 = process(num - 1, left, mid, right, another, to);
            return part1 + part2 + part3;
        } else {
            //从左到右侧或者从右到左
            int part1 = process(num - 1, left, mid, right, from, to);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + mid);
            int part3 = process(num - 1, left, mid, right, to, from);
            int part4 = 1;
            System.out.println("Move " + num + " from " + mid + " to " + to);
            int part5 = process(num - 1, left, mid, right, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }

    /**
     * 使用三个栈搞定
     */
    public enum Action {
        No, LToM, MToL, RToM, MToR;
    }

    /**
     * 通过栈实现汉诺塔
     *
     * @param num
     * @param left
     * @param mid
     * @param right
     * @return
     */
    public int stackHanoi(int num, String left, String mid, String right) {
        Stack<Integer> lS = new Stack<>();
        Stack<Integer> mS = new Stack<>();
        Stack<Integer> rS = new Stack<>();
        lS.push(Integer.MAX_VALUE);
        mS.push(Integer.MAX_VALUE);
        rS.push(Integer.MAX_VALUE);
        for (int i = num; i > 0; i--) {
            lS.push(i);
        }
        Action[] record = {Action.No};
        int step = 0;
        while (rS.size() != num + 1) {
            step += fStackTotStack(record, Action.MToL, Action.LToM, lS, mS, left, mid);
            step += fStackTotStack(record, Action.LToM, Action.MToL, mS, lS, mid, left);
            step += fStackTotStack(record, Action.RToM, Action.MToR, mS, rS, mid, left);
            step += fStackTotStack(record, Action.MToR, Action.RToM, rS, mS, right, mid);
        }
        return step;
    }

    private int fStackTotStack(Action[] record, Action preNoAct, Action nowAct, Stack<Integer> fStack,
                               Stack<Integer> tStack, String from, String to) {
        if (record[0] != preNoAct && fStack.peek() < tStack.peek()) {
            tStack.push(fStack.pop());
            System.out.println("Move " + tStack.peek() + " from " + from + " to " + to);
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }
}
