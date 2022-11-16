
// ShanbhagNivedithaA6 class extending Runnable interface
class ShanbhagNivedithaA6 implements Runnable {
    // run() method of this class
    public void run() {
        // Thread run() method
        System.out.println("thread_1 is executed");
    }

    // Main method
    public static void main (String[] args) {
        // Making objects of class 1 and 2 in main() method
        ThreadTest obj = new ThreadTest();
        ShanbhagNivedithaA6 obj2 = new ShanbhagNivedithaA6();

        //Creating 2 threads in main() method
        Thread thread_1 = new Thread(obj);
        Thread thread_2 = new Thread(obj2);

        //Moving thread to runnable states
        thread_1.start();
        thread_2.start();

        //Utilized the Java thread method - getName() in order to get the name of the thread_1
        System.out.println("thread_1 name: " + thread_1.getName()); //part c)

        System.out.println("thread_1 waiting for thread_2 to join");

        try {
            //Utilized the Java thread method - join() in order for thread_2 to terminate at the end
            thread_2.join(); //part d)
        } catch (InterruptedException e) {
            // Display the exception along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }

       //Utilizing the Java thread method - yield() to stop current thread_2 execution and to allow thread_1 with higher priority to be executed first
        thread_2.yield();//part a)
    }
}

class ThreadTest implements Runnable {
    public void run() {
        try {
            // Print statement
            System.out.println("thread_2 going to sleep for 5000");
            // Utilizing sleep method by making thread_2 to go to sleep for 5 seconds before next statement executed
            Thread.sleep(5000); //part b)
            //thread-2 wakes up and gets terminated
            System.out.println("thread_2 wakes-up and gets terminated");
        }
        // Catch block to handle exception
        catch (InterruptedException e) {
            // Print statement
            System.out.println("Thread_2 interrupted");
        }
    }
}