package 蓝桥杯;

/**
 * @author BianWenKai
 * @DATE 2021/11/6 - 17:02
 **/
public class StructureBinaryTree {

    public static void main(String[] args) {
        Object[] array = {3,1,20,15,25,7};
        StructureBinaryTree tree = new StructureBinaryTree();
        System.out.println(tree.minDepthOfTree(array));
    }

    private Node root;

    private class Node {
        private Node leftChild;
        private Node rightChild;
        private Object data;

        public Node(Object value) {
            this.data = value;
        }
    }

    public int minDepthOfTree(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            insert(array[i]);
        }
        return minDepth(root);
    }

    private void insert(Object value) {

    }
    private int minDepth(Node root) {
        if (root == null)
            return 0;
        return Math.min(minDepth(root.leftChild) + 1, minDepth(root.rightChild) + 1) ;
    }
}
