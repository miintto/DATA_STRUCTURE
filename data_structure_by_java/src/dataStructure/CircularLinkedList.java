package dataStructure;
/**
 * 자료구조 Circular Linked List 구현
 * <pre>
 * <b>Method</b>
 *     - insert() : 삽입 메소드
 *     - delete() : 삭제 메소드
 * </pre>
 *
 * <pre>
 * <b>History:</b>
 *     박민재, 1.0  2020.08.18 최초 작성
 * </pre>
 *
 * @author 박민재
 * @version 1.0
 */

public class CircularLinkedList {
    private Node root;

    CircularLinkedList() {
        this.root = null;
    }

    /**
     * 삽입 메소드:
     * <pre>
     * <b>입력받은 값으로 노드를 생성하여 리스트의 맨 뒤와 맨 첫번째에 연결</b>
     *     - root가 비어있는 경우 root에 연결, 또한 자기 스스로 연결
     *     - root가 비어있지 않으면 리스트의 마지막을 찾아 연결, 그 다음 노드는 처음과 연결
     * </pre>
     *
     * @param value (int) 리스트에 넣을 값
     */
    public void insert(int value) {
        Node node = new Node(value);

        if (this.root == null) {
            this.root = node;
            node.next = this.root;

        } else {
            Node point = this.root;

            while (point.next != this.root) {
                point = point.next;
            }
            node.next = this.root;
            point.next = node;
        }
    }

    /**
     * 삭제 메소드:
     * <pre>
     * <b>입력받은 값이 있는 노드를 찾아 삭제</b>
     *     - 삭제하려는 값이 자기 자신과 연결되어 있으면 root를 null처리
     *     - 삭제하려는 값이 존재하는 노드의 이전 노드와 그 다음 노드를 연결
     * </pre>
     *
     * @param value (int) 삭제하려는 노드의 값
     * @exception Exception 찾는 값이 없는 경우 예외처리
     */
    public void delete(int value) {
        Node point = this.root;
        Node pre = null;
        try {
            while (point.value != value) {
                pre = point;
                point = point.next;
                if (point==this.root) {
                    throw new Exception("No value 3");
                }
            }

            if (point.next == point) {
                this.root = null;

            } else if (pre == null) {
                pre = point;
                while (pre.next != this.root) {
                    pre = pre.next;
                }
                pre.next = point.next;
                this.root = point.next;

            } else {
                pre.next = point.next;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void print() {
        System.out.print("CircularLinkedList = [ ");
        Node point = this.root;

        if (point != null) {
            while (point.next != this.root) {
                System.out.print(point.value);
                point = point.next;
                if (point != this.root) {
                    System.out.print(", ");
                }
            }
            System.out.print(point.value);
        }
        System.out.println(" ]");
    }

    public static void main(String args[]) {
        CircularLinkedList lst = new CircularLinkedList();

        lst.insert(1);
        lst.insert(5);
        lst.insert(3);
        lst.insert(4);
        lst.insert(2);
        lst.print();

        lst.delete(5);
        lst.print();
        lst.delete(1);
        lst.print();
        lst.delete(2);
        lst.print();
        lst.delete(3);
        lst.print();
        lst.delete(4);
        lst.print();
    }
}
