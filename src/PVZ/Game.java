package PVZ;
import java.util.ArrayList;
import java.util.List;

public class Game {
    int sun;

    List<Plant> plants;
    List<Zombie> zombies;
    Game(){
        plants = new ArrayList<>();
        zombies = new ArrayList<>();
        sun = 50;
    }

    public void addPlant(Plant p, Coord location) {
        plants.add(p);
        p.location = location;
    }
    public void addZombie(Zombie z, Coord location){
        zombies.add(z);
        z.location = location;
    }

    public void startGame() throws InterruptedException {
        int time = 0;
        while(true){
            time++;
            if(time % 5 == 0){
                for(Plant p : plants){
                    if(p instanceof sunProducer){
                        this.sun += ((sunProducer)p).generate_sun();
                    }
                }
            }

            outputStatus();
            Thread.sleep(500);

        }
    }


    private void outputStatus() {
        System.out.println("Sun: " + sun);
        System.out.println("List of Plants: ");
        for (Plant p : plants) {
            System.out.println(p);
        }
        System.out.println("List of Zombies: ");
        for (Zombie z : zombies) {
            System.out.println(z);
        }
    }


}
