package perfectNumber;

import java.util.Scanner;

/*
    Given an integer number, if is it a perfect number return true otherwise return false.

    Input: number = 28, Output: true
    Explanation: 28 = 1 + 2 + 4 + 7 + 14
    1, 2, 4, 7, and 14 are all divisors of 28.
 */


public class PerfectNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(isPerfectNumber(scanner.nextInt()));
    }

    public static boolean isPerfectNumber(final int number) {
        int sum = 1;
        if (number == 1)
            return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                sum += i + number / i;
        }
        return sum == number;
    }
}
