class Test{
	public static void main(String[] args) {
		Course c = new Course("Star Burst", "48763", 10, "Kirito");
		Student a = new Student("UGO的上半身", 1, "123");
		Student b = new Student("UGO的下半身", 0, "456");
		c.addStudent(a,b);
		a.printElement();
		c.deleteStudent(a, b);
		a.printElement();
		c.printElement();
	}
}