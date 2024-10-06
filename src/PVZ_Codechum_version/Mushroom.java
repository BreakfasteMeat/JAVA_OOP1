package PVZ_Codechum_version;


import PVZ_Codechum_version.plant_interfaces.*;

public class Mushroom extends Plant{
    boolean status;

    public Mushroom(String name, int sun_cost, int hit_points, boolean status) {
        super(name, sun_cost, hit_points);
        this.status = status;
    }

    public boolean getStatus(){
        return status;
    }

    public void awaken(CoffeeBean cb){
        cb.die();
        this.status = true;
    }

    public static class SunShroom extends Mushroom implements SunProducer{
        public SunShroom(boolean status){
            super("Sun-shroom",25,6,status);
        }

        @Override
        public int produce_sun(){
            if(!status){
                System.out.println(name + " is asleep and cannot produce sun");
                return 0;
            }
            System.out.println(name + " produced 15 suns");
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
    public static class DoomShroom extends Mushroom implements Attacker,InstantKiller{
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
    public static class FumeShroom extends Mushroom implements Attacker, Upgradeable{
        public FumeShroom(boolean status){ super("Fume-shroom",75,6,status);}

        @Override
        public Plant upgrade(){
            return new Mushroom.GloomShroom(this.status);
        }

        @Override
        public int rangeType(){
            return 1;
        }

        @Override
        public int attack(){
            return 1;
        }
    }

    public static class GloomShroom extends Mushroom implements Attacker, PlantUpgrade{
        public GloomShroom(boolean status){
            super("Gloom-shroom",75,6,status);
        }

        @Override
        public int concurrent_sun(){
            return 25;
        }

        @Override
        public int rangeType(){
            return 3;
        }

        @Override
        public int attack(){
            return 4;
        }
    }
}
