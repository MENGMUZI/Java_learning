/**
 * @author : mengmuzi
 * create at:  2019-05-29  17:13
 * @description: 缓冲区Buffer
 */

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

/**
 * 一、缓冲区（Buffer）:在Java NIO中负责数据的存取，缓冲区是数组，用于存储不同数据类型的数据
 * 根据数据类型不同（boolean除外）提供了相应类型的缓冲区
 *  * ByteBuffer
 *  * CharBuffer
 *  * ShortBuffer
 *  * IntBuffer
 *  * LongBuffer
 *  * FloatBuffer
 *  * DoubleBuffer
 *  上述缓冲区的管理方式几乎一致，通过allocate()获取缓冲区
 *
 * 二、缓冲区存取数据的两个核心方法
 * put() :存入数据到缓冲区中
 * get() :获取缓冲区中的数据
 *
 *
 * 三、缓冲区中的四个核心的属性
 * capacity : 容量，表示缓冲区中最大存储数据的容量。一旦声明不能改变。（很数组一样）
 * limit : 界限，表示缓冲区中可以操作数据的大小。(limit后数据不能进行读写)
 * position : 位置，表示缓冲区中正在操作数据的位置。
 *  0 <= mark <= position <= limit <= capacity
 *
 * mark : 标记，表示记录当前position位置。可以通过reset()恢复到mark的位置。
 *
 * 四、直接缓冲区与非直接缓冲区:
 *    非直接缓冲区：通过allocate()方法分配缓冲区，将缓冲区建立在JVM的内存中。
 *    直接缓冲区：通过allocateDirect()方法分配直接缓冲区，将缓冲区建立在物理内存中。可以提高效率
 *
 *  此方法返回的缓冲区进行分配和取消分配所需成本通常高于非直接缓冲区。
 *  直接缓冲区的内容可以驻留在常规的垃圾回收堆之外.
 *  将直接缓冲区主要分配给那些易受基础系统的本机 I/O 操作影响的大型、持久的缓冲区。
 *  最好仅在直接缓冲区能在程序性能方面带来明显好处时分配它们。
 *  直接字节缓冲区还可以过通过FileChannel的map()方法将文件区域直接映射到内存中来创建。该方法返回MappedByteBuffer
 *
 * */
public class TestBuffer {
    @Test
    public void test1(){
        String str="abcde";

        //1.分配一个制定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        System.out.println("-----------allocate()------------");
        System.out.println(buf.position());//0
        System.out.println(buf.limit());//1024
        System.out.println(buf.capacity());//1024


        //2.利用put()存放数据到缓冲区中
        buf.put(str.getBytes());
        System.out.println("-----------put()------------");
        System.out.println(buf.position());//5
        System.out.println(buf.limit());//1024
        System.out.println(buf.capacity());//1024

        //3.切换读取数据模式
        buf.flip();
        System.out.println("-----------flip()------------");
        System.out.println(buf.position());// 0
        System.out.println(buf.limit());// 5
        System.out.println(buf.capacity());//1024

        //4.利用get()读取缓冲区中的数据
        byte[] dst = new byte[buf.limit()];
        buf.get(dst);
        System.out.println("-----------get()------------");
        System.out.println(new String(dst,0,dst.length));//abcde
        System.out.println(buf.position());//5
        System.out.println(buf.limit());//5
        System.out.println(buf.capacity());//1024

        //5.rewind():可重复读
        buf.rewind();
        System.out.println("---------rewind()------------");
        System.out.println(buf.position());//0
        System.out.println(buf.limit());//5
        System.out.println(buf.capacity());//1024

        //6.clear():清空缓冲区。但是缓冲区中的数据依然存在，但是处在“被遗忘”状态
        buf.clear();
        System.out.println("---------clear()------------");
        System.out.println(buf.position());// 0
        System.out.println(buf.limit());// 1024
        System.out.println(buf.capacity());// 1024

        //检查是否还存在数据
        System.out.println((char)buf.get());

    }

    @Test
    public void test2(){
        String str = "abcde";

        ByteBuffer buf = ByteBuffer.allocate(1024);

        buf.put(str.getBytes());

        buf.flip();
        byte[] dst = new byte[buf.limit()];
        buf.get(dst,0,2);
        System.out.println(new String(dst,0,2));// ab
        System.out.println(buf.position());// 2

        //mark():标记
        buf.mark();
        buf.get(dst,2,2);
        System.out.println(new String(dst,2,2));// cd
        System.out.println(buf.position());// 4
        //reset():恢复到mark的位置
        buf.reset();
        System.out.println(buf.position());// 2


        //判断缓冲区中是否还有剩余数据
        if(buf.hasRemaining()){
            //获取缓冲区中可以操作的数量
            System.out.println(buf.remaining());// 3

        }
    }

    @Test
    public void test3(){
        //分配直接缓存区
        ByteBuffer buf = ByteBuffer.allocateDirect(1024);
        //判断是否是直接缓冲区
        System.out.println(buf.isDirect());//true

    }


}
