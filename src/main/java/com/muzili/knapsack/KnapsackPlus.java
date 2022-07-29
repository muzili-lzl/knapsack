package java.com.muzili.knap;

/**
 * 动态规划之背包问题优化方案——缓存
 * @author lizuoliang
 * @create 2022/7/29 10:35
 */
public class KnapsackPlus {

    public static void main(String[] args) {
        int len = 30;
        int value = 50;
        int[] weight = randomArray(len, value);
        int[] values = randomArray(len, value);
        int capacity = 2000;
        System.out.println(maxValue(weight, values, capacity));
    }

    private static int[] randomArray(int len, int value) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = ((int) Math.random() * value) + 1;
        }
        return arr;
    }

    public static int maxValue(int[] weight, int[] value, int capacity){
        int n = weight.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                // 付初始值
                dp[i][j] = -2;
            }
        }
        return function(weight, value, 0, capacity, dp);
    }

    private static int function(int[] weight, int[] value, int index, int capacity, int[][] dp) {
        if (capacity < 0){
            return -1;
        }
        // 缓存中已查询过
        if (dp[index][capacity] != -2){
            return dp[index][capacity];
        }
        int ans = 0;
        if (index == weight.length){
            ans = 0;
        } else {
            int p1 = function(weight, value, index + 1, capacity, dp);
            int p2 = -1;
            int next = function(weight, value, index + 1, capacity - value[index], dp);
            if (next != -1) {
                p2 = next + value[index];
            }
            ans = Math.max(p1, p2);
        }
        dp[index][capacity] = ans;
        return ans;
    }

}
