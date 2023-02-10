import java.util.*;
import java.util.function.Predicate;

// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру. 
// Критерии фильтрации можно хранить в Map.

// Например: “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет

// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
// Класс сделать в отдельном файле

public class Laptop {

  public static void Price(Collection<Components> laptop) {
      while (true) {
          Scanner iScanner = new Scanner(System.in);
          System.out.printf("Дороже(1), Дешевле(2), Выход(3): ");
          int choice1 = iScanner.nextInt();
          if (choice1 == 1) {
            System.out.printf("Введиде цену: ");
            int price = iScanner.nextInt();
            System.out.printf("Ноутбуки, цена которых больше либо равна: %d руб.\n", price);
            System.out.println("-----------------------------------------------");
            Predicate<Components> laptopMaxPrice = n -> n.getPrice() >= price;
            laptop.stream()
              .filter(laptopMaxPrice)
              .forEach(System.out::println);
              System.out.println();
          }
          else if (choice1 == 2) {
            System.out.printf("Введиде цену: ");
            int price = iScanner.nextInt();
            System.out.printf("Ноутбуки, цена которых меньше либо равна: %d руб.\n", price);
            System.out.println("-----------------------------------------------");
            Predicate<Components> laptopMinPrice = n -> n.getPrice() <= price;
            laptop.stream()
              .filter(laptopMinPrice)
              .forEach(System.out::println);
              System.out.println();
          }
          else if (choice1 == 3) {
            return;
          }
        }
    }

    public static void SSD(Collection<Components> laptop) {
      while (true) {
          Scanner iScanner = new Scanner(System.in);
          System.out.printf("Объем больше(1), Меньше(2), Выход(3): ");
          int choice1 = iScanner.nextInt();
          if (choice1 == 1) {
            System.out.printf("Введиде объем: ");
            int ssd = iScanner.nextInt();
            System.out.printf("Ноутбуки, объем SSD кодорых больше либо равен: %d Gb.\n", ssd);
            System.out.println("-----------------------------------------------");
            Predicate<Components> laptopMaxDisk = n -> n.getDisk_size() >= ssd;
            laptop.stream()
              .filter(laptopMaxDisk)
              .forEach(System.out::println);
              System.out.println();
          }
          else if (choice1 == 2) {
            System.out.printf("Введиде объем: ");
            int ssd = iScanner.nextInt();
            System.out.printf("Ноутбуки, объем SSD кодорых меньше либо равен: %d Gb.\n", ssd);
            System.out.println("-----------------------------------------------");
            Predicate<Components> laptopMinDisk = n -> n.getDisk_size() <= ssd;
            laptop.stream()
              .filter(laptopMinDisk)
              .forEach(System.out::println);
              System.out.println();
          }
          else if (choice1 == 3) {
            return;
          }
        }
    }


   public static void Collor(Collection<Components> laptop) {
    while (true) {
      Scanner iScanner = new Scanner(System.in);
      System.out.printf("Выбор цвета(1), Выход(2): ");
      int choice1 = iScanner.nextInt();
      if (choice1 == 1) {
        Scanner Scan = new Scanner(System.in);
        System.out.printf("Введиде цвет ноутбука: ");
        String name = Scan.nextLine();
        System.out.printf("Ноутбуки у которых цвет: %s\n", name);
        System.out.println("-----------------------------------------------");
        Predicate<Components> laptopCollor = n -> n.getColor().equals(name);
        laptop.stream()
          .filter(laptopCollor)
          .forEach(System.out::println);
        System.out.println();
      }
      else if (choice1 == 2) {
        return;
      }
    }
   }

   public static void OS(Collection<Components> laptop) {
    while (true) {
      Scanner iScanner = new Scanner(System.in);
      System.out.printf("Выбор OS(1), Выход(2): ");
      int choice1 = iScanner.nextInt();
      if (choice1 == 1) {
        Scanner Scan = new Scanner(System.in);
        System.out.printf("Введиде название OS: ");
        String name = Scan.nextLine();
        System.out.printf("Ноутбуки у которых предустановлена OS: %s\n", name);
        System.out.println("-----------------------------------------------");
        Predicate<Components> laptopOs = n -> n.getOs().equals(name);
        laptop.stream()
          .filter(laptopOs)
          .forEach(System.out::println);
        System.out.println();
      }
      else if (choice1 == 2) {
        return;
      }
    }
   }

  public static void main(String[] args) {  
    List<Components> laptop = new ArrayList<>();
    Components laptop1 = new Components(1, "DEXP Aquilon", 16000, "Intel Celeron N4020", 4, 128, "silver", "Windows 11");
    Components laptop2 = new Components(2, "ASUS VivoBook 14 F413JA-EK604", 36000, "Intel Core i3-1005G1", 8, 512, "black", "Without OS");
    Components laptop3 = new Components(3, "ASUS VivoBook 14X M1403QA-LY112", 67500, "AMD Ryzen 7 5800H", 16, 1000, "silver", "Without OS");
    Components laptop4 = new Components(4, "Digma EVE 14 C414", 18000, "Intel Celeron N4020", 4, 64, "silver", "Windows 10");
    Components laptop5 = new Components(5, "ASUS TUF Gaming F15 FX506LH-HN042", 64000, "Intel Core i5-10300H", 16, 512, "black", "Without OS");

    laptop.add(laptop1);
    laptop.add(laptop2);
    laptop.add(laptop3);
    laptop.add(laptop4);
    laptop.add(laptop5);

    try (Scanner sc = new Scanner(System.in)) {
      while (true) {
          System.out.printf("ФИЛЬТР По цене(1), По объему SSD(2), По цвету(3), По ОС(4) Выйти(5): ");
          int choice = sc.nextInt();
          sc.nextLine();
          if (choice == 1) {
              Price(laptop);
          }
          if (choice == 2) {
            SSD(laptop);
          }
          if (choice == 3) {
            Collor(laptop);
          }
          if (choice == 4) {
            OS(laptop);
          }
          else if (choice == 5) {
              return;
          }
        }
    }
     
  }
} 