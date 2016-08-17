package com.endava.project.services.impl;

import com.endava.project.entities.Occurrence;
import com.endava.project.entities.Title;
import com.endava.project.services.OccurrenceService;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@Service
public class OccurrenceServiceImpl implements OccurrenceService {


    static URL url;
    static HttpURLConnection conn;

    @Override
    public String readFromURL(String name) {
        String str = null;
        String inputLine;
        try {
            url = new URL("https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&explaintext=&titles=" + name);
            conn = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            while ((inputLine = in.readLine()) != null) {
                str = inputLine;
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    //Aici aflu map-ul cu cuvinte si de cate ori apare fiecare cuvant
    @Override
    public Map<String, Integer> findWordOccurrence(String title) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Integer counter = 1;
        String separator = "(\\.|,|;|:|\\\\|/|\\?|~|`|<|>|\\[|]|\\{|}|\\(|\\)" +
                "|!|@|#|\\$|%|\\^|&|\\-|_|\\+|'|=|\\*|\"|\\|| |\\t|\\n|\\r)+";
        List<String> ignoreAll = Arrays.asList("the", "of", "a", "and", "in", "to", "are", "as", "that",
                "is", "with", "for", "or", "they", "be", "on", "their", "have", "other", "used", "from",
                "can", "also", "such", "were", "an", "by", "which", "in", "this", "often", "even", "had",
                "has", "not", "been", "some", "it", "n", "many", "its");

        String[] words = title.split(separator);
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
            if (!ignoreAll.contains(words[i])) {
                counter = map.get(words[i]);
                if (counter == null)
                    counter = new Integer(0);
                map.put(words[i], counter + 1);
            }
        }

        return map;
    }

    //Sorteaza mapul dupa cele mai multe aparitii(cele mai mari valori)
    @Override
    public Map<String, Integer> sortTheWords(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

       return sortedMap;
    }

    //primeste o lista sortata si pastreaza primele 10 elemente
    public Map<String, Integer> wordsToBeSaved(Map<String,Integer> map){
        Map<String, Integer> finalMap = new HashMap<>();
        Iterator it = map.entrySet().iterator();
        int i = 0;
        while (it.hasNext() && i < 10) {
            Map.Entry pair = (Map.Entry) it.next();
            i++;
            finalMap.put((String) pair.getKey(), (Integer) pair.getValue());
        }

        return finalMap;
    }

    //ia lista de 10 elemente si o transforma in obiecte care vor si salvate in baza de date
    @Override
    public List<Occurrence> objectsToBeSaved(Map<String, Integer> map, Title title) {
        Occurrence occurrence = new Occurrence();
        List<Occurrence> list = new ArrayList<>();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            occurrence.setWord((String) pair.getKey());
            occurrence.setOccurrences((Integer) pair.getValue());
            occurrence.setTitle(title);
            list.add(occurrence);
        }
        return list;
    }

}
