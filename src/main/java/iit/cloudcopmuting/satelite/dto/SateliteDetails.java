package iit.cloudcopmuting.satelite.dto;

public class SateliteDetails {

	private int sateliteID;
	private String name;
	private String description;
	private double distance;
	private Double health;
	
	
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
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getHealth() {
		return health;
	}
	public void setHealth(double health) {
		this.health = health;
	}
	 
}
