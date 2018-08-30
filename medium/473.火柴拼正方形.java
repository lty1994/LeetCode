/**
 * 题目来源:https://leetcode-cn.com/problems/matchsticks-to-square/description/
 * 题目描述:
 * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
 *
 * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,2,2]
 * 输出: true
 *
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * 示例 2:
 *
 * 输入: [3,3,3,3,4]
 * 输出: false
 *
 * 解释: 不能用所有火柴拼成一个正方形。
 * 注意:
 *
 * 给定的火柴长度和在 0 到 10^9之间。
 * 火柴数组的长度不超过15。
 */

class Solution {
    public boolean makesquare(int[] nums) {
        if(nums.length<4)return false;
        int _long=0;
        for(int i : nums){
            _long+=i;
        }
        if(_long%4!=0){return false;}
        else _long=_long/4;
        int[] side = {0,0,0,0};
        return dfs(nums,side,0,_long);
    }

    boolean dfs(int[] nums,int[] side,int index,int _long){
        if(index==nums.length){
            for(int i:side){
                if(i!=_long) return false;
            }
            return true;
        }
        else{
            for(int j=0;j<4;j++){
                if(side[j]+nums[index]>_long){continue;}
                side[j]+=nums[index];
                if(dfs(nums,side,index+1,_long)){
                    return true;
                }
                side[j]-=nums[index];
            }
        }
        return false;
    }
}