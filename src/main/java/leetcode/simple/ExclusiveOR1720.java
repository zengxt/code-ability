package leetcode.simple;

import java.util.Arrays;

/**
 * 未知 整数数组 arr 由 n 个非负整数组成。
 * <p>
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。
 * 例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 * <p>
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 * <p>
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 */
public class ExclusiveOR1720 {
    public static void main(String[] args) {
        Arrays.stream(decode(new int[]{1, 2, 3}, 1)).forEach(System.out::print);
        System.out.println();
        Arrays.stream(decode(new int[]{6, 2, 7, 3}, 4)).forEach(System.out::print);
    }

    public static int[] decode(int[] encoded, int first) {
        if (encoded == null) {
            return null;
        }

        int[] result = new int[encoded.length + 1];
        result[0] = first;
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] ^ encoded[i - 1];
        }

        return result;
    }
}
