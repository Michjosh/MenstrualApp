package PeriodApplication.ServiceLayer;

import PeriodApplication.DTOs.FindUserResponse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MenstrualPeriodServiceImpl implements MenstrualPeriodService {

    @Override
    public String calculateNextPeriodDate(FindUserResponse lastPeriodDate, FindUserResponse cycleLength, FindUserResponse periodLength) {
        LocalDate date = LocalDate.parse(lastPeriodDate.getDateOfLastPeriod());
        date = date.plusDays(cycleLength.getLengthOfCycle() - periodLength.getLengthOfPeriod());
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @Override
    public String[] getEstimatedPeriodDates(FindUserResponse lastPeriodDate, FindUserResponse cycleLength, FindUserResponse periodLength) {
        String nextPeriodDate = calculateNextPeriodDate(lastPeriodDate, cycleLength, periodLength);
        LocalDate date = LocalDate.parse(nextPeriodDate);

        List<String> estimatedPeriodDates = new ArrayList<>();

        // Calculate the estimated period dates for the next year
        for (int i = 0; i < 6; i++) {
            date = date.plusDays((Long.parseLong(String.valueOf(cycleLength))));
            estimatedPeriodDates.add(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        }

        return estimatedPeriodDates.toArray(new String[0]);
    }
}