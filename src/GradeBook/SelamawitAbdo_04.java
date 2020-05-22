package GradeBook;
/**
 * project: # 4
 * IDE: Intellij
 * Operating System : OSX
 * @author Selamawit Abdo
 * @Date:10/28/2019
 * @version : 0.1
 */


import GradeBook.dataStructures.MyLinkedList;
import GradeBook.helpers.FileNumber;
import GradeBook.models.Student;
import GradeBook.models.GradeItem;

import java.io.*;
import java.util.Scanner;

public class SelamawitAbdo_04 {

    private static MyLinkedList listOfStudents;     // Linked list Of Students

    /**
     * The grade items.
     */
    private static MyLinkedList listOfGradeItems;   // Linked list Of Grade Items
    private static String INPUT_FILE;
    private static String OUTPUT_FILE;

    /**
     * The main method
     */
    public static void main(String[] args) {

        listOfStudents = new MyLinkedList();

        listOfGradeItems = new MyLinkedList();

        processInput();

        generateReport();


    }

    //*************************************************************************************************
    private static void generateReport() {

        System.out.println("Generating report to file " + OUTPUT_FILE + " ... done.");


        Object[] students = listOfStudents.toArray();
        Object[] gradeItems = listOfGradeItems.toArray();


        try {
            FileWriter fileWriter = new FileWriter(OUTPUT_FILE);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("StudentID\tFirst Name\tLast Name\tEmail");

            for (int i = 1 ; i < students.length ; i++) {

                int totalMax = 0;
                int totalActual = 0;
                double percentage = 0;
                double gradePercentage = 0;

                Student student = (Student) students[i];
                printWriter.println(student.getStudentId() + "\t" + student.getFirstName() + "\t"
                        + student.getLastName() + "\t" + student.getEmailAddress());

                printWriter.println("\tGradeItemID\tCourseID\t\tType\tDate\tMaximum Score\tActual Score\tGrade(%)");

                for (int j = 1 ; j <  gradeItems.length; j++) {
                    GradeItem gradeItem = (GradeItem) gradeItems[j];

                    if (student.getStudentId().equals(gradeItem.getStudentId())) {
                        percentage =  (double) (gradeItem.getActualScore()*100)/gradeItem.getMaximumScore();
                        printWriter.println("\t" + gradeItem.getGradeItemId() + "\t\t\t" + gradeItem.getCourseId() + "\t\t"
                                + "\t" + gradeItem.getItemType() + "\t\t" + gradeItem.getDate() + "\t"
                                + "\t" + gradeItem.getMaximumScore() + "\t\t\t" + gradeItem.getActualScore() + "\t\t\t" + percentage +"%");

                        totalMax += gradeItem.getMaximumScore();
                        totalActual += gradeItem.getActualScore();
                    }

                }
                printWriter.println("=========================================================================================");

                // Check If total max is greater than zero
                gradePercentage = (totalMax > 0) ? (double) ((totalActual * 100) / totalMax) : 0;

                // Print the grade totals for the student
                printWriter.println("\tTotal\t\t\t\t\t\t\t\t\t\t\t" + totalMax + "\t\t" + totalActual + "\t\t\t"
                        + gradePercentage + "%\n");

            }

            printWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //*****************************************************************************************************************
    public static void processInput()
    {
        //      // A variable to hold the file input number
        String xx = "";
        // Get File Number From User
        xx = FileNumber.getFileNumber();
        // concatenate file name with user input
        INPUT_FILE = "Project_04_Input" + xx + ".txt";
        OUTPUT_FILE = "Project_04_Output" + xx + ".txt";

        try {
            File file = new File(INPUT_FILE);
            Scanner input = new Scanner(file);

            if (file.exists()) {
                System.out.println("Reading data from file " + INPUT_FILE);
                // while loop  file has line
                while (input.hasNextLine()) {
                    // read the line
                    String line = input.nextLine();
                    String[] data = line.split(",");
                    if (data[0].equals("STUDENT")) {
                        processStudentData(data);
                    } else if (data[0].equals("GRADE ITEM")) {
                        processGradeItemData(data);
                    }
                }
                input.close();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error Encountered: The Input File Does not Exist");
            System.exit(1);
        }


    }
//*****************************************************************************************************************

    /**
     * Process student data.
     *
     * @param data the data
     */
    // method processStudentData
    private static void processStudentData(String[] data) {


        if (data[1].equals("ADD")) {


            try {
                Student student = new Student(data[2], data[3], data[4], data[5]);

                if (listOfStudents.contains(student)) {
                    System.out.println("Student with Student Id " + student.getStudentId() + " is already in the list");
                } else {
                    listOfStudents.add(student);
                    System.out.println("Student with Student Id " + student.getStudentId() + " was added to the list");

                }

            } catch (Exception ex) {
                System.err.println(ex + "\nStudent was not added to the list");


            }
        } else if (data[1].equals("DEL")) {

            try {
                Student student = new Student(data[2], data[3], data[4], data[5]);

                if (listOfStudents.contains(student)) {
                    listOfStudents.remove(student);
                    System.out.println("Student with Student Id " + student.getStudentId() + " was removed from the list");
                } else {
                    System.err.println("Student with Student Id " + student.getStudentId() + " is not in the list ");

                }

            } catch (Exception ex) {
                System.err.println(ex + "\nStudent was not removed from the list");

            }
        } else {
            System.err.println("Error Encountered: The second field should either be ADD or DEL but found " + data[1]);
        }
    }
//*****************************************************************************************************************

    /**
     * Process grade item data
     */
    // process grade item data
    private static void processGradeItemData(String[] data) {
        if (data[1].equals("ADD")) {

            try {
                // Create the GradeItem Object using the data input
                GradeItem gradeItem = new GradeItem(data[3], Integer.parseInt(data[2]), data[4], data[5], data[6],
                        Integer.parseInt(data[7]), Integer.parseInt(data[8]));

                // Check if the GradeItem Object is Unique
                if (listOfGradeItems.contains(gradeItem)) {
                    System.err.println("Grade Item with Student Id " + gradeItem.getStudentId() + " and Grade Item Id "
                            + gradeItem.getGradeItemId() + " is already in the list");
                } else {
                    listOfGradeItems.add(gradeItem);
                    System.out.println("Grade Item with Grade Item Id " + gradeItem.getGradeItemId()
                            + " was added to the list");
                }

            } catch (Exception ex) {
                System.err.println(ex + "\nGrade Item was not added to the list");
            }
        } else if (data[1].equals("DEL")) {
            try {
                GradeItem gradeItem = new GradeItem(data[3], Integer.parseInt(data[2]), data[4], data[5], data[6],
                        Integer.parseInt(data[7]), Integer.parseInt(data[8]));

                if (listOfGradeItems.contains(gradeItem)) {
                    listOfGradeItems.remove(gradeItem);
                    System.out.println("Grade Item with Grade Item Id " + gradeItem.getGradeItemId()
                            + " was removed from the list");
                } else {
                    System.err.println("Grade Item with Grade Item Id " + gradeItem.getGradeItemId()
                            + " is not in the list ");
                }

            } catch (Exception ex) {
                System.err.println(ex + "\nGrade Item was not removed from the list");
            }

        } else {
            System.err.println("Error Encountered: The second field should either be ADD or DEL but found " + data[1]);
        }

    }
}




