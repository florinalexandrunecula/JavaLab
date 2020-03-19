package asociere;

public class Main {

    public static void main(String[] args) {

        Profesor profesorPrincipalMate = new Profesor(1, "Popescu");
        Profesor profesorSecundarMate = new Profesor(2, "Ionescu");
        Profesor profesorInfo = new Profesor(3, "Anghel");
        Profesor profesorMateSiInfo = new Profesor(4, "Petrescu");
        Profesor profesorInfosiMate = new Profesor(5, "Andrei");

        Departament departamentInfo = new Departament("info");
        departamentInfo.setProfesori(new Profesor[]{profesorInfo, profesorInfosiMate, profesorMateSiInfo});
        Departament departamentMate = new Departament("mate");
        departamentMate.setProfesori(new Profesor[]{profesorInfosiMate, profesorMateSiInfo, profesorPrincipalMate, profesorSecundarMate});

        Universitate unibuc = new Universitate("UNIBUC", new Departament[]{departamentInfo, departamentMate});

        System.out.println(unibuc);

        departamentInfo = null;
        System.out.println(unibuc);

        System.out.println(departamentMate);
        departamentMate.getProfesori()[3] = null;
        System.out.println(departamentMate);
        System.out.println(profesorSecundarMate);
    }
}
