package iit.cloudcopmuting.satelite.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import iit.cloudcopmuting.satelite.dto.SateliteDetails;
import iit.cloudcopmuting.satelite.response.Response;

public interface SateliteManagementController {

	public @ResponseBody Response getAllSatelites();
	public @ResponseBody Response createSatelite(@RequestBody SateliteDetails payload);
	public @ResponseBody Response getSateliteById(@RequestParam("sateliteID") int sateliteId);
	public @ResponseBody Response controlOrbit(@RequestBody SateliteDetails payload);
	
}
