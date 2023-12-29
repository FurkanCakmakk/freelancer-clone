package com.kurtlar.konseyi.freelancerclone.library.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


public class CreatePageable {


    public static Pageable createPageable(String pageNumber, String pageSize, Sort sort) {
        int page = Integer.parseInt(pageNumber);
        int size = Integer.parseInt(pageSize);
        return PageRequest.of(page, size, sort);
    }
}
