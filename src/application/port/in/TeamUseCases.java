package application.port.in;

import domain.model.Team;

import java.util.List;

// Port entrant (use cases) exposé par l'application
public interface TeamUseCases {
    Team createTeam(String name);
    List<Team> listTeams();
}
