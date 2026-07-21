class Solution {
    public int[] plusOne(int[] digits) {
        //loop for length of array from the last
        for (int i = digits.length - 1; i >= 0; i--){
            //condition if its less than 9 
            if (digits[i] < 9){
                //increase digits integer on index
                digits[i]++;
                // return array
                return digits;
            }
            //if index is 0 after increasing from 9 that became 10
            digits[i] = 0;
        }
        // add one more array space and put that 1 ahead of array
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }
}