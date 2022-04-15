package ca.pragmaticcoding.tennis;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainModel {

    private final ObservableList<CardModel> cardModelList = FXCollections.observableArrayList();


    public ObservableList<CardModel> getCardModelList() {
        return cardModelList;
    }
}
