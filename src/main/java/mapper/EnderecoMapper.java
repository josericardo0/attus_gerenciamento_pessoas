package mapper;

import dto.EnderecoDTO;
import model.Endereco;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {
    @Autowired
    private final ModelMapper modelMapper;

    public EnderecoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public EnderecoDTO toDTO(Endereco endereco) {
        return modelMapper.map(endereco, EnderecoDTO.class);
    }

    public Endereco toEntity(EnderecoDTO enderecoDTO) {
        return modelMapper.map(enderecoDTO, Endereco.class);
    }
}