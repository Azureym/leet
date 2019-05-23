/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumber {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final int numFromNode1 = getNumFromNode(l1);
        final int numFromNode2 = getNumFromNode(l2);
        return getNodeFromNum(numFromNode1 + numFromNode2);
    }

    private int getNumFromNode(ListNode l) {
        int tmp = 0;
        int factor = 1;
        while (l.next != null) {
            tmp = tmp + factor * l.val;
            factor *= 10;
            l = l.next;
        }
        return tmp;
    }

    private ListNode getNodeFromNum(int x) {
        int factor = 10;
        ListNode rightNode = null;
        while (x / factor != 0) {
            final int rightNum = x % factor;
            final ListNode listNode = new ListNode(rightNum);
            listNode.next = rightNode;
            rightNode = listNode;
            factor *= 10;
        }
        return rightNode;
    }
}
