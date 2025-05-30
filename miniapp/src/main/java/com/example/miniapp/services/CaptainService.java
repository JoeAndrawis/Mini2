package com.example.miniapp.services;

import com.example.miniapp.models.Captain;
import com.example.miniapp.repositories.CaptainRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaptainService {

    private final CaptainRepository captainRepository;

    public CaptainService(CaptainRepository captainRepository) {
        this.captainRepository = captainRepository;
    }

    public Captain addCaptain(Captain captain) {
        return captainRepository.save(captain);
    }

    public List<Captain> getAllCaptains() {
        return captainRepository.findAll();
    }

    public Captain getCaptainById(Long id) {
        Optional<Captain> optionalCaptain = captainRepository.findById(id);
        return optionalCaptain.orElse(null);
    }

    public List<Captain> getCaptainsByRating(Double ratingThreshold) {
        return captainRepository.findByAvgRatingScoreGreaterThan(ratingThreshold);
    }

    public Captain getCaptainByLicenseNumber(String licenseNumber) {
        return captainRepository.findByLicenseNumber(licenseNumber);
    }
}

