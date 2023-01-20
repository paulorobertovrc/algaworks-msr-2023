package br.dev.pauloroberto.msr.algaworks.domain.repository;

import br.dev.pauloroberto.msr.algaworks.domain.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}
