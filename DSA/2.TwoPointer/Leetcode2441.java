// Solution 1
class Solution {
  public int findMaxK(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    int ans = -1;
    for (int i : nums) {
      if (set.contains(-i)) {
        ans = Math.max(ans, Math.abs(i));
      }
      set.add(i);
    }
    return ans;
  }
}

// Solution 2
class Solution {
  public int findMaxK(int[] nums) {
    Arrays.sort(nums);
    int i = 0, j = nums.length - 1;
    while (i < j) {
      int sum = nums[i] + nums[j];
      if (sum == 0) return Math.abs(nums[i]);
      else if (sum < 0) i++;
      else j--;
    }
    return -1;
  }
}
