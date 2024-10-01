package PVZ;
public class Zombie extends TILE_ENTITY{
    public static final int DEFAULT_HP = 10;
    double speed;
    int damage = 1;
    Armor armor;
    public Zombie(){
        hp = DEFAULT_HP;
        speed = 0.3;
    }
    public Zombie(int hp, float speed, int damage) {
        this.hp = hp;
        this.speed = speed;
        this.damage = damage;
    }
    void take_damage(int dmg){
        if(armor != null && armor.isActive()){
            armor.takeDamage(dmg);
        } else {
            this.hp -= dmg;
        }
    }
    void walk(){
        location.move(0,(float)(-1 * speed));
    }

}
