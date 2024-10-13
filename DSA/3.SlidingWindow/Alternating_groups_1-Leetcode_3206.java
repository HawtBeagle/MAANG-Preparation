class Solution {
  public int numberOfAlternatingGroups(int[] colors) {
    int left = 0, index = 1, right = 2;
    int ans = 0;
    while (left < colors.length) {
      right = (index + 1) % colors.length;
      index = index % colors.length;
      if (colors[index] != colors[left] && colors[index] != colors[right]) ans++;
      index++;
      left++;
    }
    return ans;
  }
}
