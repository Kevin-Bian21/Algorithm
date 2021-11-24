package LeetCode;

/**
 * @author BianWenKai
 * @DATE 2021/11/24 - 11:42
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 **/
public class MergeTwoSortedLists {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //递归版本
    public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoSortedLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoSortedLists(l1, l2.next);
            return l2;
        }
    }

    //非递归版本
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
