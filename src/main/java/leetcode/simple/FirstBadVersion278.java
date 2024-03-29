package leetcode.simple;

/**
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
 * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * <p>
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * <p>
 * 你可以通过调用?bool isBadVersion(version)?接口来判断版本号 version 是否在单元测试中出错。
 * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * <p>
 */
public class FirstBadVersion278 {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
        System.out.println(firstBadVersion(1));
    }


    public static int firstBadVersion(int n) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (isBadVersion(middle)) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    private static boolean isBadVersion(int version) {
        return false;
    }
}
