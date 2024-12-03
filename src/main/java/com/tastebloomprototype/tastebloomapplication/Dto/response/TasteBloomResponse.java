package com.tastebloomprototype.tastebloomapplication.Dto.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TasteBloomResponse {
    private String responseCode;
    private String responseMessage;
   ;
}
