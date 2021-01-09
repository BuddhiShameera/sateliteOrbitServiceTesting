package iit.cloudcopmuting.satelite.dao;

import java.util.List;

import iit.cloudcopmuting.satelite.dto.SateliteDetails;

public interface SateliteManagementDao {

	public int createSatelite(SateliteDetails payload);
    public int controlOrbit(SateliteDetails payload);
    public List<SateliteDetails> getAllSatelites();
    public List<SateliteDetails> getSateliteById(int sateliteId);
}
