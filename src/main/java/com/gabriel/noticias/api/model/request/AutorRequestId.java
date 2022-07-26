package com.gabriel.noticias.api.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AutorRequestId {

    @NotNull
    private Long id;
}
