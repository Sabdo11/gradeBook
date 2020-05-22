package com.selam.gradeBook.domain.drivers;
/**
 * SelamawitAbdo_02 : The purpose of this class is to test the features of the student class and grade item class
 * project: # 2
 * IDE: Intellij
 * Operating System : OSX
 * @author Selamawit Abdo
 * @Date:10/01/2019
 * @version : 0.1
 */

import com.selam.gradeBook.domain.helpers.FileNumber;
import com.selam.gradeBook.domain.models.GradeItem;
import com.selam.gradeBook.domain.models.Student;

import java.io.File;
import java.util.Scanner;


public class SelamawitAbdo_02 {


    private static Student student1;      // The student 1
    private static Student student2;      // The student 2
    private static GradeItem gradeItem1;  // The grade item 1
    private static GradeItem gradeItem2;  // The grade item 2


    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {

        // A variable to hold the file input number
        String xx = "";

        // Get File Number From User
        xx = FileNumber.getFileNumber();

        // concatenate file name with user input
        final String INPUT_FILENAME = "Project_02_Input" + xx + ".txt";

        // Open File for Processing
        try {
            File fileInput = new File(INPUT_FILENAME);
            Scanner input = new Scanner(fileInput);

            while (input.hasNextLine()) {
                // read the next line
                String line = input.nextLine();
                // split input data using comma delimiter
                String[] data = line.split(",");
                if (data[0].equals("STUDENT")) {
                    processStudentData(data);

                } else if (data[0].equals("GRADE ITEM")) {
                    processGradeItemData(data);
                }
                else{
					System.err.println("Error! The input file does not have the key Word \'STUDENT\' or" +
                            " \'GRADE ITEM\' ");
				}
            }
            // Close input file
            input.close();

			/************************ Test Set 1 ********************************************************************/
			System.out.println("\n");
			System.out.println("Running Test 1a: ");
			System.out.println(student1.toString() + "\n");
			System.out.println("Running Test 1b");
			System.out.println(gradeItem1.toString()+"\n");
			System.out.println("****************************************************************************" + "\n");

			/************************ Test Set 2 ********************************************************************/

			System.out.println("Running Test 2a: ");
			System.out.println("Student Object Data");
			System.out.println(student1.getStudentId());
			System.out.println(student1.getFirstName());
			System.out.println(student1.getLastName());
			System.out.println(student1.getEmailAddress()+"\n");


			System.out.println("Running Test 2b: ");
			System.out.println("Grade Object Data");
			System.out.println(gradeItem1.getGradeItemId());
			System.out.println(gradeItem1.getStudentId());
			System.out.println(gradeItem1.getCourseId());
			System.out.println(gradeItem1.getItemType());
			System.out.println(gradeItem1.getDate());
			System.out.println(gradeItem1.getMaximumScore());
			System.out.println(gradeItem1.getActualScore()+"\n");
			System.out.println("****************************************************************************" + "\n");

			/************************ Test Set 3 *******************************************************************/


			student2 = new Student ("900123456", "Joe", "Doe",
                    "joedoe@msudenver.edu");
			gradeItem2 = new GradeItem( "900123456",1, "23456", "HW",
                    "20190112", 100, 95);

			System.out.println("Running Test 3a:");

			if (student1.equals(student2)) {

				System.out.println("Student objects are equal: Student IDs are " + student1.getStudentId()
                        + " and " + student2.getStudentId() + "\n");
			} else {

				System.out.println("Student objects are not equal: Student IDs are " + student1.getStudentId()
                        + " and " + student2.getStudentId()+"\n");
			}

			System.out.println("Running Test3b :");
			if (gradeItem1.equals(gradeItem2)) {

				System.out.println("GradeItem objects are equal: Student IDs are " + gradeItem1.getStudentId()
                        + " and " + gradeItem2.getStudentId()+"\n");
			} else {

				System.out.println("GradeItem objects are not equal: Student IDs are " + gradeItem1.getStudentId()
                        + " and " + gradeItem2.getStudentId()+"\n");
			}

		} catch (Exception e) {
            System.err.println(e);
        }



    }

    /**
     * process student data
     */
    private static void processStudentData(String[] data) {
        if (data[1].equals("ADD")) {
            try {

                student1 = new Student(data[2], data[3], data[4], data[5]);

            } catch (Exception ex) {
                System.err.println(ex);
            }
        } else {

			System.err.println("Error! The input file does not have the key Word \'ADD\'");
        }
    }

    /**
     * process grade item data
     */
    private static void processGradeItemData(String[] data) {

        if (data[1].equals("ADD")) {
            String studentId = data[3];
            String courseId = data[4];
            String itemType = data[5];
            String date = data[6];
            try {
                int gradeItemId = Integer.parseInt(data[2]);
                int maximumScore = Integer.parseInt(data[7]);
                int actualScore = Integer.parseInt(data[8]);

                gradeItem1 = new GradeItem(studentId, gradeItemId, courseId, itemType, date, maximumScore, actualScore);
            } catch (Exception ex) {
                System.err.println(ex);
            }
        } else {
			System.err.println("Error! The input file does not have the key Word \'ADD\'");
        }

    }
}// end test class





