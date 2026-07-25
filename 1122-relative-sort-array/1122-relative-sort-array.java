class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        int k = 0;

        // Place elements according to arr2
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]) {
                    result[k] = arr1[j];
                    k++;
                    arr1[j] = -1; // Mark as used
                }
            }
        }

        // Remember where the remaining part begins
        int start = k;

        // Append remaining elements
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != -1) {
                result[k] = arr1[i];
                k++;
            }
        }

        //Selection Sort only the remaining part
        for (int i = start; i < result.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < result.length; j++) {
                if (result[j] < result[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = result[i];
            result[i] = result[minIndex];
            result[minIndex] = temp;
        }

        return result;
    }
}