package com.kurtlar.konseyi.freelancerclone.library.utils;

import org.springframework.data.domain.Sort;

public class GenerateSort {
    public static Sort createSort(String sortBy, String sortDir) {
        // Eğer sortBy veya sortDir null ise, Constants sınıfındaki varsayılan değerleri kullan
        String sortField = sortBy != null && !sortBy.isEmpty() ? sortBy : Constants.DEFAULT_SORT_BY;
        String sortDirection = sortDir != null && !sortDir.isEmpty() ? sortDir : Constants.DEFAULT_SORT_DIRECTION;

        // Sort nesnesini oluştur ve dön
        return sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
    }
}
