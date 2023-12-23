package com.kurtlar.konseyi.freelancerclone.domain.service;

import com.kurtlar.konseyi.freelancerclone.domain.dto.CommentDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CommentService {
    CommentDto create(CommentDto commentDto);
    CommentDto getById(String id);
    CommentDto update(String id, CommentDto commentDto);
    void delete(String id);
    List<CommentDto> getAllByReviewerId(String reviewerId , String pageNumber, String pageSize , String  sortBy , String sortDir);
    Page<CommentDto> getAllByReviewedId(String reviewedId,String pageNumber, String pageSize , String  sortBy , String sortDir);

}
