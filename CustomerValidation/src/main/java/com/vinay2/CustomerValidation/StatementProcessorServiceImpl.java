package com.vinay2.CustomerValidation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Component
public class StatementProcessorServiceImpl implements StatementProcessorService {
	List<Record> CsvList = null;

	public List<Record> getCsvReportDetails() throws Exception {

		// CSV with no headers
		CSVReader csvreader = null;

		csvreader = new CSVReader(new FileReader("input.csv"), ',', '"', 1);
		CsvToBean<Record> bean = new CsvToBean<Record>();

		// Define strategy
		ColumnPositionMappingStrategy<Record> strategy = new ColumnPositionMappingStrategy<Record>();
		strategy.setType(Record.class);
		strategy.setColumnMapping(
				new String[] { "reference", "accountNumber", "description", "startBalance", "mutation", "endBalance" });

		CsvList = (ArrayList) bean.parse(strategy, csvreader);

		return CsvList;

	}

	public List<Record> getFailedTransactionDetails() throws Exception {
		List<Record> CsvList = null;

		CSVReader csvreader = null;

		csvreader = new CSVReader(new FileReader("input.csv"), ',', '"', 1);
		CsvToBean<Record> bean = new CsvToBean<Record>();

		// Define strategy
		ColumnPositionMappingStrategy<Record> strategy = new ColumnPositionMappingStrategy<Record>();
		strategy.setType(Record.class);
		strategy.setColumnMapping(
				new String[] { "reference", "accountNumber", "description", "startBalance", "mutation", "endBalance" });

		CsvList = (ArrayList) bean.parse(strategy, csvreader);

		Set<Long> nameSet = new HashSet<>();
		List<Record> failureTransaction = CsvList.stream().filter(e -> !nameSet.add(e.getReference()))
				.collect(Collectors.toList());

		/*
		 * List<Record> failureTransaction=CsvList.stream() .filter(x ->
		 * x.getEndBalance() != (Double .parseDouble(new
		 * DecimalFormat("##.##").format((x.getStartBalance() + x.getMutation())))))
		 * .collect(Collectors.toList());
		 * 
		 * 
		 * 
		 * }
		 */

		return failureTransaction;

	}

}
