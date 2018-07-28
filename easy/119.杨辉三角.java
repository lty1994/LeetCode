/**
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
在杨辉三角中，每个数是它左上方和右上方的数的和。
  1
1   1
````
示例:

输入: 3
输出: [1,3,3,1]
**/
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> tmp = new ArrayList<Integer>();
        for(int i=0;i<=rowIndex;i++){
            tmp.add(1);
            for(int j=i-1;j>=1;j--){
                tmp.set(j,tmp.get(j)+tmp.get(j-1));
            }
            
        }
        return tmp;
    }
}

