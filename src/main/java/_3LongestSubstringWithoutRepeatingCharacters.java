import java.util.HashMap;

/**
 * Created by Chong AiZhen on 17-12-4,下午2:04.
 */

/*
Given a string, find the length of the longest substring without repeating（重复） characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
"pwke" is a subsequence and not a substring.
 */
public class _3LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("qwewrs"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        //对字符串进行遍历
        for (int i=0, j=0; i<s.length(); ++i){
            //如果map中包含这个字符（）
            if (map.containsKey(s.charAt(i))){
                //j为"j"和"map中存储的此字符的下标+1"的最大值
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            //map添加字符和字符的下标（只会保留最后一次字符出现的下标）
            map.put(s.charAt(i),i);
            //max为"max"和"i-j+1"的最大值
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}
