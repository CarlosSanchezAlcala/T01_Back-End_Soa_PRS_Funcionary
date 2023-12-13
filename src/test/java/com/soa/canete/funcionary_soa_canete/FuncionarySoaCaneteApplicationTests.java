package com.soa.canete.funcionary_soa_canete;

import com.soa.canete.funcionary_soa_canete.domain.dto.FuncionaryRequestDto;
import com.soa.canete.funcionary_soa_canete.repository.FuncionaryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;

@SpringBootTest
@AutoConfigureWebTestClient
class FuncionarySoaCaneteApplicationTests {

    @Autowired
    FuncionaryRepository funcionaryRepository;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreateFuncionary() {
        FuncionaryRequestDto newDataFuncionaryNecesaryPjUnit = new FuncionaryRequestDto(
                "Jose Alberto",
                "Sanchez",
                "Campos",
                "25632547",
                "985632547",
                "Ayudante",
                "S",
                "Av. Garcilazo de la Vega Mz B Lote 232",
                "JoseAlberto@outlook.com",
                "150101",
                3,
                "A");

        webTestClient.post()
                .uri("/api/funcionaryData")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(newDataFuncionaryNecesaryPjUnit), FuncionaryRequestDto.class)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(FuncionaryRequestDto.class);

        System.out.println("Se ha creado correctamente: " + newDataFuncionaryNecesaryPjUnit);
    }

    @Test
    public void testListFuncioary() {
        webTestClient.get().uri("/api/funcionaryData/listData")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(FuncionaryRequestDto.class)
                .consumeWith(response -> {
                    List<FuncionaryRequestDto> dataList = response.getResponseBody();
                    Assertions.assertTrue(dataList != null && !dataList.isEmpty(), "La lista no debe de estar vacía.");
                    Assertions.assertFalse(false, "La lista debe contener al menos " + 1 + " elemento.");
                    System.out.println("Funciorios: " + dataList);
                });


    }

    @Test
    public void testListFuncionaryLegalGuardian() {
         webTestClient.get().uri("/api/funcionaryData/listData/legalGuardian")
                 .exchange()
                 .expectStatus().isOk()
                 .expectHeader().contentType(MediaType.APPLICATION_JSON)
                 .expectBodyList(FuncionaryRequestDto.class)
                 .consumeWith(response -> {
                     List<FuncionaryRequestDto> dataList = response.getResponseBody();
                     Assertions.assertTrue(dataList != null && !dataList.isEmpty(), "La lista no debe de estar vacia");
                     Assertions.assertFalse(false, "La lista debe contener almenos " + 1 + " elemento.");
                     System.out.println("Tutores Legales: " + dataList);
                 });
    }

    @Test
    public void testListInactiveFuncionary() {
        webTestClient.get().uri("/api/funcionaryData/listData/inactive")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(FuncionaryRequestDto.class)
                .consumeWith(response -> {
                    List<FuncionaryRequestDto> dataList = response.getResponseBody();
                    Assertions.assertTrue(dataList != null && !dataList.isEmpty(), "La lista no debe de estar vacía: ");
                    Assertions.assertTrue(true, "La lista debe contener al menos " + 1 + " elementos");
                    System.out.println("Funcionarios inactivos: " + dataList);
                });

    }

    @Test
    public void testListActiveFuncionary() {
        webTestClient.get().uri("/api/funcionaryData/listData/active")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(FuncionaryRequestDto.class)
                .consumeWith(response -> {
                    List<FuncionaryRequestDto> dataList = response.getResponseBody();
                    Assertions.assertTrue(dataList != null && !dataList.isEmpty(), "La lista no debe de estar vacía: ");
                    Assertions.assertTrue(true, "La lista debe contener al menos " + 1 + " elementos");
                    System.out.println("Funcionarios activos: " + dataList);
                });

    }

    @ParameterizedTest
    @ValueSource(ints = {27})
    public void testUpdateDataFuncionary(int dataId) {
        FuncionaryRequestDto UpdateLegalGuardian = new FuncionaryRequestDto(
                "Mayckel Josefino",
                "Huaman",
                "Minu",
                "52365414",
                "963235689",
                "Ayudante",
                "S",
                "Av. Garcilazo de la Vega Mz B Lote 231",
                "JoseHuaman@outlook.com",
                "150101",
                1,
                "A");

        webTestClient.put().uri("/api/funcionaryData/{id_funcionary}", dataId)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(UpdateLegalGuardian)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(FuncionaryRequestDto.class)
                .consumeWith(response -> {
                });
    }

}
