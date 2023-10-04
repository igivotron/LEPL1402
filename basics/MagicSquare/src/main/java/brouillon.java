public class brouillon {
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
    public static void main(String[] args){
        int[][] matrix = new int[][]
                        {{2, 7, 6},
                        {9, 5, 1},
                        {4, 3, 8}};
        System.out.println(allNumber(matrix));
        System.out.println(reference(matrix));
    }
}
