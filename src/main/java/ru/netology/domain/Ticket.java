package ru.netology.domain;

public class Ticket implements Comparable{
    private int id;
    private int cost;
    private String departureAirport;
    private String arrivalAirport;
    private int time;

    public Ticket(int id, int cost, String departureAirport, String arrivalAirport, int time) {
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
    public int compareTo(Object o) {
        Ticket ticket = (Ticket) o;
        return cost - ticket.cost;
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
