package PVZ_Codechum_version;

import PVZ_Codechum_version.plant_interfaces.SunProducer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        List<Plant> plants = new ArrayList<Plant>();
        boolean plantSuccessfullyAdded = false;
        String op;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter level type: ");
        String levelType = sc.nextLine();
        String choice;
        int do_ctr, ctr;
        boolean isNight = false;
        if(levelType.equals("Night") || levelType.equals("Fog")) isNight = true;
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
                    System.out.println("Added Lily Pad");
                    plants.add(new Plant.Lilypad());
                    break;
                case "Wallnut":
                    System.out.println("Added Wallnut");
                    plants.add(new Plant.Wallnut());
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
                        System.out.println("No Lilypad in the pool");
                        break;
                    }
                    System.out.println("Added Cattail");
                    plants.remove(ctr);
                    break;



                case "DONE":
                    break;

                default:
                    System.out.println(choice + " is not a plant");

            }
        }while(!(choice.equals("DONE")));

        do{
            System.out.print("Do something: ");
            choice = sc.nextLine();
            switch(choice){
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
            }
        }while(!(choice.equals("DONE")));

    }
}
