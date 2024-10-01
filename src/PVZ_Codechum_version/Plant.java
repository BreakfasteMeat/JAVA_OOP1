package PVZ_Codechum_version;

import PVZ_Codechum_version.plant_interfaces.Attacker;
import PVZ_Codechum_version.plant_interfaces.InstantAttacker;
import PVZ_Codechum_version.plant_interfaces.SunProducer;

public abstract class Plant {
    final static int INFINITY = Integer.MAX_VALUE;
    String name;
    int hit_points;
    public Plant(String name, int hit_points) {
        this.name = name;
        this.hit_points = hit_points;
    }
    void die(){
        int hp = 0;

    }
    public static class SunFlower extends Plant implements SunProducer{
        public SunFlower(){
            super("Sun Flower",6);
        }

        @Override
        public int produce_sun() {
            System.out.println(name + " produces 25 sun");
            return 25;
        }
    }
    public static class Peashooter extends Plant implements Attacker {
        public Peashooter(){
            super("Peashooter",6);
        }

        @Override
        public int attack() {
            System.out.println(name + " attacks");
            return 1;
        }

        @Override
        public int rangeType() {
            return 1;
        }
    }
    public static class Squash extends Plant implements Attacker, InstantAttacker{
        public Squash() {
            super("Squash",INFINITY);
        }

        @Override
        public int attack() {
            System.out.println(name + " attacks");
            return 3;
        }

        @Override
        public int rangeType() {
            return 3;
        }
    }
}
