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
    void testCreateFuncionary() {
        Funcionary newLegalGuardian = new Funcionary(
                "Boris",
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

        String accessToken = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJpdU9aUFYySFpWVHRYU2NUX21BRkRCZG1kWGdHcllCQlI5Q0o0cEtWTFk4In0.eyJleHAiOjE3MDI5NTk5OTIsImlhdCI6MTcwMjk1OTY5MSwiYXV0aF90aW1lIjoxNzAyOTU5NjkxLCJqdGkiOiIyMGI4Zjk0Ny03YzEwLTQ3NjItYjQwNC01Y2Y2NDc4ZjQ5NGUiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjkwOTEvcmVhbG1zL1NPQSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiIyOTMwNmRiZC02ZGM1LTRjM2EtOGI0Zi1hYjA2M2UzYWQ5NTYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJTT0EiLCJub25jZSI6ImQwZHBiRXRxVFZCclkxUlBSRXR6UTNsWVNuWllZVXRxVGxRNU1tTldPRFpZVjI5dGRFdHZaVGx6WkVSeCIsInNlc3Npb25fc3RhdGUiOiIwNzUwZDdhMC1mNjM5LTQ0M2UtOWU4MC1lOTEzNTQ0NTBiNzciLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbIioiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtc29hIiwib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIG9mZmxpbmVfYWNjZXNzIHByb2ZpbGUgZW1haWwiLCJzaWQiOiIwNzUwZDdhMC1mNjM5LTQ0M2UtOWU4MC1lOTEzNTQ0NTBiNzciLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwicHJlZmVycmVkX3VzZXJuYW1lIjoiYWRtaW4iLCJlbWFpbCI6ImNhcmxvcy5zYW5jaGV6QHZhbGxlZ3JhbmRlLmVkdS5wZSJ9.q1N6ee7tnpCUGj_it52uzQT2GUqBXj4TT5DTp4ACaEHCi82w_EKpgVDgxYP_CKkZgYK7WkpBKBFf1KS_ur1sJNSTzPub77ZlLkBaP3fDgKHqFsiRXL14USEH83-ObcBYXouhb0ArA49ck1yG3mivorw81jqqm9yZDZNs-5nalk-zzytOtkOe07qtRCOiWAaP32H75OfqTwxkmElaYtu8m4URBnCjg4NnRGIxFTlBP5dl6Re9ZRNPgLa3Z-RW0CdGIaevqqE_tEGOVkebGIl_Y6vSyv67dpok79dkjj3lWceR1e0oGuYsb0mjwqmKXNt6H16cexSkYB8-feWW-rlSew";

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

        String accessToken = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJpdU9aUFYySFpWVHRYU2NUX21BRkRCZG1kWGdHcllCQlI5Q0o0cEtWTFk4In0.eyJleHAiOjE3MDI5NTk5OTIsImlhdCI6MTcwMjk1OTY5MSwiYXV0aF90aW1lIjoxNzAyOTU5NjkxLCJqdGkiOiIyMGI4Zjk0Ny03YzEwLTQ3NjItYjQwNC01Y2Y2NDc4ZjQ5NGUiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjkwOTEvcmVhbG1zL1NPQSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiIyOTMwNmRiZC02ZGM1LTRjM2EtOGI0Zi1hYjA2M2UzYWQ5NTYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJTT0EiLCJub25jZSI6ImQwZHBiRXRxVFZCclkxUlBSRXR6UTNsWVNuWllZVXRxVGxRNU1tTldPRFpZVjI5dGRFdHZaVGx6WkVSeCIsInNlc3Npb25fc3RhdGUiOiIwNzUwZDdhMC1mNjM5LTQ0M2UtOWU4MC1lOTEzNTQ0NTBiNzciLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbIioiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtc29hIiwib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIG9mZmxpbmVfYWNjZXNzIHByb2ZpbGUgZW1haWwiLCJzaWQiOiIwNzUwZDdhMC1mNjM5LTQ0M2UtOWU4MC1lOTEzNTQ0NTBiNzciLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwicHJlZmVycmVkX3VzZXJuYW1lIjoiYWRtaW4iLCJlbWFpbCI6ImNhcmxvcy5zYW5jaGV6QHZhbGxlZ3JhbmRlLmVkdS5wZSJ9.q1N6ee7tnpCUGj_it52uzQT2GUqBXj4TT5DTp4ACaEHCi82w_EKpgVDgxYP_CKkZgYK7WkpBKBFf1KS_ur1sJNSTzPub77ZlLkBaP3fDgKHqFsiRXL14USEH83-ObcBYXouhb0ArA49ck1yG3mivorw81jqqm9yZDZNs-5nalk-zzytOtkOe07qtRCOiWAaP32H75OfqTwxkmElaYtu8m4URBnCjg4NnRGIxFTlBP5dl6Re9ZRNPgLa3Z-RW0CdGIaevqqE_tEGOVkebGIl_Y6vSyv67dpok79dkjj3lWceR1e0oGuYsb0mjwqmKXNt6H16cexSkYB8-feWW-rlSew";

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

        String accessToken = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJpdU9aUFYySFpWVHRYU2NUX21BRkRCZG1kWGdHcllCQlI5Q0o0cEtWTFk4In0.eyJleHAiOjE3MDI5NTk5OTIsImlhdCI6MTcwMjk1OTY5MSwiYXV0aF90aW1lIjoxNzAyOTU5NjkxLCJqdGkiOiIyMGI4Zjk0Ny03YzEwLTQ3NjItYjQwNC01Y2Y2NDc4ZjQ5NGUiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjkwOTEvcmVhbG1zL1NPQSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiIyOTMwNmRiZC02ZGM1LTRjM2EtOGI0Zi1hYjA2M2UzYWQ5NTYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJTT0EiLCJub25jZSI6ImQwZHBiRXRxVFZCclkxUlBSRXR6UTNsWVNuWllZVXRxVGxRNU1tTldPRFpZVjI5dGRFdHZaVGx6WkVSeCIsInNlc3Npb25fc3RhdGUiOiIwNzUwZDdhMC1mNjM5LTQ0M2UtOWU4MC1lOTEzNTQ0NTBiNzciLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbIioiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtc29hIiwib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIG9mZmxpbmVfYWNjZXNzIHByb2ZpbGUgZW1haWwiLCJzaWQiOiIwNzUwZDdhMC1mNjM5LTQ0M2UtOWU4MC1lOTEzNTQ0NTBiNzciLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwicHJlZmVycmVkX3VzZXJuYW1lIjoiYWRtaW4iLCJlbWFpbCI6ImNhcmxvcy5zYW5jaGV6QHZhbGxlZ3JhbmRlLmVkdS5wZSJ9.q1N6ee7tnpCUGj_it52uzQT2GUqBXj4TT5DTp4ACaEHCi82w_EKpgVDgxYP_CKkZgYK7WkpBKBFf1KS_ur1sJNSTzPub77ZlLkBaP3fDgKHqFsiRXL14USEH83-ObcBYXouhb0ArA49ck1yG3mivorw81jqqm9yZDZNs-5nalk-zzytOtkOe07qtRCOiWAaP32H75OfqTwxkmElaYtu8m4URBnCjg4NnRGIxFTlBP5dl6Re9ZRNPgLa3Z-RW0CdGIaevqqE_tEGOVkebGIl_Y6vSyv67dpok79dkjj3lWceR1e0oGuYsb0mjwqmKXNt6H16cexSkYB8-feWW-rlSew";

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

        String accessToken = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJpdU9aUFYySFpWVHRYU2NUX21BRkRCZG1kWGdHcllCQlI5Q0o0cEtWTFk4In0.eyJleHAiOjE3MDI5NTk5OTIsImlhdCI6MTcwMjk1OTY5MSwiYXV0aF90aW1lIjoxNzAyOTU5NjkxLCJqdGkiOiIyMGI4Zjk0Ny03YzEwLTQ3NjItYjQwNC01Y2Y2NDc4ZjQ5NGUiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjkwOTEvcmVhbG1zL1NPQSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiIyOTMwNmRiZC02ZGM1LTRjM2EtOGI0Zi1hYjA2M2UzYWQ5NTYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJTT0EiLCJub25jZSI6ImQwZHBiRXRxVFZCclkxUlBSRXR6UTNsWVNuWllZVXRxVGxRNU1tTldPRFpZVjI5dGRFdHZaVGx6WkVSeCIsInNlc3Npb25fc3RhdGUiOiIwNzUwZDdhMC1mNjM5LTQ0M2UtOWU4MC1lOTEzNTQ0NTBiNzciLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbIioiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtc29hIiwib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIG9mZmxpbmVfYWNjZXNzIHByb2ZpbGUgZW1haWwiLCJzaWQiOiIwNzUwZDdhMC1mNjM5LTQ0M2UtOWU4MC1lOTEzNTQ0NTBiNzciLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwicHJlZmVycmVkX3VzZXJuYW1lIjoiYWRtaW4iLCJlbWFpbCI6ImNhcmxvcy5zYW5jaGV6QHZhbGxlZ3JhbmRlLmVkdS5wZSJ9.q1N6ee7tnpCUGj_it52uzQT2GUqBXj4TT5DTp4ACaEHCi82w_EKpgVDgxYP_CKkZgYK7WkpBKBFf1KS_ur1sJNSTzPub77ZlLkBaP3fDgKHqFsiRXL14USEH83-ObcBYXouhb0ArA49ck1yG3mivorw81jqqm9yZDZNs-5nalk-zzytOtkOe07qtRCOiWAaP32H75OfqTwxkmElaYtu8m4URBnCjg4NnRGIxFTlBP5dl6Re9ZRNPgLa3Z-RW0CdGIaevqqE_tEGOVkebGIl_Y6vSyv67dpok79dkjj3lWceR1e0oGuYsb0mjwqmKXNt6H16cexSkYB8-feWW-rlSew";

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

        String accessToken = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJpdU9aUFYySFpWVHRYU2NUX21BRkRCZG1kWGdHcllCQlI5Q0o0cEtWTFk4In0.eyJleHAiOjE3MDI5NjAyMTksImlhdCI6MTcwMjk1OTkxOSwiYXV0aF90aW1lIjoxNzAyOTU5NjkxLCJqdGkiOiIxYzM0NDUyMy04ZDhjLTQ1ODQtOTI3Zi00ZGRjYmUzYjUxNTciLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjkwOTEvcmVhbG1zL1NPQSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiIyOTMwNmRiZC02ZGM1LTRjM2EtOGI0Zi1hYjA2M2UzYWQ5NTYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJTT0EiLCJub25jZSI6ImQwZHBiRXRxVFZCclkxUlBSRXR6UTNsWVNuWllZVXRxVGxRNU1tTldPRFpZVjI5dGRFdHZaVGx6WkVSeCIsInNlc3Npb25fc3RhdGUiOiIwNzUwZDdhMC1mNjM5LTQ0M2UtOWU4MC1lOTEzNTQ0NTBiNzciLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbIioiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtc29hIiwib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIG9mZmxpbmVfYWNjZXNzIHByb2ZpbGUgZW1haWwiLCJzaWQiOiIwNzUwZDdhMC1mNjM5LTQ0M2UtOWU4MC1lOTEzNTQ0NTBiNzciLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwicHJlZmVycmVkX3VzZXJuYW1lIjoiYWRtaW4iLCJlbWFpbCI6ImNhcmxvcy5zYW5jaGV6QHZhbGxlZ3JhbmRlLmVkdS5wZSJ9.d1yvuSo4YFmwLGLjMT3QTG72k0FSEeg-OREb_3YVS7t9Q9_qZoPHxqr4_B6_smCGTkapJcpQ3xeRcURIujHLyGyitFleYTw5uTlR7uiTdPjxegSK_bw5MnxmprhYMlGixTsJ-j83VWx7PlXEev9nSn1G3dNHyqs4KFhCNqhd4bJQwn-VY5kf3pbu6i-2Rl0l3WNqmp_Uo_NB9gIjZVt14kkw4MXYxi3uP1XPcTutx0q-9q8XYPxza1xbRG_r6tTj--PeUBRtoGF8cSwDHGjsKgYuUtTUszsTz8m2IUyNCqZIcjQ-C5D4pQb-PBplxAf0S5ByPUlKAc8Qk1j28ITDvA";

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
}
