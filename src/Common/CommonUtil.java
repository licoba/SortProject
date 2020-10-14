package Common;

public class CommonUtil {

    public static void print(int[] numbers) {
//        System.out.println("打印结果:");
        for (int i = 0; i < numbers.length; i++)
            System.out.print(numbers[i] + " ");
        System.out.println();
    }
}
