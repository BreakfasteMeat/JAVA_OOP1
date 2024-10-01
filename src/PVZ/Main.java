package PVZ;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        game.addPlant(new Sunflower(), new Coord(1, 1));
        game.addPlant(new Sunflower(), new Coord(2, 1));
        game.addPlant(new Sunflower(), new Coord(3, 1));
        game.addPlant(new Sunflower(), new Coord(4, 1));
        game.addPlant(new Sunflower(), new Coord(5, 1));
        game.addPlant(new Peashooter(), new Coord(1, 4));
        game.addPlant(new Peashooter(), new Coord(3, 4));
        game.addPlant(new Peashooter(), new Coord(5, 4));
        game.addPlant(new Peashooter(), new Coord(2, 4));
        game.addPlant(new Peashooter(), new Coord(4, 4));
        Random rand = new Random();
        game.addZombie(new Zombie(), new Coord(2,9));
        game.startGame();
    }
}