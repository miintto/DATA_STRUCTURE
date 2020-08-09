package dataStructure;

// 이 ArrayList는 Integer Type만 다룬다
public class ArrayList {
    private int size;      // ArrayList 초기 사이즈 설정 변수
    private int index;     // ArrayList 초기 포인터 위치 변수
    private int array[];   // 배열 선언용 변수

    // 클래스 생성자
    ArrayList() {
        // 1. 배열 선언
        // 2. 클래스의 size 초기 세팅 진행 => size 10으로
        setDefaut(10);
    }

    // 클래스 생성자 Overiding
    ArrayList(int size) {
        // 1. 배열 선언
        // 2. 클래스의 size 초기 세팅 진행 => size 10으로
        setDefaut(size);
    }

    private void setDefaut(int size){
        this.size = size;
        this.index = 0;
        this.array = new int[size];
    }

    public void add(int data) {
        // 3. add method 구현
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

    public void remove(int index) {
        // 4. remove method 구현
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

    public int indexOf(int data) {
        // 5. indexOf method 구현
        for(int i=0; i<this.index; i++){
            if(this.array[i]==data){
                return i;
            }
        }
        return -1;
    }

    public int size() {
        // 6. size method 구현
        return this.size;
    }

    public boolean contains(int data) {
        // 7. 해당 데이터가 ArrayList 내부에 존재 여부를 반환
        return indexOf(data)!=-1;
    }

    public boolean isFull(){
        // 8. ArrayList가 꽉 찬 상태인지 반환
        return this.index==this.size;
    }

    public boolean isEmpty(){
        // 9. ArrayList가 비어있는 상태인지 반환
        return this.index==0;
    }

    public boolean isValidIndex(int data){
        // 입력받은 인덱스가 올바른지 점검
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

    // 클래스를 테스트 해 볼 수 있는 메인 함수
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

