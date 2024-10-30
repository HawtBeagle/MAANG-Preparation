class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] ans=new int[n-k+1];
        int i=0,j=0;
        while(j<=nums.length){
            if(j-i<k){
                if(j==nums.length) break;
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
                j++;
                continue;
            }
            List<Pair> list=new ArrayList<>();
            for(int key: map.keySet()){
                list.add(new Pair(map.get(key),key));
            }
            Collections.sort(list,(Pair a,Pair b)->{
                if(a.first==b.first) return b.second-a.second;
                return b.first-a.first;
            });
            int sum=0;
            int uniq=0;
            for(Pair p: list){
                if(uniq>=x) break;
                sum+=p.first*p.second;
                uniq++;
            }
            ans[i]=sum;
            map.put(nums[i],map.get(nums[i])-1);
            i++;
        }
        return ans;
    }
}
