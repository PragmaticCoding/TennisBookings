package ca.pragmaticcoding.tennis;

import javafx.beans.InvalidationListener;
import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.util.Builder;

import java.util.Objects;

public class MainViewBuilder implements Builder<Region> {

    private final MainModel model;

    public MainViewBuilder(MainModel model) {
        this.model = model;
    }

    @Override
    public Region build() {
        FlowPane results = new FlowPane();
        results.setPadding(new Insets(6));
        results.getStylesheets().add(Objects.requireNonNull(MainViewBuilder.class.getResource("/css/widgetsfx.css")).toString());
        results.getStylesheets().add(Objects.requireNonNull(MainViewBuilder.class.getResource("/css/tennis.css")).toString());
        results.setMinSize(450, 340);
        results.setHgap(10);
        results.setVgap(10);
        model.getCardModelList().addListener((InvalidationListener) observable -> {
            results.getChildren().clear();
            results.getChildren().addAll(model.getCardModelList().stream().map(cardModel -> new CardController(cardModel).getView()).toList());
        });
        return results;
    }
}
