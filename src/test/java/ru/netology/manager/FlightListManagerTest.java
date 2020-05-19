package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FlightList;
import ru.netology.repository.ListRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FlightListManagerTest {
    ListRepository repository = new ListRepository();
    ListManager manager = new ListManager(repository);

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
        manager.addTicket(flightList1);
        manager.addTicket(flightList2);
        manager.addTicket(flightList3);
        manager.addTicket(flightList4);
        manager.addTicket(flightList41);
        manager.addTicket(flightList5);
        manager.addTicket(flightList51);
        manager.addTicket(flightList52);
    }

    @Test
    void shouldSort() {
        FlightList[] actual = repository.findAll();
        FlightList[] expected = {flightList5, flightList51, flightList52, flightList3, flightList1, flightList4, flightList2, flightList41};
        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchAll(){
        FlightList[] actual = manager.searchAll("MOW", "LED");
        FlightList[] expected = {flightList5, flightList51, flightList52};
        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNonAirports() {
        FlightList[] actual = manager.searchAll("LED", "MOW");
        FlightList[] expected = {};
        assertArrayEquals(expected, actual);
    }
}