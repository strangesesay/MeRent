package com.strangeTech.MiRent.Service;


import com.strangeTech.MiRent.Repository.UserRepository;
import com.strangeTech.MiRent.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<AppUser> findAll() {
        return repository.findAll();
    }

    public AppUser findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public AppUser save(AppUser user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
