package com.mani.securebank.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "refresh_tokens")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String token;

    @Column(nullable = false)
    private boolean revoked;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;
}
