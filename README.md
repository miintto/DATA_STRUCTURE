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

- Code
~~~python
>>> from binary_search_tree import BinarySearchTree

>>> tree = BinarySearchTree()

### 삽입
>>> array = [21, 28, 14, 32, 25, 18, 11, 30, 19, 15]
>>> for i in array:
...    tree.insert(i)

### 탐색
>>> tree.search(15)
Search value 15 : True

>>> tree.search(16)
Search value 16 : False

### 전위순회
>>> tree.preorder()
<BinarySearchTree Preorder>
TreeNode.value = 21
TreeNode.value = 14
TreeNode.value = 11
TreeNode.value = 18
TreeNode.value = 15
TreeNode.value = 19
TreeNode.value = 28
TreeNode.value = 25
TreeNode.value = 32
TreeNode.value = 30

### 중위순회
>>> tree.inorder()
<BinarySearchTree Inorder>
TreeNode.value = 11
TreeNode.value = 14
TreeNode.value = 15
TreeNode.value = 18
TreeNode.value = 19
TreeNode.value = 21
TreeNode.value = 25
TreeNode.value = 28
TreeNode.value = 30
TreeNode.value = 32

### 후위순회
>>> tree.postorder()
<BinarySearchTree Postorder>
TreeNode.value = 11
TreeNode.value = 15
TreeNode.value = 19
TreeNode.value = 18
TreeNode.value = 14
TreeNode.value = 25
TreeNode.value = 30
TreeNode.value = 32
TreeNode.value = 28
TreeNode.value = 21
~~~
