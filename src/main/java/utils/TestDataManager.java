package utils;

import com.thoughtworks.xstream.mapper.CannotResolveClassException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataManager {

	public static Object readDataFromXmlFile(String pathToXmlFile)
			throws FileNotFoundException, CannotResolveClassException {

		return new Serializer().fromXml(new FileInputStream(pathToXmlFile));

	}

	public static void writeDataToXmlfile(Object object, String pathToXmlFile)
			throws FileNotFoundException, IOException {

		new Serializer().toXml(new FileOutputStream(pathToXmlFile), object);

	}

	

}