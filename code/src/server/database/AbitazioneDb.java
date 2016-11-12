package server.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


@Entity
public class AbitazioneDb {
	
	@Id
	private int ID;
	@Column
	private String nome;
	@Column
	private String telefono;
	@Column
	private String indirizzo;
	@OneToOne
	@JoinColumn(name="id_sensore",referencedColumnName="ID")
	private SensoreDb sensoreDb;
	
	public AbitazioneDb(){
		super();
		
	}
	
	public AbitazioneDb(int ID,String nome,String telefono,String indirizzo,SensoreDb sensoreDb){
		this.ID=ID;
		this.nome=nome;
		this.telefono=telefono;
		this.indirizzo=indirizzo;
		this.sensoreDb=sensoreDb;
		
	}
	
	public int getID(){
		return this.ID;
	}
	
	
	public String getNome(){
		return this.nome;
	}
	
	public String getTelefono(){
		return this.telefono;
	}
	
	public String getIndirizzo(){
		return this.indirizzo;
	}
	
	public SensoreDb getSensoreDb(){
		return this.sensoreDb;
	}
	
	public void setID(int ID){
		this.ID=ID;
	}
	
	public void setNome(String nome){
		this.nome=nome;
	}

	public void setTelefono(String telefono){
		this.telefono=telefono;
	}
	
	public void setIndirizzo(String indirizzo){
		 this.indirizzo=indirizzo;
	}
	
	public static AbitazioneDb getAbitazioneDbByID(int idAbitazione) {
		SessionFactory sessionFactory = HibernateUtilServer.getSessionFactory();
		Session sess = sessionFactory.openSession();
		sess.beginTransaction();
		AbitazioneDb abitazione_db= (AbitazioneDb)sess.get(AbitazioneDb.class, idAbitazione);
		sess.getTransaction().commit();
		sess.close();
		return abitazione_db;
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
