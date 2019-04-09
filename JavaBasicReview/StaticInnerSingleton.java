
/**
 * @author : mengmuzi
 * create at:  2019-04-07  11:17
 * @description: 用静态内部类实现单例模式
 */
public class StaticInnerSingleton {

    private StaticInnerSingleton(){};

    private static class SingletonHolder{
        private static final StaticInnerSingleton INSTANCE = new StaticInnerSingleton();

    }

    public static StaticInnerSingleton getUniqueInstance(){
        return SingletonHolder.INSTANCE;
    }

}
