class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int low=0;
        int high=(n*m)-1;
        while(low<=high)
        {
            int guess=(low+high)/2;
            int r=guess/m;
            int c=guess%m;
            if(matrix[r][c] == target){
                return true;
            }
            else if(matrix[r][c]> target)
            {
                high=guess-1;
            }
            else{
                low=guess+1;
            }
        }
        return false;
    }
}