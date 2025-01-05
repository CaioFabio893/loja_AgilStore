package br.com.agilstore.agilstore.model;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoCategoria tipo;

    private int quantidadeEmEstoque;

    private Double preco;

    public Produto(){}

    public Produto(String nome, TipoCategoria tipo, double preco, int quantidadeEmEstoque) {
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCategoria getTipo() {
        return tipo;
    }

    public void setTipo(TipoCategoria tipo) {
        this.tipo = tipo;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "id = " + id +
                ", Categoria = '" + tipo + '\'' +
                ", Quantidade no estoque = " + quantidadeEmEstoque +
                ", Preco = " + preco;
    }
}

