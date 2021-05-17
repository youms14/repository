package youmssoft.repository.dto;

import java.time.LocalDate;

import youmssoft.repository.entities.ventes.Client;
import youmssoft.repository.entities.ventes.DetailsFacture;

public class FactureDto {
	 
	 private Client clientFact;
	 private float soldeFact;
	 private float nbColisFact;
	 private LocalDate dateFact;
	 private DetailsFacture myDetailsFacture;
	 
	 
	public FactureDto(Client clientFact, float soldeFact, float nbColisFact, LocalDate dateFact,
			DetailsFacture myDetailsFacture) {
		super();
		this.clientFact = clientFact;
		this.soldeFact = soldeFact;
		this.nbColisFact = nbColisFact;
		this.dateFact = dateFact;
		this.myDetailsFacture = myDetailsFacture;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FactureDto [clientFact=");
		builder.append(clientFact);
		builder.append(", soldeFact=");
		builder.append(soldeFact);
		builder.append(", nbColisFact=");
		builder.append(nbColisFact);
		builder.append(", dateFact=");
		builder.append(dateFact);
		builder.append(", myDetailsFacture=");
		builder.append(myDetailsFacture);
		builder.append("]");
		return builder.toString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientFact == null) ? 0 : clientFact.hashCode());
		result = prime * result + ((dateFact == null) ? 0 : dateFact.hashCode());
		result = prime * result + ((myDetailsFacture == null) ? 0 : myDetailsFacture.hashCode());
		result = prime * result + Float.floatToIntBits(nbColisFact);
		result = prime * result + Float.floatToIntBits(soldeFact);
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
		FactureDto other = (FactureDto) obj;
		if (clientFact == null) {
			if (other.clientFact != null)
				return false;
		} else if (!clientFact.equals(other.clientFact))
			return false;
		if (dateFact == null) {
			if (other.dateFact != null)
				return false;
		} else if (!dateFact.equals(other.dateFact))
			return false;
		if (myDetailsFacture == null) {
			if (other.myDetailsFacture != null)
				return false;
		} else if (!myDetailsFacture.equals(other.myDetailsFacture))
			return false;
		if (Float.floatToIntBits(nbColisFact) != Float.floatToIntBits(other.nbColisFact))
			return false;
		if (Float.floatToIntBits(soldeFact) != Float.floatToIntBits(other.soldeFact))
			return false;
		return true;
	}
	
	 
   
	 

}
