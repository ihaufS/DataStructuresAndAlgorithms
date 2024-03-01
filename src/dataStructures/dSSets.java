package dataStructures;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class dSSets {
    static Set<citysInnerdSSets> citysSet;

    public static void main(String[] args) {
        /*
         * Trong Java, một tập hợp là một tập hợp các phần tử duy nhất "không cho phép
         * trùng lặp". Java cung cấp một số triển khai của Set giao diện trong java.util
         * trọn gói, bao gồm:
         *
         * HashSet: Triển khai (Implements) của Giao diện "Set" sử dụng bảng băm. Các
         * phần tử được lưu trữ trong một vùng lưu trữ dựa trên mã băm của chúng, cung
         * cấp hiệu suất thời gian không đổi cho hầu hết các hoạt động.
         *
         * LinkedHashSet: Kế thừa (Extends) "HashSet" và duy trì một danh sách các phần
         * tử được liên kết theo thứ tự chúng được thêm vào. Việc triển khai này cung
         * cấp thứ tự lặp có thể dự đoán được, là thứ tự mà các phần tử được thêm vào.
         *
         * TreeSet: Triển khai (Implements) của Giao diện "SortedSet" bằng cách sử dụng
         * một cây đỏ-đen. Các phần tử được lưu trữ theo thứ tự sắp xếp dựa trên thứ tự
         * tự nhiên của chúng hoặc một bộ so sánh được chỉ định. Việc triển khai này
         * cung cấp chi phí thời gian nhật ký (n) được đảm bảo cho hầu hết các hoạt
         * động, bao gồm thêm, xóa và chứa.
         */

        /// HashSet
        citysSet = new HashSet<>();
        citysSet.add(new citysInnerdSSets("HaNoi"));
        citysSet.add(new citysInnerdSSets("HaNoi")); // ! "không cho phép trùng lặp" .size() = 4 [HaNoi, HCM, DaNang, Hue]
        citysSet.add(new citysInnerdSSets("HCM"));
        citysSet.add(new citysInnerdSSets("DaNang"));
        citysSet.add(new citysInnerdSSets("Hue"));
        citysSet.forEach(System.out::println);
        System.out.println("size: " + citysSet.size());
        citysSet.clear();
        System.out.println("isEmpty: " + citysSet.isEmpty());


    }

    /**
     * InnerdSSets
     */
//     record citysInnerdSSets(String citys) {}

    static class citysInnerdSSets {
        private String citys;

        public citysInnerdSSets(String citys) {
            this.citys = citys;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            citysInnerdSSets that = (citysInnerdSSets) o;
            return Objects.equals(citys, that.citys);
        }

        @Override
        public int hashCode() {
            return Objects.hash(citys);
        }

        @Override
        public String toString() {
            return "citysInnerdSSets{" +
                    "citys='" + citys + '\'' +
                    '}';
        }
    }
}
