class Solution {
  public int getCommon(int[] nums1, int[] nums2) {
    int left = 0, right = 0;
    while (left < nums1.length && right < nums2.length) {
      int temp1 = nums1[left];
      int temp2 = nums2[right];
      if (temp1 < temp2) left++;
      else if (temp1 > temp2) right++;
      else return temp1;
    }
    return -1;
  }
}
