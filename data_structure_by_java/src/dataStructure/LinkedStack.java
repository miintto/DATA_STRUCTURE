package dataStructure;
/**
 * 자료구조 Linked Stack 구현
 * <pre>
 * <b>Method</b>
 *     - push() : 삽입 메소드
 *     - pop() : 출력 메소드
 * </pre>
 *
 * <pre>
 * <b>History:</b>
 *     박민재, 1.0  2020.08.09 최초 작성
 * </pre>
 *
 * @author 박민재
 * @version 1.0
 */

class StackNode {
    public String value;
    public StackNode next;

    StackNode() {
        setDefault(null, null);
    }

    StackNode(String value) {
        setDefault(value, null);
    }

    StackNode(String value, StackNode next) {
        setDefault(value, next);
    }

    private void setDefault(String value, StackNode next) {
        this.value = value;
        this.next = next;
    }
}

public class LinkedStack {
    private StackNode top;
    private int size;

    LinkedStack() {
        this.top = null;
        this.size = 0;
    }

    /**
     * 삽입 메소드:
     * <pre>
     * 입력받은 값으로 노드를 만들어 top에 연결
     * </pre>
     *
     * @param value (String) 스택에 삽입할 값
     */
    public void push(String value) {
        StackNode node = new StackNode(value);
        if (this.top == null) {
            this.top = node;
        } else {
            node.next = this.top;
            this.top = node;
        }
        this.size++;
    }

    /**
     * 출력 메소드:
     * <pre>
     * top에 있는 노드를 삭제하고 그 다음 연결되어 있던 노드를 top에 연결
     * </pre>
     */
    public void pop(){
        try {
            if (this.top == null) {
                throw new Exception("The Stack is Empty!");
            } else {
                System.out.println("Pop : " + this.top.value);
                this.top = this.top.next;
                this.size--;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean contains(String value) {
        StackNode node = this.top;
        while (node != null) {
            if (node.value == value) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    public void print() {
        System.out.print("Stack = [ ");
        StackNode node = this.top;
        while (node != null) {
            System.out.print(node.value);
            node = node.next;
            if (node != null) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }

    public static void main(String args[]) {
        int len;
        boolean result;

        LinkedStack stack = new LinkedStack();

        System.out.println("Push value : A");
        stack.push("A");
        System.out.println("Push value : B");
        stack.push("B");
        System.out.println("Push value : C");
        stack.push("C");
        stack.print();

        len = stack.size();
        System.out.println("The Length of Stack is " + len);

        result = stack.contains("A");
        System.out.println("Does Stack contain 'A'? : " + result);
        result = stack.contains("Z");
        System.out.println("Does Stack contain 'Z'? : " + result);

        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();

    }
}
