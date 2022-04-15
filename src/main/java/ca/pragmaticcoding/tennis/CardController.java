package ca.pragmaticcoding.tennis;

import javafx.scene.layout.Region;

public class CardController {

    private final CardViewBuilder viewBuilder;

    public CardController(CardModel model) {
        viewBuilder = new CardViewBuilder(model);
    }

    public Region getView() {
        return viewBuilder.build();
    }
}
