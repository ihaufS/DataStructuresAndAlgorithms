package algorithms.sorting.nonComparisonSort;

import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {
    public static void main(String[] args) {
        /*
         * Thuật toán Radix Sort là một thuật toán sắp xếp không so sánh, sắp xếp các số
         * nguyên bằng cách nhóm chúng theo các chữ số riêng lẻ. Nó hoạt động bằng cách
         * sắp xếp các phần tử dựa trên giá trị của mỗi chữ số, bắt đầu từ chữ số có
         * nghĩa nhỏ nhất đến chữ số có nghĩa nhất.
         *
         * Dưới đây là các bước để xây dựng thuật toán Radix Sort:
         *
         * 1.Tìm phần tử lớn nhất trong mảng để xác định số chữ số tối đa.
         *
         * 2.Đối với mỗi vị trí chữ số, bắt đầu từ chữ số có nghĩa nhỏ nhất:
         * *a. Tạo và khởi tạo một mảng đếm có kích thước 10, trong đó mỗi phần tử đại
         * diện cho số phần tử có chữ số đó.
         * *b. Đếm số lần xuất hiện của mỗi chữ số trong mảng và lưu trữ chúng trong
         * mảng đếm.
         * *c. Sửa đổi mảng đếm để lưu trữ số lượng tích lũy của mỗi chữ số, cho biết vị
         * trí của từng chữ số theo thứ tự được sắp xếp.
         *
         * 3.Tạo một mảng tạm thời để lưu trữ các phần tử được sắp xếp.
         *
         * 4.Đi qua mảng đầu vào từ phải sang trái:
         * *a. Lấy chữ số ở vị trí chữ số hiện tại.
         * *b. Sử dụng chữ số làm chỉ mục để xác định vị trí trong mảng đếm.
         * *c. Đặt phần tử vào mảng tạm thời tại vị trí xác định.
         * *d. Giảm số lượng của chữ số đó trong mảng đếm.
         *
         * 5.Sao chép các phần tử từ mảng tạm thời trở lại mảng ban đầu.
         */

        // Nhận mảng đầu vào từ dữ liệu được người dùng nhập
        System.out.print("Enter in an array of non-negative integers (each number is separated by 1 space): ");
        try (Scanner inputArrays = new Scanner(System.in)) {
            String[] arrayProcessin = inputArrays.nextLine().replaceAll("\\s+", " ").split(" ");
            int[] arrays = new int[arrayProcessin.length];

            //Chuyển đổi kiểu dữ liệu String của mảng arraProcessin sang mảng Interger arrays
            for (int i = 0; i < arrayProcessin.length; i++) {
                arrays[i] = Integer.parseInt(arrayProcessin[i]);
            }

            //Thực hiện thuật toán Radix Sort
            radixSortx(arrays);

            //In ra mảng arrays đã được sắp xếp
            System.out.print("Array sorted: ");
            Arrays.stream(arrays).forEach(x -> System.out.print(x + " "));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static void radixSortx(int[] arrays) {
        int max = getMax(arrays);

        // Thực hiện sắp xếp đếm cho từng vị trí chữ số
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arrays, exp);
        }
    }

    private static int getMax(int[] arrays) {
        int max = arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            if (arrays[i] > max) {
                max = arrays[i];
            }
        }
        return max;
    }

    private static void countingSort(int[] arrays, int exp) {
        int[] output = new int[arrays.length];
        int[] count = new int[10];

        Arrays.fill(count, 0);

        // Đếm số lần xuất hiện của từng giá trị chữ số
        for (int i = 0; i < arrays.length; i++) {
            int digit = (arrays[i] / exp) % 10;
            count[digit]++;
        }

        // Tính toán số lượng tích lũy
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Đặt các phần tử trong mảng đầu ra theo đúng thứ tự
        for (int i = arrays.length - 1; i >= 0; i--) {
            int digit = (arrays[i] / exp) % 10;
            output[count[digit] - 1] = arrays[i];
            count[digit]--;
        }

        // Sao chép các phần tử được sắp xếp trở lại mảng ban đầu
        System.arraycopy(output, 0, arrays, 0, arrays.length);
    }
}
