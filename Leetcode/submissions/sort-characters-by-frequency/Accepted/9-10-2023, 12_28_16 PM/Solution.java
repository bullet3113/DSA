// https://leetcode.com/problems/sort-characters-by-frequency

class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        pair[] freq = new pair[130];
        for(int i = 0; i < 130; i++) freq[i] = new pair('!', -1);
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if(freq[c].ch == '!') freq[c] = new pair(c, 0);
            freq[c].f++;
        }

        Arrays.sort(freq, (a, b) -> {
            return b.f - a.f;
        });

        String ans = "";

        for(int i = 0; i < 130; i++) {
            char c = freq[i].ch;
            int f = freq[i].f;

            while(f > 0) {
                ans += c;
                f--;
            }
        }

        return ans;
    }
}

class pair {
    char ch;
    int f;

    public pair(char ch, int f) {
        this.ch = ch;
        this.f = f;
    }
}