package youmssoft.repository.entities.livraison;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="produit")
public class Produit implements Serializable {

  /**
	 * 
	 */
	private static final long serialVersionUID = -7649174148990665914L;

	@Id @GeneratedValue
	@Column(name = "idProduit", nullable = false)
	private long idProduit;

	@Column(name = "nomProd", nullable = false, length = 30)
	private String nomProd;

	@Column(name = "typeProd", nullable = false, length = 30)
	private String typeProd;

	@Column(name = "volume", nullable = true, length = 10)
	private String volume;

	@Column(name = "puVente", nullable = false)
	private float puVente;

	@Column(name = "puAchat", nullable = false)
	private float puAchat;

	@Column(name = "degreAlcool", nullable = true, length = 10)
	private String degreAlcool;

	@Column(name = "format", nullable = true)
	private int format;
	
	@Column(name = "ristourneLivraison", nullable = true)
	private float ristourneLivraison;
	
	@Column(name = "prixChargement", nullable = false)
	private float prixChargement=0;
	
	@Column(name = "quantite", nullable = false)
	private float quantite=0;
	
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "myFournisseur", referencedColumnName="idFournisseur", nullable = false)
  private Fournisseur myFournisseur;//ok
  
  @Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;

public Produit(int idProduit, String nom, String type, String volume, int puVente, int puAchat,
		String degreAlcool, int format, Fournisseur myFournisseur,float ristourneLivraison,float prixChargement) {
	super();
	this.idProduit = idProduit;
	this.nomProd = nom;
	this.typeProd = type;
	this.volume = volume;
	this.puVente = puVente;
	this.puAchat = puAchat;
	this.degreAlcool = degreAlcool;
	this.format = format;
	this.myFournisseur = myFournisseur;
	this. ristourneLivraison= ristourneLivraison;
	this. prixChargement= prixChargement;
}

public Produit(String nom, String type, String volume, int puVente, int puAchat, String degreAlcool,
		int format, Fournisseur myFournisseur,float ristourneLivraison,float prixChargement) {
	super();
	this.nomProd = nom;
	this.typeProd = type;
	this.volume = volume;
	this.puVente = puVente;
	this.puAchat = puAchat;
	this.degreAlcool = degreAlcool;
	this.format = format;
	this.myFournisseur = myFournisseur;
	this. ristourneLivraison=ristourneLivraison;
	this. prixChargement= prixChargement;
}

public Produit() {
	super();
}



public boolean isValide() {
	return isValide;
}

public void setValide(boolean isValide) {
	this.isValide = isValide;
}

public float getQuantite() {
	return quantite;
}

public void setQuantite(float quantite) {
	this.quantite = quantite;
}

public long getIdProduit() {
	return idProduit;
}

public void setIdProduit(long id) {
	this.idProduit = id;
}

public String getNom() {
	return nomProd;
}

public void setNom(String nom) {
	this.nomProd = nom;
}

public String getType() {
	return typeProd;
}

public void setType(String type) {
	this.typeProd = type;
}

public String getVolume() {
	return volume;
}

public void setVolume(String volume) {
	this.volume = volume;
}

public float getPuVente() {
	return puVente;
}

public void setPuVente(float puVente) {
	this.puVente = puVente;
}

public float getPuAchat() {
	return puAchat;
}

public void setPuAchat(int puAchat) {
	this.puAchat = puAchat;
}

public String getDegreAlcool() {
	return degreAlcool;
}

public void setDegreAlcool(String degreAlcool) {
	this.degreAlcool = degreAlcool;
}

public int getFormat() {
	return format;
}

public void setFormat(int format) {
	this.format = format;
}

public Fournisseur getMyFournisseur() {
	return myFournisseur;
}

public void setMyFournisseur(Fournisseur myFournisseur) {
	this.myFournisseur = myFournisseur;
}

public String getNomProd() {
	return nomProd;
}

public void setNomProd(String nomProd) {
	this.nomProd = nomProd;
}

public String getTypeProd() {
	return typeProd;
}

public void setTypeProd(String typeProd) {
	this.typeProd = typeProd;
}

public float getRistourneLivraison() {
	return ristourneLivraison;
}

public void setRistourneLivraison(float ristourneLivraison) {
	this.ristourneLivraison = ristourneLivraison;
}

public void setPuAchat(float puAchat) {
	this.puAchat = puAchat;
}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Produit [idProduit=");
	builder.append(idProduit);
	builder.append(", nomProd=");
	builder.append(nomProd);
	builder.append(", typeProd=");
	builder.append(typeProd);
	builder.append(", volume=");
	builder.append(volume);
	builder.append(", puVente=");
	builder.append(puVente);
	builder.append(", puAchat=");
	builder.append(puAchat);
	builder.append(", degreAlcool=");
	builder.append(degreAlcool);
	builder.append(", format=");
	builder.append(format);
	builder.append(", ristourneLivraison=");
	builder.append(ristourneLivraison);
	builder.append(", quantite=");
	builder.append(quantite);
	builder.append(", myFournisseur=");
	builder.append(myFournisseur);
	builder.append("]");
	return builder.toString();
}

public float getPrixChargement() {
	return prixChargement;
}

public void setPrixChargement(float prixChargement) {
	this.prixChargement = prixChargement;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((degreAlcool == null) ? 0 : degreAlcool.hashCode());
	result = prime * result + format;
	result = prime * result + (int) (idProduit ^ (idProduit >>> 32));
	result = prime * result + ((myFournisseur == null) ? 0 : myFournisseur.hashCode());
	result = prime * result + ((nomProd == null) ? 0 : nomProd.hashCode());
	result = prime * result + Float.floatToIntBits(prixChargement);
	result = prime * result + Float.floatToIntBits(puAchat);
	result = prime * result + Float.floatToIntBits(puVente);
	result = prime * result + Float.floatToIntBits(quantite);
	result = prime * result + Float.floatToIntBits(ristourneLivraison);
	result = prime * result + ((typeProd == null) ? 0 : typeProd.hashCode());
	result = prime * result + ((volume == null) ? 0 : volume.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Produit other = (Produit) obj;
	if (degreAlcool == null) {
		if (other.degreAlcool != null)
			return false;
	} else if (!degreAlcool.equals(other.degreAlcool))
		return false;
	if (format != other.format)
		return false;
	if (myFournisseur == null) {
		if (other.myFournisseur != null)
			return false;
	} else if (!myFournisseur.equals(other.myFournisseur))
		return false;
	if (nomProd == null) {
		if (other.nomProd != null)
			return false;
	} else if (!nomProd.equals(other.nomProd))
		return false;
	if (Float.floatToIntBits(prixChargement) != Float.floatToIntBits(other.prixChargement))
		return false;
	if (Float.floatToIntBits(puAchat) != Float.floatToIntBits(other.puAchat))
		return false;
	if (Float.floatToIntBits(puVente) != Float.floatToIntBits(other.puVente))
		return false;
	if (Float.floatToIntBits(quantite) != Float.floatToIntBits(other.quantite))
		return false;
	if (Float.floatToIntBits(ristourneLivraison) != Float.floatToIntBits(other.ristourneLivraison))
		return false;
	if (typeProd == null) {
		if (other.typeProd != null)
			return false;
	} else if (!typeProd.equals(other.typeProd))
		return false;
	if (volume == null) {
		if (other.volume != null)
			return false;
	} else if (!volume.equals(other.volume))
		return false;
	return true;
}








  

}