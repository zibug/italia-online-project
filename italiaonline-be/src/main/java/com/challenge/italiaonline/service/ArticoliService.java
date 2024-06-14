package com.challenge.italiaonline.service;

import com.challenge.italiaonline.model.Articolo;
import com.challenge.italiaonline.repository.ArticoliRepository;
import com.challenge.italiaonline.utils.Sorgenti;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticoliService {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    ArticoliRepository repository;
    @Autowired
    private ExternalApiService externalApiService;

    public List<Articolo> getNews() {

        List<Articolo> result = new ArrayList<>();

        result.addAll(externalApiService.getArticoliBBC(10));
        result.addAll(externalApiService.getArticoliHacker(10));
        result.addAll(externalApiService.getArticoliNyTimes(10));

        return result;
    }

    public List<Articolo> getNewsFromSource(String source) {
        List<Articolo> listaArticolo = new ArrayList<>();
        Sorgenti sorgente = Sorgenti.getSorgenteFromDescrizione(source);
        logger.info(sorgente.getDescrizione());
        switch (sorgente) {
            case BBC:
                return externalApiService.getArticoliBBC(30);
            case HACKER:
                return externalApiService.getArticoliHacker(30);
            case NYTIMES:
                return externalApiService.getArticoliNyTimes(30);
            default:
                return listaArticolo;
        }

    }

    
    @Transactional(rollbackFor = RuntimeException.class)
    public Articolo saveArticolo(Articolo articolo) {
        try {
            repository.save(articolo);
            return articolo;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Articolo> getListaArticoli() {
        List<Articolo> articoli = null;
        try {
            articoli = repository.findAll();
            logger.info("size articoli" + articoli.size());
            return articoli;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Articolo> filtra(String word) {
        List<Articolo> articoli = null;
        try {
            articoli = repository.findAll().stream().filter(el -> el.getTitle().toLowerCase().contains(word.toLowerCase())).collect(Collectors.toList());
            logger.info("size articoli" + articoli.size());
            return articoli;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
