package ru.netology.domain;

public class FlightList implements Comparable<FlightList>{
    private int id;
    private int cost;
    private String departureAirport;
    private String arrivalAirport;
    private int time;

    public FlightList(int id, int cost, String departureAirport, String arrivalAirport, int time) {
        this.id = id;
        this.cost = cost;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public int getTime() {
        return time;
    }


    @Override
    public int compareTo(FlightList o) {
                return cost - o.cost;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", cost=" + cost +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", time=" + time +
                '}';
    }
}
