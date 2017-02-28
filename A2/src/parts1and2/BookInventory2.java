package parts1and2;
/**
 * Assignment 2
 * Part 2
 * Writen By:
 * Jonny Linton (27388489)
 * Sorina Kong (26652786)
 * Ziad Yarbouh (27762585)
 * Sabrina D'Mello (27739486)
 * Program Details:
 * 1) In the main we need to OPEN the Sorted_Book_Info.txt
 * 2) The USER needs to APPEND a few records to the Sorted_Book_Info.txt -----We assume the user has sorted the .txt. THEREFORE no need to sort.
 * 3) Call displayFileContents() to show all the files in Sorted_Book_Info.txt
 * 4) Use bkArr[] to find how many records are in Sorted_Book_Info.txt --- The array need to be set to the size of the total number of records.
 * 5) Program must read the contents of the file to the array objects.
 * 6) The USER enters an ISBN and it uses binaryBookSearch() and the sequentialBookSearch() to find it
 * 7) Store everything in bkArr[] into a binary file
 */

import parts1and2.Book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.io.ObjectOutputStream;

public class BookInventory2 {
	public static void main(String[] args) throws Exception 
	{

		System.out.println("The Sorted_Book_Info.txt currently has the following contents:\n");

		//1)
		BufferedReader br = null;
		try
		{
			br = new BufferedReader(new FileReader("Sorted_Book_Info.txt"));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FileNotFoundException was thrown. Unable to find Sorted_Book_Info.txt.\nThe program will now terminate...");
			System.exit(0);
		}
		//3)
		displayContents(br);

		//2) + 4)
		System.out.println("\n");
		Scanner bc = null;

		try
		{
			bc = new Scanner(new FileInputStream("Sorted_Book_Info.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("FileNotFoundException was thrown. Unable to find Sorted_Book_Info.txt.\nThe program will now terminate...");
			System.exit(0);
		}
		System.out.println("There is " + bookCounter(bc) + " records in the Sorted_Book_Info.txt");
		bc.close();	

		System.out.println("\n");
		addRecords();

		//4) - second time to show the updates NUMBER of records
		Scanner nbc = null;
		try
		{
			nbc = new Scanner(new FileInputStream("Sorted_Book_Info.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("FileNotFoundException was thrown. Unable to find Sorted_Book_Info.txt.\nThe program will now terminate...");
			System.exit(0);
		}
		System.out.println("\n");
		System.out.println("Now there is " + bookCounter(nbc) + " records in the Sorted_Book_Info.txt");
		nbc.close();

		Scanner makingArr = null;
		try
		{
			makingArr = new Scanner(new FileInputStream("Sorted_Book_Info.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("FileNotFoundException was thrown. Unable to find Sorted_Book_Info.txt.\nThe program will now terminate...");
			System.exit(0);
		}		


		int makingArrCount = bookCounter(makingArr);
		Book[] bkArr = new Book[makingArrCount]; 


		//5)

		for(int j=0; j<makingArrCount; j++) 
		{ 
			bkArr[j] = new Book(); 
		}



		//Here we are trying to split each ...and setting it

		try
		{
			makingArr = new Scanner(new FileInputStream("Sorted_Book_Info.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("FileNotFoundException was thrown. Unable to find Sorted_Book_Info.txt.\nThe program will now terminate...");
			System.exit(0);
		}		
		int ctr = 0;
		System.out.println("The bookCounter counted "+ makingArrCount +" in total...");
		while(makingArr.hasNextLine() && ctr <= makingArrCount) //reads books from the Sorted_Book_Info.txt file then store them as Book objects in the array
		{
			bkArr[ctr].setISBN(makingArr.nextLong()); 
			bkArr[ctr].setTitle(makingArr.next()); 
			bkArr[ctr].setYear(makingArr.nextInt()); 
			bkArr[ctr].setAuthor(makingArr.next());
			bkArr[ctr].setPrice(makingArr.nextDouble());
			bkArr[ctr].setNumOfPages(makingArr.nextInt());

			if(makingArr.hasNextLine()) //moves onto next line (ie. next Book entry)
			{
				String garbage = makingArr.nextLine();
			}  
			ctr++;
		}
		makingArr.close();

		//This is where the searches begin:

		System.out.println("\n************* Search with Binary Search and Sequential Search **********");
		Scanner kb = new Scanner(System.in);
		long isbn;
		System.out.println("Please enter an ISBN you which to search for: ");
		isbn = kb.nextLong();
		
		System.out.println("\nStarting the Binary Book Search of the ISBN: " + isbn + "\n");
		int binaryResult = binaryBookSearch(bkArr, isbn, 0, bkArr.length-1);
		System.out.println(binaryResult);
		
		System.out.println("\nStarting the Sequential Book Search of the ISBN: " + isbn + "\n");
		int numOfIterations = SequentialBookSearch(bkArr, isbn, 0, bkArr.length-1);
		System.out.println(numOfIterations);
		
		

		//7)
		//Next is to convert bkArr[] to binary, but we need to fix BookCounter first.
		
		System.out.println("\n************* Storing bkArr[] into Book.dat **********");
		
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Book.dat"));
		for(int j=0; j<bkArr.length; j++)
		{
			output.writeObject(bkArr[j]);
		}
		
		output.close();

	}


	public static int binaryBookSearch(Book[] array, long iSBN, int start, int end) {

		//Arrays.sort(array);
		while (start <= (end-1)) {
			// Key is in a[lo..hi] or not present.
			int mid = start+ (end - start) / 2;
			if      (iSBN < array[mid].getISBN()) end = mid - 1;
			else if (iSBN > array[mid].getISBN()) start = mid + 1;
			else return mid;
		}
		return -1;

	}


	public static void displayContents(BufferedReader br) throws IOException {

		int x = br.read();
		while (x != -1) {
			System.out.print((char) x);
			x = br.read();
		}
		br.close();
	}


	public static void addRecords(){

		PrintWriter pw = null;
		Scanner kb = new Scanner(System.in);
		Scanner w = new Scanner(System.in);
		int i;
		String s = null;
		try
		{
			pw = new PrintWriter(new FileOutputStream("Sorted_Book_Info.txt", true)); 
		}
		catch(FileNotFoundException e) 	
		{		
			System.out.println("Could not open/create the file to write to. "+ " Please check for problems such as directory permission"+ " or no available memory.");
			System.out.print("Program will terminate.");
			System.exit(0);			   		   
		}
		System.out.println("How many records would you like to add?");
		i = kb.nextInt();
		if(i <= 0){
			System.out.println("No records will be added. \nProgram will continue...");
		}
		else
		{

			while (i != 0) 
			{		

				do 
				{
					System.out.println("Please enter the ISBN Title_Name Year Author_Name Price NumberOfPages:");
					s = w.nextLine(); 
				} while((s.equals("")));

				pw.println(s);

				i--;
			}
			pw.close();
			kb.close();
			w.close();
		}

	}

	public static int SequentialBookSearch(Book[] array, long iSBN, int start, int end) {
		int numOfIterations = -1;
		if (end >= array.length) {
			System.out.println("Not Found.");
			return numOfIterations;
		} else {
			for (int i = start; i <= end; i++) {
				numOfIterations++;
				if (array[i].getISBN() == iSBN) {
					System.out.println("Found at index: " + i + ", after "+ (numOfIterations+1) + " iterations.");
					return numOfIterations;
				}
			}
			System.out.println("Not Found");
			return numOfIterations+1;
		}
	}


	private static int bookCounter(Scanner sc) {
		int i;
		i = 0;
		while (sc.hasNextLine()) {
			String garb = sc.nextLine();
			i++;
		}

		if (i <= 1) {
			System.out.println("There is not enough information in this file to compare...Exiting Program");
			sc.close();
			System.exit(0);
		}
		sc.close();
		return i;
	}
	
	
}
