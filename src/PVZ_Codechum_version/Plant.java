package PVZ_Codechum_version;

import PVZ_Codechum_version.plant_interfaces.*;

public abstract class Plant implements Comparable<Plant>{
    final static int INFINITY = Integer.MAX_VALUE;
    String name;
    int hit_points;
    int sun_cost;
    public Plant(String name ,int sun_cost ,int hit_points) {
        this.name = name;
        this.hit_points = hit_points;
        this.sun_cost = sun_cost;
    }
    void die(){
        int hp = 0;
        System.out.println(this.name + " dies");
    }
    @Override
    public String toString(){
        if(this.hit_points == INFINITY) return name + " (∞)  - cost:" + sun_cost;
        else return name + " (" + hit_points + ")  - cost: " + sun_cost;

    }

    @Override
    public int compareTo(Plant p){
        return this.name.compareTo(p.name);
    }

    public static class Sunflower extends Plant implements SunProducer, Upgradeable {
        public Sunflower(){
            super("Sunflower", 50,6);
        }

        @Override
        public int produce_sun() {
            System.out.println(name + " produces 25 sun");
            return 25;
        }
        @Override
        public Plant upgrade(){
            return new TwinSunflower();
        }
    }

    public static class TwinSunflower extends Plant implements SunProducer, PlantUpgrade{
        public TwinSunflower(){
            super("Twin Sunflower", 150 ,6);
        }

        @Override
        public int produce_sun(){
            return 50;
        }

        @Override
        public int concurrent_sun(){
            return 25;
        }
    }

    public static class Peashooter extends Plant implements Attacker {
        public Peashooter(){
            super("Peashooter",100,6);
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
            super("Squash",50,INFINITY);
        }

        @Override
        public int attack() {
            System.out.println(name + " attacks");
            die();
            return 3;
        }

        @Override
        public int rangeType() {
            return 3;
        }
        @Override
        public int killType(){
            return 2;
        }
        @Override
        void die(){
            this.hit_points = 0;
            System.out.println(name + " dies while squashing zombie");
        }
    }

    public static class Jalapeno extends Plant implements Attacker, InstantAttacker{
        public Jalapeno(){
            super("Jalapeno",125,INFINITY);
        }

        @Override
        public int attack() {
            return 5;
        }

        @Override
        public int rangeType() {
            return 2;
        }

        @Override
        public int killType(){
            return 1;
        }

        @Override
        void die(){
            this.hit_points = 0;
            die();
            System.out.println(name + " dies while exploding");
        }
    }

    public static class Lilypad extends Plant implements Upgradeable{
        Lilypad(){
            super("Lily Pad",25,6);
        }

        @Override
        public Plant upgrade() {
            return new Plant.Cattail();
        }
    }
    public static class Cattail extends Plant implements Attacker,PlantUpgrade{
        public Cattail() {
            super("Cattail", 225, 6);
        }

        @Override
        public int concurrent_sun(){
            return 25;
        }

        @Override
        public int attack(){
            return 1;
        }

        @Override
        public int rangeType(){
            return 4;
        }
    }
    public static class CoffeeBean extends Plant{
        public CoffeeBean(){
            super("Coffee Bean",75, INFINITY);
        }
    }
    public static class Wallnut extends Plant{
        public Wallnut(){
            super("Wallnut",50,20);
        }
    }

}
