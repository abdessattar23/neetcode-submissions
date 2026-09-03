class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            result.putIfAbsent(sorted, new ArrayList<>());
            result.get(sorted).add(s);
        }

        return new ArrayList<>(result.values());
    }
}
