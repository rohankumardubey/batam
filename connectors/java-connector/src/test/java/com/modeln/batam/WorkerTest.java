package com.modeln.batam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.modeln.batam.connector.ConnectorHelper;
import com.modeln.batam.connector.wrapper.*;

/**
 * This test Suite is intended to test The worker Module.
 * @author gzussa
 *
 */
public class WorkerTest {

	@Test
	public void createNewBuildAndUpdate() throws IOException {
		//Create build
		String name = "build "+System.currentTimeMillis();
		BuildEntry build = new BuildEntry();
		build.setId("1_"+System.currentTimeMillis());
		build.setName(name);
		
		ConnectorHelper.createBuild(build);
		
		//Create update
		build.setDescription("desc");
		
		ConnectorHelper.updateBuild(build);
		
		ConnectorHelper.runAnalysis(build.getId(), null, false);
		
	}
	
	@Test
	public void createNewBuildAndUpdate2() throws IOException {
		//Create build
		String name = "build "+System.currentTimeMillis();
		String id = "2_"+System.currentTimeMillis();
		BuildEntry build = new BuildEntry();
		build.setId(id);
		build.setName(name);
		build.setDescription("desc");
		build.setStartDate(new Date());
		build.setEndDate(new Date(System.currentTimeMillis()+10000));
		build.setStatus("completed");
		
		List<Pair> criterias = new ArrayList<Pair>();
		criterias.add(new Pair("criterias1", "criterias1val"));
		criterias.add(new Pair("criterias2", "criterias2val"));
		build.setCriterias(criterias);
		
		List<Pair> infos = new ArrayList<Pair>();
		infos.add(new Pair("info1", "info1val"));
		infos.add(new Pair("info2", "info2val"));
		build.setInfos(infos);
		
		List<Pair> reports = new ArrayList<Pair>();
		reports.add(new Pair("reports1", "reports1val"));
		reports.add(new Pair("reports2", "reports2val"));
		build.setReports(reports);
		
		List<Step> steps = new ArrayList<Step>();
		steps.add(new Step("step1", new Date(), new Date(System.currentTimeMillis()+1000)));
		steps.add(new Step("step2", new Date(System.currentTimeMillis()+1000), new Date(System.currentTimeMillis()+2000)));
		build.setSteps(steps);
		
		List<Commit> commits = new ArrayList<Commit>();
		commits.add(new Commit(null, null, "1", "10", "100", new Date()));
		commits.add(new Commit(null, null, "2", "20", "200", new Date(System.currentTimeMillis()+1000)));
		build.setCommits(commits);
		
		ConnectorHelper.createBuild(build);
		
		//Create update
		build.setDescription("desc 2");
		build.setStartDate(new Date());
		build.setEndDate(new Date(System.currentTimeMillis()+10000));
		build.setStatus("completed 2");
		
		criterias = new ArrayList<Pair>();
		criterias.add(new Pair("criterias3", "criterias3val"));
		criterias.add(new Pair("criterias4", "criterias4val"));
		build.setCriterias(criterias);
		
		infos = new ArrayList<Pair>();
		infos.add(new Pair("info3", "info3val"));
		infos.add(new Pair("info4", "info4val"));
		build.setInfos(infos);
		
		reports = new ArrayList<Pair>();
		reports.add(new Pair("reports3", "reports3val"));
		reports.add(new Pair("reports4", "reports4val"));
		build.setReports(reports);
		
		steps = new ArrayList<Step>();
		steps.add(new Step("step3", new Date(), new Date(System.currentTimeMillis()+1000)));
		steps.add(new Step("step4", new Date(System.currentTimeMillis()+1000), new Date(System.currentTimeMillis()+2000)));
		build.setSteps(steps);
		
		commits = new ArrayList<Commit>();
		commits.add(new Commit(null, null, "3", "30", "300", new Date()));
		commits.add(new Commit(null, null, "4", "40", "400", new Date(System.currentTimeMillis()+1000)));
		build.setCommits(commits);
		
		ConnectorHelper.updateBuild(build);
		
		ConnectorHelper.runAnalysis(build.getId(), null, false);
		
	}
	
	@Test
	public void createBuildAndReports() throws IOException {
		//Create build
		String buildName = "build "+System.currentTimeMillis();
		String buildId = "3_"+System.currentTimeMillis();
		BuildEntry build = new BuildEntry();
		build.setId(buildId);
		build.setName(buildName);
		
		ConnectorHelper.createBuild(build);
		
		//Create report 1
		String reportId = "3_1_"+System.currentTimeMillis();
		ReportEntry report = new ReportEntry();
		report.setBuildName(buildName);
		report.setId(reportId);
		report.setName("report1");
		
		ConnectorHelper.createReport(report);
		
		//Create update
		build.setDescription("desc");
		
		ConnectorHelper.updateBuild(build);
		
		//Create report 2
		String report2Id = "3_2_"+System.currentTimeMillis();
		ReportEntry report2 = new ReportEntry();
		report2.setBuildName(buildName);
		report2.setName("report2");
		report2.setId(report2Id);
		
		ConnectorHelper.createReport(report2);
		
		//Update report 1
		report.setStatus("test");
		
		ConnectorHelper.updateReport(report);
		
		ConnectorHelper.runAnalysis(build.getId(), null, false);
		
	}
	
	@Test
	public void createBuildAndReports2() throws IOException {
		//Create build
		String buildName = "build "+System.currentTimeMillis();
		String buildId = "4_"+System.currentTimeMillis();
		BuildEntry build = new BuildEntry();
		build.setName(buildName);
		build.setId(buildId);
		build.setDescription("desc");
		build.setStartDate(new Date());
		build.setEndDate(new Date(System.currentTimeMillis()+10000));
		build.setStatus("completed");
		
		List<Pair> criterias = new ArrayList<Pair>();
		criterias.add(new Pair("criterias1", "criterias1val"));
		criterias.add(new Pair("criterias2", "criterias2val"));
		build.setCriterias(criterias);
		
		List<Pair> infos = new ArrayList<Pair>();
		infos.add(new Pair("info1", "info1val"));
		infos.add(new Pair("info2", "info2val"));
		build.setInfos(infos);
		
		List<Pair> reports = new ArrayList<Pair>();
		reports.add(new Pair("reports1", "reports1val"));
		reports.add(new Pair("reports2", "reports2val"));
		build.setReports(reports);
		
		List<Step> steps = new ArrayList<Step>();
		steps.add(new Step("step1", new Date(), new Date(System.currentTimeMillis()+1000)));
		steps.add(new Step("step2", new Date(System.currentTimeMillis()+1000), new Date(System.currentTimeMillis()+2000)));
		build.setSteps(steps);
		
		List<Commit> commits = new ArrayList<Commit>();
		commits.add(new Commit(null, null, "1", "10", "100", new Date()));
		commits.add(new Commit(null, null, "2", "20", "200", new Date(System.currentTimeMillis()+1000)));
		build.setCommits(commits);
		
		ConnectorHelper.createBuild(build);
		
		//Create Report 1
		String reportId = "4_1_"+System.currentTimeMillis();
		ReportEntry report = new ReportEntry();
		report.setBuildName(buildName);
		report.setBuildId(buildId);
		report.setId(reportId);
		report.setName("report1");
		report.setDescription("report desc");
		report.setStartDate(new Date());
		report.setEndDate(new Date(System.currentTimeMillis() +10000));
		report.setStatus("pending");
		
		List<String> logs = new ArrayList<String>();
		logs.add("logs 1");
		logs.add("logs 2");
		report.setLogs(logs);
		
		ConnectorHelper.createReport(report);
		
		//Update build
		build.setDescription("desc 2");
		build.setStartDate(new Date());
		build.setEndDate(new Date(System.currentTimeMillis()+10000));
		build.setStatus("completed 2");
		
		criterias = new ArrayList<Pair>();
		criterias.add(new Pair("criterias3", "criterias3val"));
		criterias.add(new Pair("criterias4", "criterias4val"));
		build.setCriterias(criterias);
		
		infos = new ArrayList<Pair>();
		infos.add(new Pair("info3", "info3val"));
		infos.add(new Pair("info4", "info4val"));
		build.setInfos(infos);
		
		reports = new ArrayList<Pair>();
		reports.add(new Pair("reports3", "reports3val"));
		reports.add(new Pair("reports4", "reports4val"));
		build.setReports(reports);
		
		steps = new ArrayList<Step>();
		steps.add(new Step("step3", new Date(), new Date(System.currentTimeMillis()+1000)));
		steps.add(new Step("step4", new Date(System.currentTimeMillis()+1000), new Date(System.currentTimeMillis()+2000)));
		build.setSteps(steps);
		
		commits = new ArrayList<Commit>();
		commits.add(new Commit(null, null, "3", "30", "300", new Date()));
		commits.add(new Commit(null, null, "4", "40", "400", new Date(System.currentTimeMillis()+1000)));
		build.setCommits(commits);
		
		ConnectorHelper.updateBuild(build);
		
		//Create Report 2
		String report2Id = "4_2_"+System.currentTimeMillis();
		ReportEntry report2 = new ReportEntry();
		report2.setBuildName(buildName);
		report2.setBuildId(buildId);
		report2.setName("report2");
		report2.setId(report2Id);
		report2.setDescription("report desc 2");
		report2.setStartDate(new Date());
		report2.setEndDate(new Date(System.currentTimeMillis() +10000));
		report2.setStatus("pending");
		
		logs = new ArrayList<String>();
		logs.add("logs 10");
		logs.add("logs 20");
		report2.setLogs(logs);
		
		ConnectorHelper.createReport(report2);
		
		//Update Report 1
		report.setDescription("report desc 1");
		report.setStartDate(new Date());
		report.setEndDate(new Date(System.currentTimeMillis() +10000));
		report.setStatus("pending");
		
		logs = new ArrayList<String>();
		logs.add("logs 3");
		logs.add("logs 4");
		report.setLogs(logs);
		
		ConnectorHelper.updateReport(report);
		
		ConnectorHelper.runAnalysis(build.getId(), null, false);
	}
	
	@Test
	public void createBuildReportsAndTests() throws IOException {
		//Create build
		String buildId = "5_"+System.currentTimeMillis();
		String buildName = "build "+System.currentTimeMillis();
		BuildEntry build = new BuildEntry();
		build.setName(buildName);
		build.setId(buildId);
		
		ConnectorHelper.createBuild(build);
		
		//Create report 1
		ReportEntry report = new ReportEntry();
		String reportId = "5_1_"+System.currentTimeMillis();
		report.setBuildId(buildId);
		report.setBuildName(buildName);
		report.setName("report1");
		report.setId(reportId);
		
		ConnectorHelper.createReport(report);
		
		//Create test
		TestEntry test = new TestEntry();
		test.setReportName("report1");
		test.setReportId(reportId);
		test.setName("test1");
		test.setDescription("desc test1");
		
		ConnectorHelper.createTest(test);
		
		//Create test
		TestEntry test2 = new TestEntry();
		test2.setReportName("report1");
		test2.setReportId(reportId);
		test2.setName("test2");
		test2.setDescription("desc test2");
		
		ConnectorHelper.createTest(test2);
		
		//Create update
		build.setDescription("desc");
		
		ConnectorHelper.updateBuild(build);
		
		//Create report 2
		ReportEntry report2 = new ReportEntry();
		String report2Id = "5_2_"+System.currentTimeMillis();
		report2.setBuildName(buildName);
		report2.setBuildId(buildId);
		report2.setName("report2");
		report2.setId(report2Id);
		
		ConnectorHelper.createReport(report2);
		
		//Update report 1
		report.setStatus("test");
		
		ConnectorHelper.updateReport(report);
		
		//Create test
		TestEntry test3 = new TestEntry();
		test3.setReportName("report2");
		test3.setReportId(report2Id);
		test3.setName("test3");
		test3.setDescription("desc test3");
		
		ConnectorHelper.createTest(test3);
		
		//Update Test 2
		test2.setLog("test");
		
		ConnectorHelper.updateTest(test2);
		
		ConnectorHelper.runAnalysis(build.getId(), null, false);
	}
	
	@Test
	public void createBuildReportsAndTests2() throws IOException {
		//Create build
		String buildName = "build "+System.currentTimeMillis();
		String buildId = "6_"+System.currentTimeMillis();
		BuildEntry build = new BuildEntry();
		build.setName(buildName);
		build.setId(buildId);
		build.setDescription("desc");
		build.setStartDate(new Date());
		build.setEndDate(new Date(System.currentTimeMillis()+10000));
		build.setStatus("completed");
		
		List<Pair> criterias = new ArrayList<Pair>();
		criterias.add(new Pair("criterias1", "criterias1val"));
		criterias.add(new Pair("criterias2", "criterias2val"));
		build.setCriterias(criterias);
		
		List<Pair> infos = new ArrayList<Pair>();
		infos.add(new Pair("info1", "info1val"));
		infos.add(new Pair("info2", "info2val"));
		build.setInfos(infos);
		
		List<Pair> reports = new ArrayList<Pair>();
		reports.add(new Pair("reports1", "reports1val"));
		reports.add(new Pair("reports2", "reports2val"));
		build.setReports(reports);
		
		List<Step> steps = new ArrayList<Step>();
		steps.add(new Step("step1", new Date(), new Date(System.currentTimeMillis()+1000)));
		steps.add(new Step("step2", new Date(System.currentTimeMillis()+1000), new Date(System.currentTimeMillis()+2000)));
		build.setSteps(steps);
		
		List<Commit> commits = new ArrayList<Commit>();
		commits.add(new Commit(null, null, "1", "10", "100", new Date()));
		commits.add(new Commit(null, null, "2", "20", "200", new Date(System.currentTimeMillis()+1000)));
		build.setCommits(commits);
		
		ConnectorHelper.createBuild(build);
		
		//Create report 1
		ReportEntry report = new ReportEntry();
		String reportId = "6_1_"+System.currentTimeMillis();
		report.setBuildName(buildName);
		report.setBuildId(buildId);
		report.setName("report1");
		report.setId(reportId);
		report.setDescription("report desc");
		report.setStartDate(new Date());
		report.setEndDate(new Date(System.currentTimeMillis() +10000));
		report.setStatus("pending");
		
		List<String> logs = new ArrayList<String>();
		logs.add("logs 1");
		logs.add("logs 2");
		report.setLogs(logs);
		
		ConnectorHelper.createReport(report);
		
		//Create test
		TestEntry test = new TestEntry();
		test.setReportId(reportId);
		test.setReportName("report1");
		test.setName("test1");
		test.setDescription("desc test1");
		test.setLog("log1");
		test.setStartDate(new Date());
		test.setEndDate(new Date(System.currentTimeMillis()+1000));
		test.setStatus("test1");
		List<Pair> testCriterias = new ArrayList<Pair>();
		testCriterias.add(new Pair("crit1", "val1"));
		testCriterias.add(new Pair("crit2", "val2"));
		test.setCriterias(testCriterias);
		List<String> tags = new ArrayList<String>();
		tags.add("tag 1");
		tags.add("tag 2");
		test.setTags(tags);
		List<Step> testSteps = new ArrayList<Step>();
		testSteps.add(new Step(1, "step 1", new Date(), new Date(), "1", "2", "2", "success", null));
		testSteps.add(new Step(2, "step 2", new Date(), new Date(), "0", "1", "2", "failed", "reason"));
		test.setSteps(testSteps);
		
		ConnectorHelper.createTest(test);
		
		//Create test
		TestEntry test2 = new TestEntry();
		test2.setReportId(reportId);
		test2.setReportName("report1");
		test2.setName("test2");
		test2.setDescription("desc test2");
		test2.setLog("log2");
		test2.setStartDate(new Date());
		test2.setEndDate(new Date(System.currentTimeMillis()+1000));
		test2.setStatus("test2");
		testCriterias = new ArrayList<Pair>();
		testCriterias.add(new Pair("crit10", "val10"));
		testCriterias.add(new Pair("crit20", "val20"));
		test2.setCriterias(testCriterias);
		tags = new ArrayList<String>();
		tags.add("tag 10");
		tags.add("tag 20");
		test2.setTags(tags);
		testSteps = new ArrayList<Step>();
		testSteps.add(new Step(1, "step 1", new Date(), new Date(), "1", "2", "2", "success", null));
		testSteps.add(new Step(2, "step 2", new Date(), new Date(), "0", "1", "2", "failed", "reason"));
		test2.setSteps(testSteps);
		
		ConnectorHelper.createTest(test2);
		
		//update build
		build.setDescription("desc 2");
		build.setStartDate(new Date());
		build.setEndDate(new Date(System.currentTimeMillis()+10000));
		build.setStatus("completed 2");
		
		criterias = new ArrayList<Pair>();
		criterias.add(new Pair("criterias3", "criterias3val"));
		criterias.add(new Pair("criterias4", "criterias4val"));
		build.setCriterias(criterias);
		
		infos = new ArrayList<Pair>();
		infos.add(new Pair("info3", "info3val"));
		infos.add(new Pair("info4", "info4val"));
		build.setInfos(infos);
		
		reports = new ArrayList<Pair>();
		reports.add(new Pair("reports3", "reports3val"));
		reports.add(new Pair("reports4", "reports4val"));
		build.setReports(reports);
		
		steps = new ArrayList<Step>();
		steps.add(new Step("step3", new Date(), new Date(System.currentTimeMillis()+1000)));
		steps.add(new Step("step4", new Date(System.currentTimeMillis()+1000), new Date(System.currentTimeMillis()+2000)));
		build.setSteps(steps);
		
		commits = new ArrayList<Commit>();
		commits.add(new Commit(null, null, "3", "30", "300", new Date()));
		commits.add(new Commit(null, null, "4", "40", "400", new Date(System.currentTimeMillis()+1000)));
		build.setCommits(commits);
		
		ConnectorHelper.updateBuild(build);
		
		//Create report 2
		ReportEntry report2 = new ReportEntry();
		String report2Id = "6_2_"+System.currentTimeMillis();
		report2.setBuildName(buildName);
		report2.setBuildId(buildId);
		report2.setName("report2");
		report2.setId(report2Id);
		report2.setDescription("report desc 2");
		report2.setStartDate(new Date());
		report2.setEndDate(new Date(System.currentTimeMillis() +10000));
		report2.setStatus("pending");
		
		logs = new ArrayList<String>();
		logs.add("logs 10");
		logs.add("logs 20");
		report2.setLogs(logs);
		
		ConnectorHelper.createReport(report2);
		
		//Update report 1
		report.setDescription("report desc 1");
		report.setStartDate(new Date());
		report.setEndDate(new Date(System.currentTimeMillis() +10000));
		report.setStatus("pending");
		
		logs = new ArrayList<String>();
		logs.add("logs 3");
		logs.add("logs 4");
		report.setLogs(logs);
		
		ConnectorHelper.updateReport(report);
		
		//Create test
		TestEntry test3 = new TestEntry();
		test3.setReportId(report2Id);
		test3.setReportName("report2");
		test3.setName("test3");
		test3.setDescription("desc test3");
		test3.setLog("log3");
		test3.setStartDate(new Date());
		test3.setEndDate(new Date(System.currentTimeMillis()+1000));
		test3.setStatus("test3");
		testCriterias = new ArrayList<Pair>();
		testCriterias.add(new Pair("crit100", "val100"));
		testCriterias.add(new Pair("crit200", "val200"));
		test3.setCriterias(testCriterias);
		test2.setCriterias(testCriterias);
		tags = new ArrayList<String>();
		tags.add("tag 100");
		tags.add("tag 200");
		test3.setTags(tags);
		testSteps = new ArrayList<Step>();
		testSteps.add(new Step(1, "step 100", new Date(), new Date(), "100", "200", "200", "success", null));
		testSteps.add(new Step(2, "step 200", new Date(), new Date(), "000", "100", "200", "failed", "reason"));
		test3.setSteps(testSteps);
		
		ConnectorHelper.createTest(test3);
		
		//Update Test 2
		test2.setLog("test2");
		test2.setStartDate(new Date());
		test2.setEndDate(new Date(System.currentTimeMillis()+2000));
		test2.setStatus("test2");
		testCriterias = new ArrayList<Pair>();
		testCriterias.add(new Pair("crit30", "val30"));
		testCriterias.add(new Pair("crit40", "val40"));
		test2.setCriterias(testCriterias);
		tags = new ArrayList<String>();
		tags.add("tag 3");
		tags.add("tag 4");
		test2.setTags(tags);
		testSteps = new ArrayList<Step>();
		testSteps.add(new Step(3, "step 30", new Date(), new Date(), "2", "3", "3", "success", null));
		testSteps.add(new Step(4, "step 40", new Date(), new Date(), "2", "3", "4", "failed", "reason"));
		test2.setSteps(testSteps);
		
		ConnectorHelper.updateTest(test2);
		
		ConnectorHelper.runAnalysis(build.getId(), null, false);
	}
	
	@Test
	public void completeRealScenario() throws IOException {
		//Create build
		String buildName = "test build end to end"/*+System.currentTimeMillis()*/;
		String buildId = "7 "+System.currentTimeMillis();
		BuildEntry build = new BuildEntry();
		build.setName(buildName);
		build.setId(buildId);
		build.setDescription("desc");
		build.setStartDate(new Date());
		
		List<Pair> criterias = new ArrayList<Pair>();
		criterias.add(new Pair("Type", "Simple Build"));
		criterias.add(new Pair("OS", "Linux"));
		build.setCriterias(criterias);
		
		List<Pair> infos = new ArrayList<Pair>();
		infos.add(new Pair("OS Version", "CentOS"));
		infos.add(new Pair("Project", "Company Project"));
		build.setInfos(infos);
		
		List<Pair> reports = new ArrayList<Pair>();
		reports.add(new Pair("Javadoc", "<a href=\"#\">javadoc</a>"));
		reports.add(new Pair("Code Coverage", "<a href=\"#\">Emma</a>"));
		build.setReports(reports);
		
		List<Step> steps = new ArrayList<Step>();
		steps.add(new Step("Clone Git", new Date(), new Date()));
		steps.add(new Step("Package", new Date(), new Date()));
		build.setSteps(steps);
		
		List<Commit> commits = new ArrayList<Commit>();
		commits.add(new Commit(null, null, "1234jgf1234jgf1234655", null, "employee1@company.com", new Date(System.currentTimeMillis())));
		commits.add(new Commit(null, null, "3465345hgfjhfgjhg3465", null, "employee1@company.com", new Date(System.currentTimeMillis())));
		build.setCommits(commits);
		
		ConnectorHelper.createBuild(build);
		
		//Create report 1
		ReportEntry report = new ReportEntry();
		String report1Id = "7 1 "+System.currentTimeMillis();
		report.setBuildName(buildName);
		report.setBuildId(buildId);
		report.setName("Test Suite Group One");
		report.setId(report1Id);
		report.setDescription("Test suite associated to module one");
		Date report1StartDate = new Date();
		report.setStartDate(report1StartDate);
		
		ConnectorHelper.createReport(report);
		
		//Create 10000 tests for report 1
		for(int i = 0; i < 100; i++){
			TestEntry test = new TestEntry();
			test.setReportId(report1Id);
			test.setReportName("Test Suite Group One");
			test.setName("package#test"+i+".java");
			test.setDescription("desc package#test"+i+".java");
			test.setStartDate(new Date());
			if(i<10){
				test.setLog("Failed because of some exception");
				test.setStatus("fail");
				test.setEndDate(new Date());
			}else if(i < 15){
				test.setLog("Error because test has some issue");
				test.setStatus("error");
				test.setEndDate(new Date());
			}else if(i < 22){
				test.setLog("Test took too ong to execute");
				test.setStatus("blacklisted");
				test.setEndDate(new Date(System.currentTimeMillis()+420000));
			}else{
				test.setLog("Success");
				test.setStatus("pass");
				test.setEndDate(new Date());
			}
			List<Pair> testCriterias = new ArrayList<Pair>();
			if(i < 50){
				testCriterias.add(new Pair("Test Suite", "Test suite 1"));
			}else{
				testCriterias.add(new Pair("Test Suite", "Test suite 2"));
			}
			if(i < 10){
				testCriterias.add(new Pair("Author", "employee1@company.com"));
			}else if(i < 20){
				testCriterias.add(new Pair("Author", "employee2@company.com"));
			}else if(i < 30){
				testCriterias.add(new Pair("Author", "employee3@company.com"));
			}else if(i < 40){
				testCriterias.add(new Pair("Author", "employee4@company.com"));
			}else if(i < 50){
				testCriterias.add(new Pair("Author", "employee5@company.com"));
			}else if(i < 60){
				testCriterias.add(new Pair("Author", "employee6@company.com"));
			}else if(i < 70){
				testCriterias.add(new Pair("Author", "employee7@company.com"));
			}else if(i < 80){
				testCriterias.add(new Pair("Author", "employee8@company.com"));
			}else if(i < 90){
				testCriterias.add(new Pair("Author", "employee9@company.com"));
			}else if(i < 100){
				testCriterias.add(new Pair("Author", "employee10@company.com"));
			}
			test.setCriterias(testCriterias);
			
			List<String> testTags = new ArrayList<String>();
			if(i < 50){
				testTags.add("under 50");
			}else{
				testTags.add("over 50");
			}
			if(i < 25){
				testTags.add("under 25");
			}else{
				testTags.add("over 25");
			}
			test.setTags(testTags);
			
			List<Step> testSteps = new ArrayList<Step>();
			testSteps.add(new Step(1, "step 1 test"+i, new Date(), new Date(), ""+i, ""+i+1, ""+i+1, "success", null));
			testSteps.add(new Step(2, "step 2 test"+i, new Date(), new Date(), ""+i, ""+i+1, ""+i+2, "failed", "reason"));
			test.setSteps(testSteps);
			
			ConnectorHelper.createTest(test);
		}
		
		//Update report 1
		report = new ReportEntry();
		report.setId(report1Id);
		
		Date report1EndDate = new Date();
		report.setEndDate(report1EndDate);
		report.setStatus("completed");
		
		List<String> logs = new ArrayList<String>();
		logs.add("<a href=\"#\">file1.log</a>");
		logs.add("<a href=\"#\">file2.log</a>");
		report.setLogs(logs);
		
		ConnectorHelper.updateReport(report);
		
		//update build	
		build = new BuildEntry();
		build.setId(buildId);
		
		reports = new ArrayList<Pair>();
		reports.add(new Pair("Report1 logs", "<a href=\"#\">report1.log</a>"));
		build.setReports(reports);
		
		steps = new ArrayList<Step>();
		steps.add(new Step("Test Suite Grp 1", report1StartDate, report1EndDate));
		build.setSteps(steps);
		
		ConnectorHelper.updateBuild(build);
		
		//Create report 2
		ReportEntry report2 = new ReportEntry();
		String report2Id = "7 1 "+System.currentTimeMillis();
		report2.setBuildName(buildName);
		report2.setBuildId(buildId);
		report2.setName("Test Suite Group Two");
		report2.setId(report2Id);
		report2.setDescription("Test suite associated to module two");
		Date report2StartDate = new Date();
		report2.setStartDate(report2StartDate);
		
		ConnectorHelper.createReport(report2);
		
		//Create and update 10000 tests for report 2
		for(int i = 0; i < 100; i++){
			TestEntry test = new TestEntry();
			test.setReportId(report2Id);
			test.setReportName("Test Suite Group Two");
			test.setName("package#test"+i+".java");
			test.setDescription("desc package#test"+i+".java");
			test.setStartDate(new Date());
			List<Pair> testCriterias = new ArrayList<Pair>();
			testCriterias.add(new Pair("Author", "employee@company.com"));
			test.setCriterias(testCriterias);
			List<String> testTags = new ArrayList<String>();
			testTags.add("regression");
			test.setTags(testTags);
			List<Step> testSteps = new ArrayList<Step>();
			testSteps.add(new Step(1, "step 1", new Date(), new Date(), "1", "2", "2", "success", null));
			test.setSteps(testSteps);
			
			ConnectorHelper.createTest(test);
			
			//Update test
			test = new TestEntry();
			test.setReportId(report2Id);
			test.setReportName("Test Suite Group Two");
			test.setName("package#test"+i+".java");
			test.setDescription("desc package#test"+i+".java");
			test.setLog("Success");
			test.setStatus("pass");
			test.setEndDate(new Date());
			testSteps = new ArrayList<Step>();
			testSteps.add(new Step(1, "step 1", new Date(), new Date(), "1", "qwe", "rty", "success", "Null pointer"));
			test.setSteps(testSteps);
			
			ConnectorHelper.updateTest(test);
		}
		
		//Update report 2
		report2 = new ReportEntry();
		report2.setId(report2Id);
		
		Date report2EndDate = new Date();
		report2.setEndDate(report2EndDate);
		report2.setStatus("completed");
		
		logs = new ArrayList<String>();
		logs.add("<a href=\"#\">file3.log</a>");
		logs.add("<a href=\"#\">file4.log</a>");
		report2.setLogs(logs);
		
		ConnectorHelper.updateReport(report2);
				
		//update build	
		build = new BuildEntry();
		build.setId(buildId);
		build.setEndDate(new Date());
		build.setStatus("completed");
		reports = new ArrayList<Pair>();
		reports.add(new Pair("Report2 logs", "<a href=\"#\">report2.log</a>"));
		build.setReports(reports);
		
		steps = new ArrayList<Step>();
		steps.add(new Step("Test Suite Grp 2", report2StartDate, report2EndDate));
		build.setSteps(steps);
		ConnectorHelper.updateBuild(build);
		
		build = new BuildEntry();
		build.setId(buildId);
		ConnectorHelper.runAnalysis(build.getId(), null, false);
	}
	
	@Test
	public void partialBuild() throws IOException {
		//Create build
		String buildName = "partial build test";
		String buildId = "8_"+System.currentTimeMillis();
		BuildEntry build = new BuildEntry();
		build.setName(buildName);
		build.setId(buildId);
		build.setStartDate(new Date());
		ConnectorHelper.createBuild(build);
		
		//Create report 1
		ReportEntry report = new ReportEntry();
		String report1Id = "8_1_"+System.currentTimeMillis();
		report.setBuildName(buildName);
		report.setBuildId(buildId);
		report.setName("Test Suite Group One");
		report.setId(report1Id);
		report.setDescription("Test suite associated to module one");
		Date report1StartDate = new Date();
		report.setStartDate(report1StartDate);
		ConnectorHelper.createReport(report);
		
		//create tests for report 1
		TestEntry test11 = new TestEntry();
		test11.setReportId(report1Id);
		test11.setReportName("Test Suite Group One");
		test11.setName("report 1 test 1");
		test11.setStartDate(new Date());
		test11.setStatus("pass");
		test11.setEndDate(new Date());
		ConnectorHelper.createTest(test11);
		
		TestEntry test12 = new TestEntry();
		test12.setReportId(report1Id);
		test12.setReportName("Test Suite Group One");
		test12.setName("report 1 test 2");
		test12.setStartDate(new Date());
		test12.setStatus("fail");
		test12.setLog("test logs here");
		test12.setEndDate(new Date());
		ConnectorHelper.createTest(test12);
		
		//Update report 1
		report = new ReportEntry();
		report.setId(report1Id);
		
		Date report1EndDate = new Date();
		report.setEndDate(report1EndDate);
		report.setStatus("completed");
		ConnectorHelper.updateReport(report);
		
		//Create report 2
		ReportEntry report2 = new ReportEntry();
		String report2Id = "8_1_"+System.currentTimeMillis();
		report2.setBuildName(buildName);
		report2.setBuildId(buildId);
		report2.setName("Test Suite Group Two");
		report2.setId(report2Id);
		Date report2StartDate = new Date();
		report2.setStartDate(report2StartDate);
		ConnectorHelper.createReport(report2);
		
		//Create tests for report 2
		TestEntry test21 = new TestEntry();
		test21.setReportId(report2Id);
		test21.setReportName("Test Suite Group Two");
		test21.setName("report 2 test 1");
		test21.setStartDate(new Date());
		test21.setStatus("pass");
		test21.setEndDate(new Date());
		ConnectorHelper.createTest(test21);
		
		//Update report 2
		report2 = new ReportEntry();
		report2.setId(report2Id);
		Date report2EndDate = new Date();
		report2.setEndDate(report2EndDate);
		report2.setStatus("completed");
		ConnectorHelper.updateReport(report2);
				
		//update build	
		build = new BuildEntry();
		build.setId(buildId);
		build.setEndDate(new Date());
		build.setStatus("completed");
		ConnectorHelper.updateBuild(build);
		
		build = new BuildEntry();
		build.setId(buildId);
		ConnectorHelper.runAnalysis(build.getId(), null, false);
		
		//Override a test
		test12 = new TestEntry();
		test12.setReportId(report1Id);
		test12.setReportName("Test Suite Group One");
		test12.setName("report 1 test 2");
		test12.setStartDate(new Date());
		test12.setStatus("pass");
		test12.setEndDate(new Date());
		test12.setOverride(true);
		ConnectorHelper.updateTest(test12);
		
		build = new BuildEntry();
		build.setId(buildId);
		ConnectorHelper.runAnalysis(build.getId(), null, true);
		
	}
	
	@Test
	public void testStepUpdate() throws IOException {
		//Create build
		String buildName = "build "+System.currentTimeMillis();
		String buildId = "8_"+System.currentTimeMillis();
		BuildEntry build = new BuildEntry();
		build.setName(buildName);
		build.setId(buildId);
		build.setStartDate(new Date());
		List<Step> steps = new ArrayList<Step>();
		steps.add(new Step("test", new Date(System.currentTimeMillis()), null));
		build.setSteps(steps);
		ConnectorHelper.createBuild(build);

		//update build	
		build = new BuildEntry();
		build.setId(buildId);
		build.setEndDate(new Date());
		build.setStatus("completed");
		steps = new ArrayList<Step>();
		steps.add(new Step("test", null, new Date(System.currentTimeMillis()+1000)));
		steps.add(new Step("test2", new Date(System.currentTimeMillis()+1000), null));
		build.setSteps(steps);
		ConnectorHelper.updateBuild(build);
		
		//update build	
		build = new BuildEntry();
		build.setId(buildId);
		build.setEndDate(new Date());
		build.setStatus("completed");
		steps = new ArrayList<Step>();
		steps.add(new Step("test2", null, new Date(System.currentTimeMillis()+2000)));
		build.setSteps(steps);
		ConnectorHelper.updateBuild(build);
		
		build = new BuildEntry();
		build.setId(buildId);
		ConnectorHelper.runAnalysis(build.getId(), null, false);
		
	}
	
	@Test
	public void createAutoAnalysis() throws IOException {
		//Create build
		String buildName = "build 9"+System.currentTimeMillis();
		BuildEntry build = new BuildEntry();
		build.setName(buildName);
		
		ConnectorHelper.createBuild(build);
		
		//Create report 1
		ReportEntry report = new ReportEntry();
		String reportName = "report 9_1_"+System.currentTimeMillis();
		report.setBuildName(buildName);
		report.setName(reportName);
		
		ConnectorHelper.createReport(report);
		
		//Create test
		TestEntry test = new TestEntry();
		test.setReportName(reportName);
		test.setName("test1");
		
		ConnectorHelper.createTest(test);
		
		//Create test
		TestEntry test2 = new TestEntry();
		test2.setReportName(reportName);
		test2.setName("test2");
		
		ConnectorHelper.createTest(test2);
		
		//Create update
		build.setDescription("desc");
		
		ConnectorHelper.updateBuild(build);
		
		//Create report 2
		ReportEntry report2 = new ReportEntry();
		String report2Name = "report9_2_"+System.currentTimeMillis();
		report2.setBuildName(buildName);
		report2.setName(report2Name);
		
		ConnectorHelper.createReport(report2);
		
		//Update report 1
		report.setStatus("test");
		
		ConnectorHelper.updateReport(report);
		
		//Create test
		TestEntry test3 = new TestEntry();
		test3.setReportName(report2Name);
		test3.setName("test3");
		
		ConnectorHelper.createTest(test3);
		
		//Update Test 2
		test2.setLog("test");
		
		ConnectorHelper.updateTest(test2);
		
//		//Recreate a empty build
//		BuildEntry build2 = new BuildEntry();
//		build2.setName(buildName);
//		
//		ConnectorHelper.createBuild(build2);
//		
//		//Recreate a second empty build
//		BuildEntry build3 = new BuildEntry();
//		build3.setName(buildName);
//		
//		ConnectorHelper.createBuild(build3);
		
		//Analyze
		//ConnectorHelper.runAnalysis(null, build3.getName(), false);
	}

}
