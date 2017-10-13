package com.jayway.alphabet.screen.tickets;

import java.util.ArrayList;
import java.util.List;

public class TicketRepository {
    public List<Ticket> get() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket("59df18e340d4cb00fac5d3e5", "Buddies 3 Day Conference Pass + Hotel", "The full experience", "30.600 SEK"));
        tickets.add(new Ticket("59df190140d4cb00fac5d3e6", "2 day Conference Pass", "T", "10.800 SEK"));
        tickets.add(new Ticket("59df191b40d4cb00fac5d3e8", "3 day Conference Pass", "The full experience", "13.800 SEK"));
        tickets.add(new Ticket("59df193d40d4cb00fac5d3e9", "3 Day Conference Pass + Hotel", "The full experience", "16.800 SEK"));
        tickets.add(new Ticket("59df195640d4cb00fac5d3ea", "3 Day Conference Pass + Workshop", "The full experience", "15.800 SEK"));
        tickets.add(new Ticket("59df196e40d4cb00fac5d3eb", "3 Day Conference Pass + Workshop + Hotel", "The full experience", "18.800 SEK"));
        tickets.add(new Ticket("59df197f40d4cb00fac5d3ec", "1 Day Workshop", "", "5.000 SEK"));

        return tickets;
    }
}