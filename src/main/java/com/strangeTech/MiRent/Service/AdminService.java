package com.strangeTech.MiRent.Service;


import com.strangeTech.MiRent.Repository.AdminRepository;
import com.strangeTech.MiRent.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository repository;

    public List<Admin> findAll() {
        return repository.findAll();
    }

    public Admin findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Admin save(Admin admin) {
        return repository.save(admin);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
