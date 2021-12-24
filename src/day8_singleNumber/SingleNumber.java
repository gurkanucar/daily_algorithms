package day8_singleNumber;

import java.util.Scanner;

/*
    Given a non-empty array of integers nums,
  every element appears twice except for one.
  Find that single one.
  Input: nums = [5,7,5]  =>   Output: 7
  */
public class SingleNumber {

    public static void main(String[] args) {

        int[] arr = getInputsFromConsole();
        System.out.println(findSingleNumber(arr));
    }

    public static int findSingleNumber(int[] arr) {
        int tmp = 0;
        for (int j : arr) {
            tmp ^= j;
        }
        return tmp;
    }


    public static int[] getInputsFromConsole() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("please put \",\" for seperate items");

        String input = scanner.nextLine();

        int[] arr = new int[input.split(",").length];

        int index = 0;
        for (var element : input.split(",")) {
            arr[index++] = Integer.parseInt(element);
        }
        return arr;
    }

}
