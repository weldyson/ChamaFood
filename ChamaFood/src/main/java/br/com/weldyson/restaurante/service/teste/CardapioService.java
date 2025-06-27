package br.com.weldyson.restaurante.service.teste;

import br.com.weldyson.restaurante.dao.CardapioDao;
import br.com.weldyson.restaurante.dao.CategoriaDao;
import br.com.weldyson.restaurante.entity.Cardapio;
import br.com.weldyson.restaurante.entity.Categoria;
import br.com.weldyson.restaurante.util.JPAUtil;


import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerChamaFood();
        cadastrasProdutoCardapio(entityManager,cadastrarCategoria(entityManager));
    }

    private static Categoria cadastrarCategoria(EntityManager entityManager){
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        Categoria pratoPrincipal = new Categoria("Prato principal");
        entityManager.getTransaction().begin();
        categoriaDao.cadastrar(pratoPrincipal);
        entityManager.getTransaction().commit();
        entityManager.clear();
        return pratoPrincipal;

    }



    private static void cadastrasProdutoCardapio(EntityManager entityManager, Categoria categoria) {
        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompnhado de lula, polvo e camarão");
        risoto.setDisponivel(true);
        risoto.setCategoria(categoria);
        risoto.setValor(BigDecimal.valueOf(88.50));

        Cardapio lasanha = new Cardapio();
        lasanha.setNome("Lasanha de frango");
        lasanha.setDescricao("Lasanha de frango suculenta com queijo catupiry");
        lasanha.setDisponivel(true);
        lasanha.setCategoria(categoria);

        lasanha.setValor(BigDecimal.valueOf(60.00));


        CardapioDao cardapioDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin();

        cardapioDao.cadastrar(risoto);
        entityManager.flush();
        cardapioDao.cadastrar(lasanha);
        entityManager.flush();
  //      System.out.println("O prato consultado foi: " + cardapioDao.consultarPorId(1));
 //       System.out.println("O prato consultado foi: " + cardapioDao.consultarPorId(2));

        cardapioDao.consultarTodos().forEach(elemento-> System.out.println("O prato consultado foi: "+elemento));

        entityManager.close();

    }

}
