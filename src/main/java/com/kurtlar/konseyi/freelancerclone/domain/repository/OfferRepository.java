package com.kurtlar.konseyi.freelancerclone.domain.repository;

import com.kurtlar.konseyi.freelancerclone.domain.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, String> {
    List<Offer> findAllByUserId(String userId);

    List<Offer> findAllByJobId(String jobId);
}
