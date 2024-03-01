package algorithms.search;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LinearSearch {
    private static final int RANDOM_ARRAY_LENGTH_LIMIT = 50;
    private static final int RANDOM_ARRAY_VALUE_LIMIT = 10000;

    public static void main(String[] args) {
        /*
         * Thuật toán Tìm kiếm tuyến tính là một thuật toán tìm kiếm đơn giản kiểm tra
         * tuần tự từng phần tử trong danh sách cho đến khi tìm thấy kết quả phù hợp
         * hoặc đạt đến cuối danh sách. Dưới đây là các bước để xây dựng thuật toán
         * Linear Search trong Java:
         *
         * 1. Bắt đầu bằng cách định nghĩa một phương thức gọi là linearSearch có hai tham
         * số: mảng cần tìm kiếm và phần tử đích được tìm thấy. Phương thức sẽ trả về
         * chỉ mục của phần tử đích nếu tìm thấy hoặc -1 nếu không tìm thấy.
         *
         * 2. Bên trong phương thức linearSearch, lặp qua từng phần tử của mảng bằng cách
         * sử dụng vòng lặp for. Bắt đầu từ phần tử đầu tiên (index 0) và tiếp tục cho
         * đến phần tử cuối cùng.
         *
         * 3. Trong vòng lặp, so sánh từng phần tử với phần tử đích. Nếu tìm thấy kết quả
         * khớp, hãy trả về chỉ mục của phần tử.
         *
         * 4. Sau khi vòng lặp kết thúc mà không tìm thấy kết quả khớp, hãy trả về -1 để
         * chỉ ra rằng phần tử đích không được tìm thấy trong mảng.
         */

        int[] array;
        Random random = new Random();

        System.out.print("Use random arrays (Otherwise enter data into the array, each value separated by a space) Y/N: ");
        try (Scanner answersInput = new Scanner(System.in);) {
            String answers = answersInput.nextLine();
            if (answers.equalsIgnoreCase("Y")) {
                int arrayLength = random.nextInt(RANDOM_ARRAY_LENGTH_LIMIT) + RANDOM_ARRAY_LENGTH_LIMIT;
                array = new int[arrayLength];
                for (int i = 0; i < arrayLength; i++) {
                    array[i] = random.nextInt(RANDOM_ARRAY_VALUE_LIMIT);
                }
                System.out.print("Array: ");
                Arrays.stream(array).forEach(x -> System.out.print(x + " "));
            } else {
                System.out.print("Enter in the array of natural numbers (each number is separated by 1 space): ");
                try (Scanner arrayInput = new Scanner(System.in);) {
                    String[] arrayProcessin = arrayInput.nextLine().replaceAll("\\s+", " ").split(" ");
                    array = new int[arrayProcessin.length];
                    for (int i = 0; i < arrayProcessin.length; i++) {
                        array[i] = Integer.parseInt(arrayProcessin[i]);
                    }
                }
            }
            System.out.println();
            System.out.print("Enter the value to find in the array: ");
            try (Scanner targetInput = new Scanner(System.in);) {
                String input = targetInput.nextLine();
                int target = Integer.parseInt(input);

                int index = linearSearch(array, target);

                if (index != -1) {
                    System.out.println("Element found at index: " + index);
                } else {
                    System.out.println("Element not found");
                }
            }
        }
    }

    private static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Target element found, return the index
            }
        }
        return -1; // Target element not found
    }
}
