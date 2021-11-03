package 蓝桥杯;

/**
 * @author BianWenKai
 * @DATE 2021/11/3 - 21:12
 **/
public class MergeTwoArrayAndCastLinkList {

    public static void main(String[] args) {
        int[] arr1 = {1,3,5};
        int[] arr2 = {2,4,6};
        MergeTwoArrayAndCastLinkList mergeTowList = new MergeTwoArrayAndCastLinkList();
        mergeTowList.showDate(mergeTowList.merge(arr1, arr2));
        System.out.println();
    }

    private Node first;
    private Node last;
    private Integer size;

    public MergeTwoArrayAndCastLinkList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    private class Node {
        private Node pre;
        private Node next;
        private int data;

        public Node(int data) {
            this.data = data;
        }
    }


    //将两个数组以链表的形式存储，并将这两个链表进行合并
    private MergeTwoArrayAndCastLinkList merge(int[] arr1, int[] arr2) {
        MergeTwoArrayAndCastLinkList list1 = new MergeTwoArrayAndCastLinkList();
        for (int value : arr1) {
            list1.insert(value);
        }
        MergeTwoArrayAndCastLinkList list2 = new MergeTwoArrayAndCastLinkList();
        for (int value : arr2) {
            list2.insert(value);
        }
       return  mergeTwoList(list1,list2);
    }

    //将两个链表合并成一个新的升序链表
    private MergeTwoArrayAndCastLinkList mergeTwoList(MergeTwoArrayAndCastLinkList list1, MergeTwoArrayAndCastLinkList list2) {
        MergeTwoArrayAndCastLinkList list = new MergeTwoArrayAndCastLinkList();
        while (list1.first != null && list2.first != null) {
            if (list1.first.data <= list2.first.data) {
                list.insert(list1.first.data);
                list1.first = list1.first.next;
            }else {
                list.insert(list2.first.data);
                list2.first = list2.first.next;
            }
        }
        while (list1.first != null) {
            list.insert(list1.first.data);
            list1.first = list1.first.next;
        }
        while (list2.first != null) {
            list.insert(list2.first.data);
            list2.first = list2.first.next;
        }
        return list;
    }

    //输出合并后的两个链表
    private void showDate(MergeTwoArrayAndCastLinkList list) {
        Node cur = list.first;
        while (cur != null) {
            System.out.print(cur.data+"  ");
            cur = cur.next;
        }
    }

    //尾插法建立链表
    private void insert(int data) {
        Node node = new Node(data);
        if (first == null) {
            first = node;
            last = node;
            size ++;
            return ;
        }
        Node cur = last;
        last.next = node;
        last = last.next;
        last.pre = cur;
        size ++;
    }
}
