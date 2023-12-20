// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        // getting the total points
        int totalPoints = 0;
        for(int point: cardPoints) totalPoints += point;

        int j = 0;
        int i = 0;
        int n = cardPoints.length;
        if(n == k) return totalPoints;
        k = n - k;
        int currSum = 0;
        int max = -1;

        while(i < n) {
            int val = cardPoints[i];
            currSum += val;

            int currWindowSize = i - j + 1;
            
            if(currWindowSize > k) {
                currSum -= cardPoints[j];
                j++;
            }

            if(currWindowSize == k)
            max = Math.max(max, totalPoints - currSum);
            i++;
        }

        return max;
    }
}

// n = cards;
// a[i] = cardpoints

// In one step a card can be chosen from start or end
// only k cards can be chosen

// score  = sum of card points chosen

// return max score