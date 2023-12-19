package com.soa.canete.funcionary.web;

import com.soa.canete.funcionary.domain.dto.FuncionaryRequestDto;
import com.soa.canete.funcionary.domain.dto.FuncionaryResponseDto;
import com.soa.canete.funcionary.repository.FuncionaryRepository;
import com.soa.canete.funcionary.service.FuncionaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/funcionaryData")
@RequiredArgsConstructor
public class FuncionaryController {

    final FuncionaryService funcionaryService;
    final FuncionaryRepository funcionaryRepository;

    @GetMapping("{id_funcionary}")
    public Mono<FuncionaryResponseDto> getDataFuncionaryById(@PathVariable Integer id_funcionary) {
        return this.funcionaryService.findById(id_funcionary);
    }

    @GetMapping("/bySoaInfo/{id_operativeunit}")
    public Flux<FuncionaryResponseDto> getDataFuncionaryByIdSoa(@PathVariable Integer id_operativeunit) {
        return this.funcionaryService.findByIdOperativeUnit(id_operativeunit);
    }

    @GetMapping("/listData")
    public Flux<FuncionaryResponseDto> getDataFuncionaryComplete() {
        return this.funcionaryService.findAll();
    }

    @GetMapping("/listData/active")
    public Flux<FuncionaryResponseDto> getDataFuncionaryActive() {
        return this.funcionaryService.findAllActive();
    }

    @GetMapping("/listData/legalGuardian")
    public Flux<FuncionaryResponseDto> getDataFuncionaryRankLegalGuardian() {
        return this.funcionaryService.findAllRankLegalGuardian();
    }

    @GetMapping("/listData/inactive")
    public Flux<FuncionaryResponseDto> getDataFuncionaryInactive() {
        return this.funcionaryService.findAllInactive();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Mono<FuncionaryResponseDto> saveNewDataFuncionary(@RequestBody FuncionaryRequestDto dto) {
        return this.funcionaryService.saveNewLegalGuardian(dto);
    }

    @PutMapping("/{id_funcionary}")
    public Mono<FuncionaryResponseDto> updateDataFuncionary(@RequestBody FuncionaryRequestDto dto, @PathVariable Integer id_funcionary) {
        return this.funcionaryService.updateLegalGuardian(dto, id_funcionary);
    }

    @PatchMapping("/deleteLogical/{id_funcionary}")
    public Mono<FuncionaryResponseDto> deleteLogicalFuncionary(@PathVariable Integer id_funcionary) {
        return this.funcionaryService.deleteLogicalLegalGuardian(id_funcionary);
    }

    @PatchMapping("/reactiveLogical/{id_funcionary}")
    public Mono<FuncionaryResponseDto> reactiveLogicalFuncionary(@PathVariable Integer id_funcionary) {
        return this.funcionaryService.reactiveLogicalLegalGuardian(id_funcionary);
    }

    @DeleteMapping("/{id_funcionary}")
    public Mono<Void> deleteTotalFuncionary(@PathVariable Integer id_funcionary) {
        return this.funcionaryService.deleteLegalGuardian(id_funcionary);
    }

    @GetMapping("/export-pdf")
    public Mono<ResponseEntity<byte[]>> exportPdf() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("FuncReport", "FuncReport.pdf");

        return funcionaryService.exportPdf()
                .flatMap(pdfBytes -> pdfBytes)
                .map(pdfBytes -> ResponseEntity.ok().headers(headers).body(pdfBytes));
    }

}
