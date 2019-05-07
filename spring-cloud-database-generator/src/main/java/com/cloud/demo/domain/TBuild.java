package com.cloud.demo.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_build")
public class TBuild {
    @Id
    @Column(name = "build_id")
    private String buildId;

    @Column(name = "build_name")
    private String buildName;

    @Column(name = "build_number")
    private String buildNumber;

    @Column(name = "build_time")
    private Date buildTime;

    @Column(name = "build_log_file_path")
    private String buildLogFilePath;

    @Column(name = "build_workspace_folder_path")
    private String buildWorkspaceFolderPath;

    @Column(name = "host_address")
    private String hostAddress;

    @Column(name = "maven_project")
    private Byte mavenProject;

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
     * @return build_name
     */
    public String getBuildName() {
        return buildName;
    }

    /**
     * @param buildName
     */
    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    /**
     * @return build_number
     */
    public String getBuildNumber() {
        return buildNumber;
    }

    /**
     * @param buildNumber
     */
    public void setBuildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
    }

    /**
     * @return build_time
     */
    public Date getBuildTime() {
        return buildTime;
    }

    /**
     * @param buildTime
     */
    public void setBuildTime(Date buildTime) {
        this.buildTime = buildTime;
    }

    /**
     * @return build_log_file_path
     */
    public String getBuildLogFilePath() {
        return buildLogFilePath;
    }

    /**
     * @param buildLogFilePath
     */
    public void setBuildLogFilePath(String buildLogFilePath) {
        this.buildLogFilePath = buildLogFilePath;
    }

    /**
     * @return build_workspace_folder_path
     */
    public String getBuildWorkspaceFolderPath() {
        return buildWorkspaceFolderPath;
    }

    /**
     * @param buildWorkspaceFolderPath
     */
    public void setBuildWorkspaceFolderPath(String buildWorkspaceFolderPath) {
        this.buildWorkspaceFolderPath = buildWorkspaceFolderPath;
    }

    /**
     * @return host_address
     */
    public String getHostAddress() {
        return hostAddress;
    }

    /**
     * @param hostAddress
     */
    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    /**
     * @return maven_project
     */
    public Byte getMavenProject() {
        return mavenProject;
    }

    /**
     * @param mavenProject
     */
    public void setMavenProject(Byte mavenProject) {
        this.mavenProject = mavenProject;
    }
}