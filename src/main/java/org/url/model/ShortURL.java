package org.url.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "short_url")
public class ShortURL {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expiry", nullable = false)
    private LocalDateTime expiry;

    @Column(name = "distributed_id", nullable = false, unique = true)
    private Long distributedId;

    @Column(name = "long_url")
    private String longURL;

    @Column(name = "alias", nullable = false, unique = true)
    private String alias;

    @Override
    public String toString() {
        return "ShortURL{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", expiry=" + expiry +
                ", distributedId=" + distributedId +
                ", longURL='" + longURL + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }
}
