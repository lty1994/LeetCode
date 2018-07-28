/**
 * 题目来源:https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/description/
 * 题目描述:
 *  给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 *
 * 题目分类:数组
 */

class Solution {
    /**
     * 题目难点在于不使用额外空间和线性时间复杂度，通过对数组元素取反的方法对数组进行标记，借用数组下标
     * 未标记的数组元素的下标就是没有出现的数字
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int l=nums.length;
        List<Integer> tmp=new ArrayList<>();
        for(int i=0;i<l;i++){
            if(nums[Math.abs(nums[i])-1]>0) nums[Math.abs(nums[i])-1]=-1*nums[Math.abs(nums[i])-1];
        }
        for(int i=0;i<l;i++){
            if(nums[i]>0)
                tmp.add(i+1);
        }
        return tmp;
    }
}