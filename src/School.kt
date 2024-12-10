package school

class School {
    val students: MutableList<Student> = mutableListOf()
    val instructors: MutableList<Instructor> = mutableListOf()
    val courses: MutableList<Course> = mutableListOf()

    fun addStudent(student: Student) {
        students.add(student)
        println("Додано студента: ${student.name}.")
    }

    fun addInstructor(instructor: Instructor) {
        instructors.add(instructor)
        println("Додано викладача: ${instructor.name}.")
    }

    fun addCourse(course: Course) {
        courses.add(course)
        println("Додано курс: ${course.name}.")
    }

    fun assignStudentToCourse(student: Student, course: Course) {
        course.addStudent(student)
    }

    fun assignInstructorToCourse(instructor: Instructor, course: Course) {
        instructor.courses.add(course)
        println("Викладач ${instructor.name} призначений до курсу ${course.name}.")
    }

    fun getStudentReport(studentId: String): String {
        val student = students.find { it.id == studentId }
        return if (student != null) {
            val grades = student.getGrades()
            val average = student.getAverageGrade()
            """
                Звіт про успішність студента ${student.name}:
                Оцінки: ${grades.entries.joinToString { "${it.key}: ${it.value}" }}
                Середня оцінка: $average
            """.trimIndent()
        } else {
            "Студента з ID $studentId не знайдено."
        }
    }

    fun getCourseReport(courseId: String): String {
        val course = courses.find { it.courseId == courseId }
        return if (course != null) {
            val average = course.getAverageGrade()
            """
                Звіт по курсу ${course.name}:
                Середня оцінка по курсу: $average
            """.trimIndent()
        } else {
            "Курс з ID $courseId не знайдено."
        }
    }
}
