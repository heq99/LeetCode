package com.qiang.leetcode.top_interview_questions.array;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/
 * 
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *     Each row must contain the digits 1-9 without repetition.
 *     Each column must contain the digits 1-9 without repetition.
 *     Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * 
 * Note:
 * 
 *     A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 *     Only the filled cells need to be validated according to the mentioned rules.
 * 
 * Example 1:
 * Input: board = 
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 * 
 * Example 2:
 * Input: board = 
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * 
 * Constraints:
 *     board.length == 9
 *     board[i].length == 9
 *     board[i][j] is a digit or '.'.
 */
public class ValidSudoku {
    
    public static boolean isValidSudoku(char[][] board) {
        for (int i=0; i<9; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> cell = new HashSet<>();
            for (int j=0; j<9; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j])) {
                    System.out.println("row: " + i + ", " + j + " = " + board[i][j]);
                    return false;
                }
                if (board[j][i] != '.' && !col.add(board[j][i])) {
                    System.out.println("col: " + j + ", " + i + " = " + board[j][i]);
                    return false;
                }
                if (board[(i/3*3)+(j%3)][(j/3)+(i%3)*3] != '.' &&
                   (!cell.add(board[(i/3*3)+(j%3)][(j/3)+(i%3)*3]))) return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        char[][] sudoku1 = new char[][] 
            {{'5','3','.', '.','7','.', '.','.','.'}
            ,{'6','.','.', '1','9','5', '.','.','.'}
            ,{'.','9','8', '.','.','.', '.','6','.'}

            ,{'8','.','.', '.','6','.', '.','.','3'}
            ,{'4','.','.', '8','.','3', '.','.','1'}
            ,{'7','.','.', '.','2','.', '.','.','6'}

            ,{'.','6','.', '.','.','.', '2','8','.'}
            ,{'.','.','.', '4','1','9', '.','.','5'}
            ,{'.','.','.', '.','8','.', '.','7','9'}};
        System.out.println(isValidSudoku(sudoku1));


        char[][] sudoku2 = new char[][] 
            {{'8','3','.', '.','7','.', '.','.','.'}
            ,{'6','.','.', '1','9','5', '.','.','.'}
            ,{'.','9','1', '.','7','.', '.','6','.'}

            ,{'1','.','.', '.','6','.', '.','.','3'}
            ,{'4','.','.', '8','.','3', '.','.','1'}
            ,{'7','.','.', '.','2','.', '.','.','6'}

            ,{'.','6','.', '.','.','.', '2','8','.'}
            ,{'.','.','.', '4','1','9', '.','.','5'}
            ,{'.','.','.', '.','8','.', '.','7','9'}};
        System.out.println(isValidSudoku(sudoku2));

        char[][] sudoku3 = new char[][]
            {{'.','.','4', '.','.','.', '6','3','.'}
            ,{'.','.','.', '.','.','.', '.','.','.'}
            ,{'5','.','.', '.','.','.', '.','9','.'}

            ,{'.','.','.', '5','6','.', '.','.','.'}
            ,{'4','.','3', '.','.','.', '.','.','1'}
            ,{'.','.','.', '7','.','.', '.','.','.'}

            ,{'.','.','.', '5','.','.', '.','.','.'}
            ,{'.','.','.', '.','.','.', '.','.','.'}
            ,{'.','.','.', '.','.','.', '.','.','.'}};
        System.out.println(isValidSudoku(sudoku3));


        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                System.out.print("(" + ((i/3*3)+(j%3)) + ", " + ((j/3)+(i%3)*3) + ")    ");
            }
            System.out.println();
        }
    }
}
