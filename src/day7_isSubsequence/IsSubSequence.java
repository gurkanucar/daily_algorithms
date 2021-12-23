package day7_isSubsequence;

import java.util.Scanner;


// Find the subsequence of given two strings. Return true if x is a subsequence of y, or false otherwise.
// abcde => bd  = true
// xyz =>  zy = false
// qwerty => qwu = false

public class IsSubSequence {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String y = scanner.nextLine(); // sequence
        String x = scanner.nextLine(); // searched subsequence

        System.out.println(isSubSequence(y, x));

    }

    public static boolean isSubSequence(String sequence, String searchedSequence) {

        char[] sequenceArr = sequence.toCharArray();
        char[] searchedSequenceArr = searchedSequence.toCharArray();

        int counter = 0;
        for (int i = 0, j = 0; i < sequenceArr.length; i++) {
            if (j < searchedSequenceArr.length && sequenceArr[i] == searchedSequenceArr[j]) {
                j++;
                counter++;
            }
        }

        return counter == searchedSequenceArr.length;
    }


}
