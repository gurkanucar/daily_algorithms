package day3_commonPrefix;

import java.util.*;

class Trie {

    private boolean isLeaf;
    private final Map<Character, Trie> children;


    Trie() {
        isLeaf = false;
        children = new HashMap<>();
    }

    public void insert(String key) {
        Trie curr = this;
        for (char c : key.toCharArray()) {
            curr.children.putIfAbsent(c, new Trie());
            curr = curr.children.get(c);
        }
        curr.isLeaf = true;
    }

    public String commonPrefix() {
        String prefix = "";
        Trie current = this;
        while (current.children.size() == 1 && !current.isLeaf) {
            var key = current.children.keySet().toArray()[0];
            current = current.children.get(key);
            if (current != null) {
                prefix += key;
            } else {
                break;
            }
        }
        return prefix;
    }

    public boolean search(String key) {
        Trie curr = this;
        for (char c : key.toCharArray()) {
            curr = curr.children.get(c);
            if (curr == null) {
                return false;
            }
        }
        return curr.isLeaf;
    }

    public boolean startsWith(String key) {
        int counter = 0;
        Trie current = this;
        for (char c : key.toCharArray()) {
            current = current.children.get(c);
            if (current == null) {
                return false;
            }
            counter++;
        }
        return key.length() == counter;
    }

}


public class Main {

    public static void main(String[] args) {

        //find longest common prefix for given inputs
        // team, test, tear

        Trie trie = new Trie();

//        trie.insert("flow");
//        trie.insert("flight");
//        trie.insert("flower");

        String startsWith = "fli";
        System.out.printf("starts with %s: %s\n", startsWith, trie.startsWith(startsWith));

        startsWith = "a";
        System.out.printf("starts with %s: %s\n", startsWith, trie.startsWith(startsWith));

        String search = "fli";
        System.out.printf("search for %s: %s\n", search, trie.search(search));

        search = "flight";
        System.out.printf("search for %s: %s\n", search, trie.search(search));

        System.out.println("Most common prefix: " + trie.commonPrefix());

    }


}
