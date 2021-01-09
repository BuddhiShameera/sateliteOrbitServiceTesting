package iit.cloudcopmuting.satelite.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iit.cloudcopmuting.satelite.controller.SateliteManagementControllerImpl;
import iit.cloudcopmuting.satelite.dao.SateliteManagementDao;
import iit.cloudcopmuting.satelite.dto.SateliteDetails;
import iit.cloudcopmuting.satelite.response.Response;
import iit.cloudcopmuting.satelite.response.SateliteDetailsResponse;

@Service
public class SateliteManagementServiceImpl implements SateliteManagementService{

	private static final Logger logger = LogManager.getLogger(SateliteManagementServiceImpl.class);
	
	@Autowired
	SateliteManagementDao sateliteDAO;
	
	@Override
	public Response getAllSatelites() {
		logger.debug("SateliteManagementServiceImpl -> getAllSatelites | Started");

		Response response = new Response();

		List<SateliteDetails> satelites = new ArrayList<SateliteDetails>();

		satelites = sateliteDAO.getAllSatelites();

		if(satelites.size() == 0)	{
			response = new Response(Response.ERROR, "ERROR", "Data query returned null");
			logger.debug("SateliteManagementServiceImpl -> getAllSatelites | Failed");
		}else {
			response = new SateliteDetailsResponse( Response.SUCCESS, "SUCCESS", "Satelites found", satelites);
			logger.debug("SateliteManagementServiceImpl -> getAllSatelites | Success");
		}

		return response;
	}

	@Override
	public Response createSatelite(SateliteDetails payload) {
		logger.debug("SateliteManagementServiceImpl -> createSatelite | Initialized");

		Response response = new Response();

		if (sateliteDAO.createSatelite(payload) == 1) {
			response = new Response(Response.SUCCESS, "SUCCESS", "Satelite created successfully!");
			logger.debug("SateliteManagementServiceImpl -> createSatelite | Success");
		} else {
			response = new Response(Response.ERROR, "ERROR", "Satelite creation error!");
		}

		logger.debug("SateliteManagementServiceImpl -> createSatelite | Finalized");
		return response;
	}

	@Override
	public Response getSateliteById(int sateliteId) {
		logger.debug("SateliteManagementServiceImpl -> getSateliteById | Started");

		Response response = new Response();

		List<SateliteDetails> satelites = new ArrayList<SateliteDetails>();

		satelites = sateliteDAO.getSateliteById(sateliteId);

		if(satelites.size() == 0)	{
			response = new Response(Response.ERROR, "ERROR", "Data query returned null");
			logger.debug("SateliteManagementServiceImpl -> getSateliteById | Failed");
		}else {
			response = new SateliteDetailsResponse( Response.SUCCESS, "SUCCESS", "Satelites found", satelites);
			logger.debug("SateliteManagementServiceImpl -> getSateliteById | Success");
		}

		return response;
	}

	@Override
	public Response controlOrbit(SateliteDetails payload) {
		logger.debug("SateliteManagementServiceImpl -> controlOrbit | Initialized");

		Response response = new Response();

		int val;
		
		val = sateliteDAO.controlOrbit(payload);

		if (val == 1) {
			logger.debug("SateliteManagementServiceImpl -> controlOrbit | Success");
			response = new Response(Response.SUCCESS, "SUCCESS", "Orbit updated successfully");
		} else {
			logger.debug("SateliteManagementServiceImpl -> controlOrbit | Error");
			response = new Response(Response.ERROR, "ERROR", "Orbit update did not behave as expected | Action will be rolled back");
		}

		logger.debug("SateliteManagementServiceImpl -> controlOrbit | Finalized");
		return response;
	}


}
