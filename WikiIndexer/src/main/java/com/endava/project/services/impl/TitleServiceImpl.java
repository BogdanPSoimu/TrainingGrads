package com.endava.project.services.impl;

import com.endava.project.entities.Occurrence;
import com.endava.project.entities.Title;
import com.endava.project.repositories.OccurrenceRepository;
import com.endava.project.repositories.TitleRepository;
import com.endava.project.services.OccurrenceService;
import com.endava.project.services.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ivamesu on 8/11/2016.
 */
@Service
public class TitleServiceImpl implements TitleService {

    @Autowired
    private OccurrenceRepository occurrenceRepository;

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private OccurrenceService occurrenceService;

    @Override
    @Transactional
    public void saveOccurrence(String title) {
        Title finalTitle = new Title();
        finalTitle.setName(title);
        List<Occurrence> list = new ArrayList<>();
        String content = occurrenceService.readFromURL(title);
        Map<String, Integer> map1 = occurrenceService.findWordOccurrence(content);
        Map<String, Integer> map2 = occurrenceService.sortTheWords(map1);
        Map<String, Integer> map3 = occurrenceService.wordsToBeSaved(map2);
        list = occurrenceService.objectsToBeSaved(map3, finalTitle);
        for (Occurrence occurrence : list)
            occurrenceRepository.save(occurrence);

        titleRepository.save(finalTitle);
    }

}
