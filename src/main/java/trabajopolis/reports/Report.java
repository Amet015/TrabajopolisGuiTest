/*
 * Copyright (c) 2019 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into
 *  with Jalasoft.
 */

package trabajopolis.reports;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.Feature;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Create a Report
 */

public class Report {

    public static Report getInstance() {
        return new Report();
    }

    /**
     * This method set up and create a report.
     */
    public void generateReport() {
        final File reportOutputDirectory = new File("target");
        final List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("build/cucumber/cucumber.json");
        final String projectName = "TrabajopolisTest";
        final boolean runWithJenkins = false;
        Feature feature = new Feature();
        feature.getName();
        final Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.addClassifications("Page", "Trabajopolis");
        final ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        final Reportable result = reportBuilder.generateReports();
    }
}
