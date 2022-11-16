/* Name: Niveditha Shanbhag, Java Assignment 2 */

/* Task below:
1. A program to ask the user to define the length of an array (not more than 10) and then accept the integer elements based on
the length defined (No Command Line Parameters) for two arrays and follow the instructions:
2. If the length of the array is invalid or the inputs are not integers, you should print a “Usage” statement exactly as shown below.
3. If the arrays are longer than the set length, the first elements should be taken. a. For example, length = 3, input array = [1 2 3 4 5] the input should be taken as [1
2 3]
When inputs are correct, your file must contain the following:
a. A method that returns the user’s array.
b. A method that prints the array passed to it.
c. A method returns the sorted array of the FIRST array. Do not change the original
array. Any sorting algorithm is fine but do not use APIs! Hint: You can store a
copy by writing a “copy” function.
d. Print this array.
e. A method returns the reversed array of the SECOND array. Do not change the
original array. Hint: You can store a copy by using the above written “copy”
function.
f. Print this array.
g. A method that prints the count of even and odd numbers.
h. Print the counts of even and odd numbers for both the arrays using above
method.
i. A method to return the sum of the elements of the array.
j. Print the sum of the two arrays. Note: The print statement is different if the sum
is equal and different if they are different. (Check example outputs below
carefully.)
 */

import java.util.*;  // Import the Scanner class

public class ShanbhagNivedithaA2 {
    public static void main(String[] args) {
        try { //try and catch statement to catch any errors like if the length of the array is invalid or inputs are not integers

                    System.out.print("Please enter the length of both the arrays:"); //To print out the statement to enter the length of array
                    Scanner sn = new Scanner(System.in); //Scanner class
                    int n = sn.nextInt(); //To scan and read in the value

                    if (n > 10) {
                        System.out.println("Usage: Please input a length of max 10."); //If the size of the array is more than 10 then to print out the usage statement
                    } else {
                        int[] firstArray = readUserInputArray(n); //To call the function for first array
                        int[] secondArray = readUserInputArray(n); //To call the function for second array
                        printUserArray(firstArray, secondArray); // To call the print function for both first and second arrays

                        //To create a backup array for first array
                        int[] backupFirstArray = new int[firstArray.length];
                        for (int i = 0; i < firstArray.length; i++)
                            backupFirstArray[i] = firstArray[i];
                        //To call the sort function to perform on the backup array without changing original array
                        int[] sortfirstArray = sortUserArray(backupFirstArray);
                        //To print out the sorted user array
                        System.out.print("\nThe sorted first array is: [ ");
                        for (Integer sortUserArray : sortfirstArray) {
                            System.out.print(sortUserArray + " ");
                        }
                        System.out.print("]");


                        int[] reversedSecondArray = reverse(secondArray);
                        System.out.print("\nThe second array in reverse order is: [ ");
                        for (Integer reverse : reversedSecondArray) {
                            System.out.print(reverse + " ");  //To print out the reversed user array
                        }
                        System.out.print("]");

                        //To call the function to perform the count of odd and even numbers for both first and second array
                        countOfEvenOddNum(firstArray, secondArray);

                        //To call the function to return the sum of the elements of the two arrays
                        int arrayFirstSum = sumOfElementsofArray(firstArray); //To print the sum of first array
                        int arraySecondSum = sumOfElementsofArray(secondArray); //To print the sum of second array

                        //To check if the sum of the first array is equal to second array
                        if (arrayFirstSum == arraySecondSum) {
                            System.out.println("The sum of the elements of the two arrays is " + arraySecondSum + "."); //If both sum of arrays are equal then to print this statement
                        } else {
                            System.out.println("The sum of the elements from the first array is " + arrayFirstSum + " and second array is " + arraySecondSum + "."); //If the sum of the arrays are different, then to print this statement
                        }
                    }//To close the scanner
                        sn.close();
                      //To print out that program is completed
                        System.out.println("\nProgram Completed.");
                      //Try and catch statement, should there be any float, double, string values or any other invalid characters other than integers to catch the error
                    } catch (InputMismatchException e) {
                           // Usage statement to be printed out
                            System.out.println("Usage: Please only input integers.");
                           //To print out that program is completed
                            System.out.println("\nProgram Completed.");
                    }
                }

                //a) A method to read user input and to return the user`s array
                public static int[] readUserInputArray(int n){
                    Scanner scan = new Scanner(System.in);
                    int[] a = new int[n];
                    System.out.println("Please enter " + n + " elements for the array:");
                    for (int i = 0; i < n ; i++) {
                        a[i] = scan.nextInt();
                    }
                    return a;
                }

                //b) A method that prints the array passed to it
                public static void printUserArray(int[] firstArray, int[] secondArray) {
                    System.out.print("The first input Array is: [ ");
                    for (Integer val1 : firstArray){
                        System.out.print(val1 + " ");
                    }
                    System.out.print("]");

                    System.out.print("\nThe second input Array is: [ ");
                    for (Integer val2 : secondArray) {
                        System.out.print(val2 + " ");
                    }
                    System.out.print("]");
                }


                //c)The function/method below is to return the sorted array of the first array
                public static int[] sortUserArray (int[] FirstArray) {
                    for (int i = 0; i < FirstArray.length; i++) {
                        for (int j = i + 1; j < FirstArray.length; j++) {

                            if (FirstArray[i] > FirstArray[j]) {
                                int tmp = FirstArray[i];
                                FirstArray[i] = FirstArray[j];
                                FirstArray[j] = tmp;
                            }
                        }
                    }
                    return FirstArray;
                }

                    //d) The function/method below is to return the reversed array of the second array by not changing the original array
                    public static int[] reverse(int[] SecondArray) {

                        int[] SecondNewArray = new int[SecondArray.length];
                        for (int i = 0; i < SecondArray.length; i++) {
                            SecondNewArray[SecondArray.length - 1 - i] = SecondArray[i];
                        }
                        return SecondNewArray;
                    }

                    //e) The function/method below is to return the count of even and odd numbers and printing the count of even and odd numbers for both the arrays
                public static void countOfEvenOddNum(int[] firstArray, int[] secondArray) {

                    int EvenCountFirstArray = 0;
                    int OddCountFirstArray = 0;
                    int EventCountSecondArray = 0;
                    int OddCountSecondArray = 0;

                    for (int i=0; i < firstArray.length; i++) {
                        if (firstArray[i] % 2 == 0) {
                            EvenCountFirstArray++;
                        } else {
                            OddCountFirstArray++;
                        }
                    }
                    System.out.println("\nIn the first array, count of even numbers: " + EvenCountFirstArray + " & count of odd numbers: " + OddCountFirstArray);
                    for (int m=0; m < secondArray.length; m++) {
                        if (secondArray[m] % 2 == 0) {
                            EventCountSecondArray++;
                        } else {
                            OddCountSecondArray++;
                        }
                    }
                    System.out.println("In the second array, count of even numbers: " + EventCountSecondArray + " & count of odd numbers: " + OddCountSecondArray);
                }

                 //i) The function/method below is to return the sum of the elements of the array
                public static int sumOfElementsofArray (int[] arrayToSum) {
                    int SumofArray = 0;
                    for (int i = 0; i < arrayToSum.length; i++) {
                        SumofArray = SumofArray + arrayToSum[i];
                    }
                    return SumofArray;
                }
           }

/* Sources used to complete assignment:
1. https://www.geeksforgeeks.org/array-copy-in-java/
2. https://www.w3schools.com/java/java_arraylist.asp
3. https://www.w3schools.com/java/java_user_input.asp
4. https://www.geeksforgeeks.org/arraylist-in-java/
5. https://www.codecademy.com/article/variable-scope-in-java
 */








