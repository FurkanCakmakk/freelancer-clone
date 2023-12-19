package com.kurtlar.konseyi.freelancerclone.library.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Response <T>{
    private T data;
    private MetaResponse meta;

    public Response(MetaResponse meta) {
        // Entity silme - Exception Senaryosu
            this.meta = meta;
    }

    public Response(T data) {
            this.data = data;
            this.meta = MetaResponse.success();
    }


}
