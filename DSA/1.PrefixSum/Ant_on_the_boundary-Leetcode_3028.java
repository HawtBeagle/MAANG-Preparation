class Solution {
  public int returnToBoundaryCount(int[] nums) {
    int sum = 0, ans = 0;
    for (int i = 0; i < nums.length; i++) {
      nums[i] += sum;
      sum = nums[i];
      if (sum == 0) ans++;
    }
    return ans;
  }
}
