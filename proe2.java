import java.util.Scanner;

class Address {
    private final String streetName;
    private final int houseNumber;
    private final int apartmentNumber;
    private static int objectCount = 0;

    public Address() {
        this.streetName = "Неизвестная улица";
        this.houseNumber = 0;
        this.apartmentNumber = 0;
        objectCount++;
    }

    public Address(String streetName, int houseNumber, int apartmentNumber) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        objectCount++;
    }

    public Address(Address other) {
        this.streetName = other.streetName;
        this.houseNumber = other.houseNumber;
        this.apartmentNumber = other.apartmentNumber;
        objectCount++;
    }

    public void show() {
        System.out.println("Улица: " + streetName + ", Дом: " + houseNumber + ", Квартира: " + apartmentNumber);
    }

    public String getStreetName() {
        return streetName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public static void printObjectCount() {
        System.out.println("Всего объектов сгенерировано: " + objectCount);
    }
}

public class proe2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Введите количество адресов: ");
            int size = scanner.nextInt();
            scanner.nextLine();
            Address[] addresses = new Address[size];

            for (int i = 0; i < size; i++) {
                System.out.println("\n--- Создание адреса " + (i + 1) + " ---");
                System.out.println("Выберите конструктор:");
                System.out.println("1 - по умолчанию");
                System.out.println("2 - пользовательский");
                System.out.println("3 - копирование");
                System.out.print("Ваш выбор: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addresses[i] = new Address();
                        System.out.println("Адрес по умолчанию создан.");
                        break;

                    case 2:
                        System.out.print("Название улицы: ");
                        String street = scanner.nextLine();
                        System.out.print("Номер дома: ");
                        int house = scanner.nextInt();
                        System.out.print("Номер квартиры: ");
                        int apartment = scanner.nextInt();
                        scanner.nextLine();
                        addresses[i] = new Address(street, house, apartment);
                        System.out.println("Пользовательский адрес создан.");
                        break;

                    case 3:
                        if (i == 0) {
                            System.out.println("Не существует адреса для копирования. Будет применен конструктор по умолчанию.");
                            addresses[i] = new Address();
                        } else {
                            System.out.println("Существующие адреса (индексы 0.." + (i - 1) + "):");
                            for (int j = 0; j < i; j++) {
                                System.out.print(j + " ");
                                addresses[j].show();
                            }
                            System.out.print("Введите индекс адреса для копирования: ");
                            int srcIndex = scanner.nextInt();
                            scanner.nextLine();
                            if (srcIndex >= 0 && srcIndex < i) {
                                addresses[i] = new Address(addresses[srcIndex]);
                                System.out.println("Конструктор копирования использован (скопирован с индекса " + srcIndex + ").");
                            } else {
                                System.out.println("Несуществующий индекс. Будет использован конструктор по умолчанию.");
                                addresses[i] = new Address();
                            }
                        }
                        break;

                    default:
                        System.out.println("Недействительный выбор. Будет использован конструктор по умолчанию.");
                        addresses[i] = new Address();
                        break;
                }
            }

            System.out.println("\n========== Статистика ===========");
            Address.printObjectCount();

            System.out.println("\n======= Все адреса ========");
            for (int i = 0; i < addresses.length; i++) {
                System.out.print((i + 1) + ". ");
                addresses[i].show();
            }

            System.out.println("\n=== Номер дома четный или номер квартиры меньше 30 ===");
            boolean foundFirst = false;
            for (Address addr : addresses) {
                if (addr.getHouseNumber() % 2 == 0 || addr.getApartmentNumber() < 30) {
                    addr.show();
                    foundFirst = true;
                }
            }
            if (!foundFirst) {
                System.out.println("Такого адреса не найдено.");
            }

            System.out.println("\n=== Название улицы не начинается на П или Т ===");
            boolean foundSecond = false;
            for (Address addr : addresses) {
                String street = addr.getStreetName().toUpperCase();
                if (!street.startsWith("П") && !street.startsWith("Т")) {
                    addr.show();
                    foundSecond = true;
                }
            }
            if (!foundSecond) {
                System.out.println("Такого адреса не найдено.");
            }

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}