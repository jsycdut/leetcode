/**
 * 剑指offer第一题
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class Solution {
    public boolean Find(int target, int [][] array) {
	// 一定要利用题目信息，就是大小规律
	// 从数组左下角开始查找，若小于target，只能向右走，大于则只能向上走
	// 不要从其他三个角开始查找，这样在大于或者小于的情况下有两种走法，没法确定走哪种
        int row = array.length - 1;
        int column = 0;
        while (row >=0 && column <array[0].length) {
            if (array[row][column] < target) {
                column++;
            }else if (array[row][column] > target) {
                row--;
            }else{
                return true;
            }
        }
        return false;
    }

}
