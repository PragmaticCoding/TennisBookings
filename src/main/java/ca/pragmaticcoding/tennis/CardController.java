package ca.pragmaticcoding.tennis;

import javafx.scene.layout.Region;

public class CardController {

    private final CardModel model;
    private final CardViewBuilder viewBuilder;

    public CardController(CardModel model) {
        this.model = model;
        viewBuilder = new CardViewBuilder(model);
    }

    public Region getView() {
        System.out.println("At builder");
        return viewBuilder.build();
    }
}
