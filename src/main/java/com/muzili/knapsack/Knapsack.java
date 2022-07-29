package java.com.muzili.knap;

/**
 * 动态规划之背包问题
 * @author lizuoliang
 * @create 2022/7/29 10:13
 */
public class Knapsack {

    public static void main(String[] args) {

    }

    public static int maxValue(int[] weight, int[] value, int capacity){
        return function(weight, value, capacity, 0);
    }

    private static int function(int[] weight, int[] value, int capacity, int index) {
        // 背包无容量
        if (capacity < 0){
            return -1;
        }
        // 无货物
        if (index == weight.length){
            return 0;
        }

        // 1.没要当前位置的货
        int p1 = function(weight, value, capacity, index + 1);
        // 2.要了当前位置的货
        int p2 = -1;
        int next = function(weight, value, capacity - weight[index], index + 1);
        if (next != -1){
            // 有价值
            p2 = value[index] + next;
        }
        return Math.max(p1, p2);
    }

}
