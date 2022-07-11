package threads;// Java program for the above approach

public class PrintOddEvenWithDifferentThreads {

	// Starting counter
	int counter = 1;

	static int N;

	// Function to print odd numbers
	public  synchronized void printOddNumber()
	{

			// Print number till the N
			while (counter < N) {

				// If count is even then print
				if (counter % 2 == 0) {

					// Exception handle
					try {
						wait();
					}
					catch (
						InterruptedException e) {
						e.printStackTrace();
					}
				}

				// Print the number
				System.out.println("odd : "+counter);

				// Increment counter
				counter++;

				// Notify to second thread
				notify();
			}
		}


	// Function to print even numbers
	public synchronized void  printEvenNumber()
	{

			// Print number till the N
			while (counter < N) {

				// If count is odd then print
				if (counter % 2 == 1) {

					// Exception handle
					try {
						wait();
					}
					catch (
						InterruptedException e) {
						e.printStackTrace();
					}
				}

				// Print the number
				System.out.println(
					"even : "+counter );

				// Increment counter
				counter++;

				// Notify to 2nd thread
				notify();
			}
		}


	// Driver Code
	public static void main(String[] args)
	{
		// Given Number N
		N = 10;

		// Create an object of class
		PrintOddEvenWithDifferentThreads mt = new PrintOddEvenWithDifferentThreads();

		// Create thread t1
		Thread t1 = new Thread(new Runnable() {
			public void run()
			{
				mt.printEvenNumber();
			}
		});

		// Create thread t2
		Thread t2 = new Thread(new Runnable() {
			public void run()
			{
				mt.printOddNumber();
			}
		});

		// Start both threads
		t1.start();
		t2.start();
	}
}
