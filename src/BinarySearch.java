import java.util.Arrays;
import java.util.Collections;

public class BinarySearch {
    public static void main(String[] args) {
        int[] sortedArr = new int[]{0,1,2,3,4,5,6,7,8,9};
        System.out.println("Iteratively search: " +
                runBinarySearchIteratively(sortedArr, 3, 0, sortedArr.length - 1));
        System.out.println("Recursively search: " +
                runBinarySearchRecursively(sortedArr, 3, 0, sortedArr.length - 1));
    }

//    Arrays.binarySearch(sortedArray, key);
//    Collections.binarySearch(sortedList, key);
    public static int runBinarySearchIteratively(
            int[] sortedArray, int key, int low, int high) {
        int index = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low  + ((high - low) / 2);
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public static int runBinarySearchRecursively(
            int[] sortedArray, int key, int low, int high) {
        int middle = low  + ((high - low) / 2);

        if (high < low) {
            return -1;
        }

        if (key == sortedArray[middle]) {
            return middle;
        } else if (key < sortedArray[middle]) {
            return runBinarySearchRecursively(
                    sortedArray, key, low, middle - 1);
        } else {
            return runBinarySearchRecursively(
                    sortedArray, key, middle + 1, high);
        }
    }
}