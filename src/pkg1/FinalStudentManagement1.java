package pkg1;

import java.util.Scanner;

class SinglyList1{                                  // created node class which will contain data and address of next node
	static class Node{
		private int id;                              // data
		private String name;                   // data
		private String dob;                     // data
		private String course;                 // data
		private String address;                // data
		private double marks;                 // data
		private Node next;                       // address of next node

		public Node(){                            // no arguement constructor
			id=0;
			name=null;
			dob=null;
			course=null;
			address=null;
			marks=0.0;
			next=null;
		}

public Node(int id,String name, String dob,String course,String address,double marks){ // with arguement constructor
	this.id=id; 
	this.name=name;
	this.dob=dob;
	this.course=course;
	this.address=address;
	this.marks=marks;
	next=null;
	}
}
	
	
//list class fields
private Node head;                    // declared one head 
	public SinglyList1(){
		head=null;                           // pointed that head towards null
}



public void display() {                                     // method to display all details
	
	System.out.println("Student List :    ");
	Node trav=head;                                       // made one node for traversing and assigned value of head to it
	
		if(trav==null) {                                     // if trav i.e temporary head is null that means there is no data in list 
			System.out.println(" No  Data to Show  ");
		}
	while(trav!=null){               // in this loop that temporary trav node will start from head because we have assigned head value to it 
		                                       // traverse one by one till it reaches  null and then it will terminate
		
		System.out.println(trav.id+" "+trav.name+" "+trav.dob+" "+trav.course+" "+trav.address+" "+trav.marks+" ");

		trav=trav.next;   // storing the address of next node in trav so that when next itration will occour 
		                           // trav will shift on next node aand execute
	}
	System.out.println("");
}


void addFirst(int id,String name,String dob,String course,String address,double marks){ // method to add node in first
	Node newNode = new Node(id,name,dob,course,address,marks);         // naya node create karo
	newNode.next=head;   // naye node me head ka address store karo
	head=newNode;           // naye node ko head bana do
}


void addLast(int id,String name,String dob,String course,String address,double marks){ // method to add node in last
	Node newNode = new Node(id,name,dob,course,address,marks);  // naya node create karo
	//Special 1: if list is empty, make new node as first node of list
	if(head==null){                // if head null he
		head=newNode;         // to new node ko head bana do
}
	// general: add node at the end
		else {
			// traverse till last node
			Node trav = head;                  // create a trav node for traversing and store value of head in it
			while(trav.next != null)         // keept traversing till it does not encounter null
			{
				trav = trav.next;              // keep itrating loop and , go next next until it encounter null
				                                        // once encountered null , come out of loop
			}
			// add new node after trav (trav.next)
			trav.next = newNode;     // jaha pr null mile waha newly created node ko place kr do and 
			                                         //current wale node me next node ka address save kr do
		}
}

public void addAtPos(int id,String name,String dob,String course,String address,double marks,int pos) {  // method to add at perticular position
		// special 1: if list is empty, add node at the start
		// special 2: if pos<=1, add node at the start
		if(head == null || pos <= 1)
			addFirst(id,name,dob,course,address,marks);
		// general: add node at given pos
		else {
			// allocate & init new node
			Node newNode = new Node(id,name,dob,course,address,marks);  // create a new node 
			// traverse till pos-1 (trav)
			Node trav = head;                            // make a node trav for traversing and store the value of head in trav           
			for(int i=1; i < pos-1; i++) {              // run the loop till required position (i.e required index)
				// special 3: if pos > length of list, add node at the end.
				if(trav.next == null)                   // if next node null aaye
					break;                                    // break kr do
				trav = trav.next;                       //  
			}
			// newnode's next should point to trav's next
			newNode.next = trav.next;
			// trav's next should pointer to new node
			trav.next = newNode;
		}
	}

public void delFirst() {
		// special 1: if list is empty, throw exception
		if(head == null)
			throw new RuntimeException("Student List is empty.");
		// general: make head pointing to next node.
		head = head.next;
		// note: the old first node will be garbage collected.
	}

public void delAll() {
		head = null;
		System.out.println("Deleted !Done");
		// all nodes will be garbage collected
	}


public void delAtPos(int pos) {
		// special 1: if pos = 1, delete first node
		if(pos == 1)
			delFirst();
		// special 2: if list is empty or pos < 1, then throw exception.
		if(head == null || pos < 1)
			throw new RuntimeException("Student List is empty or Invalid position.");
		// take temp pointer running behind trav.
		Node temp = null, trav = head;
		// traverse till pos (trav)
		for(int i = 1; i < pos; i++) {
			// special 3: if pos is beyond list length, then throw exception.
			if(trav == null)
				throw new RuntimeException("Invalid position.");
			temp = trav;
			trav = trav.next;
		}
		// trav is node to be deleted & temp is node before that
		temp.next = trav.next;
		// trav node will be garbage collected
	}
	
public void delLast() {
		// special 1: if list is empty, throw exception
		if(head == null)
			throw new RuntimeException("Student List is empty.");
		// special 2: if list has single node, make head null.
		if(head.next == null)
			head = null;
		else {
			// general: delete the last node
			Node temp=null, trav=head;
			// traverse till last node (trav) and run temp behind it
			while(trav.next != null) {
				temp = trav;
				trav = trav.next;
			}
			// when last node (trav) is deleted, second last node (temp) next should be null.
			temp.next = null;
			// last node (trav) will be garbage collected.
		}
	}

public void search_student_data(int id) {  // method to search perticular id
	Node trav = head;       // make a temporary pointer for traversal
	
	while(trav!=null) {      // keep traversing from start to end until it encounter null (ie end)
		if(trav.id==id) {       // if matches entered id 
			System.out.println(trav.id+" "+trav.name+" "+trav.dob+" "+trav.course+" "+trav.address+" "+trav.marks+" ");	// print all data in node
	}
		trav=trav.next;			// keep storing address of next node in current node .
	}
}

public void update_student_data(int id,String name,String dob, String course, String address, double marks) {
	
	if(head==null) {
		System.out.println("List is Empty :");
		return;
	}
	if(id==head.id) {
		head.name=name;
		head.dob=dob;
		head.course=course;
		head.address=address;
		head.marks=marks;
		return;
	}
	Node trav = head;
	while(trav.next!=null) {
		if(trav.next.id==id) {
			Node u =trav.next;
			u.name = name;
			u.dob=dob;
			u.course=course;
			u.address=address;
			u.marks=marks;
			return;
		}
		trav=trav.next;
		
	}
	
	
}

}




public class FinalStudentManagement1 {

	public static void main(String[] args) {
		
		int choice, id,pos;
		String name,dob,course,address;
		double marks;
				SinglyList1 list = new SinglyList1();
				Scanner sc = new Scanner(System.in);
				do {
					System.out.println("\n0. Exit\n1. Display\n2. Add First\n3. Add Last\n4. Add At Pos\n5. Search\n6. Update\n7. Del Last\n8. Del At Pos\n9. Del All\n10. Del First\n Enter choice: ");
					choice = sc.nextInt();
					switch (choice) {
					case 1: // Display
						list.display();
						break;
					case 2: // Add First
						System.out.print("Enter new student: student id + student name + student dob + student course + student address + student marks ");
						id = sc.nextInt();
						name = sc.next();
						dob = sc.next();
						course = sc.next();
						address = sc.next();
						marks = sc.nextDouble();
						list.addFirst(id,name,dob,course,address,marks);
						break;
					case 3: // Add Last
						System.out.print("Enter new student: student id + student name + student dob + student course + student address + student marks");
						id = sc.nextInt();
						name = sc.next();
						dob = sc.next();
						course = sc.next();
						address = sc.next();
						marks = sc.nextDouble();
						list.addLast(id,name,dob,course,address,marks);
						break;
					case 4: // Add At Pos
						System.out.print("Enter new student: student id + student name + student dob + student course + student address + student marks");
						id = sc.nextInt();
						name = sc.next();
						dob = sc.next();
						course = sc.next();
						address = sc.next();
						marks = sc.nextDouble();
						System.out.print("Enter Student position: ");
						pos = sc.nextInt();
						list.addAtPos(id,name,dob,course,address,marks,pos);				
						break;
					case 5: // Search 
						System.out.println("Enter student id");
						id = sc.nextInt();
						list.search_student_data(id);
						break;
					case 6: // Update
						System.out.println("Enter new student: student id + student name + student dob + student course + student address + student marks");
						id = sc.nextInt();
						name = sc.next();
						dob = sc.next();
						course = sc.next();
						address = sc.next();
						marks = sc.nextDouble();
						list.update_student_data(id,name,dob,course,address,marks);
						break;
					case 7: // Del Last
						try {
							list.delLast();
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 8: // Del At Pos
						System.out.print("Enter element position: ");
						pos = sc.nextInt();
						try {
							list.delAtPos(pos);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 9: // Del All
						list.delAll();
						break;
					case 10: // Del First
						try {
							list.delFirst();
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					}
				} while(choice!=0);
				sc.close();
	}

}
