package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rowNum = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsNum = scanner.nextInt();

        int[][] seats = new int[rowNum + 1][seatsNum + 1];
        int purchasedTickets = 0;
        double percentage = 0;
        int currentincome = 0;

        while (true) {
            System.out.println();
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    System.out.println();
                    getSeats(seats, seatsNum, rowNum);
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Enter a row number:");
                    int num1 = scanner.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    int num2 = scanner.nextInt();
                    while (num1 > rowNum || num1 < 0 || num2 > seatsNum || num2 < 0) {
                        System.out.println("Wrong input!");
                        System.out.println();
                        System.out.println("Enter a row number:");
                        num1 = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        num2 = scanner.nextInt();
                    }

                    while (seats[num1 - 1][num2 - 1] > 0) {
                        System.out.println("That ticket has already been purchased!");
                        System.out.println();
                        System.out.println("Enter a row number:");
                        num1 = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        num2 = scanner.nextInt();
                    }


                    System.out.println("Ticket price: $"+purchaseTicket(num1, rowNum, seatsNum));
                    seats[num1-1][num2-1] = 1;
                    purchasedTickets++;
                    currentincome += purchaseTicket(num1, rowNum, seatsNum);
                    break;
                case 3:
                    System.out.println();
                    int totalIncome = 0;
                    if (rowNum * seatsNum < 61) {
                        totalIncome = rowNum * seatsNum * 10;
                    } else {
                        totalIncome = rowNum/2 * seatsNum * 10;
                        totalIncome += (rowNum - rowNum/2) * seatsNum * 8;
                    }


                    if (purchasedTickets != 0 && (rowNum * seatsNum) != 0) {
                        percentage = (1.0 * purchasedTickets) * 100 / (rowNum * seatsNum * 1.0);
                    }


                    System.out.println("Number of purchased tickets: " + purchasedTickets);
                    System.out.printf("Percentage: %.2f%%", percentage);
                    System.out.println("\nCurrent income: $" + currentincome + "\n" +
                            "Total income: $" + totalIncome);
                    break;

            }
            if (choose == 0) {
                break;
            }
        }

    }

    public static void getSeats(int[][] seats, int seatsNum, int rowNum) {
        StringBuilder matrix = new StringBuilder("Cinema:\n  ");
        for (int i = 1; i <= seatsNum; i++){
            matrix.append(i + " ");
        }
        for (int i = 1; i <= rowNum; i++) {
            matrix.append("\n" + i);
            for (int j = 1; j <= seatsNum; j++) {
                String str = "";
                if (seats[i-1][j-1] == 0) {
                    str = " S";
                } else {
                    str = " B";
                }
                matrix.append(str);
            }
        }
        System.out.println(matrix);
    }

    public static int purchaseTicket(int num1, int rowNum, int seatsNum) {
        int ticketPrice = 0;
        if (rowNum * seatsNum < 61) {
            ticketPrice = 10;
        } else if (num1 <= rowNum/2){
            ticketPrice = 10;
        } else if(num1 > rowNum/2) {
            ticketPrice = 8;
        }
        return ticketPrice;

    }
}