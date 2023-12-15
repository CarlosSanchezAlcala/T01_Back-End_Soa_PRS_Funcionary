package com.soa.canete.funcionary.service.impl;

import com.soa.canete.funcionary.domain.dto.FuncionaryRequestDto;
import com.soa.canete.funcionary.domain.dto.FuncionaryResponseDto;
import com.soa.canete.funcionary.domain.mapper.FuncionaryMapper;
import com.soa.canete.funcionary.domain.model.Funcionary;
import com.soa.canete.funcionary.exception.ResourceNotFoundException;
import com.soa.canete.funcionary.repository.FuncionaryRepository;
import com.soa.canete.funcionary.service.FuncionaryService;
import com.soa.canete.funcionary.util.FuncReportGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

import static com.soa.canete.funcionary.domain.mapper.FuncionaryMapper.toModel;

@Slf4j
@Service
@RequiredArgsConstructor
public class FuncionaryImpl implements FuncionaryService {

    final FuncionaryRepository funcionaryRepository;

    private FuncReportGenerator funcReportGenerator;

    private WebClient.Builder webClientBuilder;
    @Autowired
    public FuncionaryImpl(FuncionaryRepository funcionaryRepository, FuncReportGenerator funcReportGenerator, WebClient.Builder webClientBuilder) {
        this.funcionaryRepository = funcionaryRepository;
        this.funcReportGenerator = funcReportGenerator;
        this.webClientBuilder = webClientBuilder;
    }


    @Override
    public Mono<FuncionaryResponseDto> findById(Integer id_funcionary) {
        return this.funcionaryRepository.findById(id_funcionary)
                .map(FuncionaryMapper::toDto);
    }

    @Override
    public Flux<FuncionaryResponseDto> findByIdOperativeUnit(Integer id_operativeunit) {
        return this.funcionaryRepository.findByIdOperativeUnit(id_operativeunit)
                .filter((legalGuardian) -> legalGuardian.getConfirmation().equals("S"))
                .map(FuncionaryMapper::toDto);
    }

    @Override
    public Flux<FuncionaryResponseDto> findAll() {
        return this.funcionaryRepository.findAll()
                .sort(Comparator.comparing(Funcionary::getId_funcionary).reversed())
                .map(FuncionaryMapper::toDto);
    }

    @Override
    public Flux<FuncionaryResponseDto> findAllActive() {
        return this.funcionaryRepository.findAll()
                .sort(Comparator.comparing(Funcionary::getId_funcionary).reversed())
                .filter(active -> active.getStatus().equals("A"))
                .map(FuncionaryMapper::toDto);
    }

    @Override
    public Flux<FuncionaryResponseDto> findAllRankLegalGuardian() {
        return this.funcionaryRepository.findAll()
                .sort(Comparator.comparing(Funcionary::getId_funcionary).reversed())
                .filter((legalGuardian) -> legalGuardian.getConfirmation().equals("S"))
                .filter((legalGuardian) -> legalGuardian.getStatus().equals("A"))
                .map(FuncionaryMapper::toDto);
    }

    @Override
    public Flux<FuncionaryResponseDto> findAllInactive() {
        return this.funcionaryRepository.findAll()
                .sort(Comparator.comparing(Funcionary::getId_funcionary).reversed())
                .filter(active -> active.getStatus().equals("I"))
                .map(FuncionaryMapper::toDto);
    }

    @Override
    public Mono<FuncionaryResponseDto> saveNewLegalGuardian(FuncionaryRequestDto request) {
        return this.funcionaryRepository.save(toModel(request))
                .map(FuncionaryMapper::toDto);
    }

    @Override
    public Mono<FuncionaryResponseDto> updateLegalGuardian(FuncionaryRequestDto request, Integer id_funcionary) {
        return this.funcionaryRepository.findById(id_funcionary)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El identificador: " + id_funcionary + "no fue encontrado.")))
                .flatMap(dataFuncionary -> this.funcionaryRepository.save(toModel(request, dataFuncionary.getId_funcionary())))
                .map(FuncionaryMapper::toDto);
    }

    @Override
    public Mono<FuncionaryResponseDto> deleteLogicalLegalGuardian(Integer id_funcionary) {
        return this.funcionaryRepository.findById(id_funcionary)
                .map((delete) -> {
                    delete.setStatus("I");
                    return delete;
                })
                .flatMap(funcionaryRepository::save)
                .map(FuncionaryMapper::toDto);
    }

    @Override
    public Mono<FuncionaryResponseDto> reactiveLogicalLegalGuardian(Integer id_funcionary) {
        return this.funcionaryRepository.findById(id_funcionary)
                .map((reactive) -> {
                    reactive.setStatus("A");
                    return reactive;
                })
                .flatMap(funcionaryRepository::save)
                .map(FuncionaryMapper::toDto);
    }

    @Override
    public Mono<Void> deleteLegalGuardian(Integer id_funcionary) {
        return this.funcionaryRepository.deleteById(id_funcionary);
    }

    @Override
    public Mono<Mono<byte[]>> exportPdf() {
        return funcionaryRepository.findAll()
                .collectList()
                .map(funcReportGenerator::exportToPdf);
    }

}
