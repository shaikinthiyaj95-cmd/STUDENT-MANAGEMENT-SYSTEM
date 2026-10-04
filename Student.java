public class Student {
    private int studentId;
    private String name;
    private int age;
    private String department;
    private String email;
    private String phone;
    private double mark1, mark2, mark3;
    private double totalMarks;
    private double percentage;
    private String grade;

    public Student() {}

    public Student(String name, int age, String department, String email, String phone, double mark1, double mark2, double mark3) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.email = email;
        this.phone = phone;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        calculatePerformance();
    }

    public final void calculatePerformance() {
        this.totalMarks = mark1 + mark2 + mark3;
        this.percentage = totalMarks / 3.0;
        if (percentage >= 90) this.grade = "A+";
        else if (percentage >= 80) this.grade = "A";
        else if (percentage >= 70) this.grade = "B";
        else if (percentage >= 60) this.grade = "C";
        else if (percentage >= 50) this.grade = "D";
        else this.grade = "F";
    }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public double getMark1() { return mark1; }
    public void setMark1(double mark1) { this.mark1 = mark1; }
    public double getMark2() { return mark2; }
    public void setMark2(double mark2) { this.mark2 = mark2; }
    public double getMark3() { return mark3; }
    public void setMark3(double mark3) { this.mark3 = mark3; }
    public double getTotalMarks() { return totalMarks; }
    public void setTotalMarks(double totalMarks) { this.totalMarks = totalMarks; }
    public double getPercentage() { return percentage; }
    public void setPercentage(double percentage) { this.percentage = percentage; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}