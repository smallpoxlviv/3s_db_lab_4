package ua.iot.lviv.view;

import ua.iot.lviv.controller.implementation.*;
import ua.iot.lviv.exception.OwnDateTimeException;
import ua.iot.lviv.model.*;
import ua.iot.lviv.model.implementation.*;
import ua.iot.lviv.persistant.ConnectionManager;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class MyView {

    private final AnimalSpeciesController animalSpeciesController = new AnimalSpeciesController();
    private final AnimalSpeciesHasServiceController animalSpeciesHasServiceController = new AnimalSpeciesHasServiceController();
    private final ClientController clientController = new ClientController();
    private final ClientHasPetController clientHasPetController = new ClientHasPetController();
    private final DiagnosisController diagnosisController = new DiagnosisController();
    private final DiplomaController diplomaController = new DiplomaController();
    private final DoctorController doctorController = new DoctorController();
    private final DoctorHasServiceController doctorHasServiceController = new DoctorHasServiceController();
    private final PetController petController = new PetController();
    private final ScheduleController scheduleController = new ScheduleController();
    private final ServiceController serviceController = new ServiceController();
    private final VisitController visitController = new VisitController();

    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner input = new Scanner(System.in);

    private final String getIdUpdate = "Enter id of entity you want to update: ";
    private final String getIdDelete = "Enter id of entity you want to delete: ";

    public MyView() {
        menu = new LinkedHashMap<>();
        menu.put("11", "11 - get all animal species");
        menu.put("12", "12 - get animal species by id");
        menu.put("13", "13 - create new animal species");
        menu.put("14", "14 - update animal species");
        menu.put("15", "15 - delete animal species");

        menu.put("21", "21 - get all from animal_species_has_service");
        menu.put("22", "22 - get from animal_species_has_service by id");
        menu.put("23", "23 - create new animal_species_has_service");
        menu.put("24", "24 - update animal_species_has_service");
        menu.put("25", "25 - delete from animal_species_has_service");

        menu.put("31", "31 - get all clients");
        menu.put("32", "32 - get client by id");
        menu.put("33", "33 - create new client");
        menu.put("34", "34 - update client");
        menu.put("35", "35 - delete client");

        menu.put("41", "41 - get all from client_has_pet");
        menu.put("42", "42 - get from client_has_pet by id");
        menu.put("43", "43 - create new client_has_pet");
        menu.put("44", "44 - update client_has_pet");
        menu.put("45", "45 - delete from client_has_pet");

        menu.put("51", "51 - get all diagnosis");
        menu.put("52", "52 - get diagnosis by id");
        menu.put("53", "53 - create new diagnosis");
        menu.put("54", "54 - update diagnosis");
        menu.put("55", "55 - delete diagnosis");

        menu.put("61", "61 - get all diplomas");
        menu.put("62", "62 - get diploma by id");
        menu.put("63", "63 - create new diploma");
        menu.put("64", "64 - update diploma");
        menu.put("65", "65 - delete diploma");

        menu.put("71", "71 - get all doctors");
        menu.put("72", "72 - get doctor by id");
        menu.put("73", "73 - create new doctor");
        menu.put("74", "74 - update doctor");
        menu.put("75", "75 - delete doctor");

        menu.put("81", "81 - get all from doctor_has_service");
        menu.put("82", "82 - get from doctor_has_service by id");
        menu.put("83", "83 - create new doctor_has_service");
        menu.put("84", "84 - update doctor_has_service");
        menu.put("85", "85 - delete from doctor_has_service");

        menu.put("91", "91 - get all pets");
        menu.put("92", "92 - get pet by id");
        menu.put("93", "93 - create new pet");
        menu.put("94", "94 - update pet");
        menu.put("95", "95 - delete pet");

        menu.put("101", "101- get schedule");
        menu.put("102", "102- get from schedule by id");
        menu.put("103", "103- create new schedule");
        menu.put("104", "104- update schedule");
        menu.put("105", "105 - delete schedule");

        menu.put("111", "111- get all services");
        menu.put("112", "112- get service by id");
        menu.put("113", "113- create new service");
        menu.put("114", "114- update service");
        menu.put("115", "115 - delete service");

        menu.put("121", "121- get all visits");
        menu.put("122", "122- get visit by id");
        menu.put("123", "123- create new visit");
        menu.put("124", "124- update visit");
        menu.put("125", "125 - delete visit");

        menu.put("Q", "Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("11", this::getAllAnimalSpecies);
        methodsMenu.put("12", this::getAnimalSpeciesById);
        methodsMenu.put("13", this::createAnimalSpecies);
        methodsMenu.put("14", this::updateAnimalSpecies);
        methodsMenu.put("15", this::deleteAnimalSpecies);

        methodsMenu.put("21", this::getAllAnimalSpeciesHasService);
        methodsMenu.put("22", this::getAnimalSpeciesHasServiceById);
        methodsMenu.put("23", this::createAnimalSpeciesHasService);
        methodsMenu.put("24", this::updateAnimalSpeciesHasService);
        methodsMenu.put("25", this::deleteAnimalSpeciesHasService);

        methodsMenu.put("31", this::getAllClients);
        methodsMenu.put("32", this::getClientById);
        methodsMenu.put("33", this::createClient);
        methodsMenu.put("34", this::updateClient);
        methodsMenu.put("35", this::deleteClient);

        methodsMenu.put("41", this::getAllClientHasPet);
        methodsMenu.put("42", this::getClientHasPetById);
        methodsMenu.put("43", this::createClientHasPet);
        methodsMenu.put("44", this::updateClientHasPet);
        methodsMenu.put("45", this::deleteClientHasPet);

        methodsMenu.put("51", this::getAllDiagnoses);
        methodsMenu.put("52", this::getDiagnosisById);
        methodsMenu.put("53", this::createDiagnosis);
        methodsMenu.put("54", this::updateDiagnosis);
        methodsMenu.put("55", this::deleteDiagnosis);

        methodsMenu.put("61", this::getAllDiplomas);
        methodsMenu.put("62", this::getDiplomaById);
        methodsMenu.put("63", this::createDiploma);
        methodsMenu.put("64", this::updateDiploma);
        methodsMenu.put("65", this::deleteDiploma);

        methodsMenu.put("71", this::getAllDoctors);
        methodsMenu.put("72", this::getDoctorById);
        methodsMenu.put("73", this::createDoctor);
        methodsMenu.put("74", this::updateDoctor);
        methodsMenu.put("75", this::deleteDoctor);

        methodsMenu.put("81", this::getAllDoctorHasService);
        methodsMenu.put("82", this::getDoctorHasServiceById);
        methodsMenu.put("83", this::createDoctorHasService);
        methodsMenu.put("84", this::updateDoctorHasService);
        methodsMenu.put("85", this::deleteDoctorHasService);

        methodsMenu.put("91", this::getAllPets);
        methodsMenu.put("92", this::getPetById);
        methodsMenu.put("93", this::createPet);
        methodsMenu.put("94", this::updatePet);
        methodsMenu.put("95", this::deletePet);

        methodsMenu.put("101", this::getAllSchedule);
        methodsMenu.put("102", this::getScheduleById);
        methodsMenu.put("103", this::createSchedule);
        methodsMenu.put("104", this::updateSchedule);
        methodsMenu.put("105", this::deleteSchedule);

        methodsMenu.put("111", this::getAllServices);
        methodsMenu.put("112", this::getServiceById);
        methodsMenu.put("113", this::createService);
        methodsMenu.put("114", this::updateService);
        methodsMenu.put("115", this::deleteService);

        methodsMenu.put("121", this::getAllVisits);
        methodsMenu.put("122", this::getVisitById);
        methodsMenu.put("123", this::createVisit);
        methodsMenu.put("124", this::updateVisit);
        methodsMenu.put("125", this::deleteVisit);
    }

    private void getAllAnimalSpecies() throws SQLException {
        System.out.println("\tTable 'animal_species'");
        animalSpeciesController.getAll();
    }

    private void getAnimalSpeciesById() throws SQLException {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        input.nextLine();
        animalSpeciesController.getById(id);
    }

    private void createAnimalSpecies() throws SQLException {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter species:");
        String species = input.nextLine();
        AnimalSpecies entity = new AnimalSpeciesImpl(id, species);
        animalSpeciesController.create(entity);
    }

    private void updateAnimalSpecies() throws SQLException {
        System.out.println(getIdUpdate);
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter species:");
        String species = input.nextLine();
        AnimalSpecies entity = new AnimalSpeciesImpl(id, species);
        animalSpeciesController.update(entity);
    }

    private void deleteAnimalSpecies() throws SQLException {
        System.out.println(getIdDelete);
        int id = input.nextInt();
        input.nextLine();
        animalSpeciesController.delete(id);
    }

    //-----------------------------------------------------------------------
    private void getAllAnimalSpeciesHasService() throws SQLException {
        System.out.println("\tTable 'animal_species_has_service'");
        animalSpeciesHasServiceController.getAll();
    }

    private void getAnimalSpeciesHasServiceById() throws SQLException {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        input.nextLine();
        animalSpeciesHasServiceController.getById(id);
    }

    private void createAnimalSpeciesHasService() throws SQLException {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter animal species id:");
        int animalSpeciesId = input.nextInt();
        input.nextLine();
        System.out.print("Enter service id:");
        int serviceId = input.nextInt();
        input.nextLine();
        AnimalSpeciesHasService entity = new AnimalSpeciesHasServiceImpl(id, animalSpeciesId, serviceId);
        animalSpeciesHasServiceController.create(entity);
    }

    private void updateAnimalSpeciesHasService() throws SQLException {
        System.out.println(getIdUpdate);
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter animal species id:");
        int animalSpeciesId = input.nextInt();
        input.nextLine();
        System.out.print("Enter service id:");
        int serviceId = input.nextInt();
        input.nextLine();
        AnimalSpeciesHasService entity = new AnimalSpeciesHasServiceImpl(id, animalSpeciesId, serviceId);
        animalSpeciesHasServiceController.update(entity);
    }

    private void deleteAnimalSpeciesHasService() throws SQLException {
        System.out.println(getIdDelete);
        int id = input.nextInt();
        input.nextLine();
        animalSpeciesHasServiceController.delete(id);
    }

    //-----------------------------------------------------------------------
    private void getAllClients() throws SQLException {
        System.out.println("\tTable 'client'");
        clientController.getAll();
    }

    private void getClientById() throws SQLException {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        input.nextLine();
        clientController.getById(id);
    }

    private void createClient() throws SQLException {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter first name:");
        String firstName = input.nextLine();
        System.out.print("Enter name:");
        String name = input.nextLine();
        System.out.print("Enter last name:");
        String lastName = input.nextLine();
        Client entity = new ClientImpl(id, firstName, name, lastName);
        clientController.create(entity);
    }

    private void updateClient() throws SQLException {
        System.out.println(getIdUpdate);
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter first name:");
        String firstName = input.nextLine();
        System.out.print("Enter name:");
        String name = input.nextLine();
        System.out.print("Enter last name:");
        String lastName = input.nextLine();
        Client entity = new ClientImpl(id, firstName, name, lastName);
        clientController.update(entity);
    }

    private void deleteClient() throws SQLException {
        System.out.println(getIdDelete);
        int id = input.nextInt();
        input.nextLine();
        clientController.delete(id);
    }

    //-----------------------------------------------------------------------
    private void getAllClientHasPet() throws SQLException {
        System.out.println("\tTable 'client_has_pet'");
        clientHasPetController.getAll();
    }

    private void getClientHasPetById() throws SQLException {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        input.nextLine();
        clientHasPetController.getById(id);
    }

    private void createClientHasPet() throws SQLException {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter client id:");
        int clientId = input.nextInt();
        input.nextLine();
        System.out.print("Enter pet id:");
        int petId = input.nextInt();
        input.nextLine();
        ClientHasPet entity = new ClientHasPetImpl(id, clientId, petId);
        clientHasPetController.create(entity);
    }

    private void updateClientHasPet() throws SQLException {
        System.out.println(getIdUpdate);
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter client id:");
        int clientId = input.nextInt();
        input.nextLine();
        System.out.print("Enter pet id:");
        int petId = input.nextInt();
        input.nextLine();
        ClientHasPet entity = new ClientHasPetImpl(id, clientId, petId);
        clientHasPetController.update(entity);
    }

    private void deleteClientHasPet() throws SQLException {
        System.out.println(getIdDelete);
        int id = input.nextInt();
        input.nextLine();
        clientHasPetController.delete(id);
    }

    //-----------------------------------------------------------------------
    private void getAllDiagnoses() throws SQLException {
        System.out.println("\tTable 'diagnosis'");
        diagnosisController.getAll();
    }

    private void getDiagnosisById() throws SQLException {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        input.nextLine();
        diagnosisController.getById(id);
    }

    private void createDiagnosis() throws SQLException {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter diagnosis:");
        String diagnosis = input.nextLine();
        System.out.print("Enter treatment:");
        String treatment = input.nextLine();
        Diagnosis entity = new DiagnosisImpl(id, diagnosis, treatment);
        diagnosisController.create(entity);
    }

    private void updateDiagnosis() throws SQLException {
        System.out.println(getIdUpdate);
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter diagnosis:");
        String diagnosis = input.nextLine();
        System.out.print("Enter treatment:");
        String treatment = input.nextLine();
        Diagnosis entity = new DiagnosisImpl(id, diagnosis, treatment);
        diagnosisController.update(entity);
    }

    private void deleteDiagnosis() throws SQLException {
        System.out.println(getIdDelete);
        int id = input.nextInt();
        input.nextLine();
        diagnosisController.delete(id);
    }

    //-----------------------------------------------------------------------
    private void getAllDiplomas() throws SQLException {
        System.out.println("\tTable 'diploma'");
        diplomaController.getAll();
    }

    private void getDiplomaById() throws SQLException {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        input.nextLine();
        diplomaController.getById(id);
    }

    private void createDiploma() throws SQLException, DateTimeParseException {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Enter university:");
        String university = input.nextLine();
        System.out.println("Enter date in format: MM/dd/yyyy, example: \"07/28/2011\":");
        String dateStr = input.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        System.out.println("Enter seria:");
        String seria = input.nextLine();
        System.out.println("Enter number:");
        String number = input.nextLine();
        System.out.println("Enter doctor id: ");
        int doctorId = input.nextInt();
        input.nextLine();
        Diploma entity = new DiplomaImpl(id, university, date, seria, number, doctorId);
        diplomaController.create(entity);
    }

    private void updateDiploma() throws SQLException, DateTimeParseException {
        System.out.println(getIdUpdate);
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Enter university:");
        String university = input.nextLine();
        System.out.println("Enter date in format: MM/dd/yyyy, example: \"07/28/2011\":");
        String dateStr = input.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        System.out.println("Enter seria:");
        String seria = input.nextLine();
        System.out.print("Enter number:");
        String number = input.nextLine();
        System.out.println("Enter doctor id: ");
        int doctorId = input.nextInt();
        input.nextLine();
        Diploma entity = new DiplomaImpl(id, university, date, seria, number, doctorId);
        diplomaController.update(entity);
    }

    private void deleteDiploma() throws SQLException {
        System.out.println(getIdDelete);
        int id = input.nextInt();
        input.nextLine();
        diplomaController.delete(id);
    }

    //-----------------------------------------------------------------------
    private void getAllDoctors() throws SQLException {
        System.out.println("\tTable 'doctor'");
        doctorController.getAll();
    }

    private void getDoctorById() throws SQLException {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        input.nextLine();
        doctorController.getById(id);
    }

    private void createDoctor() throws SQLException {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter first name:");
        String firstName = input.nextLine();
        System.out.print("Enter name:");
        String name = input.nextLine();
        System.out.print("Enter last name:");
        String lastName = input.nextLine();
        System.out.println("Enter year of birth:");
        int yearOfBirth = input.nextInt();
        input.nextLine();
        System.out.print("Enter speciality:");
        String speciality = input.nextLine();
        Doctor entity = new DoctorImpl(id, firstName, name, lastName, yearOfBirth, speciality);
        doctorController.create(entity);
    }

    private void updateDoctor() throws SQLException {
        System.out.println(getIdUpdate);
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter first name:");
        String firstName = input.nextLine();
        System.out.print("Enter name:");
        String name = input.nextLine();
        System.out.print("Enter last name:");
        String lastName = input.nextLine();
        System.out.println("Enter year of birth:");
        int yearOfBirth = input.nextInt();
        input.nextLine();
        System.out.print("Enter speciality:");
        String speciality = input.nextLine();
        Doctor entity = new DoctorImpl(id, firstName, name, lastName, yearOfBirth, speciality);
        doctorController.update(entity);
    }

    private void deleteDoctor() throws SQLException {
        System.out.println(getIdDelete);
        int id = input.nextInt();
        input.nextLine();
        doctorController.delete(id);
    }

    //-----------------------------------------------------------------------
    private void getAllDoctorHasService() throws SQLException {
        System.out.println("\tTable 'doctor_has_service'");
        doctorHasServiceController.getAll();
    }

    private void getDoctorHasServiceById() throws SQLException {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        input.nextLine();
        doctorHasServiceController.getById(id);
    }

    private void createDoctorHasService() throws SQLException {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter doctor id:");
        int doctorId = input.nextInt();
        input.nextLine();
        System.out.print("Enter service id:");
        int serviceId = input.nextInt();
        input.nextLine();
        DoctorHasService entity = new DoctorHasServiceImpl(id, doctorId, serviceId);
        doctorHasServiceController.create(entity);
    }

    private void updateDoctorHasService() throws SQLException {
        System.out.println(getIdUpdate);
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter doctor id:");
        int doctorId = input.nextInt();
        input.nextLine();
        System.out.print("Enter service id:");
        int serviceId = input.nextInt();
        input.nextLine();
        DoctorHasService entity = new DoctorHasServiceImpl(id, doctorId, serviceId);
        doctorHasServiceController.update(entity);
    }

    private void deleteDoctorHasService() throws SQLException {
        System.out.println(getIdDelete);
        int id = input.nextInt();
        input.nextLine();
        doctorHasServiceController.delete(id);
    }

    //-----------------------------------------------------------------------
    private void getAllPets() throws SQLException {
        System.out.println("\tTable 'pet'");
        petController.getAll();
    }

    private void getPetById() throws SQLException {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        input.nextLine();
        petController.getById(id);
    }

    private void createPet() throws SQLException {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter species id:");
        int speciesId = input.nextInt();
        input.nextLine();
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.print("Enter weight in kg:");
        int weightInKg = input.nextInt();
        input.nextLine();
        System.out.print("Enter length in cm:");
        int lengthInCm = input.nextInt();
        input.nextLine();
        System.out.println("Enter date of birth in format: MM/dd/yyyy, example: \"07/28/2011\":");
        String dateStr = input.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        Pet entity = new PetImpl(id, speciesId, name, weightInKg, lengthInCm, date);
        petController.create(entity);
    }

    private void updatePet() throws SQLException, DateTimeParseException {
        System.out.println(getIdUpdate);
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter species id:");
        int speciesId = input.nextInt();
        input.nextLine();
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.print("Enter weight in kg:");
        int weightInKg = input.nextInt();
        input.nextLine();
        System.out.print("Enter length in cm:");
        int lengthInCm = input.nextInt();
        input.nextLine();
        System.out.println("Enter date of birth in format: MM/dd/yyyy, example: \"07/28/2011\":");
        String dateStr = input.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        Pet entity = new PetImpl(id, speciesId, name, weightInKg, lengthInCm, date);
        petController.update(entity);
    }

    private void deletePet() throws SQLException {
        System.out.println(getIdDelete);
        int id = input.nextInt();
        input.nextLine();
        petController.delete(id);
    }

    //-----------------------------------------------------------------------
    private void getAllSchedule() throws SQLException {
        System.out.println("\tTable 'schedule'");
        scheduleController.getAll();
    }

    private void getScheduleById() throws SQLException {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        input.nextLine();
        scheduleController.getById(id);
    }

    private void createSchedule() throws SQLException {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Enter doctor id: ");
        int doctorId = input.nextInt();
        input.nextLine();
        System.out.println("Enter time of start in format: HH:mm:ss, example: \"10:45:00\"::");
        String timeStartStr = input.nextLine();
        Time timeStart = Time.valueOf(timeStartStr);
        System.out.println("Enter time of end in format: HH:mm:ss, example: \"18:45:00\"::");
        String timeEndStr = input.nextLine();
        Time timeEnd = Time.valueOf(timeEndStr);
        System.out.println("Enter week day:");
        String weekDay = input.nextLine();
        Schedule entity = new ScheduleImpl(id, doctorId, timeStart, timeEnd, weekDay);
        scheduleController.create(entity);
    }

    private void updateSchedule() throws SQLException {
        System.out.println(getIdUpdate);
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Enter doctor id: ");
        int doctorId = input.nextInt();
        input.nextLine();
        System.out.println("Enter time of start in format: HH:mm:ss, example: \"10:45:00\":");
        String timeStartStr = input.nextLine();
        Time timeStart = Time.valueOf(timeStartStr);
        System.out.println("Enter time of end in format: HH:mm:ss, example: \"18:45:00\":");
        String timeEndStr = input.nextLine();
        Time timeEnd = Time.valueOf(timeEndStr);
        System.out.println("Enter week day:");
        String weekDay = input.nextLine();
        Schedule entity = new ScheduleImpl(id, doctorId, timeStart, timeEnd, weekDay);
        scheduleController.update(entity);
    }

    private void deleteSchedule() throws SQLException {
        System.out.println(getIdDelete);
        int id = input.nextInt();
        input.nextLine();
        scheduleController.delete(id);
    }

    //-----------------------------------------------------------------------
    private void getAllServices() throws SQLException {
        System.out.println("\tTable 'service'");
        serviceController.getAll();
    }

    private void getServiceById() throws SQLException {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        input.nextLine();
        serviceController.getById(id);
    }

    private void createService() throws SQLException {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter description:");
        String description = input.nextLine();
        System.out.println("Enter price in USD in format \"####,##\", example: \"55,25\", \"255,5\":");
        BigDecimal priceUSD = input.nextBigDecimal();
        input.nextLine();
        Service entity = new ServiceImpl(id, name, description, priceUSD);
        serviceController.create(entity);
    }

    private void updateService() throws SQLException {
        System.out.println(getIdUpdate);
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter description:");
        String description = input.nextLine();
        System.out.println("Enter price in USD in format \"####,##\", example: \"55,25\", \"255,5\":");
        BigDecimal priceUSD = input.nextBigDecimal();
        input.nextLine();
        Service entity = new ServiceImpl(id, name, description, priceUSD);
        serviceController.update(entity);
    }

    private void deleteService() throws SQLException {
        System.out.println(getIdDelete);
        int id = input.nextInt();
        input.nextLine();
        serviceController.delete(id);
    }

    //-----------------------------------------------------------------------
    private void getAllVisits() throws SQLException {
        System.out.println("\tTable 'visit'");
        visitController.getAll();
    }

    private void getVisitById() throws SQLException {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        input.nextLine();
        visitController.getById(id);
    }

    private void createVisit() throws SQLException, OwnDateTimeException {
        System.out.println("Enter id: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Enter date and time in format: MM/dd/yyyy HH:mm, example: \"07/28/2011 09:30\":");
        String dateTimeStr = input.nextLine();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);
            System.out.println("Enter client_has_pet id:");
            int clientHasPetId = input.nextInt();
            input.nextLine();
            System.out.println("Enter service id:");
            int serviceId = input.nextInt();
            input.nextLine();
            System.out.println("Enter schedule id:");
            int scheduleId = input.nextInt();
            input.nextLine();
            System.out.println("Enter diagnosis id:");
            int diagnosisId = input.nextInt();
            input.nextLine();
            Visit entity = new VisitImpl(id, dateTime, clientHasPetId, serviceId, scheduleId, diagnosisId);
            visitController.create(entity);
        } catch (DateTimeParseException e) {
            throw new OwnDateTimeException("DateTime format is incorrect!");
        }
    }

    private void updateVisit() throws SQLException, OwnDateTimeException {
        System.out.println(getIdUpdate);
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Enter date and time in format: MM/dd/yyyy HH:mm, example: \"07/28/2011 09:30\":");
        String dateTimeStr = input.nextLine();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);
            System.out.println("Enter client_has_pet id:");
            int clientHasPetId = input.nextInt();
            input.nextLine();
            System.out.println("Enter service id:");
            int serviceId = input.nextInt();
            input.nextLine();
            System.out.println("Enter schedule id:");
            int scheduleId = input.nextInt();
            input.nextLine();
            System.out.println("Enter diagnosis id:");
            int diagnosisId = input.nextInt();
            input.nextLine();
            Visit entity = new VisitImpl(id, dateTime, clientHasPetId, serviceId, scheduleId, diagnosisId);
            visitController.update(entity);
        } catch (DateTimeParseException e) {
            throw new OwnDateTimeException("DateTime format is incorrect!");
        }
    }

    private void deleteVisit() throws SQLException {
        System.out.println(getIdDelete);
        int id = input.nextInt();
        input.nextLine();
        visitController.delete(id);
    }

    //-----------------------------------------------------------------------
    private void exit() {
        ConnectionManager.closeConnection();
        System.out.println("Good Bye!");
    }

    private void showMenu() {
        System.out.println("\nMENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    public void show() {
        do {
            System.out.println("\nM - show menu");
            System.out.println("Q - exit");
            String keyMenu = input.nextLine().toUpperCase();
            if (keyMenu.equalsIgnoreCase("M")) {
                showMenu();
                System.out.println("Select menu point.");
                keyMenu = input.nextLine().toUpperCase();
                try {
                    methodsMenu.get(keyMenu).print();
                } catch (SQLException e) {
                    System.out.println("SQLException: " + e.getMessage());
                    System.out.println("SQLState: " + e.getSQLState());
                    System.out.println("VendorError: " + e.getErrorCode());
                } catch (NullPointerException ignored) {
                    if (keyMenu.equalsIgnoreCase("Q")) {
                        exit();
                        break;
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Date format is incorrect! Correct format: MM/dd/yyyy, example: \"07/28/2011\"");
                } catch (InputMismatchException e) {
                    System.out.println("Price format is incorrect! Correct format: \"####,##\", example: \"55,25\", \"255,5\"");
                    input.nextLine();
                } catch (OwnDateTimeException e) {
                    System.out.println("DateTime format is incorrect! Correct format: MM/dd/yyyy HH:mm, example: \"07/28/2011 09:30\"");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("\nSomething went wrong. Please try later");
                }
            } else if (keyMenu.equalsIgnoreCase("Q")) {
                exit();
                break;
            }
        } while (true);
    }
}
