package fes.aragon.clases;

public class Lista {

    private Integer[] numeros;

    public Lista(Integer[] numeros) {
        this.numeros = numeros;
    }

    public Integer valorMayor() {
        Integer r = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (r < numeros[i]) {
                r = numeros[i];
            }
        }
        return r;
    }

    public Integer valorMenor() {
        Integer r = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (r > numeros[i]) {
                r = numeros[i];
            }
        }
        return r;
    }
    
    public Integer valorMedio(){
        return ordenaMayor()[(numeros.length)/2];
    }

    public Integer[] ordenaMayor() {
        Integer[] numerosM = numeros;
        int pos, aux;
        for (int i = 0; i < numerosM.length; i++) {
            pos = i;
            aux = numerosM[i];
            while (pos > 0 && numerosM[pos - 1] < aux) {
                numerosM[i] = numerosM[pos - 1];
                pos--;
            }
            numerosM[pos] = aux;
        }
        return numerosM;
    }

    public Integer[] ordenaMenor() {
        Integer[] numerosM = numeros;
        int pos, aux;
        for (int i = 0; i < numerosM.length; i++) {
            pos = i;
            aux = numerosM[i];
            while (pos > 0 && numerosM[pos - 1] > aux) {
                numerosM[i] = numerosM[pos - 1];
                pos--;
            }
            numerosM[pos] = aux;
        }
        return numerosM;
    }

    public float promedio() {
        float prom = 0f;
        for (int i = 0; i < numeros.length; i++) {
            prom += numeros[i].floatValue();
        }
        return (prom / numeros.length);
    }
    
    public String mostarLista(){
        String cadenaComa = "";
        for (int i = 0; i < numeros.length; i++) {
            cadenaComa+= numeros[i].toString() + ";";
        }
        return cadenaComa;
    }

    public static void main(String[] args) {
        Integer[] numeros = {10, 20, 10, 50, 10, 40, 20, 30};
        Lista list = new Lista(numeros);
        System.out.println("El valor mayor: " + list.valorMayor());
        System.out.println("El valor menor: " + list.valorMenor());
        System.out.println("El valor medio: " + list.valorMedio());
        System.out.println("Ordenados de mayor a menor:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(list.ordenaMayor()[i] + " ");
        }

        System.out.println("\nOrdenados de menor a mayor:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(list.ordenaMenor()[i] + " ");
        }
        
        System.out.println("\nPromedio: " + list.promedio());
        System.out.println("Numeros separados por comas:");
        System.out.println(list.mostarLista());
    }

}
