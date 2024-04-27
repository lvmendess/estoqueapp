package org.openjfx;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoController implements Initializable{

    @FXML
    private void removerProduto() throws IOException {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RemoverProd.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Estoque - Deletar Produto");
            stage.setScene(new Scene(root));
            root.getStylesheets().add(getClass().getResource("action.css").toExternalForm());
            stage.setResizable(false);
            stage.show();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        //App.setRoot("secondary");
    }

    public void AdicionarProduto(ActionEvent e) throws IOException{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProd.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Estoque - Adicionar Novo Produto");
            stage.setScene(new Scene(root));
            root.getStylesheets().add(getClass().getResource("action.css").toExternalForm());
            stage.setResizable(false);
            stage.show();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void RetirarProduto(ActionEvent e) throws IOException{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RetirarProd.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Estoque - Retirar Produto");
            stage.setScene(new Scene(root));
            root.getStylesheets().add(getClass().getResource("action.css").toExternalForm());
            stage.setResizable(false);
            stage.show();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    public TableView<Produto> ProdutoTableView;

    @FXML
    private TableColumn<Produto, Integer> produtoCodigo;

    @FXML
    private TableColumn<Produto, String> produtoNome;

    @FXML
    private TableColumn<Produto, String> produtoTamanho;

    @FXML
    private TableColumn<Produto, Integer> produtoQuant;

    @FXML
    private TableColumn<Produto, Double> custoProducao;

    @FXML
    private TableColumn<Produto, Double> precoVarejo;

    @FXML
    private TableColumn<Produto, Double> precoAtacado;

    @FXML
    private TextField searchBar;

    ObservableList<Produto> ProdutoObservableList = FXCollections.observableArrayList();

    public void recarregarTabela(){
        ProdutoObservableList.clear();
        try {
            Connection con = SQLConnection.connectDB();
            String tableQuery = "SELECT * FROM estoque";
            Statement statement = con.createStatement();
            ResultSet queryOutput = statement.executeQuery(tableQuery);

            while(queryOutput.next()){
                Integer queryCodigo = queryOutput.getInt("produtoCodigo");
                String queryNome = queryOutput.getString("produtoNome");
                String queryTamanho = queryOutput.getString("produtoTamanho");
                Integer queryQuant = queryOutput.getInt("produtoQuant");
                Double queryCusto = queryOutput.getDouble("custoProducao");
                Double queryVarejo = queryOutput.getDouble("precoVarejo");
                Double queryAtacado = queryOutput.getDouble("precoAtacado");
                ProdutoObservableList.add(new Produto(queryCodigo, queryNome, queryTamanho, queryQuant, queryCusto, queryVarejo, queryAtacado));
            }

            produtoCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
            produtoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            produtoTamanho.setCellValueFactory(new PropertyValueFactory<>("tamanho"));
            produtoQuant.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
            custoProducao.setCellValueFactory(new PropertyValueFactory<>("custoProd"));
            precoVarejo.setCellValueFactory(new PropertyValueFactory<>("varejo"));
            precoAtacado.setCellValueFactory(new PropertyValueFactory<>("atacado"));

            ProdutoTableView.setItems(ProdutoObservableList);
            //search bar

            FilteredList<Produto> filteredData = new FilteredList<>(ProdutoObservableList, b -> true);

            searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(Produto -> {
                    if(newValue.isBlank() || newValue.isEmpty() || newValue == null){
                        return true;
                    }

                    String searchKey = newValue.toUpperCase();

                    if(Produto.getNome().indexOf(searchKey)>-1){
                        return true;
                    }else if(Produto.getCodigo().contains(searchKey)){
                        return true;
                    }else{
                        return false;
                    }
                });
            });

            SortedList<Produto> sortedList = new SortedList<>(filteredData);
            sortedList.comparatorProperty().bind(ProdutoTableView.comparatorProperty());
            ProdutoTableView.setItems(sortedList);

        } catch (SQLException e) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resource){
        recarregarTabela();
    }
}
