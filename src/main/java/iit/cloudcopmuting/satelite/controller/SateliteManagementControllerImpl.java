package iit.cloudcopmuting.satelite.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import iit.cloudcopmuting.satelite.dto.SateliteDetails;
import iit.cloudcopmuting.satelite.response.Response;
import iit.cloudcopmuting.satelite.service.SateliteManagementService;

@RequestMapping("/satelite")
@RestController
@CrossOrigin
public class SateliteManagementControllerImpl implements SateliteManagementController{
	
	private static final Logger logger = LogManager.getLogger(SateliteManagementControllerImpl.class);
	
	@Autowired
	private SateliteManagementService sateliteService;

	@Override
	@RequestMapping(value = "/getAllSatelites", method = RequestMethod.GET, produces = "application/json")
	public Response getAllSatelites() {
		
		logger.debug("SateliteManagementControllerImpl -> getAllCameras | Initiated");

		Response response = new Response();
		response = sateliteService.getAllSatelites();

		logger.debug("SateliteManagementControllerImpl -> getAllCameras | Finalized");
		
		return response;
	}

	@Override
	@RequestMapping(value = "/createSatelite", consumes = "application/json", method = RequestMethod.POST, produces = "application/json")
	public Response createSatelite(@RequestBody SateliteDetails payload) {
		logger.debug("SateliteManagementControllerImpl -> createSatelite | Initiated");

		Response response = new Response();

		if (payload.getName() != null && !payload.getName().isEmpty() && payload.getHealth() != 0 && payload.getDistance() != 0) {
			response = sateliteService.createSatelite(payload);
		} else {
			response = new Response(Response.ERROR, "ERROR", "Unacceptable payload detected");
		}

		logger.debug("SateliteManagementControllerImpl -> createSatelite | Finalized");
		
		return response;
	}

	@Override
	@RequestMapping(value = "/getSateliteById", method = RequestMethod.GET, produces = "application/json")
	public Response getSateliteById(@RequestParam("sateliteId") int sateliteId) {

		logger.debug("SateliteManagementControllerImpl -> getSateliteById | Initiated");

		Response response = new Response();

		if(sateliteId != 0) {
			response = sateliteService.getSateliteById(sateliteId);
		} else {
			response = new Response(Response.ERROR, "ERROR", "Unacceptable payload detected");
		}

		logger.debug("SateliteManagementControllerImpl -> getSateliteById | Finalized");
		return response;
	}

	@Override
	@RequestMapping(value = "/controlOrbit", consumes = "application/json", method = RequestMethod.POST, produces = "application/json")
	public Response controlOrbit(@RequestBody SateliteDetails payload) {
		logger.debug("SateliteManagementControllerImpl -> controlOrbit | Initiated");

		Response response = new Response();

		if (payload.getSateliteID() != 0  && payload.getSateliteID() != 0) {
			response = sateliteService.controlOrbit(payload);
		} else {
			response = new Response(Response.ERROR, "ERROR", "Unacceptable payload detected");
		}

		logger.debug("SateliteManagementControllerImpl -> controlOrbit | Finalized");
		return response;
	}

}
