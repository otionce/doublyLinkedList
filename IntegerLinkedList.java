//Completed by Otniel Ionce as part of CSC115 @UVic September 2016
//Skeleton code given by J. Corless

public class IntegerLinkedList implements IntegerList
{
	private IntegerNode	head;
	private IntegerNode	tail;

	private	int		count;

	public IntegerLinkedList()
	{
		head = null;
		tail = null;
		count = 0;
	}

	/*
	 * PURPOSE:
	 *   Add the element x to the front of the list.
	 *
	 * PRECONDITIONS:
	 *   None.
	 * 
	 * Examples:
	 * 
	 * If l is {1,2,3} and l.addFront(9) returns, then l is {9,1,2,3}.
	 * If l is {} and l.addFront(3) returns, then l is {3}.
	 */
	public void addFront (int x)
	{
		IntegerNode p = new IntegerNode(x);
		if(head==null) { //If list is empty...
			head = p;
			tail = p;
		} else { //List is not empty
			p.next = head;
			head.prev = p;
			head = p;
		}
		count++;
	}


	/*
	 * PURPOSE:
	 *   Add the element x to the back of the list.
	 *
	 * PRECONDITIONS:
	 *   None.
	 * 
	 * Examples:
	 * 
	 * If l is {1,2,3} and l.addBack(9) returns, then l is {1,2,3,9}.
	 * If l is {} and l.addBack(9) returns, then l is {9}.
	 */	
	public void addBack (int x)
	{
		IntegerNode p = new IntegerNode(x);
		if(head == null) { //If list is empty
			head = p;
			tail = p;
		} else { // List is not empty
			p.prev = tail;
			tail.next = p;
			tail = p;
		}
		count++;
	}

	/*
	 * PURPOSE:
	 *	Return the number of elements in the list
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {7,13,22} l.size() returns 3
	 *	If l is {} l.size() returns 0
	 */
	public int size()
	{
		return count;
	}
	
	/* 
	 * PURPOSE:
	 *   Return the element at position pos in the list.
	 * 
	 * PRECONDITIONS:
	 *	pos >= 0 and pos < l.size()
	 * 
	 * Examples:
	 *	If l is {67,12,13} then l.get(0) returns 67
	 *	If l is	{67,12,13} then l.get(2) returns 13
	 *	If l is {92} then the result of l.get(2) is undefined.
	 *
	 */
	public int  get (int pos)
	{
		IntegerNode p = head;
		if(pos>=count || pos<0)
			return -1;
		for(int i = 0;i<pos;i++) {
			p=p.next;
		}
		return p.value;

	}
	
	/* 
	 * PURPOSE:
	 *   Remove all elements from the list.  After calling this
	 *   method on a list l, l.size() will return 0
	 * 
	 * PRECONDITIONS:
	 *	None.
	 * 
	 * Examples:
	 *	If l is {67,12,13} then after l.clear(), l is {}
	 *	If l is {} then after l.clear(), l is {}
	 *
	 */
	public void clear()
	{
		head = null;
		count = 0;
		tail=null;
	}

	/* 
	 * PURPOSE:
	 *   Remove all instances of value from the list. 
	 * 
	 * PRECONDITIONS:
	 *	None.
	 * 
	 * Examples:
	 *	If l is {67,12,13,12} then after l.remove(12), l is {67,13}
	 *	If l is {1,2,3} then after l.remove(2), l is {1,3}
	 *	If l is {1,2,3} then after l.remove(99), l is {1,2,3}
	 */
	public void remove (int value)
	{
		IntegerNode p = head;
		if(p==null)
			return; 
		for(int i=0;i<count;i++){
	
			if(p.value == value){
				//remove p
				if(count == 1) {
					clear();
					break;
				} else if(p == head){//if p is head
					head = p.next;
					head.prev = null;
				} else if (p == tail) { // if p is tail
					tail = p.prev;
					tail.next = null;
				} else { // where p is neither tail nor head
					p.prev.next = p.next;
					p.next.prev = p.prev;
				}
				count--;
				i--;
			}
			p=p.next;
		}
	}

	/*
	 * PURPOSE:
	 *	Return a string representation of the list
	 * 
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {1,2,3,4} then l.toString() returns "{1,2,3,4}"
	 *	If l is {} then l.toString() returns "{}"
	 *
	 */
	public String toString()
	{
		StringBuilder x = new StringBuilder("{");
		IntegerNode p = head;
		while(p!=null) {
			x.append(p.value);
			if(p.next!=null)
				x.append(',');
			p = p.next;
		}
		x.append("}");
		return x.toString();
	}
}
