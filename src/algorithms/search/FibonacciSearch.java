package algorithms.search;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FibonacciSearch {
    public static void main(String[] args) {
        /*
         * Thuật toán Fibonacci Search là một thuật toán tìm kiếm dựa trên dãy
         * Fibonacci. Nó được sử dụng để tìm kiếm một phần tử trong một mảng được sắp
         * xếp. Thuật toán so sánh phần tử đích với các phần tử tại các chỉ số chuỗi
         * Fibonacci cụ thể để xác định phạm vi tìm kiếm. Dưới đây là các bước để xây
         * dựng thuật toán Fibonacci Search trong Java:
         *
         * 1. Xác định một phương thức gọi là fibonacciSearch lấy mảng được sắp xếp,
         * phần tử đích để tìm kiếm và độ dài của mảng làm tham số. Phương thức sẽ trả
         * về chỉ mục của phần tử đích nếu tìm thấy hoặc -1 nếu nó không có trong mảng.
         *
         * 2. Tạo dãy Fibonacci lên đến một số lớn hơn hoặc bằng độ dài của mảng. Bạn có
         * thể tạo trình tự lặp đi lặp lại hoặc đệ quy.
         *
         * 3. Khởi tạo ba biến: fibMinus2 = 0 (số Fibonacci tại index -2), fibMinus1 = 1
         * (số Fibonacci tại index -1) và fib = fibMinus2 + fibMinus1.
         *
         * 4. Tìm số Fibonacci nhỏ nhất lớn hơn hoặc bằng độ dài của mảng. Điều này có
         * thể được thực hiện bằng cách tăng lặp đi lặp lại fibMinus2 và fibMinus1 cho
         * đến khi fib lớn hơn hoặc bằng chiều dài.
         *
         * 5. Khởi tạo một biến offset  thành -1, đại diện cho chỉ số của phần tử nhỏ
         * nhất của mảng con Fibonacci hiện tại đang được xem xét.
         *
         * 6. Trong khi độ dài của mảng con lớn hơn 1, hãy thực hiện các bước sau:
         * - Khởi tạo một biến i có giá trị nhỏ nhất của offset + fibMinus2 và chiều dài
         * của mảng trừ đi 1.
         * - So sánh phần tử target với phần tử tại index i. Nếu chúng bằng nhau, hãy trả
         * về chỉ số hiện tại.
         * - Nếu phần tử đích nhỏ hơn phần tử tại index i, hãy cập nhật fib thành fibMinus2
         * và fibMinus1 thành fibMinus1 - fibMinus2 và fibMinus2 thành fib - fibMinus1
         * - Nếu phần tử đích lớn hơn phần tử tại index i, hãy cập nhật fib thành fibMinus1
         * và fibMinus1 thành fibMinus2 và fibMinus2 thành fib - fibMinus1 và cập nhật offset
         * thành chỉ mục hiện tại.
         * 7. Nếu độ dài của mảng con là 1 và phần tử tại chỉ số offset + 1 bằng phần tử
         * đích, hãy trả về offset + 1.
         *
         * 8. Nếu không tìm thấy phần tử, hãy trả về -1.
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
            mergeSort(array, 0, array.length - 1);
            System.out.print("Array Sorted: ");
            Arrays.stream(array).forEach(x -> System.out.print(x + " "));
            System.out.println();
            System.out.print("Enter the value to find in the array: ");
            try (Scanner targetInput = new Scanner(System.in)) {
                int target = targetInput.nextInt();
                int index = fibonacciSearch(array, target, array.length);
                if (index != 1)
                    System.out.println("Element found at index: " + index);
                else
                    System.out.println("Element not found");
            }
        }
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }

    }

    private static int fibonacciSearch(int[] array, int target, int size) {
        int fibMinus2 = 0;
        int fibMinus1 = 1;
        int fib = fibMinus2 + fibMinus1;

        while (fib < size) {
            fibMinus2 = fibMinus1;
            fibMinus1 = fib;
            fib = fibMinus2 + fibMinus1;
        }
        int offset = -1;
        while (fib > 1) {
            int i = Math.min(offset + fibMinus2, size - 1);
            if (array[i] == target) {
                return i;
            } else if (array[i] > target) {
                fib = fibMinus2;
                fibMinus1 = fibMinus1 - fibMinus2;
                fibMinus2 = fib - fibMinus1;
            } else {
                fib = fibMinus1;
                fibMinus1 = fibMinus2;
                fibMinus2 = fib - fibMinus1;
                offset = i;
            }
        }
        if (fibMinus1 == 1 && array[offset + 1] == target) {
            return offset + 1;
        }

        return -1;
    }
}
