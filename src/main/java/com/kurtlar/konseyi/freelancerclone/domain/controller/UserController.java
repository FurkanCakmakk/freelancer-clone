package com.kurtlar.konseyi.freelancerclone.domain.controller;

import com.kurtlar.konseyi.freelancerclone.domain.controller.mapper.UserMapper;
import com.kurtlar.konseyi.freelancerclone.domain.request.TcDogrulaRequest;
import com.kurtlar.konseyi.freelancerclone.domain.request.UserRequest;
import com.kurtlar.konseyi.freelancerclone.domain.response.TcDogrulaResponse;
import com.kurtlar.konseyi.freelancerclone.domain.response.UserResponse;
import com.kurtlar.konseyi.freelancerclone.domain.service.UserService;
import com.kurtlar.konseyi.freelancerclone.library.rest.*;
import com.kurtlar.konseyi.freelancerclone.library.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
@CrossOrigin

public class UserController extends BaseController {

    private final UserService service;

    @GetMapping("/{TCKimlikNo}/{Ad}/{Soyad}/{DogumYili}")
    public TcDogrulaResponse validateUser(@PathVariable String TCKimlikNo,
                                          @PathVariable String Ad,
                                          @PathVariable String Soyad,
                                          @PathVariable String DogumYili) {
        return service.validateUser(TCKimlikNo,  Ad, Soyad,DogumYili);
    }

    @PostMapping
    @PreAuthorize("hasRole('SUPER_ADMIN' )")
    public Response<UserResponse> createUser(@RequestBody UserRequest request) {
        return respond(UserMapper.toResponse(service.save(UserMapper.toDto(request))));
    }

    @GetMapping("/{id}")

    public Response<UserResponse> getUserById(@PathVariable String id) {
        return respond(UserMapper.toResponse(service.getById(id)));
    }


    @GetMapping("/get-all-with-page-and-sorting")
    public Response<PageResponse<UserResponse>> getAllUsersByPaginationAndSortingWithQuery(
            @RequestParam(value = "pageNumber", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) String pageNumber,
            @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) String pageSize,
            @RequestParam(value = "sortBy", defaultValue = Constants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Constants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return respond(service.getAll(pageNumber, pageSize, sortBy, sortDir).map(dto -> UserMapper.toResponse(dto)));
    }

    @GetMapping
    public Response<DataResponse<UserResponse>> getAllUsers() {
        return respond(service.getAll().stream().map(UserMapper::toResponse).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public Response<UserResponse> updateUser(@PathVariable String id, @RequestBody UserRequest request) {
        return respond(UserMapper.toResponse(service.update(id, UserMapper.toDto(request))));
    }

    @DeleteMapping("/{id}")
    public Response<Void> deleteUserById(@PathVariable String id) {
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }

    @GetMapping("/get-metamask-address/{userId}")
    public String getMetamaskAddress(@PathVariable String userId){
        return service.getUserMetamaskAddress(userId);
    }


}
