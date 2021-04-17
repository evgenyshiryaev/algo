package algo.ds;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class Trie {

    private static class Node {
        boolean isWord;
        final Node[] childs = new Node['z' - 'a' + 1];
    }


    private final Node root = new Node();


    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); ++ i) {
            int c = word.charAt(i) - 'a';
            if (node.childs[c] == null) {
                node.childs[c] = new Node();
            }
            node = node.childs[c];
        }
        node.isWord = true;
    }


    public boolean search(String word) {
        Node node = getNode(word);
        return node != null && node.isWord;
    }



    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }


    private Node getNode(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); ++ i) {
            int c = word.charAt(i) - 'a';
            node = node.childs[c];
            if (node == null) {
                return null;
            }
        }
        return node;
    }


    public List<Node> getWords(Node parent) {
        List<Node> result = new ArrayList<>();

        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(parent);

        while (!deque.isEmpty()) {
            int size = deque.size();

            while (size -- > 0) {
                Node node = deque.removeFirst();
                if (node.isWord) {
                    result.add(node);
                }

                for (Node n : node.childs) {
                    if (n != null) {
                        deque.addLast(n);
                    }
                }
            }
        }

        return result;
    }

}
