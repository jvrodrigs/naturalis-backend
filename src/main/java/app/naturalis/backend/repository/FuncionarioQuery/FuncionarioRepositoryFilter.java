package app.naturalis.backend.repository.FuncionarioQuery;

import app.naturalis.backend.model.Funcionario;
import app.naturalis.backend.repository.filter.FuncionarioFilter;

import java.util.List;

public interface FuncionarioRepositoryFilter {

    List<Funcionario> filtrar(FuncionarioFilter funcionarioFilter);
}
