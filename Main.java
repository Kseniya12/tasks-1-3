package com.company;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import static java.lang.Math.abs;
public class Main {
    public static void main(String[] args) {
//2 таски
        System.out.println(repeat("mice", 5));
        System.out.println(differenceMaxMin(new int[]{10, 4, 1, 4, -10, -50, 32, 21}));
        System.out.println(isAvgWhole(new int[]{1, 3}));
        System.out.println(Arrays.toString(cumulativeSum(new int[]{3, 3, -2, 408, 3, 3})));
        System.out.println(getDecimalPlaces("43.20"));
        System.out.println(Fibonacci(7));
        System.out.println(isValid("59001"));
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(boxSeq(3));
//3 таски
        System.out.println(solutions(1, 0, -1));
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(checkPerfect(12));
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(same(new int[]{1, 3, 4, 4, 4}, new int[]{2, 5, 7}));
        System.out.println(isKaprekar(297));
        System.out.println(longestZero("01100001011000"));
        System.out.println(nextPrime(11));
        System.out.println(rightTriangle(3, 4, 5));
    }
    /*2 ТАСКИ*/
    /**
     * Создайте функцию, которая повторяет каждый символ в строке n раз.
     **/
    public static String repeat(String str, int n){
        String result = "";
        for(int i = 0; i < str.length(); i++){
            for(int j = 0; j < n; j++){
                result += str.charAt(i);
            }
        }
        return result;
    }

    /**
     *Создайте функцию, которая принимает массив и возвращает
     * разницу между самыми большими и самыми маленькими числами.
     * **/
    public static int differenceMaxMin(int[] array){
        int max = array[0];
        int min = array[0];
        for(int i = 0; i < array.length; i++){
            if (array[i] > max){
                max = array[i];
            }
            if (array[i] < min){
                min = array[i];
            }
        }
        return abs(max - min);
    }
/**
 * Создайте функцию, которая принимает массив в качестве
 * аргумента и возвращает true или false в зависимости от того,
 * является ли среднее значение всех элементов массива целым числом или нет.
 * **/
    public static boolean isAvgWhole(int[] array){
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return sum % array.length == 0;
    }
/**
 * Создайте метод, который берет массив целых чисел и
 * возвращает массив, в котором каждое целое число является
 * суммой самого себя + всех предыдущих чисел в массиве.
 * **/
    public static int[] cumulativeSum(int[] array){
        int[] result = new int[array.length];
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
            result[i] = sum;
        }
        return result;
    }
/**
 * Создайте функцию, которая возвращает число десятичных знаков, которое
 * имеет число (заданное в виде строки). Любые нули после
 * десятичной точки отсчитываются в сторону количества десятичных знаков.
 * **/
    public static int getDecimalPlaces(String number){
        int dot_ind = number.indexOf(".");
        if (dot_ind == -1) return 0;
        number = number.substring(dot_ind);
        return number.length() - 1;
    }
/**
 * Создайте функцию, которая при заданном числе
 * возвращает соответствующее число Фибоначчи.
 * **/
    public static int Fibonacci(int n){
        n++;
        int[] array = new int[n];
        array[0] = 1;
        array[1] = 1;
        for(int i = 2; i < array.length; i++){
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n-1];
    }
/**
 * Почтовые индексы состоят из 5 последовательных цифр.
 * Учитывая строку, напишите функцию, чтобы определить,
 * является ли вход действительным почтовым индексом.
 * Действительный почтовый индекс выглядит следующим образом:
 * – Должно содержать только цифры (не допускается использование нецифровых цифр).
 * – Не должно содержать никаких пробелов.
 * – Длина не должна превышать 5 цифр
 * **/
    public static boolean isValid(String str){
        if(str.length() > 5){
            return false;
        }
        for(int i = 0; i < str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
/**
 * Пара строк образует странную пару, если оба из следующих условий истинны:
 * – Первая буква 1-й строки = последняя буква 2-й строки.
 * – Последняя буква 1-й строки = первая буква 2-й строки.
 * – Создайте функцию, которая возвращает true,
 * если пара строк представляет собой странную пару, и false в противном случае.
 * **/
public static boolean isStrangePair(String fst, String snd){
    if (fst.isEmpty() && snd.isEmpty()) {
        return true;
    }
    return fst.charAt(0) == snd.charAt(snd.length() - 1) && fst.charAt(fst.length() - 1) == snd.charAt(0);
}
/**
 * Создайте две функции: isPrefix(word, prefix-) и isSuffix (word, -suffix).
 * – isPrefix должен возвращать true, если он начинается с префиксного аргумента.
 * – isSuffix должен возвращать true, если он заканчивается аргументом суффикса.
 * – В противном случае верните false.
 * **/
    public static boolean isPrefix(String s, String prefix)
    {
        if(prefix.length()>s.length()) return false;
        for(int i = 0; i < prefix.length()-1; i++){
            if(prefix.charAt(i) != s.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public static boolean isSuffix(String s, String suffix)
    {
        if(suffix.length()>s.length()) return false;
        for(int i = 1; i < suffix.length(); i++){
            if(suffix.charAt(i) != s.charAt(i)){
                return false;
            }
        }
        return true;
    }
/**
 * Создайте функцию, которая принимает число (шаг) в качестве аргумента
 * и возвращает количество полей на этом шаге последовательности.
 * **/
    public static int boxSeq(int step) {
        int odd = step / 2 + (step % 2);
        int even = step / 2;
        return odd * 3 - even;
    }
    /*3 ТАСКИ*/
    /**Квадратное уравнение ax2 + bx + c = 0 имеет либо 0, либо 1,
     * либо 2 различных решения для действительных значений x. учитывая a, b и c,
     * вы должны вернуть число решений в уравнение. **/
    public static int solutions(int a, int b, int c){
        int D = b*b-4*a*c;
        int res = 0;
        if (D==0) res = 1;
        else if(D>0) res = 2;
        else res = 0;
        return res;
    }
/**	Напишите функцию, которая возвращает позицию второго
 * вхождения " zip " в строку, или -1, если оно не происходит по крайней мере дважды.
 * Ваш код должен быть достаточно общим,
 * чтобы передать все возможные случаи, когда "zip" может произойти в строке. **/
public static int findZip(String str)
{
    boolean zip = false;
    for (int i = 0; i < str.length() - 2; i++)
        if(str.charAt(i) == 'z' && str.charAt(i + 1) == 'i' && str.charAt(i + 2) == 'p')
        {
            if (zip) return i;
            zip =  true;
        }
    return -1;
}
/**	Создайте функцию, которая проверяет, является ли целое
 * число совершенным числом или нет. Совершенное число - это число,
 * которое можно записать как сумму его множителей, исключая само число.
 Например, 6-это идеальное число, так как 1 + 2 + 3 = 6, где 1, 2 и 3-Все
 коэффициенты 6. Точно так же 28-это совершенное число,
 так как 1 + 2 + 4 + 7 + 14 = 28.
 **/
        public static boolean checkPerfect(int num)
        {
            int sum = 0;
            for (int i = 1; i < num; i++)
                if (num % i == 0) sum += i;
            return sum == num;
        }
/** Создайте функцию, которая принимает строку и возвращает новую
 *  строку с заменой ее первого и последнего символов, за исключением
 *  трех условий:
 – Если длина строки меньше двух, верните "несовместимо".".
 – Если первый и последний символы совпадают, верните "два-это пара.".
 **/
    public static String flipEndChars(String str){
        String new_str = "";
        if(str.length()<2) new_str = "Несовместимо.";
        else if(str.charAt(0) == str.charAt(str.length()-1)) new_str = "Два-это пара.";
        else new_str = str.charAt(str.length() - 1) + str.substring (1, str.length() - 1) + str.charAt(0);;
        return new_str;
    }
/** Создайте функцию, которая определяет, является ли строка
 * допустимым шестнадцатеричным кодом.
 Шестнадцатеричный код должен начинаться с фунтового ключа # и иметь
 длину ровно 6 символов. Каждый символ должен быть цифрой от 0-9 или
 буквенным символом от A-F. все буквенные символы могут быть прописными или строчными.
 **/
    public static boolean isValidHexCode(String str){
        str = str.toLowerCase();
        String check_str = "0123456789abcdfe";
        if(str.charAt(0) != '#') return false;
        if(str.length()!=7) return false;
        for(int i=1; i<str.length(); i++){
            if(check_str.indexOf(str.charAt(i)) == -1) return false;
        }
        return true;
    }
/**	Напишите функцию, которая возвращает true,
 * если два массива имеют одинаковое количество уникальных элементов, и false
 * в противном случае.В arr1 число 4 появляется трижды, что означает, что оно
 * содержит три уникальных элемента: [1, 3, 4]. Поскольку arr1 и arr2 содержат
 * одинаковое количество уникальных элементов, этот пример вернет значение true.
 **/
    public static boolean same(int[] arr1, int[] arr2){
        return countUnique(arr1) == countUnique(arr2);
    }
    public static int countUnique(int[] mas)
    {
        int kolvo = 0;
        for (int i = 0; i < mas.length; i++) {
            int kol_tmp = 0;
            for(int j = 0; j < mas.length; j++)
                if(mas[i] == mas[j]) kol_tmp++;
            if (kol_tmp == 0) kolvo++;
        }
        return kolvo;
    }
/**	Число Капрекара-это положительное целое число, которое
 * после возведения в квадрат и разбиения на две лексикографические части равно сумме
 * двух полученных новых чисел:
 – Если количество цифр квадратного числа четное, то левая и правая части будут
 иметь одинаковую длину.
 – Если количество цифр квадратного числа нечетно, то правая часть будет самой
 длинной половиной, а левая-самой маленькой или равной нулю, если количество цифр
 равно 1.
 – Учитывая положительное целое число n, реализуйте функцию, которая возвращает true, если это число Капрекара, и false, если это не так.
 **/
    public static boolean isKaprekar(int n){
        String str = String.valueOf(n*n);
        int ind = str.length() / 2;
        String str_L = "0" + str.substring(0, ind);
        String str_R = str.substring(ind);
        int sum = Integer.parseInt(str_L) + Integer.parseInt(str_R);
        return sum == n;
    }
/** Напишите функцию, которая возвращает самую
 *  длинную последовательность последовательных нулей в двоичной строке. **/
public static String longestZero(String str)
{
    String max = "";
    String cur = "";
    for (int i = 0; i < str.length(); i++)
        if(str.charAt(i) == '0')
            cur = cur + "0";
        else
        {
            if (max.length() < cur.length()) max = cur;
            cur = "";
        }
    return max;
}

/**	Если задано целое число, создайте функцию, которая
 *  возвращает следующее простое число. Если число простое,
 *  верните само число. **/
public static int nextPrime(int k){
    int i = 2;
    while(i<k) {
        if(k % i == 0){
            i = 2;
            k++;
        }
        i++;
    }
    return k;
}
/** Учитывая три числа, x, y и z, определите,
 *  являются ли они ребрами прямоугольного треугольника. **/
    public static boolean rightTriangle(int x, int y, int z){
        { return x*x + y*y == z*z || y*y + z*z == x*x || x*x + z*z == y*y; }
    }
}

