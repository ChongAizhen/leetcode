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
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                //以上面的"qwewrs"为例，当i=1时，s.charAt(i)为w，则当i=3时，w出现了重复，所以说子字符串可以从e重新开始计算，于是令j=2
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            //map添加字符和字符的下标（相同的字符只会保留最后一次字符出现的下标）
            map.put(s.charAt(i),i);
            //i-j+1为新一轮的子字符串的长度
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}
