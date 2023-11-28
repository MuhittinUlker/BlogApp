package com.muhittinu.blogapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ErrorType {
    PARAMETRE_EKSIK(2001,"Parametreler eksik girildi",HttpStatus.BAD_REQUEST),
    PARAMETRELER_YANLIS(2002,"Email veya Sifre Hatali",HttpStatus.BAD_REQUEST),
    KULLANICI_BULUNAMADI(1001,"Boyle bir kullanici sistemde kayitli degil",HttpStatus.NOT_FOUND),
    KULLANICI_ZATEN_KAYITLI(1002,"Bu mail adresi ile kayitli bir kullanici var",HttpStatus.FOUND),
    POST_BULUNAMADI(1101,"Boyle bir post sistemde kayitli degil",HttpStatus.NOT_FOUND),
    CATEGORY_BULUNAMADI(1201,"Boyle bir kategori sistemde kayitli degil",HttpStatus.NOT_FOUND);
    private int code;
    private String message;
    private HttpStatus httpStatus;
}
