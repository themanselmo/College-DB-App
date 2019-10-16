package model;

public class College {
	private PersonBag personBag;
	private TextbookBag textbookBag;
	private CourseBag courseBag;
	private final int PERSONBAG_MAXSIZE = 10;
	private final int TEXTBOOKBAG_MAXSIZE = 10;
	private final int COURSEBAG_MAXSIZE = 10;
	
	public College() {
		personBag = new PersonBag(PERSONBAG_MAXSIZE);
		textbookBag = new TextbookBag(TEXTBOOKBAG_MAXSIZE);
		courseBag = new CourseBag(COURSEBAG_MAXSIZE);
	}

	public PersonBag getPersonBag() {
		return personBag;
	}

	public void setPersonBag(PersonBag personBag) {
		this.personBag = personBag;
	}

	public TextbookBag getTextbookBag() {
		return textbookBag;
	}

	public void setTextbookBag(TextbookBag textbookBag) {
		this.textbookBag = textbookBag;
	}
	
	public CourseBag getCourseBag() {
		return courseBag;
	}
	
	public void setCourseBag(CourseBag courseBag) {
		this.courseBag = courseBag;
	}
	
	public void save() {
		personBag.save();
		textbookBag.save();
		courseBag.save();
	}
	
	public void load() {
		personBag.load();
		textbookBag.load();
		courseBag.load();
	}
	
	
	
	
	
	
	
}
