package day1;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class Collection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	// Create a set called mySet 
		Set<String> mySet = new HashSet<String>();     
	// Ensure that this set contains an interesting selection of fruit   
	   String fruit1 = "pear", fruit2 = "banana", fruit3 = "tangerine",      
       fruit4 = "strawberry", fruit5 = "blackberry"; 
	   mySet.add( fruit1 ); mySet.add( fruit2 ); mySet.add( fruit3 );
	   mySet.add( fruit2 ); mySet.add( fruit4 ); mySet.add( fruit5 );      
       // Display contents of mySet    
       System.out.println( "mySet now contains:" );   
       System.out.println( mySet );
       
     // > display the cardinality of (i.e. the number of elements in) mySet; 
       System.out.println( mySet.size() );
     // > remove the blackberry and strawberry; display contents of mySet again to confirm success;
      mySet.remove(fruit4);mySet.remove(fruit5);
       System.out.println("New set:"+ mySet );
     // > remove the remaining fruit using a single method invocation;
       mySet.removeAll(mySet);
     // > show that the set is now empty by using the isEmpty() method
       System.out.println( mySet.isEmpty()==true );
      
       //2
       
      List<String> list=new ArrayList<String>(); 
      list.add(fruit1);
      list.add(fruit2);
      list.add(fruit3);
      list.add(fruit4);
      list.add(fruit5);
      
      Iterator iter=list.iterator();
      
      System.out.print("Ordered Listing:");
      while(iter.hasNext())
      System.out.print(iter.next()+"\t");
      
      ListIterator<String> iter1=list.listIterator(list.size());
      System.out.print("\nReverse Ordered Listing:");
      while(iter1.hasPrevious())
          System.out.print(iter1.previous()+"\t");
      
      list.add(3,fruit2);
      ListIterator<String> iter2=list.listIterator(list.size());
      System.out.print("\nReverse Ordered Listing Again:");
      while(iter2.hasPrevious())
          System.out.print(iter2.previous()+"\t");
       
	}

}
