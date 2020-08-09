package dataStructure;
/**
 * 자료구조 Array List 구현
 *
 * <pre>
 * <b>History:</b>
 *     박민재, 1.0  2020.08.09 최초 작성
 * </pre>
 *
 * @author 박민재
 * @version 1.0
 */

public class ArrayList {
    private int size;      // ArrayList 초기 사이즈 설정 변수
    private int index;     // ArrayList 초기 포인터 위치 변수
    private int array[];   // 배열 선언용 변수

    ArrayList() {
        setDefaut(10);
    }

    ArrayList(int size) {
        setDefaut(size);
    }

    private void setDefaut(int size){
        this.size = size;
        this.index = 0;
        this.array = new int[size];
    }

    /**
     * 삽입 메소드 구현:
     *   - 값을 입력받아서 배열의 index 위치에 값 저장 후 index값 1 증가
     *
     * @param data (int) 입력받을 값
     * @exception Exception 배열이 가득 찬 경우 예외처리
     */
    public void add(int data) {
        try {
            if (!isFull()) {
                this.array[this.index] = data;
                this.index++;
            } else {
                throw new Exception("ArrayList is Full!");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * 삭제 메소드:
     *   - index값을 입력받아서 해당하는 위치부터 뒤의 값들을 1칸씩 앞으로 당겨온 후 index값 1 감소
     *
     * @param index (int) 배열에서 삭제하고자 하는 인덱스 값
     * @exception Exception 배열이 비어있는 경우 예외처리
     * @exception Exception index값이 범위에서 벗어난 경우 예외처리
     */
    public void remove(int index) {
        try {
            if(isEmpty()) {
                throw new Exception("ArrayList is Empty!");
            } else if (!isValidIndex(index)) {
                throw new Exception("Invalid Index!");
            } else {
                for(int i=index; i<this.index-1; i++){
                    this.array[i] = this.array[i+1];
                }
                this.index--;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 인덱스 탐색 메소드:
     *   - 입력받은 인덱스 값을 배열에서 탐색하여 처음으로 발견한 위치의 인덱스 값을 리턴
     *
     * @param data (int) 인덱스를 알고 싶은 값
     * @return (int) 입역받은 값의 인덱스 값, 존재하지 않는 경우는 -1
     */
    public int indexOf(int data) {
        for(int i=0; i<this.index; i++){
            if(this.array[i]==data){
                return i;
            }
        }
        return -1;
    }

    /**
     * 배열의 총 길이 출력
     *
     * @return (int) 배열의 총 길이
     */
    public int size() {
        return this.size;
    }

    /**
     * 존재 여부 확인 메소드
     *   - 입력받은 값을 처음부터 탐색하여 배열에 들어있으면 true, 없으면 false 반환
     *   - indexOf 메소드를 활용하여 -1이 아니면 포함되어 있다고 판단
     *
     * @param data (int) 존재 여부를 확인하고 싶은 값
     * @return (boolean) 존재 여부
     */
    public boolean contains(int data) {
        return indexOf(data)!=-1;
    }

    public boolean isFull(){
        return this.index==this.size;
    }

    public boolean isEmpty(){
        return this.index==0;
    }

    public boolean isValidIndex(int data){
        return (0<=data) & (data < this.index);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GTHArrayList [ ");
        for(int i=0; i<this.index; i++){
            sb.append(this.array[i]);
            if(i != this.index - 1){
                sb.append(", ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }

    public static void main(String args[]){
        String aryStr;
        int idx;
        boolean result;

        ArrayList aryList = new ArrayList(5);

        result = aryList.isEmpty();
        System.out.println("Is empty? : " + result);

        System.out.println("Remove index : 0");
        aryList.remove(0);
        aryStr = aryList.toString();
        System.out.println(aryStr);

        System.out.println("Add value : 1");
        aryList.add(1);
        System.out.println("Add value : 2");
        aryList.add(2);
        System.out.println("Add value : 5");
        aryList.add(5);
        System.out.println("Add value : 4");
        aryList.add(4);
        System.out.println("Add value : 5");
        aryList.add(5);
        System.out.println("Add value : 5");
        aryList.add(5);
        aryStr = aryList.toString();
        System.out.println(aryStr);

        System.out.println("Remove index : 0");
        aryList.remove(0);
        aryStr = aryList.toString();
        System.out.println(aryStr);

        System.out.println("Remove index : 2");
        aryList.remove(2);
        aryStr = aryList.toString();
        System.out.println(aryStr);

        System.out.println("Remove index : 3");
        aryList.remove(3);
        aryStr = aryList.toString();
        System.out.println(aryStr);

        System.out.println("Remove index : -1");
        aryList.remove(-1);
        aryStr = aryList.toString();
        System.out.println(aryStr);

        idx = aryList.indexOf(5);
        System.out.println("Index of 5 is " + idx);

        result = aryList.contains(5);
        System.out.println("Does List contain 5? : " + result);
        result = aryList.contains(2);
        System.out.println("Does List contain 2? : " + result);
        result = aryList.contains(7);
        System.out.println("Dose List contain 7? : " + result);
    }
}

