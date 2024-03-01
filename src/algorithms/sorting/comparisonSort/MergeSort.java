package algorithms.sorting.comparisonSort;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        /*
         * Sắp xếp hợp nhất là một thuật toán sắp xếp chia và chinh phục sắp xếp một
         * mảng bằng cách chia nó thành hai nửa, sắp xếp các nửa một cách độc lập và sau
         * đó hợp nhất các nửa được sắp xếp. Các bước cơ bản của thuật toán sắp xếp hợp
         * nhất như sau:
         *
         * 1.Chia mảng chưa sắp xếp thành n mảng con, mỗi mảng chứa một phần tử.
         * 2.Liên tục hợp nhất các mảng con để tạo ra các mảng con được sắp xếp mới cho
         * đến khi chỉ còn lại một mảng con. Đây sẽ là mảng được sắp xếp.
         *
         * Trong quá trình triển khai này, chúng ta bắt đầu bằng cách chia mảng thành
         * hai nửa và sắp xếp đệ quy từng nửa bằng phương pháp merge. Khi các mảng
         * con đã được sắp xếp, chúng ta hợp nhất chúng lại với nhau bằng phương
         * thức mergeSort. Phương pháp mergeSort hoạt động bằng cách tạo các mảng tạm thời để giữ
         * hai mảng con, sau đó hợp nhất các phần tử của các mảng này vào mảng ban đầu
         * theo thứ tự được sắp xếp.
         */

        // Prompt user for input
        System.out.print("Enter in the array of natural numbers (each number is separated by 1 space): ");
        try (Scanner inputArrays = new Scanner(System.in)) {
            String[] arrayProcessin = inputArrays.nextLine().replaceAll("\\s+", " ").split(" ");
            int[] arrays = new int[arrayProcessin.length];

            //Covert input in interger array
            for (int i = 0; i < arrayProcessin.length; i++) {
                arrays[i] = Integer.parseInt(arrayProcessin[i]);
            }

            // Perform Merge Sort
            mergeSortMethod(arrays, 0, arrays.length - 1);

            //Print sorted arrays
            System.out.print("Sorted array: ");
            Arrays.stream(arrays).forEach(x -> System.out.print(x + " "));

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static void mergeSortMethod(int[] arrays, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortMethod(arrays, left, mid);
            mergeSortMethod(arrays, mid + 1, right);
            merge(arrays, left, mid, right);
        }
    }

    public static void merge(int[] arrays, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arrays[left + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = arrays[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arrays[k] = L[i];
                i++;
            } else {
                arrays[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arrays[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arrays[k] = R[j];
            j++;
            k++;
        }
    }
}
