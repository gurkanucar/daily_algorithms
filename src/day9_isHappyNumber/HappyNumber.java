package day9_isHappyNumber;

import java.util.HashSet;
import java.util.Scanner;

/*
    if sum equals to 1 of the algorithm, return true otherwise false
    input: n = 7 , output: true
    How ?
    7^2                 = 49
    4^2 + 9^2           = 97
    9^2 + 7^2           = 130
    1^2 + 3^2 + 0^2     = 10
    1^2 + 0^2 =         = 1


 */
public class HappyNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(isHappyNumber(scanner.nextInt()));
    }


    public static int sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }


    public static boolean isHappyNumber(int n) {
        final HashSet<Integer> set = new HashSet<>();
        int flag = n;
        while (true) {
            flag = sum(flag);
            if (flag == 1) {
                return true;
            } else if (set.contains(flag)) {
                break;
            } else {
                set.add(flag);
            }
        }
        return false;
    }

}
