package io.fruitbase.business.services.team;





import java.util.List;

import io.fruitbase.model.entities.Team;

public interface TeamService {
	
	Team create(Team team);
	List<Team> listAll();
	Team findByName(String name);
	boolean delete(int id);
	Team update(int id, Team team);
	
}
