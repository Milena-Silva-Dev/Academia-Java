package imc;

public class Principal {
    public static void main(String[] args) {
        Paciente paciente1 = new Paciente("Milena", 1.65, 52);
        Paciente paciente2 = new Paciente("Gabi", 1.75, 70);
        Paciente paciente3 = new Paciente("Ana Cristina", 1.99, 90);

        System.out.println(paciente1);
        System.out.println(paciente2);
        System.out.println(paciente3);
    }
}
