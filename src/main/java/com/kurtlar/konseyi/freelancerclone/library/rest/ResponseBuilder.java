package com.kurtlar.konseyi.freelancerclone.library.rest;

import org.springframework.data.domain.Page;

import java.util.List;

public class ResponseBuilder {
    public static <T> Response<DataResponse<T>> build(List<T> items) {
        return new Response<>(new DataResponse<>(items ,items.size()));
    }

    public static <T> Response<PageResponse<T>>  build(Page<T> items) {
        return new Response<>(new PageResponse<>(items));
    }

    public static <T> Response<T> build(T item) {
        return new Response<>(item);
    }

    public static <T> Response<MetaResponse> build(MetaResponse metaResponse){
        return new Response<>(metaResponse);
    }

}
