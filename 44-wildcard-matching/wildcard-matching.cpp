/* Implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 * Tags: Dynamic Programming, Backtracking, Greedy String
 * Similar Problems: (H) Regular Expression Matching
 */
class Solution {
public:
    bool isMatch(string s, string p) {
        int i = 0;
        int j = 0;
        int star = -1;
        int lastI = -1;
        while (i < s.length()) {
            if (j < p.length() && (s[i] == p[j] || p[j] == '?')) { ++i; ++j; }
            else if (j < p.length() && p[j] == '*') { star = j++; lastI = i; }
            else if (star != -1) { i = lastI++; j = star + 1; } // if can't find a match and currently have a current *, 
                                                                // restore pointer i and j and use * to consume s 
            else { return false; }
        }
        while (j < p.length() && p[j] == '*') { ++j; }
        return j == p.length();
    }
};