package max.dev.graphql.resolver;

import max.dev.domain.Etudiant;
import max.dev.repository.EtudiantRepository;
import org.springframework.stereotype.Component;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    private final EtudiantRepository etudiantRepository;

    public MutationResolver(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    public Etudiant createEtudiant(String nom, String prenom, String adresse, int age) {
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setAdresse(adresse);
        etudiant.setAge(age);
        return etudiantRepository.save(etudiant);
    }

    public Etudiant updateEtudiant(Long id, String nom, String prenom, String adresse, int age) {
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        if (etudiant != null) {
            etudiant.setNom(nom);
            etudiant.setPrenom(prenom);
            etudiant.setAdresse(adresse);
            etudiant.setAge(age);
            return etudiantRepository.save(etudiant);
        }
        return null;
    }

    public boolean deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
        return true;
    }
}
