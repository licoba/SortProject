package GuiBing;

import java.util.Arrays;

public class GuiBingSort {

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 5, 8, 6, 2, 3, 9, 7, 4 };
        new GuiBingSort().guibing_sort(nums, 0, nums.length - 1);
        System.out.println("从小到大排序后的结果是:");
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }

    public void guibing_sort(int[] nums, int left, int right) {
        if (left == right)
            return;
        int mid = left + (right - left) / 2;
        guibing_sort(nums, left, mid);
        guibing_sort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    // 将 nums[left..mid] 和 nums[mid+1..right] 这两个有序数组合并成一个有序数组
    public void merge(int[] nums, int left, int mid, int right) {
        int[] temp = Arrays.copyOf(nums, nums.length);// 辅助数组
        // 和链表一样，数组也进行双指针，i和j分别指向两个nums的头结点
        int i = left;
        int j = mid + 1;
        for (int p = left; p <= right; p++) {
            if (i == mid + 1) { // 左边已经合并完毕了
                nums[p] = temp[j++];
            } else if (j == right + 1) {
                nums[p] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[p] = temp[j++];
            } else {
                nums[p] = temp[i++];
            }
        }
    }

}
