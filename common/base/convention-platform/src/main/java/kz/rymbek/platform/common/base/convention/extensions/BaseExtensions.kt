package kz.rymbek.platform.common.base.convention.extensions

import org.gradle.accessors.dm.LibrariesForPlatformLibs
import org.gradle.accessors.dm.LibrariesForProjectLibs
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.NamedDomainObjectProvider
import org.gradle.api.NamedDomainObjectSet
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project
import org.gradle.plugin.devel.PluginDeclaration
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependency

fun NamedDomainObjectContainer<PluginDeclaration>.conventionPlugin(
    pluginIdProvider: Provider<PluginDependency>,
    implementationClass: String
): NamedDomainObjectProvider<PluginDeclaration> {
    return register(implementationClass) {
        id = pluginIdProvider.get().pluginId
        this.implementationClass = implementationClass
    }
}

fun Project.applyPlugin(plugin: Provider<PluginDependency>) {
    pluginManager.apply(plugin.get().pluginId)
}

inline fun <reified T : Plugin<Project>> Project.applyPlugin() {
    pluginManager.apply(T::class.java)
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