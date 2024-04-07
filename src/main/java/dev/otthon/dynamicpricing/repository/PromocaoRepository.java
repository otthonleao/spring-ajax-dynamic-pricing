package dev.otthon.dynamicpricing.repository;

import dev.otthon.dynamicpricing.domain.Promocao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromocaoRepository extends JpaRepository<Promocao, Long> {

}
