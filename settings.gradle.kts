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

rootProject.name = "ComposePreperations"
include(":app")
include(":mathgame")
include(":sideeffects")
include(":jetpackcomposebasiccodelab")
include(":stateincmposecodelab")
