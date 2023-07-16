import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean running = true;
        AudioPlayer player = new AudioPlayer();

        while(running) {
            System.out.println("--------------------------");
            System.out.println("\tAudioPlayer");
            System.out.println("--------------------------");
            
            if(player.isPlaying()) {
                System.out.println("Status: Playing...");
            }
            else {
                System.out.println("Status: Paused");
            }
            
            System.out.println("--------------------------");
            System.out.println("1. Next");
            System.out.println("2. Previous");
            System.out.println("3. Play/Pause");
            System.out.println("4. Lock/Unlock");
            System.out.println("5. Exit");
            
            System.out.print("Select an option: ");
            int option = in.nextInt();
            System.out.println("--------------------------");
            
            switch (option) {
                case 1:
                player.clickNext();
                break;
                case 2:
                player.clickPrevious();
                break;
                case 3:
                player.clickPlay();
                break;
                case 4:
                player.clickLock();
                break;
                case 5:
                    running = false;
                    System.out.println("\n\tExiting player.......\n");
                    break;
            }
        }
        in.close();
    }
}
