import java.util.Map;

/**
 * Created by Chong AiZhen on 17-12-26,下午7:29.
 */

/*
Given a string s, find the longest palindromic(回文) substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.

Example:

Input: "cbbd"

Output: "bb"

所谓回文就是，指正读反读都能读通的句子。例如1234321就是一个回文数。
 */
public class _5LongestPalindromicSubstring {

    private static int lo, maxLen;

    public static void main(String[] args){
        System.out.println(longestPalindromicSubstring("abdbc"));
    }

    public static String longestPalindromicSubstring(String word) {
        int len = word.length();
        if (len<2)
            return word;
        for (int i=0;i<word.length()-1;i++){
            extendPalindrome(word,i,i);//aba这种情况，一个字母作为对称轴
            extendPalindrome(word,i,i+1);//abba这种情况
        }
        return word.substring(lo, lo+maxLen);
    }

    //该方法就是找一个中心，然后不断向两边扩散并判断字符是否相等
    public static void extendPalindrome(String word,int j,int k) {
        while (j>=0 && k<word.length()-1 && word.charAt(j)==word.charAt(k)) {
            j--;
            k++;
        }

        if (maxLen<k-j+1) {
            maxLen = k-j-1;//因为j--而k++
            lo=j+1;
        }

    }
}
