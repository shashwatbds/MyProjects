package com.designpatterns.structural.facade2;

import java.sql.Connection;
import java.util.Objects;

public class ReportGeneratorFacade {

	public static void generateReport(DBType dbType, ReportType reportType, String tableName) {
		if(Objects.nonNull(dbType) && Objects.nonNull(reportType) && Objects.nonNull(tableName)) {
			switch(dbType) {
			case MYSQL:
				ReportGenerator msqlGenerator = new MySQLReportGenerator();
				Connection msqlConnection = msqlGenerator.getDBConnection();
				switch(reportType) {
				case PDF:
					msqlGenerator.generatePDFReport("Table 2", msqlConnection);
				case HTML:
					msqlGenerator.generateHTMLReport("Table 1", msqlConnection);
				}
			case ORACLE:
				ReportGenerator oGenerator = new OracleReportGenerator();
				Connection oracleConnection = oGenerator.getDBConnection();
				switch(reportType) {
				case PDF:
					oGenerator.generatePDFReport("Table 2", oracleConnection);
				case HTML:
					oGenerator.generateHTMLReport("Table 1", oracleConnection);
				}
			}
		}
	}


	public static enum ReportType {
		PDF, HTML;
	}

	public static enum DBType {
		MYSQL, ORACLE;
	}
}
