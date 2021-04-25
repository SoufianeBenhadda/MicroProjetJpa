package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import models.Article;
import models.User;

public class JpaData {
	public static EntityManager getEntityManager() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GI-4");
		EntityManager entitymanager = emfactory.createEntityManager();
		return entitymanager;
	}
	public int registerEmployee(User employee) {
		
			
			EntityManager entitymanager = getEntityManager();
			entitymanager.getTransaction().begin();
			entitymanager.persist(employee);
			entitymanager.getTransaction().commit();
			entitymanager.close();
			return 1;			
		}
	public boolean validate(User user) {
		EntityManager entitymanager = getEntityManager();
		try {
			User u = entitymanager.createQuery("SELECT b FROM User as b WHERE b.email = :email and b.motdepasse= :mdp",User.class)
					.setParameter("email", user.getEmail()).setParameter("mdp", user.getMotdepasse()).getSingleResult();
		
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	public User setAttributes(User user) {
		EntityManager em= getEntityManager();

		 
		Query q = em.createQuery("Select c from User c where c.email= :clientEmail and c.motdepasse= :clientMDP");
		q.setParameter("clientEmail",user.getEmail());
		q.setParameter("clientMDP",user.getMotdepasse());

		User client = (User) q.getResultList().stream().findFirst().orElse(null);
		return client;

	}
	public Article SetArticle(Article article) {
		
		EntityManager em= getEntityManager();

		 
		Query q = em.createQuery("Select c from Article c where c.codearticle= :codearticle");
		q.setParameter("codearticle",article.getCodearticle());


		Article articlee = (Article) q.getResultList().stream().findFirst().orElse(null);
		return articlee;
	}
	public List<Article> getArticlesByCat(String categorie){
		EntityManager etm= getEntityManager();
		
		Query q = etm.createQuery("Select a from Article a where a.categorie= :categorie");
		q.setParameter("categorie", categorie);

		List<Article> articles=q.getResultList();
		
	    
		return articles;
	}

	}

	

