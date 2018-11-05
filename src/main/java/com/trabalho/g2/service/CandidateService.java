package com.trabalho.g2.service;

import com.trabalho.g2.model.Candidate;
import com.trabalho.g2.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public List<Candidate> findAll() {

        return candidateRepository.findAll();

    }

    public Candidate findOne(Long id) {

        return candidateRepository.findById(id).get();

    }

    public Candidate save(Candidate candidate) {

        return candidateRepository.saveAndFlush(candidate);

    }

    public void delete(Long id) {

        candidateRepository.deleteById(id);

    }
}
