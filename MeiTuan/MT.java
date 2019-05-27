import java.util.*;

/**
 * @author : mengmuzi
 * create at:  2019-04-23  18:50
 * @description: 美团
 */
public class MT {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = 0;
        int col = 0;
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        Map<Integer,Integer> mapA = new TreeMap<>();
        Map<Integer,Integer> mapB= new TreeMap<>();

        int[][] arrs = null ;

        row = scanner.nextInt();
        col = scanner.nextInt();
        arrs = new int[row][col];
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                arrs[i][j] =scanner.nextInt();
            }
        }

        for (int i = 0; i <row ; i++) {
            if((i&1)==0){
                for (int j = 0; j <col; j++) {
                    if((j&1)==0){
                        listB.add(arrs[i][j]);
                    }else{
                        listA.add(arrs[i][j]);
                    }
                }
            }else{
                for (int j = 0; j <col; j++) {
                    if((j&1)==0){
                        listA.add(arrs[i][j]);
                    }else{
                        listB.add(arrs[i][j]);
                    }
                }
            }
        }
        for (Integer temp:listA) {
            Integer count = mapA.get(temp);
            mapA.put(temp,(count == null) ? 1 : count +1);
        }
        for (Integer temp:listB) {
            Integer count = mapA.get(temp);
            mapB.put(temp,(count == null) ? 1 : count +1);
        }
        int count = 0;
        //对map中的value值排序
        List<Map.Entry<Integer,Integer>> linkedListA = new LinkedList<>(mapA.entrySet());
        Collections.sort(linkedListA, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        for (int i = 0; i <linkedListA.size()-1 ; i++) {
            count += linkedListA.get(i).getValue();
        }

        List<Map.Entry<Integer,Integer>> linkedListB = new LinkedList<>(mapA.entrySet());
        Collections.sort(linkedListB, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        for (int i = 0; i <linkedListB.size()-1 ; i++) {
            count += linkedListB.get(i).getValue();
        }

        System.out.println(count);

    }

}
