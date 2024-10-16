class Solution {
  public String mergeAlternately(String word1, String word2) {
    int left = 0, right = 0;
    StringBuilder sb = new StringBuilder();
    while (left < word1.length() && right < word2.length()) {
      sb.append(word1.charAt(left));
      sb.append(word2.charAt(right));
      left++;
      right++;
    }
    if (left == word1.length()) {
      while (right < word2.length()) sb.append(word2.charAt(right++));
    } else while (left < word1.length()) sb.append(word1.charAt(left++));
    return sb.toString();
  }
}
