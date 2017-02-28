package Part2;

/**
 *Assignment 3
 *Part 2
 *Written by:
 *Jonny Linton (27388489)
 *Sorina Kong (26652786)
 *Ziad Yarbouh(27762585)
 *Sabrina D'Mello(27739486)
 * 
 *In this program we are making a CellPhone, CellList, CellHash, and CellHashUtilization classes.
 *
 *The Driver class, CellHashUtilization, will use all the methods on create in
 *CellHash class.
 */


import java.util.Scanner;


public class CellHashUtilization {

	public static void main(String[] args) {

		
		//Introduction Message:
		
		System.out.println("*****************************************************************************************\n");
		System.out.println("\t\t\t    Welcome to Part 2 of Assignment 3. \n");
		System.out.println("\t\t\t\t   FALL SEMESTER 2015\n\t\t\t\t\t COMP249\n\nDUE:  December 6th, 2015");
		System.out.println("TEAM: CSociety \n\nMEMBERS:\n\tJonny Linton (27388489)\n\tSorina Kong (26652786)\n\tZiad K. Yarbouh(27762585)\n\tSabrina D'Mello(27739486)\n");		
		System.out.println("\n\n\t\t\t\tCellHashUtilization\n");
		System.out.println("*****************************************************************************************\n");

		
		System.out.println("Creating a new Hash Table...");
		CellHash hash = new CellHash();
		
		System.out.println("\nAdding the contents of Cell_Info.txt to the Hash Table..\n");
		hash.addToHashTable();
		System.out.println("\nDisplaying contents of each List inside the Hash Table: ");
		hash.displayHashContents();
		System.out.println("\n\n");
		
		
		//Hash Tables are a efficient way to search for data, because it maps objects to a key.
		//In this case: We first compute a hash value for the serial number, it could fall
		//anywhere between 0-11.
		//When finding an object the program determines the hash code/value and then will search
		//the linked list at to matching array slot in the hash table for the object.
		//In our case: Once the hash value is found it searches that array for that hash value
		//to find the serial number we are searching for.
		//This is more efficient than the way we used to search for the Serial number in 
		//CellListUlitization because we are not going down the entire array just to 
		//find one serial number.
		
		Scanner kb = new Scanner(System.in);
		boolean go = true;
		do
		{
			System.out.println("\nPlease enter a Serial Number to search for (or enter 0 to quit): ");
			int sn = kb.nextInt();
			if(sn == 0)
				{
					go = false;
					System.out.println("Quitting Program...");
				}
			else
				hash.findCell(sn);
		}while(go);
		
		
		kb.close();
		System.exit(0);
	}

}
