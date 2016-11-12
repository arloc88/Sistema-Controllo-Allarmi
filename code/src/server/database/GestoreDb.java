package server.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity

public class GestoreDb {
	@Id
	private int ID;
	@Column
	private String tipo;
	@Column
	private int numero;
	
	public GestoreDb(){
		super();
	}
	
	public GestoreDb(int id,String tipo,int numero){
		this.ID=id;
		this.tipo=tipo;
		this.numero=numero;
	}
	
	
	public GestoreDb(GestoreDb gestoreDb){
		this.ID=gestoreDb.getID();
		this.tipo=gestoreDb.getTipo();
		this.numero=gestoreDb.getNumero();
	}
	
	public int getID(){
		return this.ID;
	}
	
	public String getTipo(){
		return this.tipo;
	}
	
	public int getNumero(){
		return this.numero;
	}
	
	public void setID(int id){
		 this.ID=id;
	}
	
	public void setTipo(String tipo){
		this.tipo=tipo;
	}
	
	public void setNumero(int num){
		this.numero=num;
	}
	
	public void save(){
		SessionFactory sessionFactory = HibernateUtilServer.getSessionFactory();
		Session sess = sessionFactory.openSession();
		sess.beginTransaction();
		sess.save(this);
		sess.getTransaction().commit();
		sess.close();		
	}
	
	public void update() {
		SessionFactory sessionFactory = HibernateUtilServer.getSessionFactory();
		Session sess = sessionFactory.openSession();
		sess.beginTransaction();
		sess.update(this);
		sess.getTransaction().commit();
		sess.close();	
		
	}

}
