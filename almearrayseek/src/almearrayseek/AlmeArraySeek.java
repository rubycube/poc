/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almearrayseek;

/**
 *
 * @author sabusreeraj
 */
public class AlmeArraySeek {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array1 = {2, 3, 4, 5, 4};
        int[] array2 = {4, 5};
        arraySearch(array1, array2);
    }

    public static boolean arraySearch(int[] array1, int[] array2) {
        if (validateArray(array1, array2)) {
            int position = search(array1, array2);
            if (position != -1) {
                System.out.println("Array 2 found in array 1 at position " + position);
                return true;
            } else {
                System.out.println("Array 2 not found in array 1");
            }
        } else {
            System.out.println("Array 2 should be smaller in size when compared to array 1!");
        }
        return false;
    }

    public static boolean validateArray(int[] array1, int[] array2) {
        return null != array1 && null != array2 && array2.length <= array1.length;
    }

    public static int search(int[] array1, int[] array2) {
        boolean match = true;
        int array2FirstElement = array2[0];
        int array2LastElement = array2[array2.length - 1];
        for (int i = 0; i < array1.length; i++) {
            if (array1.length > i + array2.length - 1) {
                if (array2FirstElement == array1[i] && array2LastElement == array1[i + array2.length - 1]) {
                    for (int j = 1; j < array2.length - 2; j++) {
                        if (array2[j] != array1[j]) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}
