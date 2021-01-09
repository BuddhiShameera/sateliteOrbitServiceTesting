package iit.cloudcopmuting.satelite.response;

import java.util.List;

import iit.cloudcopmuting.satelite.dto.SateliteDetails;

public class SateliteDetailsResponse extends Response {

    List<SateliteDetails> sateliteDetails;
    int totalItems;

    public SateliteDetailsResponse(int id, String status, String description, List<SateliteDetails> sateliteDetails) {
        super(id, status, description);
        this.sateliteDetails = sateliteDetails;
    }

    public SateliteDetailsResponse(int id, String status, String description, List<SateliteDetails> sateliteDetails, int totalItems) {
        super(id, status, description);
        this.sateliteDetails = sateliteDetails;
        this.totalItems = totalItems;
    }

	public List<SateliteDetails> getSateliteDetails() {
		return sateliteDetails;
	}

	public void setSateliteDetails(List<SateliteDetails> sateliteDetails) {
		this.sateliteDetails = sateliteDetails;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

    
}
