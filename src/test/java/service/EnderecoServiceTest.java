package service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import dto.EnderecoDTO;
import exceptionshandler.PessoaNotFoundException;
import mapper.EnderecoMapper;
import model.Endereco;
import model.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.EnderecoRepository;
import repository.PessoaRepository;

@ExtendWith(MockitoExtension.class)
class EnderecoServiceTest {

    @Mock
    private EnderecoRepository enderecoRepository;

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private EnderecoMapper enderecoMapper;

    @InjectMocks
    private EnderecoService enderecoService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCriarEndereco() {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setLogradouro("Rua Teste");
        enderecoDTO.setCep("12345678");

        Endereco endereco = new Endereco();
        endereco.setId(1L);
        endereco.setLogradouro("Rua Teste");
        endereco.setCep("12345678");

        when(pessoaRepository.findById(anyLong())).thenReturn(Optional.of(new Pessoa()));
        when(enderecoMapper.toEntity(any(EnderecoDTO.class))).thenReturn(endereco);
        when(enderecoRepository.save(any(Endereco.class))).thenReturn(endereco);
        when(enderecoMapper.toDTO(any(Endereco.class))).thenReturn(enderecoDTO);

        EnderecoDTO createdEndereco = enderecoService.criarEndereco(1L, enderecoDTO);
        assertNotNull(createdEndereco);
        assertEquals("Rua Teste", createdEndereco.getLogradouro());
        assertEquals("12345678", createdEndereco.getCep());
    }

    @Test
    void testEditarEndereco() {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setLogradouro("Rua Teste Editada");
        enderecoDTO.setCep("87654321");

        Endereco endereco = new Endereco();
        endereco.setId(1L);
        endereco.setLogradouro("Rua Teste");
        endereco.setCep("12345678");

        when(enderecoRepository.findById(anyLong())).thenReturn(Optional.of(endereco));
        when(enderecoRepository.save(any(Endereco.class))).thenReturn(endereco);
        when(enderecoMapper.toDTO(any(Endereco.class))).thenReturn(enderecoDTO);

        EnderecoDTO editedEndereco = enderecoService.editarEndereco(1L, enderecoDTO);
        assertNotNull(editedEndereco);
        assertEquals("Rua Teste Editada", editedEndereco.getLogradouro());
        assertEquals("87654321", editedEndereco.getCep());
    }

    @Test
    void testConsultarEndereco() {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setLogradouro("Rua Teste");
        enderecoDTO.setCep("12345678");

        Endereco endereco = new Endereco();
        endereco.setId(1L);
        endereco.setLogradouro("Rua Teste");
        endereco.setCep("12345678");

        when(enderecoRepository.findById(anyLong())).thenReturn(Optional.of(endereco));
        when(enderecoMapper.toDTO(any(Endereco.class))).thenReturn(enderecoDTO);

        EnderecoDTO foundEndereco = enderecoService.consultarEndereco(1L);
        assertNotNull(foundEndereco);
        assertEquals("Rua Teste", foundEndereco.getLogradouro());
        assertEquals("12345678", foundEndereco.getCep());
    }

    @Test
    void testDefinirEnderecoPrincipal() {
        assertThrows(PessoaNotFoundException.class,
                () -> enderecoService.definirEnderecoPrincipal(1L, 1L));
    }


}
