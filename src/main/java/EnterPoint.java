import DAO.UserEntity;
import Hibernate.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class EnterPoint {

    public static void main(String[] args) {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

//        UserEntity user = new UserEntity();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteria = builder.createQuery(UserEntity.class);
        Root<UserEntity> root = criteria.from(UserEntity.class);
        criteria.select(root).where(builder.equal(root.get("id"), 1));

        List<UserEntity> userEntities = session.createQuery(criteria).getResultList();
        for (UserEntity u :
                userEntities) {
            System.out.println(u.getUsername() + " " + u.getChatId() + " " + u.getUserId());
            u.setUsername("zalupa");
        }
//        user.setChatId(321313);
//        user.setUserId(3213331);
//        user.setUsername("dsad");
//        user.setCountcool(2);
//        user.setCountpidor(1);
//        session.save(user);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}

