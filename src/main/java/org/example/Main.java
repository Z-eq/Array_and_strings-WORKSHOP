package org.example;

import javax.naming.Name;

public class Main {
    public static void main(String[] args) {
        NameRepository nr = new NameRepository();
        String[] tmp = new String[]{
                "Zeq Alidemaj",
                "Jonas Eira"
        };
        NameRepository nr1 = new NameRepository(tmp);
        NameRepository.add("Simon Elbrink");
        NameRepository.add("John Mayer");

        for(String name : NameRepository.findAll()){
            System.out.println("Name:" + name);
        }
        System.out.println("Names size = " + NameRepository.getSize());

        // ------------ Firstnames
        String firstName = "Zeq";
        String[] firstNames = NameRepository.findByFirstName(firstName);

        for(String name : firstNames){
            System.out.println("Names containing firstName " + firstName + " is " + name);
        }
        // ------------ Secondnames
        String secondName = "Eira";
        String[] secondNames = NameRepository.findByLastName(secondName);

        for(String name : secondNames){
            System.out.println("Names containing last name " + secondName + " is " + name);
        }

        // ------------ Updates
                        // {"Firstname Lastname"}
        NameRepository.add("Börje Andersson");
        NameRepository.printAll();
                        //          {"Firstname"}       {"Firstname lastname"}
        NameRepository.update("Börje", "Börje Svensson");
        NameRepository.printAll();

    }
}