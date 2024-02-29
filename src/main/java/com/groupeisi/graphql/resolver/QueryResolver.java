package com.groupeisi.graphql.resolver;

import com.groupeisi.domain.Etudiant;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.List;

import com.groupeisi.repository.EtudiantRepository;
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
