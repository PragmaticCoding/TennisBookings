package ca.pragmaticcoding.tennis;

import ca.pragmaticcoding.widgetsfx.text.Labels;
import javafx.geometry.Insets;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class CardViewBuilder implements Builder<Region> {

    private final CardModel model;

    public CardViewBuilder(CardModel model) {
        this.model = model;
    }

    @Override
    public Region build() {
        VBox results = new VBox();
        results.setPadding(new Insets(4));
        results.setMinHeight(150);
        results.setMinWidth(180);
        results.getChildren().add(Labels.prompt(model.nameProperty()));
        results.getStyleClass().add("card-box");
        return results;
    }
}
