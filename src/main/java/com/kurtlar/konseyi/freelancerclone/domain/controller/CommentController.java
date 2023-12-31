package com.kurtlar.konseyi.freelancerclone.domain.controller;

import com.kurtlar.konseyi.freelancerclone.domain.controller.mapper.CommentMapper;
import com.kurtlar.konseyi.freelancerclone.domain.controller.mapper.CommentMapper;
import com.kurtlar.konseyi.freelancerclone.domain.request.CommentRequest;
import com.kurtlar.konseyi.freelancerclone.domain.response.CommentResponse;
import com.kurtlar.konseyi.freelancerclone.domain.service.CommentService;
import com.kurtlar.konseyi.freelancerclone.library.rest.*;
import com.kurtlar.konseyi.freelancerclone.library.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("comments")
@RequiredArgsConstructor
@CrossOrigin

public class CommentController extends BaseController {
    private final CommentService commentService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<CommentResponse> createComment(@RequestBody CommentRequest request) {
        return respond(CommentMapper.toResponse(commentService.create(CommentMapper.toDto(request))));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<CommentResponse> getCommentById(@PathVariable String id) {
        return respond(CommentMapper.toResponse(commentService.getById(id)));
    }

    @GetMapping("/get-all-reviewed/{reviewedId}")
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<PageResponse<CommentResponse>> getAllCommentsByReviewed(
            @PathVariable String reviewedId,
            @RequestParam(value = "pageNumber", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) String pageNumber,
            @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) String pageSize,
            @RequestParam(value = "sortBy", defaultValue = Constants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Constants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return respond(commentService.getAllByReviewedId(reviewedId, pageNumber, pageSize, sortBy, sortDir).map(CommentMapper::toResponse));
    }

    @GetMapping("/get-all-reviewer/{reviewerId}")
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<DataResponse<CommentResponse>> getAllCommentsByReviewer(
            @PathVariable String reviewerId,
            @RequestParam(value = "pageNumber", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) String pageNumber,
            @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) String pageSize,
            @RequestParam(value = "sortBy", defaultValue = Constants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Constants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return respond(commentService.getAllByReviewerId(reviewerId, pageNumber, pageSize, sortBy, sortDir).stream().map(CommentMapper::toResponse).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<CommentResponse> updateComment(@PathVariable String id, @RequestBody CommentRequest request) {
        return respond(CommentMapper.toResponse(commentService.update(id, CommentMapper.toDto(request))));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN' , 'USER')")
    public Response<Void> deleteCommentById(@PathVariable String id) {
        commentService.delete(id);
        return new Response<>(MetaResponse.success());
    }


}
