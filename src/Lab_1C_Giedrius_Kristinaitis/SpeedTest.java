package Lab_1C_Giedrius_Kristinaitis;

import studijosKTU.Ks;
import studijosKTU.ListKTU;
import studijosKTU.Timekeeper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Random;

/**
 *	@author Giedrius Kristinaitis
 */

public class SpeedTest {

    // used to generate random numbers
    private static final Random random = new Random(2018);

    // number of elements to test
    private static final int[] testSizes = new int[] {2000, 4000, 8000, 16000};

    /**
     * Tests the speed and memory usage of various classes
     */
    public void test(){
        long memory = Runtime.getRuntime().totalMemory();

        Ks.oun("Total memory: " + memory);

        testSorting();
        testMathPow();
        testLastIndexOf();
    }

    /**
     * Tests the speed of ArrayList.lastIndexOf and LinkedList.lastIndexOf
     */
    private void testLastIndexOf(){
        Ks.oun("********* lastIndexOf TESTAS *********");

        Timekeeper timer = new Timekeeper(testSizes);

        for(int size: testSizes){
            ArrayList<Integer> arrayList = generateIntegersArrayList(size);
            LinkedList<Integer> linkedList = generateIntegersLinkedList(size);

            timer.start();
            arrayList.lastIndexOf(new Integer(5));
            timer.finish("ArrList");
            linkedList.lastIndexOf(new Integer(5));
            timer.finish("LinList");
            timer.seriesFinish();
        }
    }

    /**
     * Tests the speed of Math.pow method and compares it to normal multiplication
     */
    private void testMathPow(){
        Ks.oun("********* Math.pow(x, 2) ir x * x TESTAS *********");

        Timekeeper timer = new Timekeeper(testSizes);

        for(int size: testSizes){
            double[] numbers1 = generateDoubles(size);
            double[] numbers2 = generateDoubles(size);

            timer.start();

            for(Double x: numbers1){
                Math.pow(x, 2);
            }

            timer.finish("pow(x, 2)");

            for(Double x: numbers2){
                double result = x * x;
            }

            timer.finish("x * x");
            timer.seriesFinish();
        }
    }

    /**
     * Tests sorting speed
     */
    private void testSorting(){
        Ks.oun("********* RIKIAVIMO TESTAS *********");

        Timekeeper timer = new Timekeeper(testSizes);

        for(int size: testSizes){
            ListKTU<House> houses = generateHouses(size);

            timer.start();
            houses.sortSystem();
            timer.finish("SysBeComp");
            houses.sortSystem(House.ROOM_COMPARATOR);
            timer.finish("SysSuComp");
            houses.sortBuble();
            timer.finish("BurBeComp");
            houses.sortBuble(House.AGE_COMPARATOR);
            timer.finish("BurSuComp");
            timer.seriesFinish();
        }
    }

    /**
     * Generates an ArrayList of random integers
     * @param number number of integers to generate
     * @return ArrayList with random integers
     */
    private ArrayList<Integer> generateIntegersArrayList(int number){
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < number; i++){
            list.add(new Integer(random.nextInt(5000)));
        }

        return list;
    }

    /**
     * Generates an LinkedList of random integers
     * @param number number of integers to generate
     * @return LinkedList with random integers
     */
    private LinkedList<Integer> generateIntegersLinkedList(int number){
        LinkedList<Integer> list = new LinkedList<Integer>();

        for(int i = 0; i < number; i++){
            list.add(new Integer(random.nextInt(5000)));
        }

        return list;
    }

    /**
     * Generates an array of random doubles
     * @param number number of integers to generate
     * @return array with random integers
     */
    private double[] generateDoubles(int number){
        double[] doubles = new double[number];

        for(int i = 0; i < number; i++){
            doubles[i] = random.nextDouble() * 5000;
        }

        return doubles;
    }

    /**
     * Generates a list of houses
     * @param number number of houses to generate
     * @return list with new houses
     */
    private ListKTU<House> generateHouses(int number){
        ListKTU<House> houses = new ListKTU<House>();

        for(int i = 0; i < number; i++){
            int numOfRooms = 5 + random.nextInt(45);
            int age = 1 + random.nextInt(49);
            double price = 1000 + random.nextInt(249000);
            double area = 10 + random.nextInt(190);

            houses.add(new House(numOfRooms, age, price, area));
        }

        return houses;
    }

    /**
     * Entry point of the program
     * @param args arguments for the program
     */
    public static void main(String[] args){
        Locale.setDefault(new Locale("LT"));
        new SpeedTest().test();
    }
}
