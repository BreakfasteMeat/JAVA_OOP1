package MIDTERM_Practice_GW2;

import java.util.Random;

public abstract class Player{
	String username;
	String className;
	int MAX_hp;
	int current_hp;
	public Player(String username, String className, int MAX_hp){
		this.username = username;
		this.className = className;
		this.MAX_hp = MAX_hp;
		this.current_hp = MAX_hp;
	}
	String die(){
		this.current_hp = 0;
		return className + " " + username + " died";
	}
	int damage(){
		Random rand = new Random();
		int damage = 3000 + rand.nextInt(1000);
		this.current_hp -= damage;
		if(this.current_hp <= 0){
			System.out.println(die());
		}
		return damage;
	}
	int heal(int heal_amount){
		this.current_hp += heal_amount;
		if(current_hp > MAX_hp){
			int overflowHP = current_hp - MAX_hp;
			current_hp -= overflowHP;
			heal_amount -= overflowHP;
		}
		return heal_amount;
	}

	@Override
	public String toString(){
		return className + " " + username + " HP:(" + current_hp + "/" + MAX_hp + ")";
	}

	public String getUsername(){
		return username;
	}

	public String getClassName(){
		return className;
	}

	public int getMAX_hp(){
		return MAX_hp;
	}

	public int getCurrent_hp(){
		return current_hp;
	}
}
