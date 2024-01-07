pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Nextflix"
include(":app")
include(":core")
include(":core-network")
include(":core-local")
include(":home-ui")
include(":login-ui")
include(":movie-ui")
include(":core_ui")
