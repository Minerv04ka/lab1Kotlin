package school

class Course(val courseId: String, val name: String, val credits: Int) {
    val students: MutableList<Student> = mutableListOf()
    val grades: MutableMap<Student, Double> = mutableMapOf()

    fun addStudent(student: Student) {
        students.add(student)
        student.courses.add(this)
        println("Студент ${student.name} доданий до курсу $name.")
    }

    fun removeStudent(student: Student) {
        students.remove(student)
        student.courses.remove(this)
        grades.remove(student)
        println("Студент ${student.name} видалений з курсу $name.")
    }

    fun assignGrade(student: Student, grade: Double) {
        if (students.contains(student)) {
            grades[student] = grade
            println("Оцінка $grade призначена студенту ${student.name} на курсі $name.")
        }
    }

    fun getAverageGrade(): Double {
        return if (grades.isNotEmpty()) grades.values.average() else 0.0
    }
}
