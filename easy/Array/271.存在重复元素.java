/**
题目来源:https://leetcode-cn.com/problems/contains-duplicate/description/
 题目描述:
     给定一个整数数组，判断是否存在重复元素。
 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

 题目分类:数组、集合
 */

class Solution {//用Java实现,建立一个Set找重即可.也可先排序再找重.
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> tmp=new HashSet<>();
        for(int i:nums){
            if(tmp.contains(i)) return true;
            else
                tmp.add(i);
        }
        return false;
    }
}