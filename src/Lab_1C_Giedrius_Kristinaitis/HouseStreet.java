package Lab_1C_Giedrius_Kristinaitis;

import studijosKTU.ListKTUx;

/**
 *	@author Giedrius Kristinaitis
 */

public class HouseStreet {

    // list containing all houses in the street
    public static ListKTUx<House> houses = new ListKTUx<House>(new House());

    // base house used to create other houses
    private static final House baseHouse = new House();

    /**
     * Filters all houses based on price
     * @param minPrice minimum allowed price
     * @param maxPrice maximum allowed price
     * @return new ListKTUx<House> containing filtered houses
     */
    public static ListKTUx<House> filterByPrice(double minPrice, double maxPrice){
        ListKTUx<House> newHouses = new ListKTUx<House>(baseHouse);

        for(House house: houses){
            double price = house.getPrice();

            if(price >= minPrice && price <= maxPrice){
                newHouses.add(house);
            }
        }

        return newHouses;
    }

    /**
     * Filters all houses based on age
     * @param minAge minimum allowed age
     * @param maxAge maximum allowed age
     * @return new ListKTUx<House> containing filtered houses
     */
    public static ListKTUx<House> filterByAge(double minAge, double maxAge){
        ListKTUx<House> newHouses = new ListKTUx<House>(baseHouse);

        for(House house: houses){
            double age = house.getAge();

            if(age >= minAge && age <= maxAge){
                newHouses.add(house);
            }
        }

        return newHouses;
    }

    /**
     * Filters all houses based on number of rooms
     * @param minRooms minimum allowed age
     * @param maxRooms maximum allowed age
     * @return new ListKTUx<House> containing filtered houses
     */
    public static ListKTUx<House> filterByNumberOfRooms(double minRooms, double maxRooms){
        ListKTUx<House> newHouses = new ListKTUx<House>(baseHouse);

        for(House house: houses){
            double rooms = house.getNumberOfRooms();

            if(rooms >= minRooms && rooms <= maxRooms){
                newHouses.add(house);
            }
        }

        return newHouses;
    }

    /**
     * Filters all houses based on area
     * @param minArea minimum allowed area
     * @param maxArea maximum allowed area
     * @return new ListKTUx<House> containing filtered houses
     */
    public static ListKTUx<House> filterByArea(double minArea, double maxArea){
        ListKTUx<House> newHouses = new ListKTUx<House>(baseHouse);

        for(House house: houses){
            double area = house.getArea();

            if(area >= minArea && area <= maxArea){
                newHouses.add(house);
            }
        }

        return newHouses;
    }

    /**
     * Gets most expensive houses
     * @return new ListKTUx<House> containing most expensive houses
     */
    public static ListKTUx<House> getMostExpensiveHouses(){
        ListKTUx<House> newHouses = new ListKTUx<House>(baseHouse);
        double maxPrice = 0;

        for(House house: houses){
            double price = house.getPrice();

            if(price >= maxPrice){
                if(price > maxPrice){
                    maxPrice = price;
                    newHouses.clear();
                }

                newHouses.add(house);
            }
        }

        return newHouses;
    }
}
