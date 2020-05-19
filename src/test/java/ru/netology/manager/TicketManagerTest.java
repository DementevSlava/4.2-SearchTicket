package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketByTimeAscComparator;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(1, 17837, "LED", "RHO", 720);
    Ticket ticket2 = new Ticket(2, 22793, "LED", "AYT", 700);
    Ticket ticket3 = new Ticket(3, 8418, "LON", "PAR", 120);
    Ticket ticket4 = new Ticket(4, 19690, "LED", "LAX", 1860);
    Ticket ticket41 = new Ticket(41, 24146, "LED", "LAX", 1720);
    Ticket ticket5 = new Ticket(5, 999, "MOW", "LED", 95);
    Ticket ticket51 = new Ticket(51, 1499, "MOW", "LED", 90);
    Ticket ticket52 = new Ticket(52, 1715, "MOW", "LED", 85);

    @BeforeEach
    void setup() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket41);
        manager.addTicket(ticket5);
        manager.addTicket(ticket51);
        manager.addTicket(ticket52);
    }

    @Test
    void shouldSort() {
        Ticket[] actual = repository.findAll();
        Ticket[] expected = {ticket5, ticket51, ticket52, ticket3, ticket1, ticket4, ticket2, ticket41};
        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchAll(){
        Ticket[] actual = manager.searchAll("MOW", "LED");
        Ticket[] expected = {ticket5, ticket51, ticket52};
        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNonAirports() {
        Ticket[] actual = manager.searchAll("LED", "MOW");
        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchAllUseComparator() {
        Ticket[] actual = manager.searchAll("MOW", "LED", new TicketByTimeAscComparator());
        Ticket[] expected = {ticket52, ticket51, ticket5};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNonAirportsUseComparator() {
        Ticket[] actual = manager.searchAll("LED", "MOW", new TicketByTimeAscComparator());
        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }
}