package com.gabriel.noticias.api.assembler;

import com.gabriel.noticias.api.model.AutorModel;
import com.gabriel.noticias.api.model.AutorUpdateModel;
import com.gabriel.noticias.api.model.request.AutorRequest;
import com.gabriel.noticias.domain.model.Autor;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AutorAssembler {

    private ModelMapper modelMapper;

    public AutorModel toModel(Autor autor) {
        return modelMapper.map(autor, AutorModel.class);
    }

    public List<AutorModel> toCollectionModel(List<Autor> autores) {
        return autores.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Autor toEntity(AutorRequest autorRequest) {
        return modelMapper.map(autorRequest, Autor.class);
    }

    public AutorUpdateModel toUpdateModel(Autor autor) {
        return modelMapper.map(autor, AutorUpdateModel.class);
    }
}
