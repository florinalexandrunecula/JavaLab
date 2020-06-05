package guiRUN;

import database.Database;
import model.*;
import serviciu.angajati.ServiciuAngajati;
import serviciu.gestiuneConcedii.ServiciuGestiuneConcedii;
import serviciu.gestiuneFirma.ServiciuGestiuneFirma;
import util.Reader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Gui {

    Database db;
    GestiuneFirma gestiuneFirma;

    public Gui(){
        db = new Database();

    }

    public void run(){
        JFrame initialWindow = new JFrame();

        JLabel label1 = new JLabel("Gestiune Firma");
        label1.setBounds(150,50, 100,30);

        JButton createCompany = new JButton("Setup companie");
        createCompany.setBounds(100, 100, 200, 40);

        JButton administrateCompany = new JButton("Administreaza companie");
        administrateCompany.setBounds(100, 140, 200, 40);

        createCompany.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initialWindow.dispose();
                JFrame createWindow = new JFrame();
                createWindowSetup(createWindow);
            }
        });

        administrateCompany.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initialWindow.dispose();
                JFrame adminWindow = new JFrame();
                createAdminWindow(adminWindow);
            }
        });

        initialWindow.add(createCompany);
        initialWindow.add(administrateCompany);
        initialWindow.add(label1);
        initialWindow.setSize(400, 400);
        initialWindow.setLayout(null);
        initialWindow.setVisible(true);
    }

    private void createAdminWindow(JFrame adminWindow) {
        ServiciuAngajati S1 = new ServiciuAngajati();
        ServiciuGestiuneConcedii S2 = new ServiciuGestiuneConcedii();
        ServiciuGestiuneFirma S3 = new ServiciuGestiuneFirma();

        JLabel label1 = new JLabel("Administrare companie");
        label1.setBounds(0,0,200,30);
        adminWindow.add(label1);

        JButton exitButton = new JButton("Back");
        exitButton.setBounds(200, 0, 200, 30);
        adminWindow.add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminWindow.dispose();
                run();
            }
        });

        JLabel createDatabase = new JLabel("Introdu numele bazei de date: ");
        createDatabase.setBounds(0,30, 200,30);
        adminWindow.add(createDatabase);

        JTextField databaseName = new JTextField("");
        databaseName.setBounds(200,30,200,30);
        adminWindow.add(databaseName);

        JButton firma = new JButton("Genereaza firma pornind de la baza de date");
        firma.setBounds(0, 60, firma.getPreferredSize().width, firma.getPreferredSize().height);
        adminWindow.add(firma);

        firma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = databaseName.getText();
                Angajat[] angajati = db.readAllEmployees(fileName);
                try {
                    gestiuneFirma = S3.creeazaOFirma(db.readCompanyNames(fileName)[0], angajati);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton calculare = new JButton("Calculeaza salariile");
        calculare.setBounds(0, 90, 200 ,30);
        adminWindow.add(calculare);

        calculare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = databaseName.getText();
                Angajat[] angajati = db.readAllEmployees(fileName);
                try {
                    S3.calculeazaSalarii(gestiuneFirma);
                    // calculam salariile si apoi le trecem in baza de date -> facem update
                    for (Angajat an : gestiuneFirma.getAngajati()){
                        if (an instanceof CTO){
                            db.updateCTO(an.getNume(), an.getPrenume(), an.getNume(), an.getPrenume(), an.getVechime(), an.getAnAngajare(), an.getSalariuCalculat(), fileName);
                        }
                        if (an instanceof SoftDev){
                            int works;
                            if (((SoftDev) an).munceste()){
                                works = 1;
                            } else{
                                works = 0;
                            }
                            db.updateSoftDev(an.getNume(), an.getPrenume(), an.getNume(), an.getPrenume(), an.getVechime(), an.getAnAngajare(), works, an.getSalariuCalculat(), fileName);
                        }
                        if (an instanceof ProjMan){
                            db.updateProjectManager(an.getNume(), an.getPrenume(), an.getNume(), an.getPrenume(), an.getVechime(), an.getAnAngajare(), ((ProjMan) an).getProiect(), an.getSalariuCalculat(), fileName);
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton angajeaza = new JButton("Angajeaza");
        angajeaza.setBounds(0, 120, 200, 30);
        adminWindow.add(angajeaza);

        angajeaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminWindow.dispose();
                JFrame hireWindow = new JFrame();
                createHireWindow(hireWindow);
            }
        });

        JButton concediaza = new JButton("Concediaza");
        concediaza.setBounds(0, 150, 200, 30);
        adminWindow.add(concediaza);

        concediaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminWindow.dispose();
                JFrame fireWindow = new JFrame();
                createFireWindow(fireWindow);
            }
        });

        JButton afisareFirma = new JButton("Afisare firma");
        afisareFirma.setBounds(0, 180, 200, 30);
        adminWindow.add(afisareFirma);

        afisareFirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JTextArea firma = new JTextArea("Ana are mere");
                Angajat[] angajati = db.readAllEmployees(databaseName.getText());
                String to_write = "";
                for (Angajat an : angajati){
                    to_write += an.toString();
                    to_write += "\n";
                }
                JTextArea firma = new JTextArea(to_write);
                firma.setBounds(0, 210, firma.getPreferredSize().width, firma.getPreferredSize().height);
                adminWindow.add(firma);
                adminWindow.setVisible(false);
                adminWindow.setVisible(true);
            }
        });

        adminWindow.setSize(900,500);
        adminWindow.setLayout(null);
        adminWindow.setVisible(true);
    }

    private void createFireWindow(JFrame fireWindow) {
        ServiciuAngajati S1 = new ServiciuAngajati();
        ServiciuGestiuneConcedii S2 = new ServiciuGestiuneConcedii();
        ServiciuGestiuneFirma S3 = new ServiciuGestiuneFirma();

        JLabel label1 = new JLabel("Angajeaza");
        label1.setBounds(0, 0, 200 ,30);
        fireWindow.add(label1);

        JButton exitButton = new JButton("Back");
        exitButton.setBounds(200, 0, 200, 30);
        fireWindow.add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireWindow.dispose();
                JFrame adminWindow = new JFrame();
                createAdminWindow(adminWindow);
            }
        });

        JLabel typeOfEmployee = new JLabel("Tipul angajatului: (ProjMan, SoftDev) ");
        typeOfEmployee.setBounds(0,30, typeOfEmployee.getPreferredSize().width,typeOfEmployee.getPreferredSize().height);
        fireWindow.add(typeOfEmployee);

        JTextField type = new JTextField("");
        type.setBounds(typeOfEmployee.getPreferredSize().width,30,200,30);
        fireWindow.add(type);

        JLabel numeLabel = new JLabel("Nume: ");
        numeLabel.setBounds(0,60, numeLabel.getPreferredSize().width,numeLabel.getPreferredSize().height);
        fireWindow.add(numeLabel);

        JTextField nume = new JTextField("");
        nume.setBounds(numeLabel.getPreferredSize().width,60,200,30);
        fireWindow.add(nume);

        JLabel prenumeLabel = new JLabel("Prenume: ");
        prenumeLabel.setBounds(0,90, prenumeLabel.getPreferredSize().width,prenumeLabel.getPreferredSize().height);
        fireWindow.add(prenumeLabel);

        JTextField prenume = new JTextField("");
        prenume.setBounds(prenumeLabel.getPreferredSize().width,90,200,30);
        fireWindow.add(prenume);

        JLabel vechimeLabel = new JLabel("Vechime: ");
        vechimeLabel.setBounds(0,120, vechimeLabel.getPreferredSize().width,vechimeLabel.getPreferredSize().height);
        fireWindow.add(vechimeLabel);

        JTextField vechime = new JTextField("");
        vechime.setBounds(vechimeLabel.getPreferredSize().width,120,200,30);
        fireWindow.add(vechime);

        JLabel anAngajareLabel = new JLabel("An angajare: ");
        anAngajareLabel.setBounds(0,150, anAngajareLabel.getPreferredSize().width,anAngajareLabel.getPreferredSize().height);
        fireWindow.add(anAngajareLabel);

        JTextField anAngajare = new JTextField("");
        anAngajare.setBounds(anAngajareLabel.getPreferredSize().width,150,200,30);
        fireWindow.add(anAngajare);

        JLabel muncesteLabel = new JLabel("Munceste (1, 0): ");
        muncesteLabel.setBounds(0,180, muncesteLabel.getPreferredSize().width,muncesteLabel.getPreferredSize().height);
        fireWindow.add(muncesteLabel);

        JTextField munceste = new JTextField("");
        munceste.setBounds(muncesteLabel.getPreferredSize().width,180,200,30);
        fireWindow.add(munceste);

        JLabel proiectLabel = new JLabel("Proiect: ");
        proiectLabel.setBounds(0,210, proiectLabel.getPreferredSize().width,proiectLabel.getPreferredSize().height);
        fireWindow.add(proiectLabel);

        JTextField proiect = new JTextField("");
        proiect.setBounds(proiectLabel.getPreferredSize().width,210,200,30);
        fireWindow.add(proiect);

        JButton concediaza = new JButton("Concediaza");
        concediaza.setBounds(0, 240, 200, 30);
        fireWindow.add(concediaza);

        JLabel createDatabase = new JLabel("Introdu numele bazei de date: ");
        createDatabase.setBounds(0,270, 200,30);
        fireWindow.add(createDatabase);

        JTextField databaseName = new JTextField("");
        databaseName.setBounds(200,270,200,30);
        fireWindow.add(databaseName);

        concediaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Angajat an = null;
                if (type.getText().equals("SoftDev")){
                    boolean bool;
                    bool = Integer.parseInt(munceste.getText()) != 0;
                    an = new SoftDev(nume.getText(), prenume.getText(), Integer.parseInt(vechime.getText()), Integer.parseInt(anAngajare.getText()), "SoftDev", bool);
                    db.deleteSoftDev(nume.getText(), prenume.getText(), databaseName.getText());
                } else{
                    an = new ProjMan(nume.getText(), prenume.getText(), Integer.parseInt(vechime.getText()), Integer.parseInt(anAngajare.getText()), "ProjMan", proiect.getText());
                    db.deleteProjectManager(nume.getText(), prenume.getText(), databaseName.getText());
                }
                try {
                    S1.concediaza(gestiuneFirma, an);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        fireWindow.setSize(900,500);
        fireWindow.setLayout(null);
        fireWindow.setVisible(true);
    }

    private void createHireWindow(JFrame hireWindow) {
        ServiciuAngajati S1 = new ServiciuAngajati();
        ServiciuGestiuneConcedii S2 = new ServiciuGestiuneConcedii();
        ServiciuGestiuneFirma S3 = new ServiciuGestiuneFirma();

        JLabel label1 = new JLabel("Angajeaza");
        label1.setBounds(0, 0, 200 ,30);
        hireWindow.add(label1);

        JButton exitButton = new JButton("Back");
        exitButton.setBounds(200, 0, 200, 30);
        hireWindow.add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hireWindow.dispose();
                JFrame adminWindow = new JFrame();
                createAdminWindow(adminWindow);
            }
        });

        JLabel typeOfEmployee = new JLabel("Tipul angajatului: (ProjMan, SoftDev) ");
        typeOfEmployee.setBounds(0,30, typeOfEmployee.getPreferredSize().width,typeOfEmployee.getPreferredSize().height);
        hireWindow.add(typeOfEmployee);

        JTextField type = new JTextField("");
        type.setBounds(typeOfEmployee.getPreferredSize().width,30,200,30);
        hireWindow.add(type);

        JLabel numeLabel = new JLabel("Nume: ");
        numeLabel.setBounds(0,60, numeLabel.getPreferredSize().width,numeLabel.getPreferredSize().height);
        hireWindow.add(numeLabel);

        JTextField nume = new JTextField("");
        nume.setBounds(numeLabel.getPreferredSize().width,60,200,30);
        hireWindow.add(nume);

        JLabel prenumeLabel = new JLabel("Prenume: ");
        prenumeLabel.setBounds(0,90, prenumeLabel.getPreferredSize().width,prenumeLabel.getPreferredSize().height);
        hireWindow.add(prenumeLabel);

        JTextField prenume = new JTextField("");
        prenume.setBounds(prenumeLabel.getPreferredSize().width,90,200,30);
        hireWindow.add(prenume);

        JLabel vechimeLabel = new JLabel("Vechime: ");
        vechimeLabel.setBounds(0,120, vechimeLabel.getPreferredSize().width,vechimeLabel.getPreferredSize().height);
        hireWindow.add(vechimeLabel);

        JTextField vechime = new JTextField("");
        vechime.setBounds(vechimeLabel.getPreferredSize().width,120,200,30);
        hireWindow.add(vechime);

        JLabel anAngajareLabel = new JLabel("An angajare: ");
        anAngajareLabel.setBounds(0,150, anAngajareLabel.getPreferredSize().width,anAngajareLabel.getPreferredSize().height);
        hireWindow.add(anAngajareLabel);

        JTextField anAngajare = new JTextField("");
        anAngajare.setBounds(anAngajareLabel.getPreferredSize().width,150,200,30);
        hireWindow.add(anAngajare);

        JLabel muncesteLabel = new JLabel("Munceste (1, 0): ");
        muncesteLabel.setBounds(0,180, muncesteLabel.getPreferredSize().width,muncesteLabel.getPreferredSize().height);
        hireWindow.add(muncesteLabel);

        JTextField munceste = new JTextField("");
        munceste.setBounds(muncesteLabel.getPreferredSize().width,180,200,30);
        hireWindow.add(munceste);

        JLabel proiectLabel = new JLabel("Proiect: ");
        proiectLabel.setBounds(0,210, proiectLabel.getPreferredSize().width,proiectLabel.getPreferredSize().height);
        hireWindow.add(proiectLabel);

        JTextField proiect = new JTextField("");
        proiect.setBounds(proiectLabel.getPreferredSize().width,210,200,30);
        hireWindow.add(proiect);

        JButton angajeaza = new JButton("Angajeaza");
        angajeaza.setBounds(0, 240, 200, 30);
        hireWindow.add(angajeaza);

        JLabel createDatabase = new JLabel("Introdu numele bazei de date: ");
        createDatabase.setBounds(0,270, 200,30);
        hireWindow.add(createDatabase);

        JTextField databaseName = new JTextField("");
        databaseName.setBounds(200,270,200,30);
        hireWindow.add(databaseName);

        angajeaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Angajat an = null;
                if (type.getText().equals("SoftDev")){
                    boolean bool;
                    bool = Integer.parseInt(munceste.getText()) != 0;
                    an = new SoftDev(nume.getText(), prenume.getText(), Integer.parseInt(vechime.getText()), Integer.parseInt(anAngajare.getText()), "SoftDev", bool);
                    db.insertSoftDev(nume.getText(), prenume.getText(), Integer.parseInt(vechime.getText()), Integer.parseInt(anAngajare.getText()), "SoftDev", Integer.parseInt(munceste.getText()), 0, databaseName.getText());
                } else{
                    an = new ProjMan(nume.getText(), prenume.getText(), Integer.parseInt(vechime.getText()), Integer.parseInt(anAngajare.getText()), "ProjMan", proiect.getText());
                    db.insertProjectManager(nume.getText(), prenume.getText(), Integer.parseInt(vechime.getText()), Integer.parseInt(anAngajare.getText()), "ProjMan", proiect.getText(), 0, databaseName.getText());
                }
                try {
                    S1.adaugaAngajat(gestiuneFirma, an);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        hireWindow.setSize(900,500);
        hireWindow.setLayout(null);
        hireWindow.setVisible(true);
    }

    public void createWindowSetup(JFrame createWindow) {
        JLabel label1 = new JLabel("Setup Companie");
        label1.setBounds(0, 0, 200 ,30);
        createWindow.add(label1);

        JButton exitButton = new JButton("Back");
        exitButton.setBounds(200, 0, 200, 30);
        createWindow.add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createWindow.dispose();
                run();
            }
        });

        JLabel createDatabase = new JLabel("Introdu numele bazei de date: ");
        createDatabase.setBounds(0,30, 200,30);
        createWindow.add(createDatabase);

        JTextField databaseName = new JTextField("");
        databaseName.setBounds(200,30,200,30);
        createWindow.add(databaseName);

        JButton createDb = new JButton("Genereaza baza de date");
        createDb.setBounds(0, 60, 200, 30);
        createWindow.add(createDb);

        createDb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = databaseName.getText();
                db.createDatabase(name);
                db.createTables(name);
                JLabel label2 = new JLabel("Succes!...");
                label2.setBounds(0, 90, 200, 30);
                createWindow.add(label2);
                createWindow.setVisible(false);
                createWindow.setVisible(true);
            }
        });

        JLabel label3 = new JLabel("Populeaza baza de date");
        label3.setBounds(0, 120, 200 ,30);
        createWindow.add(label3);

        JButton createTables = new JButton("Genereaza tabelele initiale");
        createTables.setBounds(0, 150, 200, 30);
        createWindow.add(createTables);

        createTables.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reader Cititorul = Reader.getInstance();
                String[][] CompanyNames = Cititorul.readContent("CompanyNames.csv");
                String[][] CTOs = Cititorul.readContent("CTOs.csv");
                String[][] ProjectManagers = Cititorul.readContent("ProjectManagers.csv");
                String[][] SoftDevs = Cititorul.readContent("SoftDevs.csv");
                db.insertSoftDev(SoftDevs[0][0], SoftDevs[0][1], Integer.parseInt(SoftDevs[0][2]), Integer.parseInt(SoftDevs[0][3]), SoftDevs[0][4], Integer.parseInt(SoftDevs[0][5]), 0, databaseName.getText());
                db.insertSoftDev(SoftDevs[1][0], SoftDevs[1][1], Integer.parseInt(SoftDevs[1][2]), Integer.parseInt(SoftDevs[1][3]), SoftDevs[1][4], Integer.parseInt(SoftDevs[1][5]), 0, databaseName.getText());
                db.insertProjectManager(ProjectManagers[0][0], ProjectManagers[0][1], Integer.parseInt(ProjectManagers[0][2]), Integer.parseInt(ProjectManagers[0][3]), ProjectManagers[0][4], ProjectManagers[0][5], 0, databaseName.getText());
                db.insertCTO(CTOs[0][0], CTOs[0][1], Integer.parseInt(CTOs[0][2]), Integer.parseInt(CTOs[0][3]), CTOs[0][4], 0, databaseName.getText());
                db.insertCompanyName(CompanyNames[0][0], databaseName.getText());
                db.insertSoftDev(SoftDevs[2][0], SoftDevs[2][1], Integer.parseInt(SoftDevs[2][2]), Integer.parseInt(SoftDevs[2][3]), SoftDevs[2][4], Integer.parseInt(SoftDevs[2][5]), 0, databaseName.getText());
                db.insertSoftDev(SoftDevs[3][0], SoftDevs[3][1], Integer.parseInt(SoftDevs[3][2]), Integer.parseInt(SoftDevs[3][3]), SoftDevs[3][4], Integer.parseInt(SoftDevs[3][5]), 0, databaseName.getText());
                db.insertSoftDev(SoftDevs[4][0], SoftDevs[4][1], Integer.parseInt(SoftDevs[4][2]), Integer.parseInt(SoftDevs[4][3]), SoftDevs[4][4], Integer.parseInt(SoftDevs[4][5]), 0, databaseName.getText());
                db.insertProjectManager(ProjectManagers[1][0], ProjectManagers[1][1], Integer.parseInt(ProjectManagers[1][2]), Integer.parseInt(ProjectManagers[1][3]), ProjectManagers[1][4], ProjectManagers[1][5], 0, databaseName.getText());
                JLabel label4 = new JLabel("Succes!...");
                label4.setBounds(0, 180, 200, 30);
                createWindow.add(label4);
                createWindow.setVisible(false);
                createWindow.setVisible(true);
            }
        });

        JLabel label5 = new JLabel("Afisare tabel");
        label5.setBounds(0, 210, 200 ,30);
        createWindow.add(label5);

        JLabel label6 = new JLabel("Introdu numele tabelului (CTOs, CompanyNames, ProjectManagers, SoftDevs): ");
        label6.setBounds(0,240, 450,30);
        createWindow.add(label6);

        JTextField table = new JTextField("");
        table.setBounds(450,240,200,30);
        createWindow.add(table);

        JButton afisareTabel = new JButton("Afiseaza tabelul specificat mai sus");
        afisareTabel.setBounds(0, 270, afisareTabel.getPreferredSize().width, afisareTabel.getPreferredSize().height);
        createWindow.add(afisareTabel);

        afisareTabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Arrays.toString(MyDB.readCompanyNames());
                String option = table.getText();
                if (option.equals("CTOs")){
                    int i;
                    String to_print = "";
                    for(i = 0; i < db.readCTOs(databaseName.getText()).length; i++){
                        to_print += db.readCTOs(databaseName.getText())[i];
                        to_print += "\n";
                    }
                    JTextArea query = new JTextArea(to_print);
                    query.setBounds(0, 300, query.getPreferredSize().width, query.getPreferredSize().height);
                    createWindow.add(query);
                    createWindow.setVisible(false);
                    createWindow.setVisible(true);
                    JButton exit = new JButton("X");
                    exit.setBounds(query.getPreferredSize().width, 300, exit.getPreferredSize().width, exit.getPreferredSize().height);
                    createWindow.add(exit);
                    exit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            createWindow.remove(query);
                            createWindow.remove(exit);
                            createWindow.revalidate();
                            createWindow.repaint();
                        }
                    });
                }

                if (option.equals("CompanyNames")){
                    int i;
                    String to_print = "";
                    for(i = 0; i < db.readCompanyNames(databaseName.getText()).length; i++){
                        to_print += db.readCompanyNames(databaseName.getText())[i];
                        to_print += "\n";
                    }
                    JTextArea query = new JTextArea(to_print);
                    query.setBounds(0, 300, query.getPreferredSize().width, query.getPreferredSize().height);
                    createWindow.add(query);
                    createWindow.setVisible(false);
                    createWindow.setVisible(true);
                    JButton exit = new JButton("X");
                    exit.setBounds(query.getPreferredSize().width, 300, exit.getPreferredSize().width, exit.getPreferredSize().height);
                    createWindow.add(exit);
                    exit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            createWindow.remove(query);
                            createWindow.remove(exit);
                            createWindow.revalidate();
                            createWindow.repaint();
                        }
                    });
                }

                if (option.equals("ProjectManagers")){
                    int i;
                    String to_print = "";
                    for(i = 0; i < db.readProjectManagers(databaseName.getText()).length; i++){
                        to_print += db.readProjectManagers(databaseName.getText())[i];
                        to_print += "\n";
                    }
                    JTextArea query = new JTextArea(to_print);
                    query.setBounds(0, 300, query.getPreferredSize().width, query.getPreferredSize().height);
                    createWindow.add(query);
                    createWindow.setVisible(false);
                    createWindow.setVisible(true);
                    JButton exit = new JButton("X");
                    exit.setBounds(query.getPreferredSize().width, 300, exit.getPreferredSize().width, exit.getPreferredSize().height);
                    createWindow.add(exit);
                    exit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            createWindow.remove(query);
                            createWindow.remove(exit);
                            createWindow.revalidate();
                            createWindow.repaint();
                        }
                    });
                }

                if (option.equals("SoftDevs")){
                    int i;
                    String to_print = "";
                    for(i = 0; i < db.readSoftDevs(databaseName.getText()).length; i++){
                        to_print += db.readSoftDevs(databaseName.getText())[i];
                        to_print += "\n";
                    }
                    JTextArea query = new JTextArea(to_print);
                    query.setBounds(0, 300, query.getPreferredSize().width, query.getPreferredSize().height);
                    createWindow.add(query);
                    createWindow.setVisible(false);
                    createWindow.setVisible(true);
                    JButton exit = new JButton("X");
                    exit.setBounds(query.getPreferredSize().width, 300, exit.getPreferredSize().width, exit.getPreferredSize().height);
                    createWindow.add(exit);
                    exit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            createWindow.remove(query);
                            createWindow.remove(exit);
                            createWindow.revalidate();
                            createWindow.repaint();
                        }
                    });
                }
            }
        });

        createWindow.setSize(900,500);
        createWindow.setLayout(null);
        createWindow.setVisible(true);
    }

    public static void main(String[] args) {

        Gui MyGui = new Gui();
        MyGui.run();
    }
}
