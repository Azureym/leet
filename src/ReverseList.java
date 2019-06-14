import java.util.Stack;
import java.util.StringJoiner;

/**
 * 单链表反转,把我绕死了
 * <p>
 * User: yangmu
 * Date: 2019-05-25
 * Time: 14:42
 */
public class ReverseList {

    public static void main(String[] args) {
        int[] tmp = {1, 2, 3, 4};
        final ListNode construct = construct(tmp);
        print(construct);
        reverse(construct.next);
        print(construct);
    }

    private static ListNode construct(int[] tmp) {
        if (null == tmp || tmp.length == 0) {
            return null;
        }

        ListNode head = new ListNode(tmp[0]);
        ListNode test = head;
        for (int i = 1; i < tmp.length; i++) {
            ListNode p = new ListNode(tmp[i]);
            test.next = p;
            test = p;
        }
        return head;

    }

    private static void print(ListNode p) {
        StringBuilder tmp = new StringBuilder();
        while (p != null) {
            tmp.append(p.value).append(",");
            p = p.next;
        }
        System.out.println(tmp.toString());
    }

    public static class ListNode {
        int value;
        ListNode next = null;

        public ListNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", ListNode.class.getSimpleName() + "[", "]")
                    .add("value=" + value)
                    .add("next=" + next)
                    .toString();
        }
    }

    /**
     * 转换过程
     * 这里需要使用三个变量来记录
     * <p>
     * 1 -> 2 -> 3 -> 4
     * 2 -> 1 -> 3 -> 4
     * 3 -> 2 -> 1 -> 4
     * 4 -> 3 -> 2 -> 1
     *
     * @param head
     */
    public static ListNode reverse(ListNode head) {
        ListNode fixed = head;
        ListNode top = head;
        ListNode pre;
        while (fixed.next != null) {
            pre = top;
            top = fixed.next;
            fixed.next = top.next;
            top.next = pre;
        }
        return top;
    }

    public static void reorderList(ListNode head) {
        ListNode p = head;
        Stack<ListNode> stack = new Stack<>();

        while (p != null) {
            stack.push(p);
            p = p.next;
        }

        if (!stack.isEmpty()) {
            p = head;
            ListNode q = null;
            do {
                q = stack.pop();
                ListNode tmp = p.next;
                p.next = q;
                q.next = tmp;
                p = tmp;
            } while (p.next != null && !stack.isEmpty());
        }
    }
}
