package org.url.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.url.model.ShortURL;
import org.url.repository.ShortURLRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@Log4j2
public class ShortURLService {

    @Autowired
    private ShortURLRepository shortURLRepository;

    public ShortURL create(ShortURL shortURL) {
        Assert.notNull(shortURL, "ShortURL object is empty");
        log.info("Saving short url {}", shortURL);
        return shortURLRepository.saveAndFlush(shortURL);
    }

    // To be removed
    public List<ShortURL> get() {
        return shortURLRepository.findAll();
    }
}
