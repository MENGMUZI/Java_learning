package JVMAndGC;

/**
 * @author : mengmuzi
 * create at:  2019-05-14  22:40
 * @description: 模拟Metaspace
 */
public class MetaSpaceDemo {
    static class OOMTest{}

    public static void main(String[] args) {
        /*int i = 0;//模拟计数多少次后发生异常
        try{
            while(true){
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback();
                enhancer.create();
            }
        }catch (Exception e){
            System.out.println("多少次后发生异常：" + i);
            e.printStackTrace();
        }*/

    }

}
