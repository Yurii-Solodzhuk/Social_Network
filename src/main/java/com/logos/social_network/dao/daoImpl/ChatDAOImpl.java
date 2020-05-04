package com.logos.social_network.dao.daoImpl;

import com.logos.social_network.dao.ChatDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ChatDAOImpl implements ChatDAO {

    public static final int FIRST_ELEMENT = 0;

    @Autowired
    private EntityManagerFactory sessionFactory;

    @Override
    public Integer findChatIdByMemberIds(Integer firstId, Integer secondId) {

        EntityManager entityManager = sessionFactory.createEntityManager();
        Query query = entityManager.createNativeQuery("SELECT m.chat_id FROM social_network.message m " +
                "where (m.author_id = :firstId and m.recipient_id = :secondId )" +
                " or (m.recipient_id = :firstId  and m.author_id = :secondId)");


        query.setParameter("firstId", firstId);
        query.setParameter("secondId", secondId);

        List<Integer> resultList = query.getResultList();
        return !resultList.isEmpty() ? resultList.get(FIRST_ELEMENT) : null;
    }

}
