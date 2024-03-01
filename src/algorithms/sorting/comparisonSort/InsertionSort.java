package algorithms.sorting.comparisonSort;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        /*
         * Sắp xếp chèn là một thuật toán sắp xếp đơn giản hoạt động bằng cách xây dựng
         * mảng được sắp xếp cuối cùng một mục tại một thời điểm. Nó là một thuật toán
         * dựa trên so sánh tại chỗ, trong đó các yếu tố được chuyển từng phần tử một
         * đến đúng vị trí.
         *
         * Ý tưởng cơ bản đằng sau sắp xếp chèn là chia mảng đầu vào thành hai phần:
         * phần được sắp xếp và phần chưa sắp xếp. Thuật toán sau đó lặp qua phần chưa
         * được sắp xếp, lần lượt lấy từng phần tử và chèn nó vào vị trí thích hợp của
         * nó trong phần được sắp xếp. Để làm điều này, nó so sánh phần tử hiện tại với
         * các phần tử trong phần được sắp xếp, di chuyển chúng sang một vị trí sang
         * phải nếu chúng lớn hơn phần tử hiện tại.
         *
         * Dưới đây là các bước để triển khai thuật toán sắp xếp chèn:
         *
         * 1.Bắt đầu với phần tử thứ hai của mảng, giả sử phần tử đầu tiên đã được sắp
         * xếp.
         * 2.So sánh phần tử thứ hai với phần tử đầu tiên. Nếu phần tử thứ hai nhỏ hơn,
         * hãy hoán đổi chúng.
         * 3.Di chuyển đến phần tử thứ ba của mảng và so sánh nó với các phần tử ở bên
         * trái của nó, dịch chuyển bất kỳ phần tử lớn hơn nào sang vị trí bên phải cho
         * đến khi tìm thấy vị trí chính xác cho phần tử thứ ba.
         * 4.Lặp lại bước 3 cho tất cả các phần tử còn lại trong mảng.
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

            // Perform insertion Sort
            insertionSort(arrays);

            //Print sorted arrays
            System.out.print("Sorted array: ");
            Arrays.stream(arrays).forEach(x -> System.out.print(x + " "));

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static void insertionSort(int[] arrays) {
        int n = arrays.length;
        for (int i = 1; i < n; i++) {
            int key = arrays[i];
            int j = i - 1;
            while (j >= 0 && arrays[j] > key) {
                arrays[j + 1] = arrays[j];
                j--;
            }
            arrays[j + 1] = key;
        }

    }

}
