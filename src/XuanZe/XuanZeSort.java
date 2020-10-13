package XuanZe;

//选择排序算法
public class XuanZeSort {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 5, 8, 6, 2, 3, 9, 7, 4};
        //需进行length次冒泡
        for (int i = 0; i < numbers.length; i++) {
            int minIndex = i;
            // 找出最小的数的下标，并用minIndex记住
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[minIndex] > numbers[j]) {
                    minIndex = j;
                }
            }
            // 将最小的数字 与 当前的第一个数字进行交换（存放到排序序列的起始位置）
            if (i != minIndex) {
                int temp = numbers[minIndex];
                numbers[minIndex] = numbers[i];
                numbers[i] = temp;
            }
        }

        System.out.println("从小到大排序后的结果是:");
        for (int i = 0; i < numbers.length; i++)
            System.out.print(numbers[i] + " ");
    }
}
