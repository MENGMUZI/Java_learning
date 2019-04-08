/**
 * @author : mengmuzi
 * create at:  2019-04-08  01:20
 * @description: 维护 d*w 大小的二维统计数组，其中 d 是哈希函数的个数，w 根据情况而定
 */
public class CountMinSketch {

    private int d;//哈希函数的个数
    private int w;//bit数组的长度

    private long estimators[][];

    public CountMinSketch(){
        this.d = d;
        this.w = w;
    }

    public void add(int value){
        for (int i = 0; i < d ; i++) {
            estimators[i][hash(value,i)]++;
        }
    }

    public long estimateFrequency(int value){
        long minimum = Integer.MAX_VALUE;
        for (int i = 0; i < d; i++) {
            minimum = Math.min(minimum, estimators[i][hash(value, i)]);
        }
        return minimum;
    }

    private int hash(int value, int i) {
        return 0; // use ith hash function
    }

}
