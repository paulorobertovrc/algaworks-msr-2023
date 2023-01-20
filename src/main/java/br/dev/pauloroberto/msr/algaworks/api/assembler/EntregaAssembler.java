package br.dev.pauloroberto.msr.algaworks.api.assembler;

import br.dev.pauloroberto.msr.algaworks.api.model.EntregaDto;
import br.dev.pauloroberto.msr.algaworks.api.model.request.EntregaRequestDto;
import br.dev.pauloroberto.msr.algaworks.domain.model.Entrega;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class EntregaAssembler {
    private ModelMapper modelMapper;

    public EntregaDto toModel(Entrega entrega) {
        return modelMapper.map(entrega, EntregaDto.class);
    }

    public List<EntregaDto> toCollectionModel(List<Entrega> entregas) {
        return entregas.stream()
                .map(this::toModel)
                .toList();
    }

    public Entrega toEntity(EntregaRequestDto entregaRequestDto) {
        return modelMapper.map(entregaRequestDto, Entrega.class);
    }
}
