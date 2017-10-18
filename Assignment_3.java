Question 1. Find the error in the following code and explain in few lines why it is wrong. (Score 1) Here is the code.
public class Book{    
	int size;
	int price;
    String name;

    /* 
        This constructor should set the default price and name of the book as well. Would be better if we just call the more general constructor here.
        If the default price = 0 and name = "unnamed"
        this(size, 0, "unnamed");

        Another way would be to replace this with a setter
        public void setSize(int size) 
        { 
        	this.size = size 
        }
    */
    public Book(int size){ 
        this.size = size;

    }

    public Book(int size, int price, String name){
        super(); //this is use to inherit from parent class constuctor but this does not seem to inherit anything
        this.size = size;
        this.price = price;
        this.name = name;
    }

    /*
	     This function would cause a compiler error as the signature Book (int) is already defined in the first constructor. This should be replaced with a setter
	     	public void setPrice(int price) {
	    		this.price = price;
		 	}
	*/
    public Book(int price){ 
        this.price = price;
    }

    /*
	     No return type for this function, would result in a compiler error. In current form this function should have return type String.
	    	public String setName(String name)
	    
	    Although if this function is a setter the correct signature would be 
	    	public void setName(String name) {
	    		this.name = name
			}
	*/
    public setName(String name){  
        return name; //function is named as a setter, so instead of returning name, it should be setting the value of name e.g. this.name = name.
        // Although this wouldn't result in a compile error
    }
}

........................................................................Question 2 -----------------------------------------------------

Find the error in the following code and explain in few lines why it is wrong. (Score 1) Here is the code.

class Clock{
    String time;

    /*
    	 Function returns value of time, but return type is provided as void. This would result in a compiler error.
    	 The correct signature of the method should be

    	 String getTime()
    */

    void getTime(){
        return time;
    }

    void setTime(String t){
        time = t ;
    }
}
.....................................................................question 3.........................................................
 Write a Java function to remove vowels in a string. (Score 2)
  i. The function should take a string as input. 
  ii. Should return the input string after omitting the vowels. 
import java.util.Scanner;
 
public class Remove_Vowels{
 
   public static void main(String args[]) {
     Scanner sc = new Scanner(System.in);
     System.out.print("Enter a string");
     String input = sc.nextLine();
     String output =removeVowelsFromString(input) ;
     System.out.println(output);
   }
 
   public static String removeVowelsFromString(String input){
   
     String noVowels = "";
 
     for (int i=0; i<input.length(); i++)
     {
       if (!isVowel(Character.toLowerCase(input.charAt(i))))
       {
         noVowels += input.charAt(i);
       }
     }
     return noVowels;
   }
 
   public  static boolean isVowel(char x) {
 
     String vowels = "aeiou";
     for (int i=0; i<5; i++)
     {
       if (x == vowels.charAt(i))
         return true;
     }
     return false;
   }
}
.....................................................................Question 4...............................................................
 Write a java function to check if two strings are Anagrams or not. (Score 2)
  i. The function should take two input strings.
  ii. Should return a boolean ‘true’ if the inputs are Anagrams else return ‘false’. Here is the prototype you can work with

import java.util.Arrays;
import java.util.Scanner;
public class Anagrams{  
	public static void main(String args[]){
		String s1="cinema";
		String s2="iceman";
		boolean result = checkIfTwoStringsAreAnagrams(s1 , s2);
		if(result==true){
			System.out.println("given strings are Anagrams");
		}
		else{
			System.out.println("given strings are not Anagrams");
		}
    }

    // for checking two strings anagrams here i am doing (checking)-(here String s1=cinema , String s2 = iceman;)
    // 1)check length,if length is not equal it will return false and if equal it will process further (lenghth is equal)
    //2) sort strings (aceimn ; aceimn)
    //3) compare sorted Strings (aceimn = aceimn), if they are same then return true(anagram),else flase(not anagram)

	public static boolean checkIfTwoStringsAreAnagrams(String s1, String s2){
		// isAnagrams is not used
		boolean isAnagrams = true;
		//checking length of strings
		if(s1.length()!=s2.length()){
    		return false;
    	}
    	//sort string by calling sortString function
		String a = sortString(s1);
		String b =  sortString(s2);
		// comparing 
		if(a.equals(b)){
			return true;
		}
		else{
			return false;
		}
    	
    }
    	// sort both string for comparison 
    	// Method to sort a string alphabetically

    public static String sortString(String input){
        // convert input string to char array
        char tempArray[] =  input.toCharArray();
         
        // sort tempArray
        Arrays.sort(tempArray);
         
        // return new sorted string
        return new String(tempArray);
	}
}

........................................................................Question 5...........................................................

 Create a calculator that can perform the following features. (Total Score 4)
  i. The calculator should be able to perform Addition, subtraction, multiplication, division. (Score 2)
  ii. Should be able to perform squareRoot, square, cube. (Score 1) iii. Should be able to convert ‘Fahrenheit-Celsius’ , ‘Feet-Inches’. (Score 1)
   Extra Credit(Score 2)
The calculator should be able to solve a quadratic equation and return the solution as array. i. This function should take three arguments. ii. For example, if quadratic equation is Ax2 + Bx + C. The function should take A,B,C as arguments and return a solution as array.

import java.util.Scanner;

// Main calculator class, its just an entry point, actual work happens in class CalcEngine.
public class Calculator {

    public static void main(String[] args) {
        Ui calcUI = new Ui(new CalcEngine());
        calcUI.start();
    }

}

// The actual calculator operations are performed by this class
class CalcEngine {
    double add (double a, double b) {
        return a+b;
    }

    double subtract (double a, double b) {
        return a-b;
    }

    double multiply (double a, double b) {
        return a*b;
    }

    double divide (double a, double b) {
        // We are assuming the inputs are sanitized, so there wouldn't be any divide by zero.
        return a / b;
    }

    double squareRoot(double a) {
        return Math.sqrt(a);
    }

    double square (double a) {
        return a * a;
    }

    double cube (double a) {
        return a * a * a;
    }

    double fahrenheitTocelsius (double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5 / 9;
        return celsius;
    }

    double celsiusToFahrenheit (double celsius) {
        double fahrenheit = (celsius * 9 / 5) + 32;
        return fahrenheit;
    }

    double feetToInches (double feet) {
        return feet * 12;
    }

    double inchestoFeet (double inches) {
        return inches / 12;
    }

    // Solves a quadratic equation of form ax^2+bx+c. return the roots in an array.
    // number of roots depends on the value of discriminant = b^2 - 4ac
    double[] quadraticEquation (double a, double b, double c) {
        double [] roots;
        double discriminant = (b * b) - (4 * a * c);
        if (discriminant > 0){
            // The equation has two roots
            roots = new double[2];
	    // What if a == 0? Wrong form, should be (-b + sqrt(discriminant)) / (2 * a)
            roots[0] = ((-b + discriminant) / (2 * a));
            roots[1] = ((-b - discriminant) / (2 * a));
        }
        else if (discriminant == 0) {
            //The equation has one root
            roots = new double[1];
            roots[0] = -b/(2*a);
        }
        else {
            // Discriminant < 0 means there are no real roots of the equation
            roots = new double[0];
        }

        return roots;
    }

}

// This class handle the UI of the calculator, providing menu choices and recording responses.
class Ui {
    private CalcEngine engine;

    // Maximum three operands are possible
    double operand1;
    double operand2;
    double operand3;

    Scanner sc;

    public Ui(CalcEngine engine) {
        this.engine = engine;
        sc = new Scanner(System.in);
    }

    int getInput() {
        System.out.println("Please select an operation: ");
        System.out.println("Press 1 for Addition");
        System.out.println("Press 2 for Subtraction");
        System.out.println("Press 3 for Multiplication");
        System.out.println("Press 4 for Division");
        System.out.println("Press 5 for Square root");
        System.out.println("Press 6 for Square");
        System.out.println("Press 7 for Cube");
        System.out.println("Press 8 for Fahrenheit to Celsius conversion");
        System.out.println("Press 9 for Celsius to Fahrenheit conversion");
        System.out.println("Press 10 for Feet to Inches conversion");
        System.out.println("Press 11 for Inches to Feet conversion");
        System.out.println("Press 12 for Solving a quadratic equation");
        System.out.println("Press 0 to exit");

        return sc.nextInt();
    }

    void start(){
        boolean done = false;
        while (done == false) {
            int input = getInput();
            switch (input) {
                case 0:
                    // Exit
                    done = true;
                    break;

                case 1:
                    // Addition
                    inputOperand(2);
                    System.out.println("Result = " + engine.add(operand1, operand2));
                    break;

                case 2:
                    // Subtraction
                    inputOperand(2);
                    System.out.println("Result = " + engine.subtract(operand1, operand2));
                    break;

                case 3:
                    // Multiplication
                    inputOperand(2);
                    System.out.println("Result = " + engine.multiply(operand1, operand2));
                    break;

                case 4:
                    //Division
                    inputOperand(2);
                    // Make sure that second operand (divisor) is not zero
                    if (operand2 != 0.0){
                        System.out.println("Result = " + engine.divide(operand1, operand2));
                    } else {
                        System.out.println("Error: Can not divide by zero !");
                    }
                    break;

                case 5:
                    // SquareRoot
                    inputOperand(1);
                    // Make sure input is not negative
                    if (operand1 < 0.0) {
                        System.out.println("Error: Can not calculate sqrt of a negative number");
                    } else {
                        System.out.println("Result = " + engine.squareRoot(operand1));
                    }
                    break;

                case 6:
                    // Square
                    inputOperand(1);
                    System.out.println("Result = " + engine.square(operand1));
                    break;

                case 7:
                    // Cube
                    inputOperand(1);
                    System.out.println("Result = " + engine.cube(operand1));
                    break;

                case 8:
                    // Fahrenheit To Celsius
                    inputOperand(1);
                    System.out.println("Result = " + engine.fahrenheitTocelsius(operand1));
                    break;

                case 9:
                    // Celsius to Fahrenheit
                    inputOperand(1);
                    System.out.println("Result = " + engine.celsiusToFahrenheit(operand1));
                    break;

                case 10:
                    // Feet to Inches
                    inputOperand(1);
                    System.out.println("Result = " + engine.feetToInches(operand1));
                    break;

                case 11:
                    // Inches to Feet
                    inputOperand(1);
                    System.out.println("Result = " + engine.inchestoFeet(operand1));
                    break;

                case 12:
                    // Quadratic equation
                    inputOperand(3);
                    double[] result = engine.quadraticEquation(operand1, operand2, operand3);
                    if (result.length == 0) {
                        System.out.println("No roots for this equation !!");
                    } else if (result.length == 1) {
                        System.out.println("root = " + result[0]);
                    } else {
                        System.out.println("root 1 = " + result[0] + " root 2 = " + result[1]);
                    }
                    break;

                default:
                    // Should not reach here, wrong selection
                    System.out.println("Invalid input, please try again range (0-12)");
            }
        }
    }

    void inputOperand(int numberOfOperands) {
        // Initialize all operands to zero
        operand1 = 0;
        operand2 = 0;
        operand3 = 0;

        if (numberOfOperands >= 1) {
            if (numberOfOperands == 1) {
                // only one operand
                System.out.println("Enter value");
            } else {
                System.out.println("Enter first value");
            }
            operand1 = sc.nextDouble();
        }
        if (numberOfOperands >= 2) {
            System.out.println("Enter second value");
            operand2 = sc.nextDouble();
        }
        if (numberOfOperands >= 3) {
            System.out.println("Enter third value");
            operand3 = sc.nextDouble();
        }
    }
}
