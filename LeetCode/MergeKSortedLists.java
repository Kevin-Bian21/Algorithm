package LeetCode;

/**
 * @author BianWenKai
 * @DATE 2021/11/26 - 17:45
 **/
public class MergeKSortedLists {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /*
        执行用时：190 ms, 在所有 Java 提交中击败了11.05%的用户
        内存消耗：40.1 MB, 在所有 Java 提交中击败了56.44%的用户
        通过测试用例：133 / 133
     */
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length <= 0)
            return new ListNode().next;
        if (lists.length <= 1) {
            return lists[0];
        }
        if (lists.length <= 2) {
            return mergeKLists(lists, lists[0], lists[1]);
        }
        ListNode[] list = new ListNode[lists.length - 1];
        list[0] = mergeKLists(lists, lists[0], lists[1]);
        ListNode head = new ListNode();
        for (int i = 2; i < lists.length; i++) {
            head = mergeKLists(lists, list[i - 2], lists[i]);
            list[i - 1] = head;
        }
        return head;
    }

    public ListNode mergeKLists(ListNode[] lists, ListNode l1, ListNode l2) {
        //创建一个新的链表用来合并链表
        ListNode newList = new ListNode();
        //当只要有一个链表为空时，就返回另一个，这样就排除了空链表的情况
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        //创建一个新节点指向新创建的链表的头节点
        ListNode current = newList;
        //当l1、l2的节点不为空时，判断其val大小，将current的next指针指向较小的节点
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        while (l1 != null) {
            current.next = l1;
            l1 = l1.next;
            current = current.next;
        }
        while (l2 != null) {
            current.next = l2;
            l2 = l2.next;
            current = current.next;
        }
        return newList.next;
    }
}
