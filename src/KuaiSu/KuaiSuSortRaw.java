package KuaiSu;

import static Common.CommonUtil.print;


public class KuaiSuSortRaw {

    public static void sort(int[] a, int low, int high) {
        int l = low;
        int r = high;
        int key = a[low]; // 基准的key暂定为数组的第一位
        if (a.length == 1) return;
        while (r > l) {
            //从后往前比较  r>low 防止r一直减到比low都小了
            while (a[r] >= key && r > low)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                r--;//end先停下  轮到start上场了
            while (a[l] <= key && l < high)// l再怎么加也不能大于high
                l++;
            if (l >= r) break; // 如果下标加或者减到超过了
            //交换两位
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            print(a);
        }
        int flag = l = r; // flag 为重合时的下标
        // 跳出循环，交换key与中间的那个值
        int temp = a[flag];
        a[flag] = a[low];
        a[low] = temp;
        print(a);
        if (low < flag) sort(a, low, flag - 1);
        if (high > flag)
            sort(a, flag + 1, high);
    }

    public static void main(String[] args) {
//        int[] numbers = new int[]{5};
//        int[] numbers = new int[]{5, 8, 1, 6, 2, 3, 9, 7, 4};
        int[] numbers = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("原始数组是:");
        for (int i = 0; i < numbers.length; i++)
            System.out.print(numbers[i] + " ");
        System.out.println("\n-----进行快排-----");
        sort(numbers, 0, numbers.length - 1);
        System.out.println("从小到大排序后的结果是:");
        for (int i = 0; i < numbers.length; i++)
            System.out.print(numbers[i] + " ");
    }

}
