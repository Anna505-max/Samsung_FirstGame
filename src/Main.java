import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String monster = "\uD83E\uDDDF";
        String castle = "\uD83C\uDFF0";
        int step = 0;
       Person person = null;

        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        System.out.println("Ваш ответ:\t" + answer);

        switch (answer) {
            case "ДА":
                person = new Person(1, 1);
                System.out.println("Выбери сложность игры (от 1 до 5):");
                int difficultGame = scanner.nextInt();
                int sizeBoard;
                switch (difficultGame) {
                    case 1:
                        sizeBoard = 3;
                        break;
                    case 2:
                        sizeBoard = 4;
                        break;
                    case 3:
                        sizeBoard = 5;
                        break;
                    case 4:
                        sizeBoard = 6;
                        break;
                    case 5:
                        sizeBoard = 7;
                        break;
                    default:
                        sizeBoard = 5;
                        break;
                }
                System.out.println("Выбранная сложность:\t" + difficultGame);
                String[][] board = new String[sizeBoard][sizeBoard];
                startOne(sizeBoard, monster, castle, board);

                while (true) {
                    board[person.getY() - 1][person.getX() - 1] = person.getImage();
                    outputBoard(board, person.getLive(), sizeBoard);

                    System.out.println("Введите, куда будет ходить персонаж "
                            + "(ход возможен только по вертикали или горизонтали на одну клетку)"
                            + "\nКоординаты персонажа — (x: " + person.getX() + ", y: " + person.getY() + ")");

                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    System.out.println(x + ", " + y);

                    if (x != person.getX() && y != person.getY()) {
                        System.out.println("Некорректный ход");
                    } else if (Math.abs(x - person.getX()) == 1 || Math.abs(y - person.getY()) == 1) {
                        if (board[y - 1][x - 1].equals("  ")) {
                            board[person.getY() - 1][person.getX() - 1] = "  ";
                            person.move(x, y);
                            step++;
                            System.out.println("Ход корректный; новые координаты: "
                                    + person.getX() + ", " + person.getY()
                                    + "\nХод номер: " + step);
                        } else if (board[y - 1][x - 1].equals(castle)) {
                            System.out.println("Вы прошли игру! Поздравляю!");
                            break;
                        } else {
                            System.out.println("Решите задачу:");
                            if (taskMonster(difficultGame)) {
                                board[person.getY() - 1][person.getX() - 1] = "  ";
                                person.move(x, y);
                                step++;
                            } else {
                                person.downLive();
                            }
                        }
                    } else {
                        System.out.println("Координаты не изменены");
                    }

                    if (person.getLive() <= 0) {
                        break;
                    }
                }

                if (person.getLive() <= 0) {
                    System.out.println("Закончились жизни. Итог: ...");
                }
                break;

            case "НЕТ":
                System.out.println("Жаль, приходи ещё!");
                break;

            default:
                System.out.println("Данные введены некорректно");
                break;
        }
    }


    static void startOne(int sizeBoard, String monster, String castle, String[][] board) {
        Random random = new Random();
        int castleX = 1 + random.nextInt(sizeBoard);
        int castleY = 1;


        for (int y = 1; y <= sizeBoard; y++) {
            for (int x = 1; x <= sizeBoard; x++) {
                board[y - 1][x - 1] = "  ";
            }
        }

        int countMonster = sizeBoard * sizeBoard - sizeBoard - 1;
        for (int i = 0; i < countMonster; i++) {
            board[random.nextInt(sizeBoard - 1)][random.nextInt(sizeBoard)] = monster;
        }

        board[castleY - 1][castleX - 1] = castle;
    }


    static boolean taskMonster(int difficultGame) {
        if (difficultGame == 1) {
            Random random = new Random();
            int a = random.nextInt(100);
            int b = random.nextInt(100);
            int trueAnswer = a + b;

            System.out.println("Реши пример: " + a + " + " + b + " = ?");
            Scanner sc = new Scanner(System.in);
            int ans = sc.nextInt();

            if (trueAnswer == ans) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            } else {
                System.out.println("Ты проиграл эту битву!");
                return false;
            }
        } else if (difficultGame == 2) {
            Random random = new Random();
            int a = 100 + random.nextInt(100);
            int b = 100 + random.nextInt(100);
            int trueAnswer = a + b;

            System.out.println("Реши пример: " + a + " + " + b + " = ?");
            Scanner sc = new Scanner(System.in);
            int ans = sc.nextInt();

            if (trueAnswer == ans) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            } else {
                System.out.println("Ты проиграл эту битву!");
                return false;
            }
        } else if (difficultGame == 3) {
            Random random = new Random();
            int a = 200 + random.nextInt(100);
            int b = 200 + random.nextInt(100);
            int trueAnswer = a + b;

            System.out.println("Реши пример: " + a + " + " + b + " = ?");
            Scanner sc = new Scanner(System.in);
            int ans = sc.nextInt();

            if (trueAnswer == ans) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            } else {
                System.out.println("Ты проиграл эту битву!");
                return false;
            }
        } else if (difficultGame == 4) {
            Random random = new Random();
            int a = 300 + random.nextInt(100);
            int b = 300 + random.nextInt(100);
            int trueAnswer = a + b;

            System.out.println("Реши пример: " + a + " + " + b + " = ?");
            Scanner sc = new Scanner(System.in);
            int ans = sc.nextInt();

            if (trueAnswer == ans) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            } else {
                System.out.println("Ты проиграл эту битву!");
                return false;
            }
        } else if (difficultGame == 5) {
            Random random = new Random();
            int a = 400 + random.nextInt(100);
            int b = 400 + random.nextInt(100);
            int trueAnswer = a + b;

            System.out.println("Реши пример: " + a + " + " + b + " = ?");
            Scanner sc = new Scanner(System.in);
            int ans = sc.nextInt();

            if (trueAnswer == ans) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            } else {
                System.out.println("Ты проиграл эту битву!");
                return false;
            }
        } else {

            return false;
        }

    }

    static void outputBoard(String[][] board, int live, int sizeBoard) {
        String leftBlock = "|";
        String rightBlock = "|";
        String wall = "+——";


        for (String[] row : board) {
            for (int i = 0; i < sizeBoard; i++) {
                System.out.print(wall);
            }
            System.out.println("+");
            for (String cell : row) {
                System.out.print(leftBlock);
                System.out.print(cell);
            }
            System.out.println(rightBlock);
        }
        for (int i = 0; i < sizeBoard; i++) {
            System.out.print(wall);
        }
        System.out.println("+");

        System.out.println("Количество жизней:\t" + live + "\n");
    }
}







