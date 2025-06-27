package br.com.weldyson.restaurante.dao;

import br.com.weldyson.restaurante.entity.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao {
    private EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

         /*
        CRUD
        C = CREAT
        R= READ
        U= UPDATE
        D= DELETE
         */


    public void cadastrar(final Categoria categoria) {
        this.entityManager.persist(categoria);


    }

    public Categoria consultar(final Integer id) {
        return this.entityManager.find(Categoria.class, id);

    }

    public void atualizar(final Categoria categoria) {
        this.entityManager.merge(categoria);
    }

    public void excluir(final Categoria categoria) {
        this.entityManager.remove(categoria);
    }
}
