package LeetCode;

/**
 * @author BianWenKai
 * @DATE 2021/11/23 - 12:04
 **/
public class RemoveNthNodeFromEndOfList {
    /**
     * Definition for singly-linked list.
     * https://gitee.com/Kevin_Bian/img_bed/raw/master/img/remove_ex1.jpg
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     *
     * 输入：head = [1], n = 1
     * 输出：[]
     **/
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //使用双指针，当last指针到达n+1的位置时，current指针指向头节点，然后两个指针一起移动直到last指针的next值为null，说明last指针到了链表末尾，此时current所指节点为要删除的元素的前驱节点
        ListNode last = head;
        ListNode current = head;
        for(int i = 0; i < n; i++) {
            last = last.next;
        }

        //如果删除的元素位置节点为空，说明要删的元素是头节点（因为是删倒数第n个）
        if (last == null) {
            head = head.next;
            current = null;
            return head;
        }
        //找到当前要删的元素的前驱节点
        while (last.next != null) {
            last = last.next;
            current = current.next;
        }
        //定位要删除的节点
        ListNode node = current.next;
        //将要删的元素的前驱节点的next指针指向要删除元素的下一个元素
        current.next = node.next;
        //将要删除的元素释放
        node = null;
        return head;
    }
}
