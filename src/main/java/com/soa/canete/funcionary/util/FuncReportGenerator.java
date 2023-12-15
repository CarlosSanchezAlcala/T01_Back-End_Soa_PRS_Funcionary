package com.soa.canete.funcionary.util;

import com.soa.canete.funcionary.domain.model.Funcionary;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FuncReportGenerator {
    private final Scheduler jdbcScheduler = Schedulers.boundedElastic();

    public Mono<byte[]> exportToPdf(List<Funcionary> list) {
        return Mono.fromCallable(() -> generatePdf(list))
                .subscribeOn(jdbcScheduler);
    }

    private byte[] generatePdf(List<Funcionary> list) throws JRException, FileNotFoundException {
        return JasperExportManager.exportReportToPdf(getReport(list));
    }

    private JasperPrint getReport(List<Funcionary> list) throws FileNotFoundException, JRException {
        Map<String, Object> params = new HashMap<>();
        params.put("funcdata", new JRBeanCollectionDataSource(list));

        return JasperFillManager.fillReport(JasperCompileManager.compileReport(
                ResourceUtils.getFile("classpath:FuncReport.jrxml")
                        .getAbsolutePath()), params, new JREmptyDataSource());
    }
}
