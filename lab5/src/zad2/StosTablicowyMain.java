package zad2;


import lab5.Student;

public class StosTablicowyMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student0 = new Student(0, "Kowalski", "Jan", 5.5);
        Student student1 = new Student(1, "Kowal", "Basia", 4.5);
        Student student2 = new Student(2, "èrÛd≥o", "Maciej", 3.5);
        Student student3 = new Student(3, "Wysoka", "Marta", 4.0);
        Student student4 = new Student(4, "Konarek", "Dorota", 5.0);

        StosTablicowy stosik = new StosTablicowy(5);
        stosik.push(student0);
        stosik.push(student1);
        stosik.push(student2);
        stosik.push(student3);
        stosik.push(student4);

        System.out.println(stosik.pop());
        System.out.println(stosik.peek());

 
	}
}
