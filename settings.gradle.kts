pluginManagement {
	repositories {
		bintray("kotlin/kotlin-eap")
		gradlePluginPortal()
	}
}

rootProject.name = "KT-29317"


fun RepositoryHandler.bintray(name: String) =
	maven("https://dl.bintray.com/$name")
