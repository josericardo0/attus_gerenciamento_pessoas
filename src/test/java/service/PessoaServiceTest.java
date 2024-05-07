package service;

import exceptionshandler.PessoaNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import dto.PessoaDTO;
import mapper.PessoaMapper;
import model.Pessoa;
import repository.PessoaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private PessoaMapper pessoaMapper;

    @InjectMocks
    private PessoaService pessoaService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCriarPessoa() {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setNomeCompleto("Fulano de Tal");

        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNomeCompleto("Fulano de Tal");

        when(pessoaMapper.toEntity(any(PessoaDTO.class))).thenReturn(pessoa);
        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoa);
        when(pessoaMapper.toDTO(any(Pessoa.class))).thenReturn(pessoaDTO);

        PessoaDTO createdPessoa = pessoaService.criarPessoa(pessoaDTO);
        assertNotNull(createdPessoa);
        assertEquals("Fulano de Tal", createdPessoa.getNomeCompleto());
    }

    @Test
    void testEditarPessoa() {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setId(1L);
        pessoaDTO.setNomeCompleto("Beltrano de Tal");

        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNomeCompleto("Fulano de Tal");

        when(pessoaRepository.findById(anyLong())).thenReturn(Optional.of(pessoa));
        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoa);
        when(pessoaMapper.toDTO(any(Pessoa.class))).thenReturn(pessoaDTO);

        PessoaDTO editedPessoa = pessoaService.editarPessoa(1L, pessoaDTO);
        assertNotNull(editedPessoa);
        assertEquals("Beltrano de Tal", editedPessoa.getNomeCompleto());
    }

    @Test
    void testEditarPessoaPessoaNaoEncontrada() {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setId(1L);
        pessoaDTO.setNomeCompleto("Beltrano de Tal");

        when(pessoaRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(PessoaNotFoundException.class,
                () -> pessoaService.editarPessoa(1L, pessoaDTO));
    }

    @Test
    void testConsultarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNomeCompleto("Fulano de Tal");

        when(pessoaRepository.findById(anyLong())).thenReturn(Optional.of(pessoa));
        when(pessoaMapper.toDTO(any(Pessoa.class))).thenReturn(new PessoaDTO());

        PessoaDTO foundPessoa = pessoaService.consultarPessoa(1L);
        assertNotNull(foundPessoa);
    }

    @Test
    void testConsultarPessoaPessoaNaoEncontrada() {
        when(pessoaRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(PessoaNotFoundException.class,
                () -> pessoaService.consultarPessoa(1L));
    }

    @Test
    void testListarPessoas() {
        List<Pessoa> mockPessoas = Arrays.asList(new Pessoa(), new Pessoa());

        when(pessoaRepository.findAll()).thenReturn(mockPessoas);
        when(pessoaMapper.toDTO(any(Pessoa.class))).thenReturn(new PessoaDTO());

        List<PessoaDTO> pessoas = pessoaService.listarPessoas();
        assertFalse(pessoas.isEmpty());
        assertEquals(mockPessoas.size(), pessoas.size());
    }

    @Test
    void testExcluirPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);

        when(pessoaRepository.findById(anyLong())).thenReturn(Optional.of(pessoa));

        pessoaService.excluirPessoa(1L);

        verify(pessoaRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void testExcluirPessoaPessoaNaoEncontrada() {
        when(pessoaRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(PessoaNotFoundException.class,
                () -> pessoaService.excluirPessoa(1L));
    }
}
