package PeriodApplication.ServiceLayer;

import PeriodApplication.DTOs.FindUserResponse;

public interface MenstrualPeriodService {

    String calculateNextPeriodDate(FindUserResponse lastPeriodDate, FindUserResponse cycleLength, FindUserResponse periodLength);


    String[] getEstimatedPeriodDates(FindUserResponse lastPeriodDate, FindUserResponse cycleLength, FindUserResponse periodLength);
}