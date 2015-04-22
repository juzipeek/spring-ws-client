package org.me.springws.test;

import java.io.StringReader;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;

public class AppStart
{
    // "<pay_wkjs xmlns=\"http://localhost:8088/yykWebservice\">"
    private static final String MESSAGE = "<interface>"
						+ "<kh>123567890123456</kh>"
						+ "<yxq>1212</yxq>"
						+ "<fhm>00</fhm>"
						+ "</interface>";

    /**
     * @param args
     */
    public static void main(String[] args)
    {
	ApplicationContext ac = new ClassPathXmlApplicationContext(
		"WebServiceClient.xml");
	WebServiceTemplate simpleService = (WebServiceTemplate) ac
		.getBean("webServiceTemplate");
	StreamSource source = new StreamSource(new StringReader(MESSAGE));
	StreamResult result = new StreamResult(System.out);
	simpleService
		.sendSourceAndReceiveToResult(
			"http://localhost:8088/yykWebservice?wsdl",
			source, result);
    }

}
