package PVZ;
public abstract class TILE_ENTITY {
    int hp;
    Coord location;

    @Override
    public String toString(){
        return getClass().getName() + location.toString() + "HP: " + hp;
    }
}
