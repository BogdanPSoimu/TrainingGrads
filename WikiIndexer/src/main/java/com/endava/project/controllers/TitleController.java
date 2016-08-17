package com.endava.project.controllers;

import com.endava.project.entities.Title;
import com.endava.project.services.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TitleController {

    @Autowired
    private TitleService titleService;

    @RequestMapping(value = "/document", method = RequestMethod.GET)
    @ResponseBody
    public void save(@RequestParam(name = "title") String title) {

         titleService.saveOccurrence(title);
    }



}
