package jaca.stelius.ecommerce.controller;

import jaca.stelius.ecommerce.model.CatalogCurrency;
import jaca.stelius.ecommerce.repository.CatalogCurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogcurrency")
@RequiredArgsConstructor
public class CatalogCurrencyController {
    @Autowired
    private CatalogCurrencyRepository catalogCurrencyRepository;

    @GetMapping("")
    public List<CatalogCurrency> index(){
        return catalogCurrencyRepository.findAll();
    }
    @GetMapping("/{id}")
    public CatalogCurrency getCatalogCurrencyById(@PathVariable("id") int id){
        return catalogCurrencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catalog currency Not Found: " + id));
    }

    // Método para crear un nuevo elemento del catálogo
    @PostMapping("")
    public CatalogCurrency createCatalogCurrency(@RequestBody CatalogCurrency catalogCurrency) {
        return catalogCurrencyRepository.save(catalogCurrency);
    }
    // Método para actualizar un elemento del catálogo
    @PutMapping("/{id}")
    public CatalogCurrency updateCatalogCurrency(@PathVariable("id") int id, @RequestBody CatalogCurrency updatedCatalogCurrency) {
        CatalogCurrency existingCatalogCurrency = catalogCurrencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catalog currency Not Found: " + id));

        existingCatalogCurrency.setDescription(updatedCatalogCurrency.getDescription());
        existingCatalogCurrency.setStatus(updatedCatalogCurrency.getStatus());
        // Agrega aquí más campos que desees actualizar

        return catalogCurrencyRepository.save(existingCatalogCurrency);
    }

    // Método para eliminar un elemento del catálogo
    @DeleteMapping("/{id}")
    public void deleteCatalogCurrency(@PathVariable("id") int id) {
        CatalogCurrency catalogCurrencyToDelete = catalogCurrencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catalog currency Not Found: " + id));

        catalogCurrencyRepository.delete(catalogCurrencyToDelete);
    }

}
