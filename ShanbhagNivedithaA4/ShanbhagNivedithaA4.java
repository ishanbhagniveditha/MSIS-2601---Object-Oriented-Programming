// Name: Niveditha Shanbhag, Java Assignment 4 - Gift Delivery
/* Requirements:
Your gift is eligible for delivery –
1. The shipping weight must be less than 25lbs.
2. The dimensions of the gift must be less than – 15x18x20 inches.
Note: The gifts are three-dimensional, so the order that you enter the dimensions in
MUST be irrelevant and your code must be able to handle all combinations as the cubic
gifts can be arranged in any way. For example, 15x25x20 is the same as 20x15x25.

Create a java file named LastnameFirstnameA4.java. It should include two classes. One
is a public class with the same name as the file.

The “Gift” class should include:
1. Four private double fields – length, height, width, and weight storing dimensions
(in inches) and weight (in pounds) of a gift.
2. A constructor with the 3 dimensions as the parameters.
3. A constructor with only length and width of the gift as the parameters. (The
height or thickness of this gift (think of a card) is so small that can be ignored)
4. Four getters to get gifts dimensions and weight.
5. A setter for gifts weight.

• The class LastnameFirstnameA4 should have:
1. Two private fields – a field storing the Gift instance and a String storing the
receiver’s name.
2. A constructor with the Gift and receiver’s name as the parameters and get the
gifts weight from user input. If the user input is not a number, it should print a
message “Weight should be one number. Please enter again: “and try to get the
Gifts weight from user input again until success.
Hint: This is where you will ask for the weight and “set” the weight of the new
instance of LastnameFirstnameA4.java.
3. A private method validateGift() – validates the gift with respect to the shipping
companies rules and returns the value. It checks for following 4 conditions:
a. Package is too large and too heavy
b. Package is too large
c. Package is too heavy
d. Package is acceptable
4. A public method deliver() – displays if the gift is acceptable or not and also
displays necessary details of the Gift as sample cases show below.
You can pass arguments in the above functions wherever necessary.
In the main method of LastnameFirstnameA4.java, you should create HARD CODED 6 new
instances of LastnameFirstnameA4.java.
Hint: Create them using the LastnameFirstnameA4.java constructor highlighted above in step 2.
Name of the receiver Gift Dimensions
1 Prof.Ghiassi 10x10x10
2 Elyse 15x20x15
3 Pratik 15x18x21
4 Leavey 15x25x9
5 Lucas 10x10
6 Benson 30x20
Note: Do not change the names, or the order of dimensions.
Hint: After creating each instance, use the deliver() method to display if the Gift is acceptable or
not.
For example – you created an instance Gift1 of LastnameFirstnameA4.java with Name
“Prof.Ghiassi” and dimensions 10x10x10, then you can say – Gift1.deliver()
*/

import java.util.*;  // Import the Scanner class

//Gift class start
class Gift{
    private  double length;
    private  double height;
    private  double width;
    private  double weight;

    //Constructor for 3 dimension
    Gift(double x, double y, double z){
        length = x;
        width = y;
        height = z;
    }

    //2nd constructor for length and width
    Gift(double l, double w){
        length = l;
        width = w;
    }

    // setter for weight
    public void setWeight(Double weight){
        this.weight = weight;
    }
    //Getter for length
    public double getLength(){
        return length;
    }
    //Getter for width
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }
    public double getWeight(){
        return weight;
    }
}
//End of gift class


public class ShanbhagNivedithaA4 {

    private static String ReceiverName; //Static string Receiver name - static variable
    private static Gift giftobj; //Static Gift gift-obj name - static variable

    ShanbhagNivedithaA4(String ReceiverName, Gift giftObj) {
        Boolean isValid;
        //Scanner to scan and read user input
        Scanner sn = new Scanner(System.in);
        //To prompt user to enter the weight of the gift and get the weight of the gift
        System.out.print("Enter the weight of your gift to " + ReceiverName + ":");

        do {
            String n = sn.next();
            String regex = "\\d+(\\.)?(\\d+)?"; //Regex: To check if the string n scanned matches double data type
            if (n.matches(regex)) { //If the n matches regex format
                double weight = Double.parseDouble(n); //To convert the string n to double data type
                isValid = true; //Boolean = true
                giftObj.setWeight(weight); //To set the weight
            } else {
                System.out.print("Weight should be one number. Please enter again: "); //If the n does not match regex, to print this out and prompt user to type in the weight again
                isValid = false; //Boolean = false
            }
        } while (!isValid); //Loop until the weight is of correct and valid data type
    }

    public static void main(String[] args) {
        //Hard Coded 6 new instances:

        //Prof Ghiassi - Gift - dimension(10,10,10), weight - 24
        ReceiverName = "Prof.Ghiassi";
        giftobj = new Gift(10,10,10);
        ShanbhagNivedithaA4 Gift1 = new ShanbhagNivedithaA4(ReceiverName, giftobj);
        Gift1.deliver();

        //Elyse - Gift - dimension (15,20,15) , weight - 30
        ReceiverName = "Elyse";
        giftobj = new Gift(15,20,15);
        ShanbhagNivedithaA4 Gift2 = new ShanbhagNivedithaA4(ReceiverName, giftobj);
        Gift2.deliver();

        //Pratik -  Gift - dimension (15,18,21), weight - 42.5
        ReceiverName = "Pratik";
        giftobj = new Gift(15, 18, 21);
        ShanbhagNivedithaA4 Gift3 = new ShanbhagNivedithaA4(ReceiverName, giftobj);
        Gift3.deliver();

        //Leavey - Gift - dimension (15,25,9), weight - 12
        ReceiverName = "Leavey";
        giftobj = new Gift(15,25,9);
        ShanbhagNivedithaA4 Gift4 = new ShanbhagNivedithaA4(ReceiverName, giftobj);
        Gift4.deliver();

        //Lucas - Gift dimension - (10,10), weight- 0.1
        ReceiverName = "Lucas";
        giftobj = new Gift(10,10);
        ShanbhagNivedithaA4 Gift5 = new ShanbhagNivedithaA4(ReceiverName, giftobj);
        Gift5.deliver();

        //Benson - Gift dimension - (30,20), weight- 0.1
        ReceiverName = "Benson";
        giftobj = new Gift(30,20);
        ShanbhagNivedithaA4 Gift6 = new ShanbhagNivedithaA4(ReceiverName, giftobj);
        Gift6.deliver();


        System.out.println("Program Completed.");
    }
    private static String validateGift (double length, double width, double height, double weight) {

        Double max, min, mid;
        String response = "";

        //To do sorting of values since length/width/height values can be sorted and be accepted in any order
        max = height;
        if (length > max || width > max) {
            if (length > width) {
                max = length;
            } else {
                max = width;
            }
        }
        min = height;
        if (length < min || width < min) {
            if (length < width) {
                min = length;
            } else {
                min = width;
            }
        }
        mid = length + width + height - max - min;

        //To do the package checking as per min, max and mid (dimensional) values as well as the weight of the package which should be less than 25 pounds
        if((min > 15 || mid > 18 || max > 20) && weight >= 25) {
            response = "Large and Heavy";
        } else if((min > 15 || mid > 18 || max > 20) && weight < 25) {
            response = "Large";
        } else if((min < 15 || mid < 18 || max < 20) && weight >= 25) {
            response = "Heavy";
        } else {
            response = "Acceptable";
        }

       return response;
    }
    public static void deliver() {
        //To call validateMsg function
        String validateMsg = validateGift(giftobj.getLength(), giftobj.getWidth(), giftobj.getHeight(), giftobj.getWeight());

        //To return statement output accordingly as per the return response from the validate function above
        if(validateMsg == "Acceptable") {
            System.out.println("Congratulations! The gift to " + ReceiverName + " is eligible for delivery.\n");
        } else if(validateMsg == "Large") {
            System.out.println("The gift to " + ReceiverName + " is too large for delivery.");
            System.out.println("Try sending a smaller gift.\n");
        }else if(validateMsg == "Heavy"){
            System.out.println("The gift to " + ReceiverName + " is too heavy for delivery.");
            System.out.println("Try sending a lighter gift.\n");
        }else{
            System.out.println("The gift to " + ReceiverName + " is too large and too heavy for delivery.");
            System.out.println("Try sending a smaller and lighter gift.\n");
        }
    }
}

/* Sources referred for the assignment 4:
1) https://www.geeksforgeeks.org/classes-objects-java/#:~:text=A%20class%20is%20a%20user,all%20objects%20of%20one%20type.
2) https://www.javatpoint.com/object-and-class-in-java
3) https://www.w3schools.com/java/java_constructors.asp
4) https://www.tutorialspoint.com/java/java_constructors.htm
5) https://www.baeldung.com/java-static
6) https://www.simplilearn.com/tutorials/java-tutorial/static-keyword-in-java
 */


