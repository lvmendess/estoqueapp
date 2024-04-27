package org.openjfx;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ActionController {

    @FXML
    private TextField nomeTextField, tamTextField, quantTextField, precoVTextField, precoATextField, custoTextField, removTextField, retirarQuantTextField, retirarCodTextField;
    @FXML
    private Button addBotao, removBotao, retirarBotao;

    private String nomeProd, tamProd;
    private int quantProd, codProd;
    private double precoVProd;
    private double precoAProd = 0, custoProd = 0;
    private Estoque estoque = new Estoque();
    private JFrame jf = new JFrame();

    public void addProduto(ActionEvent event){
        if(nomeTextField.getText().isEmpty() && quantTextField.getText().isEmpty() && precoVTextField.getText().isEmpty()){
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Preencha os campos 'Nome do Produto', 'Quantidade' e 'Preço(Varejo)'.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                nomeProd = nomeTextField.getText().toUpperCase();
                tamProd = tamTextField.getText().toUpperCase();
                quantProd = Integer.parseInt(quantTextField.getText());
                precoVProd = Double.parseDouble(precoVTextField.getText());
                if(!precoATextField.getText().isEmpty()){
                    precoAProd = Double.parseDouble(precoATextField.getText());
                }
                if(!custoTextField.getText().isEmpty()){
                    custoProd = Double.parseDouble(custoTextField.getText());
                }
                if(nomeProd!=null && quantProd!=0 && precoVProd!=0){
                    estoque.addNovoProduto(nomeProd, tamProd, quantProd, custoProd, precoVProd, precoAProd);
                    Stage stage = (Stage) addBotao.getScene().getWindow();
                    stage.close();
                    JOptionPane.showMessageDialog(jf, "Alterações salvas com sucesso. Clique no botão 'Recarregar Tabela' para ver as alterações.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch(NumberFormatException e){
                jf.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(jf, "Digite apenas números nos campos Quantidade, Preço e Custo", "Erro de Entrada", JOptionPane.WARNING_MESSAGE);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void removerProduto(ActionEvent event){
        if(removTextField.getText().isEmpty()){
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Preencha o campo 'Código do Produto a remover'.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                codProd = Integer.parseInt(removTextField.getText());
                int resposta = JOptionPane.showConfirmDialog(jf, "Remover produto do código "+codProd+"?", "Confirmar ação", JOptionPane.OK_CANCEL_OPTION);
                if(resposta==0){
                    estoque.removerProduto(codProd);
                    Stage stage = (Stage) removBotao.getScene().getWindow();
                    stage.close();
                    JOptionPane.showMessageDialog(jf, "Alterações salvas com sucesso. Clique no botão 'Recarregar Tabela' para ver as alterações.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException e) {
                jf.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(jf, "Digite apenas números neste campo", "Erro de Entrada", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public void retirarProduto(ActionEvent event){
        if(retirarCodTextField.getText().isEmpty() && retirarQuantTextField.getText().isEmpty()){
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Preencha os campos 'Código do Produto' e 'Quantidade'.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                codProd = Integer.parseInt(retirarCodTextField.getText());
                quantProd = Integer.parseInt(retirarQuantTextField.getText());
                int resposta = JOptionPane.showConfirmDialog(jf, "Remover produto do código "+codProd+"?", "Confirmar ação", JOptionPane.OK_CANCEL_OPTION);
                if(resposta==0){
                    estoque.retirarProduto(codProd, quantProd);
                    Stage stage = (Stage) retirarBotao.getScene().getWindow();
                    stage.close();
                    JOptionPane.showMessageDialog(jf, "Alterações salvas com sucesso. Clique no botão 'Recarregar Tabela' para ver as alterações.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(jf, "Digite apenas números nestes campos", "Erro de Entrada", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    /*@FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }*/
}