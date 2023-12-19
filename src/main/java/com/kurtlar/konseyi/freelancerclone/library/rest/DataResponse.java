package com.kurtlar.konseyi.freelancerclone.library.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse<T> {
    private List<T> items = List.of();
    private Integer numberOfItems;
}
