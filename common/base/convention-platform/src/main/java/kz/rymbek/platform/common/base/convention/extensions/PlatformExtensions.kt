package kz.rymbek.platform.common.base.convention.extensions

import org.gradle.accessors.dm.LibrariesForPlatformLibs
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.the
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

val Project.platformLibs: LibrariesForPlatformLibs
    get() = the<LibrariesForPlatformLibs>()

val Project.projectJavaVersion: JavaVersion
    get() = JavaVersion.toVersion(platformLibs.versions.java.get().toInt())

val Project.projectJvmTarget: JvmTarget
    get() = JvmTarget.fromTarget(platformLibs.versions.java.get())

fun Project.applyPlugin(plugin: LibrariesForPlatformLibs.KotlinPluginAccessors) {
    pluginManager.apply(plugin.asProvider().get().pluginId)
}

fun Project.applyPlugin(plugin: LibrariesForPlatformLibs.ConventionLibraryPluginAccessors) {
    pluginManager.apply(plugin.asProvider().get().pluginId)
}

fun DependencyHandlerScope.debugImplementation(
    dependency: LibrariesForPlatformLibs.AndroidxComposeUiToolingLibraryAccessors
) {
    add("debugImplementation", dependency)
}