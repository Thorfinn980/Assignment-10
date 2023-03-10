import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        /*
        * Write a Java program to validate if a password satisfies the following requirements:
        *
        *   1. The password's length is between 8 and 16 (inclusive)
        *   2. The password must be a combination of at least three out of the following four categories:
        *  (1) lower case letters, i.e., a-z
        *  (2) upper case letters, i.e., A-Z
        *  (3) numbers, i.e., 0-9
        *  (4) the following special symbols: ~!@#$%^&*()-=+_
        * 
        */

        //Create a function that checks if the password is valid?
        //Input argument is a string
        //Check all conditions
        //Return a data type "true or false" to determine validation?
        //IMPORTANT: "least three out of the following four categories"

        Scanner myObj = new Scanner(System.in);
        System.out.print("Input: ");
        String UserInput = myObj.nextLine();

        System.out.println("Password Validation: " + isValidPassword(UserInput));

        //Resource leak so it's closed
        myObj.close();

    }

    public static boolean isValidPassword(String password) {
        //Check length
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }
    
        // Check categories
        boolean hasLowerC = false;
        boolean hasUpperC = false;
        boolean hasNum = false;
        boolean hasSpecialChar = false;
    
        //Sift through password string
        //Check all condistions
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
    
            if (Character.isLowerCase(c)) {
                hasLowerC = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperC = true;
            } else if (Character.isDigit(c)) {
                hasNum = true;
            } else if ("~!@#$%^&*()-=+_".indexOf(c) != -1) {
                hasSpecialChar = true;
            }
        }
    
        //Check conditional count
        //IMPORTANT: "least three out of the following four categories"
        //Brute force seems to be the way
        int count = 0;

        if (hasLowerC) 
            count++;

        if (hasUpperC) 
            count++;

        if (hasNum) 
            count++;

        if (hasSpecialChar) 
            count++;
    
        if (count < 3) {
            return false;
        }
    
        return true;
    }
}
