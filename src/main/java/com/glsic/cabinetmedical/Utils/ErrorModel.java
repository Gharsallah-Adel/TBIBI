package com.glsic.cabinetmedical.Utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorModel {
    private String message ;
    public ErrorModel(String message){
        this.message=message ;
    }

}
