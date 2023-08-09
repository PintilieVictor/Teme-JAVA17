package Tema8;

import java.awt.*;
import java.util.ArrayList;

public class BiathlonResults {
    public static <AthleteResult> List<Athlete> main(String[] args) {


        public static List<AthleteResult> parseCsvData (List < String > AthleteResult) {
            List<Athlete> athletes = new ArrayList<>();
            for (String line : Athlete) {
                String[] data = line.split(",");
                int athleteNumber = Integer.parseInt(data[0]);
                String athleteName = data[1];
                Athlete.CountryCode countryCode = Athlete.CountryCode.valueOf(data[2]);
                double skiTimeResult = convertTimeToSeconds(data[3]);
                String firstShooting = data[4];
                String secondShooting = data[5];
                String thirdShooting = data[6];

                athletes.add(new Athlete(athleteNumber, athleteName, countryCode,
                        skiTimeResult, firstShooting, secondShooting, thirdShooting).toString());
            }
            return athletes;
        }
    }

    private static double convertTimeToSeconds(String s) {
        return 0;
    }

    public static void calculateAndUpdateStandings(List athletes) {
    }
}
