public class MultithreadedSingleton {
    private static MultithreadedSingleton ins = null;
    private MultithreadedSingleton(){};

    public static MultithreadedSingleton getInstance(){
        if (ins == null){
          synchronized (MultithreadedSingleton.class){
              if(ins == null){
                 ins = new MultithreadedSingleton();
              }
          }
        }
        return ins;
    }
}
