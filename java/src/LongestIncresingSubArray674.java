//Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
//
//        Example 1:
//        Input: [1,3,5,4,7]
//        Output: 3
//        Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
//        Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
//        Example 2:
//        Input: [2,2,2,2,2]
//        Output: 1
//        Explanation: The longest continuous increasing subsequence is [2], its length is 1.
//
//

public class LongestIncresingSubArray674 {
    public int findLengthOfLCIS(int[] nums) {
        int l=nums.length;
        if(l<2){return l;}
        int ans=1;
        int i=1;
        int cur=1;
        while (i<l){
            if(nums[i]>nums[i-1]){
                cur+=1;
            }else{
                ans=Math.max(ans , cur);
                cur=1;
            }
            i++;
        }
        return Math.max(ans , cur);
    }
}