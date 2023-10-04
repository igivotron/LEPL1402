package basics;

import java.util.Arrays;

/**
 * Make sure that the equal method consider
 * two QR codes as identical if they have been flipped
 * by 0,1,2 or 3 quarter rotations
 *
 * For instance the two following matrices should be
 * considered equals if you flip your head by 180 degrees
 *
 *         boolean [][] t0 = new boolean[][] {
 *                 {false,true,false,false},
 *                 {false,false,true,true},
 *                 {true,false,false,true},
 *                 {true,true,false,true}
 *         };
 *
 *         // t2 is a version of t2 with two quarter rotations
 *         boolean [][] t2 = new boolean[][] {
 *                 {true,false,true,true},
 *                 {true,false,false,true},
 *                 {true,true,false,false},
 *                 {false,false,true,false}
 *         };
 */
public class QRcode {

    protected boolean [][] data;

    /**
     * Create a QR code object
     * @param data is a n x n square matrix
     */
    public QRcode(boolean [][] data) {
        this.data = data;
    }

    /**
     * Return true if the other matrix is identical up to
     * 0, 1, 2 or 3 number of rotations
     * @param o the other matrix to compare to
     * @return
     */
    boolean compare(boolean[][] m1, boolean m2[][]){
        for (int i=0; i<m1.length; i++){
            for (int j=0; j<m1[0].length; j++){
                if (m1[i][j] != m2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    @Override
    public boolean equals(Object o) {
        if (o==null || getClass() != o.getClass()){
            return false;
        }
        QRcode qr = (QRcode) o;

        int r0 = this.data.length;
        int c0 = this.data[0].length;
        int r1 = qr.data.length;
        int c1 = qr.data[0].length;

        boolean[][] t0 = new boolean[r0][c0];
        boolean[][] t1 = new boolean[r0][c0];
        boolean[][] t2 = new boolean[r0][c0];
        boolean[][] t3 = new boolean[r0][c0];

        if (r0 != r1 || c0 != c1){
            return false;
        }
        for(int i=0; i <r0; i++){
            for (int j=0; j<c0; j++){
                t0[i][j] = qr.data[c0-j-1][i]; // rotation 3
                t1[i][j] = qr.data[r0-i-1][c0-j-1]; // rotation 2
                t2[i][j] = qr.data[j][r0-i-1]; // rotation 1
                t3[i][j] = qr.data[i][j]; // no rotation
                }
            }
        if (compare(this.data, t0) || compare(this.data, t1) || compare(this.data, t2) || compare(this.data, t3)){
            return true;
        }

        // TODO
         return false;
    }



}
