package service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.ColetarDadosInfomoney;
import utils.TestMockUtil;

public class ColetarDadosInformoneyTest {
    private ColetarDadosInfomoney coletarDadosInfomoney;

    @BeforeEach
    void setUp() {
        coletarDadosInfomoney = new ColetarDadosInfomoney();
    }
    @Test
    @DisplayName("Deve retornar um set com links")
    void coletarLinks_RetornaSetComLinks_SeBemSucedido() {

        String html = TestMockUtil.retornarHtmlCom3LinksValidos();
        Assertions.assertThat(coletarDadosInfomoney.coletarLinksDasNoticias(html))
                .isNotNull()
                .isNotEmpty()
                .hasSize(3);

    }
    @Test
    @DisplayName("Deve retornar uma lista vazia quando nulo ou vazio")
    void coletarLinks_RetornaListaVaziaQuandoNuloOuVazio_SeMalSucedido() {

        String html = null;
        Assertions.assertThat(coletarDadosInfomoney.coletarLinksDasNoticias(html))
                .isNotNull()
                .isEmpty();
        String html2 = "";
        Assertions.assertThat(coletarDadosInfomoney.coletarLinksDasNoticias(html2))
                .isNotNull()
                .isEmpty();

    }

}