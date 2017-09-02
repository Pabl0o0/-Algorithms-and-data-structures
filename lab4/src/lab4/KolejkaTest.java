package lab4;


public class KolejkaTest {
	
	public static void main(String[] args) throws EmptyQueueException{
	Kolejka q = new Kolejka();
	 Student student0 = new Student(0, "Kowalski", "Jan", 5.5);
     Student student1 = new Student(1, "Kowal", "Basia", 4.5);
     Student student2 = new Student(2, "èrÛd≥o", "Maciej", 3.5);
     Student student3 = new Student(3, "Wysoka", "Marta", 4.0);
     Student student4 = new Student(4, "Konarek", "Dorota", 5.0);
//     Student student5 = new Student(5, "Nowy", "Marek", 5.0);
   q.enqueue(student0);
   q.enqueue(student1);
   q.enqueue(student2);
   q.enqueue(student3);
   q.enqueue(student4);
   System.out.println("Czy kolejka jest pusta?");
   System.out.println(q.isEmpty());
   System.out.println("D≥ugoúÊ kolejki");
   System.out.println(q.size());
   System.out.println();
   
   System.out.println("Metoda dequeue");
   System.out.println(q.dequeue());
   System.out.println(q.dequeue());
   
   System.out.println();   
   System.out.println("D≥ugoúÊ kolejki po zmianie");
   System.out.println(q.size());
   q.displayQueue();
   
   System.out.println();
   System.out.println("CzyszczÍ kolejkÍ");
   q.clear();
   System.out.println("D≥ugoúÊ kolejki");
   System.out.println(q.size());
   
   System.out.println();
   System.out.println("Tak dzia≥a wyjπtek !!");
   q.displayQueue();
   
   
	}  
}
