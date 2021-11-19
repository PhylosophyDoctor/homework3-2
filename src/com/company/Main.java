package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        System.out.println("БЫЛО");
        Random vitality = new Random();
        String str = new String();
        byte[][] field = new byte[10][10];
        for (int i = 0; i < 10; i++) {
            str = "";
            for (int j = 0; j < 10; j++) {
                field[i][j] = (byte) vitality.nextInt(2);
                str = str + " " + field[i][j];
            }
            System.out.println(str);
        }
        Random steps = new Random();
        byte step = (byte) steps.nextInt(20);
        int i = 0;
        do {
            for (int j = 0; j < 10 && (step % 10 > 0); j++) {
                if (field[i][j] == 0) { //условный оператор для поиска и замены мертвых ячеек,
                    // если условие удовлетворяется,то запускается алгоритм поиска живых соседей,
                    // если нет, то ячейка жива и ставится вопрос о её дальнейше жизнеспособности
                    int k = 0; // счетчик живых соседей
                    int savei = i; //сохраняем i для последующих действий
                    int savej = j; // и j

                    if (i - 1 < 0) //проверяем крайние члены таблицы
                    {
                        i = 10;
                        if (field[i - 1][j] == 1) {
                            k = k + 1;
                        } else; //прибавляем живого соседа выше
                    } else  if (field[i - 1][j] == 1) {
                        k = k + 1;
                    }

                    i = savei;
                    if (j + 1 > 9) //проверяем крайние члены таблицы
                    {
                        j = 0;
                        if (field[i][j + 1] == 1) {
                            k = k + 1;
                        } else;
                    } else if (field[i][j + 1] == 1) {
                        k = k + 1;
                    }
                    j = savej;
                    if (j - 1 < 0) { //проверяем крайние члены таблицы
                        j = 10;
                        if (field[i][j - 1] == 1) {
                            k = k + 1;
                        } else ;
                    }
                        else if (field[i][j - 1] == 1) {
                            k = k + 1;
                        }


                    j = savej;
                    if (i + 1 > 9) {//проверяем крайние члены таблицы
                        i = 0;
                        if (field[i + 1][j] == 1) {
                            k = k + 1;
                        } else ;
                    }
                        else if (field[i + 1][j] == 1) {
                            k = k + 1;
                        }


                    i = savei;
                    if (k >= 3) {
                        field[i][j] = 1;
                    }
                    if ((i == step / 10) && (j == step % 10)) {
                        break;
                    }

                } //прошли по i-той строке
                else {
                    int k = 0; // счетчик живых соседей
                    int savei = i; //сохраняем i для последующих действий
                    int savej = j; // и j

                    if (i - 1 < 0) //проверяем крайние члены таблицы
                    {
                        i = 10;
                        if (field[i - 1][j] == 1) {
                            k = k + 1;
                        } else; //прибавляем живого соседа выше
                    } else  if (field[i - 1][j] == 1) {
                        k = k + 1;
                    }

                    i = savei;
                    if (j + 1 > 9) //проверяем крайние члены таблицы
                    {
                        j = 0;
                        if (field[i][j + 1] == 1) {
                            k = k + 1;
                        } else;
                    } else if (field[i][j + 1] == 1) {
                        k = k + 1;
                    }
                    j = savej;
                    if (j - 1 < 0) { //проверяем крайние члены таблицы
                        j = 10;
                        if (field[i][j - 1] == 1) {
                            k = k + 1;
                        } else ;
                    }
                    else if (field[i][j - 1] == 1) {
                        k = k + 1;
                    }


                    j = savej;
                    if (i + 1 > 9) {//проверяем крайние члены таблицы
                        i = 0;
                        if (field[i + 1][j] == 1) {
                            k = k + 1;
                        } else ;
                    }
                    else if (field[i + 1][j] == 1) {
                        k = k + 1;
                    }


                    i = savei;
                    if (k<2) {
                        field[i][j] = 0;
                    }
                    if ((i == step / 10) && (j == step % 10)) {
                        break;
                    }

                }


            }

            i++;
        }
        while (i <= step / 10);
        System.out.println("\n" + "СТАЛО СПУСТЯ " + step + " ХОДA(ОВ)" + "\n");
        output(field);




    }
    public static void output ( byte[][] array)
    {
        String str = "";
        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {
                str = str + " " + array[i][j];
            }
            System.out.println(str);
            str = "";
        }
    }
}
