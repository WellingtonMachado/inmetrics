
import javassist.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testng.annotations.Test;

import javax.naming.AuthenticationException;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EmpregadoControllerTest extends AbstractTestNGSpringContextTests {
    protected MockMvc mvc;

    @Test
    public void testRegisterEmployeeSuccess() throws Exception {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        EmpregadoDto empregadoDto = mockEmpregadoDto();

        String sucesso = "Empregado cadastrado com sucesso!";
        when(empregadoController.registerEmployee(empregadoDto)).thenReturn(sucesso);
        mvc.perform(MockMvcRequestBuilders.post
                ("/empregado/cadastrar")
                .headers(httpHeaders)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testRegisterEmployeeUnauthorizedException() throws Exception {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        EmpregadoDto empregadoDto = mockEmpregadoDto();

        String erro = "Não autorizado!";
        when(empregadoController.registerEmployee(empregadoDto)).thenThrow(new AuthenticationException(erro));
        mvc.perform(MockMvcRequestBuilders.post
                ("/empregado/cadastrar")
                .headers(httpHeaders)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testRegisterEmployeeNotFoundException() throws Exception {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        EmpregadoDto empregadoDto = mockEmpregadoDto();

        String erro = "Não encontrado!";
        when(empregadoController.registerEmployee(empregadoDto)).thenThrow(new NotFoundException(erro));
        mvc.perform(MockMvcRequestBuilders.post
                ("/empregado/cadastrar")
                .headers(httpHeaders)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testListEmployeeRegisteredSuccess() throws Exception {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Integer empregadoId = 1;

        List<EmpregadoModel> listRegisteredEmployees = mockListEmployee();

        when(empregadoController.listEmployeesRegistered(empregadoId)).thenReturn(listRegisteredEmployees);
        mvc.perform(MockMvcRequestBuilders.get
                ("/empregado/list/"+ empregadoId)
                .headers(httpHeaders)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testListEmployeeRegisteredUnauthorizedException() throws Exception {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Integer empregadoId = 1;

        String erro = "Não autorizado!";
        when(empregadoController.listEmployeesRegistered(empregadoId)).thenThrow(new AuthenticationException(erro));
        mvc.perform(MockMvcRequestBuilders.get
                ("/empregado/list/"+ empregadoId)
                .headers(httpHeaders)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testListEmployeeRegisteredNotFoundException() throws Exception {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Integer empregadoId = 1;

        String erro = "Não encontrado!";
        when(empregadoController.listEmployeesRegistered(empregadoId)).thenThrow(new NotFoundException(erro));
        mvc.perform(MockMvcRequestBuilders.get
                ("/empregado/list/"+ empregadoId)
                .headers(httpHeaders)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testListAllEmployeeSuccess() throws Exception {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        List<EmpregadoModel> listAllEmployees = mockListEmployee();

        when(empregadoController.listAllEmployees()).thenReturn(listAllEmployees);
        mvc.perform(MockMvcRequestBuilders.get
                ("/empregado/list_all")
                .headers(httpHeaders)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testListAllEmployeesUnauthorizedException() throws Exception {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Integer empregadoId = 1;

        String erro = "Não autorizado!";
        when(empregadoController.listAllEmployees()).thenThrow(new AuthenticationException(erro));
        mvc.perform(MockMvcRequestBuilders.get
                ("/empregado/list_all")
                .headers(httpHeaders)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testListAllEmployeesNotFoundException() throws Exception {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Integer empregadoId = 1;

        String erro = "Não encontrado!";
        when(empregadoController.listAllEmployees()).thenThrow(new NotFoundException(erro));
        mvc.perform(MockMvcRequestBuilders.get
                ("/empregado/list_all")
                .headers(httpHeaders)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdateEmployeeSuccess() throws Exception {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        EmpregadoDto empregadoDto = mockEmpregadoDto();

        Integer empregadoId = 0;
        String sucesso = "Empregado atualizado com sucesso!";
        when(empregadoController.updateEmployee(empregadoDto, empregadoId)).thenReturn(sucesso);
        mvc.perform(MockMvcRequestBuilders.put
                ("/empregado/alterar/{empregadoId}")
                .headers(httpHeaders)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testRegisterEmployeeUnauthorizedException() throws Exception {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        EmpregadoDto empregadoDto = mockEmpregadoDto();
        Integer empregadoId = 0;

        String erro = "Não autorizado!";
        when(empregadoController.updateEmployee(empregadoDto, empregadoId)).thenThrow(new AuthenticationException(erro));
        mvc.perform(MockMvcRequestBuilders.put
                ("/empregado/alterar/{empregadoId}")
                .headers(httpHeaders)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testRegisterEmployeeNotFoundException() throws Exception {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        EmpregadoDto empregadoDto = mockEmpregadoDto();
        Integer empregadoId = 0;

        String erro = "Não encontrado!";
        when(empregadoController.updateEmployee(empregadoDto, empregadoId)).thenThrow(new NotFoundException(erro));
        mvc.perform(MockMvcRequestBuilders.put
                ("/empregado/alterar/{empregadoId}")
                .headers(httpHeaders)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteEmployeeSuccess() throws Exception {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Integer empregadoId = 1;

        String sucesso = "Empregado deletado com sucesso.";
        when(empregadoController.deleteEmployee(empregadoId)).thenReturn(sucesso);
        mvc.perform(MockMvcRequestBuilders.delete
                ("/empregado/deletar/"+ empregadoId)
                .headers(httpHeaders)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testDeleteEmployeeUnauthorizedException() throws Exception {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Integer empregadoId = 1;

        String erro = "Não autorizado!";
        when(empregadoController.deleteEmployee(empregadoId)).thenThrow(new AuthenticationException(erro));
        mvc.perform(MockMvcRequestBuilders.delete
                ("/empregado/deletar/"+ empregadoId)
                .headers(httpHeaders)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    private EmpregadoDto mockEmpregadoDto() {
        EmpregadoDto empregadoDto = new EmpregadoDto();
        empregadoDto.setAdmissao("03/11/2020");
        empregadoDto.setCargo("Analista 3");
        empregadoDto.setComissao("2500");
        empregadoDto.setCpf("45201235210");
        empregadoDto.setDepartamentoId(1);
        empregadoDto.setNome("Teste");
        empregadoDto.setSalario("2500");
        empregadoDto.setSexo("Masculino");
        empregadoDto.setTipoContratacao("CLT");
        return empregadoDto;
    }

    private List<EmpregadoModel> mockListEmployee() {
        List<EmpregadoModel> listRegisteredEmployees = new ArrayList<>();
        EmpregadoModel empregadoModel = new EmpregadoModel();
        empregadoModel.setAcesso(new AcessoModel());
        empregadoModel.setAdmissao("Admitido");
        empregadoModel.setCargo("Analista");
        empregadoModel.setComissao("2500");
        empregadoModel.setCpf("15201202110");
        empregadoModel.setDepartamento(new DepartamentoModel());
        empregadoModel.setEmpregadoId(1);
        empregadoModel.setNome("Teste");
        empregadoModel.setSalario("2500");
        empregadoModel.setSexo("Masculino");
        empregadoModel.setTipoContratacao("CLT");
        listRegisteredEmployees.add(empregadoModel);
        return listRegisteredEmployees;
    }

}
