package MIDTERM_Practice_GW2;

public abstract class Engineer extends Player{
	public Engineer(String username, String className, int MAX_hp){
		super(username, className, MAX_hp);
	}
	public static class Scrapper extends Engineer implements DPS, BoonGiver{
		public Scrapper(String username){
			super(username, "Scrapper", 11000);
		}

		@Override
		public int attack(){
			return 3000;
		}

		@Override
		public int damageType(){
			return 1;
		}

		@Override
		public int boons(){
			return 2;
		}
	}
	public static class Mechanist extends Engineer implements DPS, BoonGiver{
		public Mechanist(String username){
			super(username, "Mechanist",12000);
		}

		@Override
		public int attack(){
			return 3200;
		}

		@Override
		public int damageType(){
			return 1;
		}

		@Override
		public int boons(){
			return 2;
		}
	}
	public static class Holosmith extends Engineer implements DPS{
		public Holosmith(String username){
			super(username,"Mechanist",11500);
		}

		@Override
		public int attack(){
			return 1200;
		}

		@Override
		public int damageType(){
			return 1;
		}
	}
}
