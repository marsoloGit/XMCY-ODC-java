package config;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Const {


    public enum BrowserType {

        CHROME("chromium"),
        FIREFOX("firefox"),
        WEBKIT("webkit");

        private String name;

        BrowserType(String name) {
            this.name = name;

        }

        public String getName() {
            return this.name;
        }

    }


    public enum CalendarRanges {
        TODAY(1),
        TOMORROW(2),
        THIS_WEEK(3),
        NEXT_WEEK(4),
        THIS_MONTH(5),
        NEXT_MONTH(6);

        private int rangeNum;

        CalendarRanges(int range_num) {
            this.rangeNum = range_num;
        }

        public int getRangeNum(){
            return this.rangeNum;
        }


        public List<String> getRange(int rangeNum) {


            List<LocalDate> datesRange = new ArrayList<>();
            LocalDate today = LocalDate.now();

            switch (this) {
                case TODAY:
                    datesRange.add(today);
                    break;
                case TOMORROW:
                    LocalDate tomorrow = today.plusDays(1);
                    datesRange.add(tomorrow);
                    break;
                case THIS_WEEK:
                    datesRange = getAllDatesInWeek(today);
                    break;
                case NEXT_WEEK:
                    LocalDate dtOneWeekFromToday = today.plusDays(7);
                    datesRange = getAllDatesInWeek(dtOneWeekFromToday);
                    break;
                case THIS_MONTH:
                    datesRange = getAllDatesInMonth(today);
                    break;
                case NEXT_MONTH:
                    LocalDate dtFirstDayInNextMonth = today.plusMonths(1).withDayOfMonth(1);
                    datesRange = getAllDatesInMonth(dtFirstDayInNextMonth);
                    break;
                default:
                    throw new IllegalStateException();

            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd yyyy");

            return datesRange.stream()
                    .map(formatter::format)
                    .collect(Collectors.toList());


        }

        private List<LocalDate> getAllDatesInMonth(LocalDate givenDate) {


            // Get the year and month from the example date
            int year = givenDate.getYear();
            int month = givenDate.getMonthValue();

            // Create a YearMonth object for the given year and month
            YearMonth yearMonth = YearMonth.of(year, month);

            // Create a list to hold all the dates in the month
            List<LocalDate> datesInMonth = new ArrayList<>();

            // Loop through all the days in the month and add them to the list
            for (int day = 1; day <= yearMonth.lengthOfMonth(); day++) {
                LocalDate d = yearMonth.atDay(day);
                datesInMonth.add(d);
            }

            return datesInMonth;
        }


        private List<LocalDate> getAllDatesInWeek(LocalDate givenDate) {

            // Get the first day of the week (Monday) for the given date
            LocalDate firstDayOfWeek = givenDate.with(DayOfWeek.MONDAY);

            // Create a list to hold all the dates in the week
            List<LocalDate> datesInWeek = new ArrayList<>();

            // Loop through all the days of the week and add them to the list
            for (int i = 0; i < 7; i++) {
                LocalDate d = firstDayOfWeek.plusDays(i);
                datesInWeek.add(d);
            }

            return datesInWeek;

        }
    }


}


