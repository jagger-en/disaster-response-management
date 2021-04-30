package com.pineapple.palapa.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pineapple.palapa.model.Vertice;
import com.pineapple.palapa.service.VerticeService;

import java.util.List;

@RestController
@RequestMapping("/api/vertices") 
public class VerticeApiController {

    private final VerticeService verticeService;

    public VerticeApiController(VerticeService verticeService) {
        this.verticeService = verticeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Vertice>> getAllVertices() {
        List<Vertice> vertices = verticeService.findAllVertices();
        return new ResponseEntity<>(vertices, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Vertice> addVertice(@RequestBody Vertice vertice) {
        Vertice newVertice = verticeService.addVertice(vertice);
        return new ResponseEntity<>(newVertice, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVertice(@PathVariable("id") Long id) {
        verticeService.deleteVertice(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}