package com.cloud.demo.domain;

import javax.persistence.*;

@Table(name = "t_build_dependency")
public class TBuildDependency {
    @Column(name = "dependency_id")
    private String dependencyId;

    @Column(name = "build_id")
    private String buildId;

    private String name;

    private String packaging;

    @Column(name = "group_id")
    private String groupId;

    @Column(name = "artifact_id")
    private String artifactId;

    private String version;

    private String scope;

    private String parent;

    @Column(name = "parent_type")
    private String parentType;

    /**
     * @return dependency_id
     */
    public String getDependencyId() {
        return dependencyId;
    }

    /**
     * @param dependencyId
     */
    public void setDependencyId(String dependencyId) {
        this.dependencyId = dependencyId;
    }

    /**
     * @return build_id
     */
    public String getBuildId() {
        return buildId;
    }

    /**
     * @param buildId
     */
    public void setBuildId(String buildId) {
        this.buildId = buildId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return packaging
     */
    public String getPackaging() {
        return packaging;
    }

    /**
     * @param packaging
     */
    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    /**
     * @return group_id
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * @param groupId
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * @return artifact_id
     */
    public String getArtifactId() {
        return artifactId;
    }

    /**
     * @param artifactId
     */
    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    /**
     * @return version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return scope
     */
    public String getScope() {
        return scope;
    }

    /**
     * @param scope
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * @return parent
     */
    public String getParent() {
        return parent;
    }

    /**
     * @param parent
     */
    public void setParent(String parent) {
        this.parent = parent;
    }

    /**
     * @return parent_type
     */
    public String getParentType() {
        return parentType;
    }

    /**
     * @param parentType
     */
    public void setParentType(String parentType) {
        this.parentType = parentType;
    }
}