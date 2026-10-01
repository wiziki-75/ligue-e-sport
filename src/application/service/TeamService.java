package application.service;

import application.port.in.TeamUseCases;
import application.port.out.TeamRepository;
import domain.model.Team;

import java.util.List;
import java.util.Objects;

// Service d'application implémentant les cas d'usage exposés via le port entrant
public class TeamService implements TeamUseCases {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = Objects.requireNonNull(teamRepository);
    }

    @Override
    public Team createTeam(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Le nom de l'équipe ne peut pas être vide");
        }
        Team team = Team.ofName(name.trim());
        return teamRepository.save(team);
    }

    @Override
    public List<Team> listTeams() {
        return teamRepository.findAll();
    }
}
