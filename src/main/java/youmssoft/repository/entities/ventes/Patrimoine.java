package youmssoft.repository.entities.ventes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Patrimoine")
public class Patrimoine implements Serializable{

	@Id @GeneratedValue
	@Column(name = "idPatrimoine", nullable = false, unique=true)
	private long idPatrimoine;

	@Column(name = "naturePat", nullable = true, length=30)
	private String naturePat;

	@Column(name = "nomPat", nullable = true, length=30)
	private String nomPat;

	@Column(name = "immatriculationPat", nullable = true, length=30)
	private String immatriculationPat;
	
	@Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;

/**
 * @param idPatrimoine
 * @param naturePat
 * @param nomPat
 * @param immatriculationPat
 */
public Patrimoine(long idPatrimoine, String naturePat, String nomPat, String immatriculationPat) {
	super();
	this.idPatrimoine = idPatrimoine;
	this.naturePat = naturePat;
	this.nomPat = nomPat;
	this.immatriculationPat = immatriculationPat;
}

/**
 * @param naturePat
 * @param nomPat
 * @param immatriculationPat
 */
public Patrimoine(String naturePat, String nomPat, String immatriculationPat) {
	super();
	this.naturePat = naturePat;
	this.nomPat = nomPat;
	this.immatriculationPat = immatriculationPat;
}

/**
 * 
 */
public Patrimoine() {
	super();
}



public boolean isValide() {
	return isValide;
}

public void setValide(boolean isValide) {
	this.isValide = isValide;
}

public long getIdPatrimoine() {
	return idPatrimoine;
}

public void setIdPatrimoine(long idPatrimoine) {
	this.idPatrimoine = idPatrimoine;
}

public String getNaturePat() {
	return naturePat;
}

public void setNaturePat(String naturePat) {
	this.naturePat = naturePat;
}

public String getNomPat() {
	return nomPat;
}

public void setNomPat(String nomPat) {
	this.nomPat = nomPat;
}

public String getImmatriculationPat() {
	return immatriculationPat;
}

public void setImmatriculationPat(String immatriculationPat) {
	this.immatriculationPat = immatriculationPat;
}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Patrimoine [idPatrimoine=");
	builder.append(idPatrimoine);
	builder.append(", naturePat=");
	builder.append(naturePat);
	builder.append(", nomPat=");
	builder.append(nomPat);
	builder.append(", immatriculationPat=");
	builder.append(immatriculationPat);
	builder.append("]");
	return builder.toString();
}

  

}