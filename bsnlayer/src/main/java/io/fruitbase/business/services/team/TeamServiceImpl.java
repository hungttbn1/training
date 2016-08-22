package io.fruitbase.business.services.team;



import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import io.fruitbase.model.entities.Team;
import io.fruitbase.model.repos.team.TeamRepository;
@Service
public class TeamServiceImpl implements TeamService{
	
	@Autowired
	private TeamRepository teamRep;

	@Override
	public Team create(Team team) {
		
		team = teamRep.saveAndFlush(team);
		return team;
	}
	@Transactional
	@Override
	public List<Team> listAll() {
		
		List<Team> teams = teamRep.findAll();
		return teams;
		
		
	}
	@Override
	public Team findByName(String name) {
		Team team = teamRep.findByName(name);
		return team;
	}
	@Override
	public boolean delete(int id) {
		teamRep.delete(id);
		return true;
		 
	}
	
	public Team update(int id, Team team){
		team = teamRep.findOne(id);
		return team = teamRep.saveAndFlush(team);
		
	}

	
}
