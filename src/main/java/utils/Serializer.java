package utils;

import com.thoughtworks.xstream.XStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Serializer {

	public Object fromXml(InputStream in) {

		return (Object) new XStream().fromXML(in);
	}

	public void toXml(OutputStream outstream, Object obj) throws IOException {

		new XStream().toXML(obj, outstream);

	}

}
