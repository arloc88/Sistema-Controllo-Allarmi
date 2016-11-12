package server.entity;

import server.database.SensoreDb;


public class Sensore {
	
	private int ID;
	private String tipo;
	private int soglia;
	private Gestore gestore;
	
	
	public Sensore() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Sensore(int ID,String tipo, int soglia,Gestore gestore){
		super();
		this.ID = ID;
		this.tipo=tipo;
		this.soglia=soglia;
		this.gestore=gestore;
		
		
	}
	
	public Sensore(SensoreDb sensore_db){
		this.ID = sensore_db.getID();
		this.tipo = sensore_db.getTipo();
		this.soglia = sensore_db.getSoglia();
		this.gestore=new Gestore(sensore_db.getGestoreDb());
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
	
	public Gestore getGestore(Gestore gestore){
		return this.gestore=gestore;
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

	public SensoreDb getSensoreDb(){
		return new SensoreDb(this.ID,this.tipo,this.soglia,this.gestore.getGestoreDb());
	}

	public static Sensore findSensoreByID(int idSensore) {
		return new Sensore(SensoreDb.getSensoreDbByID(idSensore));
	}
	
	public void salva(){
		
		SensoreDb sensore_db= new SensoreDb(this.ID,this.tipo,this.soglia,this.gestore.getGestoreDb());
		sensore_db.save();
	}
	
	public void update(){
		SensoreDb sensore_db= new SensoreDb(this.ID,this.tipo,this.soglia,this.gestore.getGestoreDb());
		sensore_db.update();
		
	}

}
