package basics;

public class MagicSquare {


    /**
     * A magic square is an (n x n) matrix such that:
     * <p>
     * - all the positive numbers 1,2, ..., n*n are present (thus each number appears exactly once)
     * - the sums of the numbers in each row, each column and both main diagonals are the same
     *
     *   For instance a 3 x 3 magic square is the following
     *
     *   2 7 6
     *   9 5 1
     *   4 3 8
     *
     *   You have to implement the method that verifies if a matrix is a valid magic square
     */

    /**
     *
     * @param matrix a square matrix of size n x n
     * @return true if matrix is a n x n magic square, false otherwise
     */
    static boolean allNumber(int [][] matrix){
        boolean notPresent = true;
        int i = 0;
        int j = 0;
        for (int m =0; m< Math.pow(matrix.length, 2); m++){
            while (notPresent & i < matrix.length & j < matrix.length){
                if (matrix[i][j] == m){
                    notPresent = false;
                }
                else{
                    i++; j++;
                }
            }
            if (notPresent){
                return false;
            }
        }
        return true;
    }

    static int reference(int [][] matrix){
        int sum = 0;
        for (int i=0; i< matrix.length; i++){
            for (int j=0; j< matrix.length; j++){
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static boolean isMagicSquare(int [][] matrix) {
        // TODO Implement the body of this method, feel free to add other methods but do not change the signature of isMagiSquare
         return false;
    }
}
