package server.database;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



@Entity
public class InterventoDb {
	
	@Id
	private int ID;
	@Column
	private String tipo;
	@Column
	private Date data;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_segnalazione",referencedColumnName="ID")
	private SegnalazioneDb segnalazioneDb;
	@Column
	private int esito;

	
	public InterventoDb(){
		super();
		this.esito=0;
	}
	
	public InterventoDb(int id,Date data, SegnalazioneDb segnalazioneDb,int esito){
		this.ID=id;
		this.data=data;
		this.segnalazioneDb=segnalazioneDb;
		this.esito=esito;
		this.tipo=segnalazioneDb.getAbitazioneDb().getSensoreDb().getTipo();
		
	}
	
	public int getID(){
		return this.ID;
	}
	
	public String getTipo(){
		return this.segnalazioneDb.getAbitazioneDb().getSensoreDb().getTipo();
	}
	
	public Date getData(){
		return this.data;
	}

	public SegnalazioneDb getSegnalazioneDb(){
		return this.segnalazioneDb;
	}
	
	public int getEsito(){
		return this.esito;
	}
	public void setID(int id){
		this.ID=id;
	}
	
	public void setTipo(String tipo){
		this.tipo=tipo;
	}
	
	public void setDate(Date data){
		this.data=data;
	}
	
	public void setSegnalazioneDb(SegnalazioneDb segnalazioneDb){
		this.segnalazioneDb=segnalazioneDb;
	}

	public void setEsito(int esito){
		this.esito=esito;
	}

	
	@SuppressWarnings("unchecked")
	public static List<InterventoDb> getAllInterventiByTipoDb(String tipo) {
		List<InterventoDb> lista = new ArrayList<InterventoDb>();
		
		SessionFactory sessionFactory = HibernateUtilServer.getSessionFactory();
		Session sess = sessionFactory.openSession();
		sess.beginTransaction();
		Query query = sess.createQuery("FROM InterventoDb as c where c.segnalazioneDb.abitazioneDb.sensoreDb.tipo = :parametro");
		query.setParameter("parametro",tipo);
		lista=(List<InterventoDb>)query.list();
		sess.getTransaction().commit();
		sess.close();	
		
		return lista;
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


