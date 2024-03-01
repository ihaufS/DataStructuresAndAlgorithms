package algorithms.sorting.nonComparisonSort;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {
    public static void main(String[] args) {
        /*
         * Counting Sort là một thuật toán sắp xếp không so sánh sắp xếp một mảng bằng
         * cách đếm số lần xuất hiện của từng phần tử duy nhất trong mảng và sau đó sử
         * dụng thông tin đó để tính thứ tự được sắp xếp cuối cùng. Nó hoạt động bằng
         * cách giả định rằng đầu vào bao gồm các số nguyên trong một phạm vi đã biết và
         * sử dụng giả định này để tránh thực hiện các phép so sánh tốn kém.
         *
         * Dưới đây là các bước để xây dựng thuật toán Counting Sort:
         *
         * 1.Tìm giá trị lớn nhất trong mảng đầu vào.
         * 2.Khởi tạo một mảng các bộ đếm kích thước "max + 1" và đặt tất cả các giá trị
         * thành 0.
         * 3.Đếm số lần xuất hiện của mỗi phần tử duy nhất trong mảng đầu vào và lưu trữ
         * số đếm trong mảng truy cập.
         * 4.Sửa đổi mảng truy cập để lưu trữ tổng tích lũy của số đếm.
         * 5.Khởi tạo một mảng kích thước "n" được sắp xếp (trong đó "n" là kích thước
         * của mảng
         * đầu vào).
         * 6.Lặp qua mảng đầu vào theo thứ tự ngược lại. Đối với mỗi phần tử, hãy sử
         * dụng
         * mảng truy cập để xác định chỉ mục của vị trí được sắp xếp cuối cùng của nó
         * trong mảng được sắp xếp, đặt phần tử tại chỉ mục đó và giảm số đếm trong mảng
         * truy cập.
         * 7.Mảng được sắp xếp bây giờ chứa các phần tử được sắp xếp của mảng đầu vào.
         *
         * Note: The counting sort algorithm requires the input elements to be
         * non-negative integers!
         * Lưu ý: Thuật toán couting sort đếm yêu cầu các phần tử đầu vào phải là số
         * nguyên không âm!
         */

        // Nhận mảng đầu vào từ dữ liệu được người dùng nhập
        System.out.print("Enter in an array of non-negative integers (each number is separated by 1 space): ");
        try (Scanner inputArrays = new Scanner(System.in)) {
            String[] arrayProcessin = inputArrays.nextLine().replaceAll("\\s+", " ").split(" ");
            int[] arrays = new int[arrayProcessin.length];

            // Chuyển đổi các phần tử trong mảng String "arrayProcessin" sang mảng Integer
            // "arays"
            for (int i = 0; i < arrayProcessin.length; i++) {
                arrays[i] = Integer.parseInt(arrayProcessin[i]);
            }

            // Thực hiện thuật toán Couting Sort
            countingSortx(arrays);

            // In ra mảng arrays đã được sắp xếp
            System.out.print("Sorted array: ");
            Arrays.stream(arrays).forEach(x -> System.out.print(x + " "));

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }

    public static void countingSortx(int[] arrays) {
        int n = arrays.length;

        // Tìm giá trị lớn nhất trong mảng đầu vào
        int max = arrays[0];
        for (int i = 1; i < n; i++) {
            if (arrays[i] > max) {
                max = arrays[i];
            }
        }

        // Khởi tạo một mảng các bộ đếm có kích thước max + 1 và đặt tất cả các giá trị
        // thành 0
        int[] count = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            count[i] = 0;
        }

        // Đếm số lần xuất hiện của từng phần tử duy nhất trong mảng đầu vào
        for (int i = 0; i < n; i++) {
            count[arrays[i]]++;
        }

        // Sửa đổi mảng bộ đếm để lưu trữ tổng tích lũy của số lần đếm
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Khởi tạo một mảng đã sắp xếp có kích thước n
        int[] sorted = new int[n];

        // Lặp lại mảng đầu vào theo thứ tự ngược lại
        for (int i = n - 1; i >= 0; i--) {
            // Sử dụng mảng bộ đếm để xác định chỉ số của phần tử được sắp xếp cuối cùng vị
            // trí trong mảng đã sắp xếp
            int index = count[arrays[i]] - 1;

            // Đặt phần tử tại chỉ mục đó trong mảng đã sắp xếp
            sorted[index] = arrays[i];

            // Giảm số đếm trong mảng truy cập
            count[arrays[i]]--;
        }

        // Sao chép mảng đã sắp xếp trở lại mảng đầu vào
        System.arraycopy(sorted, 0, arrays, 0, n);

//        for (int i = 0; i < n; i++) {
//            arrays[i] = sorted[i];
//        }
    }
}
