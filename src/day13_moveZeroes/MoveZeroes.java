package day13_moveZeroes;

import java.util.Arrays;
import java.util.Scanner;

public class MoveZeroes {
    /*

    Given an integer array nums, move all 0's to the end of it
    while maintaining the relative order of the non-zero elements.

    Note that you must do this in-place without making a copy of the array.

    Input: nums = [0,1,0,3,12,0]
    Output: [1,3,12,0,0,0]


     */

    public static void main(String[] args) {

        moveZeroes(getInputs());

    }

    public static void moveZeroes(final int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
        printArray(nums);
    }

    public static void printArray(int[] nums) {

        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d ", nums[i]);
        }

    }


    public static int[] getInputs() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return Arrays.stream(input.replace(" ", "").split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
