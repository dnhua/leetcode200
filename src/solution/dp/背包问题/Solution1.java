package solution.dp.背包问题;

public class Solution1 {
//    public static int f(int value) {
//        try {
//            return value * value;
//        } finally {
//            if (value == 2) {
//                return 0;
//            }
//        }
//    }
    public int solution(int Weight, int[] weights, int[] values) {
        if (Weight <= 0)
            return 0;
        int m = weights.length, n = Weight;
        int[][] dp = new int[m+1][n+1];
        for (int i=1; i<=m; i++) {  //i代表当前物品的下标
            //得到当前这个物品的价格
            int weight = weights[i-1];
            for (int j=1; j<=n; j++) {  //j代表当前可以使用的钱数
                if (weight > j) {    //买不起
                    dp[i][j] = dp[i-1][j];
                } else {    //买得起，分两种情况：买与不买
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight] + values[i-1]);
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        int Weight = 1000;
        int[] weights = new int[]{200, 600, 100, 180, 300, 450};
        int[] value = new int[]{6, 10, 3, 4, 5, 8};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.solution(Weight, weights, value));
    }
}
