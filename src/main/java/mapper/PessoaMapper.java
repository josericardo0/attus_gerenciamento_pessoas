package mapper;

import dto.PessoaDTO;
import model.Pessoa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {
    @Autowired
    private ModelMapper modelMapper;

    public PessoaDTO toDTO(Pessoa pessoa) {
        return modelMapper.map(pessoa, PessoaDTO.class);
    }

    public Pessoa toEntity(PessoaDTO pessoaDTO) {
        return modelMapper.map(pessoaDTO, Pessoa.class);
    }
}