package q2_anagram;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    //get 2 inputs then compare each other and if they are anagram, return true else false.
    // para  -  rapa  --> return true
    // test  -  task  --> return false

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        System.out.println(isAnagram(input1, input2));

    }

    public static boolean isAnagram(String input1, String input2) {

        if (input1.length() != input2.length()) {
            return false;
        }

        char[] input1Arr = convertStringToCharArray(input1);
        char[] input2Arr = convertStringToCharArray(input2);

        mergeSort(input1Arr, input1Arr.length);
        mergeSort(input2Arr, input2Arr.length);

        for (int i = 0; i < input1Arr.length; i++) {
            if (input1Arr[i] != input2Arr[i]) {
                return false;
            }
        }

        return true;
    }

    public static char[] convertStringToCharArray(String data) {
        char[] temp = new char[data.length()];

        for (int i = 0; i < data.length(); i++) {
            temp[i] = data.charAt(i);
        }

        return temp;
    }

    public static void mergeSort(char[] a, int n) {
        if (n < 2)
            return;

        int mid = n / 2;

        char[] l = new char[mid];
        char[] r = new char[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }

        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }

        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);


    }

    private static void merge(char[] a, char[] l, char[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if ((int) l[i] <= (int) r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }


}
