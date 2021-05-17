package youmssoft.repository.dto;

import java.util.HashMap;

import youmssoft.repository.entities.ventes.ArgentMvt;

public class ArgentMvtDto {
	private long idArgentMvt;
	private float amount;
	private String objet;
	private String personnel;
	
	
	public HashMap<String, Object> mapObjectToHashMap(ArgentMvt am){
		HashMap<String, Object> hm= new HashMap<>();
		hm.put("idArgentMvt", this.idArgentMvt);
		hm.put("amount", amount);
		hm.put("objet", objet);
		hm.put("Caissier", am.getResponsable().getNomPers() +" "+am.getResponsable().getPrenomPers()); 
		if(am.getMyDepenses()!=null) {
			hm.put("idDepense", am.getMyDepenses().getIdDepense());
			hm.put("ObjetDepense", am.getMyDepenses().getMotif());
		}
		if(am.getMyCaisseJournaliere()!=null) {
			hm.put("idCaisseJournaliere", am.getMyCaisseJournaliere().getIdCaisseJournaliere());
		}
		if(am.getMyCass()!=null) {
			hm.put("idCass", am.getMyCass().getIdCass());
		}
		if(am.getMyGestionFacture()!=null) {
			hm.put("idGestionFacture", am.getMyGestionFacture().getIdGestionFacture());
		}
		if(am.getMyGestionLivraison()!=null){
			hm.put("idGestionLivraison", am.getMyGestionLivraison().getIdGestionLivraison());
		}
		if(am.getMyGestionRetourChargment()!=null) {
			hm.put("idGestionRetourChargement", am.getMyGestionRetourChargment().getIdGRC());
		}
		if(am.getMyInterfaceCaisse()!=null) {
			hm.put("idInterfaceCaisse", am.getMyInterfaceCaisse().getIdIntCaisse());
		}
		if(am.getMyTotalRistournePayement()!=null) {
			hm.put("idPayementTotalRistourne", am.getMyTotalRistournePayement().getIdTotalRistourne());
		}
		
		return hm;
		
	}
	
	public long getIdArgentMvt() {
		return idArgentMvt;
	}



	public void setIdArgentMvt(long idArgentMvt) {
		this.idArgentMvt = idArgentMvt;
	}



	public float getAmount() {
		return amount;
	}



	public void setAmount(float amount) {
		this.amount = amount;
	}



	public String getObjet() {
		return objet;
	}



	public void setObjet(String objet) {
		this.objet = objet;
	}



	public ArgentMvtDto() {
		super();
	}



	public ArgentMvtDto(long idArgentMvt, float amount, String objet) {
		super();
		this.idArgentMvt = idArgentMvt;
		this.amount = amount;
		this.objet = objet;
	}

	public ArgentMvtDto(ArgentMvt am) {
		this.idArgentMvt=am.getIdArgentMvt();
		this.amount=am.getMontant();
		this.objet=am.getLibelleArgent();
	}

	
}
