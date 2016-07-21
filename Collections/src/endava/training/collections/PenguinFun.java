package endava.training.collections;

import java.util.*;
import java.util.Collections;

public class PenguinFun {

	public static void main(String [] args){
		
		List<Penguin> penguins = new ArrayList<Penguin>();
		PenguinHatchery penguinHatchery = new PenguinHatchery();
		Set<Penguin> penguinsSet = new HashSet<Penguin>();

        //generate 10 penguins and their mating partners for the ArrayList, HashSet
		for (int i = 0; i < 10 ; i++) {
			Penguin hatchedPenguin = penguinHatchery.hatchPenguin();
			penguins.add(hatchedPenguin);
            penguins.get(i).generateMatingPartners();
			penguinsSet.add(hatchedPenguin);
		}

        Iterator<Penguin> it1 = penguins.iterator();
        while(it1.hasNext())
            System.out.println(it1.next().toString());

		while(it1.hasNext())
			System.out.println(it1.next().toString());

		System.out.println();

		Iterator<Penguin> it2 = penguinsSet.iterator();

		while(it2.hasNext())
			System.out.println(it2.next().toString());



        //Collections.sort(penguins, new SpecialComparator());
		Collections.sort(penguins, new SpecialMatingComparator());





        Map<PenguinRace, List<Penguin>> hm= new HashMap<>();

        List<Penguin> penguinImperial = new ArrayList<>();
        List<Penguin> penguinRegal = new ArrayList<>();
        List<Penguin> penguinMacaroni = new ArrayList<>();
        List<Penguin> penguinAfrican = new ArrayList<>();
        List<Penguin> penguinAntartic = new ArrayList<>();

        //group up the penguins by their race
        for (Penguin penguin : penguins) {
            if(penguin.getRace().toString().equals("IMPERIAL"))
                penguinImperial.add(penguin);
            else if (penguin.getRace().toString().equals("REGAL"))
                penguinRegal.add(penguin);
            else if (penguin.getRace().toString().equals("MACARONI"))
                penguinMacaroni.add(penguin);
            else if (penguin.getRace().toString().equals("AFRICAN"))
                penguinAfrican.add(penguin);
            else if (penguin.getRace().toString().equals("ANTARCTIC"))
                penguinAntartic.add(penguin);
        }

        hm.put(PenguinRace.IMPERIAL, penguinImperial);
        hm.put(PenguinRace.REGAL, penguinRegal);
        hm.put(PenguinRace.MACARONI, penguinMacaroni);
        hm.put(PenguinRace.AFRICAN, penguinAfrican);
        hm.put(PenguinRace.ANTARCTIC, penguinAntartic);

        Set set = hm.entrySet();
        Iterator i = set.iterator();

        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
	}

}	

