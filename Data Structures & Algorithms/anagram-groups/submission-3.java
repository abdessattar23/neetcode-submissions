class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for(int i =0; i < strs.length; i++){
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            String sorted = new String(array);
            result.putIfAbsent(sorted, new ArrayList<>());
            result.get(sorted).add(strs[i]);
        }

        return new ArrayList<>(result.values());
    }
}
