
public class Musician extends Artist {

	String[] instruments = {"" , ""};
	static String instrument1 = "", instrument2 = "";
	
	public Musician(String[] sc) {
		name = removeNameUnderscores(sc[0]);
		//name = name.trim();
		country = sc[1];
		age = Integer.valueOf(removeAgeAsterisk(sc[2]));
		if (sc[3].equals("T")) {
			active = true;
		} else {
			active = false;
		}
		if (instruments.length == 2) {
			instrument2 = instruments[1];
		}
		instruments = sc[4].split("/");
		instrument1 = instruments[0];
		//instrument1 = instrument1.trim();
		//instrument2 = instrument2.trim();
		netWorth = Integer.valueOf(sc[5]);
		//System.out.println(name + " " + country + " " + age + " " + active + " " + instrument1 + " " + instrument2 + " " + netWorth);
	}

}
