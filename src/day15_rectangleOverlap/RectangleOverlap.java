package day15_rectangleOverlap;

import java.util.Scanner;

 /*
 
    Given two axis-aligned rectangles rec1 and rec2, return true if they overlap,
     otherwise return false.

    Example 1:

    Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
    Output: true

 */


public class RectangleOverlap {

    public static void main(String[] args) {

        int[] rec1 = getInputs();
        int[] rec2 = getInputs();

        System.out.println(isRectangleOverlap(rec1, rec2));

    }


    public static boolean isRectangleOverlap(final int[] rec1, final int[] rec2) {

        if (rec1[0] >= rec2[2]
                || rec2[0] >= rec1[2]
                || rec1[1] >= rec2[3]
                || rec2[1] >= rec1[3]) {
            return false;
        }
        return true;
    }

    public static int[] getInputs() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("use \",\" for sperate items of outer list.");
        System.out.println("format: x1,y1,x2,y2");

        String input = scanner.nextLine();

        String[] tmp = input.replace(" ", "").split(",");
        int[] arr = new int[tmp.length];

        for (int i = 0; i < tmp.length; i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }

        return arr;
    }


}
