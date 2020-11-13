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

        System.out.println();

        getSeats(seats, seatsNum, rowNum);

        System.out.println();
        System.out.println("Enter a row number:");
        int num1 = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int num2 = scanner.nextInt();

        int ticketPrice = 0;
        if (rowNum * seatsNum < 61) {
            ticketPrice = 10;
        } else if (num1 <= rowNum/2){
            ticketPrice = 10;
        } else if(num1 > rowNum/2) {
            ticketPrice = 8;
        }
        System.out.println("\nTicket price: $"+ticketPrice);
        System.out.println();
        seats[num1-1][num2-1] = 1;

        getSeats(seats, seatsNum, rowNum);


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
        // something jjjj

    }
}