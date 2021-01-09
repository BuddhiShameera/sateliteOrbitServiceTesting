package iit.cloudcopmuting.satelite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import iit.cloudcopmuting.satelite.dto.SateliteDetails;

@Repository
public class SateliteManagementDaoImpl implements SateliteManagementDao{

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public int createSatelite(SateliteDetails payload) {
		int value;

		final String query = "INSERT INTO satelite ("
				+ "name, "
				+ "description, "
				+ "distance, "
				+ "health ) "
				+ "VALUES (?,?,?,?)";


		value = jdbc.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				PreparedStatement ps = con.prepareStatement(query, new String[] {});

				ps.setString(1, payload.getName());
				ps.setString(2, payload.getDescription());
				ps.setDouble(3, payload.getDistance());
				ps.setDouble(4, payload.getHealth());

				return ps;
			}

		});

		return value;
	}

	@Override
	public int controlOrbit(SateliteDetails payload) {
		int val = 0;

		final String query = "UPDATE satelite a SET "
				+ "a.distance=?, "
				+ "WHERE a.sateliteID=?";

		val = jdbc.update(query,
				payload.getDistance(),
				payload.getSateliteID()
				);

		return val;
	}

	
	@Override
	public List<SateliteDetails> getAllSatelites() {

		final String query = "SELECT " +
				"a.sateliteID," +
				"a.name," +
				"a.description," +
				"a.distance," +
				"a.health " +
				"FROM satelite a ";


		List<SateliteDetails> satelites = new ArrayList<SateliteDetails>();

		List<Map<String, Object>> rows = jdbc.queryForList(query, new Object[] {});

		for (Map<String, Object> row : rows) {

			SateliteDetails satelite = new SateliteDetails();

			satelite.setSateliteID((Integer) row.get("sateliteID"));
			satelite.setName((String) row.get("name"));
			satelite.setDescription((String) row.get("description"));
			satelite.setDistance((Double) row.get("distance"));
			satelite.setHealth((Double) row.get("health"));

			satelites.add(satelite);

		}

		return satelites;
	}

	@Override
	public List<SateliteDetails> getSateliteById(int sateliteId) {
		final String query = "SELECT " +
				"a.sateliteID," +
				"a.name," +
				"a.description," +
				"a.distance," +
				"a.health " +
				"FROM satelite a " +
				"WHERE a.sateliteID=?";

		List<SateliteDetails> satelites = new ArrayList<SateliteDetails>();

		List<Map<String, Object>> rows = jdbc.queryForList(query, new Object[] {sateliteId});

		for (Map<String, Object> row : rows) {

			SateliteDetails satelite = new SateliteDetails();

			satelite.setSateliteID((Integer) row.get("sateliteID"));
			satelite.setName((String) row.get("name"));
			satelite.setDescription((String) row.get("description"));
			satelite.setDistance((Double) row.get("distance"));
			satelite.setHealth((Double) row.get("health"));

			satelites.add(satelite);

		}

		return satelites;
	}

}
