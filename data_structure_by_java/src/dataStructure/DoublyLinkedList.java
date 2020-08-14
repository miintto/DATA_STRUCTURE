package dataStructure;
/**
 * 자료구조 Doubly Linked Stack 구현
 *
 * <pre>
 * <b>History:</b>
 *     박민재, 1.0  2020.08.15 최초 작성
 * </pre>
 *
 * @author 박민재
 * @version 1.0
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
     *   - 삽입하려는 값을 입력받아서 리스트의 마지막에 노드 연결
     *   - 리스트가 비어있는 경우 root에 연결
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
     * 삭제 메소드:
     *   - 삭제하려는 값을 입력받아서 리스트의 처음부터 탐색하면서 가장 먼저 값이 일치하는 노드 제거
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

        System.out.println("Insert value : 1");
        lkdList.insert(1);
        System.out.println("Insert value : 2");
        lkdList.insert(2);
        System.out.println("Insert value : 5");
        lkdList.insert(5);
        System.out.println("Insert value : 4");
        lkdList.insert(4);
        System.out.println("Insert value : 8");
        lkdList.insert(8);
        System.out.println("Insert value : 3");
        lkdList.insert(3);
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

        System.out.println("Remove value : 3");
        lkdList.remove(3);
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

        System.out.println("Remove value : 5");
        lkdList.remove(5);
        lkdList.print();
        lkdList.printInverse();

        System.out.println("Remove value : 4");
        lkdList.remove(4);
        lkdList.print();
        lkdList.printInverse();

    }
}
