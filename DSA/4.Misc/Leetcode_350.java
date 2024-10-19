class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> arr = new ArrayList<>();
    for (int i : nums1) map.put(i, map.getOrDefault(i, 0) + 1);
    for (int i : nums2) {
      if (map.containsKey(i) && map.get(i) >= 1) {
        arr.add(i);
        map.put(i, map.get(i) - 1);
      }
    }
    int[] ans = new int[arr.size()];
    int index = 0;
    for (int i : arr) ans[index++] = i;
    return ans;
  }
}
