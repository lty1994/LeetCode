/**
��Ŀ��Դ:https://leetcode-cn.com/problems/contains-duplicate/description/
 ��Ŀ����:
     ����һ���������飬�ж��Ƿ�����ظ�Ԫ�ء�
 ����κ�ֵ�������г����������Σ��������� true�����������ÿ��Ԫ�ض�����ͬ���򷵻� false��

 ��Ŀ����:���顢����
 */

class Solution {//��Javaʵ��,����һ��Set���ؼ���.Ҳ��������������.
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