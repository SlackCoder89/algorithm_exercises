package org.hmk.find_itinerary;

import java.util.*;

public class Solution {
    final String JFK = "JFK";
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<Ticket, Integer> ticketList = new HashMap<>();
        for (List<String> ticket : tickets) {
            ticketList.compute(new Ticket(ticket.get(0), ticket.get(1)), (k, v) -> {
                if (v == null) {
                    return 1;
                } else {
                    return v + 1;
                }
            });
        }
        Station station = new Station(ticketList, JFK);
        Map<Station, List<String>> cache = new HashMap<>();
        return dfs(station, cache);
    }

    private List<String> dfs(Station station, Map<Station, List<String>> cache) {
        if (cache.containsKey(station)) {
            return new LinkedList<>(cache.get(station));
        }

        List<String> itinerary = new LinkedList<>();
        if (station.tickets.isEmpty()) {
            itinerary.add(station.start);
            cache.put(station, itinerary);
            return itinerary;
        }

        List<Ticket> current = new ArrayList<>();
        for (Ticket ticket : station.tickets.keySet()) {
            if (ticket.start.equals(station.start)) {
                current.add(ticket);
            }
        }
        if (current.isEmpty()) {
            cache.put(station, itinerary);
            return itinerary;
        }
        current.sort(Comparator.comparing(o -> o.end));

        for (Ticket ticket : current) {
            Map<Ticket, Integer> newTickets = new HashMap<>(station.tickets);
            newTickets.compute(ticket, (k, v) -> {
                if (v != null && v > 1) {
                    return  v - 1;
                } else {
                    return null;
                }
            });
            Station newStation = new Station(newTickets, ticket.end);
            itinerary = dfs(newStation, cache);
            if (!itinerary.isEmpty()) {

                break;
            }
        }

        if (!itinerary.isEmpty()) {
            itinerary.add(0, station.start);
        }
        cache.put(station, itinerary);
        return itinerary;
    }
}

class Ticket {
    String start;
    String end;

    public Ticket(String start, String end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;

        Ticket ticket = (Ticket) o;

        if (!Objects.equals(start, ticket.start)) return false;
        return Objects.equals(end, ticket.end);
    }

    @Override
    public int hashCode() {
        int result = start != null ? start.hashCode() : 0;
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }
}

class Station {
    Map<Ticket, Integer> tickets;
    String start;

    public Station(Map<Ticket, Integer> tickets, String start) {
        this.tickets = tickets;
        this.start = start;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Station)) return false;

        Station station = (Station) o;

        if (!Objects.equals(tickets, station.tickets)) return false;
        return Objects.equals(start, station.start);
    }

    @Override
    public int hashCode() {
        int result = tickets != null ? tickets.hashCode() : 0;
        result = 31 * result + (start != null ? start.hashCode() : 0);
        return result;
    }
}