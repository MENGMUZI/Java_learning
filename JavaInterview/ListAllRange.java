/**
 * @author : mengmuzi
 * create at:  2019-05-03  21:31
 * @description: 把一个数组里的数组合全部列出
 *
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * 思路就是固定前缀 prefix，然后还有剩下的候选candidate。从候选里面选择一些加到前缀后面。
 * 比如固定前缀1，然后加上2，再从后面的34 选中3，然后是4。得到1234。或者 从后面的34里面先选4，然后是3。得到1243。
* */
public class ListAllRange {
    static TreeSet treeSet = new TreeSet();
    public static void main(String[] args) {
        String[] array = new String[]{"1","2","2","3","4"};
        listAll(Arrays.asList(array),"");
        //System.out.println(treeSet);
    }

    private static void listAll(List<String> candidate, String prefix) {
        if(candidate.isEmpty() && treeSet.add(prefix)){
            System.out.println(prefix);
            //treeSet.add(prefix);
        }
        for (int i = 0; i <candidate.size() ; i++) {
            List temp = new LinkedList(candidate);
            listAll(temp,prefix + temp.remove(i));
        }
    }

}
