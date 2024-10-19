class Solution {
  public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
    int i = 0;
    while (i < nums.length - indexDifference) {
      int j = i + indexDifference;
      while (j < nums.length) {
        int temp = Math.abs(nums[i] - nums[j]);
        if (temp >= valueDifference) return new int[] {i, j};
        j++;
      }
      i++;
    }
    return new int[] {-1, -1};
  }
}
