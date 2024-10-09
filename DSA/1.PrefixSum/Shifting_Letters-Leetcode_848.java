class Solution {
  public String shiftingLetters(String s, int[] shifts) {
    modifyArray(shifts);
    StringBuilder sb = new StringBuilder("");
    for (int i = 0; i < s.length(); i++) {
      int val =
          i - 1 >= 0 ? shifts[shifts.length - 1] - shifts[i - 1] : shifts[shifts.length - 1] - 0;
      val = val % 26;
      System.out.println(val);
      sb.append((char) (((s.charAt(i) - 'a' + val) % 26) + 'a'));
    }
    return sb.toString();
  }

  private void modifyArray(int[] shifts) {
    int sumUptoThatIndex = 0;
    for (int i = 0; i < shifts.length; i++) {
      shifts[i] %= 26;
      shifts[i] = (shifts[i] + sumUptoThatIndex);
      sumUptoThatIndex = shifts[i];
    }
  }
}
