import dataclasses


@dataclasses.dataclass
class Node:
    is_word: bool
    childs: dataclasses.field(default_factory=list)

    def __init__(self):
        self.is_word = False
        self.childs = [None] * 26


@dataclasses.dataclass
class Trie:
    root: Node = Node()

    def insert(self, word: str):
        node = self.root
        for c in word:
            i = ord(c) - ord('a')
            if node.childs[i] is None:
                node.childs[i] = Node()
            node = node.childs[i]
        node.is_word = True


    def get_node(self, word: str) -> Node:
        node = self.root
        for c in word:
            i = ord(c) - ord('a')
            node = node.childs[i]
            if node is None:
                return None
        return node


if __name__ == '__main__':
    _trie = Trie()
    assert _trie.get_node('unkn') is None
    _trie.insert('word')
    _node = _trie.get_node('wor')
    assert _node is not None and not _node.is_word
    _node = _trie.get_node('word')
    assert _node is not None and _node.is_word
