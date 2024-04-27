package org.openjfx;

public class Estoque {
    private String SQL;
    private SQLCommand command = new SQLCommand();

    public Estoque(){
        SQL = null;
    }

    public void addNovoProduto(String nome, String tamanho, int quant, double custoProd, double precoVarejo, double precoAtacado){
        SQL = "INSERT INTO estoque (produtoNome, produtoTamanho, produtoQuant, custoProducao, precoVarejo, precoAtacado) VALUES ('"+nome+"','"+tamanho+"',"+quant+","+custoProd+","+precoVarejo+","+precoAtacado+");";
        command.command(SQL);
    }

    public void retirarProduto(int codigo, int quant){
        SQL = "UPDATE estoque SET produtoQuant = produtoQuant - "+quant+" WHERE produtoCodigo = '"+codigo+"';";
        command.command(SQL);
    }

    public void removerProduto(int codigo){
        SQL = "DELETE FROM estoque WHERE produtoCodigo = '"+codigo+"';";
        command.command(SQL);
    }
}
