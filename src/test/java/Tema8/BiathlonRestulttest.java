package Tema8;

import junit.framework.TestCase;
import org.junit.Test;

import java.awt.*;

public class BiathlonRestulttest {
    @Test
    void testCsvParsing() {
        Object Athlete;
        List<Athlete> athletes = BiathlonResults.Athlete(Athlete);

        TestCase Assertions = null;
        Assertions.assertEquals(3, athletes.size());

        Athlete firstAthlete = athletes.get(0);
        Assertions.assertEquals(11, firstAthlete.athleteNumber);
        Assertions.assertEquals("Umar Jorgson", firstAthlete.athleteName);
        Assertions.assertEquals(CountryCode.SK, firstAthlete.countryCode);
        Assertions.assertEquals(1827.0, firstAthlete.skiTimeResult);
        Assertions.assertEquals("xxxox", firstAthlete.firstShooting);
        Assertions.assertEquals("xxxxx", firstAthlete.secondShooting);
        Assertions.assertEquals("xxoxo", firstAthlete.thirdShooting);
    }

    @Test
    void testStandingCalculation() {
        List<Athlete> athletes = "src/main/resources/AthleteResult";
        BiathlonResults.calculateAndUpdateStandings(athletes);
        athletes.sort(Athlete::compareTo);

        Assertions.assertEquals(3, athletes.size());

        Athlete winner = athletes.get(0);
        Athlete runnerUp = athletes.get(1);
        Athlete thirdPlace = athletes.get(2);

        Assertions.assertEquals("Jimmy Smiles", winner.athleteName);
        Assertions.assertEquals("Umar Jorgson", runnerUp.athleteName);
        Assertions.assertEquals("Piotr Smitzer", thirdPlace.athleteName);
    }
}
