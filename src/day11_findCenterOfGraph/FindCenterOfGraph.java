package day11_findCenterOfGraph;

import java.util.Scanner;

/*
    Find Center of Star Graph
    Input: edges = [[1,2],[2,3],[4,2]]
    Output: 2
    Explanation: As shown in the figure above, node 2 is connected to every other node, so 2 is the center.

 */


public class FindCenterOfGraph {

    public static void main(String[] args) {

        System.out.println(findCenter(getInputs()));

    }

    public static int findCenter(final int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }

    public static int[][] getInputs() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("use \"space\" for sperate items of list in list.");
        System.out.println("use \",\" for sperate items of outer list.");

        String input = scanner.nextLine();

        String[] outerItems = input.split(",");
        int[][] arr = new int[outerItems.length][outerItems.length];

        for (int i = 0; i < outerItems.length; i++) {
            String[] tmp = outerItems[i].split(" ");
            for (int j = 0; j < tmp.length; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
            }

        }

        return arr;
    }


}

