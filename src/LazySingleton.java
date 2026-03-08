import java.io.Serializable;

public class LazySingleton implements Serializable{
    private static LazySingleton instance = null;

    //private constructor
    private LazySingleton(){};

    public static LazySingleton getInstance() {
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }

}
