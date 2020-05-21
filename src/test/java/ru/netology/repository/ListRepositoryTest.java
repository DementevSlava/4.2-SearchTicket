package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FlightList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ListRepositoryTest {
    ListRepository repository = new ListRepository();

    FlightList flightList1 = new FlightList(1, 17837, "LED", "RHO", 720);
    FlightList flightList2 = new FlightList(2, 22793, "LED", "AYT", 700);
    FlightList flightList3 = new FlightList(3, 8418, "LON", "PAR", 120);
    FlightList flightList4 = new FlightList(4, 19690, "LED", "LAX", 1860);
    FlightList flightList41 = new FlightList(41, 24146, "LED", "LAX", 1720);
    FlightList flightList5 = new FlightList(5, 999, "MOW", "LED", 85);
    FlightList flightList51 = new FlightList(51, 1499, "MOW", "LED", 90);
    FlightList flightList52 = new FlightList(52, 1715, "MOW", "LED", 95);

    @BeforeEach
    void setup() {
        repository.save(flightList1);
        repository.save(flightList2);
        repository.save(flightList3);
        repository.save(flightList4);
        repository.save(flightList41);
        repository.save(flightList5);
        repository.save(flightList51);
        repository.save(flightList52);
    }

    @Test
    void findByAirportsOut() {
        FlightList[] actual = repository.findByAirportsIn("LAX");
        FlightList[] expected = {flightList4, flightList41};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findByAirportsIn() {
        FlightList[] actual = repository.findByAirportsOut("LED");
        FlightList[] expected = {flightList1, flightList2, flightList4, flightList41};
        assertArrayEquals(expected, actual);
    }
}