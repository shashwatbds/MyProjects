package com.designpatterns.structural.facade2;

import java.sql.Connection;

public class OracleReportGenerator implements ReportGenerator {

	@Override
	public Connection getDBConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generatePDFReport(String tableName, Connection con) {
		// TODO Auto-generated method stub

	}

	@Override
	public void generateHTMLReport(String tableName, Connection con) {
		// TODO Auto-generated method stub

	}

}
