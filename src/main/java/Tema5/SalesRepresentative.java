package Tema5;

public class SalesRepresentative {
    private String name;
    private int sales;
    private double quota;

    public SalesRepresentative(String name, int sales, double quota) {
        this.name = name;
        this.sales = sales;
        this.quota = quota;
    }

    public double getRevenue() {
        return sales * quota;
    }

    @Override
    public String toString() {
        return "SalesRepresentative" +
                "name='" + name + '\'' +
                ", sales=" + sales +
                ", quota=" + quota +
                ", revenue=" + getRevenue();
    }
}
