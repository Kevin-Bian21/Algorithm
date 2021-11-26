package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author BianWenKai
 * @DATE 2021/11/26 - 17:45
<<<<<<< HEAD
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
=======
>>>>>>> 485896f759ae2bffd68a77dfc0ed65ec58da53fd
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
        执行用时：4 ms, 在所有 Java 提交中击败了71%的用户
        内存消耗：40.1 MB, 在所有 Java 提交中击败了62.65%的用户
        通过测试用例：133 / 133
     */
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length <= 0)
            return new ListNode().next;
        Queue<ListNode> queue = new LinkedList<>(Arrays.asList(lists));
        //当队列中只剩一个链表时，说明合并完毕
        while (queue.size() >= 2){
            queue.add(mergeKLists(queue.remove(),queue.remove()));
        }
        return queue.remove();
    }

    public ListNode mergeKLists(ListNode l1, ListNode l2) {
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
