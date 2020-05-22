package GradeBook.models;

/**
 * The student Class - The purpose of this class is to track a student by using
 * there student id, first name , last name and email address.
 * 
 * project: # 1
 * IDE: Eclipse
 * Operating System : OSX
 *  
 * Perspicuity: It refers to something that can be seen through, clearness of style or exposition, freedom from obscurity
 *
 * “The Pessimist Sees Difficulty In Every Opportunity. The Optimist Sees Opportunity In Every Difficulty.” 
 *  The auther of this quote is Winston Churchill Winston Churchill is Former British Prime Minister, who was born in November 30 1874 and died on January 24 1965
 *         
 *  @author selamawit abdo
 *  @Date:08/27/2019
 *  @version : 0.1
 *
 */
public class Student {

	
	private String studentId;     //Student Id
    private String firstName;     // First name 
    private String lastName;      // Last name 
    private String emailAddress;   // Email address

	/**
	 * Instantiates a new student.
	 *
	 * @param studentId    the student id
	 * @param firstName    the first name
	 * @param lastName     the last name
	 * @param emailAddress the email address
	
	 */
	public Student(String studentId, String firstName, String lastName, String emailAddress) {

		// Check if student id is either nul
		if (validateInput(studentId) == false) {
			throw new IllegalArgumentException("Student's id is either invalid or empty");
		} 
		
		// Check if first name is either null or blank
		else if (validateInput(firstName) == false) {
			throw new IllegalArgumentException("Student's first name is either invalid or empty");
		} 
		
		// Check if last name is either null or blank
		else if (validateInput(lastName) == false) {
			throw new IllegalArgumentException("Student's last name is either invalid or empty");
		} 
		
		// Check if email address is either null or blank
		else if (validateInput(emailAddress) == false) {
			throw new IllegalArgumentException("Student's email address is either invalid or empty");
		} 
		
		else {

			// Check if email address contains the character '@'
			if (isEmailValid(emailAddress) == false) {
				throw new IllegalArgumentException("Email address: '" + emailAddress + "' has no required @");
			} 
			
			else {

				this.studentId = studentId;
				this.firstName = firstName;
				this.lastName = lastName;
				this.emailAddress = emailAddress;

			}

		}
	}

/****************************** Accessor and Class Methods  ************************************ /
	
	/**
	 * Gets the email address.
	 * @return the email address
	 */
	public String getEmailAddress() {
		return emailAddress;
	} // End get 

	/**
	 * Gets the last name.
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	} // End get

	/**
	 * Gets the first name.
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}  //End get

	/**
	 * Gets the student id.
	 * @return the student id
	 */
	public String getStudentId() {
		return studentId;
	}// End get

	//*************************************************************************
	
	/**
	 * Equals.
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		return true;
	}

	//*************************************************************************
	
	/**
	 * Check if the string is either null or blank
	 * @param input the input
	 * @return true, if successful
	 */
	private boolean validateInput(String input) {
		if (input.isBlank() || input == null) {
			return false;
		} else {
			return true;
		}

	}

	//*************************************************************************
	
	/**
	 * Checks if the email address contains the character '@' 
	 * @param email the email
	 * @return true, if is email valid
	 */
	private boolean isEmailValid(String email) {

		if (email.contains("@")) {
			return true;
		}

		return false;

	}

	//*************************************************************************
	
	/**
	 * 
	 * The string representation of the student object. 
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Student [student Id = " + studentId + ", first Name = " + firstName + ", last Name = " + lastName
				+ ", email Address = " + emailAddress + "]";
	}

}// end student class
