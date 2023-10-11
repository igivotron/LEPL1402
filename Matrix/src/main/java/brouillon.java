public class brouillon {

    public static int[][] buildFrom(String s) {
        String arr[] = null;
        arr = s.split("\n");
        String m[][] = new String[arr.length][];
        for (int i =0; i< arr.length; i++){
            m[i] = arr[i].split(" ");
        }

        return null;
    }

    public static int sum(int[][] matrix) {
        int s = 0;
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[i].length; j++){
                s += matrix[i][j];
            }
        }
        return s;
    }

    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int a = sum(matrix);
        System.out.println(a);
    }
}
