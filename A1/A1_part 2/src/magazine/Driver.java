/*Assignment 1
 *Part 2
 *Written by:
 *Jonny Linton (27388489)
 *Sorina Kong (26652786)
 *Ziad Yarbouh(27762585)
 *Sabrina D'Mello(27739486)
 *For this program we modified the equals() method from our part 1 program.
 *This equals method checks that the objects passed is null or not and if the objects
 *are the same types.  */

package magazine;

import paperpublication.PaperPublication;
import book.Book;
import journal.Journal;
import magazine.Magazine;
import book.ChildrenBook;
import book.EducationalBook;

public class Driver {

	public static void main(String[] args) {
		
		//Introduction:
		System.out.println("*******************************************************");	
		System.out.println("\t\t\t Assignment #1 \n\t\t\t     Part 1");
		System.out.println("\t\t\tFALL SEMESTER 2015\n\t\t\t     COMP249\nDUE:  October 5th, 2015");
		System.out.println("TEAM: CSociety \n\nMEMBERS:\n\tJonny Linton (27388489)\n\tSorina Kong (26652786)\n\tZiad K. Yarbouh(27762585)\n\tSabrina D'Mello(27739486)\n");		
		System.out.println("*******************************************************");
		System.out.println("BEGINING OF PROGRAM . . .");

		//Creating objects from all 6 classes, using both the default and parameterized constructors.
		PaperPublication p1 = new PaperPublication();
		PaperPublication p2 = new PaperPublication(28.99, 288);
		PaperPublication p3 = new PaperPublication(28.99, 288); //copy
		Book b1 = new Book();
		Book b2 = new Book(382938293, "I Speak To Dogs", "Ima Kaynein",2014, 99.99, 475);
		Magazine m1 = new Magazine();
		Magazine m2 = new Magazine(Magazine.paperQuality.HIGH, Magazine.issuingFrequency.YEARLY, 14.28, 35);
		Magazine m3 = new Magazine();
		Journal j1 = new Journal();
		Journal j2 = new Journal(5, "Photography", 299.01, 1000);
		Journal j3 = new Journal(); //copy
		ChildrenBook cb1 = new ChildrenBook();
		ChildrenBook cb2 = new ChildrenBook(5, 123456789, "Lil' Piggy", "George Smith", 2000, 10.99, 15);
		ChildrenBook cb3 = new ChildrenBook(5, 123456789, "Lil' Piggy", "George Smith", 2000, 10.99, 15); //copy
		EducationalBook eb1 = new EducationalBook();
		EducationalBook eb2 = new EducationalBook(4, "Biology", 483957362, "Fundamentals of Biology", "Ezra Watts", 1977, 90.99, 874);
		
		//Displaying all of the newly created objects information to the user using the toString method.
		System.out.println(p1 +"\n");
		System.out.println(p2 +"\n");
		System.out.println(p3 +"\n");

		System.out.println(b1 +"\n");
		System.out.println(b2 +"\n"); 

		System.out.println(j1 +"\n");
		System.out.println(j2 +"\n");
		System.out.println(j3 +"\n");

		System.out.println(m1 +"\n");
		System.out.println(m2 +"\n");
		System.out.println(m3 +"\n");


		System.out.println(cb1 +"\n");
		System.out.println(cb2 +"\n");
		System.out.println(cb3 +"\n");

		System.out.println(eb1 +"\n");
		System.out.println(eb2 +"\n");

		// Using equals() method to test the equality of different objects -- assuming equals method returns boolean
		System.out.println("\nIs Paper Publication #1 is the same as Paper Publication #2? " +p1.equals(p2));
		System.out.println("\n\nIs Paper Publication #2 is the same as Paper Publication #2? " +p2.equals(p3));
		System.out.println("\n\nIs Paper Publication #2 is the same as Book #1? " +p2.equals(b1));
		System.out.println("\n\nIs Journal #2 is the same as Journal #3? " +j2.equals(j3));
		System.out.println("\n\nIs Journal #1 is the same as Journal #3? " +j1.equals(j3));
		System.out.println("\n\nIs Children's Book #2 is the same as Children's Book #3? " +cb2.equals(cb3));
		System.out.println("\n\nIs Children's Book #1 is the same as Children's Book #2? " +cb1.equals(cb2));
		System.out.println("\n\nIs Magazine #1 is the same as Magazine #2? " +m1.equals(m2));
		System.out.println("\n\nIs Magazine #1 is the same as Magazine #3? " +m1.equals(m3));

		

		//Creating an array of 10 Paper Publication objects
		System.out.println("\n\nCreating an array of Paper Publication objects...\n\n");
		PaperPublication[] paperPubArr = new PaperPublication[10];
		paperPubArr[0] = cb1;
		paperPubArr[1] = p2;
		paperPubArr[2] = b1;
		paperPubArr[3] = j3;
		paperPubArr[4] = eb1;
		paperPubArr[5] = m2;
		paperPubArr[6] = cb3;
		paperPubArr[7] = eb2;
		paperPubArr[8] = j1;
		paperPubArr[9] = p3;


		//Searching array to find the cheapest Paper Publication.
		int lowestIndex = 0;
		for(int i=0; i < (paperPubArr.length - 1); i++)
		{
			if(paperPubArr[lowestIndex].getPrice() > paperPubArr[i+1].getPrice())
				lowestIndex = i+1;
		}

		//Displaying the lowest priced object to the user.
		System.out.println("The Paper Publication object in the array with the lowest price is at index " +lowestIndex +". And it's information is as follows: \n\n" +paperPubArr[lowestIndex]);

		//Search to see if multiple different objects share the lowest price.
		for(int i=0; i < paperPubArr.length; i++)
		{
			if((paperPubArr[lowestIndex].getPrice() == paperPubArr[i].getPrice()) && (lowestIndex != i))
			{
				System.out.println("\nThe object of Index " +i +" has the same price as the cheapest Paper Publication object in the array! \nThe information of this object is as follows: \n\n" +paperPubArr[i]);
			}
		}

		//Concluding:
		System.out.println("\n\n*******************************************************");
		System.out.println("The program is done. Thank you for using.");
		System.out.println("*******************************************************");
	
	}	
	
	
}
