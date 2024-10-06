class Solution {
  public boolean checkSubarraySum(int[] nums, int k) {
    int sumUptoThatIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      nums[i] += sumUptoThatIndex;
      sumUptoThatIndex = nums[i];
      nums[i] %= k;
    }
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i]) && i - map.get(nums[i]) >= 2) return true;
      else if (nums[i] == 0 && i >= 1) return true;
      if (!map.containsKey(nums[i])) {
        map.put(nums[i], i);
      }
    }
    return false;
  }
}
