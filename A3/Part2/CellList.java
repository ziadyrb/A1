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
 *The CellList class has an inner and outer class. Using single-linked list we
 *made methods to add, delete, replaces and finds CellPhone Objects. It will 
 *also display the contents in the arrayList. Finally, there is an equals and 
 *clone method.
 *
 */


import java.util.NoSuchElementException;



//OUTER CLASS

public class CellList {
	
	//INNER CLASS
	
	private class CellNode{
		
		//Attributes
		
		private CellPhone celPhn = new CellPhone();
		private CellNode next;

		//Default Constructor
		
		private CellNode()
		{
			celPhn = null;
			next = null;
		} 
		
		//Parameterized Constructor
		//This method may result in a privacy leak! The celPhn attribute is set equal to a
		//pointer to another CellPhone object. Once an object is created with this constructor,
		//the CellPhone used to created could then be destroyed, consequently destroying the
		//CellNode as well. An alternative to this would be to override the clone method in the 
		//CellPhone class, and use it to initialize the celPhn parameter.
		
		private CellNode(CellPhone cell)
		{
			celPhn = cell;
			next = null;
		}
		
		//Parameterized Constructor
		//This method may result in a privacy leak! The celPhn attribute is set equal to a
		//pointer to another CellPhone object. Once an object is created with this constructor,
		//the CellPhone used to created could then be destroyed, consequently destroying the
		//CellNode as well. An alternative to this would be to override the clone method in the 
		//CellPhone class, and use it to initialize the celPhn parameter.
		
		private CellNode(CellPhone cPhn, CellNode xtNode)
		{
			celPhn = cPhn;
			next = xtNode;
		}

		// Accessors and Mutators
		
		//This method may result in a privacy leak! The CellPhone used as a parameter in this
		//method could be destroyed after the implementation of this method, consequently 
		//destroying the CellPhone within the CellNode as well. An alternative to this would be
		//to override the clone method in the CellPhone class, and use it to initialize the celPhn parameter.
		
		private void setCellPhone(CellPhone cp)
		{
			celPhn = cp;
		}

		//This method may result in a privacy leak! Because we are returning a pointer to the
		//celPhn attribute directly, which could then be used to destroy the CellPhone and
		//the CellNode object that contains it. A safe alternative would be to override the 
		//clone method in the CellPhone class, and use it to return a clone of the CellPhone instead.
		
		private CellPhone getCellPhone()
		{
			return celPhn;  
		}

		private void setNext(CellNode cNodeNext)
		{
			next = cNodeNext;
		}

		private CellNode getNext()
		{
			return next;
		}
		
		//Copy Constructor 
		//This method may result in a privacy leak! The CellNode used as a parameter in this
		//method could be destroyed after creating a CellNode object with it, resulting in
		//the destruction of the created CellNode as well. To fix this, we could override the 
		//clone method in the CellPhone class, and use it to return a clone of the CellPhone instead.
		
		private CellNode(CellNode cN)
		{
			celPhn = cN.celPhn;
			next = cN.next;
		}

		//Clone Method 
		//Similar privacy issues to the copy constructor. Fixing issues in that method would
		//fix the potential problems in this method.
		
		protected CellNode clone()
		{
			return new CellNode(this);
		}
	
	} //End of CellNode Class

	
	//CellList Class:
	
	
	//Attributes
	
	private CellNode head;
	int size;

	
	//Default Constructor
	
	public CellList()
	{
		head = null;
		size = 0;
	}

	
	//Copy constructor
	
	public CellList(CellList cList)
	{
		if (cList == null) 
			throw new NullPointerException();

		else
		{
			head = null;

			// Now create and copy all the nodes in the list
			
			CellNode temp, temp2, temp3;
			temp = cList.head;
			temp2 = null;
			temp3 = null;
			this.size = cList.getSize();
			
			while(temp != null)
			{
				if (temp2 == null)
				{
					temp2 = new CellNode (temp.getCellPhone(), null);
					head = temp2;
				}
				else 
				{
					temp3 = new CellNode(temp.getCellPhone(), null);
					temp2.setNext(temp3);
					temp2 = temp3;
				}
				temp = temp.next;
			}
			
			// Avoiding privacy leak; set all temporary pointers to null 
			
			temp = temp2 = temp3 = null;
		}
	}
	
	
	//Accessor for size
	
	public int getSize()
	{
		return size;
	}
	
	
	//Accepts a CellPhone object as a parameter, and inserts this object in a node at the head of the CellList.
	
	public void addToStart(CellPhone cPhn)
	{
		head = new CellNode(cPhn, head);
		size++;
	}

	
	//Accepts 2 parameters, a CellPhone ojbect, and an index. Checks if index is valid. 
	//Inserts a new node containing the CellPhone at the given index.
	
	public void insertAtIndex(int index, CellPhone cPhn)
	{

		if (index > size -1)
		{
			System.out.println("\nGiven index is out of range !"); 
			throw new NoSuchElementException();
		}

		System.out.println("\n\nInsert new Cell Phone: [" + cPhn + "] at index #" + index + "." );
		int i = 0;
		CellNode temp = head;
		if ( index == 0)
		{
			CellNode newCNode = new CellNode (cPhn, head);
			newCNode.next = head.next;
			head = newCNode;
		}
		else
		{
			while (i < index - 1)
			{
				temp = temp.next;
				i++;
			}
			CellNode newCNode = new CellNode(cPhn);
			newCNode.next = temp.next;
			temp.next = newCNode;
		}
		size++;
	}
	
	
	//Accepts an index as a parameter, and checks to see if it is valid.
	//Then 'deletes' the node at the given index
	
	public void deleteFromIndex(int index)
	{
		if(index > size-1){
			System.out.println("\n\nThe index given is out of range. \nThis program will now terminate.");
			throw new NoSuchElementException();
		}
		int i=0;
		CellNode temp = head;

		//If only 1 node exists..
		if (size == 1){
			System.out.println("\n\nRemoving node from the list at the index " + 0 + ".");
			head = null ;
			size --;
		}
		//If at the head node...
		if(index == 0){
			System.out.println("\n\nDeleting node with CellPhone: [" + head.celPhn + "] from index #" + index + ".");
			head = head.next;
			size--;
		}
		//For everything else
		else {
			while (i != index -1)	// Stop at the node that precedes index
			{
				temp = temp.next;
				i++;
			}
			//Now that the pointer is pointing at the node we want to delete.
			System.out.println("\n\nDeleting node with CellPhone: [" + temp.next.celPhn + "] from index #" + index + ".");
			temp.next = temp.next.next;
			size--; //Restoring the size because we deleted one.
		}

	}
	
	
	//Accepts 2 parameters, a CellPhone object, and an index. If index is valid, it will 
	//replace the CellPhone object in the node at the given index.
	
	public void replaceItemAt(CellPhone cp, int index)
	{
		if (index > size -1)
		{
			System.out.println("\nERROR: Given index is out of range! Program will terminate. \n");
			throw new NoSuchElementException();
		}
		int i = 0;
		CellNode temp = head;
		while(i != index)
		{
			temp = temp.next;
			i++;
		}
		System.out.println("\nReplacing value at index # " + index + "\nFrom: " + temp.celPhn + "\nTo: " + cp + ". \n");
		temp.celPhn = cp;
	}

	
	//Deletes the head of the calling CellList
	
	public boolean deleteFromStart(){
		if (head != null)
		{
			head = head.next;
			System.out.println("\nThe information in the head node has been deleted.");
			return true;
		}
		else
			return false;

	}

	
	//Accepts a Serial Number as a parameter, and searches for a node with given Serial Number, if such an object is found, 
	//then the method returns a pointer to that node where the object is found; otherwise, the method returns null.
	//Also keeps track how many iterations were made before the search finally returns.
	
	public CellNode find(long serialNum){
		CellNode temp = head;
		int index = 0 ;
		int ctr = 1;
		while (temp != null){
			if(temp.celPhn.getSerialNumber() == serialNum){ 
				System.out.println("\n\nThe Serial Number: " + serialNum + " was found at the index #" + index);
				System.out.println("The number of iterations: " + ctr);
				return temp;
			}
			index++;
			ctr++;
			temp = temp.next; 	//This will move temp to the next node
		}
		System.out.println("\nThere is no value in the list with Serial Number: " + serialNum);
		System.out.println("The number of iterations: " + ctr);
		return null;
	}

	
	//Accepts a Serial Number as a parameter, and returns true if an object with that 
	//serial number is in the list; otherwise, the method returns false
	
	public boolean contain(long serialNum){
		if(find(serialNum) != null)
			return true;
		else 
			return false;
	}

	
	//Displays the contents of the calling CellList
	
	public void showContent()
	{
      if  (this.size == 0)
      {
          System.out.println("List is empty !");
      }
      System.out.println("\nThe current size of the list is : " + size + " Here are the contents of the list ");
      System.out.println("=================================================================================");
      
      CellNode temp = head;     
      while ( temp != null )
      {
          if(temp.next == null)
          	System.out.print("["+ temp.getCellPhone()+ "] ---> X " );
          else
          {
          	System.out.println("["+ temp.getCellPhone() + "] --->" );
          }
          temp = temp.next;
      }
	}
	
	
	//Accepts an object of CellList as a parameter, and returns true if the two similar objects are equal 
	//(all attributes the same except Serial Number); otherwise the method returns false.
	
	public boolean equals(CellList cl)
	{
		if (cl == null)
			return false;
		else if (getClass( ) != cl.getClass( ))
			return false;
		else if (getSize() != cl.getSize())
			return false;

		CellNode temp = head;
		CellNode othertemp = cl.head;
		while (temp != null){
			if (temp.getCellPhone().equals(othertemp.getCellPhone())==false)
				return false;
			temp = temp.next;
			othertemp = othertemp.next;
		}

		return true;
	}

	
	//Accepts a CellPhone object as a parameter, and returns the index of the first occurrence of that object
	
	public int indexOf(CellPhone c) 
  {
      int count = 0;
      CellNode node = null;
      for (node = this.head; node != null; node = node.next, count++)
      {
          if (c.equals(node.getCellPhone()))
              return count;
      }
      return -1;
  }
	
	
	//Accepts an index as a parameter, and returns the CellPhone at that index.
	//If the list is empty or index is invalid it returns null.
	//Duplicates return an invalid CellPhone object (with all parameters set to -1, 
	//and non-duplicates return the CellPhone object
	
	public CellPhone elementAt(int n) 
	{
		CellNode temp = head;
		if(temp == null)
		{
			System.out.println("List is empty!");
			return null;
		}
		if(this.size <= n)
		{
			System.out.println("Given index is out of range!");
			return null;
		}

		while(temp != null)
		{
			if(n == this.indexOf(temp.getCellPhone()))
			{
				return temp.getCellPhone();
			}
			temp = temp.next;
		}
		System.out.println("\n\nDuplicate object at index: " +n);
		return new CellPhone(-1, "-1", -1, -1);
	}
	
	
} //End of CellList

