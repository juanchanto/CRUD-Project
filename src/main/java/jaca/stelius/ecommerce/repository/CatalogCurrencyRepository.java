package jaca.stelius.ecommerce.repository;

import jaca.stelius.ecommerce.model.CatalogCurrency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CatalogCurrencyRepository extends JpaRepository<CatalogCurrency, Integer> {
    Optional<CatalogCurrency> findById(Integer id);
}
