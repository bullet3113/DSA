// https://leetcode.com/problems/find-resultant-array-after-removing-anagrams

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> list = new ArrayList<>();
        int n = words.length;
        boolean[] vis = new boolean[n];

        for(int i = 0; i < n; i++) {
            Map<Character, Integer> map = new HashMap<>();
            if(!vis[i]) {
                String word = words[i];
                for(int j = 0; j < word.length(); j++) {
                    char ch = word.charAt(j);
                    map.put(ch, map.getOrDefault(ch, 0) + 1);
                }
                vis[i] = true;
                list.add(word);
            }

            for(int j = i + 1; j < n; j++) {
                if(vis[j]) continue;
                Map<Character, Integer> temp = new HashMap<>();
                String word = words[j];
                for(int k = 0; k < word.length(); k++) {
                    char ch = word.charAt(k);
                    temp.put(ch, temp.getOrDefault(ch, 0) + 1);
                }

                if(map.equals(temp)) vis[j] = true;
            }
        }
        return list;
    }
}