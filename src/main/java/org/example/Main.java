package org.example;

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

        String[] firstNames = NameRepository.findByFirstName("Zeq");

        for(String name : firstNames){
            System.out.println("Name:" + name);
        }

    }
}