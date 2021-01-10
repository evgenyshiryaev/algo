package algo.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TrieTest {

    @Test
    public void test() {
        Trie trie = new Trie();

        Assertions.assertFalse(trie.search("data"));
        Assertions.assertFalse(trie.startsWith("da"));
        Assertions.assertFalse(trie.startsWith("data"));

        trie.insert("da");
        Assertions.assertTrue(trie.search("da"));
        Assertions.assertFalse(trie.search("data"));
        Assertions.assertTrue(trie.startsWith("da"));
        Assertions.assertFalse(trie.startsWith("data"));

        trie.insert("data");
        Assertions.assertTrue(trie.search("data"));
        Assertions.assertFalse(trie.search("dat"));
        Assertions.assertTrue(trie.search("data"));
        Assertions.assertTrue(trie.startsWith("da"));
        Assertions.assertTrue(trie.startsWith("data"));
    }

}
