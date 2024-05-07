package service;

import exceptionshandler.PessoaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dto.PessoaDTO;
import mapper.PessoaMapper;
import model.Pessoa;
import repository.PessoaRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaMapper pessoaMapper;

    @Transactional
    public PessoaDTO criarPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaMapper.toEntity(pessoaDTO);
        pessoa = pessoaRepository.save(pessoa);
        return pessoaMapper.toDTO(pessoa);
    }

    @Transactional
    public PessoaDTO editarPessoa(Long id, PessoaDTO pessoaDTO) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
        if (optionalPessoa.isPresent()) {
            Pessoa pessoa = optionalPessoa.get();
            pessoa.setNomeCompleto(pessoaDTO.getNomeCompleto());
            pessoa.setDataNascimento(pessoaDTO.getDataNascimento());
            pessoaRepository.save(pessoa);
            return pessoaMapper.toDTO(pessoa);
        } else {
            throw new PessoaNotFoundException("Pessoa não encontrada com ID: " + id);
        }
    }

    @Transactional(readOnly = true)
    public PessoaDTO consultarPessoa(Long id) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
        return optionalPessoa.map(pessoaMapper::toDTO).orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada com ID: " + id));
    }

    @Transactional(readOnly = true)
    public List<PessoaDTO> listarPessoas() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return pessoas.stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public void excluirPessoa(Long id) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
        if (optionalPessoa.isPresent()) {
            pessoaRepository.deleteById(id);
        } else {
            throw new PessoaNotFoundException("Pessoa não encontrada com ID: " + id);
        }
    }
}
