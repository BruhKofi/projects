/*************************************************************************
 *  Compilation:  javac SequentialDragon.java
 *  Execution:    java SequentialDragon N
 * 
 *  Prints out instructions for drawing an order N dragon curve.
 *
 *  % java SequentialDragon 0
 *  F
 * 
 *  % java SequentialDragon 2
 *  FLFLFRF
 *
 *  % SequentialDragon 5
 *  FLFLFRFLFLFRFRFLFLFLFRFRFLFRFRFLFLFLFRFLFLFRFRFRFLFLFRFRFLFRFRF
 *
 *  Limitations
 *  -------------
 *    -  n must be between 0 and 31
 *
 *************************************************************************/

public class SequentialDragon {
    public static void main(String[] args) {
        int n  = Integer.parseInt(args[0]);
        StdOut.println(n);
        int N  = 1 << n;                         // 2^n
        System.out.print("F");
        for (int k = 1; k < N; k++) {
            if ((k & ((k ^ (k-1)) + 1)) > 0) System.out.print("R");
            else                             System.out.print("L");
            System.out.print("F");
        }
        System.out.println();
    }
}
