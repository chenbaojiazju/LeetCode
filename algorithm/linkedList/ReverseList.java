package linkedList;
/**
 * @author 陈包佳
 * @version 1.0
 * @date 2020/10/21 22:26
 */
public class ReverseList {

    public ListNode ReverseList1(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode cur = ReverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            //链表不能指向后面会有变动的节点
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;

    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
