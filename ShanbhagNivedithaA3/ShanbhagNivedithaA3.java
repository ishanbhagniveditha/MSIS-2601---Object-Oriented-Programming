// Name: Niveditha Shanbhag
// Assignment 3 Java (isPalindrome and find-substring)
//Date: 13th October 2022

import java.util.*;  // Import the Scanner class

public class ShanbhagNivedithaA3 {
    public static void main(String[] args) {

        boolean validatorResultString;

        String[] stringArray = new String[3];
        for(int i = 0; i < stringArray.length; i++) {
            Scanner sn = new Scanner(System.in); //Scanner to scan and read user input
            System.out.println("Please enter a string:"); //To print to get user input
            String m = sn.nextLine(); //To scan the input
            validatorResultString = validateString(m); //To call validate string function
            if(validatorResultString || m == "") {
                //If the string is empty or if the string result is non-word and/or non-numeric to print out the below statement
                i--; //To prompt the user to enter the string again
                System.out.println("Usage: Enter a string that contains alphabetic characters and numbers");
            } else {
                stringArray[i] = m; //If the string is valid and is not empty, to store the value
            }
        }

        String firstString = stringArray[0]; //First String
        String secondString = stringArray[1]; //Second String
        String thirdString = stringArray[2]; //Third String

        if(firstString != null && secondString != null && thirdString != null) {
            System.out.println("\nThe given string is " + '"' + firstString + '"'); //To print out first string (user input)
            System.out.println("The prefix is " +  '"' + secondString + '"'); //To print out second string (prefix)
            System.out.println("The suffix is " +  '"' + thirdString + '"'); //To print out third string (suffix)

            boolean A = isPalindrome(firstString); //isPalindrome method value is returned here and is assigned to boolean A
            if (A == true) {
                System.out.println("\nThe given string is a palindrome."); //If the string passed is palindrome to print out this statement
            } else {
                System.out.println("\nThe given string is not a palindrome."); //If the string passed is not palindrome then to print out this statement
            }

            //To call the function/method find-substring and pass the parameters firstString, secondString & thirdString
            String substring = findSubstring(firstString, secondString, thirdString);

            if (substring == null) {
                System.out.println("No such substring in the given string."); //If substring is null, then to print this statement
            } else {
                System.out.println("The substring is " + '"' + substring + '"'); //If there is a substring found, then to print this statement
            }
            //To print program completed
            System.out.println("\nProgram Completed");
        }
    }

    //A private method to validate the strings being scanned and read
    private static boolean validateString(String M) {

        String regex = "[^a-zA-Z0-9]*"; //Validation regex to validate strings that are being passed to ensure no non-word or non-numeric characters are passed through
        Boolean isMatch = M.matches(regex); // if string matches regex as per above is assigned to Boolean IsMatch
        return isMatch; //To return isMatch value to main method
    }


    //A method "isPalindrome" that takes a String as a parameter and returns true if the
    //given String parameter is a palindrome and false if it is not
    public static boolean isPalindrome(String M){
        // Initializing an empty string to store the reverse of the original str
        String str = "";
        M = M.replaceAll("\\s+",""); //remove white space
        M = M.replaceAll("[^a-zA-Z ]", ""); //removes all punctuation
        boolean ans = false; //To define and assign boolean variable as false

        for (int i = M.length() - 1; i >= 0; i--) {
            str = str + M.charAt(i); //For loop to see if the words in reverse is same as words passed as a string
        }
        // Checking if both the strings are equal
        if (str.equalsIgnoreCase(M)) {
            ans = true; // If all conditions are met, to return the ans=true
        }
        else{

            ans=false; //If conditions not met then to return the ans as false
        }
        return ans; //To return the ans value to main method
    }


    //"findSubstring" method to that takes 3 strings as parameters and checks if
    //the first string contains a substring that starts with the second string, ends with the third string,
    //and has an even number of characters in between
    public static String findSubstring(String str, String open, String close) {
        if (str == null || open == null || close == null) {
            return null; //If the string is null, open and close is null, then to return null
        }
        int start = str.toLowerCase().indexOf(open.toLowerCase()); //
        if (start != -1) {
            int end = str.toLowerCase().indexOf(close.toLowerCase(), start + open.length());
            if (end != -1) {
                String evenString = ""; //To assign a null value to even String
                evenString = str.substring(start + open.length(), end); //To indicate the position between the start of the string (prefix) till the end (suffix)
                evenString = evenString.replaceAll("\\s+", ""); //To ignore whitespace
                evenString = evenString.replaceAll("[^a-zA-Z ]", "");//To ignore punctuations in between the characters
                int lengthOfevenString = evenString.length(); //to define the length of between the start of string (prefix) till end (suffix)
                if (lengthOfevenString % 2 == 0) {
                    return str.substring(start, (end + close.length()));
                    //To return the substring to main method if it has even number of characters in between the prefix and suffix
                }
                else
                    return null; //If its odd number of characters, to return null value to main method
            }
        }
        return null; //To return null to main method if blank
    }
}

/* Sources used to complete the assignment:
1. https://www.geeksforgeeks.org/check-if-a-string-consists-only-of-special-characters/
2. https://www.javamadesoeasy.com/2015/12/how-to-check-string-contains-only.html
3. https://www.geeksforgeeks.org/count-the-number-of-matching-characters-in-a-pair-of-strings/
4. https://www.geeksforgeeks.org/count-of-strings-whose-prefix-match-with-the-given-string-to-a-given-length-k/
5. https://stackabuse.com/java-check-if-string-contains-a-substring/
6. https://www.geeksforgeeks.org/string-arrays-in-java/
 */
