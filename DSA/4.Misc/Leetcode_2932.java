class Solution {
  public int maximumStrongPairXor(int[] nums) {
    int ans = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j < nums.length; j++) {
        if (isStrongPair(nums[i], nums[j])) ans = Math.max(ans, nums[i] ^ nums[j]);
      }
    }
    return ans;
  }

  private boolean isStrongPair(int a, int b) {
    return Math.abs(a - b) <= Math.min(a, b);
  }
}
