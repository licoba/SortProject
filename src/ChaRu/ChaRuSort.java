package ChaRu;

//插入排序算法
public class ChaRuSort {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 5, 8, 6, 2, 3, 9, 7, 4};
        //需进行length-1次冒泡
        for (int i = 1; i < numbers.length; i++) {
            for (int j = i; j > 0; j--) {
                if (numbers[j] < numbers[j - 1]) {
                    int temp = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        System.out.println("从小到大排序后的结果是:");
        for (int i = 0; i < numbers.length; i++)
            System.out.print(numbers[i] + " ");
    }
}
