
// Name: Niveditha Shanbhag Subject: MSIS 2601, Object-Oriented Programming Assignment 1//

/* Background of the assignment: This is a simple program to create a compound interest calculator.
Morty decided to save early and start a compound interest saving account.
There is a need to create a compound interest calculation to help Morty determine the total amount
in his account given an original deposit amount (P), an annual interest rate (R),and time in years (T),
assuming interest will be compounded quarterly.
*/
import java.text.DecimalFormat; //Importing package to use Decimal format to format values
//Start of the program
public class ShanbhagNivedithaA1 {
    public static void main(String[] args) {
       try { // Try and catch exception handling to catch errors if the value passed in the parameter is incorrect or invalid
           if (args.length > 0 && args.length < 4) { //Defines the length of arguments being passed as parameters which has to be 3 arguments and not more than 3 (condition)
               //Declaring variable P which is the original deposit amount will be placed as 1st argument/parameter
               double P = Double.parseDouble(args[0]);
               //Declaring variable R which is the annual interest rate will be placed in 2nd argument/parameter
               double R = Double.parseDouble(args[1]);
               //Declaring variable T which is the time will be placed in 3rd argument/parameter
               double T = Double.parseDouble(args[2]);

               //To pass values and calculate the amount based on the calc method below and return the compounded amount
               double amount = Calc(P, R, T);
               //To round off the total amount received by Monty to 2 decimal places
               String amount_roundOff = String.format("%.2f", amount);
               //To format the original amount/original deposit amount, for example if user input is $4000, display output should be $4000 and if its $4000.65 then it should display as $4000.65
               String P_format = myFormat(P);
               //To format the interest rate, for example if user input is 5%, display output should be 5% and if its 5.65% then it should display as 5.65%
               String R_format = myFormat(R);
               //To format the time, for example if time is 5 or 5.0 years, display output should be 5 years and if its 5.50 or 5.5 years then it should display as 5.5 years
               DecimalFormat df1 = new DecimalFormat("#.##");
               String T_format = df1.format(T);
               // To print out the output statement on the total amount received by Monty for the amount he deposits for the rate and time.
               System.out.println("There will be $" + amount_roundOff + " in the account if deposit $"
                       + P_format + " with " + R_format + "% interest rate after " + T_format + " years.");
           }

        } catch (Exception e) {
            //If there are any error or invalid values passed through then to print out the below statement
           System.out.println("Usage: java ShanbhagNivedithaA1 original_deposit_amount annual_interest_rate time_in_years");
        }
        // To print Program completed when program is completed
        System.out.println("Program Completed");
    }

    //To create a method for calculating compounded amount by passing P, R and T argument
    public static double Calc(double P, double R, double T) { //Passing arguments P, R and T for calculating the amount
        // Calculation of Compound interest quarterly
        double CompoundedAmt = (P * Math.pow(1 + (R / 400), 4 * T));
        //To return the total compounded amount from method to the main function
        return CompoundedAmt;
    }
    //To create a method for formatting the original amount and the interest rate
    public static String myFormat(double number) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(number).replaceAll("\\.00$", "");
    }
//End of the program
}

/*
References/Sources used for the above:
1. https://www.math-only-math.com/compound-interest-when-interest-is-compounded-quarterly.html - To reference on the math formula of quarterly compound interest.
2. https://www.geeksforgeeks.org/java-program-to-round-a-number-to-n-decimal-places/ - To reference on how to round-off values to 2 decimal places.
3. https://www.w3schools.com/java/java_try_catch.asp - To reference on the try & catch exception
*/