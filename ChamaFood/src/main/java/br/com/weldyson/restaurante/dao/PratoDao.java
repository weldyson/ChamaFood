package br.com.weldyson.restaurante.dao;

import br.com.weldyson.restaurante.entity.Prato;

import javax.persistence.EntityManager;

public class PratoDao {

    private EntityManager entityManager;

    public PratoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

         /*
        CRUD
        C = CREAT
        R= READ
        U= UPDATE
        D= DELETE
         */


    public void cadastrar(final Prato prato) {
        this.entityManager.persist(prato);

        System.out.println("Entidade cadastrada: " + prato);


    }

    public Prato consultar(final Integer id) {
        return this.entityManager.find(Prato.class, id);

    }

    public void atualizar(final  Prato prato){
        this.entityManager.merge(prato);
    }
    public void excluir(final Prato prato){
        this.entityManager.remove(prato);
    }

}
