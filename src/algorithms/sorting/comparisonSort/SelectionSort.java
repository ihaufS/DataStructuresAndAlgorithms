package algorithms.sorting.comparisonSort;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        /*
         * Sắp xếp lựa chọn là một thuật toán sắp xếp dựa trên so sánh đơn giản hoạt
         * động bằng cách phân vùng một mảng thành hai phần: một mảng con được sắp xếp
         * và một subarray chưa được sắp xếp. Thuật toán liên tục chọn phần tử nhỏ nhất
         * (hoặc lớn nhất) từ mảng con chưa được sắp xếp và di chuyển nó đến cuối
         * subarray được sắp xếp. Quá trình này được lặp lại cho đến khi toàn bộ mảng
         * được sắp xếp.
         *
         * Thuật toán hoạt động như sau:
         *
         * 1.Lặp qua mảng, chọn phần tử nhỏ nhất trong arrays chưa được sắp xếp.
         * 2.Hoán đổi phần tử đã chọn với phần tử ngoài cùng bên trái trong arrays chưa
         * được sắp xếp.
         * 3.Di chuyển ranh giới của mảng con được sắp xếp sang một phần tử sang phải.
         * Các bước trên được lặp lại cho đến khi toàn bộ mảng được sắp xếp. Sắp xếp lựa
         * chọn có độ phức tạp thời gian là O (n ^ 2), trong đó n là số phần tử trong
         * mảng.
         *
         * Sắp xếp lựa chọn không được coi là thuật toán sắp xếp hiệu quả nhất cho các
         * mảng lớn, nhưng nó có thể hữu ích cho các mảng nhỏ hoặc như một khối xây dựng
         * trong các thuật toán phức tạp hơn khác.
         */

        // Prompt user for input
        System.out.print("Enter in the array of natural numbers (each number is separated by 1 space): ");
        try (Scanner inputArrays = new Scanner(System.in)) {
            String[] arrayProcessin = inputArrays.nextLine().replaceAll("\\s+", " ").split(" ");
            int[] arrays = new int[arrayProcessin.length];

            //covert input in Interget arrays
            for (int i = 0; i < arrayProcessin.length; i++) {
                arrays[i] = Integer.parseInt(arrayProcessin[i]);
            }
            // Perform Slection Sort
            selectionSortx(arrays);

            //Print sorted arrays
            System.out.print("Sorted array: ");
            Arrays.stream(arrays).forEach(x -> System.out.print(x + " "));

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void selectionSortx(int[] arrays) {
        int n = arrays.length;

        for (int i = 0; i < n - 1; i++) {
            int minIDx = i;
            for (int j = i + 1; j < n; j++) {
                if (arrays[j] < arrays[minIDx]) {
                    minIDx = j;
                }
            }
            int temp = arrays[minIDx];
            arrays[minIDx] = arrays[i];
            arrays[i] = temp;

        }
    }
}