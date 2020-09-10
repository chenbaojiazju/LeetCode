package string;

/**
 * @author 陈包佳
 * @version 1.0
 * @date 2020/9/10 23:15
 */
public class DefanIPaddr1108 {

    public static void main(String[] args) {
        String address = "1.1.1.1";
        String result = defangIPaddr(address);
        System.out.println("Origin: " + address);
        System.out.println("Result: " + result);
    }

    private static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
