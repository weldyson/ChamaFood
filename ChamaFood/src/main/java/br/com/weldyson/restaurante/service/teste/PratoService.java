package br.com.weldyson.restaurante.service.teste;

import br.com.weldyson.restaurante.dao.PratoDao;
import br.com.weldyson.restaurante.entity.Prato;
import br.com.weldyson.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class PratoService {
    public static void main(String[] args) {
        Prato risoto = new Prato();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompnhado de lula, polvo e camarão");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));


        EntityManager entityManager = JPAUtil.getEntityManagerChamaFood();
        PratoDao pratoDao = new PratoDao(entityManager);
        entityManager.getTransaction().begin();
        pratoDao.cadastrar(risoto);
        entityManager.persist(risoto);
        entityManager.getTransaction().commit();
        entityManager.close();


    }

}
