# 자료구조 by Python

## 1. 이진 탐색 트리
- Node 객체로 구성
- 장점 : 일반 배열에 비해 탐색 속도가 빠름 
    - 일반적으로 **O(log n)** 의 시간 복잡도를 가진다.
- 단점 : 균형이 잡혀 있지 않은 경우 (Node들이 한 쪽으로 쏠려 있는 경우) 느려질 수 있음

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

<img src="https://github.com/miintto/DATA_STRUCTURE/blob/master/img/binary_search_tree_insertion_animation.gif">

### 1.2 탐색 알고리즘
- 일반적으로 O(log n)의 시간복잡도
  - 불균형한 경우 최대 O(n)까지 걸릴 수 있음
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

### 1.3 순회 알고리즘
~~~python
def preorder(self):
    """
    전위순회
    """
    self._preorder_travel(self.root)

def _preorder_travel(self, node):
    if node is not None:
        print(f'{node}')
        self._preorder_travel(node.child_left)
        self._preorder_travel(node.child_right)


def inorder(self):
    """
    중위순회
    """
    self._inorder_travel(self.root)

def _inorder_travel(self, node):
    if node is not None:
        self._inorder_travel(node.child_left)
        print(f'{node}')
        self._inorder_travel(node.child_right)


def postorder(self):
    """
    후위순회
    """
    self._postorder_travel(self.root)

def _postorder_travel(self, node):
    if node is not None:
        self._postorder_travel(node.child_left)
        self._postorder_travel(node.child_right)
        print(f'{node}')
~~~

### 1.4 삭제 알고리즘
 * 삭제할 노드의 자식이 두 개인 경우
    - 오른쪽 자식 중 가장 작은 값으로 대체 (혹은 왼쪽 자식 중 가장 큰 값으로 대체)
 * 삭제할 노드의 자식이 한 개인 경우
    - 해당 노드의 부모와 자식 노드를 서로 연결
 * 삭제할 노드가 말단 노드인 경우
    - 해당 노드만 삭제
~~~python
def delete(self, value):
    self.root, result = self._delete_value(self.root, value)
    print(f'Delete value {value} : {result}', end='\n\n')

def _delete_value(self, node, value):
    result = True
    if node is None:
        return node, False
    elif value == node.value:
        if node.child_left and node.child_right:
            parent = node
            child = node.child_right
            while child.child_left is not None:
                parent = child
                child = child.child_left
            child.child_left = node.child_left
            if parent != node:
                parent.child_left = child.child_right
                child.child_right = node.child_right
            node = child
        elif node.child_left or node.child_right:
            node = node.child_left or node.child_right
        else:
            node = None
    elif value < node.value:
        node.child_left, result = self._delete_value(node.child_left, value)
    else:
        node.child_right, result = self._delete_value(node.child_right, value)
    return node, result
~~~
