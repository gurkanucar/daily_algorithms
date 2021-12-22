package day2_anagram;

import java.util.Scanner;

public class Main {

    //get 2 inputs then compare each other and if they are anagram, return true else false.
    // meat  -  team  --> return true
    // test  -  task  --> return false


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        System.out.println(isAnagram(input1, input2));

    }

    private static boolean isAnagram(String input1, String input2) {

        if (input1.length() != input2.length()) {
            return false;
        }

        char[] arr1 = convertToCharArray(input1);
        char[] arr2 = convertToCharArray(input2);

        mergeSort(arr1, arr1.length);
        mergeSort(arr2, arr2.length);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    private static void mergeSort(char[] a, int n) {
        if (n > 1) {
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

    private static char[] convertToCharArray(String input) {
        char[] arr = new char[input.length()];

        for (int i = 0; i < input.length(); i++) {
            arr[i] = input.charAt(i);
        }
        return arr;
    }


}
