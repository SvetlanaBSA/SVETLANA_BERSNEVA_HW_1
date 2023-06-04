package task4;

public class Main {
    public static void main(String[] args) {
        //Создать таксопарк.
        //получение данных с .csv файла с тестовыми данными
        AutoPark autoPark = new AutoPark();
        autoPark.getAutoPark();
        autoPark.showAllCarsInTheAutoPark();
        //Подсчитать стоимость автопарка.
        autoPark.getAutoParkCost();
        //Провести сортировку автомобилей парка по расходу топлива.
        autoPark.sortAutosBylitersPerOneHandredKm();
        //Найти автомобиль в компании, соответствующий заданному диапазону параметров скорости.
        autoPark.searchAutosBySpeedRange();
    }

}
