package KuaiSu;

// ✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨
//快速排序算法，递归寻找下标之后进行swap操作
public class KuaiSuSort {
    public void quick_sort(int[] numbers, int left, int right) {
        if(left<right) {
            int base = left;//base取数组的第一个元素
            int i = left, j = right;
            while (i < j) {
                while (i < j && numbers[j] >= numbers[base]) j--;//内层循环的 i<j 不能省略
                while (i < j && numbers[i] <= numbers[base]) i++;//因为最后做的是i++，所以应该以i为判断基准
                System.out.println("下标搜索完成 i,j："+(i)+","+(j));
                swap(numbers, i, j);
            }
            swap(numbers, base, i);//交换base和i（或者j）
            System.out.println("-------------快排一遍完毕------------");
            quick_sort(numbers, left, i - 1);
            quick_sort(numbers, i + 1, right);
        }
    }

    public void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
        System.out.println("交换i,j：" +  Arrays.toString(numbers));
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{5, 8, 1, 6, 2, 3, 9, 7, 4};
        System.out.println("原始数组：" + Arrays.toString(numbers));
        new KuaiPai().quick_sort(numbers, 0, numbers.length - 1);
        System.out.println("快排之后：" + Arrays.toString(numbers));
    }
}
