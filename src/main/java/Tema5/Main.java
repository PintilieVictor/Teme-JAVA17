package Tema5;

public class Main {
    public static void main(String[] args) {
        Tema5.SalesRepresentative[] representatives = createRepresentativesArray();

        System.out.println("Before sorting:");
        printRepresentatives(representatives);

        bubbleSort(representatives);

        System.out.println("After sorting:");
        printRepresentatives(representatives);
    }

    private static Tema5.SalesRepresentative[] createRepresentativesArray() {
        // Create an array of SalesRepresentative objects
        Tema5.SalesRepresentative[] representatives = new Tema5.SalesRepresentative[5];
        representatives[0] = new Tema5.SalesRepresentative("John", 10, 1000);
        representatives[1] = new Tema5.SalesRepresentative("Alice", 8, 1500);
        representatives[2] = new Tema5.SalesRepresentative("Bob", 12, 800);
        representatives[3] = new Tema5.SalesRepresentative("Emily", 15, 1200);
        representatives[4] = new Tema5.SalesRepresentative("David", 9, 2000);

        return representatives;
    }

    private static void bubbleSort(Tema5.SalesRepresentative[] representatives) {
        int n = representatives.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Compare the revenue of adjacent representatives
                if (representatives[j].getRevenue() < representatives[j + 1].getRevenue()) {
                    // Swap representatives if the revenue is in descending order
                    Tema5.SalesRepresentative temp = representatives[j];
                    representatives[j] = representatives[j + 1];
                    representatives[j + 1] = temp;
                }
            }
        }
    }

    private static void printRepresentatives(Tema5.SalesRepresentative[] representatives) {
        for (Tema5.SalesRepresentative representative : representatives) {
            System.out.println(representative);
        }
        System.out.println();
    }
}

