class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    int len = p.length();
    int left = 0, right = 0;
    List<Integer> ans = new ArrayList<>();
    StringBuilder svalue = new StringBuilder();
    while (right <= s.length()) {
      if (right - left < len) {
        if (right == s.length()) break;
        svalue.append(s.charAt(right));
        right++;
        continue;
      }
      if (isAnagram(svalue, p)) ans.add(left);
      svalue.deleteCharAt(0);
      left++;
    }
    return ans;
  }

  private boolean isAnagram(StringBuilder temp, String p) {
    int value = 0;
    int[] ans = new int[26];
    for (int i = 0; i < p.length(); i++) {
      ans[temp.charAt(i) - 'a']++;
    }
    for (int i = 0; i < p.length(); i++) {
      ans[p.charAt(i) - 'a']--;
    }
    for (int i : ans) {
      if (i != 0) return false;
    }
    return true;
  }
}
