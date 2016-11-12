package server.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import server.database.InterventoDb;

public class Intervento {
	private int ID;
	private String tipo;
	private Date data;
	private Segnalazione segnalazione;
	private int esito;

	
	
	public Intervento(){
		super();
	}
	
	public Intervento(int id,Date data,Segnalazione segnalazione,int esito){
		this.ID=id;
		
		this.data=data;
		this.segnalazione=segnalazione;
		this.tipo=segnalazione.getAbitazione().getAbitazioneDb().getSensoreDb().getTipo();
	}

	public Intervento(InterventoDb interventodb){
		this.ID=interventodb.getID();
		this.tipo=interventodb.getTipo();
		this.data=interventodb.getData();
		this.segnalazione=new Segnalazione(interventodb.getSegnalazioneDb());
		this.esito=interventodb.getEsito();
		
		
	}

	public int getID(){
		return this.ID;
	}
	
	public String getTipo(){
		return this.segnalazione.getAbitazione().getAbitazioneDb().getSensoreDb().getTipo();
	}
	
	public Date getData(){
		return this.data;
	}

	public Segnalazione getSegnalazione(){
		return this.segnalazione;
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
	
	public void setSegnalazione(Segnalazione segnalazione){
		this.segnalazione=segnalazione;
	}
	
	public void setEsito(int esito){
		this.esito=esito;
	}
	
	
	//@SuppressWarnings("deprecation")
	public static List<Intervento> getAllInterventiByTipo(String tipo) {
		List<Intervento> lista = new ArrayList<Intervento>();
		
		List<InterventoDb> list_db = InterventoDb.getAllInterventiByTipoDb(tipo);
		for (InterventoDb interventoDb : list_db){
			//if(interventoDb.getTipo() == tipo.toString())
			lista.add(new Intervento(interventoDb));
		}
		
		return lista;
	}
	
	public InterventoDb getInterventoDb(){
		return new InterventoDb(this.ID,this.data,this.getSegnalazione().getSegnalazioneDb(),this.esito);
	}
	
	public void salva(){
		InterventoDb interventoDb = new InterventoDb(this.ID,this.data,this.getSegnalazione().getSegnalazioneDb(),this.esito);
		interventoDb.save();
	}
	
	public void update(){
		InterventoDb interventoDb = new InterventoDb(this.ID,this.data,this.getSegnalazione().getSegnalazioneDb(),this.esito);
		interventoDb.update();
	}
}
