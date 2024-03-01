package algorithms.search;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InterpolationSearch {
    public static void main(String[] args) {
        /*
         * Thuật toán Tìm kiếm nội suy là một thuật toán tìm kiếm hoạt động trên các
         * mảng được sắp xếp phân phối đồng đều. Nó ước tính vị trí của mục tiêu bằng
         * cách nội suy giá trị dựa trên các điểm cuối của mảng và sau đó thu hẹp phạm
         * vi tìm kiếm cho phù hợp. Dưới đây là các bước để xây dựng thuật toán
         * Interpolation Search trong Java:
         *
         * 1. Bắt đầu bằng cách xác định một phương thức gọi là interpolationSearch có
         * ba tham số: mảng được sắp xếp sẽ được tìm kiếm, phần tử đích được tìm thấy và
         * các chỉ số của khoảng thời gian tìm kiếm (bắt đầu và kết thúc). Phương thức
         * sẽ trả về chỉ mục của phần tử đích nếu tìm thấy hoặc -1 nếu không tìm thấy.
         *
         * 2. Bên trong phương pháp interpolationSearch, tính toán vị trí của phần tử
         * đích trong khoảng thời gian tìm kiếm bằng công thức:
         *
         * position = start + ((target - array[start]) * (end - start)) / (array[end] -
         * array[start])
         *
         * Công thức này ước tính vị trí của phần tử mục tiêu dựa trên giá trị của nó so
         * với các giá trị ở chỉ số bắt đầu và kết thúc.
         *
         * 3. So sánh phần tử mục tiêu với phần tử tại vị trí ước tính. Nếu chúng bằng
         * nhau, hãy trả lại vị trí.
         *
         * 4. Nếu phần tử đích nhỏ hơn phần tử ở vị trí ước tính, hãy gọi đệ quy phương
         * thức interpolationSearch trên mảng con bên trái (từ đầu đến vị trí - 1).
         *
         * 5. Nếu phần tử đích lớn hơn phần tử tại vị trí ước tính, hãy gọi đệ quy
         * phương thức interpolationSearch trên mảng con bên phải (từ vị trí + 1 đến
         * cuối).
         *
         * 6. Nếu khoảng thời gian tìm kiếm trở nên trống (bắt đầu > kết thúc), phần tử
         * đích không được tìm thấy, vì vậy hãy trả về -1.
         */
        int[] array;
        Random random = new Random();

        System.out.print("Use random arrays (Otherwise enter data into the array, each value separated by a space) Y/N: ");
        try (Scanner answersInput = new Scanner(System.in)) {
            String answers = answersInput.nextLine();
            if (answers.equalsIgnoreCase("Y")) {
                int arrayLength = random.nextInt(50) + 50;
                array = new int[arrayLength];
                for (int i = 0; i < arrayLength; i++) {
                    array[i] = random.nextInt(10000);
                }
            } else {
                System.out.print("Enter in the array of natural numbers (each number is separated by 1 space): ");
                try (Scanner arrayInput = new Scanner(System.in)) {
                    String[] arrayProcessin = arrayInput.nextLine().replaceAll("\\s+", " ").split(" ");
                    array = new int[arrayProcessin.length];
                    for (int i = 0; i < arrayProcessin.length; i++) {
                        array[i] = Integer.parseInt(arrayProcessin[i]);
                    }
                }
            }
            bubbleSort(array);
            System.out.print("Array Sorted: ");
            Arrays.stream(array).forEach(x -> System.out.print(x + " "));
            System.out.println();
            System.out.print("Enter the value to find in the array: ");
            try (Scanner targetInput = new Scanner(System.in)) {
                int target = targetInput.nextInt();
                int index = interpolationSearch(array, target, 0, array.length - 1);

                if (index != -1)
                    System.out.println("Element found at index: " + index);
                else
                    System.out.println("Element not found");
            }

        }
    }

    private static void bubbleSort(int[] array) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    flag = true;
                }
            }
        }


    }

    private static int interpolationSearch(int[] array, int target, int left, int right) {
        if (left <= right && target >= array[left] && target <= array[right]) {
            int position = left + ((target - array[left]) * (right - left)) / (array[right] - array[left]);
            if (target == array[position])
                return position;
            if (target < array[position])
                return interpolationSearch(array, target, left, position - 1);
            return interpolationSearch(array, target, position + 1, right);
        }
        return -1;

    }
}
