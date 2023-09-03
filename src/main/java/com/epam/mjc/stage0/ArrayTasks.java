package com.epam.mjc.stage0;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        String seasons[] = {
                "winter",
                "spring",
                "summer",
                "autumn"
        };
        return seasons;
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = i +1;
        }
        return result;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s+= arr[i];
        }

        return s;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        for (int i =  0; i < arr.length; i++) {
            if (number == arr[i]) return i;
        }

        return -1;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        String[] reversed = new String[arr.length];
        int counter = 0;
        for (int i = arr.length -1; i >= 0; i--) {
            reversed[i] = arr[counter];
            counter++;
        }
        return reversed;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                counter++;
            }
        }

        int[] positive = new int[counter];

        counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                positive[counter] = arr[i];
                counter++;
            }
        }
        return positive;
    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public static int[][] sortRaggedArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length - 1; j++) {
                int min_i = j;
                for (int k = j + 1; k < arr[i].length; k++) {
                    if (arr[i][k] < arr[i][min_i])
                        min_i = k;
                }

                int temp = arr[i][min_i];
                arr[i][min_i] = arr[i][j];
                arr[i][j] = temp;
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].length < arr[min_index].length)
                    min_index = j;
            }

            int[] temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {

        int[][] arr = new int[5][];
        arr[0] = new int[]{-299, 759};
        arr[1] = new int[]{-517, 594, 781};
        arr[2] = new int[]{-974, -313, -267, 18};
        arr[3] = new int[]{135, 532, 600, 952};
        arr[4] = new int[]{-495, 361, 376, 711};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println();

        }
        System.out.println("------");
        sortRaggedArray(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println();

        }


//        arr[0] = new int[]{5, 0, 1, -1, 12, 44};
//        sortRaggedArray(arr);
//
//        for (int i = 0; i < arr[0].length; i++) {
//            System.out.println(arr[0][i]);
//        }
//        int [] f = new int[]{5, 0, 1, -1, 12, 44};
//        for (int i = 0; i < f.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (f[j] > f[j+1]) {
//                    int l = f[j];
//                    f[j] = f[j+1];
//                    f[j+1] = l;
//                }
//            }
//        }

//        for (int i = 0; i < f.length; i++) {
//            System.out.println(f[i]);
//        }

    }
}
