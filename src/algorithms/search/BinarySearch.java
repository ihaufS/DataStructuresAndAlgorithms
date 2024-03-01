package algorithms.search;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class BinarySearch {
    private static final int RANDOM_ARRAY_LENGTH_LIMIT = 50;
    private static final int RANDOM_ARRAY_VALUE_LIMIT = 10000;

    public static void main(String[] args) {
        /*
         * Thuật toán Tìm kiếm nhị phân là một thuật toán tìm kiếm nhanh hoạt động trên
         * các mảng được sắp xếp. Nó liên tục chia khoảng thời gian tìm kiếm làm đôi
         * bằng cách so sánh phần tử giữa với phần tử đích cho đến khi tìm thấy kết quả
         * phù hợp hoặc khoảng thời gian tìm kiếm trở nên trống. Dưới đây là các bước để
         * xây dựng thuật toán Binary Search trong Java:
         *
         * 1. Bắt đầu bằng cách xác định một phương thức gọi là binarySearch có ba tham
         * số: mảng được sắp xếp sẽ được tìm kiếm, phần tử đích được tìm thấy và các chỉ
         * số của khoảng thời gian tìm kiếm (bắt đầu và kết thúc). Phương thức sẽ trả về
         * chỉ mục của phần tử đích nếu tìm thấy hoặc -1 nếu không tìm thấy.
         *
         * 2. Bên trong phương pháp tìm kiếm nhị phân, hãy tính chỉ số giữa của khoảng
         * thời gian tìm kiếm làm trung bình của các chỉ số bắt đầu và kết thúc.
         *
         * 3. So sánh phần tử giữa của mảng với phần tử đích. Nếu chúng bằng nhau, trả
         * về chỉ số giữa.
         *
         * 4. Nếu phần tử giữa lớn hơn phần tử đích, hãy gọi đệ quy phương thức
         * binarySearch ở nửa bên trái của mảng (từ đầu đến giữa-1).
         *
         * 5. Nếu phần tử giữa nhỏ hơn phần tử đích, hãy gọi đệ quy phương thức
         * binarySearch ở nửa bên phải của mảng (từ giữa + 1 đến cuối).
         *
         * 6. Nếu khoảng thời gian tìm kiếm trở nên trống (bắt đầu > kết thúc), phần tử
         * đích không được tìm thấy, vì vậy hãy trả về -1.
         */
        int[] array;
        Random random = new Random();
        out.print("Use random arrays (Otherwise enter data into the array, each value separated by a space) Y/N: ");
        try (Scanner anwsersInput = new Scanner(in)) {
            String anwsers = anwsersInput.nextLine();
            if (anwsers.equalsIgnoreCase("Y")) {
                int arrayLength = random.nextInt(RANDOM_ARRAY_LENGTH_LIMIT) + RANDOM_ARRAY_LENGTH_LIMIT;
                array = new int[arrayLength];
                for (int i = 0; i < arrayLength; i++) {
                    array[i] = random.nextInt(RANDOM_ARRAY_VALUE_LIMIT);
                }

            } else {
                out.print("Enter in the array of natural numbers (each number is separated by 1 space): ");
                try (Scanner arrayInput = new Scanner(in)) {
                    String[] arrayProcessin = arrayInput.nextLine().replaceAll("\\s+", " ").split(" ");
                    array = new int[arrayProcessin.length];
                    for (int i = 0; i < arrayProcessin.length; i++) {
                        array[i] = Integer.parseInt(arrayProcessin[i]);
                    }
                }
            }
            quickSort(array, 0, array.length - 1);
            out.print("Array Sorted: ");
            Arrays.stream(array).forEach(x -> out.print(x + " "));
            out.println();
            out.print("Enter the value to find in the array: ");
            try (Scanner targetInput = new Scanner(in)) {
                String input = targetInput.nextLine();
                int target = Integer.parseInt(input);

                int index = binarySearch(array, target, 0, array.length - 1);

                if (index != -1)
                    out.println("Element found at index: " + index);
                else
                    out.println("Element not found");
            }
        }

    }

    private static int binarySearch(int[] array, int target, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target)
                return mid;
            if (array[mid] > target)
                return binarySearch(array, target, left, mid - 1);
            return binarySearch(array, target, mid + 1, right);
        }
        return -1;
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivotValue = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] < pivotValue) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
