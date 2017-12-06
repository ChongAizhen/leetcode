import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers, return indices(索引) of the two numbers such that they add up to a specific（特定的） target.

You may assume（假设） that each input would have exactly（只有） one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 13,

Because nums[0] + nums[2] = 2 + 11 = 13,
return [0, 2].
 */
public class _1TwoSum {
    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 13;
        twoSum(nums,target);
    }

    //用map来存储曾经遍历过的数值
    public static int[] twoSum(int[] nums,int target){
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(target-nums[i])){
                result[1]=i;
                result[0]=map.get(target-nums[i]);
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}
