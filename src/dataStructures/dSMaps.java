package dataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class dSMaps {

    /*
     * Trong Java, bản đồ là một đối tượng ánh xạ các khóa đến các giá trị, tương tự
     * như từ điển trong Python. Java cung cấp một số triển khai giao diện trong
     * gói, bao gồm:Mapjava.util
     *
     * HashMap: Triển khai (Implements) của Giao diện "Map" bằng cách sử dụng bảng băm. Các phần tử được
     * lưu trữ trong một vùng lưu trữ dựa trên mã băm của chúng, cung cấp hiệu suất
     * thời gian không đổi cho hầu hết các hoạt động. Việc triển khai này không đảm
     * bảo thứ tự của các khóa và giá trị.
     *
     * LinkedHashMap: Kế thừa (Extends) "HashMap" và duy trì một danh sách các phần tử được
     * liên kết
     * theo thứ tự chúng được thêm vào. Việc triển khai này cung cấp thứ tự lặp có
     * thể dự đoán được, là thứ tự mà các phần tử được thêm vào.
     *
     * TreeMap: Triển khai (Implements) của Giao diện "SortedMap" bằng cây đỏ-đen. Các phần tử được lưu trữ theo
     * thứ tự sắp xếp dựa trên thứ tự tự nhiên của chúng hoặc một bộ so sánh được
     * chỉ định. Việc triển khai này cung cấp chi phí thời gian nhật ký (n) được đảm
     * bảo cho hầu hết các hoạt động, bao gồm thêm, xóa và chứa.
     */

    static Map<Integer, citysData> citys;

    public static void main(String[] args) {
//        maps();
        Map<citysData, persons> new_citys = new HashMap<>();
        new_citys.put(new citysData("HaNoi"), new persons(100000000));

        System.out.println(new citysData("HaNoi").hashCode());
        System.out.println(new citysData("HaNoi").hashCode());
        System.out.println(new_citys.get(new citysData("HaNoi")));
    }

    private static void maps() {
        citys = new HashMap<>();
        citys.put(1, new citysData("HaNoi"));
        citys.put(2, new citysData("HCM"));
        citys.put(3, new citysData("DaNang"));
        citys.put(4, new citysData("Hue"));
        citys.remove(4);

        System.out.println(citys);
        citys.entrySet().forEach(System.out::println);
        citys.entrySet().forEach(x -> System.out.println("Key: " + x.getKey() + " Value: " + x.getValue()));
        for (Map.Entry<Integer, citysData> x : citys.entrySet()) {
            System.out.println("Key: " + x.getKey() + " Value: " + x.getValue());
        }
        citys.forEach((Key, citysData) -> System.out.println("Key: " + Key + "-" + citysData));
        System.out.println("size: " + citys.size());
        System.out.println("get: " + citys.get(4));
        System.out.println("getOrDefault: " + citys.getOrDefault(4, new citysData("Default")));
        System.out.println("containsKey: " + citys.containsKey(4));
        System.out.println("keySet: " + citys.keySet());
        System.out.println("value: " + citys.values());
        System.out.println("entrySet: " + citys.entrySet());
    }

    record persons(int person) {

    }

    static class citysData {
        String citys;

        public citysData(String citys) {
            this.citys = citys;
        }

        @Override
        public String toString() {
            return "citysData{" +
                    "citys='" + citys + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            citysData citysData = (citysData) o;
            return Objects.equals(citys, citysData.citys);
        }

        @Override
        public int hashCode() {
            return Objects.hash(citys);
        }
    }
}
