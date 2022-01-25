
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoContato {
	EntityManagerFactory emf;
	EntityManager em;
	
	public DaoContato() {
		emf=Persistence.createEntityManagerFactory("JPAPU");
		em=emf.createEntityManager();
	}

	
	public void salvar(Contato contato) {
		em.getTransaction().begin();
		em.persist(contato);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public Contato pegaarUm(Long Id) {
		return em.find(Contato.class, Id);
	}
	
	public boolean update (Contato contato) {
		
		Contato contatoVindoBanco = em.find(Contato.class, contato.getId());
		
		contatoVindoBanco.setNome(contato.getNome());
		contatoVindoBanco.setEmail(contato.getEmail());
		contatoVindoBanco.setCelular(contato.getCelular());
		
		em.getTransaction().begin();
		em.merge(contato);
		em.getTransaction().commit();
		em.close();		
		
		
		
		return true;
	}
	
}
