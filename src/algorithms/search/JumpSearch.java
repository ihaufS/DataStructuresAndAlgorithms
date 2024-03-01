package algorithms.search;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JumpSearch {
    public static void main(String[] args) {
        /*
         * Thuật toán Jump Search là một thuật toán tìm kiếm hoạt động trên các mảng
         * được sắp xếp. Nó thực hiện một bước nhảy về phía trước bởi một kích thước
         * khối cố định và sau đó kiểm tra các phần tử trong khối đó cho đến khi phần tử
         * mục tiêu được tìm thấy hoặc vượt quá. Dưới đây là các bước để xây dựng thuật
         * toán Jump Search trong Java:
         *
         * 1. Bắt đầu bằng cách định nghĩa một phương thức gọi là jumpSearch có hai tham
         * số: mảng được sắp xếp sẽ được tìm kiếm và phần tử đích được tìm thấy. Phương
         * thức sẽ trả về chỉ mục của phần tử đích nếu tìm thấy hoặc -1 nếu không tìm
         * thấy.
         *
         * 2. Xác định kích thước khối (kích thước bước tối ưu) bằng cách lấy căn bậc
         * hai của độ dài mảng. Kích thước khối này sẽ được sử dụng để thực hiện các
         * bước nhảy qua mảng trong quá trình tìm kiếm.
         *
         * 3. Thiết lập một vòng lặp để thực hiện tìm kiếm nhảy. Bên trong vòng lặp,
         * khởi tạo hai biến: prevIdx đến 0 (chỉ số bắt đầu của khối hiện tại) và bước
         * đến căn bậc hai của độ dài mảng.
         *
         * 4. Kiểm tra xem phần tử đích có lớn hơn phần tử cuối cùng của khối hiện tại
         * hay không. Nếu có, hãy cập nhật prevIdx lên chỉ mục cuối cùng của khối hiện
         * tại và bước tăng để thực hiện một bước nhảy mới.
         *
         * 5. Thực hiện tìm kiếm tuyến tính trong khối hiện tại từ prevIdx đến chỉ mục
         * hiện tại (tối thiểu độ dài của mảng hoặc bước prevIdx +).
         *
         * 6. Nếu phần tử đích được tìm thấy trong quá trình tìm kiếm tuyến tính, hãy
         * trả về chỉ mục.
         *
         * 7. Nếu phần tử đích không được tìm thấy trong khối hiện tại, tìm kiếm sẽ tiếp
         * tục với khối tiếp theo. Lặp lại các bước 4-6 cho đến khi tìm thấy phần tử
         * đích, vượt quá hoặc đạt đến cuối mảng.
         *
         * 8. Nếu phần tử đích không được tìm thấy sau vòng lặp, hãy trả về -1 để chỉ ra
         * rằng nó không có trong mảng.
         */

        int[] array;
        Random random = new Random();

        System.out.print("Use random arrays (Otherwise enter data into the array, each value separated by a space) Y/N: ");
        try (Scanner answersInput = new Scanner(System.in)) {
            String answers = answersInput.nextLine();
            if (answers.equalsIgnoreCase("Y")) {
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
            selectionSort(array);
            System.out.print("Array Sorted: ");
            Arrays.stream(array).forEach(x -> System.out.print(x + " "));
            System.out.println();
            System.out.print("Enter the value to find in the array: ");
            try (Scanner input = new Scanner(System.in)) {
                int target = input.nextInt();

                int index = jumpSearch(array, target);
                if (index != -1)
                    System.out.println("Element found of index: " + index);
                else
                    System.out.println("Element not found");
            }
        }
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minID = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minID])
                    minID = j;
            }
            int temp = array[minID];
            array[minID] = array[i];
            array[i] = temp;
        }
    }

    private static int jumpSearch(int[] array, int target) {
        int arrayLength = array.length;
        int blockSize = (int) Math.floor(Math.sqrt(arrayLength));
        int privID = 0;
        int step = blockSize;

        while (array[Math.min(step, arrayLength) - 1] < target) {
            privID = step;
            step += blockSize;
            if (privID >= arrayLength)
                return -1; // Phần tử target không có trong mảng
        }

        while (array[privID] < target) {
            privID++;
            if (privID == Math.min(step, arrayLength))
                return -1; // Phần tử target không có trong mảng
        }

        if (array[privID] == target)
            return privID; // Đã tìm thấy phần tử target tại prevID
        return -1; // Phần tử target không có trong mảng
    }
}
