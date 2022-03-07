package app.naturalis.backend.dto.config;

import app.naturalis.backend.dto.FuncionarioResDto;
import app.naturalis.backend.dto.OrdemServicoPorDiaDto;
import app.naturalis.backend.dto.OrdemServicoResDto;
import app.naturalis.backend.model.Funcionario;
import app.naturalis.backend.model.OrdemServico;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        var modelMapper = new ModelMapper();
        //DTO Ordem de Serviço por Mes
        modelMapper.createTypeMap(OrdemServico.class, OrdemServicoPorDiaDto.class)
                .addMapping(OrdemServico::getDataCriado, OrdemServicoPorDiaDto::setDataCompra);

        //DTO Funcionário
        modelMapper.createTypeMap(Funcionario.class, FuncionarioResDto.class)
                .addMapping(src -> src.getCargo().getDescricao(),FuncionarioResDto::setCargo);
        //DTO Ordem de Serviço
        modelMapper.createTypeMap(OrdemServico.class, OrdemServicoResDto.class)
                .addMapping(src -> src.getResponsavel().getNome(), OrdemServicoResDto::setNomeResp)
                .addMapping(src -> src.getResponsavel().getId(), OrdemServicoResDto::setIdResp);

        return modelMapper;
    }
}
