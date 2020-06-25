package com.github.alexrossi.countries.repositories;

import com.github.alexrossi.countries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
