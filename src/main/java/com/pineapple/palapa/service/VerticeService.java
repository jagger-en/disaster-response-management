package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.Vertice;
import com.pineapple.palapa.repo.VerticeRepo;

import java.util.List;

@Service
public class VerticeService {
    private final VerticeRepo verticeRepo;

    @Autowired
    public VerticeService(VerticeRepo verticeRepo) {
        this.verticeRepo = verticeRepo;
    }

    public Vertice addVertice(Vertice Vertice) {
        return verticeRepo.save(Vertice);
    }

    public List<Vertice> findAllVertices() {
        return verticeRepo.findAll();
    }

    public void deleteVertice(Long id){
        Vertice vertice = verticeRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("Vertice by id " + id + " was not found"));
        verticeRepo.delete(vertice);
    }
}
