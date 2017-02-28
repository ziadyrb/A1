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
 *
 *The CellHash class has creates an array of CellList and initializes it to 12.
 *This will compute the hash value, add and displays contents in the hash table.
 *As well as find the serial number of a CellPhone.
 *
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CellHash {

	private CellList[] hashArr = new CellList[12];
	
	
	//Default constructor
	
	public CellHash()
	{
		for(int i=0; i<hashArr.length; i++)
		{
			hashArr[i] = new CellList();
		}
	}
	
	
	//Returns the Hash Value of a given Serial Number
	
	public int computeHashValue(long serialNum)
	{
		return ((int) serialNum%11);
	}
	
	
	//Reads the contents of the Cell_Info.txt, calculates the hash value based on the serial number, 
	//then inserts a CellNode object at the calculated Hash Value index. In addition, it also searches
	//for duplicates, displays which items are duplicates, then deletes them. The final result is an
	//array of CellList with no duplicate entries.
	
	public void addToHashTable()
	{
		Scanner sc = null;
		
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
		
		CellList cList = new CellList();
		
		
		//Initializing the information from the file into CellPhone objects, and storing them in the CellList
		
		while(sc.hasNext())
		{
			cList.addToStart(new CellPhone(sc.nextLong(), sc.next(), sc.nextDouble(), sc.nextInt()));
		}
		
		CellPhone dupDetector = new CellPhone(-1, "-1", -1, -1);
		
		//Deleting Duplicates
		
		int i=0; 
		int index;
		System.out.println("Finding duplicates...");
		for(int j=0; j<cList.getSize(); j++)
		{
			if(cList.elementAt(j).equals(dupDetector))
				{
					i++;
					System.out.println("Using deleteFromIndex() ....");
					cList.deleteFromIndex(j);
					j = j-1;
				}
			else
			{
				index = computeHashValue(cList.elementAt(j).getSerialNumber());
			
				hashArr[index].addToStart(cList.elementAt(j));
			}	
		}
		System.out.println("\nNumber of duplicates: " +i +"\n\n");
		
		sc.close();
	}
	
	
	//displays the contents of the array; that is the contents of each of the lists in the array
	
	public void displayHashContents()
	{
		for(int k=0; k<12; k++)
		{
				System.out.println("\n\n\nList at index of " +k +" has the following information: ");
				hashArr[k].showContent();
		}
	}
	
	
	//Accepts a Serial Number as a parameter, and finds out if there is a CellPhone with this Serial
	//Number in the Hash Array. Also displays the number of searches conducted.
	
	public boolean findCell(long serialNum)
	{
		int index = computeHashValue(serialNum);
		
		if(hashArr[index].find(serialNum) == null)
			return false;
		else
			return true;
	}

}
