class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            
            for (int j = 0; j <= i; j++) {
                // The first and last elements of every row are always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Find the sum of the two elements directly above it
                    int num1 = triangle.get(i - 1).get(j - 1);
                    int num2 = triangle.get(i - 1).get(j);
                    row.add(num1 + num2);
                }
            }
            
            triangle.add(row);
        }

        return triangle;
    }
}