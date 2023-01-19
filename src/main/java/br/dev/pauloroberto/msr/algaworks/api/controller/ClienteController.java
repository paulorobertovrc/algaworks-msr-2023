package br.dev.pauloroberto.msr.algaworks.api.controller;

import br.dev.pauloroberto.msr.algaworks.domain.model.Cliente;
import br.dev.pauloroberto.msr.algaworks.domain.repository.ClienteRepository;
import br.dev.pauloroberto.msr.algaworks.domain.service.CatalogoClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {
//    @PersistenceContext
//    private EntityManager entityManager;

    private ClienteRepository clienteRepository;
    private CatalogoClienteService catalogoClienteService;

    @GetMapping
    public List<Cliente> listar() {
//        return entityManager.createQuery("from Cliente", Cliente.class)
//                .getResultList();

        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()
                );

    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@RequestBody @Valid Cliente cliente) {
//        return clienteRepository.save(cliente);
        return catalogoClienteService.salvar(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable @Valid Long id, @RequestBody Cliente cliente) {
        if (!clienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        cliente.setId(id);
//        cliente = clienteRepository.save(cliente);
        cliente = catalogoClienteService.salvar(cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (!clienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

//        clienteRepository.deleteById(id);
        catalogoClienteService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
