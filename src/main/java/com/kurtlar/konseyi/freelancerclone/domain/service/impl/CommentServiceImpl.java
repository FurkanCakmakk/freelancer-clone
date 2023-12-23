package com.kurtlar.konseyi.freelancerclone.domain.service.impl;

import com.kurtlar.konseyi.freelancerclone.domain.dto.CommentDto;
import com.kurtlar.konseyi.freelancerclone.domain.entity.Comment;
import com.kurtlar.konseyi.freelancerclone.domain.repository.CommentRepository;
import com.kurtlar.konseyi.freelancerclone.domain.service.CommentService;
import com.kurtlar.konseyi.freelancerclone.domain.service.UserService;
import com.kurtlar.konseyi.freelancerclone.domain.service.mapper.CommentMapper;
import com.kurtlar.konseyi.freelancerclone.library.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;
    private final UserService userService;

    @Override
    public CommentDto create(CommentDto commentDto) {
        return CommentMapper.toDto(repository.save(CommentMapper.toEntity(new Comment(), commentDto)), userService);
    }

    @Override
    public CommentDto getById(String id) {
        return CommentMapper.toDto(repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Comment.class.getSimpleName(), "id", id)
        ), userService);
    }

    @Override
    public CommentDto update(String id, CommentDto commentDto) {
        Comment comment = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Comment.class.getSimpleName(), "id", id)
        );
        return CommentMapper.toDto(repository.save(setComment(comment, commentDto)), userService);
    }

    @Override
    public void delete(String id) {
        var comment = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Comment.class.getSimpleName(), "id", id)

        );
        repository.delete(comment);
    }

    @Override
    public List<CommentDto> getAllByReviewerId(String reviewerId, String pageNumber, String pageSize, String sortBy, String sortDir) {
        return repository.findAll().stream().map(comment -> CommentMapper.toDto(comment, userService)).toList();
    }


    @Override
    public Page<CommentDto> getAllByReviewedId(String reviewedId, String pageNumber, String pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(Integer.parseInt(pageNumber), Integer.parseInt(pageSize), sort);

        return repository.findAll(pageable).map(comment -> CommentMapper.toDto(comment, userService));
    }

    private Comment setComment(Comment comment, CommentDto commentDto) {
        comment.setContent(commentDto.getContent());
        comment.setRating(commentDto.getRating());
        comment.setReviewedId(commentDto.getReviewed().getId());
        comment.setReviewerId(commentDto.getReviewer().getId());
        return comment;
    }
}
