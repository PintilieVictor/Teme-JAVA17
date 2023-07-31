package Tema8;

public class Athlete {
    String csvFilePath = "src/main/resources/AthleteResult";

    public Athlete(int athleteNumber, String athleteName, CountryCode countryCode, double skiTimeResult, String firstShooting, String secondShooting, String thirdShooting) {
    }

    enum CountryCode {
        SK, UK, CZ// Slovakia, Ukraine, Czechia
        class Athlete implements Comparable<Athlete> {
            int athleteNumber;
            String athleteName;
            CountryCode countryCode;
            double skiTimeResult;
            String firstShooting;
            String secondShooting;
            String thirdShooting;

        public Athlete(int athleteNumber, String athleteName, CountryCode countryCode, double skiTimeResult, String firstShooting, String secondShooting, String thirdShooting) {
        }



            Athlete(int athleteNumber, String athleteName, CountryCode countryCode, double skiTimeResult, String firstShooting, String secondShooting, String thirdShooting) {
                this.athleteNumber = athleteNumber;
                this.athleteName = athleteName;
                this.countryCode = countryCode;
                this.skiTimeResult = skiTimeResult;
                this.firstShooting = firstShooting;
                this.secondShooting = secondShooting;
                this.thirdShooting = thirdShooting;
            }

            @Override
            public int compareTo(Athlete other) {
                return Double.compare(this.skiTimeResult, other.skiTimeResult);
            }
        }
    }
}
