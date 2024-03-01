package algorithms.sorting.comparisonSort;

import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {
    public static void main(String[] args) {
        /*
         * Heap Sort là một thuật toán sắp xếp dựa trên so sánh sử dụng cấu trúc dữ liệu
         * đống nhị phân để sắp xếp các phần tử. Nó hoạt động bằng cách tạo một đống tối
         * đa hoặc min-heap (tùy thuộc vào thứ tự sắp xếp được yêu cầu) của các phần tử
         * đầu vào, sau đó liên tục trích xuất phần tử gốc của đống, được đảm bảo là
         * phần tử tối đa (hoặc tối thiểu) trong đống. Phần tử được trích xuất được đặt
         * ở cuối mảng được sắp xếp và đống được cấu trúc lại để duy trì thuộc tính
         * heap.
         *
         * Các bước để triển khai Heap Sort như sau:
         *
         * 1.Xây dựng max-heap hoặc min-heap từ mảng đầu vào.
         * 2.Giải nén phần tử gốc (sẽ là phần tử tối đa hoặc tối thiểu) và hoán đổi nó
         * với phần tử cuối cùng trong heap.
         * 3.Loại bỏ phần tử cuối cùng khỏi heap (bây giờ là phần tử tối đa hoặc tối
         * thiểu) và đặt nó ở cuối mảng được sắp xếp.
         * 4.Khôi phục thuộc tính heap bằng cách sàng lọc phần tử gốc mới, nếu cần.
         * 5.Lặp lại các bước 2-4 cho đến khi toàn bộ mảng được sắp xếp.
         *
         * Heap Sort có độ phức tạp về thời gian là O (nlogn), làm cho nó trở thành một
         * thuật toán sắp xếp hiệu quả cho các tập dữ liệu lớn.
         *
         * Tuy nhiên, nó đòi hỏi bộ nhớ bổ sung để lưu trữ cấu trúc dữ liệu heap, điều
         * này có thể là một bất lợi trong một số trường hợp.
         */
        // Prompt user for input
        System.out.print("Enter in the array of natural numbers (each number is separated by 1 space): ");
        try (Scanner inputArrays = new Scanner(System.in)) {
            String[] arraysProsecccin = inputArrays.nextLine().replaceAll("\\s+", " ").split(" ");
            int[] arrays = new int[arraysProsecccin.length];

            // covert input in Interget arrays
            for (int i = 0; i < arraysProsecccin.length; i++) {
                arrays[i] = Integer.parseInt(arraysProsecccin[i]);
            }

            // Perform Heap Sort
            heapSortx(arrays);

            // Print sorted arrays
            System.out.println("Sorted array: ");
            Arrays.stream(arrays).forEach(x -> System.out.print(x + " "));

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void heapSortx(int[] arrays) {
        int n = arrays.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arrays, n, i);

        // Trích xuất từng phần tử từ heap
        for (int i = n - 1; i >= 0; i--) {
            // Di chuyển gốc hiện tại đến cuối
            int temp = arrays[0];
            arrays[0] = arrays[i];
            arrays[i] = temp;

            // Gọi max heapify trên heap giảm
            heapify(arrays, i, 0);
        }
    }

    private static void heapify(int[] arrays, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger than root
        if (left < n && arrays[left] > arrays[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < n && arrays[right] > arrays[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            int swap = arrays[i];
            arrays[i] = arrays[largest];
            arrays[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arrays, n, largest);
        }
    }

}
