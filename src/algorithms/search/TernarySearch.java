package algorithms.search;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TernarySearch {
    public static void main(String[] args) {
        /*
         * Thuật toán Ternary Search là một thuật toán tìm kiếm chia và chinh phục được
         * sử dụng để tìm một phần tử trong một mảng được sắp xếp. Nó hoạt động bằng
         * cách chia mảng thành ba phần và thu hẹp đệ quy phạm vi tìm kiếm dựa trên so
         * sánh phần tử đích với các giá trị tại hai điểm phân vùng. Dưới đây là các
         * bước để xây dựng thuật toán Ternary Search trong Java:
         *
         * 1. Xác định một phương thức gọi là ternarySearch lấy mảng được sắp xếp, phần
         * tử đích để tìm kiếm và các chỉ số low và high của phạm vi tìm kiếm làm tham
         * số. Phương thức sẽ trả về chỉ mục của phần tử đích nếu tìm thấy hoặc -1 nếu
         * nó không có trong mảng.
         *
         * 2. Tính hai điểm phân vùng, mid1 và mid2, chia phạm vi tìm kiếm thành ba phần
         * bằng nhau:
         *
         * mid1 = low + (high - low) / 3
         * mid2 = high - (high - low) / 3
         *
         * 3. So sánh phần tử mục tiêu với các phần tử ở mid1 và mid2. Có ba trường hợp
         * có thể xảy ra:
         *
         * - Nếu phần tử đích bằng phần tử ở mid1 hoặc mid2, hãy trả về chỉ mục của phần
         * tử phù hợp.
         * - Nếu phần tử đích nhỏ hơn phần tử ở mid1, hãy gọi đệ quy ternarySearch trên
         * phân vùng bên trái (từ low đến mid1-1).
         * - Nếu phần tử đích lớn hơn phần tử ở mid2, hãy gọi đệ quy ternarySearch trên
         * phân vùng bên phải (từ mid2 + 1 đến high).
         * - Nếu phần tử đích không ở mid1 cũng không mid2, hãy gọi đệ quy ternarySearch
         * trên phân vùng giữa (từ mid1 + 1 đến mid2-1).
         *
         * 4. Lặp lại bước 2 và 3 cho đến khi tìm thấy phần tử đích hoặc phạm vi tìm
         * kiếm trống (thấp > cao). Nếu phạm vi tìm kiếm trống, trả về -1 để chỉ ra rằng
         * phần tử không có trong mảng.
         *
         * Lưu ý rằng mảng phải được sắp xếp theo thứ tự tăng dần để thuật toán Tìm kiếm
         * Ternary hoạt động chính xác.
         */

        int[] array;
        Random random = new Random();

        System.out.print(
                "Use random arrays (Otherwise enter data into the array, each value separated by a space) Y/N: ");
        try (Scanner anwsersInput = new Scanner(System.in)) {
            String anwsers = anwsersInput.nextLine();
            if (anwsers.equalsIgnoreCase("Y")) {
                int arrayLength = random.nextInt(50) + 50;
                array = new int[arrayLength];
                for (int i = 0; i < arrayLength; i++) {
                    array[i] = random.nextInt(10000);
                }
            } else {
                System.out.print("Enter in the array of natural numbers (each number is separated by 1 space): ");
                try (Scanner arrayInput = new Scanner(System.in)) {
                    String[] arrayProseccin = arrayInput.nextLine().replaceAll("\\s+", " ").split(" ");
                    array = new int[arrayProseccin.length];
                    for (int i = 0; i < arrayProseccin.length; i++) {
                        array[i] = Integer.parseInt(arrayProseccin[i]);
                    }
                }
            }
            insertionSort(array);
            System.out.print("Array Sorted: ");
            Arrays.stream(array).forEach(x -> System.out.print(x + " "));
            System.out.println();
            System.out.print("Enter the value to find in the array: ");
            try (Scanner targetInput = new Scanner(System.in)) {
                int target = targetInput.nextInt();
                int index = ternarySearch(array, target, 0, array.length - 1);

                if (index != -1)
                    System.out.print("Element found at index: " + index);
                else
                    System.out.print("Element not found");
            }
        }

    }

    private static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    private static int ternarySearch(int[] array, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid1 = low + (high - low) / 3;
        int mid2 = high - (high - low) / 3;

        if (target == mid1) {
            return mid1;
        } else if (target == mid2) {
            return mid2;
        } else if (target < array[mid1]) {
            return ternarySearch(array, target, low, mid1 - 1);
        } else if (target < array[mid2]) {
            return ternarySearch(array, target, mid2 + 1, high);
        } else {
            return ternarySearch(array, target, mid1 + 1, mid2 - 1);
        }
    }
}
