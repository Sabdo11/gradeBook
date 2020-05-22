package GradeBook.models;

/**
 * The GradeItem class - the purpose of this class is to create a grade item for various courses.
 * project: # 1
 * IDE: Eclipse
 * Operating System : OSX
 * @author selamawitabdo
 * @Date:08/27/2019
 * @version : 0.1
 */
public class GradeItem {

	
	private String studentId;      // Student Id
    private int gradeItemId;       // Grade Item Id
    private String courseId;       // Course Id
    private String itemType;       // Item Type
    private String date;           // Date
    private int maximumScore;      // Maximum Score 
    private int actualScore;       // Actual Score

	/** The grade item types. */
	private String[] gradeItemTypes = { "HW", "Quiz", "Class Work", "Test", "Final" };

	/**
	 * Instantiates a new grade item.
	 *
	 * @param studentId    the student id
	 * @param gradeItemId  the grade item id
	 * @param courseId     the course id
	 * @param itemType     the item type
	 * @param date         the date
	 * @param maximumScore the maximum score
	 * @param actualScore  the actual score
	 */
	public GradeItem(String studentId, int gradeItemId, String courseId, String itemType, String date, int maximumScore,
			int actualScore) {

		// Check if student id is either null or blank
		if (validateInput(studentId) == false) {
			throw new IllegalArgumentException("Student's id is either invalid or empty");
		} 
		
		// Check if course id is either null or blank
		else if (validateInput(courseId) == false) {
			throw new IllegalArgumentException("Course id is either invalid or empty");
		} 
		
		// Check if item type is either null or blank
		else if (validateInput(itemType) == false) {
			throw new IllegalArgumentException("ItemType is either invalid or empty");
		} 
		
		// Check if date is either null or blank
		else if (validateInput(date) == false) {
			throw new IllegalArgumentException("Date is either invalid or empty");
		}

		
		//Check if item type is one of the grade items types defined in the array.
		
		if (isItemTypeValid(itemType)) {

			
			 // Checks if the grade item,maximum score, is greater than 0 and the actual
			 // score is between 0 and maximum score
			if (gradeItemId <= 0) {
				throw new IllegalArgumentException("Grade item id can not be 0");
			} 
			
			// Check if maximum score is greater than 0 
			else if (maximumScore <= 0) {
				throw new IllegalArgumentException("Maximum score can not be negative or 0");
			} 
			// Check if actual score is greater than 0 
			else if (actualScore <= 0) {
				throw new IllegalArgumentException("Actual score can not be 0");
			} 
			
			// Check if actual score is less than the maximum score 
			else if (actualScore > maximumScore) {
				throw new IllegalArgumentException(" Actual score ("+ actualScore +" ) can not be more than the Maximum" +
						" score which is "+ maximumScore);

			} else

			{

				this.studentId = studentId;
				this.gradeItemId = gradeItemId;
				this.courseId = courseId;
				this.itemType = itemType;
				this.date = date;
				this.maximumScore = maximumScore;
				this.actualScore = actualScore;

			}

		} else {
			throw new IllegalArgumentException("This ItemType is not on the itemtype list ");
		}

	}


	/****************************** Accessor and Class Methods  ************************************ /
	 /** Gets the student id.
	 * @return the studentId
	 */
	public String getStudentId() {
		return studentId;
	}

	/**
	 * Gets the grade item id.
	 * @return the gradeItemId
	 */
	public int getGradeItemId() {
		return gradeItemId;
	}

	/**
	 * Gets the course id.
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}

	/**
	 * Gets the item type.
	 * @return the itemType
	 */
	public String getItemType() {
		return itemType;
	}

	/**
	 * Gets the date.
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Gets the maximum score.
	 * @return the maximumScore
	 */
	public int getMaximumScore() {
		return maximumScore;
	}

	/**
	 * Gets the actual score.
	 * @return the actualScore
	 */
	public int getActualScore() {
		return actualScore;
	}

	//*************************************************************************
	
	/**
	 * Validate input.
	 *@param input the input
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
	 * Gets the grade item types.
	 * @return the gradeItemTypes
	 */
	private String[] getGradeItemTypes() {
		return gradeItemTypes;
	}
	
	//*************************************************************************

	/**
	 * returns true if the item type is one of the grade type items.
	 * @param itemType the item type
	 * @return true, if is item type valid
	 */
	private boolean isItemTypeValid(String itemType) {

		String[] gradeItems = this.getGradeItemTypes();

		for (int i = 0; i < gradeItems.length; i++) {

			if (gradeItems[i].equals(itemType)) {

				return true;
			}

		}

		return false;
	}

//****************************************************************************	

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
		GradeItem other = (GradeItem) obj;
		if (actualScore != other.actualScore)
			return false;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (gradeItemId != other.gradeItemId)
			return false;
		if (itemType == null) {
			if (other.itemType != null)
				return false;
		} else if (!itemType.equals(other.itemType))
			return false;
		if (maximumScore != other.maximumScore)
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
	 * The string representation of the Grade Item object. 
	 *@return the string
	 */
	@Override
	public String toString() {
		return "GradeItem [student Id = " + studentId + ", grade ItemId = " + gradeItemId + ", course Id = " + courseId
				+ ", item Type = " + itemType + ", date = " + date + ", maximum Score = " + maximumScore +
				", actual Score = "
				+ actualScore + "]";
	}

}// end gradeitem class
