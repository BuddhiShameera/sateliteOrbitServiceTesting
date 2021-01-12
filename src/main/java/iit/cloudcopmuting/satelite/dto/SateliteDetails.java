package iit.cloudcopmuting.satelite.dto;

import java.math.BigDecimal;

public class SateliteDetails {

	private int sateliteID;
	private String name;
	private String description;
	private BigDecimal distance;
	private BigDecimal health;
	
	
	public int getSateliteID() {
		return sateliteID;
	}
	public void setSateliteID(int sateliteID) {
		this.sateliteID = sateliteID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getDistance() {
		return distance;
	}
	public void setDistance(BigDecimal distance) {
		this.distance = distance;
	}
	public BigDecimal getHealth() {
		return health;
	}
	public void setHealth(BigDecimal health) {
		this.health = health;
	}
	 
}
