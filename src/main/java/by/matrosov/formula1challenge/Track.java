package by.matrosov.formula1challenge;

import java.util.*;

public class Track {

    private static final int trackLength = 10000; //m
    private static final int numberBolids = 6;

    public static void main(String[] args) {
        List<Bolid> bolidList = new ArrayList<>();
        List<Bolid> finishedList = new ArrayList<>();

        initBolids(bolidList);

        while (true){
            printInfo(bolidList);
            for (Bolid bolid : bolidList) {
                if (!bolid.isFinished()){
                    bolid.move(bolid.getDistance(), bolid.getSpeed());
                }
            }
            checkFinished(bolidList, finishedList);
            checkLastPositions(bolidList);
            checkAround10m(bolidList);
            //flf printInfo(bolidList);

            //stopped criterion
            int count = 0;
            for (Bolid bolid : bolidList) {
                if (!bolid.isFinished()){
                    count++;
                }
            }
            if (count == 1){
                System.out.println(finishedList);
                return;
            }
        }
    }

    private static void initBolids(List<Bolid> bolidList){
        double distance = 0;
        for (int i = 1; i <= Track.numberBolids; i++) {
            Bolid bolid = new Bolid(i, distance, 0, false);
            bolidList.add(bolid);
            distance = distance - 200;
        }
    }

    private static void checkLastPositions(List<Bolid> bolidList) {
        List<Double> distancesList = new ArrayList<>();
        for (Bolid bolid : bolidList) {
            if (!bolid.isFinished()){
                distancesList.add(bolid.getDistance());
            }
        }
        double minDist = Collections.min(distancesList);

        for (Bolid bolid : bolidList) {
            if (!bolid.isFinished()){
                if (bolid.getDistance() == minDist){
                    bolid.nitro(bolid.getSpeed());
                }
            }
        }
    }

    private static void checkAround10m(List<Bolid> bolidList){
        Set<Integer> numbersNearBolids = new HashSet<>();
        for (int i = 0; i < bolidList.size(); i++) {
            if (!bolidList.get(i).isFinished()){
                double minDist = bolidList.get(i).getDistance() - 10;
                double maxDist =  bolidList.get(i).getDistance() + 10;
                for (int j = 0; j < bolidList.size(); j++) {
                    if (j != i){
                        if (bolidList.get(j).getDistance() >= minDist && bolidList.get(j).getDistance() <= maxDist){
                            numbersNearBolids.add(i);
                            numbersNearBolids.add(j);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < bolidList.size(); i++) {
            if (numbersNearBolids.contains(i)){
                bolidList.get(i).speedReduce(bolidList.get(i).getSpeed());
            }
        }
    }

    private static void checkFinished(List<Bolid> bolidList, List<Bolid> finishedList){
        for (Bolid bolid : bolidList) {
            if (bolid.getDistance() >= trackLength){
                if (!bolid.isFinished()){
                    bolid.setFinished(true);
                    finishedList.add(bolid);
                }
            }
        }
    }

    private static void printInfo(List<Bolid> bolidList){
        for (Bolid bolid : bolidList) {
            System.out.println(bolid.toString());
        }
        System.out.println("-------------------------------------");
    }

}
