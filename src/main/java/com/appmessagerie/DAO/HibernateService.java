package com.appmessagerie.DAO;

import com.appmessagerie.Model.HibernateUtil;
import com.appmessagerie.Model.Message;
import com.appmessagerie.Model.Personne;
import com.appmessagerie.Util.HashUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class HibernateService {
    public static int insert(String nom, String prenom, String motDePasse) {
        Transaction tx = null;
        int id = 0;

        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();

            String motDePasseHache = HashUtil.hashPassword(motDePasse);
            Personne personne = new Personne(nom, prenom, motDePasseHache);

            // session.save() retourne un Serializable → cast en Integer
            id = (int) session.save(personne);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }

        return id; // si id == 0, on considère échec
    }

    public static Personne authenticate(String nom, String motDePasseHache) {
        Personne personne = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();

//            Query<Personne> query = session.createQuery(
//                    "FROM Personne WHERE nom = :nom AND motDePasse = :mdp", Personne.class);
//            query.setParameter("nom", nom);
//            query.setParameter("mdp", motDePasseHache);
//
//            personne = query.uniqueResult(); // null si aucun résultat
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Personne> cq = cb.createQuery(Personne.class);
            Root<Personne> root = cq.from(Personne.class);

            cq.select(root)
                    .where(
                            cb.equal(root.get("nom"), nom),
                            cb.equal(root.get("motDePasse"), motDePasseHache)
                    );

            personne = session.createQuery(cq).uniqueResult();



            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return personne;
    }

    public static List<Message> getUserMessages(int idPersonne) {
        List<Message> messages = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            Query<Message> query = session.createQuery(
                    "FROM Message WHERE idPersonne = :id", Message.class);
            query.setParameter("id", idPersonne);
            messages = query.list();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return messages;
    }
}
