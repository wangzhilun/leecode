package com.wzl.arithmetic;

public class DynamicPrograming {

    /**
     * 最小硬币问题
     *
     * @return
     */
    public static int money() {
        int[] penny = new int[]{1, 3, 5};
        int money = 11;
        int[] dp = new int[money + 1];
        dp[0] = 0;
        for (int i = 1; i <= 11; i++) {
            int minCoins = i;
            for (int j = 0; j < 3; j++) {
                if (i >= penny[j]) {
                    int temp = dp[i - penny[j]] + 1;
                    if (temp < i) {
                        minCoins = temp;
                    }
                }
            }
            dp[i] = minCoins;
        }
        return dp[money];
    }

    /**
     * 矩阵路径
     */
    public static int step() {
        // 1 3 1
        // 1 2 2
        int[][] map = new int[2][3];
        map[0][0] = 1;
        map[0][1] = 3;
        map[0][2] = 2;
        map[1][0] = 1;
        map[1][1] = 2;
        map[1][2] = 2;
        int n = 2;
        int m = 3;
        int[][] dp = new int[n][m];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum = sum + map[0][i];
            dp[0][i] = sum;
        }
        sum = 0;
        for (int j = 0; j < n; j++) {
            sum = sum + map[j][0];
            dp[j][0] = sum;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = map[i][j] + min(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[n - 1][m - 1];
    }


    public static int jump() {
        int length = 11;
        int[] dp = new int[12];
        int[] step = new int[]{1, 2};
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < length + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[11];
    }

    private static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    private static int min(int a, int b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }

    public static void main(String[] args) {
        System.out.println(step());
        System.out.println(money());
        System.out.println(jump());
    }
}
