package dataStructures;

import java.util.Stack;

public class dSStacks {
    static Stack<String> citys;
    public static void main(String[] args) {
        /*
         * Trong máy tính khoa học, ngăn xếp là một cấu trúc dữ liệu lưu trữ một tập hợp
         * các phần tử theo thứ tự tuyến tính, trong đó phần tử cuối cùng được thêm vào
         * là phần tử đầu tiên bị xóa. Thứ tự này thường được gọi là LIFO
         * (Last-In-First-Out). Cấu trúc dữ liệu ngăn xếp có thể được coi là một chồng
         * tấm, trong đó các tấm mới được thêm vào trên cùng và tấm cuối cùng được thêm
         * vào phải được gỡ bỏ trước để truy cập các tấm bên dưới nó.
         * 
         * Một ngăn xếp trong Java có thể được thực hiện bằng cách sử dụng lớp Stack
         * hoặc giao diện Deque. Lớp Stack là một lớp kế thừa mở rộng lớp Vector và cung
         * cấp các phương thức để đẩy, bật và nhìn trộm vào phần tử trên cùng của ngăn
         * xếp. Giao diện Deque, được giới thiệu trong Java 6, là viết tắt của
         * "hàng đợi kết thúc kép" và cung cấp các phương thức để chèn và xóa các phần
         * tử ở cả hai đầu của hàng đợi, có thể được sử dụng để triển khai ngăn xếp.
         */
        citys = new Stack<>();
        citys.push("HaNoi");
        citys.push("HoChiMinh");
        citys.push("DaNang");

        System.out.println("size: " + citys.size());
        System.out.println("peek: " + citys.peek());
        System.out.println("pop: " + citys.pop());
        System.out.println("size: " + citys.size());
        System.out.println("empty: " + citys.empty());
        System.out.println("search: " + citys.search("HaNoi"));
    }
}
