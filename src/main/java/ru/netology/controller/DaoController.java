package ru.netology.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.repository.DaoRepository;

import java.util.List;

@RestController
@RequestMapping("/products")
public class DaoController {
    private final DaoRepository daoRepository;

    public DaoController(DaoRepository daoRepository) {
        this.daoRepository = daoRepository;
    }

    @GetMapping("fetch-product")
    public ResponseEntity<List<String>> getProduct(@RequestParam String name) {
        List<String> names = daoRepository.getProductNames(name);
        return ResponseEntity.ok().body(names);
    }
}