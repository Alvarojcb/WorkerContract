package Exercicio.aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Exercicio.entietes.*;
import java.util.Date;



public class main {
    public static void main(String[] args) throws ParseException{
        Scanner sc =  new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter departament's name: ");
        String departamentName = sc.nextLine();
        System.out.print("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Enter Worker Level: ");
        String workerLevel = sc.nextLine().toUpperCase();
        System.out.println("Enter Base Salary: ");
        Integer baseSalary = sc.nextInt();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new departament(departamentName));

        System.out.print("How many contracts to this worker: ");
        int n  = sc.nextInt();

        for(int i=1 ; i<=n; i++){
            System.out.println("Enter contract #" + i + "data :");
            System.out.print("Date (DD/MM/YYYY)");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hour = sc.nextInt();

            HourContract contract =  new HourContract(contractDate, valuePerHour, hour);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income(MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Departament: " + worker.getDepartament().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));


        sc.close();
    }
}
