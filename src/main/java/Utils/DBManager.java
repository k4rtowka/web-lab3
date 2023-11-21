package Utils;

import model.Dot;
import javax.enterprise.inject.Model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Model
public class DBManager implements Serializable {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Data");

    EntityManager entityManager = entityManagerFactory.createEntityManager();



    //Добавить точку в БД
    public boolean addPoint(Dot dot){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(dot);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    //Получение 50 точек из БД
    public List<Dot> getPoints(){
//        try {
            EntityTransaction transition = entityManager.getTransaction();
            transition.begin();
            //entityManager.getTransaction().begin();
            List<Dot> dotList = entityManager.createQuery("SELECT dote FROM Dot dote", Dot.class)
                    .setMaxResults(50)
                    .getResultList();
            transition.commit();
            return dotList;
//        }catch (Exception e){
//            return new ArrayList<Dot>();
//        }
    }

}