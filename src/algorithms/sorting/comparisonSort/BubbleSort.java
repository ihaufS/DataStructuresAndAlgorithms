package algorithms.sorting.comparisonSort;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        /*
         * Bubble Sort là một thuật toán sắp xếp đơn giản liên tục bước qua danh sách
         * cần sắp xếp, so sánh các phần tử liền kề và hoán đổi chúng nếu chúng theo sai
         * thứ tự. Việc chuyển qua danh sách được lặp lại cho đến khi danh sách được sắp
         * xếp.
         *
         * Đây là thuật toán cơ bản cho Bubble Sort:
         *
         * 1.Lặp lại cho đến khi không có giao dịch hoán đổi nào được thực hiện:
         * -Đặt cờ hoán đổi thành false.
         * -Đối với mỗi phần tử trong danh sách (trừ phần tử cuối cùng):
         * -Nếu phần tử hiện tại lớn hơn phần tử tiếp theo, hãy hoán đổi chúng và đặt cờ
         * -hoán đổi thành true.
         * 2.Dừng.
         */

        /*
         * //! Lưu ý rằng Bubble Sort có độ phức tạp thời gian trung bình và trường hợp
         * xấu nhất là O (n ^ 2), khiến nó không hiệu quả đối với các danh sách lớn.
         * Tuy nhiên, nó có độ phức tạp thời gian tốt nhất là O (n) khi danh sách đã
         * được sắp xếp, đó là lợi thế chính của nó so với các thuật toán sắp xếp khác.
         */

        // Prompt user for input
        System.out.print("Enter in the array of natural numbers (each number is separated by 1 space): ");
        try (Scanner inputArrays = new Scanner(System.in)) {
            String[] arrayProcessin = inputArrays.nextLine().replaceAll("\\s+", " ").split(" ");
            int[] arrays = new int[arrayProcessin.length];

            // Convert input to integer array
            for (int i = 0; i < arrayProcessin.length; i++) {
                arrays[i] = Integer.parseInt(arrayProcessin[i]);
            }

            // Perform Bubble Sort
            bubbleSort(arrays);

            // Print sorted array
            System.out.print("Sorted array: ");
            for (int array : arrays) {
                System.out.print(array + " ");
            }
            System.out.println();
            Arrays.stream(arrays).forEach(x -> System.out.print(x + " "));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static void bubbleSort(int[] arrays) {
        boolean swapped = true;
        int n = arrays.length;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (arrays[i] > arrays[i + 1]) {

                    // Swap elements
                    int temp = arrays[i];
                    arrays[i] = arrays[i + 1];
                    arrays[i + 1] = temp;
                    swapped = true;
                }
            }
            n--;
        }
    }
}
