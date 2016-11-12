package centralina.entity;

import centralina.DbWrapper.SensoreDb;

public class Sensore {
	
	private int ID;
	private String tipo;
	private int soglia;
	
	
	public Sensore() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Sensore(int ID,String tipo, int soglia){
		super();
		this.ID = ID;
		this.tipo=tipo;
		this.soglia=soglia;
		
	}
	
	public Sensore(SensoreDb sensore_db){
		this.ID = sensore_db.getID();
		this.tipo = sensore_db.getTipo();
		this.soglia = sensore_db.getSoglia();
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

	public SensoreDb getSensoreDb(){
		return new SensoreDb(this.ID,this.tipo,this.soglia);
	}

	public static Sensore findSensoreByID(int idSensore) {
		return new Sensore(SensoreDb.getSensoreDbByID(idSensore));
	}
	
	public void salva(){
		
		SensoreDb sensore_db= new SensoreDb(this.ID,this.tipo,this.soglia) ;
		sensore_db.save();
	}
	
}
