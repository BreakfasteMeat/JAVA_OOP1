package PVZ;

public class Armor {
    private int hp;
    private boolean isActive;
    public Armor(int hp) {
        this.hp = hp;
        isActive = true;
    }

    public void takeDamage(int dmg) {
        hp -= dmg;
        if(hp <= 0){
            destroy();
        }
    }
    public void destroy(){
        isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }
}
