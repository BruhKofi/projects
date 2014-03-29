/*************************************************************************
 *  Compilation:  javac GrayCodeArray.java
 *  Execution:    java GrayCodeArray N
 *  
 *  Print the N-bit binary reflected Gray code use a pair of mutually
 *  recursive functions and an array.
 *
 *  % java GrayCodeArray 3
 *  000 
 *  001
 *  011
 *  010
 *  110 
 *  111
 *  101
 *  100
 *
 *************************************************************************/

public class GrayCodeArray {


    public static void show(boolean[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i]) System.out.print(1);
            else      System.out.print(0);
        System.out.println();
    }

    public static void yarg(int n, boolean[] a) {
        if (n == 0) show(a);
        else {
            a[n] = true;
            gray(n-1, a);
            a[n] = false;
            yarg(n-1, a);
        }
    }

    public static void gray(int n, boolean[] a) {
        if (n == 0) show(a);
        else {
            a[n] = false;
            gray(n-1, a);
            a[n] = true;
            yarg(n-1, a);
        }
    }


    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        boolean[] a = new boolean[N+1];
        gray(N, a);

    }

}


