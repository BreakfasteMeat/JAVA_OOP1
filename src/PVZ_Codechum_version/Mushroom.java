package PVZ_Codechum_version;


import PVZ_Codechum_version.plant_interfaces.*;

public class Mushroom extends Plant{
    boolean status;

    public Mushroom(String name, int sun_cost, int hit_points, boolean status) {
        super(name, sun_cost, hit_points);
        this.status = status;
    }
    public void awaken(CoffeeBean cb){
        cb.die();
        this.status = true;
    }

    public static class SunShroom extends Mushroom implements SunProducer{
        public SunShroom(boolean status){
            super("Puff-shroom",25,6,status);
        }

        @Override
        public int produce_sun(){
            if(!status){
                System.out.println(name + " is asleep and cannot produce sun");
                return 0;
            }
            return 15;
        }
    }

    public static class PuffShroom extends Mushroom implements Attacker {
        public PuffShroom(boolean status) {
            super("Puff-shroom", 0, 6, status);
        }

        @Override
        public int attack() {
            if(!status){
                System.out.println(name + " is asleep and cannot attack");
                return 0;
            }
            return 1;
        }

        @Override
        public int rangeType() {
            return 2;
        }
    }
    public static class DoomShroom extends Mushroom implements Attacker,InstantAttacker{
        public DoomShroom(boolean status){
            super("Doom-shroom",125,INFINITY,status);
        }

        @Override
        public int attack(){
            if(!status){
                System.out.println(name + " is asleep and cannot attack");
                return 0;
            }
            return 10;
        }
        @Override
        public int rangeType(){
            return 3;
        }
        @Override
        public int killType(){
            return 1;
        }
    }
}
