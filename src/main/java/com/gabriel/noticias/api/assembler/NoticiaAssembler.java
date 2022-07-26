package com.gabriel.noticias.api.assembler;

import com.gabriel.noticias.api.model.NoticiaModel;
import com.gabriel.noticias.api.model.request.NoticiaRequest;
import com.gabriel.noticias.domain.model.Noticia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class NoticiaAssembler {

    private ModelMapper modelMapper;

    public NoticiaModel toModel(Noticia noticia) {
        return modelMapper.map(noticia, NoticiaModel.class);
    }

    public List<NoticiaModel> toCollectionModel (List<Noticia> noticias) {
        return noticias.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Noticia toEntity(NoticiaRequest noticiaRequest) {
        return modelMapper.map(noticiaRequest, Noticia.class);
    }


}
