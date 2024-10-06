package LA3_PVZ_v2;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		List<Plant> plants = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.print("Game Mode: ");
		String mode = sc.nextLine();
		boolean isNight = (mode.equals("Night") || mode.equals("Fog"));
		int do_ctr, ctr;
		Plant cb;
		String input;
		boolean foundPlant = false;
		do {
			System.out.print("Add a plant: ");
			input = sc.nextLine();
			switch (input) {
				case "DONE":
					break;
				case "Wall Nut":
					plants.add(new Plant.WallNut());
					break;
				case "Sunflower":
					plants.add(new Plant.Sunflower());
					break;
				case "Twin Sunflower":
					ctr = 0;
					for(Plant p : plants){
						if(p instanceof Plant.Sunflower){
							plants.add(ctr,(Plant)((Plant.Sunflower)p).upgrade());
							plants.remove(++ctr);
							break;
						}
						ctr++;
					}
					break;
				case "Peashooter":
					plants.add(new Plant.Peashooter());
					break;
				case "Squash":
					plants.add(new Plant.Squash());
					break;
				case "Jalapeno":
					plants.add(new Plant.Jalapeno());
					break;
				case "Lily Pad":
					plants.add(new Plant.LilyPad());
					break;
				case "Cattail":
					ctr = 0;
					for(Plant p : plants){
						if(p instanceof Plant.LilyPad){
							plants.add(ctr,(Plant)((Plant.LilyPad)p).upgrade());
							plants.remove(++ctr);
							break;
						}
						ctr++;
					}
					break;
				case "Sun-shroom":
					plants.add(new Mushroom.SunShroom(isNight));
					break;
				case "Puff-shroom":
					plants.add(new Mushroom.PuffShroom(isNight));
					break;
				case "Doom-shroom":
					plants.add(new Mushroom.DoomShroom(isNight));
					break;
				case "Coffee Bean":
					for(Plant p : plants){
						if(p instanceof Mushroom && !((Mushroom)p).isAwake()){
							cb = new Plant.CoffeeBean();
							((Mushroom)p).awaken((Plant.CoffeeBean)cb);
							break;
						}
					}
					break;
				// add more plants here
				default:
					System.out.println(input + " is not a plant");
			}
		} while (!input.equals("DONE"));
		CompareHP compareHP = new CompareHP();
		CompareSunCost compareSunCost = new CompareSunCost();
		do {
			System.out.print("Do something: ");
			input = sc.nextLine();
			switch (input) {
				case "DONE":
					break;
				case "Produce Sun":
					do_ctr = 0;
					ctr = 0;
					for(Plant p : plants){
						if(p instanceof SunProducer && p.isAlive()){
							ctr++;
							do_ctr += ((SunProducer)p).produce_sun();
						}
					}
					System.out.println(ctr + " sun producers gather " + do_ctr + " suns");
					break;
				case "Attack":
					do_ctr = 0;
					ctr = 0;
					for(Plant p : plants){
						if(p instanceof Attacker && p.isAlive()){
							ctr++;
							do_ctr += ((Attacker)p).attack();
						}
					}
					System.out.println(ctr + " attackers dealing " + do_ctr + " damage");
					break;
				case "Attacker Status":
					foundPlant = false;
					for(Plant p : plants){
						if(p instanceof Attacker && p.isAlive()){
							foundPlant = true;
							int type = ((Attacker)p).rangeType();
							System.out.print(p.getName() + " can attack");
							if(type == 1){
								System.out.println(" on a single line");
							} else if(type == 2){
								System.out.println(" using area-of-effect");
							} else if(type == 3){
								System.out.println(" only when enemy is nearby");
							} else if (type == 4){
								System.out.println(" freely");
							}
						}
					}
					if(!foundPlant) System.out.println("You have no attackers");
					break;
				case "Instant Kill Status":
					foundPlant = false;
					for(Plant p : plants){
						if(p instanceof InstantKiller && p.isAlive()){
							foundPlant = true;
							int type = ((InstantKiller)p).killType();
							System.out.print(p.getName() + " can kill");
							if(type == 1){
								System.out.println(" instantly");
							} else if(type == 2){
								System.out.println(" on contact");
							}
						}
					}

					if(!foundPlant) System.out.println("You have no plants which can kill instantly");
					break;
				case "Sort by HP":
					plants.sort(compareHP.reversed());
					print_plants(plants);
					break;
				case "Sort by Name":
					Collections.sort(plants);
					print_plants(plants);
					break;
				case "Sort by Sun Cost":
					plants.sort(compareSunCost.reversed());
					print_plants(plants);
					break;

				default:
					System.out.println("Unknown action: " + input);
			}
		} while (!input.equals("DONE"));
	}
	public static void print_plants(List<Plant> plants){
		for(Plant p : plants){
			System.out.println(p);
		}
	}
}
