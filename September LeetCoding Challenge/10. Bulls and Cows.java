/*

You are playing the Bulls and Cows game with your friend.

You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:

The number of "bulls", which are digits in the guess that are in the correct position.
The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.

The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.
*/

class Solution {
    public String getHint(String secret, String guess) {
        int i,bull=0,cow=0,range = secret.length();
        String res="";
        int [] freq_s = new int[10];
        int [] freq_g = new int[10];
        for(i=0;i<range;i++){
            if(secret.charAt(i)==guess.charAt(i))
                bull++;
            freq_s[secret.charAt(i)-'0']++;
            freq_g[guess.charAt(i)-'0']++;
        }
        for( i=0;i<10;i++){
            cow+=Math.min(freq_s[i],freq_g[i]);
        }
        cow-=bull;
        res= bull+"A"+cow+"B";
        return res;
    }
}
