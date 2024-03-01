package dataStructures;

import java.util.ArrayList;
import java.util.List;

public class dSLists {
    static List<String> citys;

    public static void main(String[] args) {
        /*
         * Trong Java, một danh sách là một tập hợp các phần tử có thể thuộc các kiểu dữ
         * liệu khác nhau và có thể được lưu trữ trong
         * "một vị trí bộ nhớ không liền kề".
         * Java cung cấp một số loại danh sách như ArrayList, LinkedList và Vector.
         */
        List<String> new_citys = List.of(
                "hanoi",
                "hochiminh",
                "danang");
        System.out.println(new_citys);
        /*
         * Danh sách bất biến không thể sửa đổi: new_citys
         */

        citys = new ArrayList<>();
        citys.add("TP.HaNoi");
        citys.add("TP.HCM");
        citys.add("TP.DaNang");

        System.out.println(citys);
        System.out.println(citys.size());
        System.out.println(citys.contains("TP.HaNoi"));

        for (String city : citys) {
            System.out.println("for each: " + city);

        }
        citys.forEach(System.out::println);

        for (int i = 0; i < citys.size(); i++) {
            System.out.println("for i: " + citys.get(i));
        }

    }
}
