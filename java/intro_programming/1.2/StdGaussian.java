public class StdGaussian
{
    public static void main(String[] args) {
        double gauss = Math.sin(2*Math.PI*Math.random())*(Math.pow(-2*Math.log(Math.random()),-0.5));
        System.out.println(gauss);
    }
}
