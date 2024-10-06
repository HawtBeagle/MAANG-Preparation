class Solution {
  public int subarraySum(int[] nums, int k) {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    int sum = 0, ans = 0;
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(-1);
    map.put(sum, arr);
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (map.containsKey(sum - k)) {
        ans += map.get(sum - k).size();
      }
      ArrayList<Integer> temp;
      if (map.get(sum) == null) {
        temp = new ArrayList<>();
      } else {
        temp = map.get(sum);
      }
      temp.add(i);
      map.put(sum, temp);
    }
    return ans;
  }
}
