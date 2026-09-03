class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer n : nums){
            if(!map.containsKey(n)){
                map.put(n, 1);
            }else{
                map.put(n, map.get(n)+1);
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < k; i++){
            result.add(Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey());
            map.remove(Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey());
        }

        return result.stream().mapToInt(i->i).toArray();
    }
}
