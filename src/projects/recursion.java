package projects;

import java.util.List;

public class recursion {

    /*
    Find the index of an item in a list using recursion.

    Implement a function that takes in an item and an array of items, and returns the 0-based index of a
    sought item: >>> recursive_search(“hey”, [“hey”, “there”, “you”]) 0

    If the item isn’t in the list, return -1: >>> recursive_search(“porcupine”, [“hey”, “there”, “you”]) -1
     */

    public static int findIndex(int sought, int[] input, int index) {
        return findIndexRecursively(sought, input, 0);
    }

    public static int findIndexRecursively(int sought, int[] input, int index) {

        int result = -1;

        if (input == null) {
            return result;
        }

        if (sought == input[index]) {
            return index;
        }
        return findIndex(sought, input, index + 1);
    }

}
