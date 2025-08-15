package com.instituto.matricula.infaestructure.adapters.profesor;

import com.instituto.matricula.domain.model.profesor.Profesor;
import com.instituto.matricula.domain.model.profesor.ProfesorRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProfesorAdapter implements ProfesorRepository {

    private final RestTemplate restTemplate;

    public ProfesorAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Profesor findById(String uid) {
        String url = "http://localhost:8082/api/v1/instituto/profesor/" + uid;
        ProfesorData profesorData = restTemplate.getForObject(url, ProfesorData.class);
        return ProfesorMapper.MAPPER.toModel(profesorData);
    }
}
