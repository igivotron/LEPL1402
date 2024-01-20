package fp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * In this exercise, you must implement operations on streams of
 * "Student" objects, which represent students following a set of
 * courses.
 */
public class StudentStream {

    /**
     * Class representing the grade received by a student in a course.
     **/
    public static class Grade {
        private String course;
        private double value;

        public Grade(String course,
                     double value) {
            this.course = course;
            this.value = value;
        }

        /**
         * Return the name of the course.
         **/
        public String getCourse() {
            return course;
        }

        /**
         * Return the grade of the course.
         **/
        public double getValue() {
            return value;
        }
    }


    /**
     * Class encoding a student together with her or his grades.
     **/
    public static class Student {
        private String firstName;
        private String lastName;
        private int section;
        private Map<String, Double> grades = new HashMap<>();

        public Student(String firstName,
                       String lastName,
                       int section) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.section = section;
        }

        /**
         * Get the first name of the student.
         **/
        public String getFirstName() {
            return firstName;
        }

        /**
         * Get the last name of the student.
         **/
        public String getLastName() {
            return lastName;
        }

        /**
         * Get the section of the student, as an integer value.
         **/
        public int getSection() {
            return section;
        }

        /**
         * Record the grade of the student for a course.
         **/
        public void addGrade(String course,
                             double grade) {
            if (hasGrade(course)) {
                throw new IllegalArgumentException("Student has already a grade for course: " + course);
            } else {
                grades.put(course, grade);
            }
        }

        /**
         * Return true iff. a grade is available for a course of interest.
         **/
        public boolean hasGrade(String course) {
            return grades.containsKey(course);
        }

        /**
         * Get the grade of the student for a course.
         **/
        public double getGrade(String course) {
            if (hasGrade(course)) {
                return grades.get(course);
            } else {
                throw new IllegalArgumentException("Student has no grade for course: " + course);
            }
        }

        /**
         * Return the stream of all the grades that are available for
         * the student.
         **/
        public Stream<Grade> getGradesStream() {
            List<Grade> lst = new ArrayList<>();
            for (Map.Entry<String, Double> entry : grades.entrySet()) {
                lst.add(new Grade(entry.getKey(), entry.getValue()));
            }
            return lst.stream();
        }
    }


    /**
     * Class that encodes a predicate for one course of the
     * student. It associates the name of the course of interest, with
     * the predicate on the grade for this course.
     **/
    public static class CourseCondition {
        private String course;
        private Predicate<Double> valuePredicate;

        public CourseCondition(String course,
                               Predicate<Double> valuePredicate) {
            this.course = course;
            this.valuePredicate = valuePredicate;
        }

        /**
         * Return the name of the course.
         **/
        public String getCourse() {
            return course;
        }

        /**
         * Return the predicate on the value obtained by the students
         * for this course.
         **/
        public Predicate<Double> getValuePredicate() {
            return valuePredicate;
        }
    }


    /**
     * Class that represents a set of conditions to be verified by a
     * student. These conditions are used to filter students in a
     * stream.
     **/
    public static class StudentConditions {
        /**
         * The predicate for the first name of the students. Might be
         * "null" if no test must be done on the first name.
         **/
        private Predicate<String> firstNamePredicate;
        
        /**
         * The predicate for the last name of the students. Might be
         * "null" if no test must be done on the last name.
         **/
        private Predicate<String> lastNamePredicate;

        /**
         * The predicate for the section of the students. Might be
         * "null" if no test must be done on the section.
         **/
        private Predicate<Integer> sectionPredicate;

        /**
         * A list of predicates to individually filter the different
         * courses.
         **/
        private List<CourseCondition> courseConditions = new ArrayList<>();

        public void setFirstNamePredicate(Predicate<String> predicate) {
            this.firstNamePredicate = predicate;
        }

        public void setLastNamePredicate(Predicate<String> predicate) {
            this.lastNamePredicate = predicate;
        }

        public void setSectionPredicate(Predicate<Integer> predicate) {
            this.sectionPredicate = predicate;
        }

        public void addCoursePredicate(String course,
                                       Predicate<Double> valuePredicate) {
            courseConditions.add(new CourseCondition(course, valuePredicate));
        }

        /**
         * Returns true iff. the student given in argument matches all
         * the predicates.
         **/
        public boolean isMatch(Student student) {
            // TODO
            if (firstNamePredicate != null && !firstNamePredicate.test(student.getFirstName())) return false;
            if (lastNamePredicate != null && !lastNamePredicate.test(student.getLastName())) return false;
            if (sectionPredicate != null && !sectionPredicate.test(student.getSection())) return false;
            for (CourseCondition c:courseConditions){
                if(!student.hasGrade(c.getCourse()) || c.getValuePredicate().test(student.getGrade(c.getCourse()))) return false;
            }
            return true;
        }
    }


    /**
     * Class that represents the average grade of a student.
     **/
    public static class StudentAverage {
        private String firstName;
        private String lastName;
        private double average;

        /**
         * Construct an average grade from the first name of the
         * student, from the last name of the student, and from the
         * grade of the student.
         **/
        public StudentAverage(String firstName,
                              String lastName,
                              double average) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.average = average;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public double getAverage() {
            return average;
        }
    }


    /**
     * Return the stream of student(s) that match the given
     * conditions, given an input stream of student(s).
     **/
    public static Stream<Student> findAll(Stream<Student> students,
                                          StudentConditions conditions) {
        return students.filter(s -> conditions.isMatch(s));
    }


    /**
     * Return the first student that matches the given conditions,
     * given an input stream of student(s). If there is no match,
     * return "null".
     **/
    public static Student findFirst(Stream<Student> students,
                                    StudentConditions conditions) {
        Optional<Student> studentOptional = students.filter(s -> conditions.isMatch(s)).findFirst();
        if(studentOptional.isPresent()) return studentOptional.get();
        return null;
    }


    /**
     * Return true if there are at least "n" students that match the
     * given conditions, given an input stream of student(s).
     **/
    public static boolean exists(Stream<Student> students,
                                 StudentConditions conditions,
                                 long n) {

        return students.filter(s -> conditions.isMatch(s)).count() >= n;
    }


    /**
     * Return a stream of student(s) that match the given conditions
     * in an input stream of student(s), ordered according to the
     * provided comparator.
     **/
    public static Stream<Student> filterThenSort(Stream<Student> students,
                                                 StudentConditions conditions,
                                                 Comparator<Student> comparator) {
        return students.filter(s->conditions.isMatch(s)).sorted(comparator);
    }


    /**
     * Return a stream containing the N°2 and N°3 top students for the
     * course name given as parameter. Note that the N°1 student must
     * be skipped.
     **/
    public static Stream<Student> findSecondAndThirdTopStudentForGivenCourse(Stream<Student> students, String name) {
        // TODO
         return students.sorted((alice, bob) ->{
             if (alice.getGrade(name) > bob.getGrade(name)) return -1;
             else if (alice.getGrade(name) < bob.getGrade(name)) return 1;
             return 0;
         }).skip(1).limit(2);
    }


    /**
     * Return a stream that contains, for each student in the given
     * section, their average grade over all of their courses.
     **/
    public static Stream<StudentAverage> computeAverageForStudentInSection(Stream<Student> students, int section) {
        // TODO
        return students.filter(s -> s.getSection() == section).map(s ->{
            double average = s.getGradesStream().map(x->x.getValue()).reduce(0.0, (a,b) -> a+b)/s.getGradesStream().count();
            return new StudentAverage(s.getFirstName(), s.getLastName(), average);
        });
    }


    /**
     * Return the number of students that passed all courses (i.e.,
     * all grades > 10.0).
     **/
    public static long getNumberOfSuccessfulStudents(Stream<Student> students) {
         return students.filter(s -> s.getGradesStream().allMatch(g -> g.getValue()>10.0)).count();
    }


    /**
     * Return the last student in lexicographic order (i.e., first
     * compare against their last name, then against their first
     * name). If there is no such student, return "null".
     **/
    public static Student findLastInLexicographicOrder(Stream<Student> students) {
        return students.sorted((alice, bob)->{
            int last = alice.getLastName().compareTo(bob.getLastName());
            if(last == 0) return alice.getFirstName().compareTo(bob.getFirstName());
            return last;
        }).reduce(null, (alice, bob)->bob);
    }


    /**
     * Return the total sum of all the grades obtained by all the
     * students, for all of their courses.
     **/
    public static double getFullSum(Stream<Student> students) {
        return students.map(s -> s.getGradesStream().map(x -> x.getValue()).reduce(0.0,(a,b) -> a+b)).reduce(0.0, (a,b)->a+b);
    }
}
