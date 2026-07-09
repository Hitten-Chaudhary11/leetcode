class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        
        int[] sorted = heights.clone();
        
        // Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (sorted[j] > sorted[j + 1]) {
                    int temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                    swapped = true;
                }
            }
            
            if (!swapped) {
                break;
            }
        }
        
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (heights[i] != sorted[i]) {
                count++;
            }
        }
        
        return count;
    }
}