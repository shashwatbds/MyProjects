package com.designpatterns.structural.facade2;

import java.sql.Connection;

public interface ReportGenerator {

	public Connection getDBConnection();
	public void generatePDFReport(String tableName, Connection con);
	public void generateHTMLReport(String tableName, Connection con);
}
