/**
 * 题目来源:https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/description/
 * 题目描述:
 *  给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * 题目分类:数组、遍历
 **/

/**
 * 做法一:用映射,HashMap.
 **/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=numbers.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<l;i++){
            if(map.containsKey(target-numbers[i])){
                return new int[]{map.get(target-numbers[i]),i+1};
            }
            map.put(numbers[i],i+1);
        }
        return null;
    }
}

/**
 * 做法二:添加两个标志位,两边向中遍历.
 **/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        int res[] = new int[2];

        while(left < right)
        {
            // find two numbers
            if((numbers[left] + numbers[right]) == target)
            {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            }
            else if((numbers[left] + numbers[right]) > target) // if greater, right moves to left 1 place
                right--;
            else // if less, left moves to right 1 place
                left++;

        }

        return res;
    }
}