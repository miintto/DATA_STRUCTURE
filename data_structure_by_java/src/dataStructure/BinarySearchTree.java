package dataStructure;
/**
 * 자료구조 Binary Search Tree 구현
 * <pre>
 * <b>Method</b>
 *     - insert() : 삽입 메소드
 *     - delete() : 삭제 메소드
 *     - search() : 탐색 메소드
 *     - preOrder() : 전위 순회 메소드
 *     - inOrder() : 중위 순회 메소드
 *     - postOrder() : 후위 순회 메소드
 * </pre>
 *
 * <pre>
 * <b>History:</b>
 *     박민재, 1.0  2020.08.16 최초 작성
 * </pre>
 *
 * @author 박민재
 * @version 1.0
 */

class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
        setDefault(-1, null, null);
    }

    TreeNode(int value) {
        setDefault(value, null, null);
    }

    private void setDefault(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * 삽입 메소드:
     * <pre>
     * <b>노드의 값과 크기를 비교해가며 삽입</b>
     *     - root가 비어있는 경우 root에 연결
     *     - 각 노드값보다 작으면 왼쪽, 크면 오른쪽으로 탐색하며 null이면 그 위치에 연결
     * </pre>
     *
     * @param value (int) 트리에 넣을 값
     */
    public void insert(int value) {
        TreeNode node = new TreeNode(value);

        if (this.root == null) {
            this.root = node;

        } else {
            TreeNode point = this.root;
            while (point != null) {
                if (value < point.value) {
                    if (point.left == null) {
                        point.left = node;
                        break;
                    }
                    point = point.left;
                } else {
                    if (point.right == null) {
                        point.right = node;
                        break;
                    }
                    point = point.right;
                }
            }
        }
    }

    /**
     * 삭제 메소드:
     * <pre>
     * <b>노드의 값과 크기를 비교해가며 삽입</b>
     *     - 크기를 비교하면서 삭제할 노드 탐색
     *       1. 자식 노드가 없는 경우, 해당 노드 제거
     *       2. 한 쪽만 자식이 있는 경우, 해당 자식 노드를 부모 노드와 연결
     *       3. 양 쪽 모두 자식이 있는 경우, 해당 노드 기준 오른쪽 sub tree에서 가장 작은 값으로 대체
     * </pre>
     *
     * @param value (int) 트리에 넣을 값
     * @exception Exception 트리에 해당 값이 없는 경우 예외처리
     */
    public void delete(int value) {
        try {
            TreeNode point = this.root;
            TreeNode pre = null;

            while (point != null) {
                if (value == point.value) {
                    break;
                } else if (value < point.value) {
                    pre = point;
                    point = point.left;
                } else {
                    pre = point;
                    point = point.right;
                }
            }

            if (point == null) {
                throw new Exception("There is no value : " + value);

            } else {
                if ((point.right == null) & (point.left == null)) {
                    if (pre == null) {
                        this.root = null;
                    } else if (value < pre.value) {
                        pre.left = null;
                    } else {
                        pre.right = null;
                    }

                } else if (point.right == null) {
                    if (pre == null) {
                        this.root.left = this.root;
                    } else if (value < pre.value) {
                        pre.left = point.left;
                    } else {
                        pre.right = point.left;
                    }

                } else if (point.left == null) {
                    if (pre == null) {
                        this.root.left = this.root;
                    } else if (value < pre.value) {
                        pre.left = point.right;
                    } else {
                        pre.right = point.right;
                    }

                } else {
                    TreeNode newnodePre = point;
                    TreeNode newnode = point.right;
                    while (newnode.left != null) {
                        newnodePre = newnode;
                        newnode = newnode.left;
                    }

                    newnode.left = point.left;
                    newnodePre.left = newnode.right;
                    newnode.right = point.right;
                    if (pre == null) {
                        this.root = newnode;
                    } else if (value < pre.value) {
                        pre.left = newnode;
                    } else {
                        pre.right = newnode;
                    }

                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 탐색 메소드:
     * <pre>
     * value -> left -> right 순으로 출력
     * </pre>
     *
     * @param value (int) 탐색할 값
     * @return (boolean) 해당 값의 포함 여부
     */
    public boolean search(int value) {
        TreeNode point = this.root;
        while (point != null) {
            if (point.value == value) {
                return true;
            } else if (value < point.value) {
                point = point.left;
            } else {
                point = point.right;
            }
        }
        return false;
    }

    /**
     * 전위 순회 메소드:
     * <pre>
     * value -> left -> right 순으로 출력
     * </pre>
     */
    public void preOrder() {
        System.out.println("<Preorder>");
        searchPreOrder(this.root, 0);
    }

    private void searchPreOrder(TreeNode point, int depth) {
        if (point != null) {
            depth++;
            for (int i=1; i<depth; i++) System.out.print("|   ");
            System.out.println("|-- "+point.value);
            searchPreOrder(point.left, depth);
            searchPreOrder(point.right, depth);
        }
    }

    /**
     * 중위 순회 메소드:
     * <pre>
     * left -> value -> right 순으로 출력
     * </pre>
     */
    public void inOrder() {
        System.out.println("<Inorder>");
        searchInOrder(this.root, 0);
    }

    private void searchInOrder(TreeNode point, int depth) {
        if (point != null) {
            depth++;
            searchInOrder(point.left, depth);
            for (int i=1; i<depth; i++) System.out.print("|   ");
            System.out.println("|-- "+point.value);
            searchInOrder(point.right, depth);
        }
    }

    /**
     * 후위 순회 메소드:
     * <pre>
     * left -> right -> value 순으로 출력
     * </pre>
     */
    public void postOrder() {
        System.out.println("<Postorder>");
        searchPostOrder(this.root, 0);
    }

    private void searchPostOrder(TreeNode point, int depth) {
        if (point != null) {
            depth++;
            searchPostOrder(point.left, depth);
            searchPostOrder(point.right, depth);
            for (int i=1; i<depth; i++) System.out.print("|   ");
            System.out.println("|-- "+point.value);
        }
    }

    public static void main(String args[]) {
        BinarySearchTree tree = new BinarySearchTree();

        boolean result;

        tree.insert(6);
        tree.insert(9);
        tree.insert(2);
        tree.insert(4);
        tree.insert(5);
        tree.insert(1);
        tree.insert(3);
        tree.insert(10);
        tree.insert(7);
        tree.insert(8);

        tree.preOrder();
        tree.inOrder();
        tree.postOrder();

        System.out.println("Delete value : 2");
        tree.delete(2);
        tree.inOrder();
        System.out.println("Delete value : 6");
        tree.delete(6);
        tree.inOrder();
        System.out.println("Delete value : 4");
        tree.delete(4);
        tree.inOrder();
        System.out.println("Delete value : 10");
        tree.delete(10);
        tree.inOrder();

        result = tree.search(8);
        System.out.println("Does Tree Contain 8? : " + result);
        result = tree.search(6);
        System.out.println("Does Tree Contain 6? : " + result);
    }
}
