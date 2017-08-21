import java.io.PrintStream;

public class LinkedListMultiset<T> extends Multiset<T>
{
    /*  
        Will return the exact matching node when found
        Will return empty node when no exect node is found    
    */
    private Node find (T item){
        Node Temp = Head;
        for(;Temp != null;Temp = Temp.prv)
                if (Temp.data.equals(item))
                    return Temp;
        return new Node(null, null, null);
    }
    /*
        will delete a perticular Node in a safe way if found in the list
    */
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
        // When deleting anyother node in the linkedlist
        else{
            Temp.prv.nxt = Temp.nxt;
            Temp.nxt.prv = Temp.prv;
        }
    }
    //The structure of the linkedlist
    private static class Node<T>{
        protected T data;
        protected int qnty;
        protected Node<T> nxt;
        protected Node<T> prv;
        
        protected Node (T data, Node<T> nxt, Node<T> prv)
        {
            qnty =1;
            this.data = data;
            this.nxt = nxt;
            this.prv = prv;
        }
    }
    Node Head;
	public LinkedListMultiset() {
            Head = null;
	} // end of LinkedListMultiset()
	        
	public void add(T item) {
            // when there are no elements in Linklist ie when head is null.
            if (Head==null)
                Head = new Node(item, null, null);
            // If the Linklist already consist of data
            else {
                Node T = find(item);
                if (T.data!=null)
                    T.qnty++;
                else {
                    Node Temp = new Node(item, null, Head);
                    Head.nxt = Temp;
                    Head = Temp;
                }
            }
	} // end of add()
		
	public int search(T item) {
            Node Temp = find(item);
            int count =0;
            if (Temp.data != null)
                count = Temp.qnty;
            return count;
	} // end of add()
		
	public void removeOne(T item) {
            Node Temp = find(item);
            if (Temp.data != null){
                if (Temp.qnty == 0)
                    delete(Temp);
                else
                    Temp.qnty--;
            }
	} // end of removeOne()
		
	public void removeAll(T item) {
            Node Temp = find(item);
            if (Temp.data != null)                
                delete(Temp);
	} // end of removeAll()	
	
	public void print(PrintStream out) {            
            for(Node Temp = Head;Temp != null;Temp = Temp.prv)                
                    out.println(Temp.data+""+printDelim+""+Temp.qnty);
	} // end of print()
	
} // end of class LinkedListMultiset