package parts1and2;

/**
 * Assignment 2
 * Part 2
 * Writen By:
 * Jonny Linton (27388489)
 * Sorina Kong (26652786)
 * Ziad Yarbouh(27762585)
 * Sabrina D'Mello(27739486)
*/

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.File;

public class BookInventory1{
	
		public static void displayFileContents(String input)
		{
			Scanner sc = null;
			
			try
			{
				sc = new Scanner(new FileInputStream(input));	
			}
			catch(FileNotFoundException e) 
			{							   
				System.out.println("Problem opening files. File Not Found Exception. Cannot proceed to copy.");
				System.out.println("Program will terminate.");	
				System.exit(0);
			}
			System.out.println("\n ****** Displaying File Contents ***** \n");
			while(sc.hasNextLine())
			{
				String line = sc.nextLine();
				System.out.println(line);
			}
			
		}
	
		//Helping Method -- counts number of Book objects there are in the file.
		private static int bookCounter(Scanner sc)
		{
			int i = 0; 
				while(sc.hasNextLine())
				{
					String garb = sc.nextLine();
					i++;
				}
				
				if(i<=1)
				{
					System.out.println("There is not enough information in this file to compare...Exiting Program");
					sc.close();
					System.exit(0);
				}
				sc.close();
				return i;
		}
		
		// Helping Method - Traces the Array, and compares the entered Book's ISBN to all other ISBN's in the array.
		private static int[] findDuplicates(Book[] arr, Book b)
		{
			
			int[] dupIndexArr = new int[arr.length];
			for(int j=0; j<arr.length; j++)
			{
				dupIndexArr[j] = -1;
			}
			
			for(int i=0; i<arr.length; i++)
			{
				if(b.getISBN() == arr[i].getISBN() && !(b.equals(arr[i])))
				{
					dupIndexArr[i] = (i+1);
				}
			}
			return dupIndexArr;
		}
		
		//fixInventory Method
		/*
		 * Must read books from the input file, and store them as Book objects in the array
		 * Traces array looking for duplicate ISBN numbers
		 * Then prompt user to enter a new ISBN -- if still a duplicate, throws DuplicateISBNException
		 * Display a message indicating this, then prompt to ask user again (repeat duplicate check)
		 * Once all Duplicates are removed, new ISBN must be written to the output file
		*/
		public static void fixInventory(String input, String output) 
		{
			Scanner sc = null;
			PrintWriter pw = null;
			
			try
			{
				sc = new Scanner(new FileInputStream(input));	
				pw = new PrintWriter (new FileOutputStream(output));	  
			}
			catch(FileNotFoundException e) 
			{							   
				System.out.println("Problem opening files. File Not Found Exception. Cannot proceed to copy.");
				System.out.println("Program will terminate.");	
				System.exit(0);
			}
			
			
			int bookCounter = bookCounter(sc);
			
			//Must re-initialize the Scanner 'sc' because the bookCounter() method closed the Scanner. 
			//This is done so that the cursor is at the beginning of the file again.
			try
			{
				sc = new Scanner(new FileInputStream(input));	
			}
			catch(FileNotFoundException e) 
			{							   
				System.out.println("Problem opening files. File Not Found Exception. Cannot proceed to copy.");
				System.out.println("Program will terminate.");	
				System.exit(0);
			}
			
			Book[] bkArr = new Book[bookCounter]; //creates an array of Books with the correct number of elements.
			for(int j=0; j<bookCounter; j++) //Initializing the Array using default constructor
			{
				bkArr[j] = new Book();
			}
			
			Scanner kb = new Scanner(System.in);
			
			int ctr = 0;
			while(sc.hasNextLine() && ctr < bookCounter) //reads books from the input file, and store them as Book objects in the array
			{
				bkArr[ctr].setISBN(sc.nextLong());
				bkArr[ctr].setTitle(sc.next());
				bkArr[ctr].setYear(sc.nextInt());
				bkArr[ctr].setAuthor(sc.next());
				bkArr[ctr].setPrice(sc.nextDouble());
				bkArr[ctr].setNumOfPages(sc.nextInt());
				
				if(sc.hasNextLine()) //moves onto next line (ie next Book entry)
				{
					String garbage = sc.nextLine();
				} 
				
				ctr++;
			}
			
			for(int i=0; i<bkArr.length; i++)
				{
					int[] dup1 = findDuplicates(bkArr, bkArr[i]);
					for(int j=0; j<dup1.length; j++)
					{
						if(dup1[j] != -1)
						{
							System.out.println("\nDuplicate ISBN (" +bkArr[i].getISBN() +") for Book in record #" +(i+1) +" found in record #" +dup1[j]);
							// the book in bkArr[i] has a duplicate ISBN at position dup[j]
							// bkArr[dup[j]-1] is the Book which has the same ISBN
							
							boolean isThereDup;
							long newISBN;
							do
							{
								isThereDup = false;
								System.out.println("Enter a new ISBN (9 digits) for the Book in record #" +dup1[j] +": ");
								newISBN = kb.nextLong();
								
								try
								{ 
									for(int k=0; k<bkArr.length; k++)
									{
										if(newISBN == bkArr[k].getISBN() || newISBN < 100000000 || newISBN > 999999999)
											{
												throw new DuplicateISBNException();
											}
									}
								}
								catch(DuplicateISBNException e)
								{
									isThereDup = true;
									System.out.println("Please Try Again.\n");
								}
								
							}while(isThereDup);
							
							bkArr[dup1[j]-1].setISBN(newISBN);
							System.out.print("Thank you! ISBN is valid.\n");
							
						} //end of If Statement --> if(dup1[j] != -1)
						
					} //end of 2nd For loop w/ 'j'
				
				System.out.println("Writing to file...     " +bkArr[i]);
				pw.println(bkArr[i]);
				
				} //end of 1st For loop w/ 'i'
			System.out.println("\n ****** Book Inventory Fixed! ******");
			kb.close();
			sc.close();
			pw.close();
		} // End of fixInventory
	
	public static void main(String[] args){
		
		String s1 = "Initial_Book_Info.txt", s2;
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Please enter the name of the corrected file.");
		s2 = kb.nextLine();
	
		File f = new File(s2);		
		while(f.exists())
		{
			System.out.println("Error: There is an existing file called: " + s1 + ".");
			System.out.println("That file already has a size of " + f.length() + " bytes.");
			System.out.println("\nPlease enter another file name to copy to: ");
			s2 = kb.next();
			f = new File(s2);
		}
		
		fixInventory(s1, s2);
		
		displayFileContents(s2);
		
		kb.close();
	}
	
	
}


