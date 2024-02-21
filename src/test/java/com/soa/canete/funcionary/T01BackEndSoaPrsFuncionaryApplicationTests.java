package com.soa.canete.funcionary;

import com.soa.canete.funcionary.domain.model.Funcionary;
import com.soa.canete.funcionary.repository.FuncionaryRepository;
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

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
@AutoConfigureWebTestClient
class T01BackEndSoaPrsFuncionaryApplicationTests {

    @Autowired
    FuncionaryRepository funcionaryRepository;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void contextLoads() {
        System.out.println("Cargando contexto de pruebas -------- Existosamente");
    }

    /*
    @Test
    void testCreateFuncionary() {
        Funcionary newLegalGuardian = new Funcionary(
                "Boris Josefino Martino",
                "Alcantara",
                "Gonzalez",
                "73829730",
                "997533646",
                "Legislador",
                "S",
                "Las Palmas",
                "rey@gmail.com",
                "010116",
                1,
                "A");

        String accessToken = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJpdU9aUFYySFpWVHRYU2NUX21BRkRCZG1kWGdHcllCQlI5Q0o0cEtWTFk4In0.eyJleHAiOjE3MDI5Njc4NDYsImlhdCI6MTcwMjk2NzU0NiwiYXV0aF90aW1lIjoxNzAyOTY1NzMzLCJqdGkiOiIxYmFhNzhjYS1mYTQ3LTQwZGUtYTdlOS02MGI1OGVlNGQyNjUiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjkwOTEvcmVhbG1zL1NPQSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiIyOTMwNmRiZC02ZGM1LTRjM2EtOGI0Zi1hYjA2M2UzYWQ5NTYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJTT0EiLCJub25jZSI6ImIzZzVPRWh6TlU1SlQyZE5VRnBVTkdJNVNFOURRMzVyZDFGVU4xVmtkVEJIWlhkeUxucHBkR2RsTlhoTCIsInNlc3Npb25fc3RhdGUiOiIxMWNhNmJlMi02NzMyLTRlMjEtYTBhYS00NTVkOGQ3ZGFjYzkiLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbIioiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtc29hIiwib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIG9mZmxpbmVfYWNjZXNzIHByb2ZpbGUgZW1haWwiLCJzaWQiOiIxMWNhNmJlMi02NzMyLTRlMjEtYTBhYS00NTVkOGQ3ZGFjYzkiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwicHJlZmVycmVkX3VzZXJuYW1lIjoiYWRtaW4iLCJlbWFpbCI6ImNhcmxvcy5zYW5jaGV6QHZhbGxlZ3JhbmRlLmVkdS5wZSJ9.VqVWGsywBvzaEiyDXUOnEaPGvmb3_VT0GjkRXBn0y18yu5kraAU5EH0oX2tU_zzYgqzOCMZQr-2ZjVDVjK58eHPs81-c1096m2FzlGXXjm2LE0GpCigTfOGqVFzB1IWreNZnUjAibZmzkCDRTmfNdo0AzZaI90zxwPVuLp7v7HkJXS6nNlfnowjdqu1TZFYQrNzPp7o_JyDMtj4lZPpJpLVSZxlQ7-duLR9mNQ2ss0hTvpVdT7UdjRZezYb6haAU_DoYw0DZD2mp-cWLuwtTVD_UY_vn83Bvc8Cmn_R5bee5Eg3QnU-Kpq4jG0YMfD-OiRZwTNHBRQjuMHDMnj_Qdg";

        webTestClient.post()
                .uri("/api/funcionaryData")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + accessToken)
                .body(Mono.just(newLegalGuardian), Funcionary.class)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Funcionary.class);

        System.out.println("Funcionario creado correctamente" + newLegalGuardian);
    }

    @Test
    public void testListFuncionary() {

        String accessToken = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJpdU9aUFYySFpWVHRYU2NUX21BRkRCZG1kWGdHcllCQlI5Q0o0cEtWTFk4In0.eyJleHAiOjE3MDI5Njc2MTksImlhdCI6MTcwMjk2NzMxOSwiYXV0aF90aW1lIjoxNzAyOTY1NzMzLCJqdGkiOiI2ZGY4ZGVkNy0wZTg3LTRkMWQtYmVjOS00M2Q3Yjc1ZGE0N2IiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjkwOTEvcmVhbG1zL1NPQSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiIyOTMwNmRiZC02ZGM1LTRjM2EtOGI0Zi1hYjA2M2UzYWQ5NTYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJTT0EiLCJub25jZSI6ImIzZzVPRWh6TlU1SlQyZE5VRnBVTkdJNVNFOURRMzVyZDFGVU4xVmtkVEJIWlhkeUxucHBkR2RsTlhoTCIsInNlc3Npb25fc3RhdGUiOiIxMWNhNmJlMi02NzMyLTRlMjEtYTBhYS00NTVkOGQ3ZGFjYzkiLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbIioiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtc29hIiwib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIG9mZmxpbmVfYWNjZXNzIHByb2ZpbGUgZW1haWwiLCJzaWQiOiIxMWNhNmJlMi02NzMyLTRlMjEtYTBhYS00NTVkOGQ3ZGFjYzkiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwicHJlZmVycmVkX3VzZXJuYW1lIjoiYWRtaW4iLCJlbWFpbCI6ImNhcmxvcy5zYW5jaGV6QHZhbGxlZ3JhbmRlLmVkdS5wZSJ9.p3YpA89IB4F99eNHwbT4g_2IZ8eeLs-CkdC9wnJeL3hb5bGs9jYQG78wo3f8jMapMR5HDSXUTF0ypdkVwufDk_4VJqUxcVHRxPN1p6lhYSXFVz5dc3FqHPRsIdcYQUhZbSb120UCs4POep7oGhIhBupERPPsJAomN-Tvc1YL5RbQq6TMdahlbL3w_g1UcJGtdY7nNqIfGiWo5UW_qYePk6hdg_TlCQZqNB6yMAi77kNdFbPC1SBimtEenkdIM3ilgAL_eEbKRQ0OzTvOxxskU0S8H0PGZTzD8BPZ2pADkDuS34loCuCUAlMP2m0YIlxdzgQeKPTcsnhizOBFvM45gg";

        webTestClient.get().uri("/api/funcionaryData/listData")
                .header("Authorization", "Bearer " + accessToken)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Funcionary.class)
                .consumeWith(response -> {
                    List<Funcionary> dataList = response.getResponseBody();
                    Assertions.assertTrue(dataList != null && !dataList.isEmpty(), "La lista no debe de estar vacía: ");
                    Assertions.assertFalse(false, "La lista debe contener al menos " + 1 + " elementos");
                    System.out.println(dataList);
                });
    }

    @Test
    public void testListInactiveLegalGuardian() {

        String accessToken = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJpdU9aUFYySFpWVHRYU2NUX21BRkRCZG1kWGdHcllCQlI5Q0o0cEtWTFk4In0.eyJleHAiOjE3MDI5Njc2MTksImlhdCI6MTcwMjk2NzMxOSwiYXV0aF90aW1lIjoxNzAyOTY1NzMzLCJqdGkiOiI2ZGY4ZGVkNy0wZTg3LTRkMWQtYmVjOS00M2Q3Yjc1ZGE0N2IiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjkwOTEvcmVhbG1zL1NPQSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiIyOTMwNmRiZC02ZGM1LTRjM2EtOGI0Zi1hYjA2M2UzYWQ5NTYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJTT0EiLCJub25jZSI6ImIzZzVPRWh6TlU1SlQyZE5VRnBVTkdJNVNFOURRMzVyZDFGVU4xVmtkVEJIWlhkeUxucHBkR2RsTlhoTCIsInNlc3Npb25fc3RhdGUiOiIxMWNhNmJlMi02NzMyLTRlMjEtYTBhYS00NTVkOGQ3ZGFjYzkiLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbIioiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtc29hIiwib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIG9mZmxpbmVfYWNjZXNzIHByb2ZpbGUgZW1haWwiLCJzaWQiOiIxMWNhNmJlMi02NzMyLTRlMjEtYTBhYS00NTVkOGQ3ZGFjYzkiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwicHJlZmVycmVkX3VzZXJuYW1lIjoiYWRtaW4iLCJlbWFpbCI6ImNhcmxvcy5zYW5jaGV6QHZhbGxlZ3JhbmRlLmVkdS5wZSJ9.p3YpA89IB4F99eNHwbT4g_2IZ8eeLs-CkdC9wnJeL3hb5bGs9jYQG78wo3f8jMapMR5HDSXUTF0ypdkVwufDk_4VJqUxcVHRxPN1p6lhYSXFVz5dc3FqHPRsIdcYQUhZbSb120UCs4POep7oGhIhBupERPPsJAomN-Tvc1YL5RbQq6TMdahlbL3w_g1UcJGtdY7nNqIfGiWo5UW_qYePk6hdg_TlCQZqNB6yMAi77kNdFbPC1SBimtEenkdIM3ilgAL_eEbKRQ0OzTvOxxskU0S8H0PGZTzD8BPZ2pADkDuS34loCuCUAlMP2m0YIlxdzgQeKPTcsnhizOBFvM45gg";

        webTestClient.get().uri("/api/funcionaryData/listData/inactive")
                .header("Authorization", "Bearer " + accessToken)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Funcionary.class)
                .consumeWith(response -> {
                    List<Funcionary> dataList = response.getResponseBody();
                    Assertions.assertTrue(dataList != null && !dataList.isEmpty(), "La lista no debe de estar vacía: ");
                    Assertions.assertTrue(true, "La lista debe contener al menos " + 1 + " elementos");
                    System.out.println(dataList);
                });
    }

    @Test
    public void testListActiveLegalGuardian() {

        String accessToken = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJpdU9aUFYySFpWVHRYU2NUX21BRkRCZG1kWGdHcllCQlI5Q0o0cEtWTFk4In0.eyJleHAiOjE3MDI5Njc2MTksImlhdCI6MTcwMjk2NzMxOSwiYXV0aF90aW1lIjoxNzAyOTY1NzMzLCJqdGkiOiI2ZGY4ZGVkNy0wZTg3LTRkMWQtYmVjOS00M2Q3Yjc1ZGE0N2IiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjkwOTEvcmVhbG1zL1NPQSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiIyOTMwNmRiZC02ZGM1LTRjM2EtOGI0Zi1hYjA2M2UzYWQ5NTYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJTT0EiLCJub25jZSI6ImIzZzVPRWh6TlU1SlQyZE5VRnBVTkdJNVNFOURRMzVyZDFGVU4xVmtkVEJIWlhkeUxucHBkR2RsTlhoTCIsInNlc3Npb25fc3RhdGUiOiIxMWNhNmJlMi02NzMyLTRlMjEtYTBhYS00NTVkOGQ3ZGFjYzkiLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbIioiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtc29hIiwib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIG9mZmxpbmVfYWNjZXNzIHByb2ZpbGUgZW1haWwiLCJzaWQiOiIxMWNhNmJlMi02NzMyLTRlMjEtYTBhYS00NTVkOGQ3ZGFjYzkiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwicHJlZmVycmVkX3VzZXJuYW1lIjoiYWRtaW4iLCJlbWFpbCI6ImNhcmxvcy5zYW5jaGV6QHZhbGxlZ3JhbmRlLmVkdS5wZSJ9.p3YpA89IB4F99eNHwbT4g_2IZ8eeLs-CkdC9wnJeL3hb5bGs9jYQG78wo3f8jMapMR5HDSXUTF0ypdkVwufDk_4VJqUxcVHRxPN1p6lhYSXFVz5dc3FqHPRsIdcYQUhZbSb120UCs4POep7oGhIhBupERPPsJAomN-Tvc1YL5RbQq6TMdahlbL3w_g1UcJGtdY7nNqIfGiWo5UW_qYePk6hdg_TlCQZqNB6yMAi77kNdFbPC1SBimtEenkdIM3ilgAL_eEbKRQ0OzTvOxxskU0S8H0PGZTzD8BPZ2pADkDuS34loCuCUAlMP2m0YIlxdzgQeKPTcsnhizOBFvM45gg";

        webTestClient.get().uri("/api/funcionaryData/listData/active")
                .header("Authorization", "Bearer " + accessToken)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Funcionary.class)
                .consumeWith(response -> {
                    List<Funcionary> dataList = response.getResponseBody();
                    Assertions.assertTrue(dataList != null && !dataList.isEmpty(), "La lista no debe de estar vacía: ");
                    Assertions.assertTrue(true, "La lista debe contener al menos " + 1 + " elementos");
                    System.out.println(dataList);
                });
    }

    @ParameterizedTest
    @ValueSource(ints = {32})
    public void testUpdateFuncionary(int dataId) {
        Funcionary UpdateFuncionary = new Funcionary(
                "Boris Albertino",
                "Alcantara",
                "Gonzalez",
                "73829730",
                "997533646",
                "Legislador",
                "S",
                "Las Palmas",
                "rey@gmail.com",
                "010116",
                1,
                "A");

        String accessToken = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJpdU9aUFYySFpWVHRYU2NUX21BRkRCZG1kWGdHcllCQlI5Q0o0cEtWTFk4In0.eyJleHAiOjE3MDI5Njc2MTksImlhdCI6MTcwMjk2NzMxOSwiYXV0aF90aW1lIjoxNzAyOTY1NzMzLCJqdGkiOiI2ZGY4ZGVkNy0wZTg3LTRkMWQtYmVjOS00M2Q3Yjc1ZGE0N2IiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjkwOTEvcmVhbG1zL1NPQSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiIyOTMwNmRiZC02ZGM1LTRjM2EtOGI0Zi1hYjA2M2UzYWQ5NTYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJTT0EiLCJub25jZSI6ImIzZzVPRWh6TlU1SlQyZE5VRnBVTkdJNVNFOURRMzVyZDFGVU4xVmtkVEJIWlhkeUxucHBkR2RsTlhoTCIsInNlc3Npb25fc3RhdGUiOiIxMWNhNmJlMi02NzMyLTRlMjEtYTBhYS00NTVkOGQ3ZGFjYzkiLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbIioiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtc29hIiwib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIG9mZmxpbmVfYWNjZXNzIHByb2ZpbGUgZW1haWwiLCJzaWQiOiIxMWNhNmJlMi02NzMyLTRlMjEtYTBhYS00NTVkOGQ3ZGFjYzkiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwicHJlZmVycmVkX3VzZXJuYW1lIjoiYWRtaW4iLCJlbWFpbCI6ImNhcmxvcy5zYW5jaGV6QHZhbGxlZ3JhbmRlLmVkdS5wZSJ9.p3YpA89IB4F99eNHwbT4g_2IZ8eeLs-CkdC9wnJeL3hb5bGs9jYQG78wo3f8jMapMR5HDSXUTF0ypdkVwufDk_4VJqUxcVHRxPN1p6lhYSXFVz5dc3FqHPRsIdcYQUhZbSb120UCs4POep7oGhIhBupERPPsJAomN-Tvc1YL5RbQq6TMdahlbL3w_g1UcJGtdY7nNqIfGiWo5UW_qYePk6hdg_TlCQZqNB6yMAi77kNdFbPC1SBimtEenkdIM3ilgAL_eEbKRQ0OzTvOxxskU0S8H0PGZTzD8BPZ2pADkDuS34loCuCUAlMP2m0YIlxdzgQeKPTcsnhizOBFvM45gg";

        webTestClient.put().uri("/api/funcionaryData/{id}", dataId)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + accessToken)
                .bodyValue(UpdateFuncionary)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(Funcionary.class)
                .consumeWith(response -> {
                });

        System.out.println("Funcionario actualizado correctamente" + UpdateFuncionary);

    }
    */
}
