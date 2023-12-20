// https://leetcode.com/problems/string-to-integer-atoi

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        return helper(s, "", false, s.length());   
    }

    int helper(String up, String p, boolean isNegative, int len) {
        if(up.isEmpty()) {
            int ans = returnAns(isNegative, p);
            return ans;
        }

        char ch = up.charAt(0);
        if(p.length() <= 10) {
            if(ch == '0' && p.length() == 0) {
                 return helper(up.substring(1), p, isNegative, len);
            } else if(ch == 45 && up.length() == len) {
                isNegative = true;
                // up = up.substring(1);
                return helper(up.substring(1), p, isNegative, len);
            } else if(ch == 43 && up.length() == len) {
                // isNegative = true;
                // up = up.substring(1);
                return helper(up.substring(1), p, isNegative, len);
            } else if(ch < 48 || ch > 57 && up.length() == len) {
                // return 0;
                return helper("", p, isNegative, len);
            } else if(ch < 48 || ch > 57 && up.length() != len) {
                // int ans = returnAns(isNegative, p);
                // return ans;    
                return helper("", p, isNegative, len);
            }
        } else {
            // int ans = returnAns(isNegative, p);
            // return ans;
            return helper("", p, isNegative, len);
        }
        // if(p.length() > 0);
        // int temp = (int)((p.charAt(p.length()-1)) - '0');

        return helper(up.substring(1), p + ch, isNegative, len);
    }

    int returnAns(boolean check, String p) {
        
        if(check) {
            if(p.length() == 0) {
                return 0;
            } else if(p.length() <= 10) {
                // return -(Integer.parseInt(p));
                Long t = Long.parseLong(p);
                return -(t.intValue());
            } else {
                return Integer.MIN_VALUE;
            }
        } else {
            if(p.length() == 0) {
                return 0;
            } else if(p.length() <= 10) {
                return (Integer.parseInt(p));
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }
}