import java.util.HashSet;

/**
 * @author 陈包佳
 * @version 1.0
 * @date 2020/10/24 9:03
 */
public class Pow {

    public static void main(String[] args) {
        new Pow().myPow(2.0, 10);
        System.out.println(Integer.MIN_VALUE);
        String a = "";
        a.charAt(0);
        HashSet hashSet = new HashSet(0);
        hashSet.clear();
        hashSet.size();
    }

    public double myPow(double x, int n) {
        if (x == 0.0) return 0.0;
        if (n == 0) return 1.0;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1 / (myPow(x, -n-1) * x);
            }
            return 1 / myPow(x, -n);
        }
        if (n % 2 == 1) return x * myPow(x, n-1);
        return myPow(x*x, n/2);
    }
}
