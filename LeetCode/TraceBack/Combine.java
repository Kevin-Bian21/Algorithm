package LeetCode.TraceBack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BianWenKai
 * @DATE 2021/11/27 - 8:48
 *
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 *
 *输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 *
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 **/
public class Combine {


    public static void main(String[] args) {
        int n = 4;
        int k = 4;
        Combine combine = new Combine();
        System.out.println(combine.combine(n, k));
    }

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        combine(n, k, 1, new ArrayList<>());
        return result;
    }
    private void combine(int n, int k, int startIndex, List<Integer> list) {
        //终止条件为搜索到解空间树的叶子节点，即"list.size() == k"
        if (list.size() >= k) {
            //将候选解存放
            list = new ArrayList<>(list);
            result.add(list);
            return;
        }
        // i 为本次搜索起始位置 ，"i <= n - (k - list.size()) + 1" 剪枝优化，例如：，n = 4，k = 4时，第一层for循环的时候，从元素2开始的遍历都没有意义了。 在第二层for循环，从元素3开始的遍历都没有意义了。
        for (int i = startIndex; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            combine(n, k, i + 1, list);
            //回溯，撤销处理过的节点
            list.remove(list.size() - 1);
        }
    }
}
