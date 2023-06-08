package task4_v2;

public class Main {
    public static void main(String[] args) {
        //Создать таксопарк.
        //получение данных с .csv файла с тестовыми данными
        AutoPark autoPark = new AutoPark();
        autoPark.showAllCarsInTheAutoPark();
        //Подсчитать стоимость автопарка.
        autoPark.getAutoParkCost();
        //Провести сортировку автомобилей парка по расходу топлива.
        autoPark.sortAutosByLitersPerOneHundredKm();
        //Найти автомобиль в компании, соответствующий заданному диапазону параметров скорости.
        autoPark.searchAutosBySpeedRange();
    }
}
