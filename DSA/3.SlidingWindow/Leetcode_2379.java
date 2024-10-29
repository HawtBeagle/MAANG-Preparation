class Solution {
  public int minimumRecolors(String blocks, int k) {
    int ans = Integer.MAX_VALUE;
    int count = 0;
    for (int i = 0; i < k; i++) {
      char temp = blocks.charAt(i);
      if (temp == 'W') count++;
    }
    ans = Math.min(ans, count);
    int left = 0, right = k;
    while (right < blocks.length()) {
      char l = blocks.charAt(left);
      char r = blocks.charAt(right);
      if (l == 'W') count--;
      if (r == 'W') count++;
      ans = Math.min(ans, count);
      left++;
      right++;
    }
    return ans;
  }
}
