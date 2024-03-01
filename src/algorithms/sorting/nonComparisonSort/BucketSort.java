package algorithms.sorting.nonComparisonSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BucketSort {
    public static void main(String[] args) {
        /*
         * Bucket Sort là một thuật toán sắp xếp hoạt động bằng cách phân phối các phần
         * tử của một mảng vào một số vùng lưu trữ, mỗi vùng lưu trữ sau đó được sắp xếp
         * riêng lẻ bằng thuật toán sắp xếp khác hoặc bằng cách áp dụng đệ quy thuật
         * toán sắp xếp vùng lưu trữ.
         *
         * Dưới đây là các bước để xây dựng thuật toán Bucket Sort:
         *
         * 1.Tạo một mảng các vùng lưu trữ.
         * 2.Lặp qua mảng đầu vào và thêm từng phần tử vào vùng lưu trữ thích hợp dựa trên
         * hàm băm được xác định trước.
         * 3.Sắp xếp từng vùng lưu trữ bằng thuật toán sắp xếp khác như sắp xếp chèn, sắp
         * xếp lựa chọn hoặc sắp xếp nhanh.
         * 4.Nối các vùng lưu trữ đã sắp xếp vào mảng được sắp xếp cuối cùng.
         */

        // Nhận mảng đầu vào từ dữ liệu được người dùng nhập
        System.out.print("Enter in an array of non-negative integers (each number is separated by 1 space): ");
        try (Scanner inputArrays = new Scanner(System.in)) {
            String[] arrayProcessin = inputArrays.nextLine().replaceAll("\\s+", " ").split(" ");
            int[] arrays = new int[arrayProcessin.length];

            // Chuyển đổi kiểu dữ liệu String của mảng arraProcessin sang mảng Interger arrays
            for (int i = 0; i < arrayProcessin.length; i++) {
                arrays[i] = Integer.parseInt(arrayProcessin[i]);
            }

            //Thực hiện thuật toán Bucket Sort
            bucketSortx(arrays, 2);

            //In mảng đã được sắp xếp ra console
            System.out.print("Sorted array: ");
            Arrays.stream(arrays).forEach(x -> System.out.print(x + " "));

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void bucketSortx(int[] arrays, int bucketSize) {
        // Tìm giá trị nhỏ nhất và lớn nhất trong mảng
        int minValue = arrays[0];
        int maxValue = arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            if (arrays[i] < minValue) {
                minValue = arrays[i];
            } else if (arrays[i] > maxValue) {
                maxValue = arrays[i];
            }
        }

        // Tính toán số lượng và kích thước bucket
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        ArrayList<Integer>[] buckets = new ArrayList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        // Gán phần tử cho buckets
        for (int i = 0; i < arrays.length; i++) {
            int bucketIndex = (arrays[i] - minValue) / bucketSize;
            buckets[bucketIndex].add(arrays[i]);
        }

        // Sắp xếp từng bucket
        for (int i = 0; i < bucketCount; i++) {
            Collections.sort(buckets[i]);
        }

        // Nối các buckets đã sắp xếp vào mảng được sắp xếp cuối cùng
        int currentIndex = 0;
        for (int i = 0; i < bucketCount; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arrays[currentIndex++] = buckets[i].get(j);
            }
        }
    }
}