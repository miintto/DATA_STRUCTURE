# 자료구조 by Python

## 1. 이진 탐색 트리
- Node 객체로 구성
- 장점 : 일반 배열에 비해 탐색 속도가 빠름 (일반적으로 log n 의 시간 복잡도)
- 단점 : 균형이 잡혀 있지 않은 경우 느려질 수 있음
### 1.1 삽입 알고리즘
- 재귀함수를 이용하여 Node 객체 반환하는 방식으로 작성
~~~
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

- 삽입
~~~ python
tree = BinarySearchTree()
array = [21, 28, 14, 32, 25, 18, 11, 30, 19, 15]
for i in array:
    tree.insert(i)
~~~
<img src="https://github.com/miintto/DATA_STRUCTURE/blob/master/img/binary_search_tree_insertion_animation.gif">
