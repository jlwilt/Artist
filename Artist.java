import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Artist {
	static String name, country;
	static int age, netWorth;
	public static boolean active, deceased = false;
	
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
		Scanner scan = new Scanner(System.in);
		String musicianInfo = "";
		String musicianName[];
		try (FileWriter fw = new FileWriter("Musicians.txt", true)) {
			System.out.println("Enter musician name: ");
			musicianName = scan.nextLine().split(" ");
			System.out.println(musicianName.length);
			for (int i = 0; i <= musicianName.length-1; i++) {
				musicianName[i] += "_";
				if (i == musicianName.length-1) {
					musicianName[i].replace('_', ' ');
				}
				musicianInfo += musicianName[i];

			}
			System.out.println("Enter musician nationality: ");
			musicianInfo += " " + scan.nextLine();
			System.out.println("Enter musician age: ");
			musicianInfo += " " + scan.nextLine();
			System.out.println("Is the musician deceased (yes/no)?");
			if (scan.nextLine().equals("yes")) {
				musicianInfo += "*";
			} else {
				System.out.println("Enter whether musician active (T/F): ");
				musicianInfo += " " + scan.nextLine();
			}
			System.out.println("Enter musician instrument or vocals: ");
			musicianInfo += " " + scan.nextLine();
			System.out.println("Enter whether musician plays an addtional instrument (yes/no): ");
			if (scan.nextLine().equals("yes")) {
				System.out.println("Enter second instrument: ");
				musicianInfo += "/" + scan.nextLine();
			}
			System.out.println("Enter musician net worth: ");
			musicianInfo += " " + scan.nextLine();
			fw.append("\n" + musicianInfo);
			System.out.println("Musician successfully entered into file.");
			fw.close();
			scan.close();
;		} catch (IOException e){
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
