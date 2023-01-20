package br.dev.pauloroberto.msr.algaworks.api.assembler;

import br.dev.pauloroberto.msr.algaworks.api.model.OcorrenciaDto;
import br.dev.pauloroberto.msr.algaworks.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class OcorrenciaAssembler {
    private ModelMapper modelMapper;

    public OcorrenciaDto toModel(Ocorrencia ocorrencia) {
        return modelMapper.map(ocorrencia, OcorrenciaDto.class);
    }

    public List<OcorrenciaDto> toCollectionModel(List<Ocorrencia> ocorrencias) {
        return ocorrencias.stream()
                .map(this::toModel)
                .toList();
    }
}
