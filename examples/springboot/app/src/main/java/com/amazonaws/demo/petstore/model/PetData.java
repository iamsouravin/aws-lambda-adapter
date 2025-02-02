package com.amazonaws.demo.petstore.model;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


public class PetData {
    private static List<String> breeds = new ArrayList<>();
    static {
        breeds.add("Afghan Hound");
        breeds.add("Beagle");
        breeds.add("Bernese Mountain Dog");
        breeds.add("Bloodhound");
        breeds.add("Dalmatian");
        breeds.add("Jack Russell Terrier");
        breeds.add("Norwegian Elkhound");
    }

    private static Map<String, String> imgs = new HashMap<>();
    static {
        imgs.put(breeds.get(0), "/images/afghanhound.jpg");
        imgs.put(breeds.get(1), "/images/beagle.jpg");
        imgs.put(breeds.get(2), "/images/bernesemountaindog.jpg");
        imgs.put(breeds.get(3), "/images/bloodhound.jpg");
        imgs.put(breeds.get(4), "/images/dalmatian.jpg");
        imgs.put(breeds.get(5), "/images/jackrussellterrier.jpg");
        imgs.put(breeds.get(6), "/images/norwegianelkhound.jpg");
    }

    private static List<String> names = new ArrayList<>();
    static {
        names.add("Bailey");
        names.add("Bella");
        names.add("Max");
        names.add("Lucy");
        names.add("Charlie");
        names.add("Molly");
        names.add("Buddy");
        names.add("Daisy");
        names.add("Rocky");
        names.add("Maggie");
        names.add("Jake");
        names.add("Sophie");
        names.add("Jack");
        names.add("Sadie");
        names.add("Toby");
        names.add("Chloe");
        names.add("Cody");
        names.add("Bailey");
        names.add("Buster");
        names.add("Lola");
        names.add("Duke");
        names.add("Zoe");
        names.add("Cooper");
        names.add("Abby");
        names.add("Riley");
        names.add("Ginger");
        names.add("Harley");
        names.add("Roxy");
        names.add("Bear");
        names.add("Gracie");
        names.add("Tucker");
        names.add("Coco");
        names.add("Murphy");
        names.add("Sasha");
        names.add("Lucky");
        names.add("Lily");
        names.add("Oliver");
        names.add("Angel");
        names.add("Sam");
        names.add("Princess");
        names.add("Oscar");
        names.add("Emma");
        names.add("Teddy");
        names.add("Annie");
        names.add("Winston");
        names.add("Rosie");
    }

    public static List<String> getBreeds() {
        return breeds;
    }

    public static List<String> getNames() {
        return names;
    }

    public static String getRandomBreed() {
        return breeds.get(ThreadLocalRandom.current().nextInt(0, breeds.size()));
    }

    public static String getRandomName() {
        return names.get(ThreadLocalRandom.current().nextInt(0, names.size()));
    }

    public static Date getRandomDoB() {
        GregorianCalendar gc = new GregorianCalendar();

        int year = ThreadLocalRandom.current().nextInt(
                Calendar.getInstance().get(Calendar.YEAR) - 15,
                Calendar.getInstance().get(Calendar.YEAR)
        );

        gc.set(Calendar.YEAR, year);

        int dayOfYear = ThreadLocalRandom.current().nextInt(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));

        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
        return gc.getTime();
    }
    
    public static String getImgUrlForBreed(String breed) {
        return imgs.get(breed);
    }
}
