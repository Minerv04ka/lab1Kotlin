package school

fun main() {
    val school = School()

    // Створення студентів
    val student1 = Student("s1", "Олександр", "alex@example.com")
    val student2 = Student("s2", "Марія", "maria@example.com")

    // Створення викладача
    val instructor = Instructor("i1", "Іван Іванович", "ivan@example.com")

    // Створення курсів
    val course1 = Course("c1", "Математика", 4)
    val course2 = Course("c2", "Фізика", 3)

    // Додавання даних до школи
    school.addStudent(student1)
    school.addStudent(student2)
    school.addInstructor(instructor)
    school.addCourse(course1)
    school.addCourse(course2)

    // Призначення студентів до курсів
    school.assignStudentToCourse(student1, course1)
    school.assignStudentToCourse(student2, course1)
    school.assignStudentToCourse(student1, course2)

    // Призначення викладача до курсу
    school.assignInstructorToCourse(instructor, course1)

    // Призначення оцінок
    instructor.gradeStudent(course1, student1, 90.0)
    instructor.gradeStudent(course1, student2, 85.0)

    // Отримання звіту про успішність студентів і курсів
    println(school.getStudentReport("s1"))
    println(school.getCourseReport("c1"))
}
