package com.kurtlar.konseyi.freelancerclone.domain.request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TcDogrulaRequest {
    private String TCKimlikNo;
    private String Ad;
    private String Soyad;
    private String DogumYili;
}
