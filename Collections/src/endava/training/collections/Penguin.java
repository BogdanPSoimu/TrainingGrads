package endava.training.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Penguin {
	
	private String name;
	private PenguinRace race;
	private double age;
	private List<Penguin> matingPartners;
	
	public Penguin(String name, PenguinRace race, double age) {
		this.name = name;
		this.race = race;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public PenguinRace getRace() {
		return race;
	}

	public double getAge() {
		return age;
	}

	public List<Penguin> getMatingPartners() {
		return matingPartners;
	}

	public void setMatingPartners(List<Penguin> matingPartners) {
		this.matingPartners = matingPartners;
	}

	@Override
	public String toString() {
		return "Name: " + this.name + ", Race: " + this.race + ", Age " + this.age + ", Number of Mating partners: " +
				getMatingPartners().size() + ", Average age of Mating partners: " + mateAverageAge();
	}

	public void generateMatingPartners () {
		Random rand = new Random();
		List<Penguin> partners = new ArrayList<Penguin>();
		int i = rand.nextInt(3);

		for(int j = 0; j < i; j++)
			partners.add(new PenguinHatchery().hatchPenguin());

		this.setMatingPartners(partners);
	}
	
	public double mateAverageAge() {
		double average = 0;
		for(int i = 0; i < matingPartners.size(); i++)
			average += matingPartners.get(i).age;
		average = average / matingPartners.size();
		return average;
	}

}



