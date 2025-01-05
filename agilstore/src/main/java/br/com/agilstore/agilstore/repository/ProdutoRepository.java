package br.com.agilstore.agilstore.repository;

import br.com.agilstore.agilstore.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findByNomeContainingIgnoreCase(String nome);
}
