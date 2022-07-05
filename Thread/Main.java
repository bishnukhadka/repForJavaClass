public class Main {

    public static void main(String args[]) {
        String resource1 = "Nepal";
        String resource2 = "America";

        Thread t1 = new Thread(()-> {
            //
            synchronized(resource1){//first syncronized lock here
                System.out.println(resource1);
            
                synchronized(resource2){//2nd lock start here
                    System.out.println(resource2);
                }//2nd unlock here
            }//synchronized unlock here
        });
        t1.start();

        Thread t2 = new Thread(()-> {
            synchronized(resource2){
                System.out.println(resource2);
            
                synchronized(resource1){
                    System.out.println(resource1);
                }
            }
        });
        t2.start();
    }   


    //
    public synchronized void run()
    {

    }
}


//here deadlock situation arised. 