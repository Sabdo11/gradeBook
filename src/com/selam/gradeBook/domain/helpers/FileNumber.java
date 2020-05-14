package com.selam.gradeBook.domain.helpers;

/*
   Class: FileNumber

   getFileNumber - Get an n-character file number to include in a file name

   This method supports input file names of the form
         FILENAME_PREFIX_XX.FILETYPE
   where XX = 01, 02, 03, ...

   Examples are: hw2input01.txt, hw4input04.txt and hw6input_basic.txt

   Here are the methods in this class:

   1. getFileNumber(args, option)

      @param args    The command line arguments, if any. This could be
                     a 0-element array (length = 0)
      @param option  "Command Line", attempt to get the number from the
                     command line
                     "From User", get the number from the user via the
                     keyboard. This option ignores the first argument
                     Any option other than these two yields a default
                     response of "01"
      @return XX     where XX is typically 01, 02, 03, ... but could be
                     any string, including the empty string. If the user
                     enters a single numeric string, a "0" is tacked on
                     in front, yielding "0C" where C is the digit that
                     the user entered

   2. getFileNumber(args)

      @param args, as described in 1.
      @return XX,  as described in 1.

      Calls getFileNumber(args, "Command Line")

   3. getFileNumber()

      Gets a file number from the user via the keyboard

      @return XX,  as described in 1.

      Calls getFileNumber(dummyArray, "From User")
*/

import java.util.Scanner;

public class FileNumber {

    static Scanner keyboard;
    static final String DEFAULT_RESPONSE = "01";

    // The options for getting the file number

    static final String COMMAND_LINE = "command line";
    static final String FROM_USER    = "from user";

    //************************************************************************

    // Method 1. 2-arg method. See above for the parameters

    public static String getFileNumber(String[] args, String option) {

        String XX = "";            // Will contain the result to return
        String result = DEFAULT_RESPONSE;
        // Assume option isn't recognized

        // Process the user request based on the option parameter

        option = option.toLowerCase();
        if (option.equals(COMMAND_LINE)) {
            // User requested command line. If args has no entries,
            // use the result that's already set
            if (args.length > 0) {
                result = args[0];
            }
        } // End if
        else if (option.equals(FROM_USER)) {
            keyboard = new Scanner(System.in);
            System.out.print("Please enter a file number: ");
            result = keyboard.nextLine();
        } // End else if
        // If option isn't recognized, the result variable is already set

        // Before returning, convert a single digit result to "0" followed
        // by that digit

        if (result.length() == 1) {
            if (Character.isDigit(result.charAt(0))) {
                result = "0" + result;
            }
        }

        return result;

    } // End 2-arg getFileNumber

    //************************************************************************

    // Method 2. 1-arg method. See above for the parameters and return

    public static String getFileNumber(String[] args) {

        return getFileNumber(args, "Command Line");

    } // End 1-arg method

    //************************************************************************

    // Method 3. no-arg method

    // Since we're not using args, create a filler array that takes the place
    // of args

    public static String getFileNumber() {
        String[] fillerNameForArgs = { "" };

        return getFileNumber(fillerNameForArgs, "From User");
    } // End no-arg method

} // End class
