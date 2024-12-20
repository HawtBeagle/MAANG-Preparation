class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> temp1 = new HashSet<>();
    HashSet<Integer> set = new HashSet<>();
    for (int i : nums1) {
      temp1.add(i);
    }
    for (int i : nums2) {
      if (temp1.contains(i)) set.add(i);
    }
    int[] ans = new int[set.size()];
    int index = 0;
    for (int i : set) ans[index++] = i;
    return ans;
  }
}
