package com.example.javabasismain.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class C200iii06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] colors = sc.nextLine().split(" ");
        System.out.println(getResult(nums, colors));
    }

    static class Card {
        int num;
        char color;

        public Card(int num, String color) {
            this.num = num;
            this.color = color.charAt(0);
        }
    }


    public static int getResult(int[] nums, String[] colors) {
        int n = nums.length;
        Card[] cards = new Card[n];
        for (int i = 0; i < n; i++) {
            cards[i] = new Card(nums[i], colors[i]);
        }
        //这里需要特别注意形参和实参的问题
        int[] ans = {0};
        boolean[] used = new boolean[n];
        Arrays.fill(used, false);
        dfs(cards, used, null, 0, ans);
        return ans[0];
    }

    public static void dfs(Card[] cards, boolean[] used, Card last, int count, int[] ans) {
        ans[0] = Math.max(ans[0], count);

        for (int i = 0; i < cards.length; i++) {
            if (used[i]) continue;

            Card cur = cards[i];
            if (last != null && last.num != cur.num && last.color != cur.color) continue;

            used[i] = true;
            dfs(cards, used, cur, count + 1, ans);
            used[i] = false;
        }
    }

}
