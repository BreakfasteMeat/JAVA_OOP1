package PVZ;
public abstract class Plant extends TILE_ENTITY{
    public static final int DEFAULT_HP = 10;

    int sun_cost;
    boolean is_asleep;

    boolean is_aquatic;

    public Plant(int sun_cost, int hp) {
        this.sun_cost = sun_cost;
        this.hp = hp;
        is_asleep = false;
        is_aquatic = false;
    }


    public Plant(int sun_cost, boolean is_asleep, int hp) {
        this.sun_cost = sun_cost;
        this.is_asleep = is_asleep;
        this.hp = hp;
        is_aquatic = false;
    }

    public Plant(int sun_cost, boolean is_asleep, int hp, boolean is_aquatic) {
        this.sun_cost = sun_cost;
        this.is_asleep = is_asleep;
        this.hp = hp;
        this.is_aquatic = is_aquatic;
    }
    void die(){
        hp = 0;
    }
    enum RangeType{
        LONG_RANGE, SHORT_RANGE, PROJECTILE
    }

}
