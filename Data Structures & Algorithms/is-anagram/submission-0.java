class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> seenS = new HashMap<>();
        Map<Character, Integer> seenT = new HashMap<>();
        if (s.length() == t.length()) {
            for (int i = 0; i < s.length(); i++) {
                Character c = s.charAt(i);
                if (seenS.get(c) != null) {
                    seenS.put(c, seenS.getOrDefault(c, 0) + 1);
                } else {
                    seenS.put(c, 1);
                }
            }
            for (int i = 0; i < t.length(); i++) {
                Character c = t.charAt(i);
                if (seenT.get(c) != null) {
                    seenT.put(c, seenT.getOrDefault(c, 0) + 1);
                } else {
                    seenT.put(c, 1);
                }
            }

            return seenS.equals(seenT);
        }
        return false;
    }
}