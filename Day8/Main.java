

public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("Main thread started \n");

        Player player1 = new Player();
        Player player2 = new Player();

        player1.setName("player1");
        player2.setName("player2");

        player1.setThread(player2);
        player2.setThread(player1);

        player1.start();
        player2.start();

        System.out.println("Main thread ended \n ");
    }
}
