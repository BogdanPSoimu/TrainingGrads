package com.endava.project.services;

import com.endava.project.entities.Occurrence;
import com.endava.project.entities.Title;

import java.util.List;
import java.util.Map;

public interface OccurrenceService {

    String readFromURL(String name);

    Map<String,Integer> findWordOccurrence(String title);

    Map<String,Integer> sortTheWords(Map<String, Integer> map);

    List<Occurrence>  objectsToBeSaved(Map<String, Integer> map, Title tile);

    Map<String,Integer>  wordsToBeSaved(Map<String, Integer> map);
}
