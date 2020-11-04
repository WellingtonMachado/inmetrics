
import io.swagger.annotations.ApiModel;

import java.util.List;

public class DepartamentoModel {
    private Integer departamentoId;
    private List<EmpregadoModel> empregados;
    private String local;
    private String nomeDepartamento;
    private String orcamento;

    public Integer getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Integer departamentoId) {
        this.departamentoId = departamentoId;
    }

    public List<EmpregadoModel> getEmpregados() {
        return empregados;
    }

    public void setEmpregados(List<EmpregadoModel> empregados) {
        this.empregados = empregados;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    public String getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(String orcamento) {
        this.orcamento = orcamento;
    }
}
