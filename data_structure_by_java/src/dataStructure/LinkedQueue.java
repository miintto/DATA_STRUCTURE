package dataStructure;
/**
 * 자료구조 Linked Queue 구현
 *   - 구조: [rear] -> [ ] -> [ ] -> [front]
 * <pre>
 * <b>Method</b>
 *     - enqueue() : 삽입 메소드
 *     - dequeue() : 출력 메소드
 * </pre>
 *
 * <pre>
 * <b>History:</b>
 *     박민재, 1.0  2020.08.15 최초 작성
 * </pre>
 *
 * @author 박민재
 * @version 1.0
 */

public class LinkedQueue {
    private Node front;
    private Node rear;

    LinkedQueue() {
        this.front = null;
        this.rear = null;
    }

    /**
     * 삽입 메소드:
     * <pre>
     * 생성한 노드를 front 바로 다음에 연결 후, front 값을 새 노드로 업데이트
     * </pre>
     *
     * @param value (int) 큐에 넣을 값
     */
    public void enqueue(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            this.front = node;
            this.rear = node;

        } else {
            this.front.next = node;
            this.front = this.front.next;
        }
    }

    /**
     * 출력 메소드:
     * <pre>
     * - rear값 출력 후, rear를 그 다음 값으로 업데이트
     * </pre>
     *
     * @exception Exception 큐가 비어있는 경우 예외처리
     */
    public void dequeue() {
        try {
            if (isEmpty()) {
                throw new Exception("The Queue is Empty!");
            }

            else {
                System.out.println(this.rear.value);
                this.rear = this.rear.next;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void print() {
        System.out.print("LinkedQueue = [ ");
        Node point = this.rear;
        while(point != null) {
            System.out.print(point.value);
            point = point.next;
            if (point != null) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }

    public boolean isEmpty() {
        return this.rear ==null;
    }

    public static void main(String args[]) {
        LinkedQueue queue = new LinkedQueue();

        System.out.println("Enqueue : 1");
        queue.enqueue(1);
        System.out.println("Enqueue : 2");
        queue.enqueue(2);
        System.out.println("Enqueue : 3");
        queue.enqueue(3);
        queue.print();

        System.out.print("Dequeue : ");
        queue.dequeue();
        System.out.print("Dequeue : ");
        queue.dequeue();
        System.out.println("Enqueue : 4");
        queue.enqueue(4);
        queue.print();

        System.out.print("Dequeue : ");
        queue.dequeue();
        System.out.print("Dequeue : ");
        queue.dequeue();
        queue.print();

        System.out.println("Enqueue : 5");
        queue.enqueue(5);
        System.out.println("Enqueue : 6");
        queue.enqueue(6);
        queue.print();
    }
}
