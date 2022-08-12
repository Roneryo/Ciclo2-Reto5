package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label buttonText;
    @FXML
    private TableView tableView;


    @FXML
    protected void onProyectoButtonClick() {
        tableView.getItems().clear();
        tableView.getColumns().clear();
        TableColumn ID = new TableColumn<>("id");
        ID.setCellValueFactory(
                new PropertyValueFactory<>("id"));
        TableColumn Constructora  = new TableColumn<>("Constructora");
        Constructora.setCellValueFactory(
                new PropertyValueFactory<>("constructora"));
        TableColumn numeroHabitaciones  = new TableColumn<>("Numero_habitaciones");
        numeroHabitaciones.setCellValueFactory(
                new PropertyValueFactory<>("numero_habitaciones"));
        TableColumn Ciudad  = new TableColumn<>("Ciudad");
        Ciudad.setCellValueFactory(
                new PropertyValueFactory<>("ciudad"));
        tableView.getColumns().add(ID);
        tableView.getColumns().add(Constructora);
        tableView.getColumns().add(numeroHabitaciones);
        tableView.getColumns().add(Ciudad);
        DatosProyecto();
    }
    @FXML
    protected void onLiderButtonClick() {
        tableView.getItems().clear();
        tableView.getColumns().clear();
        TableColumn ID = new TableColumn<>("id");
        ID.setCellValueFactory(
                new PropertyValueFactory<>("id"));
        TableColumn Nombre  = new TableColumn<>("Primer_Nombre");
        Nombre.setCellValueFactory(
                new PropertyValueFactory<>("firstName"));
        TableColumn Apellido  = new TableColumn<>("Primer Apellido");
        Apellido.setCellValueFactory(
                new PropertyValueFactory<>("lastName"));
        TableColumn Ciudad  = new TableColumn<>("Ciudad");
        Ciudad.setCellValueFactory(
                new PropertyValueFactory<>("city"));
        tableView.getColumns().add(ID);
        tableView.getColumns().add(Nombre);
        tableView.getColumns().add(Apellido);
        tableView.getColumns().add(Ciudad);
        DatosLider();
    }
    @FXML
    protected void onComprasButtonClick() {
        tableView.getItems().clear();
        tableView.getColumns().clear();
        TableColumn ID = new TableColumn<>("id");
        ID.setCellValueFactory(
                new PropertyValueFactory<>("id"));
        TableColumn Constructora  = new TableColumn<>("Constructora");
        Constructora.setCellValueFactory(
                new PropertyValueFactory<>("constructora"));
        TableColumn Banco_Vinculado  = new TableColumn<>("Banco_Vinculado");
        Banco_Vinculado.setCellValueFactory(
                new PropertyValueFactory<>("BancoVinculado"));
        tableView.getColumns().add(ID);
        tableView.getColumns().add(Constructora);
        tableView.getColumns().add(Banco_Vinculado);
        DatosCompra();

    }
    private void DatosLider(){
        try {

            String query = "select ID_Lider ,Nombre ,Primer_Apellido ,Ciudad_Residencia  from Lider order by Ciudad_Residencia asc";
            var conn = JDBC.getConnection();
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer id = rs.getInt("ID_Lider");
                String nombre = rs.getString("Nombre");
                String primerApellido = rs.getString("Primer_Apellido");
                String ciudadResidencia = rs.getString("Ciudad_Residencia");
                tableView.getItems().add(new Lider(id,nombre,primerApellido,ciudadResidencia));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private void DatosProyecto(){
        try {
            String query = "select ID_Proyecto ,Constructora ,Numero_Habitaciones ,Ciudad  from Proyecto p where Clasificacion =\"Casa Campestre\" and Ciudad  in (\"Santa Marta\",\"Cartagena\",\"Barranquilla\")";
            var conn = JDBC.getConnection();
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer id = rs.getInt("ID_Proyecto");
                String Constructora = rs.getString("Constructora");
                Integer Numero_Habitaciones = rs.getInt("Numero_Habitaciones");
                String Ciudad = rs.getString("Ciudad");
                tableView.getItems().add(new Proyecto(id,Constructora,Numero_Habitaciones,Ciudad));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private void DatosCompra(){
        try {
            String query = "SELECT  ID_Compra,P.Constructora,P.Banco_Vinculado  from compra C inner join Proyecto P on C.ID_Proyecto =P.ID_Proyecto where Proveedor =\"Homecenter\" and P.Ciudad =\"Salento\"";
            var conn = JDBC.getConnection();
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer id = rs.getInt("ID_Compra");
                String Constructora = rs.getString("Constructora");
                String Banco_Vinculado = rs.getString("Banco_Vinculado");
                tableView.getItems().add(new Compras(id,Constructora,Banco_Vinculado));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
