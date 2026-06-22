package com.mani.securebank.repository;

import com.mani.securebank.entity.AppUser;
import com.mani.securebank.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByToken(String token);

    @Modifying
    @Query("""
       update RefreshToken rt
       set rt.revoked = true
       where rt.user = :user
       """)
    void revokeAllTokensByUser(AppUser user);

    void deleteByToken(String token);

    void deleteByUser(AppUser user);
}
