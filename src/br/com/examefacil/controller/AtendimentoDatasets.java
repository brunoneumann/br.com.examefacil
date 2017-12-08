/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.examefacil.controller;

import br.com.examefacil.bean.Atender;
import br.com.examefacil.bean.Atendimento;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author bruno
 */
public class AtendimentoDatasets {
    
    public AtendimentoDatasets(){}
    
    public JFreeChart createChartAtendimentosPorStatus(List<Atendimento> lista) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Qtde. atend. por status",   // chart title
                createDatasetAtendimentosPorStatus(lista), // data
                true,    // include legend
                true,
                false);
        
        return chart;
    }
    
    public JFreeChart createChartAtendimentosPorTipoExame(List<Atender> lista) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Qtde. atend. por tipo de exame",   // chart title
                createDatasetAtendimentosPorTipoExame(lista), // data
                true,    // include legend
                true,
                false);
        
        return chart;
    }
    
    public JFreeChart createChartAtendimentosPorData(List<Atendimento> lista){
        JFreeChart barChart = ChartFactory.createBarChart(
                "Qtde. atend. por data",
                "Data",
                "Qtde.",
                createDatasetAtendimentosPorData(lista),
                PlotOrientation.VERTICAL,
                true, true, false);
        return barChart;
    }
    
    public JFreeChart createChartAtendimentosPorAreaExame(List<Atender> lista){
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Atendimentos por data X área exame",
                "Data",
                "Qtde. atend.",
                createDatasetAtendimentosPorAreaExame(lista),
                PlotOrientation.VERTICAL,
                true,true,false);
        
        return lineChart;
    }
    
    private PieDataset createDatasetAtendimentosPorStatus(List<Atendimento> atendimentos) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for(Atendimento a : atendimentos){
            dataset.setValue(a.getStatus(), a.getQtdeAtendimentos());
        }
        return dataset;
    }
    
    private PieDataset createDatasetAtendimentosPorTipoExame(List<Atender> atendimentos) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        try {
            for(Atender a : atendimentos){
                dataset.setValue(a.getTipoexame(), a.getQtdeAtendimentos());
            }
        } catch(Exception ex){
        }
        return dataset;
    }
    
    private CategoryDataset createDatasetAtendimentosPorData(List<Atendimento> atendimentos) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(Atendimento a : atendimentos){
            dataset.addValue(a.getQtdeAtendimentos(), "Qtde. atendimentos", a.getDataString());
        }
        return dataset;
    }
    
    private CategoryDataset createDatasetAtendimentosPorAreaExame(List<Atender> atendimentos) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(Atender a : atendimentos){
            dataset.addValue(a.getQtdeAtendimentos(), a.getAreaexame(), a.getDataStr());
        }
        return dataset;
    }
    
}