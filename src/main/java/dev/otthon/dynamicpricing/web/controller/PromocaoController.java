package dev.otthon.dynamicpricing.web.controller;

import dev.otthon.dynamicpricing.domain.Categoria;
import dev.otthon.dynamicpricing.domain.Promocao;
import dev.otthon.dynamicpricing.repository.CategoriaRepository;
import dev.otthon.dynamicpricing.repository.PromocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/promocao")
public class PromocaoController {

    private static Logger log = Logger.getLogger(PromocaoController.class.toString());

    @Autowired
    private PromocaoRepository promocaoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping("/save")
    public ResponseEntity<Promocao> salvarPromocao(Promocao promocao) {
        log.info("Promocao {}");
        promocao.setDtCadastro(LocalDateTime.now());
        promocaoRepository.save(promocao);

        return ResponseEntity.ok().build();
    }

    @ModelAttribute("categorias")
    public List<Categoria> getCategorias() {
        return categoriaRepository.findAll();
    }

    @GetMapping("/add")
    public String abrirCadastro() {
        return "promo-add";
    }

}
