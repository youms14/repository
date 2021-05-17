package youmssoft.repository.entities.ventes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CommandeFacture")
public class CommandeFacture implements Serializable{//ok.

	@Id @GeneratedValue
	@Column(name = "idComFact", nullable = false, unique=true)
	private long idComFact;

	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
    @JoinColumn(name = "myCommande", referencedColumnName="idCommande", nullable = false)
    private Commande myCommande;
	
	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
    @JoinColumn(name = "myFacture", referencedColumnName="idFacture", nullable = false)
    private Facture myFacture;
    
    
    
	@Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;
    
	/**
	 * 
	 */
	public CommandeFacture() {
		super();
	}
	/**
	 * @param myCommande
	 * @param myFacture
	 */
	public CommandeFacture(Commande myCommande, Facture myFacture) {
		super();
		this.myCommande = myCommande;
		this.myFacture = myFacture;
	}
	/**
	 * @param idComFact
	 * @param myCommande
	 * @param myFacture
	 */
	public CommandeFacture(long idComFact, Commande myCommande, Facture myFacture) {
		super();
		this.idComFact = idComFact;
		this.myCommande = myCommande;
		this.myFacture = myFacture;
	}
	public long getIdComFact() {
		return idComFact;
	}
	public void setIdComFact(long idComFact) {
		this.idComFact = idComFact;
	}
	public Commande getMyCommande() {
		return myCommande;
	}
	public void setMyCommande(Commande myCommande) {
		this.myCommande = myCommande;
	}
	public Facture getMyFacture() {
		return myFacture;
	}
	
	
	public boolean isValide() {
		return isValide;
	}
	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}
	public void setMyFacture(Facture myFacture) {
		this.myFacture = myFacture;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommandeFacture [idComFact=");
		builder.append(idComFact);
		builder.append(", myCommande=");
		builder.append(myCommande);
		builder.append(", myFacture=");
		builder.append(myFacture);
		builder.append("]");
		return builder.toString();
	}
    
    
    
    
    

}