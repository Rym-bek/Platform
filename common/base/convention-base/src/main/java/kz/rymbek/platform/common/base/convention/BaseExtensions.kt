package kz.rymbek.platform.common.base.convention

import libs
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project
import org.gradle.plugin.use.PluginDependency

fun Project.applyPlugin(plugin: Provider<PluginDependency>) {
    pluginManager.apply(plugin.get().pluginId)
}

fun Project.applyPlugin(plugin: LibrariesForLibs.KotlinPluginAccessors) {
    pluginManager.apply(plugin.asProvider().get().pluginId)
}

fun DependencyHandlerScope.implementation(
    dependency: Provider<MinimalExternalModuleDependency>
) {
    add("implementation", dependency)
}

fun DependencyHandlerScope.implementation(
    path: String,
) {
    add("implementation", project(path))
}

fun DependencyHandlerScope.ksp(
    dependency: Provider<MinimalExternalModuleDependency>
) {
    add("ksp", dependency)
}

fun DependencyHandlerScope.debugImplementation(
    dependency: Provider<MinimalExternalModuleDependency>
) {
    add("debugImplementation", dependency)
}

val Project.projectJavaVersion: JavaVersion
    get() = JavaVersion.toVersion(libs.versions.java.get().toInt())