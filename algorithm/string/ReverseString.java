package string;

/**
 * @author 陈包佳
 * @version 1.0
 * @date 2020/10/24 8:34
 */
public class ReverseString {

    public String solve (String str) {
        // write code here
        char[] res = str.toCharArray();
        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            swap(res, l, r);
            l++;
            r--;
        }
        return new String(res);
    }

    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
