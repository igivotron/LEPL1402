public class brouillon {

    static int[] pascal(int n){
        n--;
        int [] line1 = new int[1];
        line1[0] = 1;
        for(int i=0; i<n; i++){
            int [] line2 = new int[line1.length +1];
            line2[0] = 1;
            line2[line2.length-1] = 1;
            for (int j=1; j<line2.length-1; j++){
                line2[j] = line1[j-1] + line1[j];
            }
            line1 = line2;
        }
        return line1;
    }

    public static void main(String[] args) {
        int[] m = pascal(9);
        for (int i =0; i<m.length; i++){
            System.out.print(m[i] + " ");
        }
    }
}