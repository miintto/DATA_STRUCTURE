package dataStructure;
/**
 * 자료구조 Doubly Linked List 구현
 * <pre>
 * <b>Method</b>
 *     - insert() : 삽입 메소드
 *     - insertSorted() : 오름차순 정렬 삽입 메소드
 *     - remove() : 삭제 메소드
 * </pre>
 *
 * <pre>
 * <b>History:</b>
 *     박민재, 1.0  2020.08.14 최초 작성
 *     박민재, 1.1  2020.08.17 오름차순 정렬 로직 추가
 * </pre>
 *
 * @author 박민재
 * @version 1.1
 */

class DoublyNode {
    public int value;
    public DoublyNode pre;
    public DoublyNode next;

    DoublyNode() {
        setDefault(-1, null, null);
    }

    DoublyNode(int value) {
        setDefault(value, null, null);
    }

    private void setDefault(int value, DoublyNode pre, DoublyNode next) {
        this.value = value;
        this.pre = pre;
        this.next = next;
    }
}

public class DoublyLinkedList {
    private DoublyNode root;

    DoublyLinkedList() {
        this.root = null;
    }

    /**
     * 삽입 메소드:
     * <pre>
     * <b>입력받은 값으로 노드를 생성하여 리스트의 맨 뒤에 삽입</b>
     *     - root가 비어있는 경우 root에 연결
     *     - root가 비어있지 않으면 리스트의 마지막을 찾아 양 방향으로 노드 연결
     * </pre>
     *
     * @param value (int) 리스트에 넣을 값
     */
    public void insert(int value) {
        DoublyNode node = new DoublyNode(value);
        if (this.root == null) {
            this.root = node;

        } else {
            DoublyNode point = this.root;

            while (point.next != null) {
                point = point.next;
            }
            point.next = node;
            node.pre = point;
        }
    }

    /**
     * 오름차순 정렬 삽입 메소드:
     * <pre>
     * <b>입력받은 값으로 노드를 생성하여 오름차순으로 삽입</b>
     *     - root가 비어있는 경우 root에 연결
     *     - root값보다 작은 경우 생성한 노드에 root를 연결하고 해당 노드를 root로 설정
     *     - root값보다 큰 경우 노드값의 크기를 비교하여 연결
     * </pre>
     *
     * @param value (int) 리스트에 넣을 값
     */
    public void insertSorted(int value) {
        DoublyNode node = new DoublyNode(value);

        if (this.root == null) {
            this.root = node;

        } else if (value < this.root.value) {
            node.next = this.root;
            this.root.pre = node;
            this.root = node;

        } else {
            DoublyNode pre = null;
            DoublyNode point = this.root;

            while (point.value < value) {
                pre = point;
                point = point.next;
                if (point == null) {
                    break;
                }
            }

            node.next = point;
            node.pre = pre;
            pre.next = node;
            if (point != null) {
                point.pre = node;
            }
        }
    }

    /**
     * 삭제 메소드:
     * <pre>
     * <b>삭제하려는 값을 입력받아서 값이 일치하는 노드 1개 제거</b>
     *     - root값과 일치하는 경우 root 다음 노드를 root로 설정
     *     - root값과는 다른 경우 리스트를 탐색하면서 값이 일치하는 노드를 찾아 제거
     * </pre>
     *
     * @param value (int) 삭제하려는 노드의 값
     * @exception Exception 리스트가 비어있는 경우 예외처리
     * @exception Exception 마지막까지 탐색해도 해당 값이 없는 경우 예외처리
     */
    public void remove(int value) {
        try {
            if (isEmpty()) {
                throw new Exception("The List is Empty!");

            } else if (this.root.value == value) {
                this.root = this.root.next;
                if (this.root != null) {
                    this.root.pre = null;
                }

            } else {
                DoublyNode point = this.root.next;

                while (point != null) {
                    if (point.value == value) {
                        point.pre.next = point.next;

                        if (point.next != null){
                            point.next.pre = point.pre;
                        }
                        break;
                    }
                    point = point.next;
                }
                if (point==null){
                    throw new Exception("There is no value : " + value);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isEmpty() {
        return this.root==null;
    }

    public void print() {
        System.out.print("DoublyLinkedList = [ ");
        DoublyNode point = this.root;

        while (point != null){
            System.out.print(point.value);
            point = point.next;
            if (point != null) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }

    public void printInverse() {
        DoublyNode point = this.root;
        if (point != null) {
            while (point.next != null) {
                point = point.next;
            }
        }

        System.out.print("DoublyLinkedList = [ ");

        while (point != null){
            System.out.print(point.value);
            point = point.pre;
            if (point != null) {
                System.out.print(", ");
            }
        }
        System.out.println(" ] (inverse)");
    }

    public static void main(String args[]) {
        DoublyLinkedList lkdList = new DoublyLinkedList();

        System.out.println("Insert value : 2");
        lkdList.insertSorted(2);
        System.out.println("Insert value : 5");
        lkdList.insertSorted(5);
        System.out.println("Insert value : 4");
        lkdList.insertSorted(4);
        System.out.println("Insert value : 1");
        lkdList.insertSorted(1);
        System.out.println("Insert value : 8");
        lkdList.insertSorted(8);
        lkdList.print();
        lkdList.printInverse();

        System.out.println("Remove value : 2");
        lkdList.remove(2);
        lkdList.print();
        lkdList.printInverse();

        System.out.println("Remove value : 1");
        lkdList.remove(1);
        lkdList.print();
        lkdList.printInverse();

        System.out.println("Remove value : 8");
        lkdList.remove(8);
        lkdList.print();
        lkdList.printInverse();

        System.out.println("Remove value : 4");
        lkdList.remove(5);
        lkdList.print();
        lkdList.printInverse();

        System.out.println("Remove value : 5");
        lkdList.remove(5);
        lkdList.print();
        lkdList.printInverse();

        System.out.println("Remove value : 4");
        lkdList.remove(4);
        lkdList.print();
        lkdList.printInverse();

        System.out.println("Remove value : 4");
        lkdList.remove(1);
        lkdList.print();
        lkdList.printInverse();

    }
}
