/**
��Ŀ��Դ:https://leetcode-cn.com/problems/missing-number/description/
 ��Ŀ����:
 ����һ������ 0, 1, 2, ..., n �� n ���������У��ҳ� 0 .. n ��û�г����������е��Ǹ�����

 ʾ�� 1:

 ����: [3,0,1]
 ���: 2
 ʾ�� 2:

 ����: [9,6,4,2,3,5,7,0,1]
 ���: 8
 ˵��:
 ����㷨Ӧ��������ʱ�临�Ӷȡ����ܷ��ʹ�ö��ⳣ���ռ���ʵ��?

 �������:��͡�����
 */

class Solution {//����������Ԫ�ط�Χ�����������ܵõ�ȱʧ�����֡���Ŀ����Ӧ����Ҫ��������ʱ�����򣨼������򣩡�

    public int missingNumber(int[] nums) {
        int sum=0;
        for(int i:nums)
        {
            sum+=i;
        }
        return (nums.length*(nums.length+1)/2-sum);
    }
}