package br.dev.pauloroberto.msr.algaworks.controller;

import br.dev.pauloroberto.msr.algaworks.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        var cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Paulo Roberto");
        cliente1.setEmail("paulo@teste.com");
        cliente1.setTelefone("999999999");

        var cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Maria");
        cliente2.setEmail("maria@teste.com.br");
        cliente2.setTelefone("888888888");

        return List.of(cliente1, cliente2);
    }
}
