class Solution {
  public double findMaxAverage(int[] nums, int k) {
    int left = 0, right = 0;
    double ans = Integer.MIN_VALUE, sum = 0;
    while (right < nums.length) {
      if (right - left + 1 < k) {
        sum += nums[right++];
      } else {
        sum += nums[right++];
        ans = (double) Math.max(ans, (double) sum / k);
        sum -= nums[left++];
      }
    }
    return ans;
  }
}
