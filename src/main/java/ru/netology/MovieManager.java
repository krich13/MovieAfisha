package ru.netology;

//у нас есть менеджер, который хранит информацию обо всех фильмах, он умеет добавлять фильмы к себе в память, выдавать последние 10

public class MovieManager {

    private int itemsQuantityToRequest = 10;
    private MovieItem[] items = new MovieItem[0]; //массив всех фильмов должен храниться в памяти класса


    //конструктор с параметром, берущий значение лимита для менеджера из параметра конструктора
    public MovieManager(int itemsQuantityToRequest) {
        this.itemsQuantityToRequest = itemsQuantityToRequest;
    }

    //конструктор без параметров, выставляющий лимит менеджера в 10
    public MovieManager() {
    }

    public void addMovie(MovieItem item) {  // создаём новый массив размером на единицу больше
        int newLength = items.length + 1;
        MovieItem[] newArray = new MovieItem[newLength]; //создаем временный массив
        for (int i = 0; i < items.length; i++) { //скопировать все из старого в новый
            newArray[i] = items[i]; //присвой в ячейку нового массива то, что лежало в старой ячейке
        }
        int lastIndex = newArray.length - 1;
        newArray[lastIndex] = item;
        items = newArray;
    }

    public MovieItem[] getLastMovies() {
        int resultLength;       //создаем новую переменную
        if (items.length > itemsQuantityToRequest) {    //если длина массива больше, чем 10, то выводим последние 10, если меньше, то выводим все
            resultLength = itemsQuantityToRequest;
        } else {
            resultLength = items.length;
        }

        MovieItem[] result = new MovieItem[resultLength]; // заполняем result из массива, что лежит в поле
        for (int i = 0; i < result.length; i++) { // перебираем массив в прямом порядке
            int index = items.length - i - 1; // но кладём в результаты в обратном
            result[i] = items[index];
        }
        return result;
    }
}
