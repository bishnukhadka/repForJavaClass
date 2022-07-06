public class Player extends Thread{
    
    int count;
    public Player (int count) {
        this.count=count;
    }

    @Override
    public void run(){
        System.out.println("Started thread : Thread" + count);
        if (count>0){
            Player child = new Player(count - 1);
            child.start();
        }
        try{
            Thread.sleep(10000-count*100);
        }catch(Exception ex){ 
        } 
        System.out.println("Ended thread thread : Thread" + count);
    }     
}