class Node:
    """
    트리 노드
    """
    def __init__(self, value):
        self.child_left = None
        self.child_right = None
        self.value = value

    def __str__(self):
        return f'Node.value = {self.value}'


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
            재귀 함수 이용하여 Node 객체 반환

            1. 처음 값 삽입시 (root가 None인 경우) root에 입력
            2. 부모 노드의 값보다 작으면 왼쪽으로, 크면 오른쪽 노드로 이동
            3. 더 이상 이동할 곳이 없으면 (Node가 None인 경우) 해당 위치에 삽입
        """
        self.root = self._insert_value(self.root, value)

    def print(self):
        """
        이진탐색트리의 값 확인하도록
            depth를 고려하여 indent 적용
        """
        print('<BinarySearchTree>')
        self._print_values(self.root)


    def _insert_value(self, node, value):
        if node == None:
            node = Node(value)
        else:
            if value < node.value:
                node.child_left = self._insert_value(node.child_left, value)
            else:
                node.child_right = self._insert_value(node.child_right, value)
        return node

    def _print_values(self, node, depth=0):
        print(f'{"    " * depth} > {node}')
        if node is not None:
            depth += 1
            self._print_values(node.child_left, depth)
            self._print_values(node.child_right, depth)



if __name__=='__main__':
    tree = BinarySearchTree()

    array = [21, 28, 14, 32, 25, 18, 11, 30, 19, 15]
    for i in array:
        tree.insert(i)

    tree.print()