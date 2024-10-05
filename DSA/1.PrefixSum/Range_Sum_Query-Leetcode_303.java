class NumArray {

  int[] nums;

  public NumArray(int[] nums) {
    this.nums = nums;
    this.toPrefixArray(nums);
  }

  public int sumRange(int left, int right) {
    return left - 1 >= 0 ? nums[right] - nums[left - 1] : nums[right];
  }

  public void toPrefixArray(int[] nums) {
    int sumUptoThatIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      nums[i] += sumUptoThatIndex;
      sumUptoThatIndex = nums[i];
    }
  }
}
