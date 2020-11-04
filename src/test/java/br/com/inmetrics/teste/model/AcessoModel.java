

import io.swagger.annotations.ApiModel;

import java.util.List;

public class AcessoModel {
    private Integer acessoId;
    private String email;
    private List<EmpregadoModel> empregado;
    private String password;

    public Integer getAcessoId() {
        return acessoId;
    }

    public void setAcessoId(Integer acessoId) {
        this.acessoId = acessoId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<EmpregadoModel> getEmpregado() {
        return empregado;
    }

    public void setEmpregado(List<EmpregadoModel> empregado) {
        this.empregado = empregado;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
