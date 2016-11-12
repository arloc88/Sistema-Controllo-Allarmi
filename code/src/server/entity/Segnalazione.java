package server.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import server.database.AllarmeDb;
import server.database.SegnalazioneDb;

public class Segnalazione {
	private int ID;
	private int stato;
	private Date data;
	private Abitazione abitazione;
	private int id_sensore;

	
	public	Segnalazione(){
		super();
	}
	
	public Segnalazione(int id,int stato,Date data,Abitazione abitazione){
		this.ID=id;
		this.stato=stato;
		this.data=data;
	
		this.abitazione=abitazione;
		this.id_sensore=this.abitazione.getAbitazioneDb().getSensoreDb().getID();
	}
	
	public Segnalazione(SegnalazioneDb segnalazioneDb){
		this.ID=segnalazioneDb.getID();
		this.stato=segnalazioneDb.getStato();
		this.data=segnalazioneDb.getData();
		this.abitazione= new Abitazione(segnalazioneDb.getAbitazioneDb());
		this.id_sensore=segnalazioneDb.getAbitazioneDb().getSensoreDb().getID();
	
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
	


	public Abitazione getAbitazione(){
		return this.abitazione;
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

	
	public void setAbitazione(Abitazione abitazione){
		this.abitazione=abitazione;
	}
	
	public SegnalazioneDb getSegnalazioneDb(){
		return new SegnalazioneDb(this.ID,this.stato,this.data,this.getAbitazione().getAbitazioneDb());
	}
	
	public void salva(){
		SegnalazioneDb segnalazioneDb = new SegnalazioneDb(this.ID,this.stato,this.data,this.getAbitazione().getAbitazioneDb());
		segnalazioneDb.save();
	}
	
	public void update(){
		SegnalazioneDb segnalazioneDb = new SegnalazioneDb(this.ID,this.stato,this.data,this.getAbitazione().getAbitazioneDb());
		segnalazioneDb.update();
	}

	
	
	
	@SuppressWarnings("deprecation")
	public static List<Segnalazione> getAllSegnalazioniByTipo(String t, int mese) {
		List<Segnalazione> lista = new ArrayList<Segnalazione>();
		
		List<SegnalazioneDb> listDb = SegnalazioneDb.getAllSegnalazioniByTipoDb(t);
		for (SegnalazioneDb segnalazioneDb : listDb){
			if(segnalazioneDb.getData().getMonth() == (mese-1))
			lista.add(new Segnalazione(segnalazioneDb));
		}
		
		return lista;
	}
}
