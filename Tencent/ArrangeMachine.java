import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-04-05  11:24
 * @description: 安排机器
 */
public class ArrangeMachine {

    public static int max_grade = 100;
    static class Pair{
        int time;
        int grade;
        public Pair(int time, int grade){
            this.time = time ;
            this.grade = grade;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int machineNum = scanner.nextInt();
            int taskNum = scanner.nextInt();
            Pair[] machines = new Pair[machineNum];
            Pair[] tasks = new Pair[taskNum];
            for (int i = 0; i <machineNum ; i++) {
                machines[i] = new Pair(scanner.nextInt(),scanner.nextInt());
            }
            for (int i = 0; i <taskNum ; i++) {
                tasks[i] = new Pair(scanner.nextInt(),scanner.nextInt());
            }
            computMaxEarning(machines,tasks,machineNum,taskNum);
        }
    }

    private static void computMaxEarning(Pair[] machines, Pair[] tasks, int machineNum, int taskNum) {
        //重写比较器
        Comparator<Pair> comparator = new Comparator<Pair>() {
            @Override//降序排序
            public int compare(Pair o1, Pair o2) {
                if(o2.time == o1.time){
                   return o2.grade - o1.grade;
                }
                return o2.time - o1.time;
            }
        };
        //机器按照时长优先排序
        Arrays.sort(machines,comparator);
        //任务按照时长优先排序
        Arrays.sort(tasks,comparator);
        //获得的收益的大小
        long earnings = 0;
        //最大完成的任务的数量
        int count = 0;
        //记录级别机器数量，下标为机器等级，值为该级别的机器数目
        int[] cnt = new int[max_grade + 1];
        Arrays.fill(cnt,0);
        //遍历任务
        int j = 0;
        for (int i = 0; i <taskNum ; i++) {
            // 找到满足时长的机器，并且记录这些机器的等级
            // 由于机器和任务均已按照时长优先进行了排序，能完成长时长高难度的机器，也可以完成短时长低难度的任务。
            while(j <machineNum && machines[j].time >= tasks[i].time) {
                cnt[machines[j].grade]++;
                j++;
            }
            for (int k = tasks[i].grade; k <= max_grade ; k++) {
                if(cnt[k] > 0){
                    count ++;
                    cnt[k] --;
                    earnings += 200 * tasks[i].time + 3 * tasks[i].grade;
                    break;
                }
            }
        }
        System.out.println(count + " " + earnings);
    }

}
