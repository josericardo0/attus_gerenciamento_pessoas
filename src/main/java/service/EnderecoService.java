package service;

import exceptionshandler.EnderecoNotFoundException;
import exceptionshandler.PessoaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dto.EnderecoDTO;
import mapper.EnderecoMapper;
import model.Endereco;
import model.Pessoa;
import repository.EnderecoRepository;
import repository.PessoaRepository;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoMapper enderecoMapper;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional
    public EnderecoDTO criarEndereco(Long pessoaId, EnderecoDTO enderecoDTO) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(pessoaId);
        if (optionalPessoa.isPresent()) {
            Endereco endereco = enderecoMapper.toEntity(enderecoDTO);
            endereco.setPessoa(optionalPessoa.get());
            endereco = enderecoRepository.save(endereco);
            return enderecoMapper.toDTO(endereco);
        } else {
            throw new PessoaNotFoundException("Pessoa não encontrada com ID: " + pessoaId);
        }
    }

    @Transactional
    public EnderecoDTO editarEndereco(Long enderecoId, EnderecoDTO enderecoDTO) {
        Optional<Endereco> optionalEndereco = enderecoRepository.findById(enderecoId);
        if (optionalEndereco.isPresent()) {
            Endereco endereco = optionalEndereco.get();
            endereco.setLogradouro(enderecoDTO.getLogradouro());
            endereco.setCep(enderecoDTO.getCep());
            endereco.setNumero(enderecoDTO.getNumero());
            endereco.setCidade(enderecoDTO.getCidade());
            endereco.setEstado(enderecoDTO.getEstado());
            enderecoRepository.save(endereco);
            return enderecoMapper.toDTO(endereco);
        } else {
            throw new EnderecoNotFoundException("Endereço não encontrado com ID: " + enderecoId);
        }
    }

    @Transactional(readOnly = true)
    public EnderecoDTO consultarEndereco(Long enderecoId) {
        Optional<Endereco> optionalEndereco = enderecoRepository.findById(enderecoId);
        return optionalEndereco.map(enderecoMapper::toDTO).orElseThrow(() -> new EnderecoNotFoundException("Endereço não encontrado com ID: " + enderecoId));
    }

    @Transactional
    public void definirEnderecoPrincipal(Long pessoaId, Long enderecoId) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(pessoaId);
        if (optionalPessoa.isPresent()) {
            Optional<Endereco> optionalEndereco = enderecoRepository.findById(enderecoId);
            if (optionalEndereco.isPresent()) {
                optionalPessoa.get().setEnderecoPrincipal(optionalEndereco.get());
            } else {
                throw new EnderecoNotFoundException("Endereço não encontrado com ID: " + enderecoId);
            }
        } else {
            throw new PessoaNotFoundException("Pessoa não encontrada com ID: " + pessoaId);
        }
    }
}
