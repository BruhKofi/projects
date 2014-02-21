public class IntroMethods
{
    public static int max3(int n1, int n2, int n3) {
        int max = Integer.MIN_VALUE;

        max = n1 > n2 ? n1 : n2;
        max = max > n3 ? max : n3;
        
        return max;
    }

    public static void printArray(double[][] arr) {
        for (int i = 0; i<arr.length; i++) {
            for (int j = 0; j<arr[i].length; j++) {
                StdOut.print(arr[i][j] + " ");
            }
            StdOut.println();
        }
    }

    public static boolean odd(boolean b1, boolean b2, boolean b3) {
        int trueCount = 0;
        if (b1) {
            trueCount++;
        }
        if (b2) {
            trueCount++;
        }
        if (b3) {
            trueCount++;
        }
        return trueCount%2 == 1;
    }

    public static boolean majority(boolean b1, boolean b2, boolean b3) {
        return ((b1 && b2 && b3) || (b1 && b2) || (b1 && b3) || b2 && b3);
    }

    public static boolean eq(int[] n1, int[] n2) {
        if (n1.length != n2.length) {
            return false;
        }
        for (int i = 0; i<n1.length; i++) {
            if (n1[i] != n2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean areTriangular(double n1, double n2, double n3) {
        if (n1 + n2 > n3) {
            return false;
        }
        if (n2 + n3 > n1) {
            return false;
        }
        if (n1 + n3 > n2) {
            return false;
        }
        return true;
    }

    public static double sigmoid(double x) {
        double exp = Math.exp(-x);
        double value = 1.0/(1-exp);
        return value;
    }

    public static double lg(double x) {
        return Math.log(x)/Math.log(2);
    }

    public static int lg(int N) {
        int n = 1;
        int exp = 0;
        if (N < 2) {
            return 0;
        }
        else {
            while (n < N) {
                exp++;
                n *= 2;
            }
            return exp-1;
        }
    }
    

    public static int signum(int N) {
        if (N < 0) {
            return -1;
        } else if (N > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int checkSum(int d) {
        if (d>9 || d < 0) {
            return 0;
        }
        int sum = 2*d;
        int first = sum/10;
        int second = sum%10;
        return first + second;
    }

    public static double max(double[] a) {
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i<a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static double min(double[] a) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i<a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    public static void rescale(double[] a) {
        double min = min(a);
        double max = max(a);
        double diff = max - min;
        for (int i = 0; i<a.length; i++) {
            a[i] -= min;
            a[i] /= diff;
        }
    }

    public static int[] histogram(int[] a, int M) {
        int[] histogram = new int[M];
        for (int i = 0; i<a.length; i++) {
            histogram[a[i]]++;
        }
        return histogram;
    }

    public static double[][] multiply(double[][] a, double[][] b) {
        int N = a.length;
        int M = a[0].length;
        if (M != b.length) {
            StdOut.println("Dimensions do not match");
            return null;
        }
        int P = b[0].length;

        double[][] prod = new double[N][P];

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<P; j++) {
                double sum = 0.0;
                for (int k = 0; k<M; k++) {
                    sum += a[i][k]*b[k][j];
                }
                prod[i][j] = sum;
            }
        }
        return prod;
    }

    public static boolean any(boolean[] a) {
        for (int i = 0; i<a.length; i++) {
            if (a[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean all(boolean[] a) {
        for (int i = 0; i<a.length; i++) {
            if (!a[i]) {
                return false;
            }
        }
        return true;
    }
            
    
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int num = N;
        int sum = 0;
        boolean check = false;
        for (int i = 1000000000; i > 0; i /= 10) {
            if (check) {
                sum += checkSum(num/i);
            } else {
                sum += num/i;
            }
            check = !check;
            num = num%i;
        }
        int rem = 0;
        if (sum%10 != 0) {
            rem = 10 - sum%10;
        }
        StdOut.println(N + "" + rem);

        int[] a = new int[10];
        for (int i = 0; i<10; i++) {
            a[i] = i;
        }
        a[0] = 5;
        int[] hist = histogram(a, 10);
        for (int i = 0; i<10; i++) {
            StdOut.print(hist[i] + " ");
        }
        StdOut.println();

        double[][] arr = new double[2][3];
        for (int i = 0; i<2; i++) {
            for (int j = 0; j<3; j++) {
                arr[i][j] = i+i*j;
            }
        }
        double[][] arr2 = new double[3][4];
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<4; j++) {
                arr2[i][j] = i+i*j;
            }
        }
        
        double[][] b = multiply(arr, arr2);
        printArray(arr);
        StdOut.println();
        printArray(arr2);
        StdOut.println();
        printArray(b);
    }
}
