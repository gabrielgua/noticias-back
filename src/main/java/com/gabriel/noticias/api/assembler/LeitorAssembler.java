package com.gabriel.noticias.api.assembler;

import com.gabriel.noticias.api.model.LeitorModel;
import com.gabriel.noticias.api.model.LeitorUpdateModel;
import com.gabriel.noticias.api.model.request.LeitorRequest;
import com.gabriel.noticias.domain.model.Leitor;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class LeitorAssembler {

    private ModelMapper modelMapper;

    public LeitorModel toModel(Leitor leitor) {
        return modelMapper.map(leitor, LeitorModel.class);
    }

    public List<LeitorModel> toCollectionModel(List<Leitor> leitores) {
        return leitores.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Leitor toEntity(LeitorRequest leitorRequest) {
        return modelMapper.map(leitorRequest, Leitor.class);
    }

    public LeitorUpdateModel toUpdateModel(Leitor leitor) {
        return modelMapper.map(leitor, LeitorUpdateModel.class);
    }
}
