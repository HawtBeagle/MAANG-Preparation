class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int temp = nums[i];
      if (map.containsKey(temp)) {
        if (Math.abs(map.get(temp) - i) <= k) return true;
      }
      map.put(temp, i);
    }
    return false;
  }
}
