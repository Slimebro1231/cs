// Note: since methods can be called directly in chat, 
// I did not call monstrous methods twice on each monster,
// As you can do that during the testing of my code

// Difficulty
// 1. call timeWarp and spaDay in chat 
// 2. create monsters in chat
// 3. sort gpa
// 4. do not allow negative gpa and age
// 5. percentEvil2, counting the uppercase 


// import java.util, for arraylists, scanners etc.
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class MyProgram
{
    public static void main(String[] args)
    {
        // Arraylist to store monsters, so its easily sorted
        ArrayList<Monster> monsters = new ArrayList<>();
        // Create a scanner to check user input
        Scanner scanner = new Scanner(System.in);
        
        // Initialize with default monsters per requirements
        monsters.add(new Monster("", "", 0, false, 0));
        monsters.add(new Monster("Dracula", 12));
        monsters.add(new Monster());
        
        // Print out current monsters
        System.out.println("Present monsters: \n");
        Monster.printAll(monsters);
        
        // Modify the properties of the first monster to make it interesting
        monsters.get(0).setName("interestingMonster");
        monsters.get(0).setType("human");
        monsters.get(0).setAge(120);
        monsters.get(0).setGPA(2.0);
        monsters.get(0).setBreath(false);
        for (int i = 0; i<3; i++){
            // time warp by 15 years
            monsters.get(i).timeWarp(15);
            // print result from warp method
            System.out.println(monsters.get(i).getName() + " is now " + monsters.get(i).getAge() + " years old. They aged 15 years.");
            // spa the monster with a spa the price of 10.0
            monsters.get(i).spaDay(10.0);
            // print the spa result
            System.out.println(monsters.get(i).getName() + " now has a GPA of " + monsters.get(i).getGPA() + " and is now " + monsters.get(i).getAge() + " years old.");
            // percent evil
            System.out.println(monsters.get(i).getName() + " is " + monsters.get(i).percentEvil() + "% evil.\n");
        }
        
        
        // Print out modified monsters
        System.out.println("Monster with interesting values and modifications: \n");
        Monster.printAll(monsters);
        System.out.println("\n\n\n\n\n\n");
        
        
        while(true){
            // try statement in case of some weird user input
            try{
                // Print menu options
                System.out.println("1 to create new Monster");
                System.out.println("2 to return sorted GPA\n( only after this method is called will the lists for other methods be sorted )");
                System.out.println("3 to time warp");
                System.out.println("4 to spa");
                System.out.println("5 to percent evil");
                System.out.println("6 to percent evil2");
                // input on user choice
                int input = scanner.nextInt();
                
                if (input == 1){
                    // Choice of making a new monster
                    // getting parameters for a new monster
                    System.out.println("What is the type?");
                    String type = scanner.next();
                    System.out.println("What is the name?");
                    String name = scanner.next();
                    System.out.println("What is the age?");
                    int age = scanner.nextInt();
                    System.out.println("What is the breath? ( true, false )");
                    boolean breath = scanner.nextBoolean();
                    System.out.println("What is the GPA");
                    double GPA = scanner.nextDouble();
                    
                    // if the gpa is negative
                    if (GPA < 0){
                        System.out.println("Monsters cannot have negative GPA");
                    }else{
                        // add a new monster to the arraylist of monsters
                        monsters.add(new Monster(type, name, age, breath, GPA));
                        // print out the new monster
                        System.out.println("Created new monster:\n" + monsters.get(monsters.size()-1));
                        // sorts the list of monsters, for better future referneces
                        Collections.sort(monsters);
                    }
                    
                }else if (input == 2){
                    // sorting the monster array by GPA
                    Collections.sort(monsters);
                    System.out.println("\n");
                    // printing all the monsters in a sorted lsit
                    Monster.printAll(monsters);
                    
                }else if (input == 3){
                    // time warp function choice
                    // gives the option to chose a monster
                    System.out.println("\nMonsters are:");
                    Monster.printAll(monsters);
                    System.out.println("\nWhich Monster to time warp? ( give a number )");
                    int warpIndex = scanner.nextInt() - 1;
                    // option to type the amount of years to warp
                    System.out.println("Warp " + monsters.get(warpIndex).getName() + " by how many years? ( negative years warps by 0 )");
                    int warpTime = scanner.nextInt();
                    // get the input of time to warp the monster by
                    monsters.get(warpIndex).timeWarp(warpTime);
                    // print result from warp method
                    System.out.println(monsters.get(warpIndex).getName() + " is now " + monsters.get(warpIndex).getAge() + " years old. They aged " + warpTime + " years.\n");
                
                }else if (input == 4){
                    // spa day option
                    // gives the option to chose a monster
                    System.out.println("\nMonsters are:");
                    Monster.printAll(monsters);
                    System.out.println("\nWhich Monster to spa? ( give a number )");
                    int spaDayIndex = scanner.nextInt()-1;
                    System.out.println("What is the price to spa " + monsters.get(spaDayIndex).getName() + "?");
                    // takes the price of spa day
                    double spaDayPrice = scanner.nextDouble();
                    // if the spa is too expensive, you cant afford it
                    if (spaDayPrice > monsters.get(spaDayIndex).getAge()){
                        System.out.println("Not enough age to afford spaDay");
                    }else{
                        // call the spa method
                        monsters.get(spaDayIndex).spaDay(spaDayPrice);
                        System.out.println(monsters.get(spaDayIndex).getName() + " now has a GPA of " + monsters.get(spaDayIndex).getGPA() + " and is now " + monsters.get(spaDayIndex).getAge() + " years old.");
                    }
                
                }else if (input == 5){
                    // call the percentEvil method on the selected monster
                    System.out.println("\nMonsters are:");
                    Monster.printAll(monsters);
                    System.out.println("\nWhich monster do you want to check percentageEvil? \nchecking for 'a' index ");
                    int evilIndex = scanner.nextInt()-1;
                    System.out.println(monsters.get(evilIndex).getName() + " is " + monsters.get(evilIndex).percentEvil() + "% evil.");
                    
                }else if (input == 6){    
                    // call the percentEvil2 method on the selected monster
                    System.out.println("\nMonsters are:");
                    Monster.printAll(monsters);
                    System.out.println("\nWhich monster do you want to check percentageEvil? \nchecking for uppercase");
                    int evilIndex = scanner.nextInt()-1;
                    System.out.println(monsters.get(evilIndex).getName() + " is " + monsters.get(evilIndex).percentEvil2() + "% evil.");
                    
                }else{
                    // if the user didnt put in any valid value, but not an error
                    System.out.println("not a valid option, choose again!");
                }
                
            }catch(Exception e){
                    // prints the exception/error message, then clears the scanner nextline so no bugs appear
                System.out.println("Something went wrong try again\n");
                scanner.nextLine();
            }
        }
    }
}