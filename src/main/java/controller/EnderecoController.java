package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dto.EnderecoDTO;
import service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/{pessoaId}")
    public ResponseEntity<EnderecoDTO> criarEndereco(@PathVariable Long pessoaId, @RequestBody EnderecoDTO enderecoDTO) {
        EnderecoDTO novoEndereco = enderecoService.criarEndereco(pessoaId, enderecoDTO);
        return new ResponseEntity<>(novoEndereco, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> editarEndereco(@PathVariable Long id, @RequestBody EnderecoDTO enderecoDTO) {
        EnderecoDTO enderecoAtualizado = enderecoService.editarEndereco(id, enderecoDTO);
        return new ResponseEntity<>(enderecoAtualizado, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> consultarEndereco(@PathVariable Long id) {
        EnderecoDTO endereco = enderecoService.consultarEndereco(id);
        return new ResponseEntity<>(endereco, HttpStatus.OK);
    }

    @PostMapping("/principal/{pessoaId}/{enderecoId}")
    public ResponseEntity<Void> definirEnderecoPrincipal(@PathVariable Long pessoaId, @PathVariable Long enderecoId) {
        enderecoService.definirEnderecoPrincipal(pessoaId, enderecoId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
