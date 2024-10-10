package MIDTERM_Practice_GW2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		List<Player> squad = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String username = "";
		String choice;
		do{
			System.out.print("Add Class: ");
			choice = sc.nextLine();
			if(!choice.equals("DONE")){
				System.out.print("Enter username: ");
				username = sc.nextLine();
			}
			switch(choice){
				case "DONE":
					break;
				case "Reaper":
					squad.add(new Necromancer.Reaper(username));
					break;
				case "Scourge":
					squad.add(new Necromancer.Scourge(username));
					break;
				case "Harbinger":
					squad.add(new Necromancer.Harbinger(username));
					break;
				case "Mechanist":
					squad.add(new Engineer.Mechanist(username));
					break;
				case "Holosmith":
					squad.add(new Engineer.Holosmith(username));
					break;
				case "Scrapper":
					squad.add(new Engineer.Scrapper(username));
					break;
				case "Soulbeast":
					squad.add(new Ranger.Soulbeast(username));
					break;
				case "Druid":
					squad.add(new Ranger.Druid(username));
					break;
				case "Untamed":
					squad.add(new Ranger.Untamed(username));
					break;
				case "Renegade":
					squad.add(new Revenant.Renegade(username));
					break;
				case "Vindicator":
					squad.add(new Revenant.Vindicator(username));
					break;
				case "Herald":
					squad.add(new Revenant.Herald(username));
					break;
				default:
					System.out.println(choice + " is not a class");
			}
		}while(!choice.equals("DONE"));

		boolean HasAssignedCommander = false;
		int ctr = 0, do_ctr = 0, total_heal_amount = 0;
		Iterator<Player> iterator = squad.iterator();
		do{
			System.out.print("Do something: ");
			choice = sc.nextLine();
			switch(choice){
				case "Print":
					print_squad(squad,HasAssignedCommander);
				case "DONE":
					break;
				case "Make Commander":

					System.out.print("Enter username to be a commander: ");
					username = sc.nextLine();
					for(Player p : squad){
						if(p.getUsername().equals(username)){
							squad.remove(p);
							squad.addFirst(p);
							break;
						}
						ctr++;
					}
					HasAssignedCommander = true;
					break;
				case "Fight":
					ctr = 0;
					do_ctr = 0;
					for(Player p : squad){
						if(p instanceof DPS){
							do_ctr += ((DPS)p).attack();
							ctr++;
						}
					}
					System.out.println(ctr + " DPS Players deal " + do_ctr + " damage to the boss");
					do_ctr = 0;
					ctr = 0;
					iterator = squad.iterator();
					while (iterator.hasNext()) {
						Player p = iterator.next();
						do_ctr += p.damage();
						if (p.getCurrent_hp() == 0) {
							iterator.remove();
						}
					}
					System.out.println("Squad took " + do_ctr + " total damage");
					break;
				case "Heal":
					ctr = 0;
					do_ctr = 0;
					for(Player p : squad){
						if(p instanceof Healer){
							do_ctr += ((Healer)p).heal();
							ctr++;
						}
					}
					for(Player p : squad){
						total_heal_amount += p.heal(do_ctr);
					}
					System.out.println(ctr + " Healers heal squad by a total of " + total_heal_amount + " hp");
					break;
			}
		}while(!choice.equals("DONE"));
	}
	public static void print_squad(List<Player> squad,boolean HasAssignedCommander){
		int ctr = 0;
		for(Player p : squad){
			if(HasAssignedCommander && ctr == 0) System.out.print("Commander: ");
			System.out.println(p);
			ctr++;
		}
	}
}
