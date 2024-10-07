class Solution {
  public int minSubArrayLen(int target, int[] nums) {
    modifyArray(nums);
    int ans = Integer.MAX_VALUE;
    int left = 0, right = 0;
    while (left < nums.length && right < nums.length) {
      int temp = left - 1 >= 0 ? nums[right] - nums[left - 1] : nums[right] - 0;
      if (temp >= target) {
        ans = Math.min(ans, right - left + 1);
        left++;
      } else right++;
    }
    return ans == Integer.MAX_VALUE ? 0 : ans;
  }

  private void modifyArray(int[] nums) {
    int sumUptoThatIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      nums[i] += sumUptoThatIndex;
      sumUptoThatIndex = nums[i];
    }
  }
}
