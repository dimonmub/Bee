import java.util.Scanner;

/**
 * Created by Dmitriy Mubarakshin on 28.09.14.
 */
public class Bee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя пчелки");
        String name = sc.next();
        System.out.println("Привет! Меня зовут " + name);
        System.out.println("Я - мальчик?");
        String answer = sc.next();
        if (answer.toUpperCase().equals("ДА"))
        {
            System.out.println("Я - трутень");
            setActionOrState(ActionOrState.MALE_BEE);
        }
        else
            setActionOrState(ActionOrState.FEMALE_BEE);
    }

    public static void setActionOrState(ActionOrState a){    //метод, отвечающий за структуру программы в целом
        //ActionOrState - параметр, определяющий текущее состояние или действие
        Scanner sc = new Scanner(System.in);
        switch (a) {
            case MALE_BEE:    //трутень
                System.out.println("Матка голодна?");
                String answer = sc.next();
                if (answer.toUpperCase().equals("ДА"))
                    setActionOrState(ActionOrState.TAKE_CARE_OF_QUEEN_BEE);
                else {
                    System.out.println("Я голоден?");
                    answer = sc.next();
                    if (answer.toUpperCase().equals("ДА"))
                        setActionOrState(ActionOrState.SEARCH_FOR_FOOD);
                    else {
                        System.out.println("Я не голоден, нужно посмотреть, как поживает матка");
                        setActionOrState(ActionOrState.MALE_BEE);
                    }
                }
                break;


            case FEMALE_BEE:
                System.out.println("Я - матка?");
                answer = sc.next();
                if (answer.toUpperCase().equals("ДА")) {
                    setActionOrState(ActionOrState.QUEEN_BEE);
                }
                else {    //рабочая пчелка
                    System.out.println("Я - рабочая пчелка");
                    setActionOrState(ActionOrState.WORKER_BEE);
                }

                break;


            case QUEEN_BEE:    //матка
                System.out.println("Я голодна?");
                answer = sc.next();
                if (answer.toUpperCase().equals("ДА"))
                    setActionOrState(ActionOrState.DEMAND_FOR_FOOD);
                else {
                    System.out.println("У меня есть потомство?");
                    answer = sc.next();
                    if (answer.toUpperCase().equals("ДА"))
                        setActionOrState(ActionOrState.TAKE_CARE_OF_CHILDREN);
                    else
                        setActionOrState(ActionOrState.CREATE_BROOD);
                }
                break;


            case WORKER_BEE:    //рабочая пчелка
                System.out.println("Сейчас день?");
                answer = sc.next();
                if (answer.toUpperCase().equals("ДА")) {
                    System.out.println("Пора на работу");
                    setActionOrState(ActionOrState.SEARCH_FOR_NECTAR);
                }
                else
                    setActionOrState(ActionOrState.SLEEP);
                break;


            case SLEEP:
                System.out.println("Ночь, пора спать");
                setActionOrState(ActionOrState.WORKER_BEE);
                break;


            case SEARCH_FOR_NECTAR:
                System.out.println("Нашла нектар?");
                answer = sc.next();
                if (answer.toUpperCase().equals("ДА"))
                    setActionOrState(ActionOrState.TAKE_TO_HIVE);
                else {
                    System.out.println("Буду искать дальше");
                    setActionOrState(ActionOrState.SEARCH_FOR_NECTAR);
                }

                break;


            case TAKE_TO_HIVE:
                System.out.println("Я собрала достаточно, пора отнести в улей");
                setActionOrState(ActionOrState.WORKER_BEE);
                break;


            case CREATE_BROOD:    //создать потомство
                System.out.println("У меня до сих пор нет детей! Нужно это исправить...");
                System.out.println("Прошло несколько недель");
                setActionOrState(ActionOrState.QUEEN_BEE);
                break;


            case TAKE_CARE_OF_CHILDREN:
                System.out.println("Где мои детки? Пора за ними поухаживать");
                setActionOrState(ActionOrState.QUEEN_BEE);
                break;


            case DEMAND_FOR_FOOD:
                System.out.println("Я хочу есть! Где мое фуагра?");
                System.out.println("Кушаю...");
                setActionOrState(ActionOrState.QUEEN_BEE);
                break;


            case TAKE_CARE_OF_QUEEN_BEE:
                System.out.println("Матка голодна, и я должен за ней ухаживать");
                setActionOrState(ActionOrState.MALE_BEE);
                break;


            case SEARCH_FOR_FOOD:
                System.out.println("Я голоден, и мне нужно найти что-нибудь поесть");
                System.out.println("Нашел еду?");
                answer = sc.next();
                if (answer.toUpperCase().equals("ДА")) {
                    System.out.println("Я покушал, нужно посмотреть, как поживает матка");
                    setActionOrState(ActionOrState.MALE_BEE);
                }
                else {
                    System.out.println("Пока я ничего не нашел :(");
                    setActionOrState(ActionOrState.SEARCH_FOR_FOOD);
                }
                break;
        }
    }

}
