class Solution {
  public void nextPermutation(int[] nums) {
    if (nums.length == 1) return;
    int last = nums.length - 1;
    int j = last - 1;
    while (j >= 0) {
      int t1 = nums[j], t2 = nums[j + 1];
      if (t1 < t2) {
        int x = j + 1;
        while (x <= last && nums[j] < nums[x]) {
          x++;
        }
        x--;
        int temp = nums[j];
        nums[j] = nums[x];
        nums[x] = temp;
        reverse(nums, j + 1, last);
        return;
      }
      j--;
    }
    reverse(nums, j + 1, last);
  }

  private void reverse(int[] nums, int l, int r) {
    while (l < r) {
      int temp = nums[l];
      nums[l] = nums[r];
      nums[r] = temp;
      l++;
      r--;
    }
  }
}
