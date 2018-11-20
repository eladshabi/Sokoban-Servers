package services;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class SolutionsManager {
	private SessionFactory factory;

	public SolutionsManager() {
		System.out.println("0");
		Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		System.out.println("1");
		Configuration configuration = new Configuration();
		System.out.println("2");
		configuration.configure();
		System.out.println("3");
		factory = configuration.buildSessionFactory();
		System.out.println("4");
	}

	public void addSolution(Solution sol) {
		System.out.println("in add 1");
		Session session = factory.openSession();
		System.out.println("in add 2");
		Transaction tx = null;
		System.out.println("in add 3");
		try {
			tx = session.beginTransaction();
			System.out.println("in add 4");
			session.save(sol);
			System.out.println("in add 5");
			tx.commit();
			System.out.println("in add 6");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			System.out.println("in add 7");
			session.close();
		}
	}

	public String getSolution(int LNum) {
		System.out.println("getsol 0" + " " + LNum);
		Session session = factory.openSession();
		System.out.println("getsol 1");
		Solution[] results = null;
		System.out.println("getsol 2");
		Query query = session.createQuery("from Solutions where LevelNum = :LNum");
		System.out.println("getsol 3");
		query.setParameter("LNum", LNum);
		System.out.println("getsol 4");
		results = new Solution[query.list().size()];

		System.out.println("getsol 5");
		results = (Solution[]) query.list().toArray(results);

		System.out.println();
		System.out.println("getsol 6");
		if (!query.list().isEmpty())
			return results[0].getSolution();
		else 
			return "empty";
	}

}
