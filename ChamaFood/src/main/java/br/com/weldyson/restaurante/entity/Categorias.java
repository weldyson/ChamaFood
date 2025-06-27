package br.com.weldyson.restaurante.entity;

import javax.persistence.*;

@Entity
@Table(name = "categorias")

public class Categorias {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String nome;

    public Categorias(){

    }
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    @Override
    public String toString() {
        return "Categorias{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
