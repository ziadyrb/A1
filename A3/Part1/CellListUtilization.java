package Part1;

/**
 *Assignment 3
 *Part 1
 *Written by:
 *Jonny Linton (27388489)
 *Sorina Kong (26652786)
 *Ziad Yarbouh(27762585)
 *Sabrina D'Mello(27739486)
 * 
 *In this program we are making a CellPhone, CellList and CellListUtilization classes.
 *
 *The driver class is CellListUtilzation. This will test all the methods in
 *the CellList Class.
 *
 */

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;


public class CellListUtilization {

	public static void main(String[] args) {

		
		//Introduction Message:
		
		System.out.println("*****************************************************************************************\n");
		System.out.println("\t\t\t    Welcome to Part 1 of Assignment 3. \n");
		System.out.println("\t\t\t\t   FALL SEMESTER 2015\n\t\t\t\t\t COMP249\n\nDUE:  December 6th, 2015");
		System.out.println("TEAM: CSociety \n\nMEMBERS:\n\tJonny Linton (27388489)\n\tSorina Kong (26652786)\n\tZiad K. Yarbouh(27762585)\n\tSabrina D'Mello(27739486)\n");		
		
		
		System.out.println("\n\n\t\t\t\t\tCellListUtilzation\n");
		System.out.println("*****************************************************************************************\n");

		Scanner sc = null;

		
		//Creating 2 CellList objects...
		
		CellList cList = new CellList();
		CellList cList2 = new CellList();

		CellPhone dupDetector = new CellPhone(-1, "-1", -1, -1);

		System.out.println("\n\nDoes cList equal cList2 ? " +cList.equals(cList2));

		
		//Setting up a Scanner to read from the text file...
		
		try
		{
			sc = new Scanner(new FileInputStream("Cell_Info.txt"));	
		}
		catch(FileNotFoundException e) 
		{							   
			System.out.println("Problem opening files. File Not Found Exception. Cannot proceed to copy.");
			System.out.println("Program will terminate.");	
			System.exit(0);
		}

		
		//Initializing the information from the file into CellPhone objects, and storing them in the CellList
		
		while(sc.hasNext())
		{
			cList.addToStart(new CellPhone(sc.nextLong(), sc.next(), sc.nextDouble(), sc.nextInt()));
		}

		sc.close();

		
		//Display information about the objects in the CellList
		
		System.out.println("Displaying Contents of cList: ");
		cList.showContent(); 
		System.out.println("\n\n");

		
		//Setting up a Scanner to read from the text file...
		
		try
		{
			sc = new Scanner(new FileInputStream("Cell_Info.txt"));	
		}
		catch(FileNotFoundException e) 
		{							   
			System.out.println("Problem opening files. File Not Found Exception. Cannot proceed to copy.");
			System.out.println("Program will terminate.");	
			System.exit(0);
		}

		
		//Initializing the information from the file into CellPhone objects, and storing them in the CellList
		
		while(sc.hasNext())
		{
			cList2.addToStart(new CellPhone(sc.nextLong(), sc.next(), sc.nextDouble(), sc.nextInt()));
		}

		sc.close();

		System.out.println("Displaying Contents of cList2: ");
		cList2.showContent();

		System.out.println("\n\nDoes cList equal cList2 ? " +cList.equals(cList2));

		

		//Finding and deleting duplicates from cList
		
		int i=0; 
		System.out.println("\n\nFinding duplicates in cList...");
		for(int j=0; j<cList.getSize(); j++)
		{
			if(cList.elementAt(j).equals(dupDetector))
			{
				i++;
				System.out.println("Using deleteFromIndex() ....");
				cList.deleteFromIndex(j);
				j = j-1;
			}
		}
		System.out.println("\nTotal number of duplicates: " +i +"\n\n");

		
		//display information about the objects in the CellList after deleting duplicates
		
		System.out.println("Displaying Contents of cList after deleting duplicates: ");
		cList.showContent();

		System.out.println("\n\nDoes cList equal cList2? " +cList.equals(cList2));

		
		//Prompting user to enter a Serial Number to search for using find() method.
		
		Scanner kb = new Scanner(System.in);
		boolean go = true;
		do
		{
			System.out.println("\n\n\nPlease enter a Serial Number to search in cList (or enter 0 to quit): ");
			int sn = kb.nextInt();
			if(sn == 0)
			{
				go = false;
				System.out.println("Stopping Search...");
			}
			else
				cList.find(sn);
		}while(go);

		kb.close();


		
		//Testing my indexOf and elementAt methods..
		
		CellPhone c1 = new CellPhone(7333403, "BenQ", 659.00, 2009);
		System.out.println("\n\nTesting out indexOf() method... Result: " +cList.indexOf(c1));
		CellPhone c2 = cList.elementAt(9);
		System.out.println("Testing out elementAt() method... Result: "+c2 +"\n\n");

		
		//Creating a new CellList object using copy constructor...
		
		CellList cList3 = new CellList(cList);

		System.out.println("Displaying contents of cList3: ");
		cList3.showContent();
		
		//Comparing cList and cList3 for equality
		
		System.out.println("\n\nDoes cList equal cList3 ? " +cList.equals(cList3));

		
		//Adding a new CellPhone to the start of cList3, and displaying
		
		CellPhone c3 = new CellPhone();
		System.out.println("\nAdding a CellPhone to the head...");
		cList3.addToStart(c3);
		System.out.println("\nDisplaying contents of cList3: ");
		cList3.showContent();

		
		//Inserting a new CellPhone into cList3 at index 3, and displaying
		
		CellPhone c4 = new CellPhone(1234567, "Star_Wars", 9.99, 1984);
		cList3.insertAtIndex(3, c4);
		cList3.showContent();

		
		//deleting nodes from cList3, and replacing some, then displaying
		
		cList3.deleteFromIndex(22);
		cList3.deleteFromStart();
		cList3.replaceItemAt(c4, 0);
		cList3.showContent();

		
		//Testing contain() method, which returns a boolean
		
		System.out.println("Does cList3 contain an element with index 1234567? " +cList3.contain(1234567));
		System.out.println("Does cList3 contain an element with index 1111111? " +cList3.contain(1111111));


		//Creating a new CellList object, and initializing every Node to the same CellPhone, and displaying.
		
		CellList cList4 = new CellList();
		System.out.println("\n\nCreating new CellList (cList4)...");
		for(int k=0; k<5; k++)
		{
			cList4.addToStart(c4);
		}
		System.out.println("\nDisplaying contents of cList4: ");
		cList4.showContent();


		//Finding and deleting duplicates from cList
		
		int f=0; 
		System.out.println("\n\nFinding duplicates in cList4...");
		for(int j=0; j<cList4.getSize(); j++)
		{
			if(cList4.elementAt(j).equals(dupDetector))
			{
				f++;
				System.out.println("Using deleteFromIndex() ....");
				cList4.deleteFromIndex(j);
				j = j-1;
			}
		}
		System.out.println("\nTotal number of duplicates: " +f +"\n\n");

		
		//display information about the objects in the CellList after deleting duplicates
		
		System.out.println("Displaying Contents of cList4 after deleting duplicates: ");
		cList4.showContent();

		System.out.println("\n\nExiting Program...");
		System.exit(0);
	} //end of main method


} //end of Class CellListUtilization