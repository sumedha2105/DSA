class Solution {
    int first(int[] a,int x)
    {
        int n=a.length;
        int low=0;
        int high=n-1;
        int res=-1;
        while(low<=high)
        {
            int guess=(low+high)/2;
            if(a[guess]<x)
            {
                low=guess+1;
            }
            else if(a[guess]>x)
            {
                high=guess-1;
            }
            else{
                res=guess;
                high=guess-1;
            }
        }
        return res;
    }
    int last(int[] a,int x)
    {
        int n=a.length;
        int low=0;
        int high=n-1;
        int res=-1;
        while(low<=high)
        {
            int guess=(low+high)/2;
            if(a[guess]<x)
            {
                low=guess+1;
            }
            else if(a[guess]>x)
            {
                high=guess-1;
            }
            else{
                res=guess;
                low=guess+1;
            }
        }
        return res;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        int first=first(nums,target);
        int last=last(nums,target);
        ans[0]=first;
        ans[1]=last;
        return ans;
        
    }
}