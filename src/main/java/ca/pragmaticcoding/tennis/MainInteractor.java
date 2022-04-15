package ca.pragmaticcoding.tennis;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainInteractor {

    private final MainModel model;
    private final List<BookingData> bookingData = new ArrayList<>();
    private final TestApi api = new TestApi();

    public MainInteractor(MainModel model) {
        this.model = model;
    }

    void loadData() {
      bookingData.clear();
      bookingData.addAll(api.fetchBookings());
    }

    void loadModel() {
        model.getCardModelList().addAll(bookingData.stream().map(this::createCardModel).toList());
    }

    private CardModel createCardModel(BookingData booking) {
        CardModel results = new CardModel();
        results.setName(booking.getName());
        return results;
    }
}
