package dataStructure;
/**
 * 자료구조 Linked List 구현
 *
 * <pre>
 * <b>History:</b>
 *     박민재, 1.0  2020.08.09 최초 작성
 * </pre>
 *
 * @author 박민재
 * @version 1.0
 */

class Node {
    public int value;
    public Node next;

    Node() {
        setDefault(-1, null);
    }

    Node(int value) {
        setDefault(value, null);
    }

    Node(int value, Node next) {
        setDefault(value, next);
    }

    private void setDefault(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}

public class LinkedList {
    private Node root;

    public LinkedList() {
        this.root = null;
    }

    /**
     * 삽입 메소드:
     *   - 값을 입력받아 해당 값을 가진 노드를 만들고 리스트의 맨 뒤에 연결
     *   - 리스트가 비어있는 경우 root에 연결
     *
     * @param value (int) 리스트에 삽입하려는 값
     */
    public void insert(int value) {
        Node node = new Node(value);
        if(this.root==null) {
            this.root = node;
        } else {
            Node point = this.root;
            while (point.next!=null) {
                point = point.next;
            }
            point.next = node;
        }
    }

    /**
     * 정렬 삽입 메소드:
     *   - 값을 입력받아 해당 값을 가진 노드를 만들고 오름차순으로 정렬하여 삽입 리스트의 맨 뒤에 연결
     *   - 리스트가 비어있는 경우 root에 연결
     *
     * @param value (int) 리스트에 삽입하려는 값
     */
    public void insertSorted(int value) {
        Node node = new Node(value);
        if (this.root==null) {
            this.root = node;

        } else if (value <= this.root.value) {
            node.next = this.root;
            this.root = node;

        } else {
            Node pre = null;
            Node point = this.root;

            while ((value > point.value)) {
                pre = point;
                point = point.next;
                if (point==null) {
                    break;
                }
            }
            node.next = point;
            pre.next = node;
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
                throw new Exception("List is Empty!");

            } else if (this.root.value==value) {
                this.root = this.root.next;

            } else {
                Node pre = this.root;
                Node target = this.root.next;

                while (target != null){
                    if (target.value==value) {
                        pre.next = target.next;
                        break;
                    }
                    pre = target;
                    target = target.next;
                }
                if (target == null) {
                    throw new Exception("There is no value!");
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * 리스트의 현재 가지고 있는 노드의 개수 출력
     *
     * @return (int) 리스트의 길이
     */
    public int length() {
        int len = 0;
        Node node = this.root;
        while (node!=null) {
            node = node.next;
            len++;
        }
        return len;
    }

    /**
     * 존재 여부 확인 메소드
     *   - 리스트를 처음부터 탐색하면서 노드의 값이 입력받은 값과 일차하면 true, 끝까지 탐색해도 없을 시 false 반환
     *
     * @param value (int) 존재 여부를 확인하고 싶은 값
     * @return (boolean) 존재 여부
     */
    public boolean contains(int value) {
        Node node = this.root;
        while (node!=null) {
            if (node.value == value) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return this.root==null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList [ ");
        Node node = this.root;
        while (node!=null) {
            sb.append(node.value);
            if(node.next!=null){
                sb.append(", ");
            }
            node = node.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

    public static void main(String args[]){
        String lstStr;
        int len;
        boolean result;

        LinkedList lkdList = new LinkedList();

        len = lkdList.length();
        System.out.println("Length of Linkedlist is " + len);

        System.out.println("Add value : 3");
        lkdList.insertSorted(3);
        System.out.println("Add value : 5");
        lkdList.insertSorted(5);
        System.out.println("Add value : 2");
        lkdList.insertSorted(2);
        System.out.println("Add value : 1");
        lkdList.insertSorted(1);
        System.out.println("Add value : 4");
        lkdList.insertSorted(4);
        System.out.println("Add value : 3");
        lkdList.insertSorted(3);
        lstStr = lkdList.toString();
        System.out.println(lstStr);

        System.out.println("Remove value : 1");
        lkdList.remove(1);
        lstStr = lkdList.toString();
        System.out.println(lstStr);

        System.out.println("Remove value : 3");
        lkdList.remove(3);
        lstStr = lkdList.toString();
        System.out.println(lstStr);

        System.out.println("Remove value : 5");
        lkdList.remove(5);
        lstStr = lkdList.toString();
        System.out.println(lstStr);

        System.out.println("Remove value : 7");
        lkdList.remove(5);
        lstStr = lkdList.toString();
        System.out.println(lstStr);

        len = lkdList.length();
        System.out.println("Length of Linkedlist is " + len);

        result = lkdList.contains(2);
        System.out.println("Does List contain 2? : " + result);
        result = lkdList.contains(7);
        System.out.println("Does List contain 7? : " + result);
    }
}
