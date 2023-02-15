package com.company;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

        public class Main {
           // static public Scanner scanner = new Scanner(System.in);
            static public List Directory_of_numbers = new LinkedList<>();
            static public List Directory_of_numbers_new = new LinkedList<>();
            public static void Add_new_subscriber_Directory(Object[][] cell) {
                Directory_of_numbers.add(cell);
            }
            public static void Add_new_subscriber_Directory_new(Object[][] cell) {
                Directory_of_numbers_new.add(cell);
            }
            public static Object[][] Construction_subscriber() {
                Scanner w = new Scanner(System.in);
                Object[][] cell = new Object[1][2];
                String name;
                long phone_number = 0;
                byte v;
                boolean flag = true;
                System.out.print("name_surname: ");
                name = w.nextLine();
                System.out.print("home or mobile phone?\n" +
                        "1 -> mobile      2 -> home\n" +
                        "Choose: ");
                v = w.nextByte();
                if (v == 1) {
                    while (flag) {
                        System.out.print("Number : ");
                        phone_number = Long.parseLong(w.next());
                        int lengthNumber = (String.valueOf(phone_number)).length();
                        if (lengthNumber == 11) {
                            name += " (mobile) ";
                            System.out.println("Abonent successful save!");
                            flag = false;
                        } else if (lengthNumber != 11) {
                            System.out.println("number not correct input!\n" +
                                    "Input number");
                            flag = true;
                        }
                    }
                } else if (v == 2) {
                    while (flag) {
                        System.out.print("Number: ");
                        phone_number = Long.parseLong(w.next());
                        int lengthNumber = (String.valueOf(phone_number)).length();
                        if (lengthNumber == 6) {
                            name += " (home) ";
                            System.out.println("Abonent successful save!");
                            flag = false;
                        } else if (lengthNumber != 6) {
                            System.out.println("number not correct input!\n" +
                                    "Input number");
                            flag = true;
                        }
                    }
                }
                cell[0][0] = name;
                cell[0][1] = phone_number;
                return cell;
            }


            public static boolean Search_number_Algoritm(Object cell, long number) {
                Object[][] cell1;
                cell1 = (Object[][]) cell;
                boolean flag;
                String convertInt_1 = String.valueOf(number);
                String convertInt_2 = String.valueOf(cell1[0][1]);
                boolean start = convertInt_2.startsWith(convertInt_1);
                if (start) {
                    flag = true;
                    return flag;
                } else {

                    flag = false;
                    return flag;
                }
            }
            public static boolean Search_name_Algoritm(Object cell, String name) {
                Object[][] cell1;
                cell1 = (Object[][]) cell;
                boolean flag;
                String name_cell = (String) cell1[0][0];
                boolean start = name_cell.startsWith(name);
                if (start) {
                    flag = true;
                    return flag;
                } else {

                    flag = false;
                    return flag;
                }
            }
            public static void Search_number() {
                Scanner w = new Scanner(System.in);
                long number = 0; int iterator =0;
                System.out.print("Input number for search: ");
                number = Long.parseLong(w.next());

                for (int i = 0; i < Directory_of_numbers.size(); i++) {
                    if (Search_number_Algoritm(Directory_of_numbers.get(i), number)) {
                        Read_number(Directory_of_numbers.get(i));
                        iterator++;
                    }
                }
                if (iterator==0)
                {
                    System.out.println("no such number ");
                }
            }
            public static void Search_name() {
                Scanner w = new Scanner(System.in);
                String name; int iterator =0;
                System.out.print("Input name for search:");
                name= w.nextLine();
                for (int i = 0; i < Directory_of_numbers.size(); i++) {
                    if (Search_name_Algoritm(Directory_of_numbers.get(i), name)) {
                        Read_name(Directory_of_numbers.get(i));
                        iterator++;
                    }
                }
                if (iterator==0)
                {
                    System.out.println("no such name ");
                }
            }

            public static void Read_subscriber(Object cell) {
                Object[][] cell1;
                cell1 = (Object[][]) cell;
                for (int i = 0; i < cell1.length; i++) {
                    for (int j = 0; j < cell1[0].length; j++) {
                        System.out.print(cell1[i][j] + " ");
                    }
                }
                System.out.println("");
            }

            public static void Read_number(Object cell) {
                Object[][] cell1;
                cell1 = (Object[][]) cell;
                System.out.println(cell1[0][1] + " " + cell1[0][0]);
            }
            public static void Read_name(Object cell) {
                Object[][] cell1;
                cell1 = (Object[][]) cell;
                System.out.println(cell1[0][0] + " " + cell1[0][1]);
            }
            public static boolean Delete_or_number_Algoritm(Object cell, long number)
            {
                Object[][] cell1;
                cell1 = (Object[][]) cell;
                boolean flag;
        /*String convertInt_1 = String.valueOf(number);
        String convertInt_2 = String.valueOf(cell1[0][1]);
        if (convertInt_1==convertInt_2) {
            flag = true;
            return flag;
        } else {

            flag = false;
            return flag;
        }*/
                String convertInt_1 = String.valueOf(number);
                String convertInt_2 = String.valueOf(cell1[0][1]);
                boolean start = convertInt_2.startsWith(convertInt_1);
                if (start) {
                    flag = true;
                    return flag;
                } else {

                    flag = false;
                    return flag;
                }
            }
            public static void Delete_number(){
                Scanner w = new Scanner(System.in);
                long number = 0; int iterator=0;
                System.out.print("Input number for delete: ");
                number = Long.parseLong(w.next());
                for (int i = 0; i < Directory_of_numbers.size(); i++) {
                    if (Delete_or_number_Algoritm(Directory_of_numbers.get(i), number)) {
                        System.out.println("Abonent");
                        Read_subscriber(Directory_of_numbers.get(i));
                        Directory_of_numbers.remove(i);
                        System.out.println("Deleted");
                        iterator++;
                    }
                }
                if (iterator==0)
                {
                    System.out.println("Not such number ");
                }
            }
            public static void Change_number_Algoritm(Object cell)
            {
                Scanner w = new Scanner(System.in);
                Scanner w1 = new Scanner(System.in);
                String name; long number=-0;
                Object[][] cell1;
                cell1 = (Object[][]) cell;
                byte v=0;
                String name_cell = (String) cell1[0][0];
                boolean end = name_cell.endsWith(" (mobile) ");
                System.out.print("Do you want change?\n" +
                        "surname_name -> 1        number -> 2\n" +
                        "choose: ");v = w.nextByte();
                if(v==1)
                {
                    System.out.print("input new surname_name: ");name=w1.nextLine();
                    cell1[0][0]=name;
                    if(end)
                    {
                        cell1[0][1]+=" (mobile) ";
                    }else
                        cell1[0][1]+=" (home) ";

                }
                else if(v==2)
                {
                    System.out.print("Input new number : ");number = Long.parseLong(w.next());
                    cell1[0][1]=number;
                    int lengthNumber = (String.valueOf(number)).length();
                    if (lengthNumber == 6) {
                        cell1[0][0]= ((String) cell1[0][0]).replace(" (mobile) "," (home) ");
                    } else if (lengthNumber ==11) {
                        cell1[0][0]= ((String) cell1[0][0]).replace(" (home) "," (mobile) ");
                    }
                }
            }
            public static void Change_number(){
                Scanner w = new Scanner(System.in);
                long number = 0; int iterator=0;
                System.out.print("input number for change: ");
                number = Long.parseLong(w.next());
                for (int i = 0; i < Directory_of_numbers.size(); i++) {
                    if (Delete_or_number_Algoritm(Directory_of_numbers.get(i), number)) {
                        Change_number_Algoritm(Directory_of_numbers.get(i));
                        System.out.println("Abonent");
                        Read_subscriber(Directory_of_numbers.get(i));
                        System.out.println("changed");
                        iterator++;
                    }
                }
                if (iterator==0)
                {
                    System.out.println("not such number");
                }
            }

            public static void Telephone_directory(){
                Object[][] cell1 = new Object[1][2];
                cell1[0][0]="Ivanov K.S (mobile) ";
                cell1[0][1]=8029331234567L;
                Add_new_subscriber_Directory_new(cell1);
                Object[][] cell2 = new Object[1][2];
                cell2[0][0]="Petrov I.M (home) ";
                cell2[0][1]=123456;
                Add_new_subscriber_Directory_new(cell2);
                Object[][] cell3 = new Object[1][2];
                cell3[0][0]="Danilik O.N (mobile) ";
                cell3[0][1]=80293312345678L;
                Add_new_subscriber_Directory_new(cell3);
            }

            public static void New_dir() {
                Telephone_directory();
                for (int i=0;i< Directory_of_numbers_new.size();i++) {
                    Checking_for_correctness( Directory_of_numbers_new.get(i));
                }
            }


            public static void Checking_for_correctness(Object cell){
                Object[][] cell1;
                cell1 = (Object[][]) cell;
                String name_cell = (String) cell1[0][0];
                boolean end = name_cell.endsWith(" (mobile) ");
                if(end) {
                    int lengthNumber = (String.valueOf(cell1[0][1])).length();
                    if(lengthNumber==11) {
                        Directory_of_numbers.add(cell);
                    }else {
                        Read_subscriber(cell);
                        System.out.println("not correctly abonent");
                    }

                }else {
                    int lengthNumber = (String.valueOf(cell1[0][1])).length();
                    if(lengthNumber==6) {
                        Directory_of_numbers.add(cell);
                    }else {
                        Read_subscriber(cell);
                        System.out.println("not correctly abonent");
                    }
                }
            }

            public static void Menu()
            {
                boolean flag = true;
                while (flag) {
                    Scanner w = new Scanner(System.in);
                    System.out.print("1 -> add number\n" +
                            "2 -> seach abonent\n" +
                            "3 -> edit\n" +
                            "4 -> delete\n" +
                            "5 -> add from another spravochnik\n" +
                            "6 -> list all abonents\n" +
                            "0 -> Exit\n" +
                            "choose: ");
                    byte v = w.nextByte();
                    switch (v) {
                        case 1:
                            Add_new_subscriber_Directory(Construction_subscriber());
                            break;
                        case 2:
                            System.out.print("seach abonent of\n" +
                                    "1 -> number        2 -> surname_name\n" +
                                    "choose: ");
                            byte v1 = w.nextByte();
                            if (v1 == 1) {
                                Search_number();
                            } else if (v1 == 2) {
                                Search_name();
                            }
                            break;
                        case 3:
                            Change_number();
                            break;
                        case 4:
                            Delete_number();
                            break;
                        case 5:
                            New_dir();
                            break;
                        case 6:
                            for (int i = 0; i < Directory_of_numbers.size(); i++) {
                                Read_subscriber(Directory_of_numbers.get(i));
                            }
                            break;
                        case 0:
                            System.out.println("finished");
                            flag = false;
                            break;
                    }
                }
            }
            public static void main(String[] args) {
                Menu();
            }
        }

