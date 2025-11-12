package com.strangeTech.MiRent.Service;


import com.strangeTech.MiRent.Repository.RentalRepository;
import com.strangeTech.MiRent.model.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {
    @Autowired
    private RentalRepository repository;

    public List<Rental> findAll() {
        return repository.findAll();
    }

    public Rental findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Rental save(Rental rental) {
        return repository.save(rental);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
