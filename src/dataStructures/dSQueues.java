package dataStructures;

import java.util.*;

public class dSQueues {
    static Queue<String> citysLinkedList;
    static LinkedList<citys> new_linkedlist;

    static Queue<String> citysPriorityQueue;
    static Queue<String> citysArrayDeque;

    public static void main(String[] args) {
        /*
         * Trong Java, một Queue là cấu trúc dữ liệu tuân theo nguyên tắc Nhập trước
         * xuất trước (FIFO), có nghĩa là phần tử đầu tiên được thêm vào hàng đợi là
         * phần tử đầu tiên bị xóa. Java Collections Framework cung cấp một giao diện
         * được gọi là Queue Điều đó xác định hành vi của một hàng đợi, cùng với một số
         * triển khai của Queue giao diện.
         * 
         * Một số triển khai được sử dụng phổ biến nhất của Queue Giao diện trong Java
         * bao gồm:
         * 
         * LinkedList: Lớp này cung cấp một triển khai đơn giản của Queue giao diện sử
         * dụng danh sách được liên kết kép. Các phần tử có thể được thêm vào cuối danh
         * sách bằng cách sử dụng add() or offer() các phương thức và phần tử có thể
         * được xóa khỏi đầu danh sách bằng cách sử dụng remove() or poll() Phương pháp.
         * 
         * PriorityQueue: Lớp này cung cấp một triển khai hàng đợi ưu tiên của Queue
         * giao diện, có nghĩa là các phần tử được sắp xếp dựa trên thứ tự tự nhiên của
         * chúng hoặc bộ so sánh tùy chỉnh. Các phần tử có thể được thêm vào hàng đợi
         * bằng cách sử dụng add() or offer() phương thức và phần tử có mức độ ưu tiên
         * cao nhất có thể được xóa bằng cách sử dụng remove() or poll() Phương pháp.
         * 
         * ArrayDeque: Lớp này cung cấp một triển khai của Deque giao diện, là một hàng
         * đợi hai đầu có thể được sử dụng như một hàng đợi hoặc một ngăn xếp. Các yếu
         * tố có thể được thêm vào cuối deque bằng cách sử dụng add() or offer() Các
         * phương thức và phần tử có thể được loại bỏ từ đầu deque bằng cách sử dụng
         * remove() or poll() Phương pháp.
         */

        /// Linked List
        System.out.println("|| dataStructures LinkedList in LinkedList ||");

        new_linkedlist = new LinkedList<>();

        new_linkedlist.add(new citys(0, "HaNoi"));
        new_linkedlist.add(new citys(1, "HCM"));
        new_linkedlist.add(new citys(2, "DaNang"));
        new_linkedlist.add(new citys(3, "Hue"));

        new_linkedlist.set(0, new citys(0, "LeKhuongHau"));
        new_linkedlist.add(2, new citys(7, "UngHoa"));

        LinkedList<dSQueues.citys> liat = (LinkedList<dSQueues.citys>) new_linkedlist.clone();
        System.out.println("Clone: " + liat);
        System.out.println(new_linkedlist.getClass());
        System.out.println(new_linkedlist);
        ListIterator<citys> citysIterator = new_linkedlist.listIterator();

        System.out.println("peek: " +new_linkedlist.peek());
        System.out.println("hashCode: " +new_linkedlist.hashCode());
        System.out.println("toArray: " + Arrays.toString(new_linkedlist.toArray()));
        // System.out.println("pop: " +new_linkedlist.pop());
        // System.out.println("poll: " +new_linkedlist.poll());


        System.out.println("hasNext: " + citysIterator.hasNext());
        System.out.println("|| Next ||");
        new_linkedlist.forEach(System.out::println);
        while (citysIterator.hasNext()) {
            System.out.println(citysIterator.next());
        }
        System.out.println("hasPrevious: " + citysIterator.hasPrevious());
        System.out.println("|| Previous ||");
        while (citysIterator.hasPrevious()) {
            System.out.println(citysIterator.previous());
        }

        citysLinkedList = new LinkedList<>();
        citysLinkedList.add("HaNoi");
        citysLinkedList.add("HoChiMinh");
        citysLinkedList.add("DaNang");

        System.out.println("|| dataStructures LinkedList in Queue ||");
        System.out.println(citysLinkedList);
        System.out.println("peek: " + citysLinkedList.peek());
        System.out.println("poll: " + citysLinkedList.poll());
        System.out.println("size: " + citysLinkedList.size());
        System.out.println("element: " + citysLinkedList.element());
        System.out.println("remove: " + citysLinkedList.remove());
        System.out.println("offer HaNoi: " + citysLinkedList.offer("HaNoi"));
        System.out.println("checkIsEmpty: " + citysLinkedList.isEmpty());
        System.out.println(citysLinkedList);

        Queue<citys> objectLinkedList = new LinkedList<>();
        objectLinkedList.add(new citys(1, "HaNoi"));
        objectLinkedList.add(new citys(2, "HoChiMinh"));
        objectLinkedList.add(new citys(3, "DaNang"));
        objectLinkedList.add(new citys(4, "Hue"));
        objectLinkedList.add(new citys(5, "NgheAn"));

        System.out.println(objectLinkedList);

        /// Priority Queue
        citysPriorityQueue = new PriorityQueue<>();

        System.out.println("|| dataStructures PriorityQueue in Queue ||");
        citysPriorityQueue.add("HaNoi");
        citysPriorityQueue.add("HoChiMinh");
        citysPriorityQueue.add("DaNang");
        citysPriorityQueue.removeIf("HaNoi"::equals);
        citysPriorityQueue.forEach(System.out::println);

        /// Array Deque
        citysArrayDeque = new ArrayDeque<>();

    }

    record citys(int ID, String name) {
    }
}
