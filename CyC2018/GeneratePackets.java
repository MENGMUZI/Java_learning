import java.util.*;

/**
 * @author : mengmuzi
 * create at:  2019-04-01  21:03
 * @description: 抢红包算法
 */
public class GeneratePackets {
    //方法一：二倍均值法，保证每次分配的红包均值都为 M/N，但是并不能保证每个红包的均值都一样，因为 M 和 N 一直在变化，那么 M/N 的值就会不同。
    public List<Integer> generatePacketsByDoubleMean(int people, int money){
        List<Integer> packets = new ArrayList<>();
        Random random = new Random();
        while(people > 1){
            int p = random.nextInt(2 * money / people );
            packets.add(p);
            money -= p;
            people --;
        }
        packets.add(money);
        return packets;
    }
    //方法二：线段切割法 在一条线段上找 N-1 个随机点，就可以将该线段随机且公平地切割成 N 段。
    public List<Integer> generatePacketsByLineCutting(int people, int money){
        List<Integer> packets = new ArrayList<>();
        Random random = new Random();
        Set<Integer> points = new TreeSet<>();
        while(points.size() < people-1){
            points.add(random.nextInt(money-1));
        }
        points.add(money);
        int pre = 0;
        for (int point:points) {
            packets.add(point-pre);
            pre = point;
        }
        return packets;
    }

    public static void main(String[] args) {
        GeneratePackets generatePackets = new GeneratePackets();
        List<Integer> packets = generatePackets.generatePacketsByDoubleMean(10,200);
        List<Integer> otherpackets = generatePackets.generatePacketsByLineCutting(10,200);
        System.out.println(packets);
        System.out.println(otherpackets);
    }

}
