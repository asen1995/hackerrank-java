public class BadCodeExample {
    public void processStudentRecords(List<Student> students) {
        // Input validation
        if (students == null) {
            throw new IllegalArgumentException("Student list cannot be null");
        }
        if (students.isEmpty()) {
            throw new IllegalArgumentException("Student list cannot be empty");
        }

        // Data processing
        Map<String, List<Student>> studentsByGrade = new HashMap<>();
        List<Student> failedStudents = new ArrayList<>();

        for (Student student : students) {
            if (student.getGrade() < 1 || student.getGrade() > 12) {
                throw new IllegalArgumentException("Invalid grade for student: " + student.getName());
            }

            if (student.getScore() < 0 || student.getScore() > 100) {
                throw new IllegalArgumentException("Invalid score for student: " + student.getName());
            }

            // Categorize students by grade
            List<Student> gradeStudents = studentsByGrade.getOrDefault(student.getGrade(), new ArrayList<>());
            gradeStudents.add(student);
            studentsByGrade.put(student.getGrade(), gradeStudents);

            // Check if the student failed
            if (student.getScore() < 60) {
                failedStudents.add(student);
            }
        }

        // Calculate average scores for each grade
        Map<Integer, Double> averageScoresByGrade = new HashMap<>();
        for (Map.Entry<String, List<Student>> entry : studentsByGrade.entrySet()) {
            int grade = Integer.parseInt(entry.getKey());
            List<Student> gradeStudents = entry.getValue();
            double totalScore = 0;
            for (Student student : gradeStudents) {
                totalScore += student.getScore();
            }
            double averageScore = totalScore / gradeStudents.size();
            averageScoresByGrade.put(grade, averageScore);
        }

        // Calculate overall average score
        double totalScore = 0;
        for (Student student : students) {
            totalScore += student.getScore();
        }
        double overallAverageScore = totalScore / students.size();

        // Identify top students
        List<Student> topStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getScore() >= 90) {
                topStudents.add(student);
            }
        }

        // Print results
        System.out.println("Average scores by grade:");
        for (Map.Entry<Integer, Double> entry : averageScoresByGrade.entrySet()) {
            System.out.println("Grade " + entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Overall average score: " + overallAverageScore);

        System.out.println("Top students:");
        for (Student student : topStudents) {
            System.out.println(student.getName() + " (Grade: " + student.getGrade() + ", Score: " + student.getScore() + ")");
        }

        System.out.println("Failed students:");
        for (Student student : failedStudents) {
            System.out.println(student.getName() + " (Grade: " + student.getGrade() + ", Score: " + student.getScore() + ")");
        }
    }

    // ... other unrelated methods and code
}
