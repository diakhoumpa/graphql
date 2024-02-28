package max.dev.graphql.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.List;
import max.dev.domain.Etudiant;
import max.dev.repository.EtudiantRepository;
import org.springframework.stereotype.Component;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    private final EtudiantRepository etudiantRepository;

    public QueryResolver(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    public List<Etudiant> etudiants() {
        return etudiantRepository.findAll();
    }

    public Etudiant etudiant(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }
}
