package br.com.weldyson.restaurante.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class  JPAUtil {

        private static final EntityManagerFactory ChamaFood = Persistence.createEntityManagerFactory("ChamaFood");

        public static EntityManager getEntityManagerChamaFood(){
            return ChamaFood.createEntityManager();
        }





    }




