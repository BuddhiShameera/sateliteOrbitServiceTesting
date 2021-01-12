package iit.cloudcopmuting.satelite.dto;

import java.math.BigDecimal;

public class SateliteDetails {

	private int sateliteID;
	private String name;
	private String description;
	private int distance;
	private int health;
	
	
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
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	 
}
