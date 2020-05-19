package ru.netology.repository;

import ru.netology.domain.Ticket;

public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket ticket) {
        int length = tickets.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public Ticket findByAirportsOut(String airportFrom) {
        for (Ticket ticket : tickets) {
            if (ticket.getDepartureAirport() == airportFrom) {
                return ticket;
            }
        }
        return null;
    }

    public Ticket findByAirportsIn(String airportTo) {
        for (Ticket ticket : tickets) {
            if (ticket.getArrivalAirport() == airportTo) {
                return ticket;
            }
        }
        return null;
    }

    public void removeById(int id) {
            int length = tickets.length - 1;
            Ticket[] tmp = new Ticket[length];
            int index = 0;
            for (Ticket item : tickets) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            tickets = tmp;
    }


}
