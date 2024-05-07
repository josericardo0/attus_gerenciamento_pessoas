package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dto.PessoaDTO;
import java.util.List;
import service.PessoaService;
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaDTO> criarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        PessoaDTO novaPessoa = pessoaService.criarPessoa(pessoaDTO);
        return new ResponseEntity<>(novaPessoa, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaDTO> editarPessoa(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) {
        PessoaDTO pessoaAtualizada = pessoaService.editarPessoa(id, pessoaDTO);
        return new ResponseEntity<>(pessoaAtualizada, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> consultarPessoa(@PathVariable Long id) {
        PessoaDTO pessoa = pessoaService.consultarPessoa(id);
        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> listarPessoas() {
        List<PessoaDTO> pessoas = pessoaService.listarPessoas();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPessoa(@PathVariable Long id) {
        pessoaService.excluirPessoa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
