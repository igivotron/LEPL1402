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
        for (int m =1; m< Math.pow(matrix.length, 2)+1; m++){
            boolean notPresent = true;
            int i = 0;
            int j = 0;
            while (notPresent & i < matrix.length & j < matrix.length){
                if (matrix[i][j] == m){
                    notPresent = false;
                }
                else{
                    i++;
                    if (i== matrix.length){
                        i=0;
                        j++;
                    }
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
            sum += matrix[i][0];
        }
        return sum;
    }

    public static boolean isMagicSquare(int [][] matrix) {
        // TODO Implement the body of this method, feel free to add other methods but do not change the signature of isMagiSquare
        int magicReference = reference(matrix);
        if (allNumber(matrix)){
            int sumDiagRight = 0;
            int sumDiagLeft = 0;
            for (int i=0; i< matrix.length; i++){
                int sumRow = 0;
                int sumColumn =0;
                sumDiagLeft += matrix[i][i];
                sumDiagRight += matrix[i][matrix.length-i-1];
                for (int j=0; j< matrix.length; j++){
                    sumRow += matrix[i][j];
                    sumColumn += matrix[j][i];
                }
                if (sumRow != magicReference || sumColumn != magicReference) {
                    return false;
                }
            }
            if (sumDiagLeft != magicReference || sumDiagRight != magicReference) {
                return false;
            }
            return true;
        }
         return false;
    }
}
