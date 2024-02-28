package max.dev.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class EtudiantTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static Etudiant getEtudiantSample1() {
        return new Etudiant().id(1L).adresse("adresse1").nom("nom1").prenom("prenom1").age(1);
    }

    public static Etudiant getEtudiantSample2() {
        return new Etudiant().id(2L).adresse("adresse2").nom("nom2").prenom("prenom2").age(2);
    }

    public static Etudiant getEtudiantRandomSampleGenerator() {
        return new Etudiant()
            .id(longCount.incrementAndGet())
            .adresse(UUID.randomUUID().toString())
            .nom(UUID.randomUUID().toString())
            .prenom(UUID.randomUUID().toString())
            .age(intCount.incrementAndGet());
    }
}
