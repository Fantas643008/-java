import java.util.Scanner;

public class seaBattle {
    public static int deck = 4, x = 0, y = 0, inputType = 0, direction;
    public static String[][] tempMap = new String[10][10]; /// Временная карта
    public static String[][] tempMap2 = new String[10][10]; /// Временная карта
    public static String[][] FirstMap = new String[10][10]; /// Карта первого игрока
    public static String[][] SecondMap = new String[10][10]; /// Карта второго игрока

    public static void main(String[] args) {
        boolean[] wrong = new boolean[4];
        int[] found = new int[5];
        for (int player = 1; player <= 2; player ++) { // Заполняем карты игроков кораблями, с новой итерацией заполняется карта следующего игрока
            for (int i = 0; i < 10; i++)
                for (int j = 0; j < 10; j++)
                    tempMap[i][j] = "."; /// Заполняем массив точками
            PrintSeaMap(); /// Рисуем карту для первого игрока
            System.out.println("""
                Перед вами карта, на которой необходимо расположить:
                1 - 4-палубный корабль,
                2 - 3-палубных кораблей,
                3 - 2-палубных кораблей,
                4 - 1-палубных корабля.
               """);
        for (int i = 0; i < deck; deck--) {
            do {
                System.out.printf("Введите начальные координаты %d-палубного корабля: ", deck); /// Выбираем точку
                inputType = 2;
                int[] arr = readInput();
                x = arr[0];
                y = arr[0];
                System.out.println("Точку выбрали");
                found = check(0);
                if (found[direction] == 0)  /// Если в точке и вокруг пусто, то проверяем направление
                    System.out.println("в точке и вокруг пусто");
                //wrong = check(direction);
                for (int i1 = 1; i1 < 5; i1++) {
                    found = check(i1);
                    if (found[direction] == 1) continue;/// Если хоть одно напр. свободно - идём дальше
                    System.out.println(found[direction]);
                    System.out.println(" хоть одно напр. свободно - идём дальше");
                }
            } while ((x < 0 && x > 9) && (y < 0 && y > 9)); /// Цикл проверяет на выход за пределы карты
            System.out.println("\nВыберите направление: ");
            for (int direction = 0; direction < 4; direction++) {/// Здесь 0 - наверх, далее почасовой до 3х
                System.out.println(found[direction]);
                switch (direction) {
                    case 0:
                        System.out.print("Наверх: ");
                        if (found[direction] == 1) System.out.println("нельзя");
                        else System.out.println("1");
                        break;
                    case 1:
                        System.out.print("Направо: ");
                        if (found[direction] == 1) System.out.println("нельзя");
                        else System.out.println("2");
                        break;
                    case 2:
                        System.out.print("Вниз: ");
                        if (found[direction] == 1) System.out.println("нельзя");
                        else System.out.println("3");
                        break;
                    case 3:
                        System.out.print("Налево: ");
                        if (found[direction] == 1) System.out.println("нельзя");
                        else System.out.println("4");
                        break;
                }
            }
                Scanner scanner = new Scanner(System.in);
                int d = scanner.nextInt();
                do {
                    switch (d) { /// Записываем в выбранном направлении
                        case 1: /// Наверх
                            for (i = 1; i < 4; i++) tempMap[x][y - i] = String.valueOf(deck);
                            break;
                        case 2: /// Направо
                            for (i = 1; i < 4; i++) tempMap[x + i][y] = String.valueOf(deck);
                            break;
                        case 3: /// Вниз
                            for (i = 1; i < 4; i++) tempMap[x][y + i] = String.valueOf(deck);
                            break;
                        case 4: /// Налево
                            for (i = 1; i < 4; i++) tempMap[x - i][y] = String.valueOf(deck);
                            break;
                    }
                } while ((d > 0) && (d < 5));
        }
        if (player == 1) { /// Корабли расставили, записываем из врем. карты на карту первого игрока
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++)
                    FirstMap[i][j] = tempMap[i][j];
            }
        }
        else { /// Корабли расставили, записываем из врем. карты на карту второго игрока
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++)
                    SecondMap[i][j] = tempMap[i][j];
            }
        }
        }
    }
    /// Метод отвечающий за выбор направления
    /// 1 - Наверх, 2 - Направо, 3 - Вниз, 4 - Налево
    public static boolean[] checkDirection() {
        String[][] arr = new String[10][10];
        arr[x][y] = tempMap[x][y];
        String deck2 = String.valueOf(deck);
        boolean found = false;
        boolean[] wrong = new boolean[4];
        for (int direction = 1; direction < 5; direction++) {   /// Перебор направлений
        try {
            switch (direction) {
                case 1: /// Наверх
                    for (int i = -1; i <= 1; i++) {
                            if (arr[x - i][y ].equals(deck2)) {
                                wrong[direction] = true;
                                break;

                        }
                    }
                case 2: /// Направо
                    for (int i = 1; i < deck; i++) {
                            if (arr[x ][y + i].equals(deck2)) {
                                wrong[direction] = true;
                                break;
                        }
                    }
                case 3: /// Вниз
                    for (int i = 1; i <= 1; i++) {
                            if (arr[x + i][y ].equals(deck2)) {
                                wrong[direction] = true;
                                break;
                        }
                    }
                case 4: /// Налево
                    for (int i = -1; i < deck; i++)
                            if (arr[x ][y - i].equals(deck2)) {
                                wrong[direction] = true;
                                break;
                        }
                    }
            }
         catch (Exception e) {
            System.out.println("Try-Catch");
        }
        }
        return wrong;
    }
    /// Метод на проверку свободного места и места вокруг него
    public static boolean checkPlace() {
        String[][] arr = tempMap;//new String[10][10];
        String deck2;
        boolean found = false;
        arr[x][y] = tempMap[x][y];
        deck2 = String.valueOf(deck);

        for (int i = -1; i <= 1; i++) {
            try {
                int x1 = x + i;
                if (x1 < 0) x1 = 0;
                if (x1 > 9) x1 = 9;
                for (int j = -1; j <= 1; j++) {
                    int y1 = y + j;
                    if (y1 < 0) y1 = 0;
                    if (y1 > 9) y1 = 9;
                    if (arr[x1][y1].equals(deck2)) {
                        found = true;
                        System.out.println("Нельзя ставить корабль в тоже место или рядом!");
                        break;
                    }
                    if (found) break;
                }
            }catch (Exception e){
                System.out.println("Все из за меня");
            }
        }
        return found;
    }
    /// Тестовый метод на общую проверку, в зависимости от полученных данных
    public static int[] check(int direct) {
        String[][] arr = tempMap;
        String deck2;
        int[] found = new int[5];
        int /*found = 0,*/ a1 = 0, b1 = 0, a2 = 0, b2 = 0;
        boolean increase1 = false, increase2 = false;
        arr[x][y] = tempMap[x][y]; //??? А надо ли оно?!
        deck2 = String.valueOf(deck);
        switch (direct) {
            case 0: /// Если 0 - проверка места
                a1 = -1;
                b1 = 1;
                a2 = -1;
                b2 = 1;
                increase1 = true;
                increase2 = true;
                break;
            case 1:  /// Наверх
                a1 = -1;
                b1 = 1;
                a2 = -1;
                b2 = (deck - 1) * -1;
                increase1 = true;
                increase2 = false;
                break;
            case 2: /// Направо
                a1 = 1;
                b1 = deck - 1;
                a2 = -1;
                b2 = 1;
                increase1 = true;
                increase2 = true;
                break;
            case 3: /// Вниз
                a1 = -1;
                b1 = 1;
                a2 = 1;
                b2 = deck - 1;
                increase1 = true;
                increase2 = true;
                break;
            case 4: /// Налево
                a1 = -1;
                b1 = (deck - 1) * -1;
                a2 = -1;
                b2 = 1;
                increase1 = false;
                increase2 = true;
                break;
        }
        boolean[] border = new boolean[4];
        while (a1 <= b1) {
            int x1 = x + a1;
            if (x1 < 0) {
                x1 = 0;
                border[3] = true;

            }
            if (x1 > 9) {
                x1 = 9;
                border[1] = true;

            }
        while (a2 <= b2) {
            int y1 = y + a2;

            if (y1 < 0) {
                y1 = 0;
                border[0] = true;
            }
            if (y1 > 9) {
                y1 = 9;
                border[2] = true;
            }
            if (direct == 0) { /// 0 - место, от 1 до 4 - направления
                if (arr[x1][y1].equals(deck2)) {
                    found[direct] = 1;
                    System.out.printf("%d-Direction, %d-Iteration of Cycle (by x) %d-Iteration of Cycle (by y) Не подходящее место для %d - палубного корабля!\n", direct, deck);
                    break;
                }
                //if (found) break;
            }
            try {
                if ((arr[x1][y1].equals(deck2)) || (border[direct - 1])) {
                    found[direct] = 1;
                    System.out.printf("%d Не подходящее направление #2 для %d корабля!", direct, deck);
                    break;
                    //if (found) break;
                }
            }catch (Exception e){}
            if (increase2) a2++;
            else a2--;
        }
        if (increase1) a1++;
        else a1--;
    }
        return found;
    }

    /// Печать карты
    public static void PrintSeaMap() {
        String[][] arr = new String[10][10];
        arr = tempMap;
        System.out.println();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(arr[i][j]);
                if (j < 9) System.out.print("|");
            }
            System.out.println();
        }
    }
    /// Ввод данных
    public static int[] readInput () {
        int inType = inputType;
        //System.out.println("inputType: " + inputType);
        String[] inputValues = new String[inType];
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        scanner.close();
        inputValues = inputLine.split(" ");
//        System.out.println("EEEE " + inputValues[0] + inputValues[1]);
        int[] result = new int[inType];
        for (int i = 0; i < inType; i++) {
            result[i] = Integer.parseInt(inputValues[i]) - 1;
//            System.out.println("RRRR " + result[i]);
        }
        return result;
    }

    public static boolean[] formula(int direct) { /// По идее мы получаем значение, по которому мы определяем то, что мы будем проверять
        String[][] arr = tempMap;//new String[10][10];
        boolean[] found = new boolean[2]; /// Здесь мы объявляем массив чтобы вернуть значения? или нет?)
        String deck2;
        int a1 = 0, b1 = 0, a2 = 0, b2 = 0;
        switch (direct) {
            case 0: /// Если 0 - проверка места
                a1 = -1;
                b1 = 1;
                a2 = a1;
                b2 = b1;
                break;
            case 1:  /// Наверх
                a1 = -1;
                b1 = 1;
                a2 = -1;
                b2 = (deck -1) * -1;
                break;
            case 2: /// Направо
                a1 = 1;
                b1 = deck -1;
                a2 = -1;
                b2 = 1;
                break;
            case 3: /// Вниз
                a1 = -1;
                b1 = 1;
                a2 = 1;
                b2 = deck -1;
                break;
            case 4: /// Налево
                a1 = -1;
                b1 = (deck -1) * -1;
                a2 = -1;
                b2 = 1;
                break;
        }
        deck2 = String.valueOf(deck);
        for (int i = a1; i <= b1; i++) {
            int x1 = x + i;
            if (x1 < 0) x1 = 0;
            if (x1 > 9) x1 = 9;
            for (int j = a2; j <= b2; j++) {
                int y1 = y + j;
                if (y1 < 0) y1 = 0;
                if (y1 > 9) y1 = 9;
//                if (arr[x1][y1].equals(deck2)) {
//                    found = true;
//                    System.out.printf("Не подходящее место для %d корабля!", deck);
//                    break;
//                }
//                if (found) break;
            }
        }
        //return found;
//        String[][] arr = new String[10][10];
//        arr[x][y] = tempMap[x][y];
//        String deck2 = String.valueOf(deck);
//        boolean found = false;
//        boolean[] wrong = new boolean[4];
//        for (int direction = 1; direction < 5; direction++) {   /// Перебор направлений
//            switch (direction) {
//                case 1: /// Наверх
//                    for (int i = -1; i <= 1; i++) {
//                        for (int j = -1; j <= -(deck-1); j++) {
//                            if (arr[x + i][y + j].equals(deck2)) {
//                                wrong[direction] = true;
//                                break;
//                            }
//                        }
//                    }
//                case 2: /// Направо
//                    for (int i = 1; i <= deck-1; i++) {
//                        for (int j = -1; j <= 1; j++) {
//                            if (arr[x + i][y + j].equals(deck2)) {
//                                wrong[direction] = true;
//                                break;
//                            }
//                        }
//                    }
//                case 3: /// Вниз
//                    for (int i = -1; i <= 1; i++) {
//                        for (int j = 1; j <= deck-1; j++) {
//                            if (arr[x + i][y + j].equals(deck2)) {
//                                wrong[direction] = true;
//                                break;
//                            }
//                        }
//                    }
//                case 4: /// Налево
//                    for (int i = -1; i <= -(deck-1); i++) {
//                        for (int j = -1; j <= 1; j++) {
//                            if (arr[x + i][y + j].equals(deck2)) {
//                                wrong[direction] = true;
//                                break;
//                            }
//                        }
//                    }
//            }
//        }
        return found;

    }

    }