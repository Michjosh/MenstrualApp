package PeriodApplication.PresentationLayer;

import PeriodApplication.ServiceLayer.MenstrualPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
//

@RestController
@RequestMapping("/menstrualApp")
public class MPController {

    @Autowired
    private MenstrualPeriodService menstrualPeriodService;

    @GetMapping("/calculateNextPeriodDate")
    public String calculateNextPeriodDate(@RequestParam String lastPeriodDate, @RequestParam int cycleLength, @RequestParam int periodLength) {
        try {
            return menstrualPeriodService.calculateNextPeriodDate(lastPeriodDate, cycleLength, periodLength);
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
    }

    @GetMapping("/getEstimatedPeriodDates")
    public String getEstimatedPeriodDates(@RequestParam String nextPeriodDate, @RequestParam int cycleLength, @RequestParam int periodLength) {
        try {
            return Arrays.toString(menstrualPeriodService.getEstimatedPeriodDates(nextPeriodDate, cycleLength, periodLength));
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
    }
}


//@RestController
//public class MPController {
//    @Autowired
//    private MenstrualPeriodService menstrualPeriodService;
//
//        @GetMapping("/menstrualApp/calculateNextPeriodDate/{lastPeriodDate}{cycleLength}{periodLength}")
//        public String calculateNextPeriodDate(@PathVariable CreateUserRequest lastPeriodDate, @PathVariable CreateUserRequest cycleLength,
//                                              @PathVariable CreateUserRequest periodLength) {
//            try {
//                return menstrualPeriodService.calculateNextPeriodDate((String) lastPeriodDate.getDateOfLastPeriod(),
//                        cycleLength.getLengthOfCycle(), periodLength.getLengthOfPeriod());
//            } catch (IllegalArgumentException ex) {
//                return ex.getMessage();
//            }
//        }
//        @GetMapping("/menstrualApp/calculateNextPeriodDate/{lastPeriodDate}{cycleLength}{periodLength}")
//        public String getEstimatedPeriodDates(@PathVariable CreateUserRequest lastPeriodDate, @PathVariable CreateUserRequest cycleLength,
//                                              @PathVariable CreateUserRequest periodLength){
//            try {
//                return Arrays.toString(menstrualPeriodService.getEstimatedPeriodDates((String) lastPeriodDate.getDateOfLastPeriod(),
//                        cycleLength.getLengthOfCycle(), periodLength.getLengthOfPeriod()));
//            } catch (IllegalArgumentException ex) {
//                return ex.getMessage();
//            }
//        }
//
//        @GetMapping("/menstrualApp/calculateNextPeriodDate/{lastPeriodDate}{cycleLength}{periodLength}")
//        public String getEstimatedPeriodDates(@PathVariable String lastPeriodDate, @PathVariable int cycleLength, @PathVariable int periodLength){
//        try {
//            return Arrays.toString(menstrualPeriodService.getEstimatedPeriodDates(lastPeriodDate, cycleLength, periodLength));
//        } catch (IllegalArgumentException ex) {
//            return ex.getMessage();
//        }
//
//        }
//        @GetMapping("/menstrualApp/calculateNextPeriodDate/{lastPeriodDate}{cycleLength}{periodLength}")
//        public String calculateNextPeriodDate(@PathVariable String lastPeriodDate, @PathVariable int cycleLength, @PathVariable int periodLength) {
//        try {
//            return menstrualPeriodService.calculateNextPeriodDate(lastPeriodDate, cycleLength, periodLength);
//        } catch (IllegalArgumentException ex) {
//            return ex.getMessage();
//        }
//    }
//}
