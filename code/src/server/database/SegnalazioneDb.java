package server.database;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



@Entity
public class SegnalazioneDb {
	@Id
	private int ID;
	@Column
	private int stato;
	@Column
	private Date data;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_abitazione",referencedColumnName="ID")
	private AbitazioneDb abitazioneDb;
	@Column
	private int id_sensore;
	
	
	public SegnalazioneDb(){
		super();
	}
	
	public SegnalazioneDb(int id,int stato,Date data,AbitazioneDb abitazioneDb){
		this.ID=id;
		this.stato=stato;
		this.data=data;

		this.abitazioneDb=abitazioneDb;
		this.id_sensore=this.abitazioneDb.getSensoreDb().getID();
	}
	
	public int getID(){
		return this.ID;
	}

	public int getStato(){
		return this.stato;
	}

	public Date getData(){
		return this.data;
	}

	
	
	public AbitazioneDb getAbitazioneDb(){
		return this.abitazioneDb;
	}

	public void setID(int id){
		this.ID=id;
	}

	public void setStato(int stato){
		this.stato=stato;
	}
	
	public void setData(Date data){
		this.data=data;
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
	
	
	@SuppressWarnings("unchecked")
	public static List<SegnalazioneDb> getAllSegnalazioniByTipoDb(String t) {
		List<SegnalazioneDb> segnalazioni = new ArrayList<SegnalazioneDb>();
		
		SessionFactory sessionFactory = HibernateUtilServer.getSessionFactory();
		Session sess = sessionFactory.openSession();
		sess.beginTransaction();
		Query query1 = sess.createQuery("FROM SegnalazioneDb as a where a.abitazioneDb.sensoreDb.tipo = :parametro");
		query1.setParameter("parametro",t);
		segnalazioni=(List<SegnalazioneDb>)query1.list();
		sess.getTransaction().commit();
		sess.close();	
		
		return segnalazioni;
		
	}

}

