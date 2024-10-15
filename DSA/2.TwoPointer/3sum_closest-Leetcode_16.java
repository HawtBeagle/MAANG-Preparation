class Solution {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int i = 0, ans = Integer.MAX_VALUE;
    int diff = Integer.MAX_VALUE;
    while (i < nums.length - 2) {
      int j = i + 1, k = nums.length - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum < target) {
          if (Math.abs(target - sum) < diff) {
            diff = Math.abs(target - sum);
            ans = sum;
          }
          j++;
        } else if (sum > target) {
          if (Math.abs(target - sum) < diff) {
            diff = Math.abs(target - sum);
            ans = sum;
          }
          k = k - 1;
        } else {
          return sum;
        }
      }
      i++;
    }
    return ans;
  }
}
