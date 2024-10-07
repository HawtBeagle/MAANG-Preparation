class Solution {
  public int maxScore(String s) {
    HashMap<Integer, Integer> map = new HashMap<>();
    populate(map, s);
    int ans = 0;
    for (int i = 0; i < s.length() - 1; i++) {
      int zeroes = i + 1 - map.get(i);
      int ones = map.get(s.length() - 1) - map.get(i);
      ans = Math.max(ans, zeroes + ones);
    }
    return ans;
  }

  private void populate(HashMap<Integer, Integer> map, String s) {
    int sumUptoThatIndex = 0;
    for (int i = 0; i < s.length(); i++) {
      int temp = s.charAt(i) - '0';
      temp += sumUptoThatIndex;
      sumUptoThatIndex = temp;
      map.put(i, sumUptoThatIndex);
    }
  }
}
