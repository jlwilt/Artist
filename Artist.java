import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Artist {
	static String name, country;
	static int age, netWorth;
	public static boolean active, deceased = false;
	static Scanner scan = new Scanner(System.in);
	
	public static String removeNameUnderscores(String name) {
		String nameArray[];
		nameArray = name.split("_");
		name = "";
		for (int i = 0; i < nameArray.length; i++) {
			name += nameArray[i] + " ";
		}
		return name;
	}
	
	public static String removeAgeAsterisk(String age) {
		if (age.contains("*")) {
			deceased = true;
			StringBuffer sb = new StringBuffer(age);
			sb = sb.deleteCharAt(age.length() - 1);
			age = sb.toString();
		}
		return age;
	}
	
	public static void inputMusician() {
		String musicianInfo = "";
		try {
			FileWriter fw = new FileWriter("Musicians.txt", true);
			System.out.println("Enter musician name (put underscores between each section of name): ");
			musicianInfo += scan.next();
			System.out.println("Enter musician nationality: ");
			musicianInfo += " " + scan.next();
			System.out.println("Enter musician age: ");
			musicianInfo += " " + scan.next();
			System.out.println("Is the musician deceased (yes/no)?");
			if (scan.next().equals("yes")) {
				musicianInfo += "*";
			} else {
				System.out.println("Enter whether musician active (T/F): ");
				musicianInfo += " " + scan.next();
			}
			System.out.println("Enter musician instrument or vocals: ");
			musicianInfo += " " + scan.next();
			System.out.println("Enter whether musician plays an addtional instrument (yes/no): ");
			if (scan.next().equals("yes")) {
				System.out.println("Enter second instrument: ");
				musicianInfo += " " + scan.next();
			}
			System.out.println("Enter musician net worth: ");
			musicianInfo += " " + scan.next();
			System.out.println(musicianInfo);
			fw.append("\n" + musicianInfo);
			fw.close();
		} catch (Exception e){
			System.out.println("File not found");
		}
	}
	
	public static void main(String[] args) {
		String[] sc = new String[7];
		Musician[] musician = new Musician[100];
		String line;
		try {
			BufferedReader br = new BufferedReader(new FileReader("Musicians.txt"));
			inputMusician();
			for (int i = 1; (line = br.readLine()) != null; i++) {
				if (i > 1) {
					sc = line.split(" ");
					musician[i] = new Musician(sc);
				}
			}
			br.close();
		} catch (IOException e) {
			System.out.println("File not found");
		}
		
	}

}
