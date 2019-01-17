package guru.springframework.sfgpetclinic.services.springdatajps;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepositoryve;

    public VetSDJpaService(VetRepository vetRepositoryve) {
        this.vetRepositoryve = vetRepositoryve;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepositoryve.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepositoryve.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepositoryve.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepositoryve.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepositoryve.deleteById(aLong);
    }
}
