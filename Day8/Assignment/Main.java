/*assignment
-create a thread
-if we pass the value 100 then that thread will create a thread inside it and so on until a 100 thread. 
-thread1 sleep for 10ms, thread2 sleep for 20ms */
public class Main {  
     public static void main(String args[]){
        System.out.println("Started main thread");  
          Player player1 = new Player(100);
          player1.start();
          System.out.println("ended main thread");  
     } 
  }