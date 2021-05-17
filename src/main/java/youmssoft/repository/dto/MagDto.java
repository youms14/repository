package youmssoft.repository.dto;

public class MagDto {
	private float quantiteSABC;
	private float quantiteUCB;
	private float quantiteGUI;
	
	
	
	public MagDto() {
		super();
	}
	public MagDto(float quantiteSABC, float quantiteUCB, float quantiteGUI) {
		super();
		this.quantiteSABC = quantiteSABC;
		this.quantiteUCB = quantiteUCB;
		this.quantiteGUI = quantiteGUI;
	}
	public float getQuantiteSABC() {
		return quantiteSABC;
	}
	public void setQuantiteSABC(float quantiteSABC) {
		this.quantiteSABC = quantiteSABC;
	}
	public float getQuantiteUCB() {
		return quantiteUCB;
	}
	public void setQuantiteUCB(float quantiteUCB) {
		this.quantiteUCB = quantiteUCB;
	}
	public float getQuantiteGUI() {
		return quantiteGUI;
	}
	public void setQuantiteGUI(float quantiteGUI) {
		this.quantiteGUI = quantiteGUI;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MagDto [quantiteSABC=");
		builder.append(quantiteSABC);
		builder.append(", quantiteUCB=");
		builder.append(quantiteUCB);
		builder.append(", quantiteGUI=");
		builder.append(quantiteGUI);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
