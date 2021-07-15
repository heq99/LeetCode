package com.qiang.leetcode.top_interview_questions.array;

/*
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/770/
 * 
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * 
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * 
 * Example 1:
 * Input: matrix = [[1,2,3]
 *                 ,[4,5,6]
 *                 ,[7,8,9]]
 * Output: [[7,4,1]
 *         ,[8,5,2]
 *         ,[9,6,3]]
 * 
 * Example 2:
 * Input: matrix = [[ 5, 1, 9,11]
 *                 ,[ 2, 4, 8,10]
 *                 ,[13, 3, 6, 7]
 *                 ,[15,14,12,16]]
 * Output: [[15,13, 2, 5]
 *         ,[14, 3, 4, 1]
 *         ,[12, 6, 8, 9]
 *         ,[16, 7,10,11]]
 * 
 * Example 3:
 * Input: matrix = [[1]]
 * Output: [[1]]
 * 
 * Example 4:
 * Input: matrix = [[1,2]
 *                 ,[3,4]]
 * Output: [[3,1]
 *         ,[4,2]]
 * 
 * Constraints:
 *     matrix.length == n
 *     matrix[i].length == n
 *     1 <= n <= 20
 *     -1000 <= matrix[i][j] <= 1000
 */
public class RotateImage {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i=0; i<(n/2)+(n%2); i++) {
            for (int j=0; j<n/2; j++) {
                int x = i;
                int y = j;
                int temp = matrix[i][j];
                for (int k=0; k<3; k++) {
                    int newx = -y + (n-1);
                    int newy = x;
                    matrix[x][y] = matrix[newx][newy];
                    x = newx;
                    y = newy;
                }
                matrix[x][y] = temp;
            }
        }
    }

    public static String printMatrix(int[][] matrix) {
        StringBuffer s = new StringBuffer();
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                s.append(matrix[i][j]);
                if (j<matrix.length - 1) {
                    s.append(", ");
                }
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }

    public static void main(String args[]) {
        int[][] matrix1 = {{ 5, 1, 9,11}
                          ,{ 2, 4, 8,10}
                          ,{13, 3, 6, 7}
                          ,{15,14,12,16}};
        System.out.println(printMatrix(matrix1));
        rotate(matrix1);
        System.out.println(printMatrix(matrix1));

        int[][] matrix2 = {{1,2}
                          ,{3,4}};
        System.out.println(printMatrix(matrix2));
        rotate(matrix2);
        System.out.println(printMatrix(matrix2));

        int[][] matrix3 = {{1}};
        System.out.println(printMatrix(matrix3));
        rotate(matrix3);
        System.out.println(printMatrix(matrix3));
    }
}
