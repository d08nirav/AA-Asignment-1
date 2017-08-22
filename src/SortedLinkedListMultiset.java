import java.io.PrintStream;

public class SortedLinkedListMultiset<T> extends Multiset<T>
{
    /*  
        Will return the exact matching node when found
        Will return node with lower value if exact not found
        Will return empty node when no exect node or node lower then item value is found    
    */
    private Node find (T item){
        Node Temp = Head;
        for(;Temp != null;Temp = Temp.prv){
            int n = compare(item, (T)Temp.data);
                if (n<=0){
                    return Temp;
                }
        }
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
    // The structure of the sorted Linked List
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
    /*  Will return -1 when data in list is less then item
        Will return  0 when data in list is equal to item
        Will return  1 when data in list is greater then item   */
    private int compare(T item, T data){
        char[] itemC = ((item.toString()).toCharArray());
        char[] dataC = ((data.toString()).toCharArray());
        int min = (itemC.length<dataC.length)?itemC.length:dataC.length;
        for (int i = 0;i<min;i++){
            //it shows that the item is smaller then data
            if(itemC[i]<dataC[i])
                return 1;
            //it show that the item is larger then data
            else if (itemC[i]>dataC[i])
                return -1;
        }
        //if they are equal
        if (itemC.length==dataC.length)
            return 0;
        //if the item is shorter than data in length
        else if (itemC.length<dataC.length)
            return 1;
        //if the item is longer than data in length
        else
            return -1;
    }
    
    Node Head,First;
    Integer Length;
    public SortedLinkedListMultiset() {
        Head = null;
        First = null;
    } // end of SortedLinkedListMultiset()

    public void add(T item) {
        //if the Linklist is empty
        if (Head==null){
            Head = new Node(item, null, null);
            First = Head;
        }
        // If the Linklist already consist of item
        else {
            Node Temp = find(item);
            //when all the data in linedklist is larger then the input item  //ie inserting at the very begining
            if (Temp.data == null){
                Temp = new Node(item, First, null);
                    First.prv = Temp;
                    First = Temp;
            }
            // if the exact item already exist in the data
            else if (Temp.data.equals(item))
                Temp.qnty++;
            else {
                // if a data item in linkedlist is smaller than the input item.
                    Node T = new Node(item, Temp.nxt, Temp);                                           
                     //when the last item in linkedlidt is not less than the input value
                    if (Temp != Head)
                        Temp.nxt.prv = T;
                    //when the last item in linkedlidt is less than the input value
                    else 
                        Head = T;
                    Temp.nxt = T;
            }
        }
    } // end of add()

    public int search(T item) {	
            Node Temp = find(item);
            int count =0;
            if (Temp.data !=null)
                if ((Temp.data).equals(item))
                    count = Temp.qnty;
            return count;
    } // end of add()

    public void removeOne(T item) {
            Node Temp = find(item);
            if (Temp.data !=null)
                if ((Temp.data).equals(item)){
                    if (Temp.qnty == 0)
                        delete(Temp);
                    else
                        Temp.qnty--;
                }
    } // end of removeOne()

    public void removeAll(T item) {
            Node Temp = find(item);
            if (Temp.data !=null)
                if ((Temp.data).equals(item))
                    delete(Temp);
    } // end of removeAll()

    public void print(PrintStream out) {
        for(Node Temp = Head;Temp != null;Temp = Temp.prv)                
                    out.println(Temp.data+""+printDelim+""+Temp.qnty);
    } // end of print()
	
} // end of class SortedLinkedListMultiset