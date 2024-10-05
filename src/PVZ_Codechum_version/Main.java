package PVZ_Codechum_version;

import PVZ_Codechum_version.Comparator_Interfaces.*;
import PVZ_Codechum_version.plant_interfaces.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Plant> plants = new ArrayList<>();
        boolean plantSuccessfullyAdded = false;
        String op;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter level type: ");
        String levelType = sc.nextLine();
        String choice;
        int do_ctr, ctr;
        String enclose_plant = null;

        boolean isNight = levelType.equals("Night") || levelType.equals("Fog");

        do{
            System.out.print("Add a plant: ");
            choice = sc.nextLine();
            switch(choice){
                case "Sunflower":
                    System.out.println("Added Sunflower");
                    plants.add(new Plant.Sunflower());
                    break;
                case "Peashooter":
                    System.out.println("Added Peashooter");
                    plants.add(new Plant.Peashooter());
                    break;
                case "Squash":
                    System.out.println("Added Squash");
                    plants.add(new Plant.Squash());
                    break;
                case "Jalapeno":
                    System.out.println("Added Jalapeno");
                    plants.add(new Plant.Jalapeno());
                    break;
                case "Lily Pad":
                    if(!levelType.equals("Pool") && !(levelType.equals("Fog"))){
                        System.out.println("Lily Pads can only be planted on water");
                        break;
                    }
                    System.out.println("Added Lily Pad");
                    plants.add(new Plant.Lilypad());
                    break;
                case "Wallnut":
                    System.out.println("Added Wallnut");
                    plants.add(new Plant.Wallnut());
                    break;
                case "Tallnut":
                    System.out.println("Added Tallnut");
                    plants.add(new Plant.Tallnut());
                    break;
                case "Pumpkin":
                    enclose_plant = null;
                    System.out.print("Enter plant to enclose['N' to not enclose a plant]: ");
                    while(enclose_plant == null){
                        enclose_plant = sc.nextLine();
                        if(enclose_plant.equals("N")) plants.add(new Plant.Pumpkin(null));
                        for(Plant p : plants){
                            if(enclose_plant.equals(p.getName())){
                                plants.add(new Plant.Pumpkin(p));
                                break;
                            }
                        }
                    }
                    System.out.println("Added Pumpkin");
                    break;

                case "Sun-shroom":
                    System.out.println("Added Sun-shroom");
                    plants.add(new Mushroom.SunShroom(isNight));
                    break;
                case "Puff-shroom":
                    System.out.println("Added Puff-shroom");
                    plants.add(new Mushroom.PuffShroom(isNight));
                    break;
                case "Doom-shroom":
                    System.out.println("Added Doom-shroom");
                    plants.add(new Mushroom.DoomShroom(isNight));
                    break;
                case "Twin Sunflower":
                    ctr = 0;
                    plantSuccessfullyAdded = false;
                    for(Plant p : plants){
                        if(p instanceof Plant.Sunflower){
                            plants.add(ctr++, ((Plant.Sunflower) p).upgrade());
                            plantSuccessfullyAdded = true;
                            break;
                        }
                        ctr++;
                    }
                    if(!plantSuccessfullyAdded){
                        System.out.println("No Sunflower in the lawn");
                        break;
                    }
                    System.out.println("Added Twin Sunflower");
                    plants.remove(ctr);
                    break;
                case "Cattail":
                    ctr = 0;
                    plantSuccessfullyAdded = false;
                    for(Plant p : plants){
                        if(p instanceof Plant.Lilypad){
                            plants.add(ctr++, ((Plant.Lilypad) p).upgrade());
                            plantSuccessfullyAdded = true;
                            break;
                        }
                        ctr++;
                    }
                    if(!plantSuccessfullyAdded){
                        System.out.println("No Lily Pad in the pool");
                        break;
                    }
                    System.out.println("Added Cattail");
                    plants.remove(ctr);
                    break;
                case "Coffee Bean":
                    for(Plant p : plants){
                        if(p instanceof  Mushroom && !((Mushroom)p).getStatus()){
                            ((Mushroom)p).awaken(new Plant.CoffeeBean());
                            break;
                        }
                    }
                    break;



                case "DONE":
                    break;

                default:
                    System.out.println(choice + " is not a plant");

            }
        }while(!(choice.equals("DONE")));

        Plant_CompareByHitPoints compareHP = new Plant_CompareByHitPoints();
        Plant_CompareBySunCost compareSun = new Plant_CompareBySunCost();
        Plant_CompareByGivenHitPoints compareGivenHP = new Plant_CompareByGivenHitPoints(0);

        do{
            System.out.print("Do something: ");
            choice = sc.nextLine();
            switch(choice){
                case "DONE":
                    break;
                case "List Plants":
                    for(Plant p : plants){
                        System.out.println(p);
                    }
                    break;
                case "Produce Sun":
                    ctr = 0;
                    do_ctr = 0;
                    for(Plant p : plants){
                        if(p instanceof SunProducer){
                            do_ctr += ((SunProducer)p).produce_sun();
                            ctr++;
                        }
                    }
                    System.out.println(ctr + " Sun Producers produced " + do_ctr + " suns");
                    break;
                case "Attack":
                    ctr = 0;
                    do_ctr = 0;
                    for(Plant p : plants){
                        if(p instanceof Attacker){
                            do_ctr += ((Attacker)p).attack();
                            ctr++;
                        }
                    }
                    System.out.println(ctr + " Attackers do " + do_ctr + " damage");
                    break;
                case "Attacker Status":
                    for(Plant p : plants){
                        if(p instanceof Attacker){
                            int type = ((Attacker)p).rangeType();
                            switch(type){
                                case 1:
                                    System.out.println(p.getName() + " attacks in a single line");
                                    break;
                                case 2:
                                    System.out.println(p.getName() + " attacks in close range");
                                    break;
                                case 3:
                                    System.out.println(p.getName() + " attacks in an area-of-effect");
                                    break;
                                case 4:
                                    System.out.println(p.getName() + " attacks freely");
                                    break;
                            }
                        }
                    }
                    break;
                case "Instant Killer Status":
                    for(Plant p: plants){
                        if(p instanceof InstantKiller){
                            int type = ((InstantKiller)p).killType();
                            switch(type){
                                case 1:
                                    System.out.println(p.getName() + " kills instantly");
                                    break;
                                case 2:
                                    System.out.println(p.getName() + " kills when zombie is close");
                                    break;
                            }
                        }
                    }
                    break;
                case "Waller Status":
                    for(Plant p : plants){
                        if(p instanceof Waller){
                            int type = ((Waller)p).wallType();
                            switch(type){
                                case 1:
                                    System.out.println(p.getName() + " defends from zombies");
                                    break;
                                case 2:
                                    System.out.println(p.getName() + " defends from jumping zombies");
                                    break;
                                case 3:
                                    System.out.println(p.getName() + " encloses " + ((Plant.Pumpkin)p).getEnclosed_plant_name());
                            }
                        }
                    }
                    break;
                case "Sort by Name":
                    Collections.sort(plants);
                    break;
                case "Sort by Hit Points":
                    plants.sort(compareHP.reversed());
                    break;
                case "Sort by Sun Cost":
                    plants.sort(compareSun.reversed());
                    break;
                case "Sort by given Hit Points":
                    System.out.print("Enter Hit Points to sort: ");
                    compareGivenHP.setHit_points(sc.nextInt());
                    plants.sort(compareGivenHP);
                    sc.nextLine();
                    break;

                default:
                    System.out.println(choice + " is not an option!");
            }
        }while(!(choice.equals("DONE")));

    }
}
