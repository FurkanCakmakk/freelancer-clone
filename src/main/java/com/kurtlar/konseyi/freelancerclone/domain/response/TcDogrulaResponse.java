package com.kurtlar.konseyi.freelancerclone.domain.response;

import lombok.*;


public class TcDogrulaResponse {
    private boolean TCKimlikNoDogrulaResult;

    public TcDogrulaResponse(boolean TCKimlikNoDogrulaResult) {
        this.TCKimlikNoDogrulaResult = TCKimlikNoDogrulaResult;
    }

    public TcDogrulaResponse(){

    }

    // Getter ve setter metodları
    public boolean isTCKimlikNoDogrulaResult() {
        return TCKimlikNoDogrulaResult;
    }

    public void setTCKimlikNoDogrulaResult(boolean TCKimlikNoDogrulaResult) {
        this.TCKimlikNoDogrulaResult = TCKimlikNoDogrulaResult;
    }

    // toString metodu, loglama ve debug için faydalı olabilir
    @Override
    public String toString() {
        return "TcDogrulaResponse{" +
                "TCKimlikNoDogrulaResult=" + TCKimlikNoDogrulaResult +
                '}';
    }
}
