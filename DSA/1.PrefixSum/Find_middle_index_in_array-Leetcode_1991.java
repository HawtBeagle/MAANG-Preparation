class Solution {
  public int findMiddleIndex(int[] nums) {
    modifyArray(nums);
    for (int i = 0; i < nums.length; i++) {
      int leftsum = i == 0 ? 0 : nums[i - 1];
      int rightsum = nums[nums.length - 1] - nums[i];
      if (leftsum == rightsum) return i;
    }
    return -1;
  }

  private void modifyArray(int[] nums) {
    int sumUptoThatIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      nums[i] += sumUptoThatIndex;
      sumUptoThatIndex = nums[i];
    }
  }
}
