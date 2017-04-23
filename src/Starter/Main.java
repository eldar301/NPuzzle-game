package Starter;

import fifteen.game.Field;
import fifteen.game.Npuzzle;

import java.util.Scanner;

/*
 * Пример игрового сеанса
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Field size:");
        int fieldSize = scanner.nextInt();
        System.out.println("Field type (c - conventional, s - spiral):");
        String fieldType = scanner.next();
        Npuzzle game = (fieldType.equals("c")) ? Npuzzle.createConventional(fieldSize) : Npuzzle.createSpiral(fieldSize);
        game.generateInitialField(10);
        System.out.println(game.getCurrentField());
        while (!game.isSolved()) {
            System.out.println("Make move(u, r, d, l, solve):");
            String dir = scanner.next();
            switch (dir) {
                case "d":
                    game.turnDown();
                    System.out.println(game.getCurrentField());
                    break;
                case "l":
                    game.turnLeft();
                    System.out.println(game.getCurrentField());
                    break;
                case "r":
                    game.turnRight();
                    System.out.println(game.getCurrentField());
                    break;
                case "u":
                    game.turnUp();
                    System.out.println(game.getCurrentField());
                    break;
                case "solve" :
                    for (Field field : game.solve()) {
                        System.out.println(field);
                    }
                    break;
                default:
                    try {
                        int switchWith = Integer.parseInt(dir);
                        game.turnTo(switchWith);
                        System.out.println(game.getCurrentField());
                    } catch (NumberFormatException e) {
                        System.out.println(String.format("Undefined input [%1$s]", dir));
                    };
                    break;
            }
        }
        System.out.println("Solved");
    }
}
