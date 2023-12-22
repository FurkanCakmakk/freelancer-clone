package com.kurtlar.konseyi.freelancerclone.domain.controller;

import com.kurtlar.konseyi.freelancerclone.domain.controller.mapper.UserMapper;
import com.kurtlar.konseyi.freelancerclone.domain.request.UserRequest;
import com.kurtlar.konseyi.freelancerclone.domain.response.UserResponse;
import com.kurtlar.konseyi.freelancerclone.domain.service.UserService;
import com.kurtlar.konseyi.freelancerclone.library.rest.BaseController;
import com.kurtlar.konseyi.freelancerclone.library.rest.MetaResponse;
import com.kurtlar.konseyi.freelancerclone.library.rest.PageResponse;
import com.kurtlar.konseyi.freelancerclone.library.rest.Response;
import com.kurtlar.konseyi.freelancerclone.library.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController extends BaseController {

    private final UserService service;

    @PostMapping
    public Response<UserResponse> createTodo(@RequestBody UserRequest request) {
        return respond(UserMapper.toResponse(service.save(UserMapper.toDto(request))));
    }

    @GetMapping("/{id}")
    public Response<UserResponse> getUserById(@PathVariable String id) {
        return respond(UserMapper.toResponse(service.getById(id)));
    }


    @GetMapping("/get-all-with-page-and-sorting")
    public Response<PageResponse<UserResponse>> getAllTodosByPaginationAndSortingWithQuery(
            @RequestParam(value = "pageNumber", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) String pageNumber,
            @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) String pageSize,
            @RequestParam(value = "sortBy", defaultValue = Constants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir" , defaultValue = Constants.DEFAULT_SORT_DIRECTION , required = false) String sortDir
    ) {
        return respond(service.getAll(pageNumber , pageSize,sortBy , sortDir).map(dto -> UserMapper.toResponse(dto)));
    }

    @PutMapping("/{id}")
    public Response<UserResponse> updateTodo(@PathVariable String id, @RequestBody UserRequest request) {
        return respond(UserMapper.toResponse(service.update(id, UserMapper.toDto(request))));
    }

    @DeleteMapping("/{id}")
    public Response<Void> deleteTodoById(@PathVariable String id) {
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }



}
