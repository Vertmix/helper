rootProject.name = "supervisor"

listOf(
    "helper"
).forEach { setupProject("${it.replace("/", "-")}", file(it)) }

fun setupProject(name: String, projectDirectory: File) = setupProject(name) {
    projectDir = projectDirectory
}

inline fun setupProject(name: String, block: ProjectDescriptor.() -> Unit) {
    include(name)
    project(":$name").apply(block)
}
