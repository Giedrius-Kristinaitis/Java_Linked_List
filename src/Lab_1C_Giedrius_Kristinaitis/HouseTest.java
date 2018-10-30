package Lab_1C_Giedrius_Kristinaitis;

import studijosKTU.Ks;
import studijosKTU.ListKTU;

import java.util.Locale;

/**
 *	@author Giedrius Kristinaitis
 */

public class HouseTest {

    /**
     * Tests the functionality of ListKTU, House, HouseStreet
     */
    public void test(){
        testIndividualHouses();
        testList();
        testSort();
        testFiltering();
    }

    /**
     * Tests the filtering mechanism of HouseStreet class
     */
    private void testFiltering(){
        Ks.oun("********* FILTRAVIMO TESTAS *********");
        HouseStreet.houses.add(new House(5, 10, 50000, 50));
        HouseStreet.houses.add(new House(6, 1, 60000, 75));
        HouseStreet.houses.add(new House(7, 5, 55000, 60));
        HouseStreet.houses.add(new House(8, 3, 88000, 120));
        HouseStreet.houses.add(new House(9, 8, 99000, 150));
        HouseStreet.houses.add(new House(4, 25, 40000, 60));
        HouseStreet.houses.add(new House(7, 13, 100000, 90));

        Ks.oun("Pradinis sąrašas:");
        printHouses(HouseStreet.houses);

        ListKTU<House> numOfRooms = HouseStreet.filterByNumberOfRooms(4, 5);
        Ks.oun("Namai su 4 arba 5 kambariais:");
        printHouses(numOfRooms);

        ListKTU<House> age = HouseStreet.filterByAge(10, 20);
        Ks.oun("Namai tarp 10 ir 20 metų amžiaus:");
        printHouses(age);

        ListKTU<House> area = HouseStreet.filterByArea(60, 100);
        Ks.oun("Namai su plotu tarp 60 ir 100 kv. metrų:");
        printHouses(area);

        ListKTU<House> price = HouseStreet.filterByPrice(70000, 99500);
        Ks.oun("Namai su kaina tarp 70000 ir 99500:");
        printHouses(price);

        ListKTU<House> mostExpensive = HouseStreet.getMostExpensiveHouses();
        Ks.oun("Brangiausias(-i) namas(-ai):");
        printHouses(mostExpensive);
    }

    /**
     * Tests the sorting mechanism of ListKTU class
     */
    private void testSort(){
        Ks.oun("********* RIKIAVIMO TESTAS *********");

        ListKTU<House> houses = new ListKTU<House>();
        houses.add(new House(5, 10, 50000, 50));
        houses.add(new House(6, 1, 60000, 75));
        houses.add(new House(7, 5, 55000, 60));
        houses.add(new House(8, 3, 88000, 120));
        houses.add(new House(9, 8, 99000, 150));
        houses.add(new House(4, 25, 40000, 60));
        houses.add(new House(7, 13, 100000, 90));
        houses.add(new House(6, 22, 75000, 80));
        houses.add(new House(3, 27, 45000, 50));
        houses.add(new House(2, 9, 30000, 35));

        Ks.oun("Sąrašas prieš rikiavimą:");
        printHouses(houses);

        houses.sortBuble();

        Ks.oun("Sąrašas po rikiavimo burbuliuku (be comparator):");
        printHouses(houses);

        houses.sortBuble(House.ROOM_COMPARATOR);

        Ks.oun("Sąrašas po rikiavimo burbuliuku (su kambarių skaičiaus komparatoriumi):");
        printHouses(houses);

        houses.sortSystem();

        Ks.oun("Sąrašas po rikiavimo sisteminiu metodu (be comparator):");
        printHouses(houses);

        houses.sortSystem(House.AGE_COMPARATOR);

        Ks.oun("Sąrašas po rikiavimo sisteminiu metodu (su amžiaus komparatoriumi):");
        printHouses(houses);
    }

    /**
     * Tests the functionality of ListKTU class
     */
    private void testList(){
        Ks.oun("********* SĄRAŠO TESTAS *********");

        ListKTU<House> houses = new ListKTU<House>();
        houses.add(new House(5, 10, 50000, 50));
        houses.add(new House(6, 1, 60000, 75));
        houses.add(new House(7, 5, 55000, 60));
        houses.add(new House(8, 3, 88000, 120));
        houses.add(new House(9, 8, 99000, 150));

        Ks.oun("Namų sąrašas pridėjus namus su add(E e):");
        printHouses(houses);

        houses.add(3, new House(4, 25, 40000, 60));
        houses.add(2, new House(7, 13, 100000, 90));
        houses.add(0, new House(6, 22, 75000, 80));
        houses.add(1, new House(3, 27, 45000, 50));
        houses.add(5, new House(2, 9, 30000, 35));

        Ks.oun("Namų sąrašas pridėjus namus su add(int k, E e):");
        printHouses(houses);

        houses.remove(0);

        Ks.oun("Namų sąrašas pašalinus 0 elementą:");
        printHouses(houses);

        houses.remove(2);

        Ks.oun("Namų sąrašas pašalinus 2 elementą:");
        printHouses(houses);

        House house = new House(1, 2, 5000, 25);

        houses.set(1, house);

        Ks.oun("Namų sąrašas pakeitus elementą indeksu 1:");
        printHouses(houses);

        houses.addFirst(new House(2, 10, 6000, 30));
        Ks.oun("Namų sąrašas pridėjus elementą su addFirst(E e):");
        printHouses(houses);

        int lastIndex = houses.lastIndexOf(house);
        Ks.oun("Paskutinis namo {" + house.toString() + "} indeksas: " + lastIndex);
        Ks.oun("Paskutinis namo {20, 20, 200000, 250} indeksas: " + houses.lastIndexOf(new House(20, 20, 200000, 250)));

        ListKTU<House> toRetain = new ListKTU<House>();
        toRetain.add(new House(5, 10, 50000, 50));
        toRetain.add(new House(6, 1, 60000, 75));
        toRetain.add(new House(7, 5, 55000, 60));
        houses.retainAll(toRetain);

        Ks.oun("Namų, kurie turi būti palikti (retained) sąrašas:");
        printHouses(toRetain);

        Ks.oun("Namų sąrašas po retainAll(ListKTU<?> c):");
        printHouses(houses);
    }

    /**
     * Prints a list of houses to the console
     * @param houses list of houses to print
     */
    private void printHouses(ListKTU<House> houses){
        int index = 0;

        for(House house: houses){
            Ks.oun("[" + index++ + "]: " + house);
        }
    }

    /**
     * Tests the functionality of House class
     */
    private void testIndividualHouses(){
        Ks.oun("********* INDIVIDUALIŲ NAMŲ TESTAS *********");

        House house1 = new House(1, 10, 2000, 25);
        House house2 = new House(2, 20, 5000, 30);
        House house3 = new House(3, 15, 15000, 45);
        House house4 = new House();
        House house5 = new House();
        House house6 = new House();

        house4.parse("4 1 25000 50");
        house5.parse("5 5 20000 40");
        house6.parse("6 7 49000 100");

        Ks.oun(house1);
        Ks.oun(house2);
        Ks.oun(house3);
        Ks.ouf("Pirmų 3 namų ploto vidurkis: %10.2f \n",
                (house1.getArea() + house2.getArea() + house3.getArea()) / 3d);

        Ks.oun(house4);
        Ks.oun(house5);
        Ks.oun(house6);
        Ks.oun("Kitų 3 namų bendras kambarių skaičius: " +
                (house4.getNumberOfRooms() + house5.getNumberOfRooms() + house6.getNumberOfRooms()));
    }

    /**
     * Entry point of the program
     * @param args arguments for the program
     */
    public static void main(String[] args){
        Locale.setDefault(new Locale("LT"));
        new HouseTest().test();
    }
}
