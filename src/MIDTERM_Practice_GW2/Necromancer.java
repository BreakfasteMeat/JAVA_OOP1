package MIDTERM_Practice_GW2;

public abstract class Necromancer extends Player{
	public Necromancer(String username, String className, int MAX_hp){
		super(username, className, MAX_hp);
	}
	public static class Reaper extends Necromancer implements DPS{
		public Reaper(String username){
			super(username,"Reaper",23000);
		}

		@Override
		public int damageType(){
			return 1;//1 POWER 2 CONDITION
		}

		@Override
		public int attack(){
			return 1000;
		}
	}
	public static class Scourge extends Necromancer implements Healer, BoonGiver{
		public Scourge(String username){
			super(username,"Scourge",19000);
		}

		@Override
		public int boons(){
			return 1;//Alacrity,
		}

		@Override
		public int heal(){
			return 5000;
		}
	}
	public static class Harbinger extends Necromancer implements DPS, BoonGiver{
		public Harbinger(String username){
			super(username, "Harbinger", 19500);
		}

		@Override
		public int boons(){
			return 2;
		}

		@Override
		public int damageType(){
			return 2;
		}

		@Override
		public int attack(){
			return 1800;
		}
	}
}
