package q1_palindrome;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    // check the input then return true if it's palindrome, else return false


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        //1234321
        System.out.println(isPalindrome(input));

    }


    public static boolean isPalindrome(String input) {

        Stack stack = new Stack();

        if (input.length() < 2) {
            return false;
        }

        for (int i = 0; i < input.length(); i++) {
            if (i < input.length() / 2) {
                stack.push(input.charAt(i));
            } else {

                if (stack.peek().equals(input.charAt(i))) {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }


}
