package server.entity;

import server.database.AbitazioneDb;

public class Abitazione {
	
	private int ID;
	private String nome;
	private String telefono;
	private String indirizzo;
	private Sensore sensore;

public Abitazione(){
	super();
	
}

public Abitazione(int ID,String nome,String telefono,String indirizzo,Sensore sensore){
	this.ID=ID;
	this.nome=nome;
	this.telefono=telefono;
	this.indirizzo=indirizzo;
	this.sensore=sensore;
	
}


public Abitazione(AbitazioneDb abitazioneDb){
	this.ID=abitazioneDb.getID();
	this.nome=abitazioneDb.getNome();
	this.indirizzo=abitazioneDb.getIndirizzo();
	this.telefono=abitazioneDb.getTelefono();
	this.sensore=new Sensore(abitazioneDb.getSensoreDb());
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

public void setID(int ID){
	this.ID=ID;
}

public void setNome(String nome){
	this.nome=nome;
}

public void setTelefono(String telefono){
	this.telefono=telefono;
}


public AbitazioneDb getAbitazioneDb(){
	return new AbitazioneDb(this.ID,this.nome,this.telefono,this.indirizzo,this.sensore.getSensoreDb());
}

public static Abitazione findAbitazioneById(int id){
	return new Abitazione(AbitazioneDb.getAbitazioneDbByID(id));
}

public void salva(){
	AbitazioneDb abitazioneDb = new AbitazioneDb(this.ID,this.nome,this.telefono,this.indirizzo,this.sensore.getSensoreDb());
	
	abitazioneDb.save();
}

public void update(){
	AbitazioneDb abitazioneDb = new AbitazioneDb(this.ID,this.nome,this.telefono,this.indirizzo,this.sensore.getSensoreDb());
	abitazioneDb.update();
	
}
}
