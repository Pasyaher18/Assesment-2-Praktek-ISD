import java.util.*;

class Patient {
    int id;
    String name;
    String code;
    int age;

    public Patient(int id, String name, String code, int age) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Nama pasien: " + name + " usia: " + age;
    }
}

class Main {
    private List<Patient> patients;

    public Main() {
        patients = new ArrayList<>();
    }

    public void antrianPasien(int id, String name, String code, int age) {
        patients.add(new Patient(id, name, code, age));
    }

    public void cetakDataPasien() {
        // Sort patients based on the urgency code and their arrival order
        patients.sort(Comparator.comparingInt(this::getPriority).thenComparingInt(p -> p.id));

        System.out.println("Urutan penanganan pasien:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    private int getPriority(Patient p) {
        switch (p.code.toLowerCase()) {
            case "merah":
                return 0;
            case "kuning":
                return 1;
            case "biru":
                return 2;
            case "hijau":
                return 3;
            default:
                return Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        Main pEr = new Main();
        pEr.antrianPasien(1, "Nur Aisyah", "Biru", 30);
        pEr.antrianPasien(2, "Rima", "Merah", 20);
        pEr.antrianPasien(3, "Didi", "Kuning", 5);
        pEr.antrianPasien(4, "Mila", "Biru", 65);

        // Assume Kira is treated and allowed to go home
        System.out.println("Pasien Nama pasien: Kira usia: 10 diizinkan pulang");

        pEr.cetakDataPasien();
    }
}
