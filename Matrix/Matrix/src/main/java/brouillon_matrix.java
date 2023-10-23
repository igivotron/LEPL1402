public class brouillon_matrix {
    public static int[][] buildFrom(String s){
        String[] sSplited = s.split("\n");
        int r = sSplited.length;
        int c = (sSplited[0].length()+1)/2;
        int m[][] = new int[r][c];

        for(int i=0; i<r; i++){
            String[] tempo = sSplited[i].split(" ");
            for(int j=0; j<c; j++) {
                m[i][j] = Integer.parseInt(tempo[j]);
            }
        }

        return m;
    }

    public static int sum(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int s = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                s += matrix[i][j];
            }
        }
        return s;
    }

    public static int[][] transpose(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int mTrans[][] = new int[c][r];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                mTrans[i][j] = matrix[j][i];
            }
        }
        return mTrans;
    }

    public static int[][] product(int[][] matrix1, int[][] matrix2) {
        int r1 = matrix1.length;
        int c1 = matrix1[0].length;
        int r2 = matrix1.length;
        int c2 = matrix1[0].length;

        int m[][] = new int[c1][r2];



        return null;
    }

    public static void test(int[][] m){
        for(int i=0; i<m.length;i++){
            for (int j=0; j<m[0].length; j++){
                System.out.print(m[i][j] + " ");
            }
        System.out.println(" ");
        }
    }
    public static void main(String[] args){
        String s = "1 2 3\n4 5 6\n7 8 9";
        String ss = "1 2 3";
        int [][] m = buildFrom(s);
        int sume = sum(m);
        System.out.println(sume);
        int[][] mTrans = transpose(m);
        test(m);
        test(mTrans);
    }
}
