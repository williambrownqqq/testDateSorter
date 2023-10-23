package org.example;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

 /**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 * Implement in single class. Don't chane constructor and signature method.
 */
public class DateSorter {

    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
     * would sort to
     * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        return unsortedDates.stream()
                .sorted((date1, date2) -> {
                    boolean hasR1 = date1.getMonth().toString().toLowerCase().contains("r");
                    boolean hasR2 = date2.getMonth().toString().toLowerCase().contains("r");

                    if (hasR1 && !hasR2) {
                        return -1;
                    } else if (!hasR1 && hasR2) {
                        return 1;
                    } else {
                        if (hasR1) {
                            return date1.compareTo(date2); // Sort with 'r' in ascending order
                        } else {
                            return date2.compareTo(date1); // Sort without 'r' in descending order
                        }
                    }
                })
                .collect(Collectors.toList());
    }
 }