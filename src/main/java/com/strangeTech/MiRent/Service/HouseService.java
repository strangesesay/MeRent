package com.strangeTech.MiRent.Service;


import com.strangeTech.MiRent.Repository.HouseRepository;
import com.strangeTech.MiRent.model.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {
    @Autowired
    private HouseRepository repository;

    public List<House> findAll() {
        return repository.findAll();
    }

    public House findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public House save(House house) {
        return repository.save(house);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
