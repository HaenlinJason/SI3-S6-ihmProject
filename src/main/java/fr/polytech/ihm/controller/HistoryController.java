package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.FilterBy;
import fr.polytech.ihm.model.Incident;
import fr.polytech.ihm.model.IncidentManager;
import fr.polytech.ihm.model.PosteAnnee;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

import java.io.IOException;

public class HistoryController {

    @FXML
    private ComboBox<FilterBy> filter;

    @FXML
    private ImageView recherch;

    @FXML
    private TableView<Incident> table;

    @FXML
    private TableColumn<Incident, String> titreCol;

    @FXML
    private TableColumn<Incident, String> typeCol;

    @FXML
    private TableColumn<Incident, String> importanceCol;

    @FXML
    private TableColumn<Incident, String> dateCol;

    @FXML
    private TableColumn<Incident, String> localisationCol;

    @FXML
    private TableColumn<Incident, String> nomCol;

    @FXML
    private TableColumn<Incident, String> prenomCol;

    @FXML
    private TableColumn<Incident, String> posteCol;

    @FXML
    private Button retour;

    @FXML
    public void initialize(){
        filter.getItems().setAll(FilterBy.values());
        ObservableList<Incident> incidents= FXCollections.observableArrayList();
        for(Incident incident : IncidentManager.getIncidentList()){
        	incidents.add(incident);
        }

        titreCol.setCellValueFactory(cellData -> cellData.getValue().titreProperty());
        typeCol.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        importanceCol.setCellValueFactory(cellData -> cellData.getValue().importanceProperty());
	    dateCol.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
	    localisationCol.setCellValueFactory(cellData -> (cellData.getValue().batimentProperty().concat(cellData.getValue().salleProperty())));
	    nomCol.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
	    prenomCol.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
	    posteCol.setCellValueFactory(cellData -> cellData.getValue().posteAnneeProperty());


        table.setItems(incidents);
    }

}
