package string;

/**
 * @author 陈包佳
 * @version 1.0
 * @date 2020/9/10 23:15
 */
public class DefanIPaddr1108 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int i = 2;
        System.out.println(a[++i] == a[i]);
    }

    private static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
