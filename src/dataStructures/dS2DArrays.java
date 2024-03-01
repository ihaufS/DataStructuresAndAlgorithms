package dataStructures;

import java.util.Arrays;

public class dS2DArrays {
    static String[][] dS2DArray;

    public static void main(String[] args) {
        dS2DArray = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                dS2DArray[i][j] = "-";
            }
        }
//        for (int i = 0; i < 3; i++) {
//            Arrays.fill(dS2DArray[i], "-");
//        }
        String[][] new_dS2DArray = new String[][]{
                new String[]{"-", "-", "-"},
                new String[]{"-", "-", "-"},
                new String[]{"-", "-", "-"}
        };
        System.out.println(Arrays.deepToString(dS2DArray));
        System.out.println(Arrays.deepToString(new_dS2DArray));
    }
}