class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int row=n-1;
        int col=0;
        while(row>=0 && col<m)
        {
            int guess=matrix[row][col];
            if(guess==target)
            {
                return true;
            }
            else if(guess>target)
            {
                row--;
            }
            else{
                col++;
            }
        }
        return false;
    }
}