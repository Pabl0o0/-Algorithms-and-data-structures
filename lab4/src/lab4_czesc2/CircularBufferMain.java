package lab4_czesc2;

public class CircularBufferMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularBuffer buff = new CircularBuffer(7);
        buff.add(7);
        buff.add(6);
        buff.add(5);
        buff.add(4);
        buff.add(3);
        buff.add(2);
        buff.add(1);
        buff.add(0);
        System.out.println(buff.size());
        System.out.print("The head element is: ");
        buff.get();
        System.out.println(buff.size());
        buff.add(0);
        System.out.println();
        
        System.out.println(buff.size());
        System.out.println("The first element is: " + buff.takeFirst());
        System.out.println("The last element is: " + buff.takeLast());
        System.out.println(buff.size());
        buff.get();
        buff.get();
        System.out.println("The first element is: " + buff.takeFirst());
        System.out.println(buff.size());
        buff.add(99999);
        System.out.println("The last element is: " + buff.takeLast());
        buff.clean();
        buff.get();
        System.out.println();
        System.out.println(buff.size());
	}

}
