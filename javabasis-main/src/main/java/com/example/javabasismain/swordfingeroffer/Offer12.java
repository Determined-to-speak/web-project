package com.example.javabasismain.swordfingeroffer;

import com.google.common.collect.Queues;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer12 {

    public static void main(String[] args) {
        char[][] board1 = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] board2 = new char[][]{{'a', 'b'}, {'c', 'd'}};
        char[][] board3 = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] board4 = new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        char[][] board5 = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};


//        System.out.println(exist(board1, "ABCCED"));
//        System.out.println(exist(board2, "abcd"));
        System.out.println(exist(board5, "ABCB"));
        System.out.println(exist(board3, "ABCCED"));
        System.out.println(exist(board4, "AAB"));

    }

    public static boolean exist(char[][] board, String word) {

        Queue<Character> words = new LinkedList<>();
        for (Character w : word.toCharArray()) {
            words.add(w);
        }

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {

                boolean[][] flag = new boolean[board.length][board[0].length];
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[0].length; j++) {
                        flag[i][j] = false;
                    }
                }


                if (dealEveryNumber(x, y, board, new LinkedList<>(words), flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 使用回溯法的时候一定要注意深拷贝问题！！！！
     *
     * @param x
     * @param y
     * @param board
     * @param word
     * @param flag
     * @return
     */
    private static boolean dealEveryNumber(int x, int y, char[][] board, Queue<Character> word, boolean[][] flag) {

        if (word.isEmpty()) {
            return true;
        }

        if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1) {
            return false;
        }
        if (flag[x][y]) {
            return false;
        }

        Queue<Character> newWord = new LinkedList<>(word);
        boolean[][] newFlag = new boolean[flag.length][flag[0].length];
        for (int i = 0; i < flag.length; i++) {
            System.arraycopy(flag[i], 0, newFlag[i], 0, flag[0].length);
        }

        if (board[x][y] == newWord.peek() && !newFlag[x][y]) {
            newWord.poll();
            newFlag[x][y] = true;

            return dealEveryNumber(x + 1, y, board, newWord, newFlag)
                    || dealEveryNumber(x - 1, y, board, newWord, newFlag)
                    || dealEveryNumber(x, y + 1, board, newWord, newFlag)
                    || dealEveryNumber(x, y - 1, board, newWord, newFlag);
        }

        return false;
    }


}
