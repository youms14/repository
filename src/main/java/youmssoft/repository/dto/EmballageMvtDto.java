package youmssoft.repository.dto;


import java.util.HashMap;


import youmssoft.repository.entities.ventes.EmballagesMvt;

public class EmballageMvtDto {
	private long idEmb;
	private String objet;
	private float qte;
	private String nomFournisseur;
	//private long gestionLivraion;
	private long personnel;
	
	public HashMap<String, Object> mapObjectToHashMap(EmballagesMvt em){
		HashMap<String, Object> hm= new HashMap<>();
	
		if(em.getMyAchatEmballage()!=null) {
			hm.put("idAchatEmballge", em.getMyAchatEmballage().getIdAcharEmballage());
		}
		if(em.getMyCass()!=null) {
			hm.put("idCass",em.getMyCass().getIdCass());
		}
		if(em.getMyGestionFacture()!=null) {
			hm.put("idGestionFacture", em.getMyGestionFacture().getIdGestionFacture());
		}
		if(em.getMyGestionLivraison()!=null) {
			hm.put("idGestionLivraison", em.getMyGestionLivraison().getIdGestionLivraison());
		}
		if(em.getMyGestionRetourChargment()!=null) {
			hm.put("idRetourChargement", em.getMyGestionRetourChargment().getIdGRC());
		}
		
		hm.put("idMouvementEmballage", idEmb);
		hm.put("quantite", qte);
		hm.put("nomFournisseur", nomFournisseur);
		hm.put("Magazinier(e)", personnel);
		hm.put("Objet",objet);
		return hm;
	}
	
	
	
	
	
	
	public long getIdEmb() {
		return idEmb;
	}
	public void setIdEmb(long idEmb) {
		this.idEmb = idEmb;
	}
	
	public float getQte() {
		return qte;
	}
	public void setQte(float qte) {
		this.qte = qte;
	}
	public String getNomFournisseur() {
		return nomFournisseur;
	}
	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}
	
	public long getPersonnel() {
		return personnel;
	}
	public void setPersonnel(long personnel) {
		this.personnel = personnel;
	}
	
	





	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public EmballageMvtDto(EmballagesMvt em) {
		super();
		this.idEmb = em.getIdEmb();
		this.objet = em.getLibelleMvtEmb();
		this.qte = em.getQuantiteEmb();
		this.nomFournisseur = em.getFournisseurEmb().getNom();
		this.personnel = em.getMagasinierEMB().getIdPersonnel();
	}

	public EmballageMvtDto() {
		super();
	}
/*
	public EmballageMvtDto mapEntityToDto(EmballagesMvt em) {
	this.idEmb = em.getIdEmb();
	this.objet = em.getLibelleMvtEmb();
	this.qte = em.getQuantiteEmb();
	this.nomFournisseur = em.getFournisseurEmb().getNom();
	this.personnel = em.getMagasinierEMB().getIdPersonnel();
	return this;
}*/






	
	
	
}
