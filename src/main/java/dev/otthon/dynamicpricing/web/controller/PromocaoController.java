package dev.otthon.dynamicpricing.web.controller;

import dev.otthon.dynamicpricing.domain.Categoria;
import dev.otthon.dynamicpricing.domain.Promocao;
import dev.otthon.dynamicpricing.repository.CategoriaRepository;
import dev.otthon.dynamicpricing.repository.PromocaoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public ResponseEntity<?> salvarPromocao(@Valid Promocao promocao, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            // Retornando Status Code 422
            return ResponseEntity.unprocessableEntity().body(errors);
        }

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
