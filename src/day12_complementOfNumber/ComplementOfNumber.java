package day12_complementOfNumber;

import java.util.Scanner;
/*

The complement of an integer is the integer you get when you
flip all the 0's to 1's and all the 1's to 0's in its binary representation.

For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer num, return its complement.

 */
public class ComplementOfNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(complement(scanner.nextInt()));
    }

    public static int complement(final int number) {

        char[] bytes = getBytes(number).toCharArray();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = bytes[i] == '1' ? '0' : '1';
        }

        return convertBytesToNumber(bytes);
    }

    public static String getBytes(int n) {
        StringBuilder bytes = new StringBuilder();

        while (n != 0) {
            bytes.insert(0, n % 2);
            n /= 2;
        }

        return bytes.toString();
    }

    public static int convertBytesToNumber(final char[] bytes) {
        int n = 0;
        int i = 0;
        for (int j = bytes.length - 1; j >= 0; j--) {
            if (bytes[j] == '1') {
                n += Math.pow(2, i);
            }
            i++;
        }
        return n;
    }

}
