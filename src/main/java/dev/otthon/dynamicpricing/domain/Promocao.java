package dev.otthon.dynamicpricing.domain;

import jakarta.persistence.*;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@SuppressWarnings("serial")
@Entity
@Table(name = "promocoes")
public class Promocao implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="titulo", nullable = false)
    private String titulo;

    @Column(name="link_promocao", nullable = false)
    private String link_promocao;

    @Column(name="site_promocao", nullable = false)
    private String site_promocao;

    @Column(name="descricao", nullable = false)
    private String descricao;

    @Column(name="link_imagem", nullable = false)
    private String link_imagem;

    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    @Column(name = "preco_promocao", nullable = false)
    private BigDecimal preco;

    @Column(name = "total_likes")
    private int likes;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dtCadastro;

    @ManyToOne()
    @JoinColumn(name = "categoria_fk")
    private Categoria categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLink_promocao() {
        return link_promocao;
    }

    public void setLink_promocao(String link_promocao) {
        this.link_promocao = link_promocao;
    }

    public String getSite_promocao() {
        return site_promocao;
    }

    public void setSite_promocao(String site_promocao) {
        this.site_promocao = site_promocao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLink_imagem() {
        return link_imagem;
    }

    public void setLink_imagem(String link_imagem) {
        this.link_imagem = link_imagem;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public LocalDateTime getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(LocalDateTime dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Promocao promocao = (Promocao) o;
        return likes == promocao.likes && Objects.equals(id, promocao.id) && Objects.equals(titulo, promocao.titulo) && Objects.equals(link_promocao, promocao.link_promocao) && Objects.equals(site_promocao, promocao.site_promocao) && Objects.equals(descricao, promocao.descricao) && Objects.equals(link_imagem, promocao.link_imagem) && Objects.equals(preco, promocao.preco) && Objects.equals(dtCadastro, promocao.dtCadastro) && Objects.equals(categoria, promocao.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, link_promocao, site_promocao, descricao, link_imagem, preco, likes, dtCadastro, categoria);
    }

    @Override
    public String toString() {
        return "Promocao{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", link_promocao='" + link_promocao + '\'' +
                ", site_promocao='" + site_promocao + '\'' +
                ", descricao='" + descricao + '\'' +
                ", link_imagem='" + link_imagem + '\'' +
                ", preco=" + preco +
                ", likes=" + likes +
                ", dtCadastro=" + dtCadastro +
                ", categoria=" + categoria +
                '}';
    }
}
