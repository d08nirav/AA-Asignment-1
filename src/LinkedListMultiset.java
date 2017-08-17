import java.io.PrintStream;

public class LinkedListMultiset<T> extends Multiset<T>
{

    private void delete(Node Temp) {        
        // When the node to be deleted is the last node
        if (Temp == Head){
            // When there is only one node
            if(Temp.prv == null)
                Head = null;
            else{
                Head = Temp.prv;
                Temp.prv.nxt = null;            
            }
        }
        //When the node to be deleted is the first node.
        else if (Temp.prv == null)
            Temp.nxt.prv =null;
        else{
            Temp.prv.nxt = Temp.nxt;
            Temp.nxt.prv = Temp.prv;
        }
    }
    //The structure of the linkedlist
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
    private int Length;
	public LinkedListMultiset() {
            Head = null;
            Length = 0;
	} // end of LinkedListMultiset()
	        
	public void add(T item) {
            // when there are no elements in Linklist ie when head is null.
            if (Head==null)
                Head = new Node(item, null, null);
            // If the Linklist already consist of data
            else {
                Node Temp = new Node(item, null, Head);
                Head.nxt = Temp;
                Head = Temp;
            }
	} // end of add()
		
	public int search(T item) {
            Node Temp = Head;
            int count = 0;
            for(;Temp != null;Temp = Temp.prv)
                if (Temp.data.equals(item))
                    count++;
		return count;
	} // end of add()
		
	public void removeOne(T item) {
            Node Temp = Head;
            for(;Temp != null;Temp = Temp.prv){
                if (Temp.data.equals(item)){
                    delete (Temp);
                    break;  //To delete only once.
                }                    
            }
	} // end of removeOne()
		
	public void removeAll(T item) {
            Node Temp = Head;
            for(;Temp != null;Temp = Temp.prv)
                if (Temp.data.equals(item))
                    delete (Temp);
	} // end of removeAll()	
	
	public void print(PrintStream out) {
            Node Temp = Head;
            //T[] aryTs = new T[10];
            
            for(;Temp != null;Temp = Temp.prv){
                //put in array
                out.println(Temp.data+""+printDelim+""+search((T)Temp.data));
            }
	} // end of print()
	
} // end of class LinkedListMultiset