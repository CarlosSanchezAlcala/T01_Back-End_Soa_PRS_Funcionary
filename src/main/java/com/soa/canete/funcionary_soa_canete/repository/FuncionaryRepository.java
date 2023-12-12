package com.soa.canete.funcionary_soa_canete.repository;

import com.soa.canete.funcionary_soa_canete.domain.model.Funcionary;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface FuncionaryRepository extends ReactiveCrudRepository<Funcionary, Integer> {

    Flux<Funcionary> findByIdOperativeUnit(Integer idOperativeUnit);

}
