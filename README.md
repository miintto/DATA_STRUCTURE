# 자료구조 by Python

## 1. 이진 탐색 트리
- Node 객체로 구성
- 장점 : 일반 배열에 비해 탐색 속도가 빠름 (일반적으로 log n 의 시간 복잡도)
- 단점 : 균형이 잡혀 있지 않은 경우 느려질 수 있음
### 1.1 삽입 알고리즘
- 재귀함수를 이용하여 Node 객체 반환하는 방식으로 작성
~~~python
def insert(self, value):
    self.root = self._insert_value(self.root, value)

def _insert_value(self, node, value):
    if node == None:
        node = Node(value)
    else:
        if value < node.value:
            node.child_left = self._insert_value(node.child_left, value)
        else:
            node.child_right = self._insert_value(node.child_right, value)
    return node
~~~

### 1.2 탐색 알고리즘
~~~python
def search(self, value):
    result = self._search_value(self.root, value)
    print(f'search {value} = {result}')

def _search_value(self, node, value):
    if node is None:
        return False
    elif node.value==value:
        return True
    elif value < node.value:
        return self._search_value(node.child_left, value)
    else:
        return self._search_value(node.child_right, value)
~~~

- Code

<img src="https://github.com/miintto/DATA_STRUCTURE/blob/master/img/binary_search_tree_insertion_animation.gif">

~~~python
tree = BinarySearchTree()

### 삽입
array = [21, 28, 14, 32, 25, 18, 11, 30, 19, 15]
for i in array:
    tree.insert(i)

tree.print()

<BinarySearchTree>
 > Node.value = 21
     > Node.value = 14
         > Node.value = 11
             > None
             > None
         > Node.value = 18
             > Node.value = 15
                 > None
                 > None
             > Node.value = 19
                 > None
                 > None
     > Node.value = 28
         > Node.value = 25
             > None
             > None
         > Node.value = 32
             > Node.value = 30
                 > None
                 > None
             > None

### 탐색
tree.search(15)
tree.search(16)

search 15 = True
search 16 = False
~~~
