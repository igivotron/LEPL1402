package basics;

public class Matrix {

    /**
     * Create a matrix from a String.
     *
     * The string if formatted as follow:
     *  - Each row of the matrix is separated by a newline
     *    character \n
     *  - Each element of the rows are separated by a space
     *
     *  @param s The input String
     *  @return The matrix represented by the String
     */
    public static int[][] buildFrom(String s) {
        String[] A = s.split("\n");
        int[][] B = new int[A.length][];
        for(int i=0; i< A.length; i++){
            String[] C = A[i].split(" ");
            B[i] = new int[C.length];
            for(int j=0; j<C.length; j++){B[i][j] = Integer.parseInt(C[j]);}
        }
        return B;
    }


    /**
     * Compute the sum of the element in a matrix
     *
     * @param matrix The input matrix
     * @return The sum of the element in matrix
     */
    public static int sum(int[][] matrix) {
        int sum = 0;
        for (int[] i : matrix) {for (int j : i) {sum += j;}}
        return sum;
    }

    /**
     * Compute the transpose of a matrix
     *
     * @param matrix The input matrix
     * @return A new matrix that is the transpose of matrix
     */
    public static int[][] transpose(int[][] matrix) {
        int[][] trans = new int[matrix[0].length][matrix.length];
        for(int i=0; i<matrix[0].length; i++){
            for(int j=0; j<matrix.length; j++){
                trans[i][j] = matrix[j][i];
            }
        }
        return trans;
    }

    /**
     * Compute the product of two matrix
     *
     * @param matrix1 A n x m matrix
     * @param matrix2 A m x k matrix
     * @return The n x k matrix product of matrix1 and matrix2
     */
    public static int[][] product(int[][] matrix1, int[][] matrix2) {
        int[][] mult = new int[matrix1.length][matrix2[0].length];
        for(int i=0; i< matrix1.length; i++){
            for(int j=0; j< matrix2[0].length; j++){
                int sum =0;
                for(int k=0; k<matrix1[i].length;k++){sum += matrix1[i][k]*matrix2[k][j];}
                mult[i][j] = sum;
            }
        }
        return mult;
    }
}