
import java.util.Scanner;



public class Main {
    public static boolean isWin = false;
    public static boolean correctParant = false;
    public static int correctPlace = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] mapsFirstPlayer = new String[10][10];
        String[][] mapsOnesPlayer = new String[10][10];
        String[][] checkMapsFirstPlayer = new String[10][10];
        String[][] checkMapsOnesPlayer = new String[10][10];
        int chipFirstPlayer = 20;
        int chipOnesPlayer = 20;
        int x;
        int y;
        int blocks = 4;
        readyMap(checkMapsFirstPlayer);
        readyMap(checkMapsOnesPlayer);
        readyMap(mapsFirstPlayer);
        readyMap(mapsOnesPlayer);
        printFirstMap(mapsFirstPlayer);
        System.out.println("Первый игрок расставляет корабли,Начинаем с самого большого (4клетки) ");
        do {
            correctPlace = 0;  // Переменная, благодаря которой проверяем корректность постановки корабля
            System.out.println("Введите первую координату");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
            if (x > 10 || x < 0 || y > 10 || y < 0) {
                System.out.println("Не выходи за рамки");
                continue;
            }
            if (mapsFirstPlayer[x][y].equals("X")) {
                System.out.println("Нельзя ставить на одинаковые места");
                continue;
            }
            correctPlace(x,y,mapsFirstPlayer); // Функция, которая проверяет корректность установки корабля
            if (correctPlace >= 1) {
                mapsFirstPlayer[x][y] = "X";
                printFirstMap(mapsFirstPlayer);
                createShip(x, y, blocks, mapsFirstPlayer); // функция, которая рисует наш корабль
            }
            else
            {
                System.out.println("Нельзя ставить рядом");
            }
        }
        while (correctParant != true);

        blocks = 3; // Длина корабля
        System.out.println();
        printFirstMap(mapsFirstPlayer); // Печатаем массив с заполненным кораблем
        System.out.println("Теперь 2 корабля по 3 клетки");
        for (int i = 0 ;i<2;i++) {
            correctPlace =0; // Переменная, благодаря которой проверяем корректность постановки корабля
            correctParant = false;
            do {
                System.out.println("Введите первую координату");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
                if (x > 10 || x < 0 || y > 10 || y < 0)
                {
                    System.out.println("Не выходи за рамки");
                    continue;
                }
                if (mapsFirstPlayer[x][y].equals("X"))
                {
                    System.out.println("Нельзя ставить на одинаковые места");
                    continue;
                }
                correctPlace(x, y, mapsFirstPlayer);
                if (correctPlace >= 1) {
                    mapsFirstPlayer[x][y] = "X";
                    printFirstMap(mapsFirstPlayer);
                    createShip(x, y, blocks, mapsFirstPlayer);
                }
                else
                {
                    System.out.println("Нельзя ставить рядом");

                }
            }
            while (correctParant != true);
        }
        System.out.println();
        printFirstMap(mapsFirstPlayer);
        blocks = 2;
        System.out.println("Теперь 3 корабля по 2 клетки");
        for (int i = 0 ;i<3;i++)
        {
            correctPlace = -1;
            correctParant = false;
            do
            {
                System.out.println("Введите первую координату");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
                if (x > 10 || x < 0 || y > 10 || y < 0)
                {
                    System.out.println("Не выходи за рамки");
                    continue;
                }
                if (mapsFirstPlayer[x][y].equals("X"))
                {
                    System.out.println("Нельзя ставить на одинаковые места");
                    continue;
                }
                correctPlace(x, y, mapsFirstPlayer);
                if (correctPlace >= 0)
                {
                    mapsFirstPlayer[x][y] = "X";
                    printFirstMap(mapsFirstPlayer);
                    System.out.println(correctPlace);
                    createShip(x, y, blocks, mapsFirstPlayer);
                }
                else {
                    System.out.println("Нельзя ставить рядом");
                }
            }
            while (correctParant != true);
        }
        blocks = 1;
        System.out.println();
        correctPlace = 0;
        printFirstMap(mapsFirstPlayer);
        System.out.println("Теперь 4 корабля по 1 клетки");
        for (int i = 0 ;i<4;i++)
        {
            correctPlace =0;
            correctParant = false;
            do
            {
                System.out.println("Введите первую координату");
                System.out.println(correctPlace);
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
                if (x > 10 || x < 0 || y > 10 || y < 0)
                {
                    System.out.println("Не выходи за рамки");
                    continue;
                }
                if (mapsFirstPlayer[x][y].equals("X")) {
                    System.out.println("Нельзя ставить на одинаковые места");
                    continue;
                }
                correctPlace(x, y, mapsFirstPlayer);
                if (correctPlace >= 1)
                {
                    mapsFirstPlayer[x][y] = "X";
                    printFirstMap(mapsFirstPlayer);
                    createShip(x, y, blocks, mapsFirstPlayer);
                }
                else {
                    System.out.println("Нельзя ставить рядом");

                }
            }
            while (correctParant != true);
        }
        printFirstMap(mapsOnesPlayer);
        correctPlace = 0;
        blocks = 4; // Длина корабля
        System.out.println("Второй игрок расставляет корабли,Начинаем с самого большого (4клетки) ");
        do
        {
            System.out.println("Введите первую координату");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
            if (x > 10 || x < 0 || y > 10 || y < 0) {
                System.out.println("Не выходи за рамки");
                continue;
            }
            if (mapsOnesPlayer[x][y].equals("X"))
            {
                System.out.println("Нельзя ставить на одинаковые места");
                continue;
            }
            correctPlace(x,y,mapsOnesPlayer);
            if (correctPlace >= 1) {
                mapsOnesPlayer[x][y] = "X";
                printFirstMap(mapsOnesPlayer);
                createShip(x, y, blocks, mapsOnesPlayer);
            }
            else
            {
                System.out.println("Нельзя ставить рядом");
            }
        }
        while (correctParant != true);

        blocks = 3;
        System.out.println();
        printFirstMap(mapsOnesPlayer);
        System.out.println("Теперь 2 корабля по 3 клетки");
        for (int i = 0 ;i<2;i++)
        {
            correctPlace =0;
            correctParant = false;
            do
            {
                System.out.println("Введите первую координату");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
                if (x > 10 || x < 0 || y > 10 || y < 0)
                {
                    System.out.println("Не выходи за рамки");
                    continue;
                }
                if (mapsOnesPlayer[x][y].equals("X"))
                {
                    System.out.println("Нельзя ставить на одинаковые места");
                    continue;
                }
                correctPlace(x, y, mapsOnesPlayer);
                if (correctPlace >= 1)
                {
                    mapsOnesPlayer[x][y] = "X";
                    printFirstMap(mapsOnesPlayer);
                    createShip(x, y, blocks, mapsOnesPlayer);
                }
                else
                {
                    System.out.println("Нельзя ставить рядом");
                }
            }
            while (correctParant != true);
        }
        System.out.println();
        printFirstMap(mapsOnesPlayer);
        blocks = 2;
        System.out.println("Теперь 3 корабля по 2 клетки");
        for (int i = 0 ;i<3;i++)
        {
            correctPlace = -1;
            correctParant = false;
            do
            {
                System.out.println("Введите первую координату");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
                if (x > 10 || x < 0 || y > 10 || y < 0)
                {
                    System.out.println("Не выходи за рамки");
                    continue;
                }
                if (mapsOnesPlayer[x][y].equals("X"))
                {
                    System.out.println("Нельзя ставить на одинаковые места");
                    continue;
                }
                correctPlace(x, y, mapsOnesPlayer);
                if (correctPlace >= 0)
                {
                    mapsOnesPlayer[x][y] = "X";
                    printFirstMap(mapsOnesPlayer);
                    createShip(x, y, blocks, mapsOnesPlayer);
                }
                else
                {
                    System.out.println("Нельзя ставить рядом");
                }
            }
            while (correctParant != true);
        }
        blocks = 1;
        System.out.println();
        correctPlace = 0;
        printFirstMap(mapsOnesPlayer);
        System.out.println("Теперь 4 корабля по 1 клетки");
        for (int i = 0 ;i<4;i++)
        {
            correctPlace =0;
            correctParant = false;
            do
            {
                System.out.println("Введите первую координату");
                System.out.println(correctPlace);
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
                if (x > 10 || x < 0 || y > 10 || y < 0)
                {
                    System.out.println("Не выходи за рамки");
                    continue;
                }
                if (mapsOnesPlayer[x][y].equals("X"))
                {
                    System.out.println("Нельзя ставить на одинаковые места");
                    continue;
                }
                correctPlace(x, y,mapsOnesPlayer);
                if (correctPlace >= 1)
                {
                    mapsOnesPlayer[x][y] = "X";
                    printFirstMap(mapsOnesPlayer);
                    createShip(x, y, blocks, mapsOnesPlayer);
                }
                else
                {
                    System.out.println("Нельзя ставить рядом");
                }
            }
            while (correctParant != true);
        }
        printFirstMap(checkMapsFirstPlayer);

        int step = 0;
        String player;
        while (true)
        {
            if (step % 2 == 0)
            {
                player = "Первый";
                System.out.println("Ходит первый игрок");
            } else
            {
                player = "Второй";
                System.out.println("Ходит второй игрок");
            }
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
            if (x > 10 || x < 0 || y > 10 || y < 0)
            {
                System.out.println("Не выходи за рамки");
                continue;
            }

            if (player.equals("Первый") && mapsOnesPlayer[x][y].equals("X"))
            {
                if (mapsOnesPlayer[x][y].equals("O") ) {
                    System.out.println("Нельзя ставить на одинаковые места");
                    continue;
                }
                checkMapsFirstPlayer[x][y] = "X";
                mapsOnesPlayer[x][y] = "O";
                chipOnesPlayer--;
                checkForWin(chipOnesPlayer);
                printFirstMap(checkMapsFirstPlayer);
                System.out.println("Попал, продолжаем ход");
                if (isWin)
                {
                    System.out.println("Победил первый игрок");
                    printFirstMap(checkMapsFirstPlayer);
                    break;
                }
                continue;
            }
            if (player.equals("Первый") && !mapsOnesPlayer[x][y].equals("X"))
            {
                if (mapsOnesPlayer[x][y].equals("O"))
                {
                    System.out.println("Нельзя ставить на одинаковые места");
                    continue;
                }
                checkMapsFirstPlayer[x][y] = "O";
                mapsOnesPlayer[x][y] = "O";
                step++;
                printFirstMap(checkMapsFirstPlayer);
                System.out.println("Не попал");
            }

            if (player.equals("Второй") && mapsFirstPlayer[x][y].equals("X"))
            {
                if (mapsFirstPlayer[x][y].equals("O"))
                {
                    System.out.println("Нельзя ставить на одинаковые места");
                    continue;
                }
                checkMapsOnesPlayer[x][y] = "X";
                mapsFirstPlayer[x][y] = "O";
                chipFirstPlayer--;
                checkForWin(chipFirstPlayer);
                printFirstMap(checkMapsOnesPlayer);
                System.out.println("Попал, продолжаем ход");
                if (isWin)
                {
                    System.out.println("Победил второй игрок");
                    printFirstMap(checkMapsOnesPlayer);
                    break;
                }
                continue;
            }
            if (player.equals("Второй") && !mapsFirstPlayer[x][y].equals("X"))
            {
                if (mapsFirstPlayer[x][y].equals("O"))
                {
                    System.out.println("Нельзя ставить на одинаковые места");
                    continue;
                }
                checkMapsOnesPlayer[x][y] = "O";
                mapsFirstPlayer[x][y] = "O";
                step++;
                printFirstMap(checkMapsOnesPlayer);
                System.out.println("Не попал");
            }
        }
    }

    public static void readyMap(String[][] mapsPlayer) // функция заполняющая массив точками
    {
        for (int i = 0; i < mapsPlayer.length; i++)
        {
            mapsPlayer[i][0] = ".";
            for (int j = 0; j < mapsPlayer[i].length; j++)
                mapsPlayer[i][j] = ".";
        }
    }

    public static void printFirstMap(String[][] mapsPlayer)// функция печати массива
    {
        for (int i = 0; i < mapsPlayer.length; i++)
        {
            for (int j = 0; j < mapsPlayer[i].length; j++)
            {
                System.out.print(mapsPlayer[i][j] + "|");
                if (j > 8)
                    System.out.println();
            }
        }
    }

    public static void checkForWin(int chip) // функция проверки победы
    {
        if (chip == 0) {
            isWin = true;
        }
    }

    public static void createShip(int x1, int y1, int blocks, String[][] mapsPlayer) // функция установки кораблей
    {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        int number;
        boolean correct = false;
        if (blocks >= 2)
        {
            System.out.println("Выберете направление: " + blocks);
            if (x1 >= blocks - 1)
            {
                number = 1;
                System.out.println(number + " Наверх ");
            }
            if (x1 <= 10 - blocks)
            {
                number = 2;
                System.out.println(number + " Вниз ");
            }
            if (y1 >= blocks - 1 )
            {
                number = 3;
                System.out.println(number + " Налево ");
            }
            if (y1 <= 10 - blocks)
            {
                number = 4;
                System.out.println(number + " Направо ");
            }
            while (correct != true)
            {
                try {
                    choice = scanner.nextInt();
                    switch (choice)
                    {
                        case 1:  // up
                                System.out.println(correctPlace);
                            for (int i = 1; i < blocks; i++)
                                correctPlace(x1 - i, y1, mapsPlayer);
                            if (correctPlace >= blocks - 1)
                            {
                                System.out.println(correctPlace);
                                for (int j = 0; j < blocks; j++)
                                    mapsPlayer[x1 - j][y1] = "X";
                                correct = true;
                                break;
                            }
                            else
                            {
                                System.out.println("Сюда нельзя");
                                System.out.println(correctPlace);
                                mapsPlayer[x1][y1] = ".";
                                break;
                            }
                        case 2: // down
                            for (int i = 1; i < blocks; i++)
                                correctPlace(x1 + i, y1, mapsPlayer);
                            if (correctPlace >= blocks - 1)
                            {
                                for (int j = 0; j < blocks; j++)
                                    mapsPlayer[x1 + j][y1] = "X";
                                correct = true;
                                break;
                            }
                            else
                            {
                                System.out.println("Сюда нельзя");
                                System.out.println(correctPlace);
                                mapsPlayer[x1][y1] = ".";
                                break;
                            }
                        case 3:  // left
                            for (int i = 1; i < blocks; i++)
                                correctPlace(x1, y1 - i, mapsPlayer);
                            if (correctPlace >= blocks - 1)
                            {
                                for (int j = 0; j < blocks; j++)
                                    mapsPlayer[x1][y1 - j] = "X";
                                correct = true;
                                break;
                            }
                            else
                            {
                                System.out.println("Сюда нельзя");
                                System.out.println(correctPlace);
                                mapsPlayer[x1][y1] = ".";
                                break;
                            }
                        case 4:  //right
                            for (int i = 1; i < blocks; i++)
                                correctPlace(x1, y1 + i, mapsPlayer);
                            if (correctPlace >= blocks - 1)
                            {
                                for (int j = 0; j < blocks; j++)
                                    mapsPlayer[x1][y1 + j] = "X";
                                correct = true;
                                break;
                            }
                            else
                            {
                                System.out.println("Сюда нельзя");
                                System.out.println(correctPlace);
                                mapsPlayer[x1][y1] = ".";
                                break;
                            }
                        default:
                            System.out.println("Введите корректное число");
                            break;
                    }
                }
                catch (Exception e)
                {
                    System.out.println("Введите корректное число");
                }
            }
        }
        printFirstMap(mapsPlayer);
        System.out.println("Подтверждаете выбор?\n" +
                "1: Подтверждаю \n" +
                "2: Переставить");
        int confirm = 3;
        while (confirm != 2 && confirm != 1)
        {
            confirm = scanner.nextInt();
            if (confirm == 1)
                correctParant = true;
            else if (confirm == 2)
            {
                switch (choice)
                {
                    case 1:  // up
                        for (int i = 0; i < blocks; i++)
                            mapsPlayer[x1 - i][y1] = ".";
                        correctPlace = 0;
                        if (blocks==2)
                        {
                            correctPlace = -1;
                        }
                        break;
                    case 2: // down
                        for (int i = 0; i < blocks; i++)
                            mapsPlayer[x1 + i][y1] = ".";
                        correctPlace = 0;
                        if (blocks==2)
                        {
                            correctPlace = -1;
                        }
                        break;
                    case 3:  // left
                        for (int i = 0; i < blocks; i++)
                            mapsPlayer[x1][y1 - i] = ".";
                        correctPlace = 0;
                        if (blocks==2)
                        {
                            correctPlace = -1;
                        }
                        break;
                    case 4:  //right
                        for (int i = 0; i < blocks; i++)
                            mapsPlayer[x1][y1 + i] = ".";
                        correctPlace = 0;
                        if (blocks==2)
                        {
                            correctPlace = -1;
                        }
                        break;
                }
            }
            else
                System.out.println("Выберите корректное число");
        }
    }
    public static void correctPlace (int x1, int y1, String[][] mapsPlayer) // функция проверки на правильность постановки кораблей
    {
        try
        {
            if (x1 == 0 && y1 == 0)
            {
                if (mapsPlayer[x1 + 1][y1].equals(".") &&
                        mapsPlayer[x1][y1 + 1].equals(".") &&
                        mapsPlayer[x1 + 1][y1 + 1].equals(".")&&
                        mapsPlayer[x1][y1].equals("."))
                {
                    correctPlace++;
                    System.out.println("х = 0 и у = 0");
                }
            }
            if (x1 == 9 && y1 == 9)
            {
                if (mapsPlayer[x1 - 1][y1].equals(".") &&
                        mapsPlayer[x1 - 1][y1 - 1].equals(".") &&
                        mapsPlayer[x1][y1 - 1].equals("."))
                {
                    correctPlace++;
                    System.out.println("х = 9 и у  = 9");
                }
            }
            if (x1 == 9 && y1 == 0)
            {
                if (mapsPlayer[x1-1][y1].equals(".") &&
                        mapsPlayer[x1 - 1][y1 + 1].equals(".") &&
                        mapsPlayer[x1][y1 + 1].equals("."))
                {
                    correctPlace++;
                    System.out.println("х = 9 и у  = 0");
                }
            }
            if (x1 == 0 && y1 == 9)
            {
                if (mapsPlayer[x1][y1 - 1].equals(".") &&
                        mapsPlayer[x1 + 1][y1 - 1].equals(".") &&
                        mapsPlayer[x1+1][y1].equals("."))
                {
                    correctPlace++;
                    System.out.println("х = 0 и у  = 9");
                }
            }
            if (x1==9 && y1!=0)
            {
                if(mapsPlayer[x1][y1-1].equals(".") &&
                        mapsPlayer[x1 - 1][y1 - 1].equals(".") &&
                        mapsPlayer[x1-1][y1].equals(".") &&
                        mapsPlayer[x1 - 1][y1 + 1].equals(".") &&
                        mapsPlayer[x1][y1+1].equals("."))
                {
                    correctPlace++;
                    System.out.println("х = 9 и у не = 0");
                }
            }
            if (x1 == 0 && y1 != 0)
            {
                if (mapsPlayer[x1 + 1][y1].equals(".") &&
                        mapsPlayer[x1][y1 + 1].equals(".") &&
                        mapsPlayer[x1][y1 - 1].equals(".") &&
                        mapsPlayer[x1 + 1][y1 - 1].equals(".") &&
                        mapsPlayer[x1 + 1][y1 + 1].equals("."))
                {
                    correctPlace++;
                    System.out.println("х = 0 и у не = 0");
                }
            }
            if (x1 != 0 && y1 == 0)
            {
                if (mapsPlayer[x1 - 1][y1].equals(".") &&
                        mapsPlayer[x1 - 1][y1 + 1].equals(".") &&
                        mapsPlayer[x1][y1 + 1].equals(".") &&
                        mapsPlayer[x1 + 1][y1 + 1].equals(".") &&
                        mapsPlayer[x1 + 1][y1].equals("."))
                {
                    correctPlace++;
                    System.out.println("х не = 0 и у  = 0");
                }
            }
            if (x1 != 0 && y1 == 9)
            {
                if (mapsPlayer[x1 - 1][y1].equals(".") &&
                        mapsPlayer[x1 - 1][y1 - 1].equals(".") &&
                        mapsPlayer[x1][y1 - 1].equals(".") &&
                        mapsPlayer[x1 + 1][y1 - 1].equals(".") &&
                        mapsPlayer[x1 + 1][y1].equals("."))
                {
                    correctPlace++;
                    System.out.println("х не  = 0 и у  = 9");
                }
            }
            if (x1 != 0 && y1 != 0)
            {
                if (
                        mapsPlayer[x1 - 1][y1 - 1].equals(".") &&
                                mapsPlayer[x1 - 1][y1].equals(".") &&
                                mapsPlayer[x1 - 1][y1 + 1].equals(".") &&
                                mapsPlayer[x1][y1 + 1].equals(".") &&
                                mapsPlayer[x1][y1 - 1].equals(".") &&
                                mapsPlayer[x1 + 1][y1 - 1].equals(".") &&
                                mapsPlayer[x1 + 1][y1].equals(".") &&
                                mapsPlayer[x1 + 1][y1 + 1].equals("."))
                {
                    correctPlace++;
                    System.out.println("х не  = 0 и у не = 0");
                }
            }
        }
        catch (Exception e)
        {
        }
    }
}








