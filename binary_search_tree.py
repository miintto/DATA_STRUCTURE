class TreeNode:
    """
    트리 노드
    """
    def __init__(self, value):
        self.child_left = None
        self.child_right = None
        self.value = value

    def __str__(self):
        return f'<TreeNode.value = {self.value}>'


class BinarySearchTree:
    """
    이진 탐색 트리 - 삽입 / 탐색 / 삭제 알고리즘 구현
        장점 : 일반 배열에 비해 탐색 속도가 빠름 (일반적으로 log n 의 시간 복잡도)
        단정 : 균형잡혀있지 않은 경우 느려질 수 있음
    """
    def __init__(self):
        self.root = None


    def insert(self, value):
        """
        이진탐색트리 삽입 알고리즘
            1. 처음 값 삽입시 (root가 None인 경우) root에 입력
            2. 부모 노드의 값보다 작으면 왼쪽으로, 크면 오른쪽 노드로 이동
            3. 더 이상 이동할 곳이 없으면 (Node가 None인 경우) 해당 위치에 삽입
        """
        self.root = self._insert_value(self.root, value)
        print(f'Insert value : {value}', end='\n\n')

    def _insert_value(self, node, value):
        if node == None:
            node = TreeNode(value)
        else:
            if value < node.value:
                node.child_left = self._insert_value(node.child_left, value)
            else:
                node.child_right = self._insert_value(node.child_right, value)
        return node


    def search(self, value):
        """
        이진탐색트리 탐색 알고리즘
            1. 부모 노드 값보다 작으면 왼쪽으로, 크면 오른쪽으로 이동
            2. 일치하는 값이 있으면 Ture 반환
            3. 더 이상 이동할 곳이 없으면 False 반환
        """
        result, n = self._search_value(self.root, value)
        print(f'Search value {value} : {result}  ({n} times)', end='\n\n')

    def _search_value(self, node, value, n=1):
        if node is None:
            return False, n
        elif value == node.value:
            return True, n
        elif value < node.value:
            n+=1
            return self._search_value(node.child_left, value, n)
        else:
            n+=1
            return self._search_value(node.child_right, value, n)


    def preorder(self):
        """
        이진탐색트리 전위순회 알고리즘
            depth를 고려하여 indent 적용

            root -> left -> right 순서로 순회
        """
        print('<BinarySearchTree Preorder>')
        self._preorder_travel(self.root)
        print()

    def _preorder_travel(self, node, depth=-1):
        depth+=1
        if node is not None:
            print(f' {"|   "*depth}|-- {node}')
            self._preorder_travel(node.child_left, depth)
            self._preorder_travel(node.child_right, depth)


    def inorder(self):
        """
        이진탐색트리 전위순회 알고리즘
            depth를 고려하여 indent 적용

            left -> root -> right 순서로 순회
        """
        print('<BinarySearchTree Inorder>')
        self._inorder_travel(self.root)
        print()

    def _inorder_travel(self, node, depth=-1):
        depth+=1
        if node is not None:
            self._inorder_travel(node.child_left, depth)
            print(f' {"|  "*depth}|-- {node}')
            self._inorder_travel(node.child_right, depth)


    def postorder(self):
        """
        이진탐색트리 전위순회 알고리즘
            depth를 고려하여 indent 적용

            left -> right -> root 순서로 순회
        """
        print('<BinarySearchTree Postorder>')
        self._postorder_travel(self.root)
        print()

    def _postorder_travel(self, node, depth=-1):
        depth+=1
        if node is not None:
            self._postorder_travel(node.child_left, depth)
            self._postorder_travel(node.child_right, depth)
            print(f' {"|  "*depth}|-- {node}')


    def delete(self, value):
        """
        이진탐색트리 삭제 알고리즘
            1. 삭제할 노드의 자식이 두 개인 경우
                > 오른쪽 자식 중 가장 작은 값으로 채움
            2. 삭제할 노드의 자식이 한 개인 경우
                > 해당 노드의 부모와 자식 노드를 연결
            3. 삭제할 노드가 leaf 노드인 경우
                > 해당 노드 삭제
        """
        self.root, result = self._delete_value(self.root, value)
        print(f'Delete value {value} : {result}', end='\n\n')

    def _delete_value(self, node, value):
        result = True
        if node is None:
            return node, False

        elif value == node.value:
            if node.child_left and node.child_right:
                '''자식 노드가 둘 다 있는 경우'''
                parent = node
                child = node.child_right
                while child.child_left is not None:
                    parent = child
                    child = child.child_left
                    ### child: 대체할 노드
                child.child_left = node.child_left
                if parent != node:
                    parent.child_left = child.child_right
                    child.child_right = node.child_right
                node = child
            elif node.child_left or node.child_right:
                '''자식 노드가 한 쪽만 있는 경우'''
                node = node.child_left or node.child_right
            else:
                '''Leaf 노드인 경우'''
                node = None

        elif value < node.value:
            node.child_left, result = self._delete_value(node.child_left, value)
        else:
            node.child_right, result = self._delete_value(node.child_right, value)
        return node, result


if __name__=='__main__':
    tree = BinarySearchTree()

    ### 삽입
    array = [21, 28, 14, 32, 25, 18, 11, 30, 19, 15]
    for i in array:
        tree.insert(i)

    ### 탐색
    tree.search(15)
    tree.search(16)

    ### 전위순회
    tree.preorder()
    ### 중위순회
    tree.inorder()
    ### 후위순회
    tree.postorder()

    ### 삭제
    tree.delete(15)
    tree.delete(16)
    tree.delete(18)
    tree.delete(21)

    tree.inorder()