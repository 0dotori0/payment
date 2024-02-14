package com.switchone.payment.listener;

import com.switchone.payment.domain.AbstractEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.event.spi.*;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class LogWriterListener implements PostDeleteEventListener, PostInsertEventListener, PostUpdateEventListener {

    private static final long serialVersionUID = -6460434143349161450L;

    @Override
    public void onPostInsert(PostInsertEvent event) {
        onPostAction("onPostInsert", event.getEntity(), event.getSession().getSessionFactory());
    }

    @Override
    public void onPostUpdate(PostUpdateEvent event) {
        onPostAction("onPostUpdate", event.getEntity(), event.getSession().getSessionFactory());
    }

    @Override
    public void onPostDelete(PostDeleteEvent event) {
        onPostAction("onPostDelete", event.getEntity(), event.getSession().getSessionFactory());
    }

    private void onPostAction(String action, Object entity, SessionFactory sessionFactory) {

        Session session = sessionFactory.openSession();
        try {
            writeLog(session, entity);
        } catch (Exception ex) {
            // ignored
            log.error(String.format("%s Error::%s:%s", action, entity, ex.getMessage()));
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    private void writeLog(Session session, Object entity) {

    }

    private void save(Session session, AbstractEntity<?> entity) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(entity);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            throw ex;
        }
    }

    @Override
    public boolean requiresPostCommitHanding(EntityPersister persister) {
        return false;
    }
}
