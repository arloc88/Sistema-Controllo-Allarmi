package server.entity;


import server.database.GestoreDb;


public class Gestore {
	
	
	private int ID;
	
	private String tipo;
	
	private int numero;
	
	public Gestore(){
		super();
	}
	
	public Gestore(int id,String tipo,int numero){
		this.ID=id;
		this.tipo=tipo;
		this.numero=numero;
	}
	
	
	public Gestore(GestoreDb gestoreDb){
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
	
	public GestoreDb getGestoreDb(){
		return new GestoreDb(this.ID,this.tipo,this.numero);
	}
	
}
