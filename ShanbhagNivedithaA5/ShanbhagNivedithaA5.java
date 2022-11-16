/*
Name: Niveditha Shanbhag, Object-Oriented Programming - Assignment 5
 */
public class ShanbhagNivedithaA5{
    public static void main(String[] args) {
        Regular regularObj1, regularObj2; //Regular objects
        Express expressObj1, expressObj2; //Express objects

        //Hardcoded the values packageName, weight of the package where package name is Prof.Ghiassi and weight of package = 22
        regularObj1 = new Regular("Prof. Ghiassi",22);

        expressObj1 = new Express("Prof. Ghiassi", 22,10, 10, 10);
        regularObj1.printInfo();//To print out the Regular package information
        expressObj1.printInfo(regularObj1.comparePrice(regularObj1,expressObj1)); //To print out Express package information

        // Hardcoded 2nd set of values - packageName, weight of the package where package name is Leavey and weight = 12
        regularObj2 = new Regular("Leavey", 12);
        expressObj2 = new Express("Leavey", 12, 15, 25, 9);
        regularObj2.printInfo();//To print out the Express package information
        expressObj2.printInfo(regularObj2.comparePrice(regularObj2, expressObj2)); //To print out Express package information

        System.out.println("Program Completed");
    }
}

/* Sources referred for class - ShanbhagNivedithaA5:
1)https://www.geeksforgeeks.org/passing-and-returning-objects-in-java/
*/


