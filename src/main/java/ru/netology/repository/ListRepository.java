package ru.netology.repository;

import ru.netology.domain.FlightList;

public class ListRepository {
    private FlightList[] flightLists = new FlightList[0];

    public void save(FlightList flightList) {
        int length = flightLists.length + 1;
        FlightList[] tmp = new FlightList[length];
        System.arraycopy(flightLists, 0, tmp, 0, flightLists.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = flightList;
        flightLists = tmp;
    }

    public FlightList[] findAll() {
        return flightLists;
    }

    public FlightList findByAirportsOut(String airportFrom) {
        for (FlightList flightList : flightLists) {
            if (airportFrom.equals(flightList.getDepartureAirport())) {
                return flightList;
            }
        }
        return null;
    }

    public FlightList findByAirportsIn(String airportTo) {
        for (FlightList flightList : flightLists) {
            if (airportTo.equals(flightList.getArrivalAirport())) {
                return flightList;
            }
        }
        return null;
    }

    public void removeById(int id) {
            int length = flightLists.length - 1;
            FlightList[] tmp = new FlightList[length];
            int index = 0;
            for (FlightList item : flightLists) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            flightLists = tmp;
    }


}
