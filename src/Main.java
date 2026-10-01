// Point d'entrée de l'application (couche de démarrage)
// Cette classe câble explicitement les dépendances entre l'application (ports entrants)
// et l'infrastructure (adaptateurs sortants), selon l'architecture hexagonale.

import application.port.in.TeamUseCases;
import application.service.TeamService;
import infrastructure.adapter.out.memory.InMemoryTeamRepository;
import domain.model.Team;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Adaptateur sortant (Infrastructure) implémentant le port de sortie du domaine
        var teamRepository = new InMemoryTeamRepository();

        // Service d'application implémentant le port entrant (use cases)
        TeamUseCases teamService = new TeamService(teamRepository);

        // Démonstration de deux cas d'usage: création et liste des équipes
        teamService.createTeam("Blue Warriors");
        teamService.createTeam("Red Dragons");

        List<Team> teams = teamService.listTeams();
        System.out.println("Equipes enregistrées:");
        for (Team t : teams) {
            System.out.println("- " + t.getName() + " (" + t.getId() + ")");
        }
    }
}
