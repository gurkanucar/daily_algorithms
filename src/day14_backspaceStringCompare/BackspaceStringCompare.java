package day14_backspaceStringCompare;

import java.util.Scanner;
import java.util.Stack;

/*

    Given two strings s and t, return true
    if they are equal when both are typed into empty text editors.
     '#' means a backspace character.

    Note that after backspacing an empty text, the text will continue empty.



    Example 1:

    Input: s = "ab#c", t = "ad#c"
    Output: true
    Explanation: Both s and t become "ac".

 */

public class BackspaceStringCompare {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final String input1 = scanner.nextLine();
        final String input2 = scanner.nextLine();

        System.out.println(stringProcess(input1).equals(stringProcess(input2)));

    }

    public static String stringProcess(final String n) {
        Stack stack = new Stack();
        for (char c : n.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();

    }

}
