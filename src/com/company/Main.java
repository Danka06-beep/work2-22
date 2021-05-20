package com.company;


import java.util.Random;
import java.util.Scanner;



class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int SIZE = 10;
        int warField[][]= new int[SIZE][SIZE];
        int EMPTY = 0;
        int SHIP = 1;
        int DEAD = 2;
        int MISS = 3;
        int MAX_COUNT = 10;
        int countship = 10;
        int countHod = MAX_COUNT;

        System.out.println();
        System.out.println("Игра морской бой");
        System.out.println("Заполнение кораблей.....");
        System.out.println();

        for (int i = 0; i < MAX_COUNT; i++) {
            int shipPlace1 = random.nextInt(SIZE);
            int shipPlace2 = random.nextInt(SIZE);

            if (warField[shipPlace1][shipPlace2] == SHIP){
                i--;
            }
            warField[shipPlace1][shipPlace2] = SHIP;

        }
        for (int i = 0; i< SIZE; i++) {
            for (int j = 0; j< SIZE; j++) {
                System.out.print(warField[i][j]);
            }
            System.out.println();
        }
        while (true){
            System.out.println("Введите координаты для атаки (осталось"+ "" + countHod + ")");
            countHod--;
            System.out.println("Введите кординату x:");
            int x = scanner.nextInt() - 1;
            System.out.println("Введите кординату y:");
            int y = scanner.nextInt() - 1;
            if (warField[x][y] == SHIP) {
                System.out.println("убил");
                warField[x][y] = DEAD;
                countship --;
            }else {
                System.out.println("Промах");
                warField[x][y] = MISS;
            }
            if(countship == 0){
                System.out.println("Победа");
                break;
            }
            if (countHod == 0){
                System.out.println("Проиграл");
                break;
            }
            for (int i = 0; i< SIZE; i++) {
                for (int j = 0; j< SIZE; j++) {
                    System.out.print(warField[i][j]);
                }
                System.out.println();
            }
        }
    }
}
