package youmssoft.repository.entities.ventes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import youmssoft.repository.entities.livraison.Personnel;



@Entity
@Table(name="RetourProduits")
public class RetourProduits {
	
	@Id @GeneratedValue
	@Column(name = "idRP", nullable = false, unique=true)
	private long idRP;
	
	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myProduitFacture", referencedColumnName="idPorduitsFacture", nullable = true)
	private ProduitsFacture myProduitFacture;
	
	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myProduitsRC", referencedColumnName="idProduitsRC", nullable = true)
	private ProduitsRC myProduitsRC;
	
	private LocalDate dateRetour;
	
	
	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "magaziner", referencedColumnName="idPersonnel", nullable = true)
	private Personnel magaziner;

	public RetourProduits(long idRP, ProduitsFacture myProduitFacture, ProduitsRC myProduitsRC, LocalDate dateRetour) {
		super();
		this.idRP = idRP;
		this.myProduitFacture = myProduitFacture;
		this.myProduitsRC = myProduitsRC;
		this.dateRetour = dateRetour;
	}
	
	

	public RetourProduits(long idRP, ProduitsFacture myProduitFacture, ProduitsRC myProduitsRC, LocalDate dateRetour,
			Personnel magaziner) {
		super();
		this.idRP = idRP;
		this.myProduitFacture = myProduitFacture;
		this.myProduitsRC = myProduitsRC;
		this.dateRetour = dateRetour;
		this.magaziner = magaziner;
	}



	public RetourProduits() {
		super();
	}

	
	public Personnel getMagaziner() {
		return magaziner;
	}

	public void setMagaziner(Personnel magaziner) {
		this.magaziner = magaziner;
	}

	public long getIdRP() {
		return idRP;
	}

	public void setIdRP(long idRP) {
		this.idRP = idRP;
	}

	public ProduitsFacture getMyProduitFacture() {
		return myProduitFacture;
	}

	public void setMyProduitFacture(ProduitsFacture myProduitFacture) {
		this.myProduitFacture = myProduitFacture;
	}

	public ProduitsRC getMyProduitsRC() {
		return myProduitsRC;
	}

	public void setMyProduitsRC(ProduitsRC myProduitsRC) {
		this.myProduitsRC = myProduitsRC;
	}

	public LocalDate getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(LocalDate dateRetour) {
		this.dateRetour = dateRetour;
	}
	
	
	
	

}
