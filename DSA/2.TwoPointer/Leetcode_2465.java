class Solution {
  public int distinctAverages(int[] nums) {
    Set<Double> set = new HashSet<>();
    Arrays.sort(nums);
    int left = 0, right = nums.length - 1;
    while (left < right) {
      set.add((double) (nums[left] + nums[right]) / 2);
      left++;
      right--;
    }
    return set.size();
  }
}
