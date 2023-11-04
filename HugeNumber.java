
/**
 * Question3HugeNumber.java
 *
 * This program implements a class that can store extremely large
 * numbers by storing each digit as a node in a linked list. It
 * also has a deep copy constructor.  As extra credit, an
 * an ADD method that adds an input HugeNumber to the instance's
 * HugeNumber value and returns a new HugeNumber that is set
 * to the sum of the two values may be implemented
 *
 * Created: Sun Apr 3 2005
 * Modified Fri Aug 4 2006  Amy Hickey
 *
 * @author Kenrick Mock
 * @version 1
 */

class HugeNumber
{
	/**
	* Inner class to store a digit within a node
	*/
	private class DigitNode
	{
		private int digit=0;			// Value for this digit
		private DigitNode next=null;		// Reference to next digit
		private DigitNode prev=null;		// Reference to previous digit
		/**
		* DigitNode constructor, initializes number
		*/
		DigitNode(int d)
		{
			this.digit = d;
		}
		/* Accessor and mutator methods */
		public int getDigit()
		{
			return digit;
		}
		public void setDigit(int d)
		{
			digit = d;
		}
		public DigitNode getNext()
		{
			return next;
		}
		public void setNext(DigitNode nextNode)
		{
			next = nextNode;
		}
		public DigitNode getPrev()
		{
			return prev;
		}
		public void setPrev(DigitNode prevNode)
		{
			prev = prevNode;
		}
	}

	// Variable declarations
	private DigitNode head = null;	// Head points to the most significant digit in the list
	private DigitNode tail = null;	// Tail points to the least significant digit in the list

	/**
	* Constructors
	*/
	public HugeNumber()
	{
		//head and tail are already set to null.  No othe code needed for constructor
	}

	/**
	* Deep copy constructor
	* @param newVal Input HugeNumber to copy to this HugeNumber
	*/
	public HugeNumber(HugeNumber newVal)
	{
		// Traverse the input HugeNumber, copying each node to a new list
		DigitNode current = newVal.head;
		DigitNode temp;  // Copy of current node
		DigitNode prev;  // Previous node for the copy so we can set up the double link

	   //complete this method
		if(current != null) {
			this.head = new DigitNode(current.getDigit());
			prev = head;

			current = current.getNext();
			while(current != null) {
				temp = new DigitNode(current.getDigit());
				prev.setNext(temp);
				temp.setPrev(prev);
				prev = temp;
				current = current.getNext();
			}
			this.tail = prev;
		}
	}

	/**
	* Adds a input HugeNumber to this HugeNumber.  It traverses the linked lists,
	* adding each digit starting from the least significant digit and working
	* up to the most significant digit.
	*
	* @param otherNum target HugeNumber to add
	* @return HugeNumber HugeNumber that represents the sum of the two HugeNumbers
	*/
	public HugeNumber add(HugeNumber otherNum)
	{	
		HugeNumber newNum = new HugeNumber();	// Create new number
		 
		//complete this method

		DigitNode pos = newNum.tail;
		DigitNode pos2 = otherNum.tail;

		int val = 1;

		while(pos != null && pos2 != null) {
			int sum = pos.getDigit() + pos2.getDigit() + val;
			if(sum < 10) {
				pos.setDigit(sum);
				val = 0;
			} else {
				pos.setDigit(sum % 10);
				val = 1;
			}
			pos = pos.getPrev();
			pos2 = pos2.getPrev();
		}

		if(pos == null && pos2 != null) {
			while(pos2 != null) {
				int sum = pos2.getDigit() + val;
				if(sum < 10) {
					val = 0;
				} else {
					sum = sum % 10;
					val = 1;
				}
				newNum.addDigit(sum);
				pos2 = pos2.getPrev();
			}
		}

		if(val > 0) {
			newNum.addDigit(val);
		}
		
		return newNum;
	}

	/**
	* addDigit adds a new digit, d, as a new most significant
	* digit for the list.
	* @param d new digit to add as the MSD
	*/
	public void addDigit(int d)
	{
		//complete this method
		DigitNode newD = new DigitNode(d);

		if(tail == null) {
			head = newD;
			tail = newD;
		} else {
			newD.setNext(head);
			head.setPrev(newD);
			head = newD;
		}
	}

	/**
	* Resets the HugeNumber to a null, empty value
	*/
	public void resetValue()
	{
		//complete this method
		head = null;
		tail = null;
	}

	/**
	* @return String The HugeNumber converted to a string
	*/
	public String toString()
	{
		String strVal = "";
		//complete this method
		DigitNode pos = this.head;

		while(pos != null) {
			strVal += pos.getDigit();
			pos = pos.getNext();
		}

		return strVal;

	}
}

