package br.com.weldyson.restaurante.dao;

import br.com.weldyson.restaurante.entity.Cardapio;

import javax.persistence.EntityManager;

public class CardapioDao {

    private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

         /*
        CRUD
        C = CREAT
        R= READ
        U= UPDATE
        D= DELETE
         */


    public void cadastrar(final Cardapio cardapio) {
        this.entityManager.persist(cardapio);



    }

    public Cardapio consultar(final Integer id) {
        return this.entityManager.find(Cardapio.class, id);

    }

    public void atualizar(final Cardapio cardapio){
        this.entityManager.merge(cardapio);
    }
    public void excluir(final Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }

}
