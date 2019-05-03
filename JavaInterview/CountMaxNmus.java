import java.util.*;

/**
 * @author : mengmuzi
 * create at:  2019-05-03  23:54
 * @description: 寻找字符串中出现次数最多的那个字母和次数
 */
public class CountMaxNmus {
    public static void main(String[] args) {
        String input = "asdsafdsfsdgfxzzcxzwesdfgsgscxzdfs";
        new CountMaxNmus().countNums(input);
    }

    private void countNums(String input) {
        char[] chars = input.toCharArray();
        ArrayList arrayList = new ArrayList();
        TreeSet treeSet = new TreeSet();
        for (int i = 0; i <chars.length ; i++) {
            arrayList.add(String.valueOf(chars[i]));
            treeSet.add(String.valueOf(chars[i])); // 为了去除重复的字符串
        }
        System.out.println("treeSet :" + treeSet);
        Collections.sort(arrayList);
        System.out.println("arrayList :" + arrayList);

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i <arrayList.size() ; i++) {
            stringBuffer.append(arrayList.get(i));
        }
        input = stringBuffer.toString();
        System.out.println("stringBufferToString :" + input);

    }


}
