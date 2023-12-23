package com.kurtlar.konseyi.freelancerclone.domain.repository;

import com.kurtlar.konseyi.freelancerclone.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment , String> {
}
