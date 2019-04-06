/**
 * @author : mengmuzi
 * create at:  2019-04-06  21:13
 * @description: 字典树
 */
public class Trie {
    public class TrieNode{
        public int path;//共用这个节点的单词数
        public int end;//以这个节点结尾的单词数
        public TrieNode[] map;
        public TrieNode(){
            path = 0;
            end = 0;
            map = new TrieNode[26];
        }
    }

    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word){
        if(word == null){
            return;
        }
        char[] chs = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i <chs.length ; i++) {
            index = chs[i] - 'a';
            if(node.map[index] == null){
                node.map[index] = new TrieNode();
            }
            node = node.map[index];
            node.path ++;

        }
        node.end ++;

    }

    public void delete(String word){
        if(search(word)){
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i <chs.length ; i++) {
                index = chs[i] - 'a';
                if(node.map[index].path --== 1){
                    node.map[index] = null;//如果当前节点只有一个单词共用，就把下面全部删掉
                    return;
                }
                node = node.map[index];
            }
            node.end--;

        }
    }

    public boolean search(String word){
        if(word == null){
            return false;
        }
        char[] chs = word.toCharArray();
        int index = 0;
        TrieNode node = root;
        for (int i = 0; i <chs.length ; i++) {
            index = chs[i] - 'a';
            if(node.map[index] == null){
                return false;
            }
            node = node.map[index];
        }
        return node.end != 0;

    }
    public int prefixNumber(String pre){
        if(pre == null){
            return 0;
        }
        char[] chs = pre.toCharArray();
        int index = 0;
        TrieNode node = root;
        for (int i = 0; i <pre.length(); i++) {
            index = chs[i] - 'a';
            if(node.map[index] == null){
                return 0;

            }
            node = node.map[index];
        }
        return node.path;
    }
}
