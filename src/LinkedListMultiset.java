import java.io.PrintStream;
import java.util.*;

public class LinkedListMultiset<T> extends Multiset<T>
{
    //private Integer Head;
    private static class Node<T>
    {
        protected T data;
        protected Node<T> nxt;
        protected Node<T> prv;
        
        protected Node (T data, Node<T> nxt, Node<T> prv)
        {
            this.data = data;
            this.nxt = nxt;
            this.prv = prv;
        }
    }
    Node Head;
	public LinkedListMultiset() {
            Head = null;            
		// Implement me!
	} // end of LinkedListMultiset()
	
	
	public void add(T item) {
            // when there are no elements in Linklist ie when head is null.
            if (Head==null)
                Head = new Node(item, null, null);
            // If the Linklist already consist of data
            else {
                Node Temp = new Node(item, null, Head);
                Head = Temp;
            }
		// Implement me!
	} // end of add()
	
	
	public int search(T item) {
		// Implement me!		
		// default return, please override when you implement this method
		return 0;
	} // end of add()
	
	
	public void removeOne(T item) {
		// Implement me!
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
            Node Temp = Head;
            for(;Temp != null;Temp = Temp.prv){
                out.println(Temp.data+""+printDelim);
            }
            
		// Implement me!
	} // end of print()
	
} // end of class LinkedListMultiset