package domain.model;

import java.util.Objects;
import java.util.UUID;

// Entité de domaine représentant une équipe e-sport
public class Team {
    private final String id;
    private final String name;

    public Team(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Team ofName(String name) {
        return new Team(UUID.randomUUID().toString(), name);
    }

    public String getId() { return id; }
    public String getName() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
