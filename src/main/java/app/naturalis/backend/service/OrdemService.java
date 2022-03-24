package app.naturalis.backend.service;

import app.naturalis.backend.dto.OrdemServicoPorPessoaDto;
import app.naturalis.backend.dto.OrdemServicoResDto;
import app.naturalis.backend.handler.exception.ClienteIsInativoException;
import app.naturalis.backend.model.Cliente;
import app.naturalis.backend.model.OrdemServico;
import app.naturalis.backend.repository.ClienteRepository;
import app.naturalis.backend.repository.OrdemServicoRepository;
import app.naturalis.backend.repository.filter.OrdemServicoFilter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.io.InputStream;
import java.util.*;

@Service
public class OrdemService {

    @Autowired
    private OrdemServicoRepository osRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public byte[] reportOrders(List<OrdemServicoResDto> data, OrdemServicoFilter filters) throws Exception{
        if (data.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("DT_INICIO", filters.getDataCriacaoDe());
        parametros.put("DT_FIM", filters.getDataCriacaoAte());
        if (filters.getResp()!= 0){
            parametros.put("INFO_RESP",data.get(0).getNomeResp());
        }
        parametros.put("REPORT_LOCALE", new Locale("pt", "BR"));

        InputStream inputStream = this.getClass().getResourceAsStream(
                "/relatorios/orders-all.jasper");

        JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parametros,
                new JRBeanCollectionDataSource(data));

        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

    public OrdemServico newOs(OrdemServico ordemServico){
        Optional<Cliente> cliente = this.clienteRepository.findById(ordemServico.getCliente().getId());

        if (cliente.isEmpty() || cliente.get().isInativo()){
            throw new ClienteIsInativoException();
        }
        return this.osRepository.save(ordemServico);
    }

    public Optional<OrdemServico> getById(int id){
        Optional<OrdemServico> osById = Optional.ofNullable(this.osRepository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1)));
        return osById;
    }

    public OrdemServico editById(int id, OrdemServico ordemServico){
        Optional<OrdemServico> osByIdSave = Optional.ofNullable(this.osRepository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1)));
        BeanUtils.copyProperties(ordemServico, osByIdSave.get(), "id");
        return this.osRepository.save(osByIdSave.get());
    }

    public void removeOsById(int id){
        this.osRepository.deleteById(id);
    }
}
