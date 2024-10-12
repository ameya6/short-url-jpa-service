package org.url.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.url.model.ShortURL;

import java.util.UUID;

public interface ShortURLRepository extends JpaRepository<ShortURL, UUID> {
    ShortURL findByAlias(String alias);
}
