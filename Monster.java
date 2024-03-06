// also imports
import java.util.ArrayList;
import java.util.Random;


// the monster class, except it implements comparable, 
// which allows the collections.sort function to be overriden and used
public class Monster implements Comparable<Monster>{
    // declaring the base information, in their correct types
    private String type;
    private String name;
    private int age;
    private boolean breath;
    private double GPA;
    
    // "default" constructor that takes in no parameters, directly assigning values
    public Monster(){
        this.type = "Zombie";
        this.name = "Uuuggghhh";
        this.age = 0;
        this.breath = true;
        this.GPA = 3.9;
    }
    
    // constructor for just name and age, with the type being vampire and having a random gpa...
    public Monster(String name, int age){
        this.type = "Vampire";
        this.name = name;
        this.age = age;
        this.breath = false;
        // rounding the GPA to 1 decimal place, with a value from 0.0 to 4.0
        this.GPA = (Math.round(new Random().nextDouble()*4*10.0))/10.0; 
    }
    
    // constructor that takes in all the values, the one used most commonly
    public Monster(String type, String name, int age, boolean breath, double GPA){
        this.type = type;
        this.name = name;
        this.age = (int)age; // truncates age in case somehow it isnt an int
        this.breath = breath; 
        this.GPA = Math.round(GPA*10.0)/10.0; // rounds the gpa to a 1 decimal place scale
    }
    
    // time warp method
    public void timeWarp(int yearsAged){
        if (yearsAged < 0){
            return;     // if the years aged is negative, dont do anything
        }
        this.age += yearsAged;  // adding the years aged
        this.GPA += 0.1 * (int)(yearsAged/100); // adding gpa stuff
    }
    
    // spa day method
    public void spaDay(double price){
        if (this.age > price){ // if you can afford it
            this.age -= price; // removes the price from the age. age is an int, so it can only store an int, meaning automatic truncation
            this.GPA = this.GPA /2; // halves the gpa
        }
    }
    
    // percent evil method
    public double percentEvil(){
        int indexOfA = name.indexOf('a'); // gets the index of the first 'a'
        int nameLength = name.length();   // stores the value of the length of the name
        if (indexOfA >= 0) {  // prevention of division by zero
            double percentage = ((double) (indexOfA + 1) / nameLength) * 100; // percent evil in a number
            return (Math.round(percentage*10.0))/10.0; // rounds percent evil
        } else {
            return 0.0;
        }
    }
    
    // percent evil 2 method, the challenge one
    public double percentEvil2(){
        int uppercaseCount = 0; // declares count as 0
        int nameLength = name.length(); // name length
        for (int i = 0; i < nameLength; i++) {
            if (Character.isUpperCase(name.charAt(i))) { // if the character at i is uppercase
                uppercaseCount++; // add to the count
            }
        }
        if (nameLength > 0) { // prevents division by zero error
            double percentage = ((double) uppercaseCount / nameLength) * 100; // gets the percentage on a 100 scale
            return (Math.round(percentage * 10.0)) / 10.0; // rounds it
        } else {
            return 0.0;
        }
    }
    
    // tostring method
    public String toString(){
        // just a formatted string
        return "Monster " + this.name + " is a " + this.age + " year old " + this.type + ", has a GPA of " + this.GPA + ", and " + (this.breath ? "has" : "has no") + " breath.\n";
    }
    
    // the overridden compare method.
    public int compareTo(Monster compared){
        // compared now compares monster gpa
        if (compared.GPA > this.GPA){ // if the compared gpa is higher, return 1
            return 1;
        }else if (compared.GPA < this.GPA){ // if the compared gpa is lower, return -1
            return -1;
        }
        return 0; // if they are the same return 0
    }
    
    // prints all of the monsters with their rank before them
    public static void printAll(ArrayList<Monster> monsters){
        // static method that takes in the list to print.
        int rank = 1;
        for (Monster m : monsters){
            System.out.println(rank + ") " + m);
            rank++;
        }
    }
    
    // Getter method for the 'type' field
    public String getType() {
        return this.type;
    }

    // Setter method for the 'type' field
    public void setType(String type) {
        this.type = type;
    }

    // Getter method for the 'name' field
    public String getName() {
        return this.name;
    }

    // Setter method for the 'name' field
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for the 'age' field
    public int getAge() {
        return this.age;
    }

    // Setter method for the 'age' field
    public void setAge(int ageSet) {
        if (ageSet > 0){
            this.age = ageSet;
        }
    }

    // Getter method for the 'breath' field
    public boolean hasBreath() {
        return this.breath;
    }

    // Setter method for the 'breath' field
    public void setBreath(boolean breath) {
        this.breath = breath;
    }

    // Getter method for the 'GPA' field
    public double getGPA() {
        return this.GPA;
    }

    // Setter method for the 'GPA' field
    public void setGPA(double GPA) {
        if (GPA > 0.0){
            this.GPA = GPA;
        }
    }
}