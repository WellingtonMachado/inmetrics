
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.testng.annotations.Test;

public class EmpregadoControllerTest{

    @Test
    public void cadastrarEmpregadoSucesso() throws Exception {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        EmpregadoDto request = new EmpregadoDto();
        request.setAdmissao("03/11/2020");
        request.setCargo("Analista 3");
        request.setComissao("2500");
        request.setCpf("45201235210");
        request.setDepartamentoId(1);
        request.setNome("Teste");
        request.setSalario("2500");
        request.setSexo("Masculino");
        request.setTipoContratacao("CLT");

        String sucesso = "Empregado cadastrado com sucesso!";
        when(empregadoController.cadastrarEmpregado(request)).thenReturn(sucesso);
        mvc.perform(MockMvcRequestBuilders.post
                ("/empregado/cadastrar")
                .headers(httpHeaders)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }
}
