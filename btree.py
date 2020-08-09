class BTreeNode:
    """
    B트리 노드
    """
    def __init__(self, n):
        self.child = list()
        self.value = list()
        self.n = n

    def __str__(self):
        return f'TreeNode.value = {self.value}'

    def add_value(self, value):

        self.value.append(value)

    def _check_valid(self):
        if len(self.child)>self.n+1:
            raise ValueError
        if len(self.value)>self.n:
            raise ValueError
