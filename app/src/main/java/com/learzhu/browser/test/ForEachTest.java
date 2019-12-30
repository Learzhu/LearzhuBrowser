package com.learzhu.browser.test;

import java.util.ArrayList;

/**
 * ForEachTest.java是液多多的类。
 *
 * @author Learzhu
 * @version 2019-12-26 15:54
 * @update Learzhu 2019-12-26 15:54
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class ForEachTest {
    public static boolean isCentralWarehouse(String shopId) {
        ArrayList<String> shopIds = new ArrayList<>();
        shopIds.add("170814181045341074");//佛山中心仓
        shopIds.add("180529096277933977");//台州中心仓
        for (String shopId1 : shopIds) {
            if (shopId1.equals(shopId)) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        System.out.println(isCentralWarehouse("170814181045341074"));
        System.out.println(isCentralWarehouse("1"));
    }
}
