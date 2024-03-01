package algorithms.search;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ExponentialSearch {
    public static void main(String[] args) {
        /*
         * Thuật toán Tìm kiếm theo cấp số nhân là một thuật toán tìm kiếm hoạt động
         * trên các mảng được sắp xếp. Nó bắt đầu bằng cách tìm một phạm vi trong đó
         * phần tử đích có thể tồn tại và sau đó thực hiện tìm kiếm nhị phân trong phạm
         * vi đó để tìm phần tử đích. Dưới đây là các bước để xây dựng thuật toán
         * Exponential Search trong Java:
         *
         * 1.Bắt đầu bằng cách định nghĩa một phương thức gọi là exponentialSearch có hai
         * tham số: mảng được sắp xếp sẽ được tìm kiếm và phần tử đích được tìm thấy.
         * Phương thức sẽ trả về chỉ mục của phần tử đích nếu tìm thấy hoặc -1 nếu không
         * tìm thấy.
         *
         * 2.Kiểm tra xem phần tử đầu tiên của mảng có bằng với phần tử đích hay không.
         * Nếu có, trả về 0 khi phần tử đích được tìm thấy ở chỉ mục đầu tiên.
         *
         * 3.Xác định phạm vi cho tìm kiếm nhị phân. Bắt đầu với một biến gọi là bound set
         * thành 1, và trong khi bound nhỏ hơn độ dài của mảng và phần tử ở bound nhỏ
         * hơn phần tử đích, hãy nhân bound với 2.
         *
         * 4.Đặt chỉ mục bắt đầu cho tìm kiếm nhị phân đến mức tối thiểu của bound và
         * độ dài của mảng.
         *
         * 5.Đặt chỉ mục kết thúc cho tìm kiếm nhị phân đến mức tối thiểu của bound và
         * độ dài của mảng trừ đi 1.
         *
         * 6.Thực hiện tìm kiếm nhị phân trong phạm vi xác định. Điều kiện chỉ số bắt đầu nhỏ
         * hơn hoặc bằng chỉ số kết thúc, hãy tính chỉ số giữa là trung bình của chỉ số
         * bắt đầu và kết thúc. So sánh yếu tố ở chỉ số giữa với phần tử mục tiêu và
         * điều chỉnh các chỉ số bắt đầu và kết thúc cho phù hợp.(Tìm kiếm nhị phân)
         *
         * 7.Nếu phần tử đích được tìm thấy trong quá trình tìm kiếm nhị phân, hãy trả về
         * chỉ mục.
         *
         * 8.Nếu không tìm thấy phần tử đích, hãy trả về -1 để chỉ ra rằng nó không có
         * trong mảng.
         */

        int[] array;
        Random random = new Random();

        System.out.print("Use random arrays (Otherwise enter data into the array, each value separated by a space) Y/N: ");
        try (Scanner answersInput = new Scanner(System.in)) {
            String answer = answersInput.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                int arrayLength = random.nextInt(50) + 50;
                array = new int[arrayLength];
                for (int i = 0; i < arrayLength; i++) {
                    array[i] = random.nextInt(10000);
                }
            } else {
                System.out.print("Enter in the array of natural numbers (each number is separated by 1 space): ");
                try (Scanner arrayInput = new Scanner(System.in)) {
                    String[] arrayProcessin = arrayInput.nextLine().replaceAll("\\s+", " ").split(" ");
                    array = new int[arrayProcessin.length];

                    for (int i = 0; i < arrayProcessin.length; i++) {
                        array[i] = Integer.parseInt(arrayProcessin[i]);
                    }
                }
            }
            heapSort(array);
            System.out.print("Array Sorted: ");
            Arrays.stream(array).forEach(x -> System.out.print(x + " "));
            System.out.println();
            System.out.print("Enter the value to find in the array: ");
            try (Scanner targetInput = new Scanner(System.in)) {
                int target = targetInput.nextInt();
                int index = exponentialSearch(array, target);

                if (index != -1)
                    System.out.println("Element found at index: " + index);
                else
                    System.out.println("Element not found");
            }
        }
    }

    private static void heapSort(int[] array) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }

    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest])
            largest = left;

        if (right < n && array[right] > array[largest])
            largest = right;

        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, n, largest);
        }
    }

    private static int exponentialSearch(int[] array, int target) {
        int arraylength = array.length;

        if (array[0] == target)
            return 0;
        int bound = 1;
        while (bound < arraylength && array[bound] <= target) {
            bound *= 2;
        }
        int start = bound / 2;
        int end = Math.min(bound, arraylength - 1);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target)
                return mid;
            else if (array[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}
