private class Solution {
  public int numSubarraysWithSum(int[] nums, int goal) {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    map.put(0, new ArrayList<Integer>());
    int ans = 0;
    int sumUptoThatIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      nums[i] += sumUptoThatIndex;
      sumUptoThatIndex = nums[i];
      if (nums[i] == goal) ans++;
      if (map.containsKey(nums[i] - goal)) {
        ArrayList<Integer> arr = map.get(nums[i] - goal);
        ans += arr.size();
      }
      ArrayList<Integer> temp;
      if (map.get(nums[i]) == null) {
        temp = new ArrayList<>();
      } else {
        temp = map.get(nums[i]);
      }
      temp.add(i);
      map.put(nums[i], temp);
    }
    return ans;
  }
}
