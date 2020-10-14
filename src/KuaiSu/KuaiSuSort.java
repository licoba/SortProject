package KuaiSu;


//快速排序算法
public class KuaiSuSort {

    //快速排序
    public static void quick_sort(int arr[], int left, int right) {
        if (left < right) {
            // temp 为基准数
            int i = left, j = right, temp = arr[left];
            while (i < j) {
                while (i < j && arr[j] >= temp) // 从右向左找第一个小于temp的数
                    j--;
                if (i < j) {
                    arr[i++] = arr[j];//调换位置  这个操作等于两步（1、arr[i] = arr[j]  2、i++）
                    for (int x = 0; x < arr.length; x++)
                        System.out.print(arr[x] + " ");
                    System.out.println();
                }

                while (i < j && arr[i] < temp) // 从左向右找第一个大于等于temp的数
                    i++;
                if (i < j) {
                    arr[j--] = arr[i];//调换位置
                    for (int x = 0; x < arr.length; x++)
                        System.out.print(arr[x] + " ");
                    System.out.println();
                }
            }
            System.out.println("跳出while循环时: i=" + i + " j=" + i);//跳出while循环时，i和j 相等
            arr[i] = temp;
            for (int x = 0; x < arr.length; x++)
                System.out.print(arr[x] + " ");
            System.out.println();
            quick_sort(arr, left, i - 1); // 递归调用
            quick_sort(arr, i + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{5, 8, 1, 6, 2, 3, 9, 7, 4};
        System.out.println("原始数组是:");
        for (int i = 0; i < numbers.length; i++)
            System.out.print(numbers[i] + " ");
        System.out.println("\n-----进行快排-----");
        quick_sort(numbers, 0, numbers.length - 1);
        System.out.println("从小到大排序后的结果是:");
        for (int i = 0; i < numbers.length; i++)
            System.out.print(numbers[i] + " ");
    }
}
