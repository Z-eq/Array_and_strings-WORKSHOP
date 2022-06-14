package org.example;

public class NameRepository {
    //Our internal array
    private static String[] names;


    public NameRepository() {
        names = new String[1];
    }

    public NameRepository(String[] tmp) {
        names = new String[1];
        setNames(tmp);
    }

    /*
     * Returns the length of names.
     */
    public static int getSize() {
        return names.length;
    }

    /*
     *  Deep copy of string array to the object
     */
    public static void setNames(String[] names2) {
        if (names.length < names2.length) {
            // expand the internal array
            names = new String[names2.length];
        }
        for (int n = 0; n < names2.length; n++) {
            names[n] = names2[n];
        }
    }

    /*
     * Clears all the names in the array
     */
    public static void clear() {
        names = new String[1];
    }

    /*
     * Returns all the names in the array
     */
    public static String[] findAll() {
        return names;
    }

    /*
     *   Finds a name in the database
       @return null if no name is found

     */
    public static String find(final String fullName) {
        for (int n = 0; n < names.length; n++) {
            if (names[n] == fullName) {
                return names[n];
            }
        }
        return null;
    }

    /*
     *  This method adds another name to the database
     *  @return true if added
     */
    public static boolean add(final String fullName) {
        if (find(fullName) == null) {
            //adding the name here
            String[] names2 = new String[names.length + 1];
            for (int n = 0; n < names.length; n++) {
                names2[n] = names[n];
            }
            names2[names2.length - 1] = fullName;
            names = names2;
            return true;
        } else {
            return false;
        }
    }

    /*
     *  This method finds all names by first name
     */
    public static String[] findByFirstName(final String firstName) {
        int counter = 0;
        for (String fullName : names) {
            if (fullName.startsWith(firstName)) {
                counter++;
            }
        }
        String[] tmp = new String[counter];
        counter = 0;
        for (String fullName : names) {
            if (fullName.startsWith(firstName)) {
                tmp[counter++] = fullName;
            }
        }
        return tmp;
    }

    //This method finds the last name occurence
    public static String[] findByLastName(final String lastName) {

        int counter = 0;

        for (String fullName : names) {
            // "Firstname lastname"
            // fullNames[0]   fullNames[1]
            //{"Firstname", "lastname"}
            String[] fullNames = fullName.split(" ");
            if(fullNames[1].startsWith(lastName)){
                counter++;
            }
        }
        String[] tmp = new String[counter];
        counter = 0;
        for (String fullName : names) {
            String[] fullNames = fullName.split(" ");
            if(fullNames[1].startsWith(lastName)){
                tmp[counter++] = fullName;
            }
        }
        return tmp;
    }

    // Updates the name of the search criteria [firstname}           {firstname lastname}
    public static boolean update(final String original, final String updatedName) {
        for(int n = 0; n < names.length; n++){
            //{"Firstname Lastname"}
            //
            if(names[n].startsWith(original)){
                names[n] = updatedName;
                return true;
            }
        }
        return false;
    }

    public static void printAll(){
        System.out.println("Names in the array:");
        for(int n = 0; n < names.length; n++){
            System.out.println("n=" + n + " name=\"" + names[n] + "\"");
        }
    }
}
