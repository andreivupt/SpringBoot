package com.trabalho.g2.controller;

import com.trabalho.g2.model.Candidate;
import com.trabalho.g2.repository.CandidateRepository;
import com.trabalho.g2.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/election")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @RequestMapping("/")
    public ModelAndView findAll(){

        ModelAndView view = new ModelAndView("candidate");
        view.addObject("candidates", candidateService.findAll());

        return view;

    }

    @GetMapping("/add")
    public ModelAndView add(Candidate candidate) {

        ModelAndView view = new ModelAndView("/candidateAdd");
        view.addObject("candidate", candidate);

        return view;

    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {

        return add(candidateService.findOne(id));

    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {

        candidateService.delete(id);

        return findAll();

    }

    @PostMapping("/save")
    public ModelAndView save(@Valid Candidate candidate, BindingResult result) {

        if(result.hasErrors()) {
            return add(candidate);
        }

        candidateService.save(candidate);

        return findAll();
    }
}
