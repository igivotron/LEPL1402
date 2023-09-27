public class brouillon {
    static long factorial(long a){
        long fact = 1;
        for (int i=1; i<a+1; i++){
            fact*=i;
        }
        return fact;
    }

    static int[] matrixPascal(int n){
        n--;
        int [] matrix = new int[n+1];
        for (int k =0; k<n+1; k++){
            matrix[k] = (int) (factorial(n) / (factorial(k) * factorial(n-k)));
        }
        return matrix;
    }
    public static void main(String[] args){
        int [] matrix = matrixPascal((15));
        for (int i=0; i<matrix.length; i++){
            System.out.print(matrix[i] + " ");
        }
    }
}
