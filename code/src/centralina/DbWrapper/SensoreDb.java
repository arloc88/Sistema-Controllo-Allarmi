package centralina.DbWrapper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;




@Entity
public class SensoreDb {
	
	@Id
	private int ID;
	@Column
	private String tipo;
	@Column
	private int soglia;
	
	
	public SensoreDb(){
		super();
	}
	
	public SensoreDb(int ID,String tipo,int soglia){
		super();
		this.ID=ID;
		this.tipo=tipo;
		this.soglia=soglia;
	}
	
	public int getID(){
		return this.ID;
	}
	
	public String getTipo(){
		return this.tipo;
	}

	public int getSoglia(){
		return this.soglia;
	}
	
	public void setID(int ID){
		this.ID=ID;
		
	}

	public void setTipo(String tipo){
		this.tipo=tipo;
	}
	
	public void setSoglia(int soglia){
		this.soglia=soglia;
	}
	
	
	public static SensoreDb getSensoreDbByID(int idSensore) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session sess = sessionFactory.openSession();
		sess.beginTransaction();
		SensoreDb sensore_db= (SensoreDb)sess.get(SensoreDb.class, idSensore);
		sess.getTransaction().commit();
		sess.close();
		return sensore_db;
	}
	
	public void save(){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session sess = sessionFactory.openSession();
		sess.beginTransaction();
		sess.save(this);
		sess.getTransaction().commit();
		sess.close();		
	}
	
	public void update() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session sess = sessionFactory.openSession();
		sess.beginTransaction();
		sess.update(this);
		sess.getTransaction().commit();
		sess.close();	
		
	}
	
	
	
	
}
