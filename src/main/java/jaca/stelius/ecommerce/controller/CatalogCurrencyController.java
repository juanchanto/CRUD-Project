package jaca.stelius.ecommerce.controller;

import jaca.stelius.ecommerce.model.CatalogCurrency;
import jaca.stelius.ecommerce.repo.CatalogCurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalogcurrency")
@RequiredArgsConstructor
public class CatalogCurrencyController {
    @Autowired
    private CatalogCurrencyRepository catalogCurrencyRepository;

    @GetMapping("")
    List<CatalogCurrency> index(){
        return catalogCurrencyRepository.findAll();
    }
    @GetMapping("/{id}")
    public CatalogCurrency getById(@PathVariable("id") int id){
        return catalogCurrencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catalog currency Not Found: " + id));
    }
}
