package dev.otthon.dynamicpricing.repository;

import dev.otthon.dynamicpricing.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
