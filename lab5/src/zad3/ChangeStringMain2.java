package zad3;
import java.io.*;
import zad2.StosTablicowy;


public class ChangeStringMain2 {
	public static void main(String[] args)throws IOException {
			
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String zdanie = in.readLine();
    while ( !zdanie.equals("end")) {
        String[] splited = zdanie.split(" ");
        StosTablicowy napis = new StosTablicowy(splited.length);
        for (int i = 0; i < splited.length; i++) {
            napis.push(splited[i]);
        }

        System.out.println();
        while (!napis.isEmpty()) {
            System.out.print(napis.pop() + " ");
        }
        System.out.println();
        zdanie = in.readLine();
    }
    }
   }


