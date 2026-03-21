class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        
        int low = 0, high = m;
        
        while (low <= high) {
            
            int cut1 = (low + high) / 2;
            int cut2 = (m + n + 1) / 2 - cut1;
            
           
            int lft1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int lft2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            
         
            int ryt1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
            int ryt2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];
            
            
            if (lft1 <= ryt2 && lft2 <= ryt1) {
                
               
                if ((m + n) % 2 == 0) {
                    return (Math.max(lft1, lft2) + Math.min(ryt1, ryt2)) / 2.0;
                } 
               
                else {
                    return Math.max(lft1, lft2);
                }
            }
            
            
            else if (lft1 > ryt2) {
                high = cut1 - 1;
            } 
          
            else {
                low = cut1 + 1;
            }
        }
        
        return 0.0;
    }
}