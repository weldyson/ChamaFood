package br.com.weldyson.restaurante.service.teste;

import br.com.weldyson.restaurante.dao.CardapioDao;
import br.com.weldyson.restaurante.entity.Cardapio;
import br.com.weldyson.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {

        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompnhado de lula, polvo e camarão");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));

        Cardapio lasanha = new Cardapio();
        lasanha.setNome("Lasanha de frango");
        lasanha.setDescricao("Lasanha de frango suculenta com queijo catupiry");
        lasanha.setDisponivel(true);
        lasanha.setValor(BigDecimal.valueOf(60.00));



        EntityManager entityManager = JPAUtil.getEntityManagerChamaFood();
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin();
        cardapioDao.cadastrar(risoto);
        entityManager.flush();
        cardapioDao.cadastrar(lasanha);
        entityManager.flush();
        System.out.println("O prato consultado foi: "+ cardapioDao.consultar(1));

        cardapioDao.excluir((lasanha));
        System.out.println("O prato consultado foi: "+ cardapioDao.consultar(2));

        entityManager.clear();
        risoto.setValor(BigDecimal.valueOf(75.50));
        cardapioDao.atualizar(risoto);
        System.out.println("O prato consutado foi: "+ cardapioDao.consultar(1));
    }
}
