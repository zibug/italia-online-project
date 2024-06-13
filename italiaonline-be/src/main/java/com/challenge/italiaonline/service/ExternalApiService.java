package com.challenge.italiaonline.service;

import com.challenge.italiaonline.model.Articolo;
import com.challenge.italiaonline.model.ArticoliBBCResponse;
import com.challenge.italiaonline.model.ArticoliNyTimesResponse;
import com.challenge.italiaonline.utils.Sorgenti;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExternalApiService {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private final String urlNyTimes = "https://api.nytimes.com/svc/mostpopular/v2/emailed/7.json?api-key=P9eZP8Gn1gllxx3q5QDlsJwsmQ1yQgAN";
    private final String urlIndiciHacker = "https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty";
    private final String ID_NEWS = "[id_news]";
    private final String urlDettaglioHacker = "https://hacker-news.firebaseio.com/v0/item/" + ID_NEWS + ".json?print=pretty";
    private final String urlBBC = "http://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=9acc642023684f07b46fae89185513ce";

    public List<Articolo> getArticoliNyTimes(Integer size) throws RestClientException{

        RestTemplate restTemplate = new RestTemplate();

        List<Articolo> result = null;
        ArticoliNyTimesResponse response = null;
        try {
            String jsonString = restTemplate.getForObject(this.urlNyTimes, String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            response = objectMapper.readValue(jsonString, ArticoliNyTimesResponse.class);
            result = response.getResults();
            result.stream().forEach(ar -> ar.setSource(Sorgenti.NYTIMES.getDescrizione()));
        } catch (RestClientException e) {
            logger.error(e);
            throw e;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        if(result.size() > size) {
            result = result.subList(0, size);
        }
        return result;
    }

    public List<Articolo> getArticoliHacker(Integer size) throws RestClientException{

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Articolo> result = new ArrayList<>();
        ArrayList<Integer> indiciNews = null;
        try {
            String jsonString = restTemplate.getForObject(this.urlIndiciHacker, String.class);
            indiciNews = objectMapper.readValue(jsonString, ArrayList.class);
        } catch (RestClientException e) {
            logger.error(e);
            throw e;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        if(indiciNews != null) {
            for(int i = 0; i < size; i++) {
                Articolo response = null;
                String urlHacker = null;
                try {
                    Integer indice = indiciNews.get(i);
                    urlHacker = this.urlDettaglioHacker.replace(this.ID_NEWS, indice.toString());
                } catch (Exception e) {
                    logger.error(e);
                    throw e;
                }

                try {
                    String jsonString = restTemplate.getForObject(urlHacker, String.class);
                    logger.info(urlHacker);
                    response = objectMapper.readValue(jsonString, Articolo.class);
                    if(response != null) {
                        result.add(response);
                        response.setSource(Sorgenti.HACKER.getDescrizione());
                    }
                } catch (RestClientException e) {
                    logger.error(e);
                    throw e;
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
            return result;
        }

        return null;
    }

    public List<Articolo> getArticoliBBC(Integer size) throws RestClientException{

        RestTemplate restTemplate = new RestTemplate();

        List<Articolo> result = null;
        ArticoliBBCResponse response = null;
        try {
            String jsonString = restTemplate.getForObject(this.urlBBC, String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            response = objectMapper.readValue(jsonString, ArticoliBBCResponse.class);
            result = response.getArticles();
            result.stream().forEach(ar -> ar.setSource(Sorgenti.BBC.getDescrizione()));
        } catch (RestClientException e) {
            logger.error(e);
            throw e;
        } catch (JsonProcessingException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
        if(result.size() > size) {
            result = result.subList(0, size);
        }
        return result;
    }
}
