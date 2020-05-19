package ru.netology.manager;

import ru.netology.domain.FlightList;
import ru.netology.repository.ListRepository;

public class ListManager {
    private ListRepository repository;

    public ListManager(ListRepository repository) {
        this.repository = repository;
    }

    public void addTicket (FlightList flightList) {
        repository.save(flightList);
    }

    public FlightList[] searchAll(String airportFrom, String airportTo) {
        FlightList[] result = new FlightList[0];
        for (FlightList flightList : repository.findAll()) {
            if (airportFrom.equals(flightList.getDepartureAirport()) && airportTo.equals(flightList.getArrivalAirport())) {
                FlightList[] tmp = new FlightList[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = flightList;
                result = tmp;
            }
        }
        return result;
    }


}
