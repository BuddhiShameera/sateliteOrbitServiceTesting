package iit.cloudcopmuting.satelite.service;

import iit.cloudcopmuting.satelite.dto.SateliteDetails;
import iit.cloudcopmuting.satelite.response.Response;

public interface SateliteManagementService {

	public Response getAllSatelites();
	public Response createSatelite(SateliteDetails payload);
	public Response getSateliteById(int sateliteId);
	public Response controlOrbit(SateliteDetails payload);
}
