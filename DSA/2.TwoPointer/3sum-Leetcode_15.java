class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    for (int i = 0; i < nums.length - 2; i++) {
      twoSum(nums, -(nums[i]), i + 1, set);
    }
    for (List<Integer> l : set) {
      ans.add(l);
    }
    return ans;
  }

  private void twoSum(int nums[], int target, int index, Set<List<Integer>> set) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = index; i < nums.length; i++) {
      int temp = nums[i];
      if (map.containsKey(target - temp)) {
        ArrayList<Integer> arr =
            new ArrayList<>(Arrays.asList(temp, target - temp, nums[index - 1]));
        Collections.sort(arr);
        set.add(arr);
      } else {
        map.put(temp, 1);
      }
    }
  }
}

// Solution optimal

class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    int i = 0;
    while (i < nums.length - 2) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        i++;
        continue;
      }
      int j = i + 1;
      int k = nums.length - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum < 0) {
          j++;
        } else if (sum > 0) {
          k--;
        } else {
          ans.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
          j++;
          k--;
          while (j < k && nums[j] == nums[j - 1]) j++;
          while (j < k && nums[k] == nums[k + 1]) k--;
        }
      }
      i++;
    }
    return ans;
  }
}
