class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0,right=0;
        int ans=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while(right<s.length()){
          char temp=s.charAt(right);
          if(!map.containsKey(temp)){
            map.put(temp,1); 
            ans=Math.max(ans,right-left+1);
            right++;
          }
          else if(map.get(temp)!=0){
            map.put(s.charAt(left),map.get(s.charAt(left))-1);
            left++;
          }
          else{
            map.put(temp,map.get(temp)+1);
            ans=Math.max(right-left+1,ans);
            right++;
          }
        }
    }
}
