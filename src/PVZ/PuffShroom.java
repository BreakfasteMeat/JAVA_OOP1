package PVZ;
public class PuffShroom extends Mushroom{
    public PuffShroom(int sun_cost, int hp) {
        super(0, DEFAULT_HP);
    }

    int shoot(){
        return 1;
    }
}
