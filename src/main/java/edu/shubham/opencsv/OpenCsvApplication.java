package edu.shubham.opencsv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpenCsvApplication {
	private static final String PATH_TO_SAMPLE_FILE = "test.csv";
	public static void main(final String[] args) throws IOException {
		System.out.println("Entering the console app");
		final InputStream is = OpenCsvApplication.class.getClassLoader().getResourceAsStream(PATH_TO_SAMPLE_FILE);
		final BufferedReader br = new BufferedReader(new InputStreamReader(is));
		System.out.println("Opened the file: "+br.ready());
		CsvToBean<SampleFileObject> csvToBean =  new CsvToBeanBuilder(br)
                    .withType(SampleFileObject.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<SampleFileObject> sampleFileObjectIterator = csvToBean.iterator();

            while (sampleFileObjectIterator.hasNext()) {
                SampleFileObject csvUser = sampleFileObjectIterator.next();
                System.out.println("Short Code : " + csvUser.getShortCode());
                System.out.println("First : " + csvUser.getFirst());
                System.out.println("==========================");
            }
		SpringApplication.run(OpenCsvApplication.class, args);
	}

}
