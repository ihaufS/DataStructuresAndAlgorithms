package algorithms.sorting.comparisonSort;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        /*
         * Sắp xếp nhanh là một thuật toán chia và chinh phục để sắp xếp một mảng hoặc
         * danh sách các phần tử. Đây là một trong những thuật toán được sử dụng phổ
         * biến nhất để sắp xếp, do tính hiệu quả và đơn giản của nó.
         *
         * Ý tưởng cơ bản đằng sau thuật toán sắp xếp nhanh là chọn một phần tử pivot từ
         * mảng, phân vùng mảng thành hai mảng con - một mảng chứa các phần tử nhỏ hơn
         * phần tử pivot và mảng còn lại chứa các phần tử lớn hơn phần tử pivot - và sắp
         * xếp đệ quy các mảng con. Phần tử pivot được định vị sao cho tất cả các phần
         * tử bên trái của nó nhỏ hơn nó và tất cả các phần tử bên phải của nó đều lớn
         * hơn nó.
         *
         * Dưới đây là các bước để triển khai thuật toán sắp xếp nhanh:
         *
         * 1.Chọn một phần tử pivot từ mảng. Đây có thể là bất kỳ phần tử nào, nhưng một
         * lựa chọn phổ biến là phần tử đầu tiên hoặc phần tử cuối cùng trong mảng.
         * 2.Phân vùng mảng thành hai mảng con - một mảng chứa các phần tử nhỏ hơn phần
         * tử pivot và mảng còn lại chứa các phần tử lớn hơn phần tử pivot.
         * 3.Áp dụng đệ quy các bước 1 và 2 cho các mảng con cho đến khi toàn bộ mảng
         * được sắp xếp.
         */
        // Prompt user for input
        System.out.print("Enter in the array of natural numbers (each number is separated by 1 space): ");
        try (Scanner inputArrays = new Scanner(System.in)) {
            String[] arraysProcessin = inputArrays.nextLine().replaceAll("\\s+", " ").split(" ");
            int[] arrays = new int[arraysProcessin.length];

            // covert input in Interger arrays
            for (int i = 0; i < arraysProcessin.length; i++) {
                arrays[i] = Integer.parseInt(arraysProcessin[i]);
            }

            // Perform Quick Sort
            quickSortx(arrays, 0, arrays.length - 1);

            // Print sorted arrays
            System.out.print("Sorted array: ");
            Arrays.stream(arrays).forEach(x -> System.out.print(x + " "));

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
    /*
     * Việc triển khai này lấy một mảng các số nguyên, các chỉ số trái và phải của
     * mảng được sắp xếp:
     * 1.Phương pháp quickSortx đệ quy sắp xếp các mảng con.
     * 2.Phương pháp partition phân vùng mảng và trả về chỉ mục của phần tử pivot.
     * 3.Phương pháp swap được sử dụng để hoán đổi các phần tử trong mảng.
     */

    public static void quickSortx(int[] arrays, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arrays, left, right);
            quickSortx(arrays, left, pivotIndex - 1);
            quickSortx(arrays, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] arrays, int left, int right) {
        int pivotValue = arrays[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arrays[j] < pivotValue) {
                i++;
                swap(arrays, i, j);
            }
        }
        swap(arrays, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] arrays, int i, int j) {
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }
}
