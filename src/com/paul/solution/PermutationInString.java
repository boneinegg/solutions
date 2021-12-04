package com.paul.solution;

/**
 * https://leetcode-cn.com/problems/permutation-in-string/
 */
public class PermutationInString {
    public static void main(String[] args) {
        PermutationInString pis = new PermutationInString();
        System.err.println(pis.checkInclusion("ab", "eibaooo"));
        System.err.println(pis.checkInclusion("abcdxabcde",
                "abcdeabcdx"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] need = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            need[s1.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int j = 0; j < 26; j++) {
            if (need[j] > 0) {
                count++;
            }
        }
        int left = 0, right = 0, index;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right++);
            index = c - 'a';
            if (need[index] > 0) {
                window[index]++;
                if (window[index] == need[index]) {
                    valid++;
                }
            }
            while (valid == count) {
                if (right - left == s1.length()) {
                    return true;
                }
                char d = s2.charAt(left++);
                index = d - 'a';
                if (need[index] > 0) {
                    if (window[index] == need[index]) {
                        valid--;
                    }
                    window[index]--;
                }
            }
        }
        return false;
    }
}
