package io.fruitbase.model.repos.team;

import org.springframework.data.jpa.repository.JpaRepository;

import io.fruitbase.model.entities.Team;

public interface TeamRepository extends JpaRepository<Team, Integer>, TeamRepositoryCustom{
	Team findByName(String name);
}
