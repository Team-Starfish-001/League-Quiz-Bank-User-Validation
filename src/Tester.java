import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

public class Tester {
	public Tester() {
		try {
			//OutputStream o =  
			BufferedReader b = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("curl --user \"teamStarfish001:dumdumdum07\" https://api.github.com/gists/starred").getInputStream()));
			//prnt.println();
			String line = b.readLine();
			System.out.println(line);
			while (line != null) {
				line = b.readLine();
				System.out.println(line);
			}
		} catch(Exception e) {
			
		}
	}
	
	public static void main(String[] args) {
		Tester t = new Tester();
	}
	
}
