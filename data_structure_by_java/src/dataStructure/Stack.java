package dataStructure;
/**
 * 자료구조 Stack 구현
 *
 * <pre>
 * <b>History:</b>
 *     박민재, 1.0  2020.08.09 최초 작성
 * </pre>
 *
 * @author 박민재
 * @version 1.0
 */

public class Stack {
    private int size;      // Stack의 총 크기 (default: 10)
    private int top;       // 가장 위의 값의 인덱스
    private int[] array;   // Stack 배열

    Stack() {
        setDefault(10);
    }

    Stack(int size) {
        setDefault(size);
    }

    private void setDefault(int size) {
        this.size = size;
        this.top = -1;
        this.array = new int[size];
    }

    /**
     * 삽입 메소드:
     *   - top 값 1 증가 후 입력받은 값을 top 위치에 삽입
     *
     * @param value (int) 스택에 삽입하려는 값
     * @exception Exception 가득 찬 경우 예외처리
     */
    public void push(int value) {
        try {
            if (!isFull()) {
                this.array[++this.top] = value;
            } else {
                throw new Exception("The Stack is Full!");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * pop 메소드:
     *   - top 위치의 값을 제거 후 top 값 1 감소
     *
     * @exception Exception 스택이 비어있는 경우 예외처리
     */
    public void pop() {
        try {
            if (!isEmpty()) {
                System.out.println("Pop : " + this.array[this.top--]);
            } else {
                throw new Exception("The Stack is Empty!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isFull() {
        return this.top+1==this.size;
    }

    public boolean isEmpty() {
        return this.top==-1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack [ ");
        for(int i=0; i<=this.top; i++){
            sb.append(this.array[i]);
            if(i != this.top ){
                sb.append(", ");
            }
        }
        sb.append(" ] <-");
        return sb.toString();
    }

    public static void main(String args[]) {
        String stkStr;
        int value;

        Stack stack = new Stack(5);

        stack.pop();

        System.out.println("Push value : 11");
        stack.push(11);
        System.out.println("Push value : 3");
        stack.push(3);
        System.out.println("Push value : 6");
        stack.push(6);
        System.out.println("Push value : 8");
        stack.push(8);
        System.out.println("Push value : 2");
        stack.push(2);
        System.out.println("Push value : 1");
        stack.push(1);
        stkStr = stack.toString();
        System.out.println(stkStr);

        stack.pop();
        stkStr = stack.toString();
        System.out.println(stkStr);

        stack.pop();
        stkStr = stack.toString();
        System.out.println(stkStr);

        stack.pop();
        stkStr = stack.toString();
        System.out.println(stkStr);
    }
}
