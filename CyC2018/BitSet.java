/**
 * @author : mengmuzi
 * create at:  2019-04-02  14:47
 * @description: 如果海量数据是整数，并且范围不大时，就可以使用 BitSet 存储。
 */
public class BitSet {

    int[] bitset;
    public BitSet(int size){
        bitset = new int[(size >> 5) + 1];//divide by 32

    }
    boolean get(int pos){
        int wordNumber = (pos>>5);//divide by 32
        int bitNumber = (pos & 0x1F);// mod 32
        return(bitset[wordNumber] & (1 << bitNumber)) != 0;

    }

    void set(int pos){
        int wordNumber = (pos >> 5);
        int bitNumber = (pos & 0x1F);
        bitset[wordNumber] |= 1 << bitNumber;
    }


}
