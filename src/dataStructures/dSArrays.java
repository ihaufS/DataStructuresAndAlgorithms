package dataStructures;

import java.util.Arrays;

public class dSArrays {
    static String[] city;

    public static void main(String[] args) {
        city = new String[10];
        city[0] = "HaNoi";

        String[] address = {"GiaiPhong", "DaiLa"};

        for (int i = 0; i < city.length; i++) {
            System.out.println("City " + i + " " + city[i]);
        }

        for (int i = address.length - 1; i >= 0; i--) {
            System.out.println("Address " + i + " " + address[i]);
        }

        for (String add : address) {
            System.out.println("Address " + add);
        }

        Arrays.stream(address).forEach(System.out::println);

        System.out.println("City: " + city.length + " " + "Address: " + address.length);
    }
}
