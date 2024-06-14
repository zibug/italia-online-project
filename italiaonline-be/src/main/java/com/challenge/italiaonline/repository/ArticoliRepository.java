package com.challenge.italiaonline.repository;

import com.challenge.italiaonline.model.Articolo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ArticoliRepository extends MongoRepository<Articolo, String> {
}
