package mapper;

import dto.PessoaDTO;
import model.Pessoa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {
    @Autowired
    private final ModelMapper modelMapper;

    public PessoaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PessoaDTO toDTO(Pessoa pessoa) {
        return modelMapper.map(pessoa, PessoaDTO.class);
    }

    public Pessoa toEntity(PessoaDTO pessoaDTO) {
        return modelMapper.map(pessoaDTO, Pessoa.class);
    }
}