package br.com.douglas.correios.soap;

import java.math.BigDecimal;
import java.util.List;

public class TesteClienteCorreios {

    public static void main(String[] args) {
        CalcPrecoPrazoWSSoap cliente = new CalcPrecoPrazoWS().getCalcPrecoPrazoWSSoap();
        String semCdEmpresa = "";
        String semSenha = "";
        String codigoSedex = "40010";
        String cepTias = "94435050";
        String cepCasa = "90830520";
        String peso = "3";
        int formato = 1;
        BigDecimal comprimento = BigDecimal.valueOf(30);
        BigDecimal altura = BigDecimal.valueOf(10);
        BigDecimal largura = BigDecimal.valueOf(15);
        BigDecimal diametro = BigDecimal.valueOf(10);
        BigDecimal valor = BigDecimal.ZERO;
        String entregueEmMaos = "N";
        String avisoRecebimento = "N";


        CResultado cResultado = cliente.calcPrecoPrazo(semCdEmpresa, semSenha, codigoSedex,
                cepTias, cepCasa, peso,
                formato, comprimento, altura, largura, diametro, entregueEmMaos, valor, avisoRecebimento);

        List<CServico> servicos = cResultado.getServicos().getCServico();
        String valorPesquisado = servicos.get(0).getValor();

        System.out.printf("Valor para %s é de %s %n", cepCasa, valorPesquisado);
    }
}
