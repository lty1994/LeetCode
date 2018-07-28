/**
题目来源:https://leetcode-cn.com/problems/missing-number/description/
 题目描述:
 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

 示例 1:

 输入: [3,0,1]
 输出: 2
 示例 2:

 输入: [9,6,4,2,3,5,7,0,1]
 输出: 8
 说明:
 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?

 问题分类:求和、数组
 */

class Solution {//给定了数组元素范围，求和做差就能得到缺失的数字。题目本意应该是要求用线性时间排序（计数排序）。

    public int missingNumber(int[] nums) {
        int sum=0;
        for(int i:nums)
        {
            sum+=i;
        }
        return (nums.length*(nums.length+1)/2-sum);
    }
}