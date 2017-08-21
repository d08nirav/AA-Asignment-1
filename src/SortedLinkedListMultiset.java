import java.io.PrintStream;

public class SortedLinkedListMultiset<T> extends Multiset<T>
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
        // When deleting anyother node in the linkedlist
        else{
            Temp.prv.nxt = Temp.nxt;
            Temp.nxt.prv = Temp.prv;
        }
    }
    
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
        // If the Linklist already consist of data
        else {
            Node Temp = Head;        
            for(;Temp != null;Temp = Temp.prv) {
                System.out.println("in for");
                int val =compare (item, (T)Temp.data);
                // if a data item in linkedlist is smaller than or equal to the input item.
                if (val<=0){
                    Node T = new Node(item, Temp.nxt, Temp);                                           
                    //when the last item in linkedlidt is not less than the input value
                    if (Temp != Head)
                        Temp.nxt.prv = T;
                    //when the last item in linkedlidt is less than the input value
                    else 
                        Head = T;
                    Temp.nxt = T;
                    return;
                }
            }
            //when all the data in linedklist is larger then the input item  //ie inserting at the very begining
            Node T = new Node(item, First, null);
            First.prv = T;
            First = T;
        }
        System.out.println("Add completed");
    } // end of add()

    public int search(T item) {	
            Node Temp = Head;
            int count = 0;
            for(int val = 0;Temp != null && val>=0;Temp = Temp.prv, val = compare(item, (T)Temp.data))                 
                if (val==0)
                    count++;     
            //System.out.println(count);
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
            for(;Temp != null;Temp = Temp.prv){
                if (Temp.data.equals(item))
                    delete (Temp);                    
            }
    } // end of removeAll()

    public void print(PrintStream out) {
        Node Temp = Head;            ;            
            for(int count = 0;Temp != null;Temp = Temp.prv){
                try {
                    if (((T)Temp.data).equals((T)Temp.prv.data))
                        count++;                
                    else {
                        out.println(Temp.data+""+printDelim+""+(count+1));
                        count =0;
                    }
                }   
                //when scanning the first element// It will throw error as the previous of first is null
                catch (NullPointerException e)
                {
                    out.println(Temp.data+""+printDelim+""+(count+1));
                }
            }
    } // end of print()
	
} // end of class SortedLinkedListMultiset