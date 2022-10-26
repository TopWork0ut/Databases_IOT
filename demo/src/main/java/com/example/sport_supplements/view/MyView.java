package com.example.sport_supplements.view;
import com.example.sport_supplements.controller.*;
import com.example.sport_supplements.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.*;
@Component
public class MyView {
    @Autowired
    private DishController dishController;
    @Autowired
    private ScheduleController scheduleController;
    @Autowired
    private ScheduleDishController scheduleDishController;
    @Autowired
    private ScheduleSupplementController scheduleSupplementController;
    @Autowired
    private SportsmanController sportsmanController;
    @Autowired
    private SupplementController supplementController;

    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner input = new Scanner(System.in);
    private final Dish nullDish = new Dish(null, null, null, null, null, null, null);
    private final Schedule nullSchedule = new Schedule(null, null, null, null);
    private final ScheduleDish nullScheduleDish = new ScheduleDish(null, null);
    private final ScheduleSupplement nullScheduleSupplement = new ScheduleSupplement(null,null);
    private final Sportsman nullSportsman = new Sportsman(null,null,null,null,null,null,null);
    private final Supplement nullSupplement = new Supplement(null, null, null, null, null, null, null);


    public MyView() {
        menu = new LinkedHashMap<>();
        menu.put("A", "  A - Select all table");

        menu.put("1", "   1 - Table: Dish");
        menu.put("11", "  11 - Create Dish");
        menu.put("12", "  12 - Update Dish");
        menu.put("13", "  13 - Delete from Dish");
        menu.put("14", "  14 - Find all Dishes");
        menu.put("15", "  15 - Find Dish by ID");
        menu.put("16", "  16 - Find Dish by dish_name");

        menu.put("2", "   2 - Table: Schedule");
        menu.put("21", "  21 - Create Schedule");
        menu.put("22", "  22 - Update Schedule");
        menu.put("23", "  23 - Delete from Schedule");
        menu.put("24", "  24 - Find all Schedules");
        menu.put("25", "  25 - Find Schedule by ID");

        menu.put("3", "   3 - Table: ScheduleDish");
        menu.put("31", "  31 - Create ScheduleDish");
        menu.put("32", "  32 - Find all ScheduleDishes");
        menu.put("33", "  33 - Update ScheduleDishes");
        menu.put("34", "  34 - Delete ScheduleDish");
        menu.put("35", "  35 - Find ScheduleDishes by Id");

        menu.put("4", "   4 - Table: ScheduleSupplement");
        menu.put("41", "  41 - Create ScheduleSupplement");
        menu.put("42", "  42 - Find all ScheduleSupplements");
        menu.put("43", "  43 - Update ScheduleSupplement");
        menu.put("44", "  44 - Delete from ScheduleSupplement");
        menu.put("45", "  45 - Find ScheduleSupplements by Id");

        menu.put("5", "   5 - Table: Sportsman");
        menu.put("51", "  51 - Create Sportsman");
        menu.put("52", "  52 - Update Sportsman");
        menu.put("53", "  53 - Delete from Sportsman");
        menu.put("54", "  54 - Find all Sportsmans");
        menu.put("55", "  55 - Find Sportsman by ID");
        menu.put("56", "  56 - Find Sportsman by Surname");


        menu.put("6", "   6 - Table: Supplement");
        menu.put("61", "  61 - Create Supplement");
        menu.put("62", "  62 - Update Supplement");
        menu.put("63", "  63 - Delete from Supplement");
        menu.put("64", "  64 - Find all Supplements");
        menu.put("65", "  65 - Find Supplement by ID");
        menu.put("66", "  66 - Find Supplement by Name");

        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("A", this::selectAllTable);

        methodsMenu.put("11", this::createDish);
        methodsMenu.put("12", this::updateDish);
        methodsMenu.put("13", this::deleteFromDish);
        methodsMenu.put("14", this::findAllDishes);
        methodsMenu.put("15", this::findDishById);
        methodsMenu.put("16", this::findByDishName);

        methodsMenu.put("21", this::createSchedule);
        methodsMenu.put("22", this::updateSchedule);
        methodsMenu.put("23", this::deleteFromSchedule);
        methodsMenu.put("24", this::findAllSchedules);
        methodsMenu.put("25", this::findScheduleById);

        methodsMenu.put("31", this::createScheduleDish);
        methodsMenu.put("32", this::findAllScheduleDishes);
        methodsMenu.put("33", this::updateScheduleDish);
        methodsMenu.put("34", this::deleteScheduleDishById);
        methodsMenu.put("35", this::findScheduleDishById);

        methodsMenu.put("41", this::createScheduleSupplement);
        methodsMenu.put("42", this::findAllScheduleSupplements);
        methodsMenu.put("43", this::updateScheduleSupplement);
        methodsMenu.put("44", this::deleteScheduleSupplementById);
        methodsMenu.put("45", this::findScheduleSupplementById);

        methodsMenu.put("51", this::createSportsman);
        methodsMenu.put("52", this::updateSportsman);
        methodsMenu.put("53", this::deleteFromSportsman);
        methodsMenu.put("54", this::findAllSportsmans);
        methodsMenu.put("55", this::findSportsmanById);
        methodsMenu.put("56", this::findBySportsmanSurName);

        methodsMenu.put("61", this::createSupplement);
        methodsMenu.put("62", this::updateSupplement);
        methodsMenu.put("63", this::deleteFromSupplement);
        methodsMenu.put("64", this::findAllSupplements);
        methodsMenu.put("65", this::findSupplementById);
        methodsMenu.put("66", this::findBySupplementName);
    }

    private void selectAllTable() {
        findAllDishes();
        findAllSchedules();
        findAllSportsmans();
        findAllSupplements();
    }


//    Dish --------------------------------


    private void createDish() {
        System.out.println("Input 'dish_name': ");
        String dishName = input.nextLine();
        System.out.println("Input 'components': ");
        String components = input.nextLine();
        System.out.println("Input 'calories': ");
        Integer calories = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'manufacturer': ");
        String manufacturer = input.nextLine();
        System.out.println("Input 'productionDate': ");
        LocalDate productionDate = LocalDate.parse(input.nextLine());
        System.out.println("Input 'consumptionDate': ");
        LocalDate consumptionDate = LocalDate.parse(input.nextLine());

        Dish dish = new Dish(null, dishName, components, calories, manufacturer, productionDate, consumptionDate);

        int count = dishController.create(dish);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateDish() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'dish_name': ");
        String dishName = input.nextLine();
        System.out.println("Input 'components': ");
        String components = input.nextLine();
        System.out.println("Input 'calories': ");
        Integer calories = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'manufacturer': ");
        String manufacturer = input.nextLine();
        System.out.println("Input 'productionDate': ");
        LocalDate productionDate = LocalDate.parse(input.nextLine());
        System.out.println("Input 'consumptionDate': ");
        LocalDate consumptionDate = LocalDate.parse(input.nextLine());

        Dish dish = new Dish(null, dishName, components, calories, manufacturer, productionDate, consumptionDate);

        int count = dishController.update(id, dish);
        System.out.printf("There are updated %d rows\n", count);

    }

    private void deleteFromDish() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = dishController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllDishes() {
        System.out.println("\nTable: Dish");
        List<Dish> dishes = dishController.findAll();
        for (Dish dish : dishes) {
            System.out.println(dish);
        }
    }

    private void findDishById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Dish> dish = dishController.findById(id);
        System.out.println(dish.orElse(nullDish));
    }

    private void findByDishName() {
        System.out.println("Input 'dish_name': ");
        String dishName = input.nextLine();

        Optional<Dish> dish = dishController.findByDishName(dishName);
        System.out.println(dish.orElse(nullDish));
    }


//    Schedule --------------------------------


    private void createSchedule() {
        System.out.println("Input 'startDietingDate': ");
        LocalDate startDieting = LocalDate.parse(input.nextLine());
        System.out.println("Input 'endDietingDate': ");
        LocalDate endDieting = LocalDate.parse(input.nextLine());
        System.out.println("Input 'description': ");
        String description = input.nextLine();

        Schedule schedule = new Schedule(null, startDieting, endDieting, description);

        int count = scheduleController.create(schedule);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateSchedule() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'startDietingDate': ");
        LocalDate startDieting = LocalDate.parse(input.nextLine());
        System.out.println("Input 'endDietingDate': ");
        LocalDate endDieting = LocalDate.parse(input.nextLine());
        System.out.println("Input 'description': ");
        String description = input.nextLine();

        Schedule schedule = new Schedule(null, startDieting, endDieting, description);

        int count = scheduleController.update(id, schedule);
        System.out.printf("There are updated %d rows\n", count);

    }

    private void deleteFromSchedule() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = scheduleController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllSchedules() {
        System.out.println("\nTable: Schedule");
        List<Schedule> schedules = scheduleController.findAll();
        for (Schedule schedule : schedules) {
            System.out.println(schedule);
        }
    }

    private void findScheduleById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Schedule> schedule = scheduleController.findById(id);
        System.out.println(schedule.orElse(nullSchedule));
    }


// ScheduleDish --------------------------------


    private void createScheduleDish() {
        System.out.println("Input 'schedule id': ");
        Integer scheduleId = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'dish id': ");
        Integer dishId = Integer.valueOf((input.nextLine()));

        ScheduleDish scheduleDish = new ScheduleDish(scheduleId, dishId);

        int count = scheduleDishController.create(scheduleId, dishId, scheduleDish);
        System.out.printf("There are created %d rows\n", count);
    }


    private void findAllScheduleDishes() {
        System.out.println("\nTable: ScheduleDish");
        List<ScheduleDish> scheduleDishes = scheduleDishController.findAll();
        for (ScheduleDish scheduleDish : scheduleDishes) {
            System.out.println(scheduleDish);
        }
    }

    private void findScheduleDishById() {
        System.out.println("Input 'dish id': ");
        Integer dishID = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'schedule id': ");
        Integer scheduleID = Integer.valueOf((input.nextLine()));

        Optional<ScheduleDish> scheduleDish = scheduleDishController.findById(scheduleID, dishID);
        System.out.println(scheduleDish.orElse(nullScheduleDish));
    }

    private void updateScheduleDish() {
        System.out.println("Input 'dish_id': ");
        Integer dishID = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'schedule_id': ");
        Integer scheduleID = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'new dish_id': ");
        Integer newDishID = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'new schedule_id': ");
        Integer newScheduleID = Integer.valueOf((input.nextLine()));

        ScheduleDish scheduleDish = new ScheduleDish(newScheduleID, newDishID);

        int count = scheduleDishController.update(scheduleID, dishID, scheduleDish);
        System.out.printf("There are updated %d rows\n", count);

    }

    private void deleteScheduleDishById() {
        System.out.println("Input 'dish id': ");
        Integer dishID = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'schedule id': ");
        Integer scheduleID = Integer.valueOf((input.nextLine()));

        int count = scheduleDishController.delete(scheduleID, dishID);
        System.out.printf("There are deleted %d rows\n", count);
    }


//    ScheduleSupplement --------------------------------


    private void createScheduleSupplement() {
        System.out.println("Input 'schedule_id': ");
        Integer scheduleId = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'supplement_id': ");
        Integer supplementId = Integer.valueOf((input.nextLine()));

        ScheduleSupplement scheduleSupplement  = new ScheduleSupplement(scheduleId, supplementId);

        int count = scheduleSupplementController.create(scheduleId, supplementId, scheduleSupplement);
        System.out.printf("There are created %d rows\n", count);
    }


    private void findAllScheduleSupplements() {
        System.out.println("\nTable: ScheduleDish");
        List<ScheduleSupplement> scheduleSupplements = scheduleSupplementController.findAll();
        for (ScheduleSupplement scheduleSupplement : scheduleSupplements) {
            System.out.println(scheduleSupplement);
        }
    }

    private void findScheduleSupplementById() {
        System.out.println("Input 'schedule_id': ");
        Integer scheduleId = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'supplement_id': ");
        Integer supplementId = Integer.valueOf((input.nextLine()));

        Optional<ScheduleSupplement> scheduleSupplement = scheduleSupplementController.findById(scheduleId, supplementId);
        System.out.println(scheduleSupplement.orElse(nullScheduleSupplement));
    }

    private void updateScheduleSupplement() {
        System.out.println("Input 'schedule_id': ");
        Integer scheduleID = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'supplement_id': ");
        Integer supplementId = Integer.valueOf((input.nextLine()));


        System.out.println("Input 'new schedule_id': ");
        Integer newScheduleID = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'new supplement_id': ");
        Integer newSupplementId = Integer.valueOf((input.nextLine()));


        ScheduleSupplement scheduleSupplement = new ScheduleSupplement(newScheduleID, newSupplementId);

        int count = scheduleSupplementController.update(scheduleID, supplementId, scheduleSupplement);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteScheduleSupplementById() {
        System.out.println("Input 'schedule_id': ");
        Integer scheduleID = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'supplement_id': ");
        Integer supplementId = Integer.valueOf((input.nextLine()));

        int count = scheduleSupplementController.delete(scheduleID, supplementId);
        System.out.printf("There are deleted %d rows\n", count);
    }


//  Sportsman --------------------------------


    private void createSportsman() {
        System.out.println("Input 'sportsman_name': ");
        String sportsmanName = input.nextLine();
        System.out.println("Input 'sportsman_surname': ");
        String sportsmanSurName = input.nextLine();
        System.out.println("Input 'kind_of_sport': ");
        String kindOfSport = input.nextLine();
        System.out.println("Input 'height': ");
        Integer height = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'weight': ");
        Integer weight = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'schedule_id': ");
        Integer scheduleID = Integer.valueOf((input.nextLine()));

        Sportsman sportsman = new Sportsman(null, sportsmanName,sportsmanSurName, kindOfSport, height, weight, scheduleID);

        int count = sportsmanController.create(sportsman);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateSportsman() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'sportsman_name': ");
        String sportsmanName = input.nextLine();
        System.out.println("Input 'sportsman_surname': ");
        String sportsmanSurName = input.nextLine();
        System.out.println("Input 'kind_of_sport': ");
        String kindOfSport = input.nextLine();
        System.out.println("Input 'height': ");
        Integer height = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'weight': ");
        Integer weight = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'schedule_id': ");
        Integer scheduleID = Integer.valueOf((input.nextLine()));

        Sportsman sportsman = new Sportsman(null, sportsmanName,sportsmanSurName, kindOfSport, height, weight, scheduleID);

        int count = sportsmanController.update(id, sportsman);
        System.out.printf("There are updated %d rows\n", count);

    }

    private void deleteFromSportsman() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = sportsmanController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllSportsmans() {
        System.out.println("\nTable: Dish");
        List<Sportsman> sportsmen = sportsmanController.findAll();
        for (Sportsman sportsman : sportsmen) {
            System.out.println(sportsman);
        }
    }

    private void findSportsmanById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Sportsman> sportsman = sportsmanController.findById(id);
        System.out.println(sportsman.orElse(nullSportsman));
    }

    private void findBySportsmanSurName() {
        System.out.println("Input 'sportsman_surname': ");
        String sportsmanSurName = input.nextLine();

        Optional<Sportsman> sportsman = sportsmanController.findBySportsmanSurName(sportsmanSurName);
        System.out.println(sportsman.orElse(nullSportsman));
    }


// Supplement --------------------------------


    private void createSupplement() {
        System.out.println("Input 'supplement_name': ");
        String supplementName = input.nextLine();
        System.out.println("Input 'components': ");
        String components = input.nextLine();
        System.out.println("Input 'calories': ");
        Integer calories = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'manufacturer': ");
        String manufacturer = input.nextLine();
        System.out.println("Input 'productionDate': ");
        LocalDate productionDate = LocalDate.parse(input.nextLine());
        System.out.println("Input 'consumptionDate': ");
        LocalDate consumptionDate = LocalDate.parse(input.nextLine());

        Supplement supplement = new Supplement(null, supplementName, components, calories, manufacturer, productionDate, consumptionDate);

        int count = supplementController.create(supplement);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateSupplement() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'dish_name': ");
        String supplementName = input.nextLine();
        System.out.println("Input 'components': ");
        String components = input.nextLine();
        System.out.println("Input 'calories': ");
        Integer calories = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'manufacturer': ");
        String manufacturer = input.nextLine();
        System.out.println("Input 'productionDate': ");
        LocalDate productionDate = LocalDate.parse(input.nextLine());
        System.out.println("Input 'consumptionDate': ");
        LocalDate consumptionDate = LocalDate.parse(input.nextLine());

        Supplement supplement = new Supplement(null, supplementName, components, calories, manufacturer, productionDate, consumptionDate);

        int count = supplementController.update(id, supplement);
        System.out.printf("There are updated %d rows\n", count);

    }

    private void deleteFromSupplement() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = supplementController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllSupplements() {
        System.out.println("\nTable: Dish");
        List<Supplement> supplements = supplementController.findAll();
        for (Supplement supplement : supplements) {
            System.out.println(supplement);
        }
    }

    private void findSupplementById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Supplement> supplement = supplementController.findById(id);
        System.out.println(supplement.orElse(nullSupplement));
    }

    private void findBySupplementName() {
        System.out.println("Input 'dish_name': ");
        String supplementName = input.nextLine();

        Optional<Supplement> supplement = supplementController.findBySupplementName(supplementName);
        System.out.println(supplement.orElse(nullSupplement));
    }


// Output --------------------------------


    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) {
                try {
                    System.out.println(menu.get(key));
                } catch (Exception e) {
                    System.out.println("There is no such option in the list");
                    e.printStackTrace();
                }
            }
    }

    private void outputSubMenu(String fig) {
        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!keyMenu.equals("Q"));
    }
}

