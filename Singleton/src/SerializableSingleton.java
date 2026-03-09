import java.io.Serializable;

public class SerializableSingleton implements Serializable{
    private static SerializableSingleton instance = null;

    //private constructor
    private SerializableSingleton(){}

    public static SerializableSingleton getInstance() {
        if (instance == null){
            instance = new SerializableSingleton();
        }
        return instance;
    }

    protected Object readResolve(){
        return instance;
    }
}
