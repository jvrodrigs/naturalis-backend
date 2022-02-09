package app.naturalis.backend.service;

import app.naturalis.backend.model.Substancias;
import app.naturalis.backend.repository.SubstanciasRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubstanciasService {

    @Autowired
    private SubstanciasRepository substanciasRepository;

    public Substancias newSubst(Substancias substancias){
        return this.substanciasRepository.save(substancias);
    }

    public Optional<Substancias> getById(int id){
        Optional<Substancias> subsById = Optional.ofNullable(this.substanciasRepository.findById(id).orElseThrow( () ->
                new EmptyResultDataAccessException((1))));
        return subsById;
    }

    public void removeSubsById(int id){
        this.substanciasRepository.deleteById(id);
    }

    public Substancias editById(int id, Substancias substancias){
        Optional<Substancias> saveSubs = Optional.ofNullable(this.substanciasRepository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1)));
        BeanUtils.copyProperties(substancias, saveSubs.get(), "id");
        return this.substanciasRepository.save(saveSubs.get());
    }
}
