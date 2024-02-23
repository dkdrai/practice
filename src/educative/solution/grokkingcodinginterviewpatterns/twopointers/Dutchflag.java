package educative.solution.grokkingcodinginterviewpatterns.twopointers;

import java.util.*;

/*
* Solution summary
To recap, the solution to this problem can be divided into five main parts:

We traverse the array using three pointers, red, white, and blue.

If the element pointed to by the white pointer is
0
0
, we swap it with the element pointed to by the red pointer if it’s not pointing to
0
0
, and increment both the red and white pointers.

If the element pointed to by the white pointer is
1
1
, we increment the white pointer.

If the element pointed to by the white pointer is
2
2
, we swap it with the element pointed to by the blue pointer if it’s not pointing to
2
2
 and decrement the blue pointer.

The array is sorted when the blue pointer becomes less than the white pointer.*/
public class Dutchflag {
    public static int[] sortColors(int[] colors) {

        int red = 0;
        int white = 0;
        int blue = colors.length - 1;

        while (white <= blue) {

            if (colors[white] == 0) {

                if (colors[red] != 0) {
                    int temp = colors[red];
                    colors[red] = colors[white];
                    colors[white] = temp;
                }

                white++;
                red++;
            } else if (colors[white] == 1) {
                white++;
            } else {
                if (colors[blue] != 2) {
                    int temp = colors[white];
                    colors[white] = colors[blue];
                    colors[blue] = temp;
                }

                blue--;
            }
        }

        return colors;
    }

    // Driver code
    public static void main(String[] args) {
        int[][] inputs = {
                {0, 1, 0},
                {1, 1, 0, 2},
                {2, 1, 1, 0, 0},
                {2, 2, 2, 0, 1, 0},
                {2, 1, 1, 0, 1, 0, 2}
        };

        for (int i = 0; i < inputs.length; i++) {
            sortColors(inputs[i]);
            for (int j = 0; j < inputs[i].length; j++) {
                System.out.print(inputs[i][j]);
                System.out.print(" ");
            }
            System.out.println();

        }
    }
}