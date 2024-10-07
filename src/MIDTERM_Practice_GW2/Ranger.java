package MIDTERM_Practice_GW2;

public abstract class Ranger extends Player{
	public Ranger(String username, String className, int MAX_hp){
		super(username, className, MAX_hp);
	}
	public static class Soulbeast extends Ranger implements Kiter{
		public Soulbeast(String username){
			super(username, "Soulbeast", 16000);
		}
		@Override
		public int kiteEnemy(){
			this.current_hp -= 1200;
			return 1200;
		}
	}
	public static class Druid extends Ranger implements Healer,BoonGiver{
		public Druid(String username){
			super(username, "Druid",15900);
		}

		@Override
		public int heal(){
			return 6000;
		}

		@Override
		public int boons(){
			return 1;
		}
	}
	public static class Untamed extends Ranger implements DPS{
		public Untamed(String username){
			super(username,"Untamed",15200);
		}
		@Override
		public int attack(){
			return 4000;
		}
		@Override
		public int damageType(){
			return 1;
		}
	}
}
