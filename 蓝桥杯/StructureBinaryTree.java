package 蓝桥杯;

/**
 * @author BianWenKai
 * @DATE 2021/11/6 - 17:02
 **/


/**
 * 给定一个数组，建立一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点
 */
public class StructureBinaryTree {

    public static void main(String[] args) {
        Object[] array = {2,null,3,null,4,null,5,null,6};
        Object[] array1 = {3,9,20,null,null,15,7};
        StructureBinaryTree tree = new StructureBinaryTree();
        System.out.println("array 的最小深度 :" +  tree.minDepthOfTree(array));
        System.out.println("array1 的最小深度 :" +tree.minDepthOfTree(array1));
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
        if (array == null)
            throw new IllegalStateException("The array is null");
        Node root = createTree(array);
        return minDepth(root);
    }
    public Node createTree(Object[] array) {
        return createTree(array, 0);
    }

    //创建二叉树：由一个根节点及两个不相交的、被分别称为左子树和右子树的二叉树组成.
    private Node createTree(Object[] array, int index) {
        if (index >= array.length)
            return null;
        if (array[index] == null)
            return null;
        else {
            Node root = new Node(array[index]);
            root.leftChild = createTree(array, index + 1 );
            root.rightChild = createTree(array, index + 2);
            return root;
        }
    }
    private int minDepth(Node root) {
        if (root == null)
            return 0;
        //左子结点存在，但右子节点为空的情况，说明该节点不为叶子节点
        if (root.leftChild != null && root.rightChild == null)
            return 1 + minDepth(root.leftChild);
        //同理
        if (root.leftChild == null && root.rightChild != null)
            return 1 + minDepth(root.rightChild);
        return Math.min(minDepth(root.leftChild) + 1, minDepth(root.rightChild) + 1) ;
    }
}
