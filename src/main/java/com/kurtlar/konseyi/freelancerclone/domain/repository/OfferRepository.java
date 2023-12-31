package com.kurtlar.konseyi.freelancerclone.domain.repository;

import com.kurtlar.konseyi.freelancerclone.domain.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer, String> {
    List<Offer> findAllByUserId(String userId);
    List<Offer> findAllByJobId(String jobId);
    Offer findByUserIdAndJobId(String userId, String jobId);
}
