class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<String>> groups = new HashMap<>((int) (n / 0.75f) + 1);

        int maxLen = 0;
        for (String s : strs) if (s.length() > maxLen) maxLen = s.length();

        char[] buf = new char[maxLen];
        int[] count = new int[26];

        for (String s : strs) {
            int len = s.length();
            for (int i = 0; i < len; i++) count[s.charAt(i) - 'a']++;

            int pos = 0;
            for (int c = 0; c < 26; c++) {
                int cnt = count[c];
                if (cnt != 0) {
                    Arrays.fill(buf, pos, pos + cnt, (char) ('a' + c));
                    pos += cnt;
                    count[c] = 0;
                }
            }

            String key = new String(buf, 0, len);
            List<String> bucket = groups.get(key);
            if (bucket == null) {
                bucket = new ArrayList<>();
                groups.put(key, bucket);
            }
            bucket.add(s);
        }
        return new ArrayList<>(groups.values());
    }
}