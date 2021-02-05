/**
 * @author 陈包佳
 * @version 1.0
 * @date 2021/1/14 22:34
 */
public class AddInList {

    public static void main(String[] args) {
        float a = 1.0f;
        int b = 1;
        for (int i = 0; i < 29; i++) {
            System.out.println(i);
            a = a * 2;
            b = b * 2;
            System.out.println(a==b);
            System.out.println(b);
            System.out.println(a);
        }

    }

    public ListNode addInList(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        ListNode result = new ListNode(-1);
        ListNode cur = result;
        head1 = reverse(head1);
        head2 = reverse(head2);
        ListNode p = head1;
        ListNode q = head2;
        int carry = 0;
        int sum = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;

            sum = x + y + carry;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            carry = sum / 10;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(1);
        }
        return reverse(result.next);
    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
