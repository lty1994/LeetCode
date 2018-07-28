/*
题目来源：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
题目描述：
    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:

输入: [7,1,5,3,6,4]
输出: 7

示例 3:

输入: [7,6,4,3,1]
输出: 0

问题分类：分之策略、最大子数组
 */

class Solution {//对每日股价的增量为正的求和
    public int maxProfit(int[] prices) {
        int l=prices.length;
        if(l==0)return 0;//排空
        int[] get= new int[l-1];
        for(int i=0;i<l-1;i++){
            get[i]=prices[i+1]-prices[i];
        }
        int count=0;
        for(int i=0;i<l-1;i++){
            if(get[i]>0){
                count+=get[i];
            }
        }
        if(count<0)return 0;
        else return count;
    }
}

