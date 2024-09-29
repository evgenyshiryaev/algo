from dataclasses import dataclass, field
from typing import TypeVar

Node = TypeVar("Node")


@dataclass
class Node:
    data: int
    left: Node = field(default=None, repr=False)
    right: Node = field(default=None, repr=False)

class LinkedList:
    def __init__(self):
        self.first = Node(-1)
        self.last = Node(-1, self.first)
        self.first.right = self.last
        self.size = 0

    def add_left(self, right, data) -> Node:
        left = right.left
        node = Node(data, left, right)
        left.right = node
        right.left = node
        self.size += 1
        return node

    def add_right(self, left, data) -> Node:
        right = left.right
        node = Node(data, left, right)
        left.right = node
        right.left = node
        self.size += 1
        return node

    def remove(self, node: Node):
        node.left.right, node.right.left = node.right, node.left
        self.size -= 1

    def __str__(self):
        s = 'LinkedList size=' + str(self.size)
        node = self.first.right
        while node != self.last:
            s += ' ' + str(node.data)
            node = node.right
        return s


if __name__ == '__main__':
    ll = LinkedList()
    print(ll)
    node0 = ll.add_right(ll.first, 0)
    node1 = ll.add_right(node0, 1)
    node2 = ll.add_left(node1, 2)
    print(ll)
    ll.remove(node0)
    ll.remove(node2)
    print(ll)
