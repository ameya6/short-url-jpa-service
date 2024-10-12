package org.url.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.url.api.model.ShortURLDTO;
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

    public ShortURLDTO create(ShortURLDTO shortURLDTO) {
        Assert.notNull(shortURLDTO, "ShortURL object is empty");
        ShortURL shortURL = toShortURL(shortURLDTO);
        log.info("Saving short url {}", shortURL);
        shortURL = shortURLRepository.saveAndFlush(shortURL);
        return toShortURLDTO(shortURL);
    }

    public ShortURLDTO findAbyAlias(String alias) {
        ShortURL shortURL = shortURLRepository.findByAlias(alias);
        return toShortURLDTO(shortURL);
    }

    private ShortURL toShortURL(ShortURLDTO shortURLDTO) {
        return ShortURL.builder()
                .id(shortURLDTO.getId())
                .longURL(shortURLDTO.getLongURL())
                .alias(shortURLDTO.getAlias())
                .createdAt(shortURLDTO.getCreatedAt())
                .distributedId(shortURLDTO.getDistributedId())
                .expiry(shortURLDTO.getExpiry())
                .build();
    }

    private ShortURLDTO toShortURLDTO(ShortURL shortURL) {
        return ShortURLDTO.builder()
                .id(shortURL.getId())
                .createdAt(shortURL.getCreatedAt())
                .longURL(shortURL.getLongURL())
                .alias(shortURL.getAlias())
                .distributedId(shortURL.getDistributedId())
                .expiry(shortURL.getExpiry())
                .build();
    }
}
