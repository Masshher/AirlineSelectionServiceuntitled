package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.manager.AviaSouls;

import java.util.Comparator;

public class AviaSoulTest {

    Ticket ticket1 = new Ticket("City1", "City2", 45_000, 8, 15);
    Ticket ticket2 = new Ticket("City3", "City1", 15_000, 20, 23);
    Ticket ticket3 = new Ticket("City1", "City2", 25_000, 7, 10);
    Ticket ticket4 = new Ticket("City4", "City1", 43_000, 2, 9);
    Ticket ticket5 = new Ticket("City1", "City2", 15_000, 23, 5);
    Ticket ticket6 = new Ticket("City3", "City4", 25_000, 5, 9);
    Ticket ticket7 = new Ticket("City4", "City2", 42_000, 6, 13);

    
    @Test
    public void compareTwoTicketsWithMoreExpensiveTicketChoice() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void compareTwoTicketsWithCheaperTicketChoice() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket4);

        int expected = -1;
        int actual = ticket5.compareTo(ticket4);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void compareTwoTicketsWithTheSamePrice() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket6);

        int expected = 0;
        int actual = ticket3.compareTo(ticket6);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void SelectingEligibleTicketsSortedByPrice() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        Ticket[] expected = {ticket5, ticket3, ticket1};
        Ticket[] actual = aviaSouls.search("City1", "City2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void FindATicketWhenYouDonNotHaveTheRightDirection() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("City2", "City3");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void FindTicketAtOneDestination() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);

        Ticket[] expected = {ticket7};
        Ticket[] actual = aviaSouls.search("City4", "City2");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void SelectionOfSuitableTicketsSortedByFlightTime() {
        AviaSouls aviaSouls = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);

        Ticket[] expected = {ticket3, ticket5, ticket1};
        Ticket[] actual = aviaSouls.searchAndSortBy("City1", "City2", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }


}
