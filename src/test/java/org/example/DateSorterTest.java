package org.example;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DateSorterTest {

    @Test
    public void testSortDates() {
        DateSorter dateSorter = new DateSorter();

        // Create a list of unsorted dates
        List<LocalDate> unsortedDates = Arrays.asList(
                LocalDate.of(2004, 7, 1),
                LocalDate.of(2005, 1, 2),
                LocalDate.of(2007, 1, 1),
                LocalDate.of(2032, 5, 3)
        );

        // Expected sorted order
        List<LocalDate> expectedSortedDates = Arrays.asList(
                LocalDate.of(2005, 1, 2),
                LocalDate.of(2007, 1, 1),
                LocalDate.of(2032, 5, 3),
                LocalDate.of(2004, 7, 1)
        );

        // Call the sortDates method
        Collection<LocalDate> sortedDates = dateSorter.sortDates(unsortedDates);

        // Check if the sorted dates match the expected order
        assertEquals(expectedSortedDates, sortedDates);
    }
}