package ex1;

import org.junit.jupiter.api.Assertions;


class HashTableTest {

    //Demuestro que el ITEMS++ puede sumar cuando introduzco valores
    @org.junit.jupiter.api.Test
    void count() {
        HashTable hashTable = new HashTable();
        hashTable.put("22", "30");
        hashTable.put("45", "51");
        Assertions.assertEquals(2, hashTable.count());
    }

    //Si meto una fila diferente a 16 el codigo peta
    @org.junit.jupiter.api.Test
    void size() {
        HashTable hashTable = new HashTable();
        Assertions.assertEquals(16, hashTable.size());
    }

    //cuando introduzco el mismo valor veo que reemplaza al otro
    @org.junit.jupiter.api.Test
    void put() {
        HashTable hashTable = new HashTable();
        hashTable.put("hola", "a");
        hashTable.put("hola", "b");
        Assertions.assertEquals("\n bucket[12] = [hola, b]",hashTable.toString());
    }

    //Creo un valor y busco si esta en la misma linea y si no está me retorna null
    @org.junit.jupiter.api.Test
    void get() {
        HashTable hashTable = new HashTable();
        hashTable.put("2","hola");
        Assertions.assertEquals(null, hashTable.get("13"));
    }

    @org.junit.jupiter.api.Test
    void drop() {
        //Le introduzco un valor a cada key
        HashTable hashTable = new HashTable();
        hashTable.put("5","a");
        hashTable.put("16","e");
        hashTable.put("27","h");
        hashTable.put("6","b");
        hashTable.put("17","f");
        hashTable.put("28","i");
        hashTable.put("7","c");
        hashTable.put("18","g");
        hashTable.put("29","j");
        hashTable.put("8","d");

        //imprimo la hashtable con sus valores
        Assertions.assertEquals("\n" + " bucket[5] = [5, a] -> [16, e] -> [27, h]\n" + " bucket[6] = [6, b] -> [17, f] -> [28, i]\n" + " bucket[7] = [7, c] -> [18, g] -> [29, j]\n" + " bucket[8] = [8, d]", hashTable.toString());

        //me cargo contenido de la hashtable
        hashTable.drop("6");
        hashTable.drop("16");
        hashTable.drop("29");

        //imprimo el contenido de la hashtable con el contenido que he quitado
        Assertions.assertEquals("\n" + " bucket[5] = [5, a] -> [27, h]\n" + " bucket[6] = [17, f] -> [28, i]\n" + " bucket[7] = [7, c] -> [18, g]\n" + " bucket[8] = [8, d]",hashTable.toString());
        Assertions.assertEquals(7,hashTable.count());
    }
}