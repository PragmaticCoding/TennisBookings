package ca.pragmaticcoding.tennis;

import java.util.List;
import java.util.stream.Stream;

public class TestApi {

    public List<BookingData> fetchBookings() {
       return Stream.of("Fred Smith", "Henry Brown", "Herman Vermin").map(this::createBookingData).toList();
    }

    private BookingData createBookingData(String name) {
        BookingData results = new BookingData();
        results.setName(name);
        return results;
    }
}
