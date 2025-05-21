package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpresaTest {

    @Test
    void deveNotificarUmaEmpresa() {
        Faturamento faturamento = new Faturamento(2025, 5, 10000, "Vendas");
        Empresa empresa = new Empresa("Empresa Teste 1");
        empresa.lancarFaturamento(faturamento);
        faturamento.lancarFaturamentos();
        assertEquals("Informações de faturamento para a empresa: Empresa Teste 1 -> {Faturamento -> Ano: 2025, Mês: 5, Valor: 10000, Setor: Vendas }", empresa.getUltimaNotificacao());
    }

    @Test
    void deveNotificarDiversasEmpresas() {
        Faturamento faturamento = new Faturamento(2024, 8, 250000, "Tecnologia");
        Empresa empresa1 = new Empresa("TecnoTest");
        Empresa empresa2 = new Empresa("DevSitesTest");
        empresa1.lancarFaturamento(faturamento);
        empresa2.lancarFaturamento(faturamento);
        faturamento.lancarFaturamentos();
        assertEquals("Informações de faturamento para a empresa: TecnoTest -> {Faturamento -> Ano: 2024, Mês: 8, Valor: 250000, Setor: Tecnologia }", empresa1.getUltimaNotificacao());
        assertEquals("Informações de faturamento para a empresa: DevSitesTest -> {Faturamento -> Ano: 2024, Mês: 8, Valor: 250000, Setor: Tecnologia }", empresa2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarEmpresa() {
        Faturamento faturamento = new Faturamento(2023, 2, 358000, "Marketing");
        Empresa empresa = new Empresa("MKTest");
        faturamento.lancarFaturamentos();
        assertEquals(null, empresa.getUltimaNotificacao());
    }

    @Test
    void deveNotificarEmpresaFaturamento1() {
        Faturamento faturamento1 = new Faturamento(2020, 9, 8000000, "Marketing");
        Faturamento faturamento2 = new Faturamento(2025, 10, 9022342, "Vendas");
        Empresa empresa1 = new Empresa("MKTest");
        Empresa empresa2 = new Empresa("EmpTest");
        empresa1.lancarFaturamento(faturamento1);
        empresa2.lancarFaturamento(faturamento2);
        faturamento1.lancarFaturamentos();
        assertEquals("Informações de faturamento para a empresa: MKTest -> {Faturamento -> Ano: 2020, Mês: 9, Valor: 8000000, Setor: Marketing }", empresa1.getUltimaNotificacao());
        assertEquals(null, empresa2.getUltimaNotificacao());
    }
}