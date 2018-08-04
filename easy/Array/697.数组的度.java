/**
 * 题目来源:https://leetcode-cn.com/problems/degree-of-an-array/description/
 * 题目描述:
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。

 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

 示例 1:

 输入: [1, 2, 2, 3, 1]
 输出: 2
 解释:
 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 连续子数组里面拥有相同度的有如下所示:
 [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 最短连续子数组[2, 2]的长度为2，所以返回2.
 示例 2:

 输入: [1,2,2,3,1,4,2]
 输出: 6
 注意:

 nums.length 在1到50,000区间范围内。
 nums[i] 是一个在0到49,999范围内的整数。

 题目分类:Map操作，数组遍历
 */

/**
 * 方法一：首先遍历数组，记录每个数出现的频数；然后遍历频数最大的数，求最度相同的子数组的长度，取最小值（用时:121ms）
 * */
class Solution {
    public int findShortestSubArray(int[] nums) {
        int l=nums.length;
        Map<Integer,Integer> map= new HashMap<>();
        int maxcount=0;
        for(int i:nums){
            int count = map.containsKey(i)?map.get(i):0;
            map.put(i,count+1);
            maxcount=(maxcount<=(count+1))?(count+1):maxcount;
        }
        Set<Integer> maxnum=map.keySet();
        int mindis=Integer.MAX_VALUE;
        for(int i:maxnum){
            if(maxcount==map.get(i)){
                int a=0;int b=l-1;
                while(nums[a]!=i&&a<b){
                    a++;
                }
                while(nums[b]!=i&&a<b){
                    b--;
                }
                mindis=Math.min(mindis,b-a+1);
            }
        }
        return mindis;
    }
}

/**
 * 方法二：用空间换时间（用时：11ms）
 */
class Solution {
    public int findShortestSubArray(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            max = Math.max(max,i);
            min = Math.min(min,i);
        }
        //起点数组
        int[] start = new int[max-min+1];
        for(int i=0;i<start.length;i++)
        {
            start[i] = -1;
        }
        //跨度数组
        int[] length = new int[max-min+1];
        //该数出现的次数
        int[] times = new int[max-min+1];
        int maxNum = 0;
        for(int i=0;i<nums.length;i++)
        {
            int index = nums[i]-min;
            //更新出现的次数并找到出现次数的最大值
            times[index]++;
            maxNum = Math.max(maxNum,times[index]);
            //更新起点位置
            if(start[index]==-1){
                start[index]=i;
            }
            //更新区间长度
            length[index] = i-start[index]+1;
        }
        int res = nums.length;
        for(int i = 0;i<times.length;i++)
        {
            if(times[i]==maxNum&&length[i]!=0&&length[i]<res)
                res = length[i];
        }
        return res;
    }
}
