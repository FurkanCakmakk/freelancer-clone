package com.kurtlar.konseyi.freelancerclone.domain.repository;

import com.kurtlar.konseyi.freelancerclone.domain.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment , String> {

    Page<Comment> getAllByReviewedId(String reviewedId, Pageable pageable);
    Page<Comment> getAllByReviewerId(String reviewerId, Pageable pageable);
}
