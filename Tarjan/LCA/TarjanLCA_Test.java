package Tarjan.LCA;

import java.util.Arrays;

public class TarjanLCA_Test {
    public static void main(String[] args) {
        TarjanLCA solution = new TarjanLCA();

    /*
            0
          /   \
         4     3
        /|\     \
       1 5 6     8
        / \
       2   7
     */

        int[] ans = solution.Tarjan(
                new int[][]{
                        {0, 4},
                        {0, 3},
                        {3, 8},
                        {4, 1},
                        {4, 5},
                        {4, 6},
                        {5, 2},
                        {5, 7}
                },
                new int[][]{
                        {2, 3},
                        {6, 7}
                },
                9, 0
        );

        System.out.println(Arrays.toString(ans));
    }


}
