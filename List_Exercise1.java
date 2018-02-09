/*  Program name: Project 5
    Author: Tony N Theisen
    Date: 05 February 2018
    
    Description: A Inverative demo of what a Singly, Doubly, and Circular list
    can do with user input. 
    
    Input: User Input from the console
    Output: Console output 
    
    Limitation: UNKNOWN
*/

import java.util.*;  // ArrayList, Random
import java.io.*;    // Scanner

public class List_Exercise1 {

   // Instance Variable
   private Scanner         keyboard;   // Source for user Input
   private String          userInput;  
   private int             listSize;
   
   // Constructor
   public List_Exercise1() {
      
      keyboard             = new Scanner (System.in);
      userInput            = "";
      listSize                 = 0;                          // Size of Linked List
         
   } // End Constructor
   
   
   // Top Level Menu for Linked List Options
   public void topLvlMenu() {
   
      System.out.println("This was created by Supereme Leader Tony Theisen");
      
      System.out.println("\nMain Menu, Please select from one of the following options:" 
                         + "\nPress 1 for: \tSingly Linked (Integers)" 
                         + "\nPress 2 for: \tDouble Linked (Doubles)"
                         + "\nPress 3 for: \tSingly Linked (String)"
                         + "\nPress 4 for: \tTo quit and GO TO BED!");
      userInput = keyboard.nextLine();
      
      switch(userInput) {
         case "1":
            singlyLinked();
            break;
         case "2":
            //typeTWO();
            break;
         case "3":
            //typeTHREE();
            break;
         case "4":
            System.exit(0);   // Exit system   
         default:
            System.out.println("\n###Your response was not recongized###");
            topLvlMenu();
      }   
      
   } // End topLvlMenu
 
 
   // Singly Linked List Menu that will determine users next moves  
   public void singlyLinked(){
      System.out.println("Singly Linked");
      
      System.out.println("\n\t\tCreate Singly-Linked List"
                       + "\n\tPress 1 to create a Linked List" 
                       + "\n\tPress n to go back to previous menu");
      userInput = keyboard.nextLine();
      
      switch(userInput) {
         case "1":
            createList();
            break;
         case "n":
            topLvlMenu();
         default: 
            System.out.println("\n###Your response was not recongized###");
            break;
      }
      singlyLinked();   
      
   } // End Singly Linked Method
   
   
   // Create a Link List
   public void createList() {
      System.out.println("create list");
      int someNumber = 0;
      
      LinkedList Linked = new LinkedList();
      
      System.out.println("Welcome to Singly-Linked List"
                         + "\nPick one of the following options"
                         + "\n\tPress 1: Build your own list"
                         + "\n\tPress 2: Clear list"
                         + "\n\tPress 3: Check if the list is sorted"
                         + "\n\tPress 4: Insert at Head"
                         + "\n\tPress 5: Insert at tail"
                         + "\n\tPress 6: Delete by value"
                         + "\n\tPress n to go back to previous menu");
       
      userInput = keyboard.nextLine();
       
      switch(userInput) {
         case "1":
            System.out.println("Provide data. PRESS 0 to quit");
            do {
               System.out.println("What number would you like to input?");
               someNumber = keyboard.nextInt();
               
               //someNumber = Integer.parseInt(userInput);
            
               Linked.insertHead(someNumber);
            } while (someNumber != 0);
            Linked.show();
            break;
         case "2":
            // Clear List
            break;
         case "3":
            // Sorted?
            break;
         case "4":
            // Insert head
            System.out.println("Inserting to the head of the list."
                               + "Would you like to see current list before insert?"
                               + "\n\t PRESS Y or N");
         
            if (keyboard.next().charAt(0) == 'Y') {
               Linked.show();
            }    
         
            System.out.println("Input Number that you would like to put into the head");
            someNumber = keyboard.nextInt();
         
            Linked.insertHead(someNumber);
            Linked.show();
            break;
         case "5":
            // inseart tail
            break;
         case "6":
            // delete value
            break;
         case "n":
            singlyLinked();
         default: 
            System.out.println("\n###Your response was not recongized###");
            break;
      }
      createList();
   
   } // End Create List
   
   
   public static void main(String args[]) {
      
      List_Exercise1 list = new List_Exercise1();
      
      list.topLvlMenu();
   
   
   } // End Main 


// *CLASS LINKED LIST**********************************************************

   public class LinkedList {
   
      Node head;
      Node tail;
      public int size;
      
      // Constructor
      public LinkedList() {
         head = null;
         tail = null;
         size = 0; 
      }
            
      public boolean isEmpty() {       // Check is list is empty
         return head == null;
      }
      
      public int getSize() {           // Get size of list
         return size;
      }
      
      public void insertHead(int value) {    // insert node at head
         Node current = new Node(value, null);
         size++;
         if(head == null) {               // Assign node to head if no head is found
            head = current;
            tail = head;
         } 
         else {
            current.setLink(head);
            head = current;               // Adding to linklist 
         }      
      }
       
      public void insertTail(int value) {   // For type 2 insert at tail
         Node current = new Node(value, null);
         size++;
         if (head == null) {
            head = current;
            tail = head;
         }
         else {
            tail.setLink(current);
            tail = current;
         }   
      } 
       
      public void addAt(int value, int position) {  
         Node current = new Node(value, null);           // Create A
         Node location = head;                           // B becomes Head
         position -= 1;
         for (int i = 1; i < size; i++) {
            if (i == position) {
               Node temp = location.getLink();           // c becomes B (LOCATION)
               location.setLink(current);                // B Location (A)
               current.setLink(temp);                    // A location (C)
               break;
            }
            location = location.getLink();               // B = B Location 
         }
         size++;
      }          
                      
      public void show()                  // Show List
      {
         System.out.print("\nSingly Linked List: ");
         if (size == 0) 
         {
            System.out.print("empty\n");
            return;
         }    
         if (head.getLink() == null) 
         {
            System.out.println(head.getData() );
            return;
         }
         Node current = head;                   // Magic to get this to work
         System.out.print(head.getData()+ " > ");
         current = head.getLink();
         while (current.getLink() != null)
         {
            System.out.print(current.getData()+ " > ");
            current = current.getLink();
         }
         System.out.print(current.getData()+ "\n");
      } 
      
      public void deleteAtPos(int position) {   // Delete based off os user input and value       
         if (position == 1) {
            head = head.getLink();
            size--; 
            return ;
         }
         if (position == size) {
            Node extra = head;
            Node extra1 = head;
            while (extra != tail) {
               extra1 = extra;
               extra = extra.getLink();
            }
            tail = extra1;
            tail.setLink(null);
            size --;
            return;
         }
         Node location = head;
         position-= 1 ;
         for (int i = 1; i < size - 1; i++) {
            if (i == position) {
               Node temp = location.getLink();
               temp = temp.getLink();
               location.setLink(temp);
               break;
            }
            location = location.getLink();
         }
         size-- ;
      }  
      
   } // End Class (LINKED LIST)
   
   
// *CLASS NODE*****************************************************************

   // Creates a node object for use
   public class Node {
   
      Node next;
      int items;
   
      // Constructor
      public Node() {
         items = 0;
         next = null;
      } 
         
      public Node(int value) {
         items = value;
         next = null;
      }
      
      public Node(int value, Node n) {
         items = value;
         next = n;
      }
      
      public void setLink(Node n) {       // Set link to next Node
         next = n;
      }
      
      public void setData(int value) {    // Set value to current link
         items = value;
      }
      
      public Node getLink() {             // Get link to next node
         return next;
      }
      
      public int getData() {              // Get data of current node
         return items;
      } 
            
   } // End Class (NODE)
   
} // End Class (LIST_EXERCISE)